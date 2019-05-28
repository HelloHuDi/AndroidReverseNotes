package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.m.b;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.k;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.TRIGGERED_STATUS;
import com.tencent.ttpic.model.TriggerCtrlItem;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.List;

public class FaceOffFilter extends VideoFilterBase {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceOffFragmentShader.dat");
    private static final String TAG = FaceOffFilter.class.getSimpleName();
    public static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceOffVertexShader.dat");
    private byte[] data = null;
    protected int faceImageHeight;
    protected int faceImageWidth;
    private float[] faceVertices = new float[1380];
    private int grayImageHeight;
    private int grayImageWidth;
    private float[] grayVertices = new float[1380];
    protected boolean isFaceImageReady;
    private boolean isGrayImageReady;
    protected FaceItem item;
    private int lastIndex = -1;
    public float level1 = 0.0f;
    public float level2 = 0.0f;
    public int levelCount = 0;
    byte[] mData = null;
    float percent1 = 0.05f;
    float percent2 = 0.15f;
    private boolean sequenceMode;
    public double sumg = 0.0d;
    public double sumr = 0.0d;
    private float[] texVertices = new float[1380];
    protected int[] texture = new int[2];
    private TriggerCtrlItem triggerCtrlItem;
    private boolean triggered;

    static {
        AppMethodBeat.i(82434);
        AppMethodBeat.o(82434);
    }

    public FaceOffFilter(FaceItem faceItem, String str) {
        super(PROGRAM_TYPE.FACEOFF);
        AppMethodBeat.i(82413);
        this.item = faceItem;
        this.dataPath = str;
        this.sequenceMode = TextUtils.isEmpty(faceItem.faceExchangeImage);
        this.triggerCtrlItem = new TriggerCtrlItem(faceItem);
        initParams();
        AppMethodBeat.o(82413);
    }

    public void initParams() {
        AppMethodBeat.i(82414);
        this.faceImageWidth = this.item.width;
        this.faceImageHeight = this.item.height;
        addParam(new n("inputImageTexture2", 0, 33986));
        addParam(new n("inputImageTexture3", 0, 33987));
        addParam(new i("enableFaceOff", 1));
        addParam(new f("alpha", this.item.blendAlpha));
        addParam(new b("canvasSize", 0.0f, 0.0f));
        addParam(new f("positionRotate", 0.0f));
        addParam(new i("enableAlphaFromGray", this.item.grayScale));
        addParam(new i("blendMode", this.item.blendMode));
        if (this.item.blendMode == 13) {
            addParam(new f("level1", 0.0f));
            addParam(new f("level2", 0.0f));
        }
        if (this.item.blendMode == 14) {
            addParam(new k("inputImageTexture4", FaceOffUtil.getFaceBitmap(this.dataPath + File.separator + this.item.irisImage), 33988, true));
            float[] fArr = new float[]{0.0f, 0.0f};
            addParam(new g("center1", fArr));
            addParam(new g("center2", fArr));
            addParam(new g("size", fArr));
            addParam(new f("radius1", 0.0f));
            addParam(new f("radius2", 0.0f));
            addParam(new f("leftEyeClosed", 0.0f));
            addParam(new f("rightEyeClosed", 0.0f));
        }
        AppMethodBeat.o(82414);
    }

    public void setCosAlpha(float f) {
        AppMethodBeat.i(82415);
        addParam(new f("alpha", f));
        AppMethodBeat.o(82415);
    }

    public void updatePreview(PTDetectInfo pTDetectInfo) {
        AppMethodBeat.i(82416);
        List copyList = VideoMaterialUtil.copyList(pTDetectInfo.facePoints);
        updateActionTriggered(pTDetectInfo);
        this.triggered = this.triggerCtrlItem.isTriggered();
        if (this.triggered) {
            updatePointParams(copyList);
            updateTextureParams(pTDetectInfo.timestamp);
            AppMethodBeat.o(82416);
            return;
        }
        this.lastIndex = -1;
        AppMethodBeat.o(82416);
    }

