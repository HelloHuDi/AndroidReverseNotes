package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ai extends BaseFilter {
    public ai() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86486);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new o("inputImageTexture2", "sh/purpleyellow_nuan_curve.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bMh);
        baseFilter2.addParam(new o("inputImageTexture2", "sh/gradient_purpleyellow_rgb.png", this.needFlipBlend ? 1 : 0, (byte) 0));
        baseFilter2.addParam(new f("ralpha", 0.6f));
        baseFilter2.addParam(new f("galpha", 0.6f));
        baseFilter2.addParam(new f("balpha", 0.6f));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(GLSLRender.bKD);
        baseFilter3.addParam(new o("inputImageTexture2", "sh/purpleyellow_anticmos_curve.png", 33986));
        baseFilter2.setNextFilter(baseFilter3, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86486);
    }
}
