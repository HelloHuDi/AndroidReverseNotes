package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.C44677k;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.ay */
public final class C25606ay extends BaseFilter {
    public C25606ay() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86506);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKM);
        baseFilter.addParam(new C0934g("color2", new float[]{0.93333334f, 0.67058825f, 0.89411765f, 1.0f}));
        baseFilter.addParam(new C0933f("transparency", 0.3f));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bLZ);
        baseFilter2.addParam(new C0934g("color2", new float[]{0.89411765f, 0.63529414f, 0.22352941f, 1.0f}));
        baseFilter2.addParam(new C0933f("transparency", 0.1f));
        baseFilter.setNextFilter(baseFilter2, null);
        C44677k c44677k = new C44677k();
        c44677k.mo71704a(0.0f, 5.0f, 1.0f, 310.0f, 340.0f, 10.0f, 40.0f);
        baseFilter2.setNextFilter(c44677k, null);
        C44677k c44677k2 = new C44677k();
        c44677k2.mo71704a(0.0f, -22.0f, 15.0f, 355.0f, 18.0f, 58.0f, 79.0f);
        c44677k.setNextFilter(c44677k2, null);
        baseFilter = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr2 = new float[]{0.0f, -0.047058824f, -0.047058824f};
        baseFilter.addParam(new C0934g("shadowsShift", new float[]{-0.02745098f, -0.05490196f, 0.0f}));
        baseFilter.addParam(new C0934g("midtonesShift", fArr));
        baseFilter.addParam(new C0934g("highlightsShift", fArr2));
        c44677k2.setNextFilter(baseFilter, null);
        BaseFilter baseFilter3 = new BaseFilter(GLSLRender.bKD);
        baseFilter3.addParam(new C0936o("inputImageTexture2", "sh/maplered_curve.png", 33986));
        baseFilter.setNextFilter(baseFilter3, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86506);
    }
}
