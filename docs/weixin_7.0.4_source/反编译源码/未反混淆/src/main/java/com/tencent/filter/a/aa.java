package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aa extends BaseFilter {
    public aa() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86476);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKF);
        baseFilter.addParam(new g("color2", new float[]{0.15294118f, 0.09411765f, 0.09803922f, 1.0f}));
        baseFilter.addParam(new f("transparency", 1.0f));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKD);
        baseFilter2.addParam(new o("inputImageTexture2", "sh/fuguhuang.png", 33986));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr2 = new float[]{0.0f, 0.0f, -0.1254902f};
        baseFilter.addParam(new g("shadowsShift", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter.addParam(new g("midtonesShift", fArr));
        baseFilter.addParam(new g("highlightsShift", fArr2));
        baseFilter.addParam(new i("preserveLuminosity", 1));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bKJ);
        baseFilter2.addParam(new f("inputH", 1.0f));
        baseFilter2.addParam(new f("inputS", 1.0f));
        baseFilter2.addParam(new f("inputV", 0.974f));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bKM);
        baseFilter.addParam(new g("color2", new float[]{0.9490196f, 0.9098039f, 0.8039216f, 1.0f}));
        baseFilter.addParam(new f("transparency", 0.5f));
        baseFilter2.setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86476);
    }
}
