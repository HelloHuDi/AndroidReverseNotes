package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo.Builder;
import com.tencent.ttpic.facedetect.FaceDetector;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.youtu.GestureDetector;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BeautyFaceListReshape {
    public static final String TAG = BeautyFaceListReshape.class.getName();
    private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bJB);
    private C41672h mCopyFrame1 = new C41672h();
    private C41672h mCopyFrame2 = new C41672h();
    private EyeLightenAndPounchFilterReshape mEyeLightenFilter = new EyeLightenAndPounchFilterReshape();
    private C41672h mEyeLightenFrame = new C41672h();
    private FaceFeatureFilterReshape mFaceFeatureFilter = new FaceFeatureFilterReshape();
    private C41672h mFaceFeatureFrame = new C41672h();
    private C41672h mRemovePounchFrame = new C41672h();

    static {
        AppMethodBeat.m2504i(81999);
        AppMethodBeat.m2505o(81999);
    }

    public BeautyFaceListReshape() {
        AppMethodBeat.m2504i(81989);
        AppMethodBeat.m2505o(81989);
    }

    public void initial() {
        AppMethodBeat.m2504i(81990);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.ApplyGLSLFilter();
        }
        if (this.mFaceFeatureFilter != null) {
            this.mFaceFeatureFilter.ApplyGLSLFilter();
        }
        this.mCopyFilter.ApplyGLSLFilter();
        AppMethodBeat.m2505o(81990);
    }

    public void setRemovePounchAlpha(float f) {
        AppMethodBeat.m2504i(81991);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.setSmoothOpacity(f);
        }
        AppMethodBeat.m2505o(81991);
    }

    public void setEyeLightenAlpha(float f) {
        AppMethodBeat.m2504i(81992);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.setAlphaValue(f);
        }
        AppMethodBeat.m2505o(81992);
    }

    public void setPounchEnhance(float f) {
        AppMethodBeat.m2504i(81993);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.setPounchEnhance(f);
        }
        AppMethodBeat.m2505o(81993);
    }

    public void setFaceFeatherAlpha(float f) {
        AppMethodBeat.m2504i(81994);
        if (this.mFaceFeatureFilter != null) {
            this.mFaceFeatureFilter.setAlphaValue(f);
        }
        AppMethodBeat.m2505o(81994);
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.m2504i(81995);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.updateVideoSize(i, i2, d);
        }
        if (this.mFaceFeatureFilter != null) {
            this.mFaceFeatureFilter.updateVideoSize(i, i2, d);
        }
        AppMethodBeat.m2505o(81995);
    }

    public C41672h render(C41672h c41672h, List<List<PointF>> list, List<float[]> list2, FaceDetector faceDetector, List<PointF> list3, Set<Integer> set, double d, int i, long j) {
        Map faceActionCounter;
        int i2;
        int i3;
        float[] fArr;
        AppMethodBeat.m2504i(81996);
        if (faceDetector != null) {
            faceActionCounter = faceDetector.getFaceActionCounter();
        } else {
            faceActionCounter = null;
        }
        BenchUtil.benchStart("mBeautyFaceList mFaceFeatherFilter");
        if (this.mFaceFeatureFilter != null && this.mFaceFeatureFilter.needRender()) {
            this.mCopyFilter.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, this.mFaceFeatureFrame);
            i2 = 0;
            while (true) {
                i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                fArr = (float[]) list2.get(i3);
                this.mFaceFeatureFilter.updatePreview(new Builder().facePoints((List) list.get(i3)).faceAngles(fArr).faceActionCounter(faceActionCounter).handPoints(list3).handActionCounter(GestureDetector.getInstance().getHandActionCounter()).triggeredExpression(set).phoneAngle((float) i).timestamp(j).build());
                this.mFaceFeatureFilter.OnDrawFrameGLSL();
                this.mFaceFeatureFilter.renderTexture(c41672h.texture[0], c41672h.width, c41672h.height);
                i2 = i3 + 1;
            }
            c41672h = this.mFaceFeatureFrame;
        }
        BenchUtil.benchEnd("mBeautyFaceList mFaceFeatherFilter");
        BenchUtil.benchStart("mBeautyFaceList mEyeLightenFilter");
        if (this.mEyeLightenFilter != null && this.mEyeLightenFilter.needRender()) {
            this.mCopyFilter.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, this.mEyeLightenFrame);
            i2 = 0;
            while (true) {
                i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                fArr = (float[]) list2.get(i3);
                this.mEyeLightenFilter.updatePreview(new Builder().facePoints((List) list.get(i3)).faceAngles(fArr).faceActionCounter(faceActionCounter).handPoints(list3).handActionCounter(GestureDetector.getInstance().getHandActionCounter()).triggeredExpression(set).phoneAngle((float) i).timestamp(j).build());
                this.mEyeLightenFilter.OnDrawFrameGLSL();
                this.mEyeLightenFilter.renderTexture(c41672h.texture[0], c41672h.width, c41672h.height);
                i2 = i3 + 1;
            }
            c41672h = this.mEyeLightenFrame;
        }
        BenchUtil.benchEnd("mBeautyFaceList mEyeLightenFilter");
        AppMethodBeat.m2505o(81996);
        return c41672h;
    }

    public void clear() {
        AppMethodBeat.m2504i(81997);
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
        AppMethodBeat.m2505o(81997);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.m2504i(81998);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.setRenderMode(i);
        }
        if (this.mFaceFeatureFilter != null) {
            this.mFaceFeatureFilter.setRenderMode(i);
        }
        this.mCopyFilter.setRenderMode(i);
        AppMethodBeat.m2505o(81998);
    }
}
