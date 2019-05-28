package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;

public class BeautyFaceList {
    public static final String TAG = BeautyFaceList.class.getName();
    private float[] faceVertices = new float[1380];
    private int height;
    private ContrastFilter mContrastFilter = new ContrastFilter();
    private C41672h mContrastFrame = new C41672h();
    private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bJB);
    private C41672h mCopyFrame1 = new C41672h();
    private C41672h mCopyFrame2 = new C41672h();
    private EyeLightenAndPounchFilter mEyeLightenFilter = new EyeLightenAndPounchFilter();
    private C41672h[] mEyeLightenFrame = new C41672h[2];
    private double mFaceDetScale;
    private FaceFeatureFilter mFaceFeatureFilter = new FaceFeatureFilter();
    private C41672h[] mFaceFeatureFrame = new C41672h[2];
    private LightRemovePouchFilter mLightRemovePouchFilter = new LightRemovePouchFilter();
    private C41672h[] mLightRemovePouchFrame = new C41672h[2];
    private C41672h mRemovePounchFrame = new C41672h();
    private int width;

    static {
        AppMethodBeat.m2504i(81988);
        AppMethodBeat.m2505o(81988);
    }

    public BeautyFaceList() {
        int i;
        int i2 = 0;
        AppMethodBeat.m2504i(81974);
        for (i = 0; i < this.mEyeLightenFrame.length; i++) {
            this.mEyeLightenFrame[i] = new C41672h();
        }
        for (i = 0; i < this.mFaceFeatureFrame.length; i++) {
            this.mFaceFeatureFrame[i] = new C41672h();
        }
        while (i2 < this.mLightRemovePouchFrame.length) {
            this.mLightRemovePouchFrame[i2] = new C41672h();
            i2++;
        }
        AppMethodBeat.m2505o(81974);
    }

    public void initial() {
        AppMethodBeat.m2504i(81975);
        this.mEyeLightenFilter.ApplyGLSLFilter();
        this.mFaceFeatureFilter.ApplyGLSLFilter();
        this.mLightRemovePouchFilter.ApplyGLSLFilter();
        this.mContrastFilter.ApplyGLSLFilter();
        this.mCopyFilter.ApplyGLSLFilter();
        AppMethodBeat.m2505o(81975);
    }

    public void setRemovePounchAlpha(float f) {
        AppMethodBeat.m2504i(81976);
        this.mEyeLightenFilter.setSmoothOpacity(f);
        AppMethodBeat.m2505o(81976);
    }

    public void setLightRemovePouchAlpha(float f) {
        AppMethodBeat.m2504i(81977);
        this.mLightRemovePouchFilter.setSmoothOpacity(Math.min(1.0f, Math.max(0.0f, f / 0.9f)));
        AppMethodBeat.m2505o(81977);
    }

    public void setEyeLightenAlpha(float f) {
        AppMethodBeat.m2504i(81978);
        this.mEyeLightenFilter.setAlphaValue(f);
        AppMethodBeat.m2505o(81978);
    }

    public void setFaceFeatureParam(FaceFeatureParam faceFeatureParam) {
        AppMethodBeat.m2504i(81979);
        this.mFaceFeatureFilter.setFaceFeatureParam(faceFeatureParam);
        AppMethodBeat.m2505o(81979);
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.m2504i(81980);
        this.mEyeLightenFilter.updateVideoSize(i, i2, d);
        this.mFaceFeatureFilter.updateVideoSize(i, i2, d);
        this.mLightRemovePouchFilter.updateVideoSize(i, i2, d);
        this.width = i;
        this.height = i2;
        this.mFaceDetScale = d;
        AppMethodBeat.m2505o(81980);
    }

    public C41672h render(C41672h c41672h, List<List<PointF>> list) {
        Object obj;
        AppMethodBeat.m2504i(81981);
        Object obj2 = null;
        int i = 0;
        while (true) {
            int i2 = i;
            obj = obj2;
            if (i2 >= list.size()) {
                break;
            }
            BaseFilter baseFilter;
            int i3;
            int i4;
            int i5;
            C41672h[] c41672hArr;
            C41672h[] c41672hArr2;
            List copyList = VideoMaterialUtil.copyList((List) list.get(i2));
            FaceOffUtil.initFacePositions(FaceOffUtil.getFullCoords(copyList, 2.0f), (int) (((double) this.width) * this.mFaceDetScale), (int) (((double) this.height) * this.mFaceDetScale), this.faceVertices);
            BenchUtil.benchStart("mBeautyFaceList mFaceFeatherFilter");
            if (this.mFaceFeatureFilter.needRender()) {
                baseFilter = this.mCopyFilter;
                i3 = c41672h.texture[0];
                i4 = c41672h.width;
                i5 = c41672h.height;
                c41672hArr = this.mFaceFeatureFrame;
                baseFilter.RenderProcess(i3, i4, i5, -1, 0.0d, c41672hArr[i2 % c41672hArr.length]);
                this.mFaceFeatureFilter.updateParam(this.faceVertices);
                this.mFaceFeatureFilter.OnDrawFrameGLSL();
                this.mFaceFeatureFilter.renderTexture(c41672h.texture[0], c41672h.width, c41672h.height);
                c41672hArr2 = this.mFaceFeatureFrame;
                c41672h = c41672hArr2[i2 % c41672hArr2.length];
            }
            BenchUtil.benchEnd("mBeautyFaceList mFaceFeatherFilter");
            if (this.mLightRemovePouchFilter.needRender()) {
                baseFilter = this.mCopyFilter;
                i3 = c41672h.texture[0];
                i4 = c41672h.width;
                i5 = c41672h.height;
                c41672hArr = this.mLightRemovePouchFrame;
                baseFilter.RenderProcess(i3, i4, i5, -1, 0.0d, c41672hArr[i2 % c41672hArr.length]);
                this.mLightRemovePouchFilter.updateParam(this.faceVertices);
                this.mLightRemovePouchFilter.OnDrawFrameGLSL();
                this.mLightRemovePouchFilter.renderTexture(c41672h.texture[0], c41672h.width, c41672h.height);
                c41672hArr2 = this.mLightRemovePouchFrame;
                c41672h = c41672hArr2[i2 % c41672hArr2.length];
            }
            BenchUtil.benchStart("mBeautyFaceList mEyeLightenFilter");
            if (this.mEyeLightenFilter.needRender()) {
                obj = 1;
                ContrastFilter contrastFilter = this.mContrastFilter;
                i3 = c41672h.texture[0];
                i4 = c41672h.width;
                i5 = c41672h.height;
                c41672hArr = this.mEyeLightenFrame;
                contrastFilter.RenderProcess(i3, i4, i5, -1, 0.0d, c41672hArr[i2 % c41672hArr.length]);
                this.mEyeLightenFilter.updateParam(copyList, this.faceVertices);
                this.mEyeLightenFilter.OnDrawFrameGLSL();
                this.mEyeLightenFilter.renderTexture(c41672h.texture[0], c41672h.width, c41672h.height);
                C41672h[] c41672hArr3 = this.mEyeLightenFrame;
                c41672h = c41672hArr3[i2 % c41672hArr3.length];
            }
            obj2 = obj;
            BenchUtil.benchEnd("mBeautyFaceList mEyeLightenFilter");
            i = i2 + 1;
        }
        if (obj == null && this.mContrastFilter.needRender()) {
            this.mContrastFilter.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, this.mContrastFrame);
            c41672h = this.mContrastFrame;
        }
        AppMethodBeat.m2505o(81981);
        return c41672h;
    }

    public void clear() {
        int i = 0;
        AppMethodBeat.m2504i(81982);
        this.mEyeLightenFilter.clearGLSLSelf();
        this.mFaceFeatureFilter.clearGLSLSelf();
        this.mLightRemovePouchFilter.clearGLSLSelf();
        this.mContrastFilter.ClearGLSL();
        this.mRemovePounchFrame.clear();
        for (C41672h c41672h : this.mEyeLightenFrame) {
            if (c41672h != null) {
                c41672h.clear();
            }
        }
        for (C41672h c41672h2 : this.mFaceFeatureFrame) {
            if (c41672h2 != null) {
                c41672h2.clear();
            }
        }
        C41672h[] c41672hArr = this.mLightRemovePouchFrame;
        int length = c41672hArr.length;
        while (i < length) {
            C41672h c41672h3 = c41672hArr[i];
            if (c41672h3 != null) {
                c41672h3.clear();
            }
            i++;
        }
        this.mCopyFrame1.clear();
        this.mCopyFrame2.clear();
        this.mContrastFrame.clear();
        AppMethodBeat.m2505o(81982);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.m2504i(81983);
        this.mEyeLightenFilter.setRenderMode(i);
        this.mFaceFeatureFilter.setRenderMode(i);
        this.mLightRemovePouchFilter.setRenderMode(i);
        this.mContrastFilter.setRenderMode(i);
        this.mCopyFilter.setRenderMode(i);
        AppMethodBeat.m2505o(81983);
    }

    public void setToothWhitenAlpha(float f) {
        AppMethodBeat.m2504i(81984);
        this.mEyeLightenFilter.setToothWhitenAlpha(f);
        AppMethodBeat.m2505o(81984);
    }

    public void setNormalAlphaFactor(float f) {
        AppMethodBeat.m2504i(81985);
        this.mFaceFeatureFilter.setNormalAlphaFactor(f);
        AppMethodBeat.m2505o(81985);
    }

    public void setLightRemovePouchSkinTexture(int i) {
        AppMethodBeat.m2504i(81986);
        this.mLightRemovePouchFilter.setSkinTexture(i);
        AppMethodBeat.m2505o(81986);
    }

    public void setContrastLevel(int i) {
        AppMethodBeat.m2504i(81987);
        this.mContrastFilter.setContrastLevel(i);
        this.mEyeLightenFilter.setContrastLevel(i);
        AppMethodBeat.m2505o(81987);
    }
}
