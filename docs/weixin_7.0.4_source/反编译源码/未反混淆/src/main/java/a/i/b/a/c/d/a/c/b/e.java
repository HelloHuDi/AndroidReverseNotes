package a.i.b.a.c.d.a.c.b;

import a.a.k;
import a.a.m;
import a.f.b.j;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.h;
import a.i.b.a.c.d.a.a.l;
import a.i.b.a.c.i.c.a;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.ar;
import a.i.b.a.c.l.as;
import a.i.b.a.c.l.az;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.p;
import a.i.b.a.c.l.t;
import a.i.b.a.c.l.w;
import a.i.b.a.c.l.x;
import a.i.b.a.c.l.y;
import a.o;
import a.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class e extends as {
    private static final a Bpo = d.a(l.COMMON, false, null, 3).a(b.FLEXIBLE_LOWER_BOUND);
    private static final a Bpp = d.a(l.COMMON, false, null, 3).a(b.FLEXIBLE_UPPER_BOUND);
    public static final e Bpq = new e();

    static {
        AppMethodBeat.i(120062);
        AppMethodBeat.o(120062);
    }

    private e() {
    }

    public final /* synthetic */ ap O(w wVar) {
        AppMethodBeat.i(120057);
        j.p(wVar, "key");
        ap arVar = new ar(P(wVar));
        AppMethodBeat.o(120057);
        return arVar;
    }

    private final w P(w wVar) {
        h dYs;
        AppMethodBeat.i(120058);
        while (true) {
            dYs = wVar.ejw().dYs();
            if (!(dYs instanceof a.i.b.a.c.b.ar)) {
                break;
            }
            wVar = d.b((a.i.b.a.c.b.ar) dYs);
        }
        if (dYs instanceof a.i.b.a.c.b.e) {
            az gVar;
            o a = a(t.ak(wVar), (a.i.b.a.c.b.e) dYs, Bpo);
            ad adVar = (ad) a.first;
            boolean booleanValue = ((Boolean) a.second).booleanValue();
            a = a(t.al(wVar), (a.i.b.a.c.b.e) dYs, Bpp);
            ad adVar2 = (ad) a.first;
            boolean booleanValue2 = ((Boolean) a.second).booleanValue();
            if (booleanValue || booleanValue2) {
                gVar = new g(adVar, adVar2);
            } else {
                gVar = x.a(adVar, adVar2);
            }
            w wVar2 = gVar;
            AppMethodBeat.o(120058);
            return wVar2;
        }
        Throwable illegalStateException = new IllegalStateException("Unexpected declaration kind: ".concat(String.valueOf(dYs)).toString());
        AppMethodBeat.o(120058);
        throw illegalStateException;
    }

    private final o<ad, Boolean> a(ad adVar, a.i.b.a.c.b.e eVar, a aVar) {
        AppMethodBeat.i(120059);
        o<ad, Boolean> I;
        if (adVar.ejw().getParameters().isEmpty()) {
            o I2 = u.I(adVar, Boolean.FALSE);
            AppMethodBeat.o(120059);
            return I2;
        } else if (g.n(adVar)) {
            ap apVar = (ap) adVar.ejt().get(0);
            ba ekq = apVar.ekq();
            w dZS = apVar.dZS();
            j.o(dZS, "componentTypeProjection.type");
            I = u.I(x.c(adVar.dYn(), adVar.ejw(), k.listOf(new ar(ekq, P(dZS))), adVar.eci()), Boolean.FALSE);
            AppMethodBeat.o(120059);
            return I;
        } else if (y.an(adVar)) {
            I = u.I(p.awn("Raw error type: " + adVar.ejw()), Boolean.FALSE);
            AppMethodBeat.o(120059);
            return I;
        } else {
            a.i.b.a.c.b.a.g dYn = adVar.dYn();
            an ejw = adVar.ejw();
            List parameters = adVar.ejw().getParameters();
            j.o(parameters, "type.constructor.parameters");
            Iterable<a.i.b.a.c.b.ar> iterable = parameters;
            Collection arrayList = new ArrayList(m.d(iterable));
            for (a.i.b.a.c.b.ar arVar : iterable) {
                j.o(arVar, "parameter");
                arrayList.add(b(arVar, aVar));
            }
            List list = (List) arrayList;
            boolean eci = adVar.eci();
            a.i.b.a.c.i.e.h a = eVar.a(Bpq);
            j.o(a, "declaration.getMemberScope(RawSubstitution)");
            I = u.I(x.a(dYn, ejw, list, eci, a), Boolean.TRUE);
            AppMethodBeat.o(120059);
            return I;
        }
    }

    private static /* synthetic */ ap b(a.i.b.a.c.b.ar arVar, a aVar) {
        AppMethodBeat.i(120061);
        ap a = a(arVar, aVar, d.b(arVar));
        AppMethodBeat.o(120061);
        return a;
    }

    public final boolean isEmpty() {
        return false;
    }

    public static ap a(a.i.b.a.c.b.ar arVar, a aVar, w wVar) {
        AppMethodBeat.i(120060);
        j.p(arVar, "parameter");
        j.p(aVar, "attr");
        j.p(wVar, "erasedUpperBound");
        ap arVar2;
        switch (f.eQZ[aVar.BoX.ordinal()]) {
            case 1:
                arVar2 = new ar(ba.INVARIANT, wVar);
                AppMethodBeat.o(120060);
                return arVar2;
            case 2:
            case 3:
                if (arVar.dZh().BKm) {
                    List parameters = wVar.ejw().getParameters();
                    j.o(parameters, "erasedUpperBound.constructor.parameters");
                    if ((!((Collection) parameters).isEmpty() ? 1 : null) != null) {
                        arVar2 = new ar(ba.OUT_VARIANCE, wVar);
                        AppMethodBeat.o(120060);
                        return arVar2;
                    }
                    arVar2 = d.a(arVar, aVar);
                    AppMethodBeat.o(120060);
                    return arVar2;
                }
                arVar2 = new ar(ba.INVARIANT, a.G(arVar).dXL());
                AppMethodBeat.o(120060);
                return arVar2;
            default:
                a.m mVar = new a.m();
                AppMethodBeat.o(120060);
                throw mVar;
        }
    }
}
