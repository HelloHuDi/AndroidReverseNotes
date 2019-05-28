package com.tencent.filter;

import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.g;
import java.util.Map;

public final class j extends BaseFilter {
    float bMA = 0.3f;
    float bMB = 1.25f;
    float bMC = 0.001f;
    float bMD = 0.999f;
    private BaseFilter bME = null;
    private a bMF = null;
    float bMz = 25.0f;

    public static class a extends BaseFilter {
        float bMG = 1.0f;
        float bMz = 25.0f;
        int paramTEXTRUEID = 0;

        public a(float f) {
            super(GLSLRender.bKf);
            this.bMG = f;
        }

        public final void V(float f) {
            AppMethodBeat.i(86372);
            this.bMz = f;
            addParam(new f("strength", this.bMz));
            AppMethodBeat.o(86372);
        }

        public final void ApplyGLSLFilter(boolean z, float f, float f2) {
            AppMethodBeat.i(86373);
            this.paramTEXTRUEID = g.dSO();
            addParam(new f("strength", this.bMz));
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.o(86373);
        }

        public final void beforeRender(int i, int i2, int i3) {
            AppMethodBeat.i(86374);
            QImage aL = g.aL(i, i2, i3);
            QImage InplaceBlur8bitQImage = aL.InplaceBlur8bitQImage(1, (int) (80.0f * this.bMG));
            aL.Dispose();
            GLSLRender.nativeTextImage(InplaceBlur8bitQImage, this.paramTEXTRUEID);
            InplaceBlur8bitQImage.Dispose();
            AppMethodBeat.o(86374);
        }

        public final boolean renderTexture(int i, int i2, int i3) {
            AppMethodBeat.i(86375);
            setTextureParam(this.paramTEXTRUEID, 1);
            boolean renderTexture = super.renderTexture(i, i2, i3);
            AppMethodBeat.o(86375);
            return renderTexture;
        }

        public final void ClearGLSL() {
            AppMethodBeat.i(86376);
            g.Sk(this.paramTEXTRUEID);
            super.ClearGLSL();
            AppMethodBeat.o(86376);
        }
    }

    public j() {
        super(GLSLRender.bJB);
    }

    public final boolean isAdjustFilter() {
        return true;
    }

    public final void setAdjustParam(float f) {
        AppMethodBeat.i(86377);
        float max = Math.max((float) Math.min((double) f, 1.0d), 0.0f);
        this.bMz = 50.0f * max;
        this.bMA = max * 0.6f;
        if (this.bMF != null) {
            this.bMF.V(this.bMz);
        }
        if (this.bME != null) {
            this.bME.addParam(new f("sharpness", this.bMA));
        }
        AppMethodBeat.o(86377);
    }

    public final void setParameterDic(Map<String, Object> map) {
        AppMethodBeat.i(86378);
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
        AppMethodBeat.o(86378);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86379);
        this.glsl_programID = GLSLRender.bJB;
        float min = Math.min(f2, f);
        this.scaleFact = Math.min(100.0f / min, 1.0f);
        l lVar = new l(this.bMC, this.bMD);
        setNextFilter(lVar, new int[]{this.srcTextureIndex});
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKd);
        lVar.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bJB);
        baseFilter2.scaleFact = Math.min(400.0f / min, 1.0f);
        baseFilter.setNextFilter(baseFilter2, null);
        this.bMF = new a(baseFilter2.scaleFact);
        this.bMF.V(this.bMz);
        baseFilter2.setNextFilter(this.bMF, new int[]{this.srcTextureIndex + 3});
        a aVar = this.bMF;
        this.bME = new BaseFilter(GLSLRender.bMn, GLSLRender.bKi);
        this.bME.addParam(new f("sharpness", this.bMA));
        aVar.setNextFilter(this.bME, null);
        BaseFilter baseFilter3 = this.bME;
        baseFilter2 = new BaseFilter(GLSLRender.bKe);
        baseFilter3.setNextFilter(baseFilter2, null);
        baseFilter3 = new BaseFilter(GLSLRender.bKg);
        baseFilter3.addParam(new f("saturation", this.bMB));
        baseFilter2.setNextFilter(baseFilter3, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86379);
    }
}
