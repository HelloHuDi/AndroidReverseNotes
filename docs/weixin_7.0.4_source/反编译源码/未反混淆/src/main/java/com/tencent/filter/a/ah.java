package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ah extends BaseFilter {
    public ah() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86485);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new o("inputImageTexture2", "sh/glarefonddream_curve.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bMg);
        baseFilter2.addParam(new o("inputImageTexture2", "sh/glarefonddream_screen0.png", 33986));
        baseFilter2.addParam(new f("transparency", 0.6f));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bMg);
        baseFilter.addParam(new o("inputImageTexture2", "sh/glarefonddream_screen1.png", 33986));
        baseFilter.addParam(new f("transparency", 0.7f));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bMg);
        baseFilter2.addParam(new o("inputImageTexture2", "sh/glarefonddream_screen2.png", 33986));
        baseFilter2.addParam(new f("transparency", 0.4f));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86485);
    }
}
