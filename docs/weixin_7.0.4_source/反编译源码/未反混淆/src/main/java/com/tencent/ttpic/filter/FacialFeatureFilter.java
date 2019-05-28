package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.filter.h;
import com.tencent.filter.m.j;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.PTDetectInfo.Builder;
import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.VideoModule.DeviceType;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.model.DistortionItem;
import com.tencent.ttpic.model.FaceFeatureItem;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.List;

public class FacialFeatureFilter extends VideoFilterBase {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FacialFeatureFragmentShader.dat");
    private static int FRAME_EDGE = 640;
    public static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FacialFeatureVertexShader.dat");
    private float[] faceVertices = new float[1380];
    List<PointF> fullPositions;
    private float[] grayVertices = new float[1380];
    private FaceFeatureItem mFaceFeatureItem;
    private FaceItem mFaceItem;
    h mFrame = new h();
    private boolean mIsFirstRender = true;
    h mResultFrame;
    private List<NormalVideoFilter> mStickerFilters;
    h mTFrame = new h();
    TransformFilter mTransformFilter;
    private float[] mt4 = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private float[] texVertices = new float[1380];

    static {
        AppMethodBeat.i(82460);
        AppMethodBeat.o(82460);
    }

    public FacialFeatureFilter(FaceItem faceItem, List<DistortionItem> list, FaceFeatureItem faceFeatureItem) {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.i(82447);
        if (list != null) {
            this.mTransformFilter = new TransformFilter((List) list, null);
        }
        this.mFaceFeatureItem = faceFeatureItem;
        this.mFaceItem = faceItem;
        initParams();
        if (VideoModule.getDeviceType() == DeviceType.HIGH) {
            FRAME_EDGE = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
            AppMethodBeat.o(82447);
        } else if (VideoModule.getDeviceType() == DeviceType.MIDDLE) {
            FRAME_EDGE = 640;
            AppMethodBeat.o(82447);
        } else {
            FRAME_EDGE = 512;
            AppMethodBeat.o(82447);
        }
    }

    public void initParams() {
        AppMethodBeat.i(82448);
        addParam(new k("inputImageTexture2", FaceOffUtil.getFaceBitmap(this.mFaceFeatureItem.getDataPath() + File.separator + this.mFaceItem.faceExchangeImage), 33987, true));
        addParam(new j("posMatRotate", this.mt4));
        if (this.mTransformFilter != null) {
            this.mTransformFilter.initParams();
        }
        AppMethodBeat.o(82448);
    }

    public h getFrame() {
        return this.mFrame;
    }

