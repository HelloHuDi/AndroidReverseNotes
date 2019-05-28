package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.f;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class af extends BaseFilter {
    public af() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86483);
        k kVar = new k();
        kVar.a(0.0f, -10.0f, 25.0f, 339.0f, 9.0f, 39.0f, 69.0f);
        setNextFilter(kVar, null);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new o("inputImageTexture2", "sh/andy_gradient_curve.png", 33986));
        kVar.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKD);
        baseFilter2.addParam(new o("inputImageTexture2", "sh/andy_curve.png", 33986));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bKN);
        baseFilter.addParam(new f("exposure", 0.305f));
        baseFilter2.setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86483);
    }
}
