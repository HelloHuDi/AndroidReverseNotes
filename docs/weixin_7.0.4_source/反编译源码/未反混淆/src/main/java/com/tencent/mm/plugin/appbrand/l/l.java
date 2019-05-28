package com.tencent.mm.plugin.appbrand.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class l {
    private static AtomicInteger ioy = new AtomicInteger(1);
    public HashMap<String, d> hGk;

    static class a {
        private static l ipf = new l();

        static {
            AppMethodBeat.i(108237);
            AppMethodBeat.o(108237);
        }
    }

    /* synthetic */ l(byte b) {
        this();
    }

    static {
        AppMethodBeat.i(108242);
        AppMethodBeat.o(108242);
    }

    private l() {
        AppMethodBeat.i(108238);
        this.hGk = new HashMap();
        AppMethodBeat.o(108238);
    }

    public static l aII() {
        AppMethodBeat.i(108239);
        l aIJ = a.ipf;
        AppMethodBeat.o(108239);
        return aIJ;
    }

    public final d CT(String str) {
        AppMethodBeat.i(108240);
        if (this.hGk.containsKey(str)) {
            d dVar = (d) this.hGk.get(str);
            AppMethodBeat.o(108240);
            return dVar;
        }
        AppMethodBeat.o(108240);
        return null;
    }

    public static int aIA() {
        AppMethodBeat.i(108241);
        int incrementAndGet = ioy.incrementAndGet();
        AppMethodBeat.o(108241);
        return incrementAndGet;
    }
}
