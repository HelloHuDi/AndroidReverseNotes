package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.ad */
public final class C44656ad extends BaseFilter {
    public C44656ad() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86479);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/gaoleng_curve.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{-0.14901961f, 0.0f, 0.08627451f};
        float[] fArr2 = new float[]{-0.019607844f, 0.019607844f, 0.05882353f};
        baseFilter2.addParam(new C0934g("shadowsShift", new float[]{-0.22352941f, 0.039215688f, 0.08627451f}));
        baseFilter2.addParam(new C0934g("midtonesShift", fArr));
        baseFilter2.addParam(new C0934g("highlightsShift", fArr2));
        baseFilter2.addParam(new C0935i("preserveLuminosity", 1));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bLN);
        baseFilter.addParam(new C0934g("color2", new float[]{0.06666667f, 0.6f, 0.8745098f, 1.0f}));
        baseFilter.addParam(new C0933f("transparency", 0.7f));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bKE);
        baseFilter2.addParam(new C0933f("scaleC", -0.07500002f));
        baseFilter2.addParam(new C0933f("scaleT", 0.0f));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bJO);
        baseFilter.addParam(new C0933f("contrast", 1.13f));
        baseFilter.addParam(new C0933f("saturation", 1.0f));
        baseFilter.addParam(new C0933f("brightness", 1.0f));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bLF);
        baseFilter2.addParam(new C0933f("inputH", 1.0f));
        baseFilter2.addParam(new C0933f("inputS", 1.0f));
        baseFilter2.addParam(new C0933f("inputV", 0.98f));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86479);
    }
}
