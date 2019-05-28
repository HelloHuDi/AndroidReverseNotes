package com.bumptech.glide.c.a;

import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class f {
    private static final com.bumptech.glide.c.a.e.a<?> azl = new com.bumptech.glide.c.a.e.a<Object>() {
        public final e<Object> T(Object obj) {
            AppMethodBeat.i(91704);
            a aVar = new a(obj);
            AppMethodBeat.o(91704);
            return aVar;
        }

        public final Class<Object> mg() {
            AppMethodBeat.i(91705);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Not implemented");
            AppMethodBeat.o(91705);
            throw unsupportedOperationException;
        }
    };
    private final Map<Class<?>, com.bumptech.glide.c.a.e.a<?>> azk = new HashMap();

    static final class a implements e<Object> {
        private final Object data;

        a(Object obj) {
            this.data = obj;
        }

        public final Object mj() {
            return this.data;
        }

        public final void cleanup() {
        }
    }

    public f() {
        AppMethodBeat.i(91706);
        AppMethodBeat.o(91706);
    }

    static {
        AppMethodBeat.i(91709);
        AppMethodBeat.o(91709);
    }

    public final synchronized void b(com.bumptech.glide.c.a.e.a<?> aVar) {
        AppMethodBeat.i(91707);
        this.azk.put(aVar.mg(), aVar);
        AppMethodBeat.o(91707);
    }

    public final synchronized <T> e<T> T(T t) {
        e T;
        AppMethodBeat.i(91708);
        i.d(t, "Argument must not be null");
        com.bumptech.glide.c.a.e.a aVar = (com.bumptech.glide.c.a.e.a) this.azk.get(t.getClass());
        if (aVar == null) {
            for (com.bumptech.glide.c.a.e.a aVar2 : this.azk.values()) {
                if (aVar2.mg().isAssignableFrom(t.getClass())) {
                    aVar = aVar2;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = azl;
        }
        T = aVar.T(t);
        AppMethodBeat.o(91708);
        return T;
    }
}
