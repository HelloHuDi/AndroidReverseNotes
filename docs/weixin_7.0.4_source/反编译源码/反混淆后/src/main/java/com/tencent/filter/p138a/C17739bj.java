package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.C44677k;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.bj */
public final class C17739bj extends BaseFilter {
    public C17739bj() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86517);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bLE);
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/nextdoor_center_curve.png", 33986));
        baseFilter.addParam(new C0936o("inputImageTexture3", "sh/nextdoor_center_curve_mask.png", 33987));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bLE);
        baseFilter2.addParam(new C0936o("inputImageTexture2", "sh/nextdoor_edge_curve.png", 33986));
        baseFilter2.addParam(new C0936o("inputImageTexture3", "sh/nextdoor_edge_curve_mask.png", 33987));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.0f, -0.08627451f, 0.0f};
        float[] fArr2 = new float[]{0.0f, 0.0f, 0.0f};
        baseFilter.addParam(new C0934g("shadowsShift", new float[]{0.0f, -0.05490196f, 0.101960786f}));
        baseFilter.addParam(new C0934g("midtonesShift", fArr));
        baseFilter.addParam(new C0934g("highlightsShift", fArr2));
        baseFilter.addParam(new C0935i("preserveLuminosity", 1));
        baseFilter2.setNextFilter(baseFilter, null);
        BaseFilter baseFilter3 = new BaseFilter(GLSLRender.bKI);
        baseFilter3.addParam(new C0934g("color2", new float[]{0.99215686f, 0.84705883f, 0.6392157f, 1.0f}));
        baseFilter3.addParam(new C0933f("transparency", 0.3f));
        baseFilter.setNextFilter(baseFilter3, null);
        C44677k c44677k = new C44677k();
        c44677k.mo71704a(1.0f, 20.0f, 0.0f, 335.0f, 352.0f, 16.0f, 28.0f);
        baseFilter3.setNextFilter(c44677k, null);
        baseFilter = new BaseFilter(GLSLRender.bJO);
        baseFilter.addParam(new C0933f("contrast", 1.1f));
        baseFilter.addParam(new C0933f("saturation", 1.0f));
        baseFilter.addParam(new C0933f("brightness", 1.0f));
        c44677k.setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86517);
    }
}
