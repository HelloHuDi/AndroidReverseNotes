package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.BenchUtil;
import java.util.List;

public class BeautyFaceList_573 {
    public static final String TAG = BeautyFaceList.class.getName();
    private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bJB);
    private C41672h mCopyFrame1 = new C41672h();
    private C41672h mCopyFrame2 = new C41672h();
    private EyeLightenAndPounchFilter_573 mEyeLightenFilter = new EyeLightenAndPounchFilter_573();
    private C41672h mEyeLightenFrame = new C41672h();
    private FaceFeatureFilter_573 mFaceFeatureFilter = new FaceFeatureFilter_573();
    private C41672h mFaceFeatureFrame = new C41672h();
    private LightRemovePouchFilter_573 mLightRemovePouchFilter = new LightRemovePouchFilter_573();
    private C41672h mLightRemovePouchFrame = new C41672h();
    private C41672h mRemovePounchFrame = new C41672h();
    private float superSmooth = 0.25f;

    static {
        AppMethodBeat.m2504i(82012);
        AppMethodBeat.m2505o(82012);
    }

    public BeautyFaceList_573() {
        AppMethodBeat.m2504i(82000);
        AppMethodBeat.m2505o(82000);
    }

    public void initial() {
        AppMethodBeat.m2504i(82001);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.ApplyGLSLFilter();
        }
        if (this.mFaceFeatureFilter != null) {
            this.mFaceFeatureFilter.ApplyGLSLFilter();
        }
        if (this.mLightRemovePouchFilter != null) {
            this.mLightRemovePouchFilter.ApplyGLSLFilter();
        }
        this.mCopyFilter.ApplyGLSLFilter();
        AppMethodBeat.m2505o(82001);
    }

    public void setRemovePounchAlpha(float f) {
        AppMethodBeat.m2504i(82002);
        if (this.mLightRemovePouchFilter != null) {
            this.mLightRemovePouchFilter.setSmoothOpacity(f);
        }
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.setSmoothOpacity(Math.max(0.0f, Math.min(1.0f, f < this.superSmooth ? 0.0f : (1.0f / (1.0f - this.superSmooth)) * (f - this.superSmooth))));
        }
        AppMethodBeat.m2505o(82002);
    }

    public void setEyeLightenAlpha(float f) {
        AppMethodBeat.m2504i(82003);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.setAlphaValue(f);
        }
        AppMethodBeat.m2505o(82003);
    }

    public void setFaceFeatureParam(FaceFeatureParam faceFeatureParam) {
        AppMethodBeat.m2504i(82004);
        if (this.mFaceFeatureFilter != null) {
            this.mFaceFeatureFilter.setFaceFeatureParam(faceFeatureParam);
        }
        AppMethodBeat.m2505o(82004);
    }

    public void setContrastOpacity(float f) {
        AppMethodBeat.m2504i(82005);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.setContrastOpacity(f);
        }
        AppMethodBeat.m2505o(82005);
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.m2504i(82006);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.updateVideoSize(i, i2, d);
        }
        if (this.mFaceFeatureFilter != null) {
            this.mFaceFeatureFilter.updateVideoSize(i, i2, d);
        }
        if (this.mLightRemovePouchFilter != null) {
            this.mLightRemovePouchFilter.updateVideoSize(i, i2, d);
        }
        AppMethodBeat.m2505o(82006);
    }

    public C41672h render(C41672h c41672h, List<List<PointF>> list) {
        int i;
        AppMethodBeat.m2504i(82007);
        BenchUtil.benchStart("mBeautyFaceList mFaceFeatherFilter");
        if (this.mFaceFeatureFilter != null && this.mFaceFeatureFilter.needRender()) {
            this.mCopyFilter.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, this.mFaceFeatureFrame);
            for (i = 0; i < list.size(); i++) {
                this.mFaceFeatureFilter.updateParam((List) list.get(i));
                this.mFaceFeatureFilter.OnDrawFrameGLSL();
                this.mFaceFeatureFilter.renderTexture(c41672h.texture[0], c41672h.width, c41672h.height);
            }
            c41672h = this.mFaceFeatureFrame;
        }
        BenchUtil.benchEnd("mBeautyFaceList mFaceFeatherFilter");
        if (this.mLightRemovePouchFilter != null && this.mLightRemovePouchFilter.needRender()) {
            this.mCopyFilter.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, this.mLightRemovePouchFrame);
            for (i = 0; i < list.size(); i++) {
                this.mLightRemovePouchFilter.updateParam((List) list.get(i));
                this.mLightRemovePouchFilter.OnDrawFrameGLSL();
                this.mLightRemovePouchFilter.renderTexture(c41672h.texture[0], c41672h.width, c41672h.height);
            }
            c41672h = this.mLightRemovePouchFrame;
        }
        BenchUtil.benchStart("mBeautyFaceList mEyeLightenFilter");
        if (this.mEyeLightenFilter != null && this.mEyeLightenFilter.needRender()) {
            this.mCopyFilter.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, this.mEyeLightenFrame);
            for (i = 0; i < list.size(); i++) {
                this.mEyeLightenFilter.updateParam((List) list.get(i));
                this.mEyeLightenFilter.OnDrawFrameGLSL();
                this.mEyeLightenFilter.renderTexture(c41672h.texture[0], c41672h.width, c41672h.height);
            }
            c41672h = this.mEyeLightenFrame;
        }
        BenchUtil.benchEnd("mBeautyFaceList mEyeLightenFilter");
        AppMethodBeat.m2505o(82007);
        return c41672h;
    }

    public void clear() {
        AppMethodBeat.m2504i(82008);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.clearGLSLSelf();
        }
        if (this.mFaceFeatureFilter != null) {
            this.mFaceFeatureFilter.clearGLSLSelf();
        }
        if (this.mLightRemovePouchFilter != null) {
            this.mLightRemovePouchFilter.clearGLSLSelf();
        }
        this.mCopyFilter.ClearGLSL();
        this.mRemovePounchFrame.clear();
        this.mEyeLightenFrame.clear();
        this.mFaceFeatureFrame.clear();
        this.mLightRemovePouchFrame.clear();
        this.mCopyFrame1.clear();
        this.mCopyFrame2.clear();
        AppMethodBeat.m2505o(82008);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.m2504i(82009);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.setRenderMode(i);
        }
        if (this.mFaceFeatureFilter != null) {
            this.mFaceFeatureFilter.setRenderMode(i);
        }
        if (this.mLightRemovePouchFilter != null) {
            this.mLightRemovePouchFilter.setRenderMode(i);
        }
        this.mCopyFilter.setRenderMode(i);
        AppMethodBeat.m2505o(82009);
    }

    public void setToothWhitenAlpha(float f) {
        AppMethodBeat.m2504i(82010);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.setToothWhitenAlpha(f);
        }
        AppMethodBeat.m2505o(82010);
    }

    public void setNormalAlphaFactor(float f) {
        AppMethodBeat.m2504i(82011);
        if (this.mFaceFeatureFilter != null) {
            this.mFaceFeatureFilter.setNormalAlphaFactor(f);
        }
        AppMethodBeat.m2505o(82011);
    }
}
