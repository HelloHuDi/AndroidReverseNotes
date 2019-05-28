package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.recorder.ActVideoDecoder;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.PlayerUtil;
import com.tencent.ttpic.util.PlayerUtil.Player;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.ITEM_SOURCE_TYPE;
import com.tencent.ttpic.util.VideoPrefsUtil;
import com.tencent.ttpic.util.youtu.GestureDetector;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class FastSticker {
    protected String dataPath;
    protected long frameStartTime;
    protected int height;
    protected boolean isImageReady;
    protected StickerItem item;
    private int lastImageIndex = -1;
    private boolean mAudioPause;
    private boolean mHasBodyDetected = false;
    private boolean mHasSeenValid = false;
    protected boolean mIsRenderForBitmap = false;
    private Player mPlayer;
    public List<PointF> mPreviousBodyPoints = null;
    private long mPreviousLostTime = System.currentTimeMillis();
    protected double mScreenScale;
    private long mTimesForLostProtect = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
    protected ActVideoDecoder mVideoDecoder;
    protected int playCount = 0;
    protected RenderParam renderParam = new RenderParam();
    private int[] tex = new int[1];
    protected TriggerCtrlItem triggerCtrlItem;
    protected boolean triggered = false;
    protected int width;

    public abstract void updatePositions(List<PointF> list);

    public abstract void updatePositions(List<PointF> list, float[] fArr);

    FastSticker(StickerItem stickerItem, String str) {
        this.item = stickerItem;
        this.dataPath = str;
        this.renderParam.f17530id = stickerItem.f18271id;
        this.triggerCtrlItem = new TriggerCtrlItem(stickerItem);
        initAudio();
    }

    public void updatePreview(PTDetectInfo pTDetectInfo) {
        if (VideoMaterialUtil.isBodyDetectItem(this.item)) {
            avoidBodyPointsShake(pTDetectInfo);
        }
        int frameIndex = getFrameIndex(pTDetectInfo.timestamp);
        updateActionTriggered(pTDetectInfo);
        if (needRenderTexture()) {
            if (VideoMaterialUtil.isFaceItem(this.item)) {
                updatePositions(pTDetectInfo.facePoints, pTDetectInfo.faceAngles);
            } else if (VideoMaterialUtil.isBodyDetectItem(this.item)) {
                updatePositions(pTDetectInfo.bodyPoints);
                if (!this.mHasBodyDetected) {
                    pTDetectInfo.bodyPoints = null;
                }
            } else {
                updatePositions(pTDetectInfo.handPoints, new float[]{0.0f, 0.0f, 0.0f});
            }
            updateTextureParam(frameIndex);
            return;
        }
        clearTextureParam();
        this.playCount = 0;
        VideoMemoryManager.getInstance().reset(this.item.f18271id);
        updateTextureParam(0);
    }

    public void updateVideoSize(int i, int i2, double d) {
        this.width = i;
        this.height = i2;
        this.mScreenScale = d;
    }

    public void updateTextureParam(long j) {
        int frameIndex = getFrameIndex(j);
        synchronized (this) {
            updateTextureParam(frameIndex);
        }
    }

    private int getFrameIndex(long j) {
        if (!this.triggered) {
            this.frameStartTime = j;
        }
        int max = (int) (((double) (j - this.frameStartTime)) / Math.max(this.item.frameDuration, 1.0d));
        if (max >= this.item.frames * (this.playCount + 1)) {
            this.playCount++;
        }
        return max % Math.max(this.item.frames, 1);
    }

    public int getTexture() {
        return this.tex[0];
    }

    /* Access modifiers changed, original: protected */
    public void updateActionTriggered(PTDetectInfo pTDetectInfo) {
        boolean z = false;
        if (this.item != null) {
            boolean z2;
            Map map = pTDetectInfo.faceActionCounter;
            Map map2 = pTDetectInfo.handActionCounter;
            Set set = pTDetectInfo.triggeredExpression;
            List list = pTDetectInfo.bodyPoints;
            this.triggerCtrlItem.getTriggeredStatus(pTDetectInfo);
            if (this.item.activateTriggerTotalCount != 0) {
                Map map3;
                if (this.item.preTriggerType != PTExpression.ALWAYS.value) {
                    if (VideoMaterialUtil.isFaceTriggerType(this.item.preTriggerType)) {
                    }
                }
                boolean isFaceTriggerType = VideoMaterialUtil.isFaceTriggerType(this.item.countTriggerType);
                if (isFaceTriggerType) {
                    map3 = map;
                } else {
                    map3 = map2;
                }
                if (map3 != null) {
                    if ((isFaceTriggerType ? map : map2).size() != 0) {
                        if ((isFaceTriggerType ? ((FaceActionCounter) map.get(Integer.valueOf(this.item.countTriggerType))).count : ((HandActionCounter) map2.get(Integer.valueOf(this.item.countTriggerType))).count) % this.item.activateTriggerTotalCount == this.item.activateTriggerCount) {
                            if (this.item.playCount == 0 || this.playCount < this.item.playCount) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (this.playCount < this.item.playCount) {
                                if (isFaceTriggerType) {
                                    pTDetectInfo.faceDetector.lockActionCounter();
                                } else {
                                    GestureDetector.getInstance().lockActionCounter();
                                }
                            } else if (this.item.playCount > 0) {
                                if (isFaceTriggerType) {
                                    pTDetectInfo.faceDetector.clearActionCounter();
                                } else {
                                    GestureDetector.getInstance().clearActionCounter();
                                }
                            }
                        }
                    }
                }
                z2 = false;
            } else {
                if (VideoMaterialUtil.isFaceTriggerType(this.item.triggerType)) {
                    z2 = set.contains(Integer.valueOf(this.item.triggerType));
                } else if (!VideoMaterialUtil.isBodyDetectType(this.item.triggerType)) {
                    z2 = GestureDetector.getInstance().isGestureTriggered(this.item.triggerType);
                } else if (list == null) {
                    z2 = true;
                } else if (list.isEmpty()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2 || this.mIsRenderForBitmap) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            if (z2 && isRangeValueHit()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (!this.triggered) {
                    this.frameStartTime = pTDetectInfo.timestamp;
                    z = true;
                }
                this.triggered = true;
            } else if (this.item.alwaysTriggered || this.playCount >= this.item.playCount) {
                this.triggered = false;
            }
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
    }

    private void initAudio() {
        if (this.mPlayer == null && this.item != null && !TextUtils.isEmpty(this.dataPath) && !TextUtils.isEmpty(this.item.f18271id) && !TextUtils.isEmpty(this.item.audio)) {
            String str = this.dataPath + File.separator + this.item.f18271id + File.separator + this.item.audio;
            if (str.startsWith("assets://")) {
                this.mPlayer = PlayerUtil.createPlayerFromAssets(VideoGlobalContext.getContext(), str.replace("assets://", ""), false);
            } else {
                this.mPlayer = PlayerUtil.createPlayerFromUri(VideoGlobalContext.getContext(), str, false);
            }
        }
    }

    private boolean isRangeValueHit() {
        if ((this.item.charmRange == null || this.item.charmRange.isHit()) && ((this.item.ageRange == null || this.item.ageRange.isHit()) && ((this.item.genderRange == null || this.item.genderRange.isHit()) && ((this.item.popularRange == null || this.item.popularRange.isHit()) && (this.item.cpRange == null || this.item.cpRange.isHit()))))) {
            return true;
        }
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void updateTextureParam(int i) {
        if (i != this.lastImageIndex) {
            if (this.lastImageIndex > i && this.mVideoDecoder != null) {
                this.mVideoDecoder.reset();
            }
            this.renderParam.texture = getNextFrame(i);
        }
    }

    private int getNextFrame(int i) {
        if (this.item.sourceType == ITEM_SOURCE_TYPE.IMAGE || this.mVideoDecoder == null) {
            if (this.tex[0] != 0) {
                boolean z;
                Bitmap loadImage = VideoMemoryManager.getInstance().loadImage(this.item.f18271id, i);
                if (loadImage != null || (this.isImageReady && !this.mIsRenderForBitmap)) {
                    z = false;
                } else {
                    loadImage = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.f18271id + "_" + i + ".png", MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
                    z = true;
                }
                if (BitmapUtils.isLegal(loadImage)) {
                    GlUtil.loadTexture(this.tex[0], loadImage);
                    if (z) {
                        loadImage.recycle();
                    }
                }
            }
            return this.tex[0];
        }
        this.mVideoDecoder.decodeFrame((long) i);
        this.mVideoDecoder.updateFrame();
        this.isImageReady = true;
        this.lastImageIndex = i;
        return this.tex[0];
    }

    public void setBitmapDrawable(BitmapDrawable bitmapDrawable) {
    }

    public boolean needRenderTexture() {
        return this.triggered;
    }

    /* Access modifiers changed, original: protected */
    public void clearTextureParam() {
        this.renderParam.position = GlUtil.EMPTY_POSITIONS_TRIANGLES;
    }

    public void setStickerItem(StickerItem stickerItem) {
        this.item = stickerItem;
    }

    public void destroy() {
        clearGLSLSelf();
        PlayerUtil.destroyPlayer(this.mPlayer);
    }

    public void destroyAudio() {
        PlayerUtil.destroyPlayer(this.mPlayer);
        this.mPlayer = null;
    }

    public float getFrameDuration(long j) {
        if (this.triggered) {
            return (float) (((double) (j - this.frameStartTime)) / 1000.0d);
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
        GLES20.glGenTextures(this.tex.length, this.tex, 0);
        if (this.item.sourceType != ITEM_SOURCE_TYPE.IMAGE) {
            this.mVideoDecoder = new ActVideoDecoder(this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.f18271id + VideoMaterialUtil.MP4_SUFFIX, this.tex[0]);
        }
    }

    public boolean needRender(int i) {
        if ((this.item.personID == -1 || this.item.personID == i) && this.triggered && this.isImageReady) {
            return true;
        }
        return false;
    }

    public RenderParam getRenderParam() {
        return this.renderParam;
    }

    public void clearGLSLSelf() {
        int i = 0;
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

    public void reset() {
        this.triggered = false;
        this.playCount = 0;
        this.mHasBodyDetected = false;
        this.mHasSeenValid = false;
        this.mPreviousBodyPoints = null;
    }

    public void setAudioPause(boolean z) {
        this.mAudioPause = z;
    }

    private void avoidBodyPointsShake(PTDetectInfo pTDetectInfo) {
        if (pTDetectInfo.bodyPoints == null || pTDetectInfo.bodyPoints.isEmpty()) {
            this.mHasBodyDetected = false;
            if (!this.mHasSeenValid) {
                this.mHasSeenValid = false;
                return;
            } else if (System.currentTimeMillis() - this.mPreviousLostTime < this.mTimesForLostProtect) {
                pTDetectInfo.bodyPoints = this.mPreviousBodyPoints;
                return;
            } else {
                return;
            }
        }
        this.mHasBodyDetected = true;
        this.mHasSeenValid = true;
        this.mPreviousLostTime = System.currentTimeMillis();
        this.mPreviousBodyPoints = pTDetectInfo.bodyPoints;
    }
}
