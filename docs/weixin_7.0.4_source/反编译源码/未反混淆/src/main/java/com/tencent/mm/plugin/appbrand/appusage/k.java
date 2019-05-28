package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public final class k extends j<b> {
    public static final String[] fjY = new String[]{j.a(b.fjX, "AppBrandAppLaunchUsernameDuplicateRecord")};
    public final e gTC;

    static {
        AppMethodBeat.i(129556);
        AppMethodBeat.o(129556);
    }

    public k(e eVar) {
        super(eVar, b.fjX, "AppBrandAppLaunchUsernameDuplicateRecord", b.diI);
        this.gTC = eVar;
    }

    public final boolean x(String str, long j) {
        AppMethodBeat.i(129555);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129555);
            return false;
        }
        b bVar = new b();
        bVar.field_username = str;
        boolean b = b((c) bVar, new String[0]);
        bVar.field_updateTime = j;
        boolean c;
        if (b) {
            c = c(bVar, new String[0]);
            AppMethodBeat.o(129555);
            return c;
        }
        c = b((c) bVar);
        AppMethodBeat.o(129555);
        return c;
    }
}
