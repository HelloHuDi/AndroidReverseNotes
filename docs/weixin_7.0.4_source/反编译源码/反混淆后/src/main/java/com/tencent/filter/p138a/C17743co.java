package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.C44673b;
import com.tencent.filter.C44677k;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.co */
public final class C17743co extends BaseFilter {
    public C17743co() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86547);
        C44673b c44673b = new C44673b(GLSLRender.bJB, 0);
        c44673b.setEffectIndex(2);
        c44673b.setSrcFilterIndex(this.srcTextureIndex + 1);
        c44673b.ApplyGLSLFilter(z, f, f2);
        setNextFilter(c44673b, null);
        BaseFilter lastFilter = c44673b.getLastFilter();
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/tianmeizipai_curve.png", 33986));
        lastFilter.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr2 = new float[]{0.03137255f, 0.0f, 0.0f};
        baseFilter2.addParam(new C0934g("shadowsShift", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter2.addParam(new C0934g("midtonesShift", fArr));
        baseFilter2.addParam(new C0934g("highlightsShift", fArr2));
        baseFilter.setNextFilter(baseFilter2, null);
        C44677k c44677k = new C44677k();
        c44677k.mo71704a(0.0f, 3.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f);
        baseFilter2.setNextFilter(c44677k, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86547);
    }
}
