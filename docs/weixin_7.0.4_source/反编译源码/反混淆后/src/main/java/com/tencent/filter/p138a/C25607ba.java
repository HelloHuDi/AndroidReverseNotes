package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.ba */
public final class C25607ba extends BaseFilter {
    private BaseFilter bNF;

    public C25607ba() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86508);
        this.bNF = new C44654ab();
        this.bNF.addParam(new C0936o("inputImageTexture2", "sh/meiguichuxue_lf.png", 33986));
        setNextFilter(this.bNF, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86508);
    }
}
