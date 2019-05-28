package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cl extends BaseFilter {
    public cl() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86544);
        k kVar = new k();
        kVar.a(0.0f, -20.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f);
        setNextFilter(kVar, null);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKF);
        baseFilter.addParam(new g("color2", new float[]{0.09019608f, 0.06666667f, 0.06666667f, 1.0f}));
        baseFilter.addParam(new f("transparency", 0.5f));
        kVar.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKD);
        baseFilter2.addParam(new o("inputImageTexture2", "sh/teamilk_curve2.png", 33986));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bKI);
        baseFilter.addParam(new g("color2", new float[]{0.9411765f, 0.91764706f, 0.85490197f, 1.0f}));
        baseFilter.addParam(new f("transparency", 1.0f));
        baseFilter2.setNextFilter(baseFilter, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86544);
    }
}
