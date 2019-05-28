package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.bq;

public final class z {
    public static y nY(String str) {
        AppMethodBeat.i(77806);
        y yVar = new y("@black.android", null, str, null, true, true);
        AppMethodBeat.o(77806);
        return yVar;
    }

    public static y nZ(String str) {
        AppMethodBeat.i(77807);
        bq RA = ((j) g.K(j.class)).XU().RA("@t.qq.com");
        if (RA == null) {
            AppMethodBeat.o(77807);
            return null;
        }
        y yVar = new y("@t.qq.com", null, str, null, RA.isEnable(), RA.dum());
        AppMethodBeat.o(77807);
        return yVar;
    }

    private static String af(String str, String str2) {
        AppMethodBeat.i(77808);
        String str3 = "";
        if (str != null) {
            str3 = str3 + str.replace("@", "");
        }
        if (str2 != null) {
            str3 = str3 + str2;
        }
        AppMethodBeat.o(77808);
        return str3;
    }

    public static y ag(String str, String str2) {
        AppMethodBeat.i(77809);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(77809);
            return null;
        }
        bq RA = ((j) g.K(j.class)).XU().RA(str);
        if (RA == null || !RA.dun()) {
            AppMethodBeat.o(77809);
            return null;
        }
        y yVar = new y("@domain.android", RA.name, af(RA.xZV.apT(""), str2), RA.xZV.apT(""), RA.isEnable(), true);
        AppMethodBeat.o(77809);
        return yVar;
    }
}
