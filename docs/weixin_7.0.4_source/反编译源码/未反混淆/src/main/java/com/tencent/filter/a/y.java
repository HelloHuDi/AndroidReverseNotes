package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class y extends BaseFilter {
    public y() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86473);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bJO);
        baseFilter.addParam(new f("contrast", 1.0f));
        baseFilter.addParam(new f("saturation", 1.4f));
        baseFilter.addParam(new f("brightness", 1.0f));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{-0.02745098f, 0.0f, 0.011764706f};
        float[] fArr2 = new float[]{-0.02745098f, 0.0f, 0.011764706f};
        baseFilter2.addParam(new g("shadowsShift", new float[]{-0.02745098f, 0.0f, 0.011764706f}));
        baseFilter2.addParam(new g("midtonesShift", fArr));
        baseFilter2.addParam(new g("highlightsShift", fArr2));
        baseFilter2.addParam(new i("preserveLuminosity", 1));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bLF);
        baseFilter.addParam(new f("inputH", 1.0f));
        baseFilter.addParam(new f("inputS", 1.0f));
        baseFilter.addParam(new f("inputV", 1.02f));
        baseFilter2.setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86473);
    }
}
