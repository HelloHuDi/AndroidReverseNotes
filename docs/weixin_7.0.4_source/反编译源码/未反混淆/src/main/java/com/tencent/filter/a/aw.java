package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.f;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aw extends BaseFilter {
    public aw() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86504);
        k kVar = new k();
        kVar.a(0.0f, 10.0f, 0.0f, 329.0f, 349.0f, 13.0f, 32.0f);
        setNextFilter(kVar, null);
        k kVar2 = new k();
        kVar2.a(0.0f, -10.0f, -4.0f, 2.0f, 18.0f, 49.0f, 72.0f);
        kVar.setNextFilter(kVar2, null);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new o("inputImageTexture2", "sh/lightwhite_curve.png", 33986));
        kVar2.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bJO);
        baseFilter2.addParam(new f("contrast", 1.05f));
        baseFilter2.addParam(new f("saturation", 1.0f));
        baseFilter2.addParam(new f("brightness", 1.0f));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86504);
    }
}
