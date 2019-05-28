package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.f;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ag extends BaseFilter {
    public ag() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86484);
        k kVar = new k();
        kVar.a(0.0f, -50.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f);
        setNextFilter(kVar, null);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new o("inputImageTexture2", "sh/glarefashion_curve.png", 33986));
        kVar.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bMg);
        baseFilter2.addParam(new o("inputImageTexture2", "sh/glarefashion_screen.png", 33986));
        baseFilter2.addParam(new f("transparency", 0.3f));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86484);
    }
}
