package com.tencent.filter.art;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class a extends BaseFilter {
    int bMY;
    String bMZ;
    float bNa;
    float bNb;
    float bNc;
    float bNd;
    float intensity;

    public final void setParameterDic(Map<String, Object> map) {
        AppMethodBeat.i(86281);
        if (map.containsKey("intensity")) {
            this.intensity = ((Float) map.get("intensity")).floatValue();
        }
        if (!(getmNextFilter() == null || getmNextFilter().getmNextFilter() == null)) {
            getmNextFilter().getmNextFilter().addParam(new f("intensity", this.intensity * 3.5f));
        }
        AppMethodBeat.o(86281);
    }

    public a(int i) {
        super(i);
        AppMethodBeat.i(86282);
        this.bMZ = null;
        this.bMZ = null;
        this.bMY = i;
        this.bNa = 0.3f;
        this.intensity = 0.5f;
        this.bNb = 0.0f;
        this.bNc = 0.12f;
        this.bNd = 0.02f;
        if (!(this.bMZ == null && this.bMY == GLSLRender.bJB)) {
            addParam(new o("inputImageTexture2", this.bMZ, 33986));
            addParam(new f("inputH", 0.0f));
            addParam(new f("inputS", 0.12f));
            addParam(new f("inputV", 0.02f));
        }
        AppMethodBeat.o(86282);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86283);
        if (IsFilterInvalute()) {
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.o(86283);
            return;
        }
        if (!z) {
            this.glsl_programID = GLSLRender.bJB;
            BaseFilter baseFilter = new BaseFilter(GLSLRender.bKR);
            baseFilter.addParam(new f("blurSize", this.bNa));
            setNextFilter(baseFilter, null);
            BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKS);
            baseFilter2.addParam(new f("blurSize", this.bNa));
            baseFilter2.addParam(new f("intensity", this.intensity * 3.5f));
            baseFilter.setNextFilter(baseFilter2, new int[]{this.srcTextureIndex + 1});
            if (!(this.bMZ == null && this.bMY == GLSLRender.bJB)) {
                baseFilter = new BaseFilter(this.bMY);
                baseFilter.addParam(new o("inputImageTexture2", this.bMZ, 33986));
                baseFilter.addParam(new f("inputH", this.bNb));
                baseFilter.addParam(new f("inputS", this.bNc));
                baseFilter.addParam(new f("inputV", this.bNd));
                baseFilter2.setNextFilter(baseFilter, null);
            }
        } else if (!(this.bMZ == null && this.bMY == GLSLRender.bJB)) {
            this.glsl_programID = this.bMY;
            addParam(new o("inputImageTexture2", this.bMZ, 33986));
            addParam(new f("inputH", this.bNb));
            addParam(new f("inputS", this.bNc));
            addParam(new f("inputV", this.bNd));
        }
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86283);
    }
}
