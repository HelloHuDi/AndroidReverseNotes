package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class i {
    private static final o gSt = new c();

    static {
        AppMethodBeat.i(101714);
        AppMethodBeat.o(101714);
    }

    public static String xn(String str) {
        AppMethodBeat.i(101713);
        InputStream openRead = gSt.openRead(str);
        String str2;
        if (openRead == null) {
            str2 = "";
            AppMethodBeat.o(101713);
            return str2;
        }
        str2 = com.tencent.luggage.g.i.convertStreamToString(openRead);
        AppMethodBeat.o(101713);
        return str2;
    }
}
