package com.tencent.mm.vending.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Stack;

final class g {
    private static g zYo;
    ThreadLocal<Stack<c>> b = new ThreadLocal();

    private g() {
        AppMethodBeat.i(126069);
        AppMethodBeat.o(126069);
    }

    static {
        AppMethodBeat.i(126070);
        zYo = null;
        zYo = new g();
        AppMethodBeat.o(126070);
    }

    public static g dMp() {
        return zYo;
    }
}
