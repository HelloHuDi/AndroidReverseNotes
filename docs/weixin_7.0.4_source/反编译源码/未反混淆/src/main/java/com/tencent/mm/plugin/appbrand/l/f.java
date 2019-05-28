package com.tencent.mm.plugin.appbrand.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class f {
    private static AtomicInteger ioy = new AtomicInteger(1);
    public HashMap<String, d> hGk;

    static class a {
        private static f ioS = new f();

        static {
            AppMethodBeat.i(108161);
            AppMethodBeat.o(108161);
        }
    }

    /* synthetic */ f(byte b) {
        this();
    }

    static {
        AppMethodBeat.i(108166);
        AppMethodBeat.o(108166);
    }

    private f() {
        AppMethodBeat.i(108162);
        this.hGk = new HashMap();
        AppMethodBeat.o(108162);
    }

    public static int aIA() {
        AppMethodBeat.i(108163);
        int incrementAndGet = ioy.incrementAndGet();
        AppMethodBeat.o(108163);
        return incrementAndGet;
    }

    public static f aIE() {
        AppMethodBeat.i(108164);
        f aIF = a.ioS;
        AppMethodBeat.o(108164);
        return aIF;
    }

    public final d CM(String str) {
        AppMethodBeat.i(108165);
        if (this.hGk.containsKey(str)) {
            d dVar = (d) this.hGk.get(str);
            AppMethodBeat.o(108165);
            return dVar;
        }
        AppMethodBeat.o(108165);
        return null;
    }
}
