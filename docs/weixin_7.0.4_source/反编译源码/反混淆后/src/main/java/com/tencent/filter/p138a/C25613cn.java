package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.C44677k;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.cn */
public final class C25613cn extends BaseFilter {
    public C25613cn() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86546);
        C44677k c44677k = new C44677k();
        c44677k.mo71704a(0.0f, 27.0f, 0.0f, 316.0f, 340.0f, 0.0f, 24.0f);
        setNextFilter(c44677k, null);
        C44677k c44677k2 = new C44677k();
        c44677k2.mo71704a(-5.0f, 20.0f, 5.0f, 358.0f, 28.0f, 46.0f, 74.0f);
        c44677k.setNextFilter(c44677k2, null);
        c44677k = new C44677k();
        c44677k.mo71704a(20.0f, 0.0f, 0.0f, 68.0f, 90.0f, 124.0f, 140.0f);
        c44677k2.setNextFilter(c44677k, null);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.0f, 0.039215688f, 0.0f};
        float[] fArr2 = new float[]{-0.019607844f, 0.039215688f, 0.019607844f};
        baseFilter.addParam(new C0934g("shadowsShift", new float[]{0.05882353f, 0.039215688f, 0.0f}));
        baseFilter.addParam(new C0934g("midtonesShift", fArr));
        baseFilter.addParam(new C0934g("highlightsShift", fArr2));
        baseFilter.addParam(new C0935i("preserveLuminosity", 1));
        c44677k.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKD);
        baseFilter2.addParam(new C0936o("inputImageTexture2", "sh/thursday_curve.png", 33986));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86546);
    }
}
