package a.i.b.a.c.d.a.c.b;

import a.a.t;
import a.aa;
import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.b.e;
import a.i.b.a.c.h.i;
import a.i.b.a.c.i.e.h;
import a.i.b.a.c.l.ac;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.az;
import a.i.b.a.c.l.q;
import a.i.b.a.c.l.w;
import a.k.v;
import a.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class g extends q implements ac {

    static final class a extends k implements m<String, String, Boolean> {
        public static final a Bpr = new a();

        static {
            AppMethodBeat.i(120065);
            AppMethodBeat.o(120065);
        }

        a() {
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(120063);
            Boolean valueOf = Boolean.valueOf(iR((String) obj, (String) obj2));
            AppMethodBeat.o(120063);
            return valueOf;
        }

        public static boolean iR(String str, String str2) {
            AppMethodBeat.i(120064);
            j.p(str, "first");
            j.p(str2, "second");
            if (j.j(str, v.b(str2, (CharSequence) "out ")) || j.j(str2, "*")) {
                AppMethodBeat.o(120064);
                return true;
            }
            AppMethodBeat.o(120064);
            return false;
        }
    }

    static final class b extends k implements a.f.a.b<w, List<? extends String>> {
        final /* synthetic */ a.i.b.a.c.h.c Bps;

        b(a.i.b.a.c.h.c cVar) {
            this.Bps = cVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(120066);
            List Q = Q((w) obj);
            AppMethodBeat.o(120066);
            return Q;
        }

        public final List<String> Q(w wVar) {
            AppMethodBeat.i(120067);
            j.p(wVar, "type");
            Iterable<ap> ejt = wVar.ejt();
            Collection arrayList = new ArrayList(a.a.m.d(ejt));
            for (ap a : ejt) {
                arrayList.add(this.Bps.a(a));
            }
            List list = (List) arrayList;
            AppMethodBeat.o(120067);
            return list;
        }
    }

    static final class d extends k implements a.f.a.b<String, String> {
        public static final d Bpu = new d();

        static {
            AppMethodBeat.i(120072);
            AppMethodBeat.o(120072);
        }

        d() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(120071);
            String str = (String) obj;
            j.p(str, "it");
            String concat = "(raw) ".concat(String.valueOf(str));
            AppMethodBeat.o(120071);
            return concat;
        }
    }

    static final class c extends k implements m<String, String, String> {
        public static final c Bpt = new c();

        static {
            AppMethodBeat.i(120070);
            AppMethodBeat.o(120070);
        }

        c() {
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(120068);
            String iS = iS((String) obj, (String) obj2);
            AppMethodBeat.o(120068);
            return iS;
        }

        public static String iS(String str, String str2) {
            AppMethodBeat.i(120069);
            j.p(str, "receiver$0");
            j.p(str2, "newArgs");
            if (v.b((CharSequence) str, '<')) {
                str = v.jd(str, str) + '<' + str2 + '>' + v.a(str, '>');
                AppMethodBeat.o(120069);
                return str;
            }
            AppMethodBeat.o(120069);
            return str;
        }
    }

    public g(ad adVar, ad adVar2) {
        j.p(adVar, "lowerBound");
        j.p(adVar2, "upperBound");
        super(adVar, adVar2);
        AppMethodBeat.i(120077);
        boolean c = a.i.b.a.c.l.a.c.BKs.c(adVar, adVar2);
        if (!aa.AUz || c) {
            AppMethodBeat.o(120077);
            return;
        }
        Throwable assertionError = new AssertionError("Lower bound " + adVar + " of a flexible type must be a subtype of the upper bound " + adVar2);
        AppMethodBeat.o(120077);
        throw assertionError;
    }

    public final /* synthetic */ az b(a.i.b.a.c.b.a.g gVar) {
        AppMethodBeat.i(120074);
        j.p(gVar, "newAnnotations");
        az gVar2 = new g(this.BJx.d(gVar), this.BJy.d(gVar));
        AppMethodBeat.o(120074);
        return gVar2;
    }

    public final h dXR() {
        AppMethodBeat.i(120073);
        a.i.b.a.c.b.h dYs = ejw().dYs();
        if (!(dYs instanceof e)) {
            dYs = null;
        }
        e eVar = (e) dYs;
        if (eVar == null) {
            Throwable illegalStateException = new IllegalStateException(("Incorrect classifier: " + ejw().dYs()).toString());
            AppMethodBeat.o(120073);
            throw illegalStateException;
        }
        h a = eVar.a(e.Bpq);
        j.o(a, "classDescriptor.getMemberScope(RawSubstitution)");
        AppMethodBeat.o(120073);
        return a;
    }

    public final String a(a.i.b.a.c.h.c cVar, i iVar) {
        int i = 0;
        AppMethodBeat.i(120076);
        j.p(cVar, "renderer");
        j.p(iVar, "options");
        a aVar = a.Bpr;
        b bVar = new b(cVar);
        c cVar2 = c.Bpt;
        String b = cVar.b(this.BJx);
        String b2 = cVar.b(this.BJy);
        String str;
        if (iVar.eiS()) {
            str = "raw (" + b + ".." + b2 + ')';
            AppMethodBeat.o(120076);
            return str;
        } else if (this.BJy.ejt().isEmpty()) {
            str = cVar.a(b, b2, a.i.b.a.c.l.c.a.aL(this));
            AppMethodBeat.o(120076);
            return str;
        } else {
            Object iS;
            List Q = bVar.Q(this.BJx);
            List Q2 = bVar.Q(this.BJy);
            String a = t.a((Iterable) Q, (CharSequence) ", ", null, null, 0, null, (a.f.a.b) d.Bpu, 30);
            Iterable<o> a2 = t.a((Iterable) Q, (Iterable) Q2);
            if (!((Collection) a2).isEmpty()) {
                for (o oVar : a2) {
                    aVar = a.Bpr;
                    if (!a.iR((String) oVar.first, (String) oVar.second)) {
                        break;
                    }
                }
            }
            i = 1;
            if (i != 0) {
                iS = c.iS(b2, a);
            } else {
                str = b2;
            }
            String iS2 = c.iS(b, a);
            if (j.j(iS2, iS)) {
                AppMethodBeat.o(120076);
                return iS2;
            }
            str = cVar.a(iS2, iS, a.i.b.a.c.l.c.a.aL(this));
            AppMethodBeat.o(120076);
            return str;
        }
    }

    public final ad eby() {
        return this.BJx;
    }

    public final /* synthetic */ az rK(boolean z) {
        AppMethodBeat.i(120075);
        az gVar = new g(this.BJx.rL(z), this.BJy.rL(z));
        AppMethodBeat.o(120075);
        return gVar;
    }
}
