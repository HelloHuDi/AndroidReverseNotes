package com.bumptech.glide.c.c;

import com.bumptech.glide.c.j;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class r {
    private static final n<Object, Object> aEA = new a();
    private static final c aEz = new c();
    private final List<b<?, ?>> aEB;
    private final c aEC;
    private final Set<b<?, ?>> aED;
    private final android.support.v4.f.k.a<List<Throwable>> awV;

    static class a implements n<Object, Object> {
        a() {
        }

        public final com.bumptech.glide.c.c.n.a<Object> b(Object obj, int i, int i2, j jVar) {
            return null;
        }

        public final boolean X(Object obj) {
            return false;
        }
    }

    static class b<Model, Data> {
        final Class<Data> aBd;
        private final Class<Model> aEE;
        final o<? extends Model, ? extends Data> aEF;

        public b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
            this.aEE = cls;
            this.aBd = cls2;
            this.aEF = oVar;
        }

        public final boolean t(Class<?> cls) {
            AppMethodBeat.i(92118);
            boolean isAssignableFrom = this.aEE.isAssignableFrom(cls);
            AppMethodBeat.o(92118);
            return isAssignableFrom;
        }
    }

    static class c {
        c() {
        }
    }

    static {
        AppMethodBeat.i(92125);
        AppMethodBeat.o(92125);
    }

    public r(android.support.v4.f.k.a<List<Throwable>> aVar) {
        this(aVar, aEz);
    }

    private r(android.support.v4.f.k.a<List<Throwable>> aVar, c cVar) {
        AppMethodBeat.i(92119);
        this.aEB = new ArrayList();
        this.aED = new HashSet();
        this.awV = aVar;
        this.aEC = cVar;
        AppMethodBeat.o(92119);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized <Model> List<n<Model, ?>> s(Class<Model> cls) {
        ArrayList arrayList;
        AppMethodBeat.i(92121);
        try {
            arrayList = new ArrayList();
            for (b bVar : this.aEB) {
                if (!this.aED.contains(bVar) && bVar.t(cls)) {
                    this.aED.add(bVar);
                    arrayList.add(a(bVar));
                    this.aED.remove(bVar);
                }
            }
            AppMethodBeat.o(92121);
        } catch (Throwable th) {
            this.aED.clear();
            AppMethodBeat.o(92121);
        }
        return arrayList;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized List<Class<?>> r(Class<?> cls) {
        ArrayList arrayList;
        AppMethodBeat.i(92122);
        arrayList = new ArrayList();
        for (b bVar : this.aEB) {
            if (!arrayList.contains(bVar.aBd) && bVar.t(cls)) {
                arrayList.add(bVar.aBd);
            }
        }
        AppMethodBeat.o(92122);
        return arrayList;
    }

    public final synchronized <Model, Data> n<Model, Data> b(Class<Model> cls, Class<Data> cls2) {
        n<Model, Data> qVar;
        AppMethodBeat.i(92123);
        try {
            ArrayList arrayList = new ArrayList();
            Object obj = null;
            for (b bVar : this.aEB) {
                if (this.aED.contains(bVar)) {
                    obj = 1;
                } else {
                    Object obj2;
                    if (bVar.t(cls) && bVar.aBd.isAssignableFrom(cls2)) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        this.aED.add(bVar);
                        arrayList.add(a(bVar));
                        this.aED.remove(bVar);
                    }
                }
            }
            if (arrayList.size() > 1) {
                qVar = new q(arrayList, this.awV);
                AppMethodBeat.o(92123);
            } else if (arrayList.size() == 1) {
                qVar = (n) arrayList.get(0);
                AppMethodBeat.o(92123);
            } else if (obj != null) {
                qVar = aEA;
                AppMethodBeat.o(92123);
            } else {
                com.bumptech.glide.h.c cVar = new com.bumptech.glide.h.c(cls, cls2);
                AppMethodBeat.o(92123);
                throw cVar;
            }
        } catch (Throwable th) {
            this.aED.clear();
            AppMethodBeat.o(92123);
        }
        return qVar;
    }

    private <Model, Data> n<Model, Data> a(b<?, ?> bVar) {
        AppMethodBeat.i(92124);
        n nVar = (n) i.d(bVar.aEF.a(this), "Argument must not be null");
        AppMethodBeat.o(92124);
        return nVar;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized <Model, Data> void b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        AppMethodBeat.i(92120);
        this.aEB.add(this.aEB.size(), new b(cls, cls2, oVar));
        AppMethodBeat.o(92120);
    }
}
