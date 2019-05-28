package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.f */
public final class C32129f extends BaseFilter {
    public C32129f() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86439);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bJO);
        baseFilter.addParam(new C0933f("contrast", 1.0f));
        baseFilter.addParam(new C0933f("saturation", 0.0f));
        baseFilter.addParam(new C0933f("brightness", 1.0f));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKF);
        baseFilter2.addParam(new C0934g("color2", new float[]{0.0627451f, 0.07058824f, 0.09019608f, 1.0f}));
        baseFilter2.addParam(new C0933f("transparency", 1.0f));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bKI);
        baseFilter.addParam(new C0934g("color2", new float[]{0.9098039f, 0.87058824f, 0.85882354f, 1.0f}));
        baseFilter.addParam(new C0933f("transparency", 0.55f));
        baseFilter2.setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86439);
    }
}
