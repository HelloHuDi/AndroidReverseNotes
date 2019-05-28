package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class h {
    private static Set<n> uiT = new HashSet();

    static {
        AppMethodBeat.i(6156);
        AppMethodBeat.o(6156);
    }

    public static void b(n nVar) {
        AppMethodBeat.i(6154);
        uiT.add(nVar);
        AppMethodBeat.o(6154);
    }

    public static void c(n nVar) {
        AppMethodBeat.i(6155);
        uiT.remove(nVar);
        AppMethodBeat.o(6155);
    }

    public static Set<n> cXb() {
        return uiT;
    }
}
