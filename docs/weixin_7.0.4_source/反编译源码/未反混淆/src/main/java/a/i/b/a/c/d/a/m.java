package a.i.b.a.c.d.a;

import a.aa;
import a.f.b.j;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.al;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.h;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.t;
import a.i.b.a.c.d.a.b.d;
import a.i.b.a.c.d.b.j.c;
import a.i.b.a.c.d.b.r;
import a.i.b.a.c.f.f;
import a.i.b.a.c.i.e;
import a.i.b.a.c.i.e.b;
import a.i.b.a.c.l.w;
import a.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class m implements e {
    public static final a Blf = new a();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static boolean a(a.i.b.a.c.b.a aVar, a.i.b.a.c.b.a aVar2) {
            AppMethodBeat.i(119696);
            j.p(aVar, "superDescriptor");
            j.p(aVar2, "subDescriptor");
            if ((aVar2 instanceof a.i.b.a.c.d.a.b.e) && (aVar instanceof t)) {
                boolean z = ((a.i.b.a.c.d.a.b.e) aVar2).BhM.size() == ((t) aVar).dYV().size();
                if (!aa.AUz || z) {
                    al eaK = ((a.i.b.a.c.d.a.b.e) aVar2).eaK();
                    j.o(eaK, "subDescriptor.original");
                    List dYV = eaK.dYV();
                    j.o(dYV, "subDescriptor.original.valueParameters");
                    Iterable iterable = dYV;
                    t dZp = ((t) aVar).dZp();
                    j.o(dZp, "superDescriptor.original");
                    List dYV2 = dZp.dYV();
                    j.o(dYV2, "superDescriptor.original.valueParameters");
                    for (o oVar : a.a.t.a(iterable, (Iterable) dYV2)) {
                        au auVar = (au) oVar.first;
                        au auVar2 = (au) oVar.second;
                        t tVar = (t) aVar2;
                        j.o(auVar, "subParameter");
                        boolean z2 = a(tVar, auVar) instanceof c;
                        dZp = (t) aVar;
                        j.o(auVar2, "superParameter");
                        if (z2 != (a(dZp, auVar2) instanceof c)) {
                            AppMethodBeat.o(119696);
                            return true;
                        }
                    }
                    AppMethodBeat.o(119696);
                    return false;
                }
                Throwable assertionError = new AssertionError("External overridability condition with CONFLICTS_ONLY should not be run with different value parameters size");
                AppMethodBeat.o(119696);
                throw assertionError;
            }
            AppMethodBeat.o(119696);
            return false;
        }

        private static a.i.b.a.c.d.b.j a(t tVar, au auVar) {
            AppMethodBeat.i(119697);
            w dZS;
            a.i.b.a.c.d.b.j V;
            if (r.b(tVar) || f(tVar)) {
                dZS = auVar.dZS();
                j.o(dZS, "valueParameterDescriptor.type");
                V = r.V(a.i.b.a.c.l.c.a.az(dZS));
                AppMethodBeat.o(119697);
                return V;
            }
            dZS = auVar.dZS();
            j.o(dZS, "valueParameterDescriptor.type");
            V = r.V(dZS);
            AppMethodBeat.o(119697);
            return V;
        }

        private static boolean f(t tVar) {
            AppMethodBeat.i(119698);
            if (tVar.dYV().size() != 1) {
                AppMethodBeat.o(119698);
                return false;
            }
            l dXW = tVar.dXW();
            if (!(dXW instanceof a.i.b.a.c.b.e)) {
                dXW = null;
            }
            a.i.b.a.c.b.e eVar = (a.i.b.a.c.b.e) dXW;
            if (eVar == null) {
                AppMethodBeat.o(119698);
                return false;
            }
            List dYV = tVar.dYV();
            j.o(dYV, "f.valueParameters");
            Object fN = a.a.t.fN(dYV);
            j.o(fN, "f.valueParameters.single()");
            h dYs = ((au) fN).dZS().ejw().dYs();
            if (!(dYs instanceof a.i.b.a.c.b.e)) {
                dYs = null;
            }
            a.i.b.a.c.b.e eVar2 = (a.i.b.a.c.b.e) dYs;
            if (eVar2 == null) {
                AppMethodBeat.o(119698);
                return false;
            } else if (g.d(eVar) && j.j(a.i.b.a.c.i.c.a.o(eVar), a.i.b.a.c.i.c.a.o(eVar2))) {
                AppMethodBeat.o(119698);
                return true;
            } else {
                AppMethodBeat.o(119698);
                return false;
            }
        }
    }

    static {
        AppMethodBeat.i(119700);
        AppMethodBeat.o(119700);
    }

    public final a.i.b.a.c.i.e.a eaX() {
        return a.i.b.a.c.i.e.a.CONFLICTS_ONLY;
    }

    public final b a(a.i.b.a.c.b.a aVar, a.i.b.a.c.b.a aVar2, a.i.b.a.c.b.e eVar) {
        boolean z;
        AppMethodBeat.i(119699);
        j.p(aVar, "superDescriptor");
        j.p(aVar2, "subDescriptor");
        if ((aVar instanceof a.i.b.a.c.b.b) && (aVar2 instanceof t) && !g.b((l) aVar2)) {
            a.i.b.a.c.b.a aVar3;
            d dVar = d.BkH;
            f dZg = ((t) aVar2).dZg();
            j.o(dZg, "subDescriptor.name");
            if (!d.h(dZg)) {
                c cVar = c.Bky;
                dZg = ((t) aVar2).dZg();
                j.o(dZg, "subDescriptor.name");
                if (!c.f(dZg)) {
                    z = false;
                }
            }
            a.i.b.a.c.b.b p = t.p((a.i.b.a.c.b.b) aVar);
            boolean dZr = ((t) aVar2).dZr();
            if (aVar instanceof t) {
                aVar3 = aVar;
            } else {
                aVar3 = null;
            }
            t tVar = (t) aVar3;
            if (tVar == null || dZr != tVar.dZr()) {
                z = true;
            } else {
                z = false;
            }
            if (z && (p == null || !((t) aVar2).dZr())) {
                z = true;
            } else if (!(eVar instanceof d) || ((t) aVar2).dZq() != null) {
                z = false;
            } else if (p == null || t.a(eVar, (a.i.b.a.c.b.a) p)) {
                z = false;
            } else {
                if ((p instanceof t) && (aVar instanceof t) && d.e((t) p) != null) {
                    String a = r.a((t) aVar2, false, false, 2);
                    tVar = ((t) aVar).dZp();
                    j.o(tVar, "superDescriptor.original");
                    if (j.j(a, r.a(tVar, false, false, 2))) {
                        z = false;
                    }
                }
                z = true;
            }
        } else {
            z = false;
        }
        b bVar;
        if (z) {
            bVar = b.INCOMPATIBLE;
            AppMethodBeat.o(119699);
            return bVar;
        } else if (a.a(aVar, aVar2)) {
            bVar = b.INCOMPATIBLE;
            AppMethodBeat.o(119699);
            return bVar;
        } else {
            bVar = b.UNKNOWN;
            AppMethodBeat.o(119699);
            return bVar;
        }
    }
}
