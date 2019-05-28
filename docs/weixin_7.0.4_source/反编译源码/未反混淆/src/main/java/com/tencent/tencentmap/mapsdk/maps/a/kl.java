package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class kl<T, S extends kt> implements kj<T, S> {
    private final List<? extends kj<T, S>> a;
    private final ky b;
    private final kf c;

    kl(List<? extends kj<T, S>> list, kf kfVar) {
        AppMethodBeat.i(100236);
        if (list.isEmpty()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(100236);
            throw illegalArgumentException;
        }
        this.c = kfVar;
        this.a = list;
        this.b = ks.a(list);
        AppMethodBeat.o(100236);
    }

    public final kt b() {
        return this.b;
    }

    public final void a(mf<? super kt, Boolean> mfVar, ly<? super kg<T, S>> lyVar) {
        AppMethodBeat.i(100237);
        if (((Boolean) mfVar.a(b().a())).booleanValue()) {
            for (kj kjVar : this.a) {
                if (lyVar.c()) {
                    AppMethodBeat.o(100237);
                    return;
                }
                kjVar.a(mfVar, lyVar);
            }
            AppMethodBeat.o(100237);
            return;
        }
        AppMethodBeat.o(100237);
    }

    public final int c() {
        AppMethodBeat.i(100238);
        int size = this.a.size();
        AppMethodBeat.o(100238);
        return size;
    }

    /* Access modifiers changed, original: final */
    public final List<? extends kj<T, S>> a() {
        return this.a;
    }

    public final List<kj<T, S>> a(kg<? extends T, ? extends S> kgVar) {
        AppMethodBeat.i(100239);
        kj a = this.c.d().a(kgVar.b().a(), this.a);
        List a2 = ks.a(this.a, a, a.a(kgVar));
        if (a2.size() <= this.c.a()) {
            a2 = Collections.singletonList(new kl(a2, this.c));
            AppMethodBeat.o(100239);
            return a2;
        }
        List<kj<T, S>> a3 = a(this.c.c().a(a2, this.c.b()));
        AppMethodBeat.o(100239);
        return a3;
    }

    private List<kj<T, S>> a(kw<? extends kj<T, S>> kwVar) {
        AppMethodBeat.i(100240);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new kl(kwVar.a().a(), this.c));
        arrayList.add(new kl(kwVar.b().a(), this.c));
        AppMethodBeat.o(100240);
        return arrayList;
    }
}
