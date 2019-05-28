package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.ETC1Util.ETC1Texture;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.m.b;
import com.tencent.filter.m.d;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.filter.m.j;
import com.tencent.filter.m.n;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.TRIGGERED_STATUS;
import com.tencent.ttpic.model.TriggerCtrlItem;
import com.tencent.ttpic.recorder.ActVideoDecoder;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.MatrixUtil;
import com.tencent.ttpic.util.PlayerUtil;
import com.tencent.ttpic.util.PlayerUtil.Player;
import com.tencent.ttpic.util.VideoFilterFactory.STICKER_TYPE;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.ITEM_SOURCE_TYPE;
import com.tencent.ttpic.util.VideoPrefsUtil;
import java.io.File;
import java.util.List;

public abstract class NormalVideoFilter extends VideoFilterBase {
    private static final String TAG = NormalVideoFilter.class.getSimpleName();
    protected boolean isImageReady;
    protected StickerItem item;
    private int lastImageIndex = -1;
    private boolean mAudioPause;
    private boolean mHasBodyDetected = false;
    private boolean mHasSeenValid = false;
    private Player mPlayer;
    public List<PointF> mPreviousBodyPoints = null;
    private long mPreviousLostTime = System.currentTimeMillis();
    private long mTimesForLostProtect = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
    protected ActVideoDecoder mVideoDecoder;
    private int[] tex = new int[2];
    protected TriggerCtrlItem triggerCtrlItem;
    protected boolean triggered = false;

    public abstract void updatePositions(List<PointF> list, float[] fArr, float f);

    public NormalVideoFilter(StickerItem stickerItem, String str) {
        super(PROGRAM_TYPE.STICKER_NORMAL);
        this.item = stickerItem;
        this.dataPath = str;
        this.triggerCtrlItem = new TriggerCtrlItem(stickerItem);
        initParams();
        initAudio();
    }

