package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.ap */
public final class C32118ap extends BaseFilter {
    public C32118ap() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86497);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr2 = new float[]{0.07450981f, 0.0f, -0.015686275f};
        baseFilter.addParam(new C0934g("shadowsShift", new float[]{-0.05882353f, 0.03529412f, -0.023529412f}));
        baseFilter.addParam(new C0934g("midtonesShift", fArr));
        baseFilter.addParam(new C0934g("highlightsShift", fArr2));
        baseFilter.addParam(new C0935i("preserveLuminosity", 1));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bLD);
        baseFilter2.addParam(new C0936o("inputImageTexture2", "sh/jiaopian.png", 33986));
        baseFilter2.addParam(new C0934g("channelvec", new float[]{0.0f, 1.0f, 0.0f}));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86497);
    }
}
