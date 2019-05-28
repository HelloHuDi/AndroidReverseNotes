package com.bumptech.glide.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class p {
    private final r aEr;
    private final a aEs;

    static class a {
        final Map<Class<?>, a<?>> aEt = new HashMap();

        static class a<Model> {
            final List<n<Model, ?>> aEu;

            public a(List<n<Model, ?>> list) {
                this.aEu = list;
            }
        }

        a() {
            AppMethodBeat.i(92100);
            AppMethodBeat.o(92100);
        }
    }

    public p(android.support.v4.f.k.a<List<Throwable>> aVar) {
        this(new r(aVar));
        AppMethodBeat.i(92101);
        AppMethodBeat.o(92101);
    }

    private p(r rVar) {
        AppMethodBeat.i(92102);
        this.aEs = new a();
        this.aEr = rVar;
        AppMethodBeat.o(92102);
    }

    public final synchronized <Model, Data> void b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        AppMethodBeat.i(92103);
        this.aEr.b(cls, cls2, oVar);
        this.aEs.aEt.clear();
        AppMethodBeat.o(92103);
    }

    public final synchronized List<Class<?>> r(Class<?> cls) {
        List r;
        AppMethodBeat.i(92105);
        r = this.aEr.r(cls);
        AppMethodBeat.o(92105);
        return r;
    }

    public final synchronized <A> List<n<A, ?>> P(A a) {
        ArrayList arrayList;
        List list;
        List list2;
        AppMethodBeat.i(92104);
        Class cls = a.getClass();
        a aVar = (a) this.aEs.aEt.get(cls);
        if (aVar == null) {
            list = null;
        } else {
            list = aVar.aEu;
        }
        if (list == null) {
            List unmodifiableList = Collections.unmodifiableList(this.aEr.s(cls));
            if (((a) this.aEs.aEt.put(cls, new a(unmodifiableList))) != null) {
                IllegalStateException illegalStateException = new IllegalStateException("Already cached loaders for model: ".concat(String.valueOf(cls)));
                AppMethodBeat.o(92104);
                throw illegalStateException;
            }
            list2 = unmodifiableList;
        } else {
            list2 = list;
        }
        int size = list2.size();
        arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            n nVar = (n) list2.get(i);
            if (nVar.X(a)) {
                arrayList.add(nVar);
            }
        }
        AppMethodBeat.o(92104);
        return arrayList;
    }
}
