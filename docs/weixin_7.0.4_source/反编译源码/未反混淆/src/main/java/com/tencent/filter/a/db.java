package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class db extends BaseFilter {
    public db() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86565);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new o("inputImageTexture2", "sh/young_curve.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.11764706f, -0.023529412f, 0.050980393f};
        float[] fArr2 = new float[]{-0.003921569f, 0.0f, 0.019607844f};
        baseFilter2.addParam(new g("shadowsShift", new float[]{0.07058824f, 0.0f, 0.0f}));
        baseFilter2.addParam(new g("midtonesShift", fArr));
        baseFilter2.addParam(new g("highlightsShift", fArr2));
        baseFilter.setNextFilter(baseFilter2, null);
        k kVar = new k();
        kVar.a(0.0f, 10.0f, 22.0f, 335.0f, 5.0f, 35.0f, 65.0f);
        baseFilter2.setNextFilter(kVar, null);
        k kVar2 = new k();
        kVar2.a(-6.0f, 2.0f, 10.0f, -1.0f, 0.0f, 0.0f, 0.0f);
        kVar.setNextFilter(kVar2, null);
        baseFilter = new BaseFilter(GLSLRender.bJO);
        baseFilter.addParam(new f("contrast", 1.05f));
        baseFilter.addParam(new f("saturation", 1.0f));
        baseFilter.addParam(new f("brightness", 1.0f));
        kVar2.setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86565);
    }
}
