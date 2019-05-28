package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bg extends BaseFilter {
    public bg() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86514);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{-0.07059216f, 0.027035292f, 0.019607844f};
        float[] fArr2 = new float[]{0.0627451f, -0.09411765f, 0.0f};
        baseFilter.addParam(new g("shadowsShift", new float[]{-0.053819608f, 0.020611765f, 0.0f}));
        baseFilter.addParam(new g("midtonesShift", fArr));
        baseFilter.addParam(new g("highlightsShift", fArr2));
        baseFilter.addParam(new i("preserveLuminosity", 1));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKJ);
        baseFilter2.addParam(new f("inputH", 1.0f));
        baseFilter2.addParam(new f("inputS", 1.0f));
        baseFilter2.addParam(new f("inputV", 1.146f));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new o("inputImageTexture2", "sh/molv_curve1.png", 33986));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bLE);
        baseFilter2.addParam(new o("inputImageTexture2", "sh/molv_curve2.png", 33986));
        baseFilter2.addParam(new o("inputImageTexture3", "sh/molv_curve2mask.png", 33987));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86514);
    }
}
