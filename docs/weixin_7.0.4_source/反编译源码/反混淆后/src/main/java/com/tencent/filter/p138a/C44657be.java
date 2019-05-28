package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.C44677k;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.be */
public final class C44657be extends BaseFilter {
    public C44657be() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86512);
        C44677k c44677k = new C44677k();
        c44677k.mo71704a(3.0f, 40.0f, 3.0f, 329.0f, 352.0f, 10.0f, 35.0f);
        setNextFilter(c44677k, null);
        C44677k c44677k2 = new C44677k();
        c44677k2.mo71704a(-5.0f, 5.0f, 10.0f, 6.0f, 32.0f, 52.0f, 82.0f);
        c44677k.setNextFilter(c44677k2, null);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/milkcoffee_curve.png", 33986));
        c44677k2.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bMf);
        baseFilter2.addParam(new C0934g("color2", new float[]{0.7294118f, 0.5372549f, 0.5058824f, 1.0f}));
        baseFilter2.addParam(new C0933f("transparency", 0.1f));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.0f, 0.0f, -0.023529412f};
        float[] fArr2 = new float[]{-0.007843138f, 0.0f, 0.0f};
        baseFilter.addParam(new C0934g("shadowsShift", new float[]{0.0f, 0.0f, -0.023529412f}));
        baseFilter.addParam(new C0934g("midtonesShift", fArr));
        baseFilter.addParam(new C0934g("highlightsShift", fArr2));
        baseFilter2.setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86512);
    }
}
