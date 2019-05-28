package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.cz */
public final class C37335cz extends BaseFilter {
    private BaseFilter bNF;

    public C37335cz() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86563);
        this.bNF = new C44654ab();
        this.bNF.addParam(new C0936o("inputImageTexture2", "sh/yingtaobuding_lf.png", 33986));
        setNextFilter(this.bNF, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86563);
    }
}
