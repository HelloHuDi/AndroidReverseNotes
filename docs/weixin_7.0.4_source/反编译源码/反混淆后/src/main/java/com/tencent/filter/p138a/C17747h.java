package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.h */
public final class C17747h extends BaseFilter {
    public C17747h() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86441);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKH);
        float[] fArr = new float[]{1.0f, 1.0f, 1.0f};
        baseFilter.addParam(new C0934g("channelparam", new float[]{0.4f, 0.4f, 0.2f}));
        baseFilter.addParam(new C0934g("mixparam", fArr));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bKD);
        baseFilter2.addParam(new C0936o("inputImageTexture2", "sh/blackwhite.png", 33986));
        baseFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86441);
    }
}
