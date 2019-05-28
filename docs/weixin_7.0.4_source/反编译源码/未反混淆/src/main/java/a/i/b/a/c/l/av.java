package a.i.b.a.c.l;

import a.a.t;
import a.f.a.b;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.h;
import a.i.b.a.c.l.a.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class av {
    static final /* synthetic */ boolean $assertionsDisabled = (!av.class.desiredAssertionStatus());
    public static final ad BKc = p.awo("DONT_CARE");
    public static final ad BKd = p.awn("Cannot be inferred");
    public static final ad BKe = new a("NO_EXPECTED_TYPE");
    public static final ad BKf = new a("UNIT_EXPECTED_TYPE");

    public static class a extends i {
        private final String name;

        public final /* synthetic */ az b(g gVar) {
            AppMethodBeat.i(122685);
            ad d = d(gVar);
            AppMethodBeat.o(122685);
            return d;
        }

        public final /* synthetic */ az rK(boolean z) {
            AppMethodBeat.i(122684);
            ad rL = rL(z);
            AppMethodBeat.o(122684);
            return rL;
        }

        public a(String str) {
            this.name = str;
        }

        /* Access modifiers changed, original: protected|final */
        public final ad eby() {
            AppMethodBeat.i(122681);
            IllegalStateException illegalStateException = new IllegalStateException(this.name);
            AppMethodBeat.o(122681);
            throw illegalStateException;
        }

        public final ad d(g gVar) {
            AppMethodBeat.i(122682);
            IllegalStateException illegalStateException = new IllegalStateException(this.name);
            AppMethodBeat.o(122682);
            throw illegalStateException;
        }

        public final ad rL(boolean z) {
            AppMethodBeat.i(122683);
            IllegalStateException illegalStateException = new IllegalStateException(this.name);
            AppMethodBeat.o(122683);
            throw illegalStateException;
        }

        public final String toString() {
            return this.name;
        }
    }

    static {
        AppMethodBeat.i(122700);
        AppMethodBeat.o(122700);
    }

    public static boolean ax(w wVar) {
        return wVar == BKe || wVar == BKf;
    }

    public static boolean ay(w wVar) {
        AppMethodBeat.i(122686);
        if (wVar == null || wVar.ejw() != BKc.ejw()) {
            AppMethodBeat.o(122686);
            return false;
        }
        AppMethodBeat.o(122686);
        return true;
    }

    public static w az(w wVar) {
        AppMethodBeat.i(122687);
        w a = a(wVar, true);
        AppMethodBeat.o(122687);
        return a;
    }

    public static w aA(w wVar) {
        AppMethodBeat.i(122688);
        w a = a(wVar, false);
        AppMethodBeat.o(122688);
        return a;
    }

    public static w a(w wVar, boolean z) {
        AppMethodBeat.i(122689);
        az rK = wVar.ekn().rK(z);
        AppMethodBeat.o(122689);
        return rK;
    }

    public static w b(w wVar, boolean z) {
        AppMethodBeat.i(122690);
        if (z) {
            wVar = a(wVar, true);
            AppMethodBeat.o(122690);
            return wVar;
        }
        AppMethodBeat.o(122690);
        return wVar;
    }

    public static ad a(h hVar, a.i.b.a.c.i.e.h hVar2) {
        AppMethodBeat.i(122691);
        ad awn;
        if (p.L(hVar)) {
            awn = p.awn("Unsubstituted type for ".concat(String.valueOf(hVar)));
            AppMethodBeat.o(122691);
            return awn;
        }
        an dXY = hVar.dXY();
        List ga = ga(dXY.getParameters());
        a.i.b.a.c.b.a.g.a aVar = g.BfJ;
        awn = x.a(a.i.b.a.c.b.a.g.a.eai(), dXY, ga, false, hVar2);
        AppMethodBeat.o(122691);
        return awn;
    }

    public static List<ap> ga(List<ar> list) {
        AppMethodBeat.i(122692);
        ArrayList arrayList = new ArrayList(list.size());
        for (ar dZf : list) {
            arrayList.add(new ar(dZf.dZf()));
        }
        List m = t.m(arrayList);
        AppMethodBeat.o(122692);
        return m;
    }

    public static boolean aB(w wVar) {
        AppMethodBeat.i(122693);
        w c;
        if (wVar.eci()) {
            AppMethodBeat.o(122693);
            return true;
        } else if (t.ai(wVar) && aB(t.aj(wVar).BJy)) {
            AppMethodBeat.o(122693);
            return true;
        } else if (aE(wVar)) {
            if (!(wVar.ejw().dYs() instanceof e)) {
                au aw = au.aw(wVar);
                Collection<w> eap = wVar.ejw().eap();
                ArrayList<w> arrayList = new ArrayList(eap.size());
                for (w c2 : eap) {
                    Object b;
                    c2 = aw.c(c2, ba.INVARIANT);
                    if (c2 != null) {
                        b = b(c2, wVar.eci());
                    } else {
                        b = null;
                    }
                    if (b != null) {
                        arrayList.add(b);
                    }
                }
                for (w c22 : arrayList) {
                    if (aB(c22)) {
                        AppMethodBeat.o(122693);
                        return true;
                    }
                }
            }
            AppMethodBeat.o(122693);
            return false;
        } else {
            an ejw = wVar.ejw();
            if (ejw instanceof v) {
                for (w c222 : ejw.eap()) {
                    if (aB(c222)) {
                        AppMethodBeat.o(122693);
                        return true;
                    }
                }
            }
            AppMethodBeat.o(122693);
            return false;
        }
    }

    public static boolean aC(w wVar) {
        AppMethodBeat.i(122694);
        if (wVar.eci()) {
            AppMethodBeat.o(122694);
            return true;
        } else if (t.ai(wVar) && aC(t.aj(wVar).BJy)) {
            AppMethodBeat.o(122694);
            return true;
        } else {
            AppMethodBeat.o(122694);
            return false;
        }
    }

    public static e aD(w wVar) {
        AppMethodBeat.i(122695);
        h dYs = wVar.ejw().dYs();
        if (dYs instanceof e) {
            e eVar = (e) dYs;
            AppMethodBeat.o(122695);
            return eVar;
        }
        AppMethodBeat.o(122695);
        return null;
    }

    public static boolean b(w wVar, b<az, Boolean> bVar) {
        AppMethodBeat.i(122696);
        if (wVar == null) {
            AppMethodBeat.o(122696);
            return false;
        }
        az ekn = wVar.ekn();
        if (((Boolean) bVar.am(ekn)).booleanValue()) {
            AppMethodBeat.o(122696);
            return true;
        }
        q qVar = ekn instanceof q ? (q) ekn : null;
        if (qVar != null && (b(qVar.BJx, (b) bVar) || b(qVar.BJy, (b) bVar))) {
            AppMethodBeat.o(122696);
            return true;
        } else if ((ekn instanceof g) && b(((g) ekn).BJh, (b) bVar)) {
            AppMethodBeat.o(122696);
            return true;
        } else {
            an ejw = wVar.ejw();
            if (ejw instanceof v) {
                for (w b : ((v) ejw).BJH) {
                    if (b(b, (b) bVar)) {
                        AppMethodBeat.o(122696);
                        return true;
                    }
                }
                AppMethodBeat.o(122696);
                return false;
            }
            for (ap apVar : wVar.ejt()) {
                if (!apVar.ekp() && b(apVar.dZS(), (b) bVar)) {
                    AppMethodBeat.o(122696);
                    return true;
                }
            }
            AppMethodBeat.o(122696);
            return false;
        }
    }

    public static ap e(ar arVar) {
        AppMethodBeat.i(122697);
        ah ahVar = new ah(arVar);
        AppMethodBeat.o(122697);
        return ahVar;
    }

    public static boolean aE(w wVar) {
        AppMethodBeat.i(122698);
        if (aF(wVar) != null || (wVar.ejw() instanceof k)) {
            AppMethodBeat.o(122698);
            return true;
        }
        AppMethodBeat.o(122698);
        return false;
    }

    private static ar aF(w wVar) {
        AppMethodBeat.i(122699);
        if (wVar.ejw().dYs() instanceof ar) {
            ar arVar = (ar) wVar.ejw().dYs();
            AppMethodBeat.o(122699);
            return arVar;
        }
        AppMethodBeat.o(122699);
        return null;
    }
}
