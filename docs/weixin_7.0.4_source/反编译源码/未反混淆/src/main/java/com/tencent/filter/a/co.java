package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.b;
import com.tencent.filter.k;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class co extends BaseFilter {
    public co() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86547);
        b bVar = new b(GLSLRender.bJB, 0);
        bVar.setEffectIndex(2);
        bVar.setSrcFilterIndex(this.srcTextureIndex + 1);
        bVar.ApplyGLSLFilter(z, f, f2);
        setNextFilter(bVar, null);
        BaseFilter lastFilter = bVar.getLastFilter();
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new o("inputImageTexture2", "sh/tianmeizipai_curve.png", 33986));
        lastFilter.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.0f, 0.0f, 0.0f};
        float[] fArr2 = new float[]{0.03137255f, 0.0f, 0.0f};
        baseFilter2.addParam(new g("shadowsShift", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter2.addParam(new g("midtonesShift", fArr));
        baseFilter2.addParam(new g("highlightsShift", fArr2));
        baseFilter.setNextFilter(baseFilter2, null);
        k kVar = new k();
        kVar.a(0.0f, 3.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f);
        baseFilter2.setNextFilter(kVar, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86547);
    }
}