    public void updatePreview(PTDetectInfo pTDetectInfo) {
        AppMethodBeat.i(82449);
        this.fullPositions = FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList(pTDetectInfo.facePoints), 2.0f);
        addAttribParam("inputTextureCoordinate", FaceOffUtil.initMaterialFaceTexCoords(this.fullPositions, (int) (((double) this.width) * this.mFaceDetScale), (int) (((double) this.height) * this.mFaceDetScale), this.texVertices));
        updateFacePoints(this.fullPositions, (float) FRAME_EDGE);
        List list = this.fullPositions;
        int i = FRAME_EDGE;
        setPositions(FaceOffUtil.initFacePositions(list, i, i, this.faceVertices));
        setCoordNum(690);
        if (this.mTransformFilter != null) {
            this.mTransformFilter.updatePreview(new Builder().facePoints(this.fullPositions).faceAngles(pTDetectInfo.faceAngles).faceActionCounter(pTDetectInfo.faceActionCounter).handPoints(pTDetectInfo.handPoints).handActionCounter(pTDetectInfo.handActionCounter).triggeredExpression(pTDetectInfo.triggeredExpression).phoneAngle(pTDetectInfo.phoneAngle).timestamp(pTDetectInfo.timestamp).build());
        }
        AppMethodBeat.o(82449);
    }

    private void updateFacePoints(List<PointF> list, float f) {
        AppMethodBeat.i(82450);
        float f2 = ((PointF) list.get(64)).x;
        float f3 = ((PointF) list.get(64)).y;
        for (PointF pointF : list) {
            pointF.x -= f2;
            pointF.y -= f3;
        }
        float atan2 = (float) Math.atan2((double) (((PointF) list.get(9)).x - ((PointF) list.get(84)).x), (double) (((PointF) list.get(9)).y - ((PointF) list.get(84)).y));
        f2 = (float) Math.cos((double) atan2);
        f3 = (float) Math.sin((double) atan2);
        for (PointF pointF2 : list) {
            float f4 = pointF2.x;
            float f5 = pointF2.y;
            pointF2.x = (f4 * f2) - (f5 * f3);
            pointF2.y = (f4 * f3) + (f5 * f2);
        }
        f2 = AlgoUtils.getDistance((PointF) list.get(99), (PointF) list.get(101));
        for (PointF pointF22 : list) {
            pointF22.x = (pointF22.x * f) / f2;
            pointF22.y = (pointF22.y * f) / f2;
        }
        f2 = f / 2.0f;
        for (PointF pointF3 : list) {
            pointF3.x += f2;
            pointF3.y += f2;
        }
        AppMethodBeat.o(82450);
    }

    public void initAttribParams() {
        AppMethodBeat.i(82451);
        super.initAttribParams();
        addAttribParam("inputTextureCoordinate2", FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoords(FaceOffUtil.genPoints(this.mFaceItem.facePoints), 2.0f), this.mFaceItem.width, this.mFaceItem.height, this.grayVertices));
        if (this.mTransformFilter != null) {
            this.mTransformFilter.initAttribParams();
        }
        setDrawMode(DRAW_MODE.TRIANGLES);
        setCoordNum(690);
        AppMethodBeat.o(82451);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(82452);
        super.ApplyGLSLFilter();
        if (this.mTransformFilter != null) {
            this.mTransformFilter.ApplyGLSLFilter();
        }
        for (VideoFilterBase ApplyGLSLFilter : this.mStickerFilters) {
            ApplyGLSLFilter.ApplyGLSLFilter();
        }
        AppMethodBeat.o(82452);
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.i(82453);
        super.updateVideoSize(i, i2, d);
        if (this.mTransformFilter != null) {
            TransformFilter transformFilter = this.mTransformFilter;
            int i3 = FRAME_EDGE;
            transformFilter.updateVideoSize(i3, i3, 1.0d);
        }
        for (NormalVideoFilter updateVideoSize : this.mStickerFilters) {
            updateVideoSize.updateVideoSize(i, i2, d);
        }
        AppMethodBeat.o(82453);
    }

    public void RenderProcess(int i, int i2, int i3, int i4, double d, h hVar) {
        AppMethodBeat.i(82454);
        h hVar2 = this.mFrame;
        int i5 = FRAME_EDGE;
        hVar2.a(-1, i5, i5, d);
        if (this.mIsFirstRender) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
        }
        this.mIsFirstRender = false;
        OnDrawFrameGLSL();
        int i6 = FRAME_EDGE;
        renderTexture(i, i6, i6);
        this.mResultFrame = this.mFrame;
        if (this.mTransformFilter != null) {
            TransformFilter transformFilter = this.mTransformFilter;
            i5 = this.mFrame.texture[0];
            int i7 = FRAME_EDGE;
            transformFilter.RenderProcess(i5, i7, i7, -1, d, this.mTFrame);
            this.mResultFrame = this.mTFrame;
        }
        AppMethodBeat.o(82454);
    }

    public void clearGLSLSelf() {
        AppMethodBeat.i(82455);
        if (this.mTransformFilter != null) {
            this.mTransformFilter.clearGLSLSelf();
        }
        for (NormalVideoFilter clearGLSLSelf : this.mStickerFilters) {
            clearGLSLSelf.clearGLSLSelf();
        }
        this.mFrame.clear();
        this.mTFrame.clear();
        super.clearGLSLSelf();
        AppMethodBeat.o(82455);
    }

    public boolean setRenderMode(int i) {
        AppMethodBeat.i(82456);
        super.setRenderMode(i);
        if (this.mTransformFilter != null) {
            this.mTransformFilter.setRenderMode(i);
        }
        for (NormalVideoFilter renderMode : this.mStickerFilters) {
            renderMode.setRenderMode(i);
        }
        AppMethodBeat.o(82456);
        return true;
    }

    public void setStickerFilters(List<NormalVideoFilter> list) {
        AppMethodBeat.i(82457);
        this.mStickerFilters = list;
        for (NormalVideoFilter normalVideoFilter : list) {
            normalVideoFilter.item.support3D = 0;
        }
        AppMethodBeat.o(82457);
    }

    public List<NormalVideoFilter> getStickerFilters() {
        return this.mStickerFilters;
    }

    public void updateStickerFilterList(List<PointF> list, float[] fArr, h hVar) {
        AppMethodBeat.i(82458);
        updatePreview(new Builder().facePoints(list).faceAngles(fArr).build());
        RenderProcess(hVar.texture[0], hVar.width, hVar.height, hVar.texture[0], 0.0d, hVar);
        for (NormalVideoFilter normalVideoFilter : this.mStickerFilters) {
            if (!normalVideoFilter.needLoadImage()) {
                float distance = AlgoUtils.getDistance((PointF) this.fullPositions.get(normalVideoFilter.item.scalePivots[0]), (PointF) this.fullPositions.get(normalVideoFilter.item.scalePivots[1]));
                float f = (((float) normalVideoFilter.item.dx) * distance) / ((float) normalVideoFilter.item.originalScaleFactor);
                float f2 = (((float) normalVideoFilter.item.dy) * distance) / ((float) normalVideoFilter.item.originalScaleFactor);
                if (normalVideoFilter.item.anchorPoint != null && normalVideoFilter.item.anchorPoint.length >= 2) {
                    normalVideoFilter.item.anchorPoint[0] = (int) (((PointF) this.fullPositions.get(this.mFaceFeatureItem.getMaskAnchorPoint())).x + f);
                    normalVideoFilter.item.anchorPoint[1] = (int) (((PointF) this.fullPositions.get(this.mFaceFeatureItem.getMaskAnchorPoint())).y + f2);
                }
                normalVideoFilter.item.width = FRAME_EDGE;
                normalVideoFilter.item.height = FRAME_EDGE;
                normalVideoFilter.item.scaleFactor = (int) (distance / (normalVideoFilter.item.scale <= 0.0f ? 1.0f : normalVideoFilter.item.scale));
                normalVideoFilter.updateTextureParam(this.mResultFrame.texture[0]);
            }
        }
        AppMethodBeat.o(82458);
    }

    public void reset() {
        AppMethodBeat.i(82459);
        for (NormalVideoFilter reset : this.mStickerFilters) {
            reset.reset();
        }
        if (this.mTransformFilter != null) {
            this.mTransformFilter.reset();
        }
        AppMethodBeat.o(82459);
    }
}
