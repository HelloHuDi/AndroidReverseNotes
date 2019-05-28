package com.tencent.filter.art;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

/* renamed from: com.tencent.filter.art.a */
public final class C25623a extends BaseFilter {
    int bMY;
    String bMZ;
    float bNa;
    float bNb;
    float bNc;
    float bNd;
    float intensity;

    public final void setParameterDic(Map<String, Object> map) {
        AppMethodBeat.m2504i(86281);
        if (map.containsKey("intensity")) {
            this.intensity = ((Float) map.get("intensity")).floatValue();
        }
        if (!(getmNextFilter() == null || getmNextFilter().getmNextFilter() == null)) {
            getmNextFilter().getmNextFilter().addParam(new C0933f("intensity", this.intensity * 3.5f));
        }
        AppMethodBeat.m2505o(86281);
    }

    public C25623a(int i) {
        super(i);
        AppMethodBeat.m2504i(86282);
        this.bMZ = null;
        this.bMZ = null;
        this.bMY = i;
        this.bNa = 0.3f;
        this.intensity = 0.5f;
        this.bNb = 0.0f;
        this.bNc = 0.12f;
        this.bNd = 0.02f;
        if (!(this.bMZ == null && this.bMY == GLSLRender.bJB)) {
            addParam(new C0936o("inputImageTexture2", this.bMZ, 33986));
            addParam(new C0933f("inputH", 0.0f));
            addParam(new C0933f("inputS", 0.12f));
            addParam(new C0933f("inputV", 0.02f));
        }
        AppMethodBeat.m2505o(86282);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86283);
        if (IsFilterInvalute()) {
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.m2505o(86283);
            return;
        }
        if (!z) {
            this.glsl_programID = GLSLRender.bJB;
            BaseFilter baseFilter = new BaseFilter(GLSLRender.bKR);
            baseFilter.addParam(new C0933f("blurSize", this.bNa));
            setNextFilter(baseFilter, null);
            BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKS);
            baseFilter2.addParam(new C0933f("blurSize", this.bNa));
            baseFilter2.addParam(new C0933f("intensity", this.intensity * 3.5f));
            baseFilter.setNextFilter(baseFilter2, new int[]{this.srcTextureIndex + 1});
            if (!(this.bMZ == null && this.bMY == GLSLRender.bJB)) {
                baseFilter = new BaseFilter(this.bMY);
                baseFilter.addParam(new C0936o("inputImageTexture2", this.bMZ, 33986));
                baseFilter.addParam(new C0933f("inputH", this.bNb));
                baseFilter.addParam(new C0933f("inputS", this.bNc));
                baseFilter.addParam(new C0933f("inputV", this.bNd));
                baseFilter2.setNextFilter(baseFilter, null);
            }
        } else if (!(this.bMZ == null && this.bMY == GLSLRender.bJB)) {
            this.glsl_programID = this.bMY;
            addParam(new C0936o("inputImageTexture2", this.bMZ, 33986));
            addParam(new C0933f("inputH", this.bNb));
            addParam(new C0933f("inputS", this.bNc));
            addParam(new C0933f("inputV", this.bNd));
        }
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86283);
    }
}
