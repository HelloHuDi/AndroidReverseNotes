package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.k;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bf extends BaseFilter {
    public bf() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86513);
        k kVar = new k();
        kVar.a(0.0f, -4.0f, 4.0f, 0.0f, 28.0f, 48.0f, 72.0f);
        setNextFilter(kVar, null);
        k kVar2 = new k();
        kVar2.a(-5.039946f, 24.0f, 0.0f, 329.0f, 330.0f, 8.0f, 26.0f);
        kVar.setNextFilter(kVar2, null);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new o("inputImageTexture2", "sh/milkgreen_curve.png", 33986));
        kVar2.setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bMf);
        baseFilter2.addParam(new g("color2", new float[]{0.72156864f, 0.8784314f, 0.77254903f, 1.0f}));
        baseFilter2.addParam(new f("transparency", 0.1f));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86513);
    }
}
