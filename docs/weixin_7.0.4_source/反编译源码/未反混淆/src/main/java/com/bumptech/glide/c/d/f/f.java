package com.bumptech.glide.c.d.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class f {
    private final List<a<?, ?>> aGs = new ArrayList();

    static final class a<Z, R> {
        final e<Z, R> aBf;
        private final Class<Z> aGt;
        private final Class<R> aGu;

        a(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
            this.aGt = cls;
            this.aGu = cls2;
            this.aBf = eVar;
        }

        public final boolean e(Class<?> cls, Class<?> cls2) {
            AppMethodBeat.i(92365);
            if (this.aGt.isAssignableFrom(cls) && cls2.isAssignableFrom(this.aGu)) {
                AppMethodBeat.o(92365);
                return true;
            }
            AppMethodBeat.o(92365);
            return false;
        }
    }

    public f() {
        AppMethodBeat.i(92366);
        AppMethodBeat.o(92366);
    }

    public final synchronized <Z, R> void b(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
        AppMethodBeat.i(92367);
        this.aGs.add(new a(cls, cls2, eVar));
        AppMethodBeat.o(92367);
    }

    public final synchronized <Z, R> e<Z, R> c(Class<Z> cls, Class<R> cls2) {
        e<Z, R> nH;
        AppMethodBeat.i(92368);
        if (cls2.isAssignableFrom(cls)) {
            nH = g.nH();
            AppMethodBeat.o(92368);
        } else {
            for (a aVar : this.aGs) {
                if (aVar.e(cls, cls2)) {
                    nH = aVar.aBf;
                    AppMethodBeat.o(92368);
                }
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
            AppMethodBeat.o(92368);
            throw illegalArgumentException;
        }
        return nH;
    }

    public final synchronized <Z, R> List<Class<R>> d(Class<Z> cls, Class<R> cls2) {
        List<Class<R>> list;
        AppMethodBeat.i(92369);
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            AppMethodBeat.o(92369);
            list = arrayList;
        } else {
            for (a e : this.aGs) {
                if (e.e(cls, cls2)) {
                    arrayList.add(cls2);
                }
            }
            AppMethodBeat.o(92369);
            Object list2 = arrayList;
        }
        return list2;
    }
}
