package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hb {
    public static boolean a() {
        AppMethodBeat.i(99520);
        if (b().equals("tencentmap")) {
            AppMethodBeat.o(99520);
            return false;
        }
        AppMethodBeat.o(99520);
        return true;
    }

    private static String b() {
        return "";
    }
}
