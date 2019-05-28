package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.w */
public final class C44670w extends BaseFilter {
    public C44670w() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86472);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr2 = new float[]{0.03137255f, -0.015882352f, 0.0f};
        baseFilter.addParam(new C0934g("shadowsShift", new float[]{0.0f, -0.06411765f, 0.03137255f}));
        baseFilter.addParam(new C0934g("midtonesShift", fArr));
        baseFilter.addParam(new C0934g("highlightsShift", fArr2));
        baseFilter.addParam(new C0935i("preserveLuminosity", 1));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKF);
        baseFilter2.addParam(new C0934g("color2", new float[]{0.38039216f, 0.30588236f, 0.4117647f, 1.0f}));
        baseFilter2.addParam(new C0933f("transparency", 0.3f));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/fen.png", 33986));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bKG);
        fArr2 = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr3 = new float[]{0.018431371f, 0.0f, -0.037254903f};
        baseFilter2.addParam(new C0934g("shadowsShift", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter2.addParam(new C0934g("midtonesShift", fArr2));
        baseFilter2.addParam(new C0934g("highlightsShift", fArr3));
        baseFilter2.addParam(new C0935i("preserveLuminosity", 1));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86472);
    }
}
