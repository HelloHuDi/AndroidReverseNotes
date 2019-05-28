package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.C44677k;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.bf */
public final class C44658bf extends BaseFilter {
    public C44658bf() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86513);
        C44677k c44677k = new C44677k();
        c44677k.mo71704a(0.0f, -4.0f, 4.0f, 0.0f, 28.0f, 48.0f, 72.0f);
        setNextFilter(c44677k, null);
        C44677k c44677k2 = new C44677k();
        c44677k2.mo71704a(-5.039946f, 24.0f, 0.0f, 329.0f, 330.0f, 8.0f, 26.0f);
        c44677k.setNextFilter(c44677k2, null);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/milkgreen_curve.png", 33986));
        c44677k2.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bMf);
        baseFilter2.addParam(new C0934g("color2", new float[]{0.72156864f, 0.8784314f, 0.77254903f, 1.0f}));
        baseFilter2.addParam(new C0933f("transparency", 0.1f));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86513);
    }
}
