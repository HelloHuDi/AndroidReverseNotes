package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class az extends BaseFilter {
    public az() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86507);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new o("inputImageTexture2", "sh/medsea_curve.png", 33986));
        setNextFilter(baseFilter, null);
        k kVar = new k();
        kVar.a(-3.0f, 21.0f, 6.0f, 299.0f, 329.0f, 359.0f, 29.0f);
        baseFilter.setNextFilter(kVar, null);
        k kVar2 = new k();
        kVar2.a(-6.0f, 1.0f, 8.0f, -1.0f, 0.0f, 0.0f, 0.0f);
        kVar.setNextFilter(kVar2, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.07058824f, 0.0f, 0.0f};
        float[] fArr2 = new float[]{0.0f, 0.0f, 0.0f};
        baseFilter2.addParam(new g("shadowsShift", new float[]{0.09803922f, 0.09019608f, 0.06666667f}));
        baseFilter2.addParam(new g("midtonesShift", fArr));
        baseFilter2.addParam(new g("highlightsShift", fArr2));
        kVar2.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86507);
    }
}
