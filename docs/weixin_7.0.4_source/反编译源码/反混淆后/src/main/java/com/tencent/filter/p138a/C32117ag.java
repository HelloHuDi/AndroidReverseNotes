package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.C44677k;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.ag */
public final class C32117ag extends BaseFilter {
    public C32117ag() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86484);
        C44677k c44677k = new C44677k();
        c44677k.mo71704a(0.0f, -50.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f);
        setNextFilter(c44677k, null);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/glarefashion_curve.png", 33986));
        c44677k.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bMg);
        baseFilter2.addParam(new C0936o("inputImageTexture2", "sh/glarefashion_screen.png", 33986));
        baseFilter2.addParam(new C0933f("transparency", 0.3f));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86484);
    }
}
