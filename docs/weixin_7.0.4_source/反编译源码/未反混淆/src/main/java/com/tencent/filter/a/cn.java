package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cn extends BaseFilter {
    public cn() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86546);
        k kVar = new k();
        kVar.a(0.0f, 27.0f, 0.0f, 316.0f, 340.0f, 0.0f, 24.0f);
        setNextFilter(kVar, null);
        k kVar2 = new k();
        kVar2.a(-5.0f, 20.0f, 5.0f, 358.0f, 28.0f, 46.0f, 74.0f);
        kVar.setNextFilter(kVar2, null);
        kVar = new k();
        kVar.a(20.0f, 0.0f, 0.0f, 68.0f, 90.0f, 124.0f, 140.0f);
        kVar2.setNextFilter(kVar, null);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.0f, 0.039215688f, 0.0f};
        float[] fArr2 = new float[]{-0.019607844f, 0.039215688f, 0.019607844f};
        baseFilter.addParam(new g("shadowsShift", new float[]{0.05882353f, 0.039215688f, 0.0f}));
        baseFilter.addParam(new g("midtonesShift", fArr));
        baseFilter.addParam(new g("highlightsShift", fArr2));
        baseFilter.addParam(new i("preserveLuminosity", 1));
        kVar.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKD);
        baseFilter2.addParam(new o("inputImageTexture2", "sh/thursday_curve.png", 33986));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86546);
    }
}
