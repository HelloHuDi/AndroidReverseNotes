package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class h {
    private static final Set<Object> hvE = new HashSet();

    static {
        AppMethodBeat.i(91164);
        AppMethodBeat.o(91164);
    }

    public static <T> T bB(T t) {
        AppMethodBeat.i(91162);
        if (t != null) {
            hvE.add(t);
        }
        AppMethodBeat.o(91162);
        return t;
    }

    public static void at(Object obj) {
        AppMethodBeat.i(91163);
        hvE.remove(obj);
        AppMethodBeat.o(91163);
    }
}
