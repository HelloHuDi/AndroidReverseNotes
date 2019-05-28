package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n extends BaseFilter {
    public n() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86454);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKH);
        float[] fArr = new float[]{1.0f, 1.0f, 1.0f};
        baseFilter.addParam(new g("channelparam", new float[]{0.4f, 0.4f, 0.2f}));
        baseFilter.addParam(new g("mixparam", fArr));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKD);
        baseFilter2.addParam(new o("inputImageTexture2", "sh/coffee_curve.png", 33986));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bLN);
        baseFilter.addParam(new g("color2", new float[]{0.22352941f, 0.19215687f, 0.16078432f, 1.0f}));
        baseFilter.addParam(new f("transparency", 1.0f));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bLN);
        baseFilter2.addParam(new g("color2", new float[]{0.44313726f, 0.39215687f, 0.36078432f, 1.0f}));
        baseFilter2.addParam(new f("transparency", 1.0f));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86454);
    }
}
