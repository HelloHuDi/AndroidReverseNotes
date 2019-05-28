package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.C44677k;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.bd */
public final class C17738bd extends BaseFilter {
    public C17738bd() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86511);
        C44677k c44677k = new C44677k();
        c44677k.mo71704a(-3.0f, 40.0f, 10.0f, 316.0f, 348.0f, 10.0f, 45.0f);
        setNextFilter(c44677k, null);
        C44677k c44677k2 = new C44677k();
        c44677k2.mo71704a(0.0f, 5.0f, 25.0f, 0.0f, 32.0f, 52.0f, 82.0f);
        c44677k.setNextFilter(c44677k2, null);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/milkblue_curve.png", 33986));
        c44677k2.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKM);
        baseFilter2.addParam(new C0934g("color2", new float[]{0.7294118f, 0.8901961f, 0.99607843f, 1.0f}));
        baseFilter2.addParam(new C0933f("transparency", 0.1f));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86511);
    }
}
