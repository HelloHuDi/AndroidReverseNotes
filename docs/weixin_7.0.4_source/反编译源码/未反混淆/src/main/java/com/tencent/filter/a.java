package com.tencent.filter;

import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends BaseFilter {
    public final void setAdjustParam(float f) {
        AppMethodBeat.i(86280);
        addParam(new f("filterAdjustParam", f));
        AppMethodBeat.o(86280);
    }

    public a(int i) {
        super(i);
    }
}
