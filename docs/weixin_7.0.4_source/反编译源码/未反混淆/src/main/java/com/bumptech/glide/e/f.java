package com.bumptech.glide.e;

import com.bumptech.glide.c.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class f {
    private final List<a<?>> aGX = new ArrayList();

    static final class a<T> {
        final l<T> aAN;
        final Class<T> aAf;

        a(Class<T> cls, l<T> lVar) {
            this.aAf = cls;
            this.aAN = lVar;
        }
    }

    public f() {
        AppMethodBeat.i(92447);
        AppMethodBeat.o(92447);
    }

    public final synchronized <Z> void b(Class<Z> cls, l<Z> lVar) {
        AppMethodBeat.i(92448);
        this.aGX.add(new a(cls, lVar));
        AppMethodBeat.o(92448);
    }

    public final synchronized <Z> l<Z> v(Class<Z> cls) {
        l<Z> lVar;
        AppMethodBeat.i(92449);
        int size = this.aGX.size();
        for (int i = 0; i < size; i++) {
            a aVar = (a) this.aGX.get(i);
            if (aVar.aAf.isAssignableFrom(cls)) {
                lVar = aVar.aAN;
                AppMethodBeat.o(92449);
                break;
            }
        }
        lVar = null;
        AppMethodBeat.o(92449);
        return lVar;
    }
}
