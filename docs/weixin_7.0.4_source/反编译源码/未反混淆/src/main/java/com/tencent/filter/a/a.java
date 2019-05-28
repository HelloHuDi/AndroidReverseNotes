package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends BaseFilter {
    public a() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86428);
        if (z) {
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.o(86428);
            return;
        }
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bMy, GLSLRender.bLJ);
        baseFilter.addParam(new f("sharpness", 0.2f));
        baseFilter.addParam(new f("inputH", 1.0f));
        baseFilter.addParam(new f("inputS", 1.2f));
        baseFilter.addParam(new f("inputV", 1.0f));
        baseFilter.addParam(new f("imageWidthFactor", 1.0f / f));
        baseFilter.addParam(new f("imageHeightFactor", 1.0f / f2));
        setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86428);
    }
}
