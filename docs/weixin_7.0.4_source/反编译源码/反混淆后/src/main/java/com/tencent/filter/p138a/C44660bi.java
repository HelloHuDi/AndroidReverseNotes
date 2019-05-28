package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.bi */
public final class C44660bi extends BaseFilter {
    public C44660bi() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86516);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bJO);
        baseFilter.addParam(new C0933f("contrast", 1.0f));
        baseFilter.addParam(new C0933f("saturation", 0.5f));
        baseFilter.addParam(new C0933f("brightness", 1.0f));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKD);
        baseFilter2.addParam(new C0936o("inputImageTexture2", "sh/heibai4_Curve.png", 33986));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bKI);
        baseFilter.addParam(new C0934g("color2", new float[]{0.84705883f, 0.8f, 0.74509805f, 1.0f}));
        baseFilter.addParam(new C0933f("transparency", 1.0f));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bKF);
        baseFilter2.addParam(new C0934g("color2", new float[]{0.09019608f, 0.06666667f, 0.06666667f, 1.0f}));
        baseFilter2.addParam(new C0933f("transparency", 1.0f));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bLO);
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/heibai4_blend.png", 33986));
        baseFilter.addParam(new C0933f("transparency", 0.8f));
        baseFilter2.setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86516);
    }
}
