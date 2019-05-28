package a.i.b.a.c.d.a;

import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.ag;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.al;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.l;
import a.i.b.a.c.f.f;
import a.i.b.a.c.i.d;
import a.i.b.a.c.l.a.q;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.w;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t {

    static final class b extends k implements a.f.a.b<a.i.b.a.c.b.b, Boolean> {
        public static final b BlM = new b();

        static {
            AppMethodBeat.i(119730);
            AppMethodBeat.o(119730);
        }

        b() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119729);
            a.i.b.a.c.b.b bVar = (a.i.b.a.c.b.b) obj;
            j.p(bVar, "it");
            c cVar = c.Bky;
            Boolean valueOf = Boolean.valueOf(c.b((al) bVar));
            AppMethodBeat.o(119729);
            return valueOf;
        }
    }

    static final class c extends k implements a.f.a.b<a.i.b.a.c.b.b, Boolean> {
        public static final c BlN = new c();

        static {
            AppMethodBeat.i(119732);
            AppMethodBeat.o(119732);
        }

        c() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119731);
            a.i.b.a.c.b.b bVar = (a.i.b.a.c.b.b) obj;
            j.p(bVar, "it");
            boolean z = g.b((l) bVar) && d.j(bVar) != null;
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(119731);
            return valueOf;
        }
    }

    static final class a extends k implements a.f.a.b<a.i.b.a.c.b.b, Boolean> {
        public static final a BlL = new a();

        static {
            AppMethodBeat.i(119728);
            AppMethodBeat.o(119728);
        }

        a() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119727);
            a.i.b.a.c.b.b bVar = (a.i.b.a.c.b.b) obj;
            j.p(bVar, "it");
            e eVar = e.BkZ;
            Boolean valueOf = Boolean.valueOf(e.l(a.i.b.a.c.i.c.a.x(bVar)));
            AppMethodBeat.o(119727);
            return valueOf;
        }
    }

    static final a.i.b.a.c.f.b a(a.i.b.a.c.f.b bVar, String str) {
        AppMethodBeat.i(119733);
        a.i.b.a.c.f.b q = bVar.q(f.avX(str));
        j.o(q, "child(Name.identifier(name))");
        AppMethodBeat.o(119733);
        return q;
    }

    static final a.i.b.a.c.f.b b(a.i.b.a.c.f.c cVar, String str) {
        AppMethodBeat.i(119734);
        a.i.b.a.c.f.b ehI = cVar.t(f.avX(str)).ehI();
        j.o(ehI, "child(Name.identifier(name)).toSafe()");
        AppMethodBeat.o(119734);
        return ehI;
    }

    static final r v(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(119735);
        f avX = f.avX(str2);
        j.o(avX, "Name.identifier(name)");
        a.i.b.a.c.d.b.t tVar = a.i.b.a.c.d.b.t.BrJ;
        r rVar = new r(avX, a.i.b.a.c.d.b.t.iV(str, str2 + '(' + str3 + ')' + str4));
        AppMethodBeat.o(119735);
        return rVar;
    }

    public static final <T extends a.i.b.a.c.b.b> T n(T t) {
        AppMethodBeat.i(119736);
        j.p(t, "receiver$0");
        c cVar = c.Bky;
        if (!c.eaU().contains(t.dZg())) {
            e eVar = e.BkZ;
            if (!e.eaW().contains(a.i.b.a.c.i.c.a.x(t).dZg())) {
                AppMethodBeat.o(119736);
                return null;
            }
        }
        T b;
        if ((t instanceof ah) || (t instanceof ag)) {
            b = a.i.b.a.c.i.c.a.b(t, a.BlL);
            AppMethodBeat.o(119736);
            return b;
        } else if (t instanceof al) {
            b = a.i.b.a.c.i.c.a.b(t, b.BlM);
            AppMethodBeat.o(119736);
            return b;
        } else {
            AppMethodBeat.o(119736);
            return null;
        }
    }

    public static final boolean o(a.i.b.a.c.b.b bVar) {
        AppMethodBeat.i(119737);
        j.p(bVar, "receiver$0");
        if (n(bVar) != null) {
            AppMethodBeat.o(119737);
            return true;
        }
        AppMethodBeat.o(119737);
        return false;
    }

    public static final <T extends a.i.b.a.c.b.b> T p(T t) {
        AppMethodBeat.i(119738);
        j.p(t, "receiver$0");
        a.i.b.a.c.b.b n = n(t);
        if (n != null) {
            AppMethodBeat.o(119738);
            return n;
        }
        d dVar = d.BkH;
        f dZg = t.dZg();
        j.o(dZg, "name");
        if (d.h(dZg)) {
            T b = a.i.b.a.c.i.c.a.b(t, c.BlN);
            AppMethodBeat.o(119738);
            return b;
        }
        AppMethodBeat.o(119738);
        return null;
    }

    public static final String q(a.i.b.a.c.b.b bVar) {
        AppMethodBeat.i(119739);
        j.p(bVar, "callableMemberDescriptor");
        a.i.b.a.c.b.b r = r(bVar);
        if (r != null) {
            r = a.i.b.a.c.i.c.a.x(r);
            if (r != null) {
                String m;
                if (r instanceof ah) {
                    e eVar = e.BkZ;
                    m = e.m(r);
                    AppMethodBeat.o(119739);
                    return m;
                }
                if (r instanceof al) {
                    c cVar = c.Bky;
                    f a = c.a((al) r);
                    if (a != null) {
                        m = a.name;
                        AppMethodBeat.o(119739);
                        return m;
                    }
                }
                AppMethodBeat.o(119739);
                return null;
            }
        }
        AppMethodBeat.o(119739);
        return null;
    }

    private static final a.i.b.a.c.b.b r(a.i.b.a.c.b.b bVar) {
        AppMethodBeat.i(119740);
        if (g.b((l) bVar)) {
            a.i.b.a.c.b.b n = n(bVar);
            AppMethodBeat.o(119740);
            return n;
        }
        AppMethodBeat.o(119740);
        return null;
    }

    public static final boolean a(e eVar, a.i.b.a.c.b.a aVar) {
        AppMethodBeat.i(119741);
        j.p(eVar, "receiver$0");
        j.p(aVar, "specialCallableDescriptor");
        l dXW = aVar.dXW();
        if (dXW == null) {
            v vVar = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            AppMethodBeat.o(119741);
            throw vVar;
        }
        ad dZf = ((e) dXW).dZf();
        j.o(dZf, "(specialCallableDescript…ssDescriptor).defaultType");
        for (e x = d.x(eVar); x != null; x = d.x(x)) {
            if (!(x instanceof a.i.b.a.c.d.a.b.d)) {
                if ((q.e((w) x.dZf(), (w) dZf) != null ? 1 : null) != null) {
                    if (g.b((l) x)) {
                        AppMethodBeat.o(119741);
                        return false;
                    }
                    AppMethodBeat.o(119741);
                    return true;
                }
            }
        }
        AppMethodBeat.o(119741);
        return false;
    }

    public static final boolean s(a.i.b.a.c.b.b bVar) {
        AppMethodBeat.i(119742);
        j.p(bVar, "receiver$0");
        j.p(bVar, "receiver$0");
        if ((a.i.b.a.c.i.c.a.x(bVar).dXW() instanceof a.i.b.a.c.d.a.b.d) || g.b((l) bVar)) {
            AppMethodBeat.o(119742);
            return true;
        }
        AppMethodBeat.o(119742);
        return false;
    }
}
