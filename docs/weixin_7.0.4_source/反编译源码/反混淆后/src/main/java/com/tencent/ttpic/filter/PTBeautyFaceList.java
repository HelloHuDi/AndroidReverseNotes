package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
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
    private C41672h mCopyFrame1 = new C41672h();
    private C41672h mCopyFrame2 = new C41672h();
    private EyeLightenAndPounchFilter mEyeLightenFilter = new EyeLightenAndPounchFilter();
    private C41672h mEyeLightenFrame = new C41672h();
    private FaceFeatureFilter mFaceFeatureFilter = new FaceFeatureFilter();
    private C41672h mFaceFeatureFrame = new C41672h();
    private C41672h mRemovePounchFrame = new C41672h();

    static {
        AppMethodBeat.m2504i(82695);
        AppMethodBeat.m2505o(82695);
    }

    public PTBeautyFaceList() {
        AppMethodBeat.m2504i(82687);
        AppMethodBeat.m2505o(82687);
    }

    public void initial() {
        AppMethodBeat.m2504i(82688);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.ApplyGLSLFilter();
        }
        if (this.mFaceFeatureFilter != null) {
            this.mFaceFeatureFilter.ApplyGLSLFilter();
        }
        this.mCopyFilter.ApplyGLSLFilter();
        AppMethodBeat.m2505o(82688);
    }

    public void setRemovePounchAlpha(float f) {
        AppMethodBeat.m2504i(82689);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.setSmoothOpacity(f);
        }
        AppMethodBeat.m2505o(82689);
    }

    public void setEyeLightenAlpha(float f) {
        AppMethodBeat.m2504i(82690);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.setAlphaValue(f);
        }
        AppMethodBeat.m2505o(82690);
    }

    public void setPounchEnhance(float f) {
    }

    public void setFaceFeatherAlpha(float f) {
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.m2504i(82691);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.updateVideoSize(i, i2, d);
        }
        if (this.mFaceFeatureFilter != null) {
            this.mFaceFeatureFilter.updateVideoSize(i, i2, d);
        }
        AppMethodBeat.m2505o(82691);
    }

    public C41672h process(C41672h c41672h, PTFaceAttr pTFaceAttr) {
        int i;
        int i2;
        float[] fArr;
        AppMethodBeat.m2504i(82692);
        List allFacePoints = pTFaceAttr.getAllFacePoints();
        List allFaceAngles = pTFaceAttr.getAllFaceAngles();
        Map faceActionCounter = pTFaceAttr.getFaceActionCounter();
        List handPoints = pTFaceAttr.getHandPoints();
        Set triggeredExpression = pTFaceAttr.getTriggeredExpression();
        int rotation = pTFaceAttr.getRotation();
        long timeStamp = pTFaceAttr.getTimeStamp();
        BenchUtil.benchStart("mBeautyFaceList mFaceFeatherFilter");
        if (this.mFaceFeatureFilter != null) {
            this.mCopyFilter.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, this.mFaceFeatureFrame);
            i = 0;
            while (true) {
                i2 = i;
                if (i2 >= allFacePoints.size()) {
                    break;
                }
                fArr = (float[]) allFaceAngles.get(i2);
                this.mFaceFeatureFilter.updatePreview(new Builder().facePoints((List) allFacePoints.get(i2)).faceAngles(fArr).faceActionCounter(faceActionCounter).handPoints(handPoints).handActionCounter(GestureDetector.getInstance().getHandActionCounter()).triggeredExpression(triggeredExpression).phoneAngle((float) rotation).timestamp(timeStamp).build());
                this.mFaceFeatureFilter.OnDrawFrameGLSL();
                this.mFaceFeatureFilter.renderTexture(c41672h.texture[0], c41672h.width, c41672h.height);
                i = i2 + 1;
            }
            c41672h = this.mFaceFeatureFrame;
        }
        BenchUtil.benchEnd("mBeautyFaceList mFaceFeatherFilter");
        BenchUtil.benchStart("mBeautyFaceList mEyeLightenFilter");
        if (this.mEyeLightenFilter != null && this.mEyeLightenFilter.needRender()) {
            this.mCopyFilter.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, this.mEyeLightenFrame);
            i = 0;
            while (true) {
                i2 = i;
                if (i2 >= allFacePoints.size()) {
                    break;
                }
                fArr = (float[]) allFaceAngles.get(i2);
                this.mEyeLightenFilter.updatePreview(new Builder().facePoints((List) allFacePoints.get(i2)).faceAngles(fArr).faceActionCounter(faceActionCounter).handPoints(handPoints).handActionCounter(GestureDetector.getInstance().getHandActionCounter()).triggeredExpression(triggeredExpression).phoneAngle((float) rotation).timestamp(timeStamp).build());
                this.mEyeLightenFilter.OnDrawFrameGLSL();
                this.mEyeLightenFilter.renderTexture(c41672h.texture[0], c41672h.width, c41672h.height);
                i = i2 + 1;
            }
            c41672h = this.mEyeLightenFrame;
        }
        BenchUtil.benchEnd("mBeautyFaceList mEyeLightenFilter");
        AppMethodBeat.m2505o(82692);
        return c41672h;
    }

    public void clear() {
        AppMethodBeat.m2504i(82693);
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
        AppMethodBeat.m2505o(82693);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.m2504i(82694);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.setRenderMode(i);
        }
        if (this.mFaceFeatureFilter != null) {
            this.mFaceFeatureFilter.setRenderMode(i);
        }
        this.mCopyFilter.setRenderMode(i);
        AppMethodBeat.m2505o(82694);
    }
}
