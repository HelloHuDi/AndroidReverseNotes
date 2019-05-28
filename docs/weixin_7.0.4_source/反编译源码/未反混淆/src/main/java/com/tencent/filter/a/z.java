package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class z extends BaseFilter {
    public z() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86475);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKF);
        baseFilter.addParam(new g("color2", new float[]{0.18039216f, 0.14901961f, 0.07450981f, 1.0f}));
        baseFilter.addParam(new f("transparency", 1.0f));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr2 = new float[]{0.0f, 0.0f, 0.0f};
        baseFilter2.addParam(new g("shadowsShift", new float[]{-0.023529412f, 0.105882354f, 0.0f}));
        baseFilter2.addParam(new g("midtonesShift", fArr));
        baseFilter2.addParam(new g("highlightsShift", fArr2));
        baseFilter2.addParam(new i("preserveLuminosity", 1));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bLM);
        baseFilter.addParam(new g("color2", new float[]{0.39607844f, 0.25490198f, 0.18431373f, 1.0f}));
        baseFilter.addParam(new f("transparency", 0.87f));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bKG);
        fArr = new float[]{0.0f, 0.05490196f, 0.0f};
        fArr2 = new float[]{0.03137255f, 0.05490196f, -0.24313726f};
        baseFilter2.addParam(new g("shadowsShift", new float[]{0.0f, 0.05490196f, 0.0f}));
        baseFilter2.addParam(new g("midtonesShift", fArr));
        baseFilter2.addParam(new g("highlightsShift", fArr2));
        baseFilter2.addParam(new i("preserveLuminosity", 1));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bJO);
        baseFilter.addParam(new f("contrast", 1.0f));
        baseFilter.addParam(new f("saturation", 0.6f));
        baseFilter.addParam(new f("brightness", 1.0f));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bKD);
        baseFilter2.addParam(new o("inputImageTexture2", "sh/fugu_curve.png", 33986));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bKJ);
        baseFilter.addParam(new f("inputH", 1.0f));
        baseFilter.addParam(new f("inputS", 1.0f));
        baseFilter.addParam(new f("inputV", 0.974f));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bKM);
        baseFilter2.addParam(new g("color2", new float[]{0.9490196f, 0.9098039f, 0.8039216f, 1.0f}));
        baseFilter2.addParam(new f("transparency", 0.5f));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86475);
    }
}
