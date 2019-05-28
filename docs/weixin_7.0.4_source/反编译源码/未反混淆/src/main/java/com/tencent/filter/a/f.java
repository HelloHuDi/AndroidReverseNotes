package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f extends BaseFilter {
    public f() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86439);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bJO);
        baseFilter.addParam(new com.tencent.filter.m.f("contrast", 1.0f));
        baseFilter.addParam(new com.tencent.filter.m.f("saturation", 0.0f));
        baseFilter.addParam(new com.tencent.filter.m.f("brightness", 1.0f));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKF);
        baseFilter2.addParam(new g("color2", new float[]{0.0627451f, 0.07058824f, 0.09019608f, 1.0f}));
        baseFilter2.addParam(new com.tencent.filter.m.f("transparency", 1.0f));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bKI);
        baseFilter.addParam(new g("color2", new float[]{0.9098039f, 0.87058824f, 0.85882354f, 1.0f}));
        baseFilter.addParam(new com.tencent.filter.m.f("transparency", 0.55f));
        baseFilter2.setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86439);
    }
}
