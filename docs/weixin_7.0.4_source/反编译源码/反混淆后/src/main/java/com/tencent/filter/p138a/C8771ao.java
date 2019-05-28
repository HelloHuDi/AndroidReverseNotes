package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a.ao */
public final class C8771ao extends BaseFilter {
    /* renamed from: p */
    public float f2443p = 1.0f;

    public C8771ao() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86496);
        int theFilterIndex = getTheFilterIndex(this);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bJB);
        baseFilter.scaleFact = Math.min(100.0f / Math.min(f2, f), 1.0f);
        setNextFilter(baseFilter, null);
        baseFilter.setNextFilter(new C37326al(this.f2443p), new int[]{theFilterIndex + (this.srcTextureIndex + 1)});
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86496);
    }
}
