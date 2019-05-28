package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.ar */
public final class C0930ar extends BaseFilter {
    public C0930ar() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86499);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.0f, 0.0f, -0.05882353f};
        float[] fArr2 = new float[]{0.0f, 0.0f, 0.0f};
        baseFilter.addParam(new C0934g("shadowsShift", new float[]{0.039215688f, 0.039215688f, 0.0f}));
        baseFilter.addParam(new C0934g("midtonesShift", fArr));
        baseFilter.addParam(new C0934g("highlightsShift", fArr2));
        baseFilter.addParam(new C0935i("preserveLuminosity", 1));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bLF);
        baseFilter2.addParam(new C0933f("inputH", 1.0f));
        baseFilter2.addParam(new C0933f("inputS", 1.0f));
        baseFilter2.addParam(new C0933f("inputV", 1.02f));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bJO);
        baseFilter.addParam(new C0933f("contrast", 1.0f));
        baseFilter.addParam(new C0933f("saturation", 1.25f));
        baseFilter.addParam(new C0933f("brightness", 1.0f));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bKD);
        baseFilter2.addParam(new C0936o("inputImageTexture2", "sh/jingwu_saturation_curve.png", 33986));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86499);
    }
}
