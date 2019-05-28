package com.tencent.mm.plugin.appbrand.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class i {
    private static AtomicInteger ioy = new AtomicInteger(1);
    public HashMap<String, g> hGk;

    static class a {
        private static i ioZ = new i();

        static {
            AppMethodBeat.i(108180);
            AppMethodBeat.o(108180);
        }
    }

    /* synthetic */ i(byte b) {
        this();
    }

    static {
        AppMethodBeat.i(108185);
        AppMethodBeat.o(108185);
    }

    private i() {
        AppMethodBeat.i(108181);
        this.hGk = new HashMap();
        AppMethodBeat.o(108181);
    }

    public static int aIA() {
        AppMethodBeat.i(108182);
        int incrementAndGet = ioy.incrementAndGet();
        AppMethodBeat.o(108182);
        return incrementAndGet;
    }

    public static i aIG() {
        AppMethodBeat.i(108183);
        i aIH = a.ioZ;
        AppMethodBeat.o(108183);
        return aIH;
    }

    public final g CO(String str) {
        AppMethodBeat.i(108184);
        if (this.hGk.containsKey(str)) {
            g gVar = (g) this.hGk.get(str);
            AppMethodBeat.o(108184);
            return gVar;
        }
        AppMethodBeat.o(108184);
        return null;
    }
}
