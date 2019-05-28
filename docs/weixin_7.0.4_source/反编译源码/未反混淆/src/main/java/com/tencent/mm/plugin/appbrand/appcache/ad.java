package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class ad extends j<ac> {
    public static final String[] fjY = new String[]{j.a(ac.gSs, "PkgUsageLRURecord")};
    final e bSd;

    public ad(e eVar) {
        super(eVar, ac.gSs, "PkgUsageLRURecord", ac.diI);
        this.bSd = eVar;
    }

    static {
        AppMethodBeat.i(129411);
        AppMethodBeat.o(129411);
    }

    public final void am(String str, int i) {
        AppMethodBeat.i(129410);
        c acVar = new ac();
        acVar.field_appId = str;
        acVar.field_type = i;
        super.a(acVar, ac.gSr);
        AppMethodBeat.o(129410);
    }
}
