package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.kd */
final class C44531kd {

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.kd$a */
    static class C44530a<T> {
        /* renamed from: a */
        private final C44532kz<T> f17475a;
        /* renamed from: b */
        private final long f17476b;

        C44530a(C44532kz<T> c44532kz, long j) {
            this.f17475a = c44532kz;
            this.f17476b = j;
        }

        /* renamed from: a */
        static <T> C44530a<T> m80817a(C44532kz<T> c44532kz, long j) {
            AppMethodBeat.m2504i(100201);
            C44530a c44530a = new C44530a(c44532kz, j);
            AppMethodBeat.m2505o(100201);
            return c44530a;
        }
    }

    /* renamed from: a */
    static <T, S extends C36529kt> C44532kz<C36526kk<T, S>> m80824a(C31081mf<? super C36529kt, Boolean> c31081mf, C5908ly<? super C16298kg<T, S>> c5908ly, C44532kz<C36526kk<T, S>> c44532kz, long j) {
        AppMethodBeat.m2504i(100202);
        C44532kz a = C44531kd.m80823a((C31081mf) c31081mf, (C5908ly) c5908ly, C44530a.m80817a(c44532kz, j));
        AppMethodBeat.m2505o(100202);
        return a;
    }

    /* renamed from: a */
    private static <S extends C36529kt, T> C44532kz<C36526kk<T, S>> m80823a(C31081mf<? super C36529kt, Boolean> c31081mf, C5908ly<? super C16298kg<T, S>> c5908ly, C44530a<C36526kk<T, S>> c44530a) {
        C44530a c44530a2;
        C44532kz<C36526kk<T, S>> a;
        AppMethodBeat.m2504i(100203);
        while (!c44530a2.f17475a.mo70915b()) {
            C36526kk c36526kk = (C36526kk) c44530a2.f17475a.mo70916c();
            if (c5908ly.mo12544c()) {
                C44532kz a2 = C44532kz.m80825a();
                AppMethodBeat.m2505o(100203);
                return a2;
            } else if (c44530a2.f17476b <= 0) {
                a = c44530a2.f17475a;
                AppMethodBeat.m2505o(100203);
                return a;
            } else if (c36526kk.mo57768b() == c36526kk.mo57767a().mo65163c()) {
                c44530a2 = C44530a.m80817a(C44531kd.m80821a(c44530a2.f17475a), c44530a2.f17476b);
            } else if (c36526kk.mo57767a() instanceof C41071kl) {
                c44530a2 = C44530a.m80817a(C44531kd.m80822a((C31081mf) c31081mf, c44530a2.f17475a, c36526kk), c44530a2.f17476b);
            } else {
                c44530a2 = C44531kd.m80820a((C31081mf) c31081mf, (C5908ly) c5908ly, c44530a2, c36526kk);
            }
        }
        a = c44530a2.f17475a;
        AppMethodBeat.m2505o(100203);
        return a;
    }

    /* renamed from: a */
    private static <T, S extends C36529kt> C44530a<C36526kk<T, S>> m80820a(C31081mf<? super C36529kt, Boolean> c31081mf, C5908ly<? super C16298kg<T, S>> c5908ly, C44530a<C36526kk<T, S>> c44530a, C36526kk<T, S> c36526kk) {
        long b;
        AppMethodBeat.m2504i(100204);
        C16298kg c16298kg = (C16298kg) ((C41070ki) c36526kk.mo57767a()).mo65160a().get(c36526kk.mo57768b());
        if (((Boolean) c31081mf.mo12522a(c16298kg.mo29553b())).booleanValue()) {
            c5908ly.mo57773a((Object) c16298kg);
            b = c44530a.f17476b - 1;
        } else {
            b = c44530a.f17476b;
        }
        C44530a a = C44530a.m80817a(c44530a.f17475a.mo70917d().mo70914b(c36526kk.mo57769c()), b);
        AppMethodBeat.m2505o(100204);
        return a;
    }

    /* renamed from: a */
    private static <S extends C36529kt, T> C44532kz<C36526kk<T, S>> m80821a(C44532kz<C36526kk<T, S>> c44532kz) {
        C44532kz<C36526kk<T, S>> c44532kz2;
        AppMethodBeat.m2504i(100205);
        C44532kz<C36526kk<T, S>> d = c44532kz.mo70917d();
        if (d.mo70915b()) {
            c44532kz2 = d;
        } else {
            c44532kz2 = d.mo70917d().mo70914b(((C36526kk) d.mo70916c()).mo57769c());
        }
        AppMethodBeat.m2505o(100205);
        return c44532kz2;
    }

    /* renamed from: a */
    private static <S extends C36529kt, T> C44532kz<C36526kk<T, S>> m80822a(C31081mf<? super C36529kt, Boolean> c31081mf, C44532kz<C36526kk<T, S>> c44532kz, C36526kk<T, S> c36526kk) {
        C44532kz<C36526kk<T, S>> b;
        AppMethodBeat.m2504i(100206);
        C46800kj c46800kj = (C46800kj) ((C41071kl) c36526kk.mo57767a()).mo65164a().get(c36526kk.mo57768b());
        if (((Boolean) c31081mf.mo12522a(c46800kj.mo29553b())).booleanValue()) {
            b = c44532kz.mo70914b(new C36526kk(c46800kj, 0));
        } else {
            b = c44532kz.mo70917d().mo70914b(c36526kk.mo57769c());
        }
        AppMethodBeat.m2505o(100206);
        return b;
    }
}
