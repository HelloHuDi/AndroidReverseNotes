package a.i.b.a.c.d.b;

import a.a.ak;
import a.a.al;
import a.a.v;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.b.ab;
import a.i.b.a.c.e.a.c;
import a.i.b.a.c.e.a.s;
import a.i.b.a.c.e.b.a.g;
import a.i.b.a.c.e.b.a.h;
import a.i.b.a.c.f.f;
import a.i.b.a.c.j.a.i;
import a.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Set;

public final class e {
    private static final Set<a.i.b.a.c.d.b.a.a.a> Brm = ak.setOf(a.i.b.a.c.d.b.a.a.a.CLASS);
    private static final Set<a.i.b.a.c.d.b.a.a.a> Brn = al.setOf(a.i.b.a.c.d.b.a.a.a.FILE_FACADE, a.i.b.a.c.d.b.a.a.a.MULTIFILE_CLASS_PART);
    private static final g Bro = new g(1, 1, 2);
    private static final g Brp = new g(1, 1, 11);
    private static final g Brq = new g(1, 1, 13);
    public static final a Brr = new a();
    public i Brl;

    static final class b extends k implements a.f.a.a<List<? extends f>> {
        public static final b Brs = new b();

        static {
            AppMethodBeat.i(120251);
            AppMethodBeat.o(120251);
        }

        b() {
            super(0);
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            return v.AUP;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public final i ecp() {
        AppMethodBeat.i(120252);
        i iVar = this.Brl;
        if (iVar == null) {
            j.avw("components");
        }
        AppMethodBeat.o(120252);
        return iVar;
    }

    private final boolean ecq() {
        AppMethodBeat.i(120253);
        if (this.Brl == null) {
            j.avw("components");
        }
        AppMethodBeat.o(120253);
        return false;
    }

    public final a.i.b.a.c.j.a.e a(n nVar) {
        AppMethodBeat.i(120254);
        j.p(nVar, "kotlinClass");
        String[] a = a(nVar, Brm);
        if (a == null) {
            AppMethodBeat.o(120254);
            return null;
        }
        String[] strArr = nVar.dXA().strings;
        if (strArr == null) {
            AppMethodBeat.o(120254);
            return null;
        }
        o d;
        try {
            d = a.i.b.a.c.e.b.a.j.d(a, strArr);
        } catch (a.i.b.a.c.g.k e) {
            Throwable illegalStateException = new IllegalStateException("Could not read data from " + nVar.getLocation(), e);
            AppMethodBeat.o(120254);
            throw illegalStateException;
        } catch (Throwable th) {
            ecq();
            if (nVar.dXA().Bsd.ehy()) {
                AppMethodBeat.o(120254);
            } else {
                d = null;
            }
        }
        if (d == null) {
            AppMethodBeat.o(120254);
            return null;
        }
        h hVar = (h) d.first;
        a.i.b.a.c.j.a.e eVar = new a.i.b.a.c.j.a.e(hVar, (c) d.second, nVar.dXA().Bsd, new p(nVar, b(nVar), c(nVar)));
        AppMethodBeat.o(120254);
        return eVar;
    }

    public final a.i.b.a.c.i.e.h a(ab abVar, n nVar) {
        AppMethodBeat.i(120255);
        j.p(abVar, "descriptor");
        j.p(nVar, "kotlinClass");
        String[] a = a(nVar, Brn);
        if (a == null) {
            AppMethodBeat.o(120255);
            return null;
        }
        String[] strArr = nVar.dXA().strings;
        if (strArr == null) {
            AppMethodBeat.o(120255);
            return null;
        }
        o e;
        try {
            e = a.i.b.a.c.e.b.a.j.e(a, strArr);
        } catch (a.i.b.a.c.g.k e2) {
            Throwable illegalStateException = new IllegalStateException("Could not read data from " + nVar.getLocation(), e2);
            AppMethodBeat.o(120255);
            throw illegalStateException;
        } catch (Throwable th) {
            ecq();
            if (nVar.dXA().Bsd.ehy()) {
                AppMethodBeat.o(120255);
            } else {
                e = null;
            }
        }
        if (e == null) {
            AppMethodBeat.o(120255);
            return null;
        }
        h hVar = (h) e.first;
        s sVar = (s) e.second;
        a.i.b.a.c.e.a.c cVar = hVar;
        a.i.b.a.c.e.a.a aVar = nVar.dXA().Bsd;
        a.i.b.a.c.j.a.a.e iVar = new i(nVar, sVar, hVar, b(nVar), c(nVar));
        i iVar2 = this.Brl;
        if (iVar2 == null) {
            j.avw("components");
        }
        a.i.b.a.c.i.e.h hVar2 = new a.i.b.a.c.j.a.a.h(abVar, sVar, cVar, aVar, iVar, iVar2, b.Brs);
        AppMethodBeat.o(120255);
        return hVar2;
    }

    private final a.i.b.a.c.j.a.o<g> b(n nVar) {
        AppMethodBeat.i(120256);
        ecq();
        if (nVar.dXA().Bsd.ehy()) {
            AppMethodBeat.o(120256);
            return null;
        }
        a.i.b.a.c.j.a.o<g> oVar = new a.i.b.a.c.j.a.o(nVar.dXA().Bsd, g.Byu, nVar.getLocation(), nVar.dWY());
        AppMethodBeat.o(120256);
        return oVar;
    }

    private final boolean c(n nVar) {
        AppMethodBeat.i(120257);
        if (this.Brl == null) {
            j.avw("components");
        }
        if (d(nVar)) {
            AppMethodBeat.o(120257);
            return true;
        }
        AppMethodBeat.o(120257);
        return false;
    }

    private final boolean d(n nVar) {
        AppMethodBeat.i(120258);
        if (this.Brl == null) {
            j.avw("components");
        }
        if (nVar.dXA().ecw() && j.j(nVar.dXA().Bsd, Brp)) {
            AppMethodBeat.o(120258);
            return true;
        }
        AppMethodBeat.o(120258);
        return false;
    }

    private static String[] a(n nVar, Set<? extends a.i.b.a.c.d.b.a.a.a> set) {
        AppMethodBeat.i(120259);
        j.p(nVar, "kotlinClass");
        j.p(set, "expectedKinds");
        a.i.b.a.c.d.b.a.a dXA = nVar.dXA();
        String[] strArr = dXA.Bsf;
        if (strArr == null) {
            strArr = dXA.Bsg;
        }
        if (strArr == null) {
            AppMethodBeat.o(120259);
            return null;
        } else if (set.contains(dXA.Bsc)) {
            AppMethodBeat.o(120259);
            return strArr;
        } else {
            AppMethodBeat.o(120259);
            return null;
        }
    }

    static {
        AppMethodBeat.i(120260);
        AppMethodBeat.o(120260);
    }
}
