package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.C44677k;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.ax */
public final class C8772ax extends BaseFilter {
    public C8772ax() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86505);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKI);
        baseFilter.addParam(new C0934g("color2", new float[]{0.3882353f, 0.9490196f, 0.99607843f, 1.0f}));
        baseFilter.addParam(new C0933f("transparency", 0.18f));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{-0.0627451f, -0.007843138f, 0.03137255f};
        float[] fArr2 = new float[]{0.0f, -0.039215688f, 0.03137255f};
        baseFilter2.addParam(new C0934g("shadowsShift", new float[]{-0.039215688f, -0.047058824f, 0.03137255f}));
        baseFilter2.addParam(new C0934g("midtonesShift", fArr));
        baseFilter2.addParam(new C0934g("highlightsShift", fArr2));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(GLSLRender.bKD);
        baseFilter3.addParam(new C0936o("inputImageTexture2", "sh/lolly_curve.png", 33986));
        baseFilter2.setNextFilter(baseFilter3, null);
        C44677k c44677k = new C44677k();
        c44677k.mo71704a(7.0f, 30.0f, 0.0f, 306.0f, 336.0f, 6.0f, 36.0f);
        baseFilter3.setNextFilter(c44677k, null);
        C44677k c44677k2 = new C44677k();
        c44677k2.mo71704a(-14.0f, 24.0f, 0.0f, 169.0f, 180.0f, 229.0f, 259.0f);
        c44677k.setNextFilter(c44677k2, null);
        c44677k = new C44677k();
        c44677k.mo71704a(0.0f, 30.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f);
        c44677k2.setNextFilter(c44677k, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86505);
    }
}
