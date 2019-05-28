package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.C44677k;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.az */
public final class C8773az extends BaseFilter {
    public C8773az() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86507);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/medsea_curve.png", 33986));
        setNextFilter(baseFilter, null);
        C44677k c44677k = new C44677k();
        c44677k.mo71704a(-3.0f, 21.0f, 6.0f, 299.0f, 329.0f, 359.0f, 29.0f);
        baseFilter.setNextFilter(c44677k, null);
        C44677k c44677k2 = new C44677k();
        c44677k2.mo71704a(-6.0f, 1.0f, 8.0f, -1.0f, 0.0f, 0.0f, 0.0f);
        c44677k.setNextFilter(c44677k2, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.07058824f, 0.0f, 0.0f};
        float[] fArr2 = new float[]{0.0f, 0.0f, 0.0f};
        baseFilter2.addParam(new C0934g("shadowsShift", new float[]{0.09803922f, 0.09019608f, 0.06666667f}));
        baseFilter2.addParam(new C0934g("midtonesShift", fArr));
        baseFilter2.addParam(new C0934g("highlightsShift", fArr2));
        c44677k2.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86507);
    }
}
