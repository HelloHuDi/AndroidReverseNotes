package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.C44677k;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.cl */
public final class C37333cl extends BaseFilter {
    public C37333cl() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86544);
        C44677k c44677k = new C44677k();
        c44677k.mo71704a(0.0f, -20.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f);
        setNextFilter(c44677k, null);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKF);
        baseFilter.addParam(new C0934g("color2", new float[]{0.09019608f, 0.06666667f, 0.06666667f, 1.0f}));
        baseFilter.addParam(new C0933f("transparency", 0.5f));
        c44677k.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKD);
        baseFilter2.addParam(new C0936o("inputImageTexture2", "sh/teamilk_curve2.png", 33986));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bKI);
        baseFilter.addParam(new C0934g("color2", new float[]{0.9411765f, 0.91764706f, 0.85490197f, 1.0f}));
        baseFilter.addParam(new C0933f("transparency", 1.0f));
        baseFilter2.setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86544);
    }
}
