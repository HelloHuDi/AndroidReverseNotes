package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.ah */
public final class C17737ah extends BaseFilter {
    public C17737ah() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86485);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKD);
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/glarefonddream_curve.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bMg);
        baseFilter2.addParam(new C0936o("inputImageTexture2", "sh/glarefonddream_screen0.png", 33986));
        baseFilter2.addParam(new C0933f("transparency", 0.6f));
        baseFilter.setNextFilter(baseFilter2, null);
        baseFilter = new BaseFilter(GLSLRender.bMg);
        baseFilter.addParam(new C0936o("inputImageTexture2", "sh/glarefonddream_screen1.png", 33986));
        baseFilter.addParam(new C0933f("transparency", 0.7f));
        baseFilter2.setNextFilter(baseFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bMg);
        baseFilter2.addParam(new C0936o("inputImageTexture2", "sh/glarefonddream_screen2.png", 33986));
        baseFilter2.addParam(new C0933f("transparency", 0.4f));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86485);
    }
}
