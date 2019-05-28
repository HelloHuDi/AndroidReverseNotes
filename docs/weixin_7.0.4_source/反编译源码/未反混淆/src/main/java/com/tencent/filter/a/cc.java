package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cc extends BaseFilter {
    public cc() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86536);
        k kVar = new k();
        kVar.a(0.0f, 13.0f, 0.0f, 340.0f, 352.0f, 10.0f, 20.0f);
        setNextFilter(kVar, null);
        k kVar2 = new k();
        kVar2.a(0.0f, -18.0f, 15.0f, 352.0f, 15.0f, 45.0f, 70.0f);
        kVar.setNextFilter(kVar2, null);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new o("inputImageTexture2", "sh/richred_curve.png", 33986));
        kVar2.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{-0.023529412f, 0.011764706f, 0.043137256f};
        float[] fArr2 = new float[]{-0.007843138f, 0.0f, 0.0f};
        baseFilter2.addParam(new g("shadowsShift", new float[]{0.0f, 0.007843138f, 0.007843138f}));
        baseFilter2.addParam(new g("midtonesShift", fArr));
        baseFilter2.addParam(new g("highlightsShift", fArr2));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86536);
    }
}
