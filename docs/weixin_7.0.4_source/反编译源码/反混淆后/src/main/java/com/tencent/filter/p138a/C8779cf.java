package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.cf */
public final class C8779cf extends BaseFilter {
    public C8779cf() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86539);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/senlin_curve.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr2 = new float[]{0.047058824f, 0.0f, 0.0f};
        baseFilter2.addParam(new C0934g("shadowsShift", new float[]{-0.28627452f, 0.0f, 0.0f}));
        baseFilter2.addParam(new C0934g("midtonesShift", fArr));
        baseFilter2.addParam(new C0934g("highlightsShift", fArr2));
        baseFilter2.addParam(new C0935i("preserveLuminosity", 1));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bLO);
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/senlin_blend.png", 33986));
        baseFilter.addParam(new C0933f("transparency", 0.8f));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bLN);
        baseFilter2.addParam(new C0934g("color2", new float[]{0.011764706f, 0.32156864f, 0.30980393f, 1.0f}));
        baseFilter2.addParam(new C0933f("transparency", 1.0f));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86539);
    }
}
