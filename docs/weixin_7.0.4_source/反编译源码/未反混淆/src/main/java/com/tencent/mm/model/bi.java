package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.k;

public final class bi {
    public static a fmO = null;

    public interface a {
        int aag();

        k aah();
    }

    public static k a(k kVar) {
        AppMethodBeat.i(58107);
        if (fmO == null) {
            AppMethodBeat.o(58107);
            return kVar;
        }
        kVar = fmO.aah();
        AppMethodBeat.o(58107);
        return kVar;
    }

    public static int aag() {
        AppMethodBeat.i(58108);
        if (fmO != null) {
            int aag = fmO.aag();
            AppMethodBeat.o(58108);
            return aag;
        }
        AppMethodBeat.o(58108);
        return 0;
    }
}