    public void initAttribParams() {
        AppMethodBeat.i(82417);
        super.initAttribParams();
        initFaceTexCoords();
        initGrayTexCoords();
        setDrawMode(DRAW_MODE.TRIANGLES);
        setCoordNum(690);
        AppMethodBeat.o(82417);
    }

    /* Access modifiers changed, original: protected */
    public void initFaceTexCoords() {
        AppMethodBeat.i(82418);
        setTexCords(FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoordsForFaceOffFilter(FaceOffUtil.genPoints(this.item.facePoints), 2.0f), this.faceImageWidth, this.faceImageHeight, this.texVertices));
        AppMethodBeat.o(82418);
    }

    private void initGrayTexCoords() {
        AppMethodBeat.i(82419);
        setGrayCords(FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoordsForFaceOffFilter(FaceOffUtil.getGrayCoords(this.item.featureType), 2.0f), this.grayImageWidth, this.grayImageHeight, this.grayVertices));
        AppMethodBeat.o(82419);
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.i(82420);
        super.updateVideoSize(i, i2, d);
        addParam(new b("canvasSize", (float) i, (float) i2));
        AppMethodBeat.o(82420);
    }

    public TRIGGERED_STATUS updateActionTriggered(PTDetectInfo pTDetectInfo) {
        AppMethodBeat.i(82421);
        TRIGGERED_STATUS triggeredStatus = this.triggerCtrlItem.getTriggeredStatus(pTDetectInfo);
        AppMethodBeat.o(82421);
        return triggeredStatus;
    }

    public void updateTextureParams(long j) {
        AppMethodBeat.i(82422);
        if (!initGrayImage()) {
            AppMethodBeat.o(82422);
        } else if (this.sequenceMode) {
            this.triggerCtrlItem.updateFrameIndex(j);
            int frameIndex = this.triggerCtrlItem.getFrameIndex();
            if (frameIndex == this.lastIndex) {
                AppMethodBeat.o(82422);
                return;
            }
            int nextFrame = getNextFrame(frameIndex);
            if (nextFrame <= 0) {
                AppMethodBeat.o(82422);
                return;
            }
            addParam(new n("inputImageTexture2", nextFrame, 33986));
            this.lastIndex = frameIndex;
            AppMethodBeat.o(82422);
        } else {
            initFaceImage();
            AppMethodBeat.o(82422);
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean initFaceImage() {
        AppMethodBeat.i(82423);
        if (this.isFaceImageReady) {
            AppMethodBeat.o(82423);
            return true;
        }
        Bitmap loadImage = VideoMemoryManager.getInstance().loadImage(this.item.faceExchangeImage, this.item.faceExchangeImage);
        int sampleSize = VideoMemoryManager.getInstance().getSampleSize();
        if (BitmapUtils.isLegal(loadImage)) {
            GlUtil.loadTexture(this.texture[0], loadImage);
            this.faceImageWidth = loadImage.getWidth() * sampleSize;
            this.faceImageHeight = loadImage.getHeight() * sampleSize;
            initFaceTexCoords();
            addParam(new n("inputImageTexture2", this.texture[0], 33986));
            this.isFaceImageReady = true;
        }
        boolean z = this.isFaceImageReady;
        AppMethodBeat.o(82423);
        return z;
    }

    /* Access modifiers changed, original: protected */
    public boolean initGrayImage() {
        AppMethodBeat.i(82424);
        if (this.isGrayImageReady) {
            AppMethodBeat.o(82424);
            return true;
        }
        Bitmap loadImage = VideoMemoryManager.getInstance().loadImage(this.item.featureType);
        int sampleSize = VideoMemoryManager.getInstance().getSampleSize();
        if (BitmapUtils.isLegal(loadImage)) {
            GlUtil.loadTexture(this.texture[1], loadImage);
            this.grayImageWidth = loadImage.getWidth() * sampleSize;
            this.grayImageHeight = loadImage.getHeight() * sampleSize;
            initGrayTexCoords();
            addParam(new n("inputImageTexture3", this.texture[1], 33987));
            this.isGrayImageReady = true;
        }
        boolean z = this.isGrayImageReady;
        AppMethodBeat.o(82424);
        return z;
    }

    public void updatePointParams(List<PointF> list) {
        float f = 1.0f;
        int i = 1;
        AppMethodBeat.i(82425);
        setPositions(FaceOffUtil.initFacePositions(FaceOffUtil.getFullCoordsForFaceOffFilter(VideoMaterialUtil.copyList(list), 2.0f), (int) (((double) this.width) * this.mFaceDetScale), (int) (((double) this.height) * this.mFaceDetScale), this.faceVertices));
        setCoordNum(690);
        if (this.item.blendMode == 13) {
            getAverageGreen(list, (int) (((double) this.width) * this.mFaceDetScale), (int) (((double) this.height) * this.mFaceDetScale));
            addParam(new f("level1", this.level1 / 255.0f));
            addParam(new f("level2", this.level2 / 255.0f));
        }
        if (this.item.blendMode == 14) {
            int i2;
            float distance = AlgoUtils.getDistance((PointF) list.get(35), (PointF) list.get(39));
            float distance2 = AlgoUtils.getDistance((PointF) list.get(45), (PointF) list.get(49));
            float max = Math.max(((PointF) list.get(44)).x - ((PointF) list.get(43)).x, ((PointF) list.get(54)).x - ((PointF) list.get(53)).x);
            distance2 = ((((float) Math.pow((double) (Math.abs(max) / Math.max(distance, distance2)), 1.0d)) * 20.0f) + 1.0f) * max;
            float[] fArr = new float[]{(float) (((double) (((PointF) list.get(44)).x + distance2)) / this.mFaceDetScale), (float) (((double) ((PointF) list.get(44)).y) / this.mFaceDetScale)};
            float[] fArr2 = new float[]{(float) (((double) (((PointF) list.get(54)).x + distance2)) / this.mFaceDetScale), (float) (((double) ((PointF) list.get(54)).y) / this.mFaceDetScale)};
            float[] fArr3 = new float[]{(float) this.width, (float) this.height};
            float distance3 = ((float) ((((double) AlgoUtils.getDistance((PointF) list.get(39), (PointF) list.get(35))) / this.mFaceDetScale) / 4.0d)) * 0.9f;
            float distance4 = ((float) ((((double) AlgoUtils.getDistance((PointF) list.get(49), (PointF) list.get(45))) / this.mFaceDetScale) / 4.0d)) * 0.9f;
            if (AlgoUtils.getDistance((PointF) list.get(41), (PointF) list.get(37)) / distance3 < 0.1f) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (AlgoUtils.getDistance((PointF) list.get(51), (PointF) list.get(47)) / distance4 >= 0.1f) {
                i = 0;
            }
            addParam(new g("center1", fArr));
            addParam(new g("center2", fArr2));
            addParam(new g("size", fArr3));
            addParam(new f("radius1", distance3));
            addParam(new f("radius2", distance4));
            addParam(new f("leftEyeClosed", i2 != 0 ? 1.0f : 0.0f));
            String str = "rightEyeClosed";
            if (i == 0) {
                f = 0.0f;
            }
            addParam(new f(str, f));
        }
        AppMethodBeat.o(82425);
    }

    public int getNextFrame(int i) {
        AppMethodBeat.i(82426);
        Bitmap loadImage = VideoMemoryManager.getInstance().loadImage(this.item.id, i);
        if (BitmapUtils.isLegal(loadImage)) {
            GlUtil.loadTexture(this.texture[0], loadImage);
            this.isFaceImageReady = true;
            int i2 = this.texture[0];
            AppMethodBeat.o(82426);
            return i2;
        }
        AppMethodBeat.o(82426);
        return -1;
    }

    public FaceItem getFaceOffItem() {
        return this.item;
    }

    public void setImageData(byte[] bArr) {
        if (bArr != null) {
            this.data = bArr;
        }
    }

    public void updateRandomGroupValue(int i) {
        AppMethodBeat.i(82427);
        this.triggerCtrlItem.setRandomGroupValue(i);
        AppMethodBeat.o(82427);
    }

    private float getAverageGreen(List<PointF> list, int i, int i2) {
        AppMethodBeat.i(82428);
        if (this.data == null || this.data.length < (i2 * i) * 4) {
            AppMethodBeat.o(82428);
            return 0.0f;
        }
        int i3 = (int) (((PointF) list.get(66)).x - ((PointF) list.get(65)).x);
        int i4 = (int) (((PointF) list.get(69)).y - ((PointF) list.get(78)).y);
        int i5 = (int) ((PointF) list.get(65)).x;
        int i6 = (int) ((PointF) list.get(78)).y;
        if (i5 >= i || i6 >= i2 || i3 <= 0 || i4 <= 0) {
            AppMethodBeat.o(82428);
            return 0.0f;
        }
        int i7;
        int i8;
        if (i5 < 0) {
            i7 = 0;
        } else {
            i7 = i5;
        }
        if (i6 < 0) {
            i8 = 0;
        } else {
            i8 = i6;
        }
        if (i7 + i3 > i) {
            i5 = i - i7;
        } else {
            i5 = i3;
        }
        if (i8 + i4 > i2) {
            i6 = i2 - i8;
        } else {
            i6 = i4;
        }
        byte[] bArr = new byte[((i5 * i6) * 4)];
        for (i3 = 0; i3 < i6; i3++) {
            for (i4 = 0; i4 < i5; i4++) {
                int i9 = ((i3 * i5) + i4) * 4;
                int i10 = ((((i3 + i8) * i) + i4) + i7) * 4;
                bArr[i9] = this.data[i10];
                bArr[i9 + 1] = this.data[i10 + 1];
                bArr[i9 + 2] = this.data[i10 + 2];
                bArr[i9 + 3] = this.data[i10 + 3];
            }
        }
        int[] iArr = new int[256];
        this.sumg = 0.0d;
        this.sumr = 0.0d;
        for (i3 = 0; i3 < i6; i3++) {
            for (i4 = 0; i4 < i5; i4++) {
                i7 = bArr[((i3 * i5) + i4) * 4] & 255;
                this.sumr += (double) i7;
                this.sumg += (double) (bArr[(((i3 * i5) + i4) * 4) + 1] & 255);
                iArr[i7] = iArr[i7] + 1;
            }
        }
        this.sumg /= (double) (i5 * i6);
        this.sumr /= (double) (i5 * i6);
        this.levelCount = 0;
        for (i4 = 255; i4 >= 0; i4--) {
            this.levelCount += iArr[i4];
            if (((float) this.levelCount) >= ((float) (i6 * i5)) * this.percent1) {
                this.level1 = (float) i4;
                break;
            }
        }
        this.levelCount = 0;
        for (i4 = 255; i4 >= 0; i4--) {
            this.levelCount += iArr[i4];
            if (((float) this.levelCount) >= ((float) (i6 * i5)) * this.percent2) {
                this.level2 = (float) i4;
                break;
            }
        }
        float f = (float) this.sumr;
        AppMethodBeat.o(82428);
        return f;
    }

    public boolean isRenderReady() {
        return this.triggered && this.isFaceImageReady && this.isGrayImageReady;
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(82429);
        super.ApplyGLSLFilter();
        GLES20.glGenTextures(this.texture.length, this.texture, 0);
        AppMethodBeat.o(82429);
    }

    public void clearGLSLSelf() {
        AppMethodBeat.i(82430);
        GLES20.glDeleteTextures(this.texture.length, this.texture, 0);
        super.clearGLSLSelf();
        AppMethodBeat.o(82430);
    }

    public boolean canUseBlendMode() {
        return this.item != null && this.item.blendMode < 2;
    }

    public void setRenderForBitmap(boolean z) {
        AppMethodBeat.i(82431);
        this.triggerCtrlItem.setRenderForBitmap(z);
        AppMethodBeat.o(82431);
    }

    public void reset() {
        AppMethodBeat.i(82432);
        this.triggerCtrlItem.reset();
        AppMethodBeat.o(82432);
    }

    public void setTriggerWords(String str) {
        AppMethodBeat.i(82433);
        this.triggerCtrlItem.setTriggerWords(str);
        AppMethodBeat.o(82433);
    }
}
