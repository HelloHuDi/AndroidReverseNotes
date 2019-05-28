package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo.Builder;
import com.tencent.ttpic.PTFaceAttr;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.youtu.GestureDetector;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PTBeautyFaceList {
    public static final String TAG = BeautyFaceList.class.getName();
    private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bJB);
    private h mCopyFrame1 = new h();
    private h mCopyFrame2 = new h();
    private EyeLightenAndPounchFilter mEyeLightenFilter = new EyeLightenAndPounchFilter();
    private h mEyeLightenFrame = new h();
    private FaceFeatureFilter mFaceFeatureFilter = new FaceFeatureFilter();
    private h mFaceFeatureFrame = new h();
    private h mRemovePounchFrame = new h();

    static {
        AppMethodBeat.i(82695);
        AppMethodBeat.o(82695);
    }

    public PTBeautyFaceList() {
        AppMethodBeat.i(82687);
        AppMethodBeat.o(82687);
    }

    public void initial() {
        AppMethodBeat.i(82688);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.ApplyGLSLFilter();
        }
        if (this.mFaceFeatureFilter != null) {
            this.mFaceFeatureFilter.ApplyGLSLFilter();
        }
        this.mCopyFilter.ApplyGLSLFilter();
        AppMethodBeat.o(82688);
    }

    public void setRemovePounchAlpha(float f) {
        AppMethodBeat.i(82689);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.setSmoothOpacity(f);
        }
        AppMethodBeat.o(82689);
    }

    public void setEyeLightenAlpha(float f) {
        AppMethodBeat.i(82690);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.setAlphaValue(f);
        }
        AppMethodBeat.o(82690);
    }

    public void setPounchEnhance(float f) {
    }

    public void setFaceFeatherAlpha(float f) {
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.i(82691);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.updateVideoSize(i, i2, d);
        }
        if (this.mFaceFeatureFilter != null) {
            this.mFaceFeatureFilter.updateVideoSize(i, i2, d);
        }
        AppMethodBeat.o(82691);
    }

    public h process(h hVar, PTFaceAttr pTFaceAttr) {
        int i;
        int i2;
        float[] fArr;
        AppMethodBeat.i(82692);
        List allFacePoints = pTFaceAttr.getAllFacePoints();
        List allFaceAngles = pTFaceAttr.getAllFaceAngles();
        Map faceActionCounter = pTFaceAttr.getFaceActionCounter();
        List handPoints = pTFaceAttr.getHandPoints();
        Set triggeredExpression = pTFaceAttr.getTriggeredExpression();
        int rotation = pTFaceAttr.getRotation();
        long timeStamp = pTFaceAttr.getTimeStamp();
        BenchUtil.benchStart("mBeautyFaceList mFaceFeatherFilter");
        if (this.mFaceFeatureFilter != null) {
            this.mCopyFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, this.mFaceFeatureFrame);
            i = 0;
            while (true) {
                i2 = i;
                if (i2 >= allFacePoints.size()) {
                    break;
                }
                fArr = (float[]) allFaceAngles.get(i2);
                this.mFaceFeatureFilter.updatePreview(new Builder().facePoints((List) allFacePoints.get(i2)).faceAngles(fArr).faceActionCounter(faceActionCounter).handPoints(handPoints).handActionCounter(GestureDetector.getInstance().getHandActionCounter()).triggeredExpression(triggeredExpression).phoneAngle((float) rotation).timestamp(timeStamp).build());
                this.mFaceFeatureFilter.OnDrawFrameGLSL();
                this.mFaceFeatureFilter.renderTexture(hVar.texture[0], hVar.width, hVar.height);
                i = i2 + 1;
            }
            hVar = this.mFaceFeatureFrame;
        }
        BenchUtil.benchEnd("mBeautyFaceList mFaceFeatherFilter");
        BenchUtil.benchStart("mBeautyFaceList mEyeLightenFilter");
        if (this.mEyeLightenFilter != null && this.mEyeLightenFilter.needRender()) {
            this.mCopyFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, this.mEyeLightenFrame);
            i = 0;
            while (true) {
                i2 = i;
                if (i2 >= allFacePoints.size()) {
                    break;
                }
                fArr = (float[]) allFaceAngles.get(i2);
                this.mEyeLightenFilter.updatePreview(new Builder().facePoints((List) allFacePoints.get(i2)).faceAngles(fArr).faceActionCounter(faceActionCounter).handPoints(handPoints).handActionCounter(GestureDetector.getInstance().getHandActionCounter()).triggeredExpression(triggeredExpression).phoneAngle((float) rotation).timestamp(timeStamp).build());
                this.mEyeLightenFilter.OnDrawFrameGLSL();
                this.mEyeLightenFilter.renderTexture(hVar.texture[0], hVar.width, hVar.height);
                i = i2 + 1;
            }
            hVar = this.mEyeLightenFrame;
        }
        BenchUtil.benchEnd("mBeautyFaceList mEyeLightenFilter");
        AppMethodBeat.o(82692);
        return hVar;
    }

    public void clear() {
        AppMethodBeat.i(82693);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.clearGLSLSelf();
        }
        if (this.mFaceFeatureFilter != null) {
            this.mFaceFeatureFilter.clearGLSLSelf();
        }
        this.mCopyFilter.ClearGLSL();
        this.mRemovePounchFrame.clear();
        this.mEyeLightenFrame.clear();
        this.mFaceFeatureFrame.clear();
        this.mCopyFrame1.clear();
        this.mCopyFrame2.clear();
        AppMethodBeat.o(82693);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.i(82694);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.setRenderMode(i);
        }
        if (this.mFaceFeatureFilter != null) {
            this.mFaceFeatureFilter.setRenderMode(i);
        }
        this.mCopyFilter.setRenderMode(i);
        AppMethodBeat.o(82694);
    }
}
