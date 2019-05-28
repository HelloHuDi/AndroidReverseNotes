package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.C44677k;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.aw */
public final class C32123aw extends BaseFilter {
    public C32123aw() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86504);
        C44677k c44677k = new C44677k();
        c44677k.mo71704a(0.0f, 10.0f, 0.0f, 329.0f, 349.0f, 13.0f, 32.0f);
        setNextFilter(c44677k, null);
        C44677k c44677k2 = new C44677k();
        c44677k2.mo71704a(0.0f, -10.0f, -4.0f, 2.0f, 18.0f, 49.0f, 72.0f);
        c44677k.setNextFilter(c44677k2, null);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/lightwhite_curve.png", 33986));
        c44677k2.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bJO);
        baseFilter2.addParam(new C0933f("contrast", 1.05f));
        baseFilter2.addParam(new C0933f("saturation", 1.0f));
        baseFilter2.addParam(new C0933f("brightness", 1.0f));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86504);
    }
}
