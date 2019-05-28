package com.tencent.mm.plugin.appbrand.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.i;
import com.tencent.mm.plugin.appbrand.m.a.b;
import com.tencent.mm.plugin.appbrand.m.a.c;
import com.tencent.mm.plugin.appbrand.permission.f;

public final class h extends b {
    public final int aIT() {
        return 5;
    }

    public final void a(i iVar, c cVar) {
        AppMethodBeat.i(102203);
        ((f) cVar.gMN.B(f.class)).Dq(iVar.optString("apiName"));
        AppMethodBeat.o(102203);
    }
}
