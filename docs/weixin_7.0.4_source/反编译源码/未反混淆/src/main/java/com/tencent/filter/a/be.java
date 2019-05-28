package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class be extends BaseFilter {
    public be() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86512);
        k kVar = new k();
        kVar.a(3.0f, 40.0f, 3.0f, 329.0f, 352.0f, 10.0f, 35.0f);
        setNextFilter(kVar, null);
        k kVar2 = new k();
        kVar2.a(-5.0f, 5.0f, 10.0f, 6.0f, 32.0f, 52.0f, 82.0f);
        kVar.setNextFilter(kVar2, null);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new o("inputImageTexture2", "sh/milkcoffee_curve.png", 33986));
        kVar2.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bMf);
        baseFilter2.addParam(new g("color2", new float[]{0.7294118f, 0.5372549f, 0.5058824f, 1.0f}));
        baseFilter2.addParam(new f("transparency", 0.1f));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.0f, 0.0f, -0.023529412f};
        float[] fArr2 = new float[]{-0.007843138f, 0.0f, 0.0f};
        baseFilter.addParam(new g("shadowsShift", new float[]{0.0f, 0.0f, -0.023529412f}));
        baseFilter.addParam(new g("midtonesShift", fArr));
        baseFilter.addParam(new g("highlightsShift", fArr2));
        baseFilter2.setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86512);
    }
}
