package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.at */
public final class C32120at extends BaseFilter {
    public C32120at() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86501);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/lantuise.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bLF);
        baseFilter2.addParam(new C0933f("inputH", 1.0f));
        baseFilter2.addParam(new C0933f("inputS", 1.0f));
        baseFilter2.addParam(new C0933f("inputV", 1.0914f));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr2 = new float[]{-0.15152942f, 0.0f, 0.08293334f};
        baseFilter.addParam(new C0934g("shadowsShift", new float[]{0.0f, 0.0f, 0.064941175f}));
        baseFilter.addParam(new C0934g("midtonesShift", fArr));
        baseFilter.addParam(new C0934g("highlightsShift", fArr2));
        baseFilter.addParam(new C0935i("preserveLuminosity", 1));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bKE);
        baseFilter2.addParam(new C0933f("scaleC", -0.14400002f));
        baseFilter2.addParam(new C0933f("scaleT", 0.0f));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bKF);
        baseFilter.addParam(new C0934g("color2", new float[]{0.54901963f, 0.654902f, 0.69803923f, 1.0f}));
        baseFilter.addParam(new C0933f("transparency", 0.15f));
        baseFilter2.setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86501);
    }
}
