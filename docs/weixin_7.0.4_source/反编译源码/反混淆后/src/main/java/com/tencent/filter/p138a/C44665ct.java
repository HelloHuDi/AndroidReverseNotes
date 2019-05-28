package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.ct */
public final class C44665ct extends BaseFilter {
    public C44665ct() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86551);
        C44654ab c44654ab = new C44654ab();
        c44654ab.addParam(new C0936o("inputImageTexture2", "sh/rixi2_lf.png", 33986));
        setNextFilter(c44654ab, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86551);
    }
}
