package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class kd {

    static class a<T> {
        private final kz<T> a;
        private final long b;

        a(kz<T> kzVar, long j) {
            this.a = kzVar;
            this.b = j;
        }

        static <T> a<T> a(kz<T> kzVar, long j) {
            AppMethodBeat.i(100201);
            a aVar = new a(kzVar, j);
            AppMethodBeat.o(100201);
            return aVar;
        }
    }

    static <T, S extends kt> kz<kk<T, S>> a(mf<? super kt, Boolean> mfVar, ly<? super kg<T, S>> lyVar, kz<kk<T, S>> kzVar, long j) {
        AppMethodBeat.i(100202);
        kz a = a((mf) mfVar, (ly) lyVar, a.a(kzVar, j));
        AppMethodBeat.o(100202);
        return a;
    }

    private static <S extends kt, T> kz<kk<T, S>> a(mf<? super kt, Boolean> mfVar, ly<? super kg<T, S>> lyVar, a<kk<T, S>> aVar) {
        a aVar2;
        kz<kk<T, S>> a;
        AppMethodBeat.i(100203);
        while (!aVar2.a.b()) {
            kk kkVar = (kk) aVar2.a.c();
            if (lyVar.c()) {
                kz a2 = kz.a();
                AppMethodBeat.o(100203);
                return a2;
            } else if (aVar2.b <= 0) {
                a = aVar2.a;
                AppMethodBeat.o(100203);
                return a;
            } else if (kkVar.b() == kkVar.a().c()) {
                aVar2 = a.a(a(aVar2.a), aVar2.b);
            } else if (kkVar.a() instanceof kl) {
                aVar2 = a.a(a((mf) mfVar, aVar2.a, kkVar), aVar2.b);
            } else {
                aVar2 = a((mf) mfVar, (ly) lyVar, aVar2, kkVar);
            }
        }
        a = aVar2.a;
        AppMethodBeat.o(100203);
        return a;
    }

    private static <T, S extends kt> a<kk<T, S>> a(mf<? super kt, Boolean> mfVar, ly<? super kg<T, S>> lyVar, a<kk<T, S>> aVar, kk<T, S> kkVar) {
        long b;
        AppMethodBeat.i(100204);
        kg kgVar = (kg) ((ki) kkVar.a()).a().get(kkVar.b());
        if (((Boolean) mfVar.a(kgVar.b())).booleanValue()) {
            lyVar.a((Object) kgVar);
            b = aVar.b - 1;
        } else {
            b = aVar.b;
        }
        a a = a.a(aVar.a.d().b(kkVar.c()), b);
        AppMethodBeat.o(100204);
        return a;
    }

    private static <S extends kt, T> kz<kk<T, S>> a(kz<kk<T, S>> kzVar) {
        kz<kk<T, S>> kzVar2;
        AppMethodBeat.i(100205);
        kz<kk<T, S>> d = kzVar.d();
        if (d.b()) {
            kzVar2 = d;
        } else {
            kzVar2 = d.d().b(((kk) d.c()).c());
        }
        AppMethodBeat.o(100205);
        return kzVar2;
    }

    private static <S extends kt, T> kz<kk<T, S>> a(mf<? super kt, Boolean> mfVar, kz<kk<T, S>> kzVar, kk<T, S> kkVar) {
        kz<kk<T, S>> b;
        AppMethodBeat.i(100206);
        kj kjVar = (kj) ((kl) kkVar.a()).a().get(kkVar.b());
        if (((Boolean) mfVar.a(kjVar.b())).booleanValue()) {
            b = kzVar.b(new kk(kjVar, 0));
        } else {
            b = kzVar.d().b(kkVar.c());
        }
        AppMethodBeat.o(100206);
        return b;
    }
}
