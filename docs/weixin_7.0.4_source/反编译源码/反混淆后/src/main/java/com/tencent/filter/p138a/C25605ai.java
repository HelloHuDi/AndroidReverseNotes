package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.ai */
public final class C25605ai extends BaseFilter {
    public C25605ai() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86486);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/purpleyellow_nuan_curve.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bMh);
        baseFilter2.addParam(new C0936o("inputImageTexture2", "sh/gradient_purpleyellow_rgb.png", this.needFlipBlend ? 1 : 0, (byte) 0));
        baseFilter2.addParam(new C0933f("ralpha", 0.6f));
        baseFilter2.addParam(new C0933f("galpha", 0.6f));
        baseFilter2.addParam(new C0933f("balpha", 0.6f));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(GLSLRender.bKD);
        baseFilter3.addParam(new C0936o("inputImageTexture2", "sh/purpleyellow_anticmos_curve.png", 33986));
        baseFilter2.setNextFilter(baseFilter3, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86486);
    }
}
