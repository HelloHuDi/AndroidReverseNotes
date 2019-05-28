package com.tencent.luggage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a implements c {
    private static Map<Class<? extends b>, b> bOa = new ConcurrentHashMap();
    private static Map<Class<? extends d>, d> bOb = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(90706);
        AppMethodBeat.o(90706);
    }

    public final String getName() {
        return "luggage-core";
    }

    public final Map<Class<? extends b>, b> wH() {
        return bOa;
    }

    public final Map<Class<? extends d>, d> wI() {
        return bOb;
    }
}
