package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.C44677k;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.cd */
public final class C25611cd extends BaseFilter {
    public C25611cd() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86537);
        C44677k c44677k = new C44677k();
        c44677k.mo71704a(7.0f, 16.0f, 9.0f, 332.0f, 347.0f, 11.0f, 29.0f);
        setNextFilter(c44677k, null);
        C44677k c44677k2 = new C44677k();
        c44677k2.mo71704a(0.0f, -6.0f, 5.0f, 359.0f, 17.0f, 49.0f, 72.0f);
        c44677k.setNextFilter(c44677k2, null);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/richyellow_curve.png", 33986));
        c44677k2.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{-0.02745098f, 0.0f, 0.02745098f};
        float[] fArr2 = new float[]{0.023529412f, 0.011764706f, -0.02745098f};
        baseFilter2.addParam(new C0934g("shadowsShift", new float[]{0.011764706f, 0.0f, -0.011764706f}));
        baseFilter2.addParam(new C0934g("midtonesShift", fArr));
        baseFilter2.addParam(new C0934g("highlightsShift", fArr2));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86537);
    }
}
