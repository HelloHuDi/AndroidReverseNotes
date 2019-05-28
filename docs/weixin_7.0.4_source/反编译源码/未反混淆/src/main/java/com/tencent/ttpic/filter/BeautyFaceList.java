package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
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
    private h mContrastFrame = new h();
    private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bJB);
    private h mCopyFrame1 = new h();
    private h mCopyFrame2 = new h();
    private EyeLightenAndPounchFilter mEyeLightenFilter = new EyeLightenAndPounchFilter();
    private h[] mEyeLightenFrame = new h[2];
    private double mFaceDetScale;
    private FaceFeatureFilter mFaceFeatureFilter = new FaceFeatureFilter();
    private h[] mFaceFeatureFrame = new h[2];
    private LightRemovePouchFilter mLightRemovePouchFilter = new LightRemovePouchFilter();
    private h[] mLightRemovePouchFrame = new h[2];
    private h mRemovePounchFrame = new h();
    private int width;

    static {
        AppMethodBeat.i(81988);
        AppMethodBeat.o(81988);
    }

    public BeautyFaceList() {
        int i;
        int i2 = 0;
        AppMethodBeat.i(81974);
        for (i = 0; i < this.mEyeLightenFrame.length; i++) {
            this.mEyeLightenFrame[i] = new h();
        }
        for (i = 0; i < this.mFaceFeatureFrame.length; i++) {
            this.mFaceFeatureFrame[i] = new h();
        }
        while (i2 < this.mLightRemovePouchFrame.length) {
            this.mLightRemovePouchFrame[i2] = new h();
            i2++;
        }
        AppMethodBeat.o(81974);
    }

    public void initial() {
        AppMethodBeat.i(81975);
        this.mEyeLightenFilter.ApplyGLSLFilter();
        this.mFaceFeatureFilter.ApplyGLSLFilter();
        this.mLightRemovePouchFilter.ApplyGLSLFilter();
        this.mContrastFilter.ApplyGLSLFilter();
        this.mCopyFilter.ApplyGLSLFilter();
        AppMethodBeat.o(81975);
    }

    public void setRemovePounchAlpha(float f) {
        AppMethodBeat.i(81976);
        this.mEyeLightenFilter.setSmoothOpacity(f);
        AppMethodBeat.o(81976);
    }

    public void setLightRemovePouchAlpha(float f) {
        AppMethodBeat.i(81977);
        this.mLightRemovePouchFilter.setSmoothOpacity(Math.min(1.0f, Math.max(0.0f, f / 0.9f)));
        AppMethodBeat.o(81977);
    }

    public void setEyeLightenAlpha(float f) {
        AppMethodBeat.i(81978);
        this.mEyeLightenFilter.setAlphaValue(f);
        AppMethodBeat.o(81978);
    }

    public void setFaceFeatureParam(FaceFeatureParam faceFeatureParam) {
        AppMethodBeat.i(81979);
        this.mFaceFeatureFilter.setFaceFeatureParam(faceFeatureParam);
        AppMethodBeat.o(81979);
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.i(81980);
        this.mEyeLightenFilter.updateVideoSize(i, i2, d);
        this.mFaceFeatureFilter.updateVideoSize(i, i2, d);
        this.mLightRemovePouchFilter.updateVideoSize(i, i2, d);
        this.width = i;
        this.height = i2;
        this.mFaceDetScale = d;
        AppMethodBeat.o(81980);
    }

    public h render(h hVar, List<List<PointF>> list) {
        Object obj;
        AppMethodBeat.i(81981);
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
            h[] hVarArr;
            h[] hVarArr2;
            List copyList = VideoMaterialUtil.copyList((List) list.get(i2));
            FaceOffUtil.initFacePositions(FaceOffUtil.getFullCoords(copyList, 2.0f), (int) (((double) this.width) * this.mFaceDetScale), (int) (((double) this.height) * this.mFaceDetScale), this.faceVertices);
            BenchUtil.benchStart("mBeautyFaceList mFaceFeatherFilter");
            if (this.mFaceFeatureFilter.needRender()) {
                baseFilter = this.mCopyFilter;
                i3 = hVar.texture[0];
                i4 = hVar.width;
                i5 = hVar.height;
                hVarArr = this.mFaceFeatureFrame;
                baseFilter.RenderProcess(i3, i4, i5, -1, 0.0d, hVarArr[i2 % hVarArr.length]);
                this.mFaceFeatureFilter.updateParam(this.faceVertices);
                this.mFaceFeatureFilter.OnDrawFrameGLSL();
                this.mFaceFeatureFilter.renderTexture(hVar.texture[0], hVar.width, hVar.height);
                hVarArr2 = this.mFaceFeatureFrame;
                hVar = hVarArr2[i2 % hVarArr2.length];
            }
            BenchUtil.benchEnd("mBeautyFaceList mFaceFeatherFilter");
            if (this.mLightRemovePouchFilter.needRender()) {
                baseFilter = this.mCopyFilter;
                i3 = hVar.texture[0];
                i4 = hVar.width;
                i5 = hVar.height;
                hVarArr = this.mLightRemovePouchFrame;
                baseFilter.RenderProcess(i3, i4, i5, -1, 0.0d, hVarArr[i2 % hVarArr.length]);
                this.mLightRemovePouchFilter.updateParam(this.faceVertices);
                this.mLightRemovePouchFilter.OnDrawFrameGLSL();
                this.mLightRemovePouchFilter.renderTexture(hVar.texture[0], hVar.width, hVar.height);
                hVarArr2 = this.mLightRemovePouchFrame;
                hVar = hVarArr2[i2 % hVarArr2.length];
            }
            BenchUtil.benchStart("mBeautyFaceList mEyeLightenFilter");
            if (this.mEyeLightenFilter.needRender()) {
                obj = 1;
                ContrastFilter contrastFilter = this.mContrastFilter;
                i3 = hVar.texture[0];
                i4 = hVar.width;
                i5 = hVar.height;
                hVarArr = this.mEyeLightenFrame;
                contrastFilter.RenderProcess(i3, i4, i5, -1, 0.0d, hVarArr[i2 % hVarArr.length]);
                this.mEyeLightenFilter.updateParam(copyList, this.faceVertices);
                this.mEyeLightenFilter.OnDrawFrameGLSL();
                this.mEyeLightenFilter.renderTexture(hVar.texture[0], hVar.width, hVar.height);
                h[] hVarArr3 = this.mEyeLightenFrame;
                hVar = hVarArr3[i2 % hVarArr3.length];
            }
            obj2 = obj;
            BenchUtil.benchEnd("mBeautyFaceList mEyeLightenFilter");
            i = i2 + 1;
        }
        if (obj == null && this.mContrastFilter.needRender()) {
            this.mContrastFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, this.mContrastFrame);
            hVar = this.mContrastFrame;
        }
        AppMethodBeat.o(81981);
        return hVar;
    }

    public void clear() {
        int i = 0;
        AppMethodBeat.i(81982);
        this.mEyeLightenFilter.clearGLSLSelf();
        this.mFaceFeatureFilter.clearGLSLSelf();
        this.mLightRemovePouchFilter.clearGLSLSelf();
        this.mContrastFilter.ClearGLSL();
        this.mRemovePounchFrame.clear();
        for (h hVar : this.mEyeLightenFrame) {
            if (hVar != null) {
                hVar.clear();
            }
        }
        for (h hVar2 : this.mFaceFeatureFrame) {
            if (hVar2 != null) {
                hVar2.clear();
            }
        }
        h[] hVarArr = this.mLightRemovePouchFrame;
        int length = hVarArr.length;
        while (i < length) {
            h hVar3 = hVarArr[i];
            if (hVar3 != null) {
                hVar3.clear();
            }
            i++;
        }
        this.mCopyFrame1.clear();
        this.mCopyFrame2.clear();
        this.mContrastFrame.clear();
        AppMethodBeat.o(81982);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.i(81983);
        this.mEyeLightenFilter.setRenderMode(i);
        this.mFaceFeatureFilter.setRenderMode(i);
        this.mLightRemovePouchFilter.setRenderMode(i);
        this.mContrastFilter.setRenderMode(i);
        this.mCopyFilter.setRenderMode(i);
        AppMethodBeat.o(81983);
    }

    public void setToothWhitenAlpha(float f) {
        AppMethodBeat.i(81984);
        this.mEyeLightenFilter.setToothWhitenAlpha(f);
        AppMethodBeat.o(81984);
    }

    public void setNormalAlphaFactor(float f) {
        AppMethodBeat.i(81985);
        this.mFaceFeatureFilter.setNormalAlphaFactor(f);
        AppMethodBeat.o(81985);
    }

    public void setLightRemovePouchSkinTexture(int i) {
        AppMethodBeat.i(81986);
        this.mLightRemovePouchFilter.setSkinTexture(i);
        AppMethodBeat.o(81986);
    }

    public void setContrastLevel(int i) {
        AppMethodBeat.i(81987);
        this.mContrastFilter.setContrastLevel(i);
        this.mEyeLightenFilter.setContrastLevel(i);
        AppMethodBeat.o(81987);
    }
}
