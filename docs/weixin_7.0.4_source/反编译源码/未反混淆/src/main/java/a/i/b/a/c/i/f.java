package a.i.b.a.c.i;

import a.a.t;
import a.f.b.j;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.d;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.h;
import a.i.b.a.c.b.l;
import a.i.b.a.c.c.a.c;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class f {
    private static boolean D(l lVar) {
        AppMethodBeat.i(121982);
        j.p(lVar, "receiver$0");
        if ((lVar instanceof e) && ((e) lVar).dYj()) {
            AppMethodBeat.o(121982);
            return true;
        }
        AppMethodBeat.o(121982);
        return false;
    }

    private static au aa(w wVar) {
        AppMethodBeat.i(121983);
        j.p(wVar, "receiver$0");
        h dYs = wVar.ejw().dYs();
        if (!(dYs instanceof e)) {
            dYs = null;
        }
        e eVar = (e) dYs;
        if (eVar != null) {
            j.p(eVar, "receiver$0");
            if (eVar.dYj()) {
                d dYe = eVar.dYe();
                if (dYe != null) {
                    List dYV = dYe.dYV();
                    if (dYV != null) {
                        au auVar = (au) t.fO(dYV);
                        AppMethodBeat.o(121983);
                        return auVar;
                    }
                }
                AppMethodBeat.o(121983);
                return null;
            }
            AppMethodBeat.o(121983);
            return null;
        }
        AppMethodBeat.o(121983);
        return null;
    }

    public static final boolean ab(w wVar) {
        AppMethodBeat.i(121984);
        j.p(wVar, "receiver$0");
        h dYs = wVar.ejw().dYs();
        if (dYs != null) {
            boolean D = D(dYs);
            AppMethodBeat.o(121984);
            return D;
        }
        AppMethodBeat.o(121984);
        return false;
    }

    public static final w ac(w wVar) {
        AppMethodBeat.i(121985);
        j.p(wVar, "receiver$0");
        au aa = aa(wVar);
        if (aa == null) {
            AppMethodBeat.o(121985);
            return null;
        }
        a.i.b.a.c.i.e.h dXR = wVar.dXR();
        a.i.b.a.c.f.f dZg = aa.dZg();
        j.o(dZg, "parameter.name");
        ah ahVar = (ah) t.i((Iterable) dXR.a(dZg, c.FOR_ALREADY_TRACKED));
        if (ahVar != null) {
            w dZS = ahVar.dZS();
            AppMethodBeat.o(121985);
            return dZS;
        }
        AppMethodBeat.o(121985);
        return null;
    }
}
