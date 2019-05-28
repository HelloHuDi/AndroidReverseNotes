package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.C44677k;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.av */
public final class C32122av extends BaseFilter {
    public C32122av() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86503);
        C44677k c44677k = new C44677k();
        c44677k.mo71704a(4.0f, 9.0f, -2.0f, 309.0f, 334.0f, 6.0f, 32.0f);
        setNextFilter(c44677k, null);
        C44677k c44677k2 = new C44677k();
        c44677k2.mo71704a(0.0f, -17.0f, 4.0f, 338.0f, 16.0f, 61.0f, 93.0f);
        c44677k.setNextFilter(c44677k2, null);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/lightred_curve.png", 33986));
        c44677k2.setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86503);
    }
}