    public void initParams() {
        addParam(new i("blendMode", this.item.blendMode));
        addParam(new n("inputImageTexture2", 0, 33986));
        addParam(new n("inputImageTexture3", 0, 33987));
        addParam(new i("texNeedTransform", 1));
        addParam(new b("canvasSize", 0.0f, 0.0f));
        addParam(new b("texAnchor", 0.0f, 0.0f));
        addParam(new f("texScale", 1.0f));
        addParam(new d("texRotate", 0.0f, 0.0f, 0.0f));
        addParam(new j("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0f, 4.0f, 10.0f)));
    }

    public void updatePreview(PTDetectInfo pTDetectInfo) {
        if (VideoMaterialUtil.isBodyDetectItem(this.item)) {
            avoidBodyPointsShake(pTDetectInfo);
        }
        updatePlayer(updateActionTriggered(pTDetectInfo) == TRIGGERED_STATUS.FIRST_TRIGGERED);
        int frameIndex = this.triggerCtrlItem.getFrameIndex();
        if (needRenderTexture()) {
            if (VideoMaterialUtil.isGestureItem(this.item)) {
                updatePositions(pTDetectInfo.handPoints, pTDetectInfo.faceAngles, pTDetectInfo.phoneAngle);
            } else if (VideoMaterialUtil.isBodyDetectItem(this.item)) {
                updatePositions(pTDetectInfo.bodyPoints);
                if (!this.mHasBodyDetected) {
                    pTDetectInfo.bodyPoints = null;
                }
            } else {
                updatePositions(pTDetectInfo.facePoints, pTDetectInfo.faceAngles, pTDetectInfo.phoneAngle);
            }
            updateTextureParam(frameIndex, pTDetectInfo.timestamp);
            return;
        }
        clearTextureParam();
        VideoMemoryManager.getInstance().reset(this.item.id);
        updateTextureParam(0, pTDetectInfo.timestamp);
    }

    public void updateVideoSize(int i, int i2, double d) {
        super.updateVideoSize(i, i2, d);
        addParam(new b("canvasSize", (float) i, (float) i2));
    }

    public void updateTextureParam(long j) {
        this.triggerCtrlItem.updateFrameIndex(j);
        int frameIndex = this.triggerCtrlItem.getFrameIndex();
        synchronized (this) {
            updateTextureParam(frameIndex, j);
        }
    }

    public void updateTextureParam(int i) {
        if (!needLoadImage()) {
            addParam(new n("inputImageTexture2", i, 33986));
            this.isImageReady = true;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public boolean needLoadImage() {
        return this.item.stickerType != STICKER_TYPE.FACE_FEATURE.type;
    }

    /* Access modifiers changed, original: protected */
    public TRIGGERED_STATUS updateActionTriggered(PTDetectInfo pTDetectInfo) {
        return this.triggerCtrlItem.getTriggeredStatus(pTDetectInfo);
    }

    /* Access modifiers changed, original: protected */
    public void updatePlayer(boolean z) {
        this.triggered = this.triggerCtrlItem.isTriggered();
        if (!this.triggered) {
            destroyAudio();
        } else if (VideoPrefsUtil.getMaterialMute() || this.mAudioPause) {
            PlayerUtil.stopPlayer(this.mPlayer);
        } else {
            initAudio();
            if (this.item.audioLoopCount <= 0) {
                PlayerUtil.startPlayer(this.mPlayer, z);
            } else if (z) {
                PlayerUtil.startPlayer(this.mPlayer, true);
            }
        }
    }

    private void initAudio() {
        if (this.mPlayer == null && this.item != null && !TextUtils.isEmpty(this.dataPath) && !TextUtils.isEmpty(this.item.id) && !TextUtils.isEmpty(this.item.audio)) {
            String str = this.dataPath + File.separator + this.item.id + File.separator + this.item.audio;
            if (str.startsWith("assets://")) {
                this.mPlayer = PlayerUtil.createPlayerFromAssets(VideoGlobalContext.getContext(), str.replace("assets://", ""), false);
            } else {
                this.mPlayer = PlayerUtil.createPlayerFromUri(VideoGlobalContext.getContext(), str, false);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void updateTextureParam(int i, long j) {
        if (needLoadImage() && i != this.lastImageIndex) {
            if (this.lastImageIndex > i && this.mVideoDecoder != null) {
                this.mVideoDecoder.reset();
            }
            if (this.item.stickerType == STICKER_TYPE.ETC.type) {
                ETC1Texture loadETCRGBTexture = VideoMemoryManager.getInstance().loadETCRGBTexture(this.item.id, i);
                ETC1Texture loadETCAlphaTexture = VideoMemoryManager.getInstance().loadETCAlphaTexture(this.item.id, i);
                if (loadETCRGBTexture != null && loadETCAlphaTexture != null) {
                    BenchUtil.benchStart("mPkmReader loadTexture");
                    GlUtil.loadTexture(this.tex[0], loadETCRGBTexture);
                    GlUtil.loadTexture(this.tex[1], loadETCAlphaTexture);
                    BenchUtil.benchEnd("mPkmReader loadTexture");
                    addParam(new n("inputImageTexture2", this.tex[0], 33986));
                    addParam(new n("inputImageTexture3", this.tex[1], 33987));
                    this.isImageReady = true;
                    this.lastImageIndex = i;
                    return;
                }
                return;
            }
            addParam(new n("inputImageTexture2", getNextFrame(i), 33986));
        }
    }

    private int getNextFrame(int i) {
        if (VideoMaterialUtil.isEmptyItem(this.item)) {
            return this.tex[0];
        }
        if (this.item.sourceType != ITEM_SOURCE_TYPE.IMAGE && this.mVideoDecoder != null) {
            this.mVideoDecoder.decodeFrame((long) i);
            if (this.mVideoDecoder.updateFrame()) {
                this.isImageReady = true;
            }
            this.lastImageIndex = i;
        } else if (this.tex[0] != 0) {
            boolean z;
            Bitmap loadImage = VideoMemoryManager.getInstance().loadImage(this.item.id, i);
            if (loadImage != null || (this.isImageReady && !this.triggerCtrlItem.isRenderForBitmap())) {
                z = false;
            } else {
                loadImage = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id + "_" + i + ".png", MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
                z = true;
            }
            if (BitmapUtils.isLegal(loadImage)) {
                BenchUtil.benchStart("normal loadTexture");
                GlUtil.loadTexture(this.tex[0], loadImage);
                BenchUtil.benchEnd("normal loadTexture");
                if (z) {
                    loadImage.recycle();
                }
                this.isImageReady = true;
                this.lastImageIndex = i;
            }
        }
        return this.tex[0];
    }

    /* Access modifiers changed, original: protected */
    public int getTextureId() {
        return this.tex[0];
    }

    public void setRenderForBitmap(boolean z) {
        this.triggerCtrlItem.setRenderForBitmap(z);
    }

    public boolean needRenderTexture() {
        return this.triggered;
    }

    /* Access modifiers changed, original: protected */
    public void clearTextureParam() {
        setPositions(GlUtil.EMPTY_POSITIONS);
    }

    /* Access modifiers changed, original: protected */
    public void updatePositions(List<PointF> list) {
    }

    public void destroy() {
        clearGLSLSelf();
        destroyAudio();
    }

    public void destroyAudio() {
        PlayerUtil.destroyPlayer(this.mPlayer);
        this.mPlayer = null;
    }

    public float getFrameDuration(long j) {
        if (this.triggered) {
            return (float) (((double) (j - this.triggerCtrlItem.getFrameStartTime())) / 1000.0d);
        }
        return 0.0f;
    }

    public boolean needCopyTex() {
        if (this.item != null && this.item.blendMode >= 2 && this.item.blendMode <= 12) {
            return true;
        }
        return false;
    }

    private boolean isFullScreenRender(AttributeParam attributeParam) {
        if (attributeParam == null) {
            return false;
        }
        for (float f : attributeParam.vertices) {
            if (Float.compare(-1.0f, f) != 0 && Float.compare(1.0f, f) != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isRenderReady() {
        return this.triggered && this.isImageReady;
    }

    public int getLastFrameIndex() {
        return this.lastImageIndex;
    }

    public boolean canUseBlendMode() {
        return this.item.blendMode < 2 || this.item.blendMode > 12;
    }

    public void ApplyGLSLFilter() {
        super.ApplyGLSLFilter();
        GlUtil.createEtcTexture(this.tex);
        if (this.item.sourceType != ITEM_SOURCE_TYPE.IMAGE) {
            this.mVideoDecoder = new ActVideoDecoder(this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id + VideoMaterialUtil.MP4_SUFFIX, this.tex[0]);
        }
    }

    public void clearGLSLSelf() {
        int i = 0;
        super.clearGLSLSelf();
        GLES20.glDeleteTextures(this.tex.length, this.tex, 0);
        synchronized (this) {
            while (i < this.tex.length) {
                this.tex[i] = 0;
                i++;
            }
            if (this.mVideoDecoder != null) {
                this.mVideoDecoder.release();
                this.mVideoDecoder = null;
            }
        }
    }

    public StickerItem getStickerItem() {
        return this.item;
    }

    public void updateRandomGroupValue(int i) {
        this.triggerCtrlItem.setRandomGroupValue(i);
    }

    public void reset() {
        this.mHasBodyDetected = false;
        this.mHasSeenValid = false;
        this.mPreviousBodyPoints = null;
        this.triggerCtrlItem.reset();
    }

    public void setTriggerWords(String str) {
        TriggerCtrlItem triggerCtrlItem = this.triggerCtrlItem;
        if (!(this.item == null || TextUtils.isEmpty(this.item.triggerWords))) {
            str = this.item.triggerWords;
        }
        triggerCtrlItem.setTriggerWords(str);
    }

    public void setAudioPause(boolean z) {
        this.mAudioPause = z;
    }

    private void avoidBodyPointsShake(PTDetectInfo pTDetectInfo) {
        if (pTDetectInfo.bodyPoints == null || pTDetectInfo.bodyPoints.isEmpty()) {
            this.mHasBodyDetected = false;
            if (!this.mHasSeenValid) {
                return;
            }
            if (System.currentTimeMillis() - this.mPreviousLostTime < this.mTimesForLostProtect) {
                pTDetectInfo.bodyPoints = this.mPreviousBodyPoints;
                return;
            }
            this.mHasSeenValid = false;
            this.mPreviousBodyPoints = null;
            return;
        }
        this.mHasBodyDetected = true;
        this.mHasSeenValid = true;
        this.mPreviousLostTime = System.currentTimeMillis();
        this.mPreviousBodyPoints = pTDetectInfo.bodyPoints;
    }
}
