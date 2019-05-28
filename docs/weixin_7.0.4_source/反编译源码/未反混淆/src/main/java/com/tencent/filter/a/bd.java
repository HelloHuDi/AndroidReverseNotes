package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bd extends BaseFilter {
    public bd() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86511);
        k kVar = new k();
        kVar.a(-3.0f, 40.0f, 10.0f, 316.0f, 348.0f, 10.0f, 45.0f);
        setNextFilter(kVar, null);
        k kVar2 = new k();
        kVar2.a(0.0f, 5.0f, 25.0f, 0.0f, 32.0f, 52.0f, 82.0f);
        kVar.setNextFilter(kVar2, null);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new o("inputImageTexture2", "sh/milkblue_curve.png", 33986));
        kVar2.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKM);
        baseFilter2.addParam(new g("color2", new float[]{0.7294118f, 0.8901961f, 0.99607843f, 1.0f}));
        baseFilter2.addParam(new f("transparency", 0.1f));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86511);
    }
}
