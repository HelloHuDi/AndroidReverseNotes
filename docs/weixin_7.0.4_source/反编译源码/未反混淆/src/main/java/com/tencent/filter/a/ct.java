package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ct extends BaseFilter {
    public ct() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86551);
        ab abVar = new ab();
        abVar.addParam(new o("inputImageTexture2", "sh/rixi2_lf.png", 33986));
        setNextFilter(abVar, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86551);
    }
}
