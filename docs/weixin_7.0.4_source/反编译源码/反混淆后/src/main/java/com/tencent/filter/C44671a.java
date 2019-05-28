package com.tencent.filter;

import com.tencent.filter.C25624m.C0933f;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.a */
public final class C44671a extends BaseFilter {
    public final void setAdjustParam(float f) {
        AppMethodBeat.m2504i(86280);
        addParam(new C0933f("filterAdjustParam", f));
        AppMethodBeat.m2505o(86280);
    }

    public C44671a(int i) {
        super(i);
    }
}
