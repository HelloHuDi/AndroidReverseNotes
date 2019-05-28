package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class ab extends j<aa> {
    public static final String[] fjY = new String[]{j.a(aa.gSs, "PkgUpdateStats")};

    public ab(e eVar) {
        super(eVar, aa.gSs, "PkgUpdateStats", aa.diI);
    }

    static {
        AppMethodBeat.i(129408);
        AppMethodBeat.o(129408);
    }

    /* Access modifiers changed, original: final */
    public final boolean ao(String str, int i) {
        AppMethodBeat.i(129407);
        c aaVar = new aa();
        aaVar.field_key = str;
        aaVar.field_version = i;
        boolean a = super.a(aaVar, aa.gSr);
        AppMethodBeat.o(129407);
        return a;
    }
}
