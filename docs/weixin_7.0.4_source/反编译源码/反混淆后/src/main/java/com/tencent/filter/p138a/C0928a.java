package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.a */
public final class C0928a extends BaseFilter {
    public C0928a() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86428);
        if (z) {
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.m2505o(86428);
            return;
        }
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bMy, GLSLRender.bLJ);
        baseFilter.addParam(new C0933f("sharpness", 0.2f));
        baseFilter.addParam(new C0933f("inputH", 1.0f));
        baseFilter.addParam(new C0933f("inputS", 1.2f));
        baseFilter.addParam(new C0933f("inputV", 1.0f));
        baseFilter.addParam(new C0933f("imageWidthFactor", 1.0f / f));
        baseFilter.addParam(new C0933f("imageHeightFactor", 1.0f / f2));
        setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86428);
    }
}
