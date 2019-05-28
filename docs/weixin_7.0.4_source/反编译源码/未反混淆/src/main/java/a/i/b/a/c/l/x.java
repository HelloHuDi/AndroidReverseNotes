package a.i.b.a.c.l;

import a.f.b.j;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.aq;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.h;
import a.i.b.a.c.l.ao.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class x {
    public static final x BJI = new x();

    static {
        AppMethodBeat.i(122609);
        AppMethodBeat.o(122609);
    }

    private x() {
    }

    public static final ad c(g gVar, an anVar, List<? extends ap> list, boolean z) {
        AppMethodBeat.i(122605);
        j.p(gVar, "annotations");
        j.p(anVar, "constructor");
        j.p(list, "arguments");
        h dYs;
        ad a;
        if (!gVar.isEmpty() || !list.isEmpty() || z || anVar.dYs() == null) {
            a.i.b.a.c.i.e.h dXR;
            dYs = anVar.dYs();
            if (dYs instanceof ar) {
                dXR = dYs.dZf().dXR();
            } else if (dYs instanceof e) {
                if (list.isEmpty()) {
                    dXR = ((e) dYs).dZf().dXR();
                } else {
                    e eVar = (e) dYs;
                    a aVar = ao.BJQ;
                    dXR = eVar.a(a.a(anVar, list));
                    j.o(dXR, "descriptor.getMemberScop…(constructor, arguments))");
                }
            } else if (dYs instanceof aq) {
                dXR = p.cw("Scope for abbreviation: " + ((aq) dYs).dZg(), true);
                j.o(dXR, "ErrorUtils.createErrorSc…{descriptor.name}\", true)");
            } else {
                Throwable illegalStateException = new IllegalStateException("Unsupported classifier: " + dYs + " for constructor: " + anVar);
                AppMethodBeat.o(122605);
                throw illegalStateException;
            }
            a = a(gVar, anVar, list, z, dXR);
            AppMethodBeat.o(122605);
            return a;
        }
        dYs = anVar.dYs();
        if (dYs == null) {
            j.dWJ();
        }
        j.o(dYs, "constructor.declarationDescriptor!!");
        a = dYs.dZf();
        j.o(a, "constructor.declarationDescriptor!!.defaultType");
        AppMethodBeat.o(122605);
        return a;
    }

    public static final ad a(g gVar, an anVar, List<? extends ap> list, boolean z, a.i.b.a.c.i.e.h hVar) {
        AppMethodBeat.i(122606);
        j.p(gVar, "annotations");
        j.p(anVar, "constructor");
        j.p(list, "arguments");
        j.p(hVar, "memberScope");
        ae aeVar = new ae(anVar, list, z, hVar);
        ad adVar;
        if (gVar.isEmpty()) {
            adVar = aeVar;
            AppMethodBeat.o(122606);
            return adVar;
        }
        adVar = new d(aeVar, gVar);
        AppMethodBeat.o(122606);
        return adVar;
    }

    public static final ad a(g gVar, e eVar, List<? extends ap> list) {
        AppMethodBeat.i(122607);
        j.p(gVar, "annotations");
        j.p(eVar, "descriptor");
        j.p(list, "arguments");
        an dXY = eVar.dXY();
        j.o(dXY, "descriptor.typeConstructor");
        ad c = c(gVar, dXY, list, false);
        AppMethodBeat.o(122607);
        return c;
    }

    public static final az a(ad adVar, ad adVar2) {
        AppMethodBeat.i(122608);
        j.p(adVar, "lowerBound");
        j.p(adVar2, "upperBound");
        if (j.j(adVar, adVar2)) {
            az azVar = adVar;
            AppMethodBeat.o(122608);
            return azVar;
        }
        az rVar = new r(adVar, adVar2);
        AppMethodBeat.o(122608);
        return rVar;
    }
}
