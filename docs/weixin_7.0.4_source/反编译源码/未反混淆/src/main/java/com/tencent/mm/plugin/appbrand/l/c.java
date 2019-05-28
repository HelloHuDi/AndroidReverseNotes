package com.tencent.mm.plugin.appbrand.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class c {
    private static AtomicInteger ioy = new AtomicInteger(1);
    public HashMap<String, b> hGk;

    static class a {
        private static c ioz = new c();

        static {
            AppMethodBeat.i(108142);
            AppMethodBeat.o(108142);
        }
    }

    /* synthetic */ c(byte b) {
        this();
    }

    static {
        AppMethodBeat.i(108147);
        AppMethodBeat.o(108147);
    }

    private c() {
        AppMethodBeat.i(108143);
        this.hGk = new HashMap();
        AppMethodBeat.o(108143);
    }

    public static int aIA() {
        AppMethodBeat.i(108144);
        int incrementAndGet = ioy.incrementAndGet();
        AppMethodBeat.o(108144);
        return incrementAndGet;
    }

    public static c aIB() {
        AppMethodBeat.i(108145);
        c aIC = a.ioz;
        AppMethodBeat.o(108145);
        return aIC;
    }

    public final b CJ(String str) {
        AppMethodBeat.i(108146);
        if (this.hGk.containsKey(str)) {
            b bVar = (b) this.hGk.get(str);
            AppMethodBeat.o(108146);
            return bVar;
        }
        AppMethodBeat.o(108146);
        return null;
    }
}
