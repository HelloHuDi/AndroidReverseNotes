package com.tencent.filter;

import com.tencent.filter.C25624m.C0933f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C41106g;
import java.util.Map;

/* renamed from: com.tencent.filter.j */
public final class C44675j extends BaseFilter {
    float bMA = 0.3f;
    float bMB = 1.25f;
    float bMC = 0.001f;
    float bMD = 0.999f;
    private BaseFilter bME = null;
    private C44676a bMF = null;
    float bMz = 25.0f;

    /* renamed from: com.tencent.filter.j$a */
    public static class C44676a extends BaseFilter {
        float bMG = 1.0f;
        float bMz = 25.0f;
        int paramTEXTRUEID = 0;

        public C44676a(float f) {
            super(GLSLRender.bKf);
            this.bMG = f;
        }

        /* renamed from: V */
        public final void mo71703V(float f) {
            AppMethodBeat.m2504i(86372);
            this.bMz = f;
            addParam(new C0933f("strength", this.bMz));
            AppMethodBeat.m2505o(86372);
        }

        public final void ApplyGLSLFilter(boolean z, float f, float f2) {
            AppMethodBeat.m2504i(86373);
            this.paramTEXTRUEID = C41106g.dSO();
            addParam(new C0933f("strength", this.bMz));
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.m2505o(86373);
        }

        public final void beforeRender(int i, int i2, int i3) {
            AppMethodBeat.m2504i(86374);
            QImage aL = C41106g.m71542aL(i, i2, i3);
            QImage InplaceBlur8bitQImage = aL.InplaceBlur8bitQImage(1, (int) (80.0f * this.bMG));
            aL.Dispose();
            GLSLRender.nativeTextImage(InplaceBlur8bitQImage, this.paramTEXTRUEID);
            InplaceBlur8bitQImage.Dispose();
            AppMethodBeat.m2505o(86374);
        }

        public final boolean renderTexture(int i, int i2, int i3) {
            AppMethodBeat.m2504i(86375);
            setTextureParam(this.paramTEXTRUEID, 1);
            boolean renderTexture = super.renderTexture(i, i2, i3);
            AppMethodBeat.m2505o(86375);
            return renderTexture;
        }

        public final void ClearGLSL() {
            AppMethodBeat.m2504i(86376);
            C41106g.m71538Sk(this.paramTEXTRUEID);
            super.ClearGLSL();
            AppMethodBeat.m2505o(86376);
        }
    }

    public C44675j() {
        super(GLSLRender.bJB);
    }

    public final boolean isAdjustFilter() {
        return true;
    }

    public final void setAdjustParam(float f) {
        AppMethodBeat.m2504i(86377);
        float max = Math.max((float) Math.min((double) f, 1.0d), 0.0f);
        this.bMz = 50.0f * max;
        this.bMA = max * 0.6f;
        if (this.bMF != null) {
            this.bMF.mo71703V(this.bMz);
        }
        if (this.bME != null) {
            this.bME.addParam(new C0933f("sharpness", this.bMA));
        }
        AppMethodBeat.m2505o(86377);
    }

    public final void setParameterDic(Map<String, Object> map) {
        AppMethodBeat.m2504i(86378);
        if (map.containsKey("stretechMag")) {
            this.bMz = ((Float) map.get("stretechMag")).floatValue();
        }
        if (map.containsKey("sharpnessMag")) {
            this.bMA = ((Float) map.get("sharpnessMag")).floatValue();
        }
        if (map.containsKey("saturationMag")) {
            this.bMB = ((Float) map.get("saturationMag")).floatValue();
        }
        if (map.containsKey("percent")) {
            this.bMC = ((Float) map.get("percent")).floatValue();
            this.bMD = 1.0f - this.bMC;
        }
        AppMethodBeat.m2505o(86378);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86379);
        this.glsl_programID = GLSLRender.bJB;
        float min = Math.min(f2, f);
        this.scaleFact = Math.min(100.0f / min, 1.0f);
        C17757l c17757l = new C17757l(this.bMC, this.bMD);
        setNextFilter(c17757l, new int[]{this.srcTextureIndex});
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKd);
        c17757l.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bJB);
        baseFilter2.scaleFact = Math.min(400.0f / min, 1.0f);
        baseFilter.setNextFilter(baseFilter2, null);
        this.bMF = new C44676a(baseFilter2.scaleFact);
        this.bMF.mo71703V(this.bMz);
        baseFilter2.setNextFilter(this.bMF, new int[]{this.srcTextureIndex + 3});
        C44676a c44676a = this.bMF;
        this.bME = new BaseFilter(GLSLRender.bMn, GLSLRender.bKi);
        this.bME.addParam(new C0933f("sharpness", this.bMA));
        c44676a.setNextFilter(this.bME, null);
        BaseFilter baseFilter3 = this.bME;
        baseFilter2 = new BaseFilter(GLSLRender.bKe);
        baseFilter3.setNextFilter(baseFilter2, null);
        baseFilter3 = new BaseFilter(GLSLRender.bKg);
        baseFilter3.addParam(new C0933f("saturation", this.bMB));
        baseFilter2.setNextFilter(baseFilter3, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86379);
    }
}
