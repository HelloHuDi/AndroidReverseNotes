package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cd extends BaseFilter {
    public cd() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86537);
        k kVar = new k();
        kVar.a(7.0f, 16.0f, 9.0f, 332.0f, 347.0f, 11.0f, 29.0f);
        setNextFilter(kVar, null);
        k kVar2 = new k();
        kVar2.a(0.0f, -6.0f, 5.0f, 359.0f, 17.0f, 49.0f, 72.0f);
        kVar.setNextFilter(kVar2, null);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new o("inputImageTexture2", "sh/richyellow_curve.png", 33986));
        kVar2.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{-0.02745098f, 0.0f, 0.02745098f};
        float[] fArr2 = new float[]{0.023529412f, 0.011764706f, -0.02745098f};
        baseFilter2.addParam(new g("shadowsShift", new float[]{0.011764706f, 0.0f, -0.011764706f}));
        baseFilter2.addParam(new g("midtonesShift", fArr));
        baseFilter2.addParam(new g("highlightsShift", fArr2));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86537);
    }
}
