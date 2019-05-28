package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ad extends BaseFilter {
    public ad() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86479);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new o("inputImageTexture2", "sh/gaoleng_curve.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{-0.14901961f, 0.0f, 0.08627451f};
        float[] fArr2 = new float[]{-0.019607844f, 0.019607844f, 0.05882353f};
        baseFilter2.addParam(new g("shadowsShift", new float[]{-0.22352941f, 0.039215688f, 0.08627451f}));
        baseFilter2.addParam(new g("midtonesShift", fArr));
        baseFilter2.addParam(new g("highlightsShift", fArr2));
        baseFilter2.addParam(new i("preserveLuminosity", 1));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bLN);
        baseFilter.addParam(new g("color2", new float[]{0.06666667f, 0.6f, 0.8745098f, 1.0f}));
        baseFilter.addParam(new f("transparency", 0.7f));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bKE);
        baseFilter2.addParam(new f("scaleC", -0.07500002f));
        baseFilter2.addParam(new f("scaleT", 0.0f));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bJO);
        baseFilter.addParam(new f("contrast", 1.13f));
        baseFilter.addParam(new f("saturation", 1.0f));
        baseFilter.addParam(new f("brightness", 1.0f));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bLF);
        baseFilter2.addParam(new f("inputH", 1.0f));
        baseFilter2.addParam(new f("inputS", 1.0f));
        baseFilter2.addParam(new f("inputV", 0.98f));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86479);
    }
}
