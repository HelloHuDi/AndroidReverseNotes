package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class ki<T, S extends kt> implements kj<T, S> {
    private final List<kg<T, S>> a;
    private final ky b;
    private final kf c;

    ki(List<kg<T, S>> list, kf kfVar) {
        AppMethodBeat.i(100230);
        this.a = list;
        this.c = kfVar;
        this.b = ks.a(list);
        AppMethodBeat.o(100230);
    }

    public final kt b() {
        return this.b;
    }

    /* Access modifiers changed, original: final */
    public final List<kg<T, S>> a() {
        return this.a;
    }

    public final void a(mf<? super kt, Boolean> mfVar, ly<? super kg<T, S>> lyVar) {
        AppMethodBeat.i(100231);
        if (((Boolean) mfVar.a(b().a())).booleanValue()) {
            for (kg kgVar : this.a) {
                if (lyVar.c()) {
                    AppMethodBeat.o(100231);
                    return;
                } else if (((Boolean) mfVar.a(kgVar.b())).booleanValue()) {
                    lyVar.a((Object) kgVar);
                }
            }
            AppMethodBeat.o(100231);
            return;
        }
        AppMethodBeat.o(100231);
    }

    public final int c() {
        AppMethodBeat.i(100232);
        int size = this.a.size();
        AppMethodBeat.o(100232);
        return size;
    }

    public final List<kj<T, S>> a(kg<? extends T, ? extends S> kgVar) {
        AppMethodBeat.i(100233);
        List a = ks.a(this.a, kgVar);
        if (a.size() <= this.c.a()) {
            a = Collections.singletonList(new ki(a, this.c));
            AppMethodBeat.o(100233);
            return a;
        }
        List<kj<T, S>> a2 = a(this.c.c().a(a, this.c.b()));
        AppMethodBeat.o(100233);
        return a2;
    }

    private List<kj<T, S>> a(kw<kg<T, S>> kwVar) {
        AppMethodBeat.i(100234);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ki(kwVar.a().a(), this.c));
        arrayList.add(new ki(kwVar.b().a(), this.c));
        AppMethodBeat.o(100234);
        return arrayList;
    }
}
