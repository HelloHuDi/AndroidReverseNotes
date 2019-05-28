package com.tencent.mm.wallet_core.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.WeakHashMap;

public final class a {
    public WeakHashMap<Object, Boolean> Ags = new WeakHashMap();

    static class a {
        static a Agt = new a();

        static {
            AppMethodBeat.i(49162);
            AppMethodBeat.o(49162);
        }
    }

    public a() {
        AppMethodBeat.i(49163);
        AppMethodBeat.o(49163);
    }

    public static synchronized a dOl() {
        a aVar;
        synchronized (a.class) {
            aVar = a.Agt;
        }
        return aVar;
    }
}
