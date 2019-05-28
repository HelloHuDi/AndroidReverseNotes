package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.C44677k;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.db */
public final class C8782db extends BaseFilter {
    public C8782db() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86565);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/young_curve.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.11764706f, -0.023529412f, 0.050980393f};
        float[] fArr2 = new float[]{-0.003921569f, 0.0f, 0.019607844f};
        baseFilter2.addParam(new C0934g("shadowsShift", new float[]{0.07058824f, 0.0f, 0.0f}));
        baseFilter2.addParam(new C0934g("midtonesShift", fArr));
        baseFilter2.addParam(new C0934g("highlightsShift", fArr2));
        baseFilter.setNextFilter(baseFilter2, null);
        C44677k c44677k = new C44677k();
        c44677k.mo71704a(0.0f, 10.0f, 22.0f, 335.0f, 5.0f, 35.0f, 65.0f);
        baseFilter2.setNextFilter(c44677k, null);
        C44677k c44677k2 = new C44677k();
        c44677k2.mo71704a(-6.0f, 2.0f, 10.0f, -1.0f, 0.0f, 0.0f, 0.0f);
        c44677k.setNextFilter(c44677k2, null);
        baseFilter = new BaseFilter(GLSLRender.bJO);
        baseFilter.addParam(new C0933f("contrast", 1.05f));
        baseFilter.addParam(new C0933f("saturation", 1.0f));
        baseFilter.addParam(new C0933f("brightness", 1.0f));
        c44677k2.setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86565);
    }
}
