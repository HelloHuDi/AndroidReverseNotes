package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.z */
public final class C17752z extends BaseFilter {
    public C17752z() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86475);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKF);
        baseFilter.addParam(new C0934g("color2", new float[]{0.18039216f, 0.14901961f, 0.07450981f, 1.0f}));
        baseFilter.addParam(new C0933f("transparency", 1.0f));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr2 = new float[]{0.0f, 0.0f, 0.0f};
        baseFilter2.addParam(new C0934g("shadowsShift", new float[]{-0.023529412f, 0.105882354f, 0.0f}));
        baseFilter2.addParam(new C0934g("midtonesShift", fArr));
        baseFilter2.addParam(new C0934g("highlightsShift", fArr2));
        baseFilter2.addParam(new C0935i("preserveLuminosity", 1));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bLM);
        baseFilter.addParam(new C0934g("color2", new float[]{0.39607844f, 0.25490198f, 0.18431373f, 1.0f}));
        baseFilter.addParam(new C0933f("transparency", 0.87f));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bKG);
        fArr = new float[]{0.0f, 0.05490196f, 0.0f};
        fArr2 = new float[]{0.03137255f, 0.05490196f, -0.24313726f};
        baseFilter2.addParam(new C0934g("shadowsShift", new float[]{0.0f, 0.05490196f, 0.0f}));
        baseFilter2.addParam(new C0934g("midtonesShift", fArr));
        baseFilter2.addParam(new C0934g("highlightsShift", fArr2));
        baseFilter2.addParam(new C0935i("preserveLuminosity", 1));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bJO);
        baseFilter.addParam(new C0933f("contrast", 1.0f));
        baseFilter.addParam(new C0933f("saturation", 0.6f));
        baseFilter.addParam(new C0933f("brightness", 1.0f));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bKD);
        baseFilter2.addParam(new C0936o("inputImageTexture2", "sh/fugu_curve.png", 33986));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bKJ);
        baseFilter.addParam(new C0933f("inputH", 1.0f));
        baseFilter.addParam(new C0933f("inputS", 1.0f));
        baseFilter.addParam(new C0933f("inputV", 0.974f));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bKM);
        baseFilter2.addParam(new C0934g("color2", new float[]{0.9490196f, 0.9098039f, 0.8039216f, 1.0f}));
        baseFilter2.addParam(new C0933f("transparency", 0.5f));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86475);
    }
}
