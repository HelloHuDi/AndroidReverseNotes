package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cp {
    private static cp a = new cp();

    static {
        AppMethodBeat.i(98658);
        AppMethodBeat.o(98658);
    }

    public static cc a(String str) {
        AppMethodBeat.i(98656);
        cc a = bw.a(str);
        AppMethodBeat.o(98656);
        return a;
    }

    public static cp a() {
        return a;
    }

    public static void a(String str, bu buVar, int i) {
        AppMethodBeat.i(98657);
        bw.a(str, buVar, i);
        AppMethodBeat.o(98657);
    }
}
