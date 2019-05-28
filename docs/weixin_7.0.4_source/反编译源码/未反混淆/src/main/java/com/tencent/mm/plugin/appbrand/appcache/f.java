package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class f extends j<h> {
    public static final String[] fjY = new String[]{j.a(h.gSs, "CodeLibUsageLRURecord")};
    final e bSd;

    public f(e eVar) {
        super(eVar, h.gSs, "CodeLibUsageLRURecord", h.diI);
        this.bSd = eVar;
    }

    static {
        AppMethodBeat.i(129326);
        AppMethodBeat.o(129326);
    }

    public final void am(String str, int i) {
        AppMethodBeat.i(129325);
        c hVar = new h();
        hVar.field_appId = str;
        hVar.field_version = i;
        super.a(hVar, h.gSr);
        AppMethodBeat.o(129325);
    }
}
