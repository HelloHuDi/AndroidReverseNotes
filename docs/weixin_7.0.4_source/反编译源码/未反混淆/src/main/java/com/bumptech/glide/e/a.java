package com.bumptech.glide.e;

import com.bumptech.glide.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class a {
    private final List<a<?>> aGX = new ArrayList();

    static final class a<T> {
        final d<T> aAc;
        final Class<T> aBd;

        a(Class<T> cls, d<T> dVar) {
            this.aBd = cls;
            this.aAc = dVar;
        }
    }

    public a() {
        AppMethodBeat.i(92429);
        AppMethodBeat.o(92429);
    }

    public final synchronized <T> d<T> u(Class<T> cls) {
        d<T> dVar;
        AppMethodBeat.i(92430);
        for (a aVar : this.aGX) {
            if (aVar.aBd.isAssignableFrom(cls)) {
                dVar = aVar.aAc;
                AppMethodBeat.o(92430);
                break;
            }
        }
        dVar = null;
        AppMethodBeat.o(92430);
        return dVar;
    }

    public final synchronized <T> void b(Class<T> cls, d<T> dVar) {
        AppMethodBeat.i(92431);
        this.aGX.add(new a(cls, dVar));
        AppMethodBeat.o(92431);
    }
}
