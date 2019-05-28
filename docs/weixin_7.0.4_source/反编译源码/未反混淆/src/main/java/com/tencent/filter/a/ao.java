package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ao extends BaseFilter {
    public float p = 1.0f;

    public ao() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86496);
        int theFilterIndex = getTheFilterIndex(this);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bJB);
        baseFilter.scaleFact = Math.min(100.0f / Math.min(f2, f), 1.0f);
        setNextFilter(baseFilter, null);
        baseFilter.setNextFilter(new al(this.p), new int[]{theFilterIndex + (this.srcTextureIndex + 1)});
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86496);
    }
}
