package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class av extends BaseFilter {
    public av() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86503);
        k kVar = new k();
        kVar.a(4.0f, 9.0f, -2.0f, 309.0f, 334.0f, 6.0f, 32.0f);
        setNextFilter(kVar, null);
        k kVar2 = new k();
        kVar2.a(0.0f, -17.0f, 4.0f, 338.0f, 16.0f, 61.0f, 93.0f);
        kVar.setNextFilter(kVar2, null);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new o("inputImageTexture2", "sh/lightred_curve.png", 33986));
        kVar2.setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86503);
    }
}
