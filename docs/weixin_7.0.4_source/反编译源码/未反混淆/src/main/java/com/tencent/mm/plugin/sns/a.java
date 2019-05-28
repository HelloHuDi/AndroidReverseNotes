package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.i;

public final class a implements com.tencent.mm.plugin.sns.b.a {
    public final void i(int i, String str, int i2) {
        AppMethodBeat.i(35596);
        m iVar = new i(i, str, i2);
        g.RQ();
        g.RO().eJo.a(iVar, 0);
        AppMethodBeat.o(35596);
    }
}
