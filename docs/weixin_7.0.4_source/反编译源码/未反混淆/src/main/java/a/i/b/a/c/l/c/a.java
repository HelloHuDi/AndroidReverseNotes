package a.i.b.a.c.l.c;

import a.a.m;
import a.f.b.j;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.l.a.c;
import a.i.b.a.c.l.a.e;
import a.i.b.a.c.l.a.k;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.ah;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.at;
import a.i.b.a.c.l.av;
import a.i.b.a.c.l.ax;
import a.i.b.a.c.l.az;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.q;
import a.i.b.a.c.l.w;
import a.i.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class a {
    public static final g aL(w wVar) {
        AppMethodBeat.i(122816);
        j.p(wVar, "receiver$0");
        g dZD = wVar.ejw().dZD();
        j.o(dZD, "constructor.builtIns");
        AppMethodBeat.o(122816);
        return dZD;
    }

    public static final w az(w wVar) {
        AppMethodBeat.i(122817);
        j.p(wVar, "receiver$0");
        w az = av.az(wVar);
        j.o(az, "TypeUtils.makeNullable(this)");
        AppMethodBeat.o(122817);
        return az;
    }

    public static final w aA(w wVar) {
        AppMethodBeat.i(122818);
        j.p(wVar, "receiver$0");
        w aA = av.aA(wVar);
        j.o(aA, "TypeUtils.makeNotNullable(this)");
        AppMethodBeat.o(122818);
        return aA;
    }

    public static final boolean A(w wVar) {
        AppMethodBeat.i(122819);
        j.p(wVar, "receiver$0");
        boolean A = g.A(wVar);
        AppMethodBeat.o(122819);
        return A;
    }

    public static final boolean aE(w wVar) {
        AppMethodBeat.i(122820);
        j.p(wVar, "receiver$0");
        boolean aE = av.aE(wVar);
        AppMethodBeat.o(122820);
        return aE;
    }

    public static final boolean c(w wVar, w wVar2) {
        AppMethodBeat.i(122821);
        j.p(wVar, "receiver$0");
        j.p(wVar2, "superType");
        boolean c = c.BKs.c(wVar, wVar2);
        AppMethodBeat.o(122821);
        return c;
    }

    public static final w a(w wVar, a.i.b.a.c.b.a.g gVar) {
        AppMethodBeat.i(122822);
        j.p(wVar, "receiver$0");
        j.p(gVar, "newAnnotations");
        if (wVar.dYn().isEmpty() && gVar.isEmpty()) {
            AppMethodBeat.o(122822);
            return wVar;
        }
        w b = wVar.ekn().b(gVar);
        AppMethodBeat.o(122822);
        return b;
    }

    public static final ap a(w wVar, ba baVar, ar arVar) {
        AppMethodBeat.i(122823);
        j.p(wVar, "type");
        j.p(baVar, "projectionKind");
        if ((arVar != null ? arVar.dZh() : null) == baVar) {
            baVar = ba.INVARIANT;
        }
        ap arVar2 = new a.i.b.a.c.l.ar(baVar, wVar);
        AppMethodBeat.o(122823);
        return arVar2;
    }

    public static final ap aM(w wVar) {
        AppMethodBeat.i(122824);
        j.p(wVar, "receiver$0");
        ap arVar = new a.i.b.a.c.l.ar(wVar);
        AppMethodBeat.o(122824);
        return arVar;
    }

    public static final boolean h(az azVar) {
        AppMethodBeat.i(122826);
        j.p(azVar, "receiver$0");
        if ((azVar.ejw() instanceof k) || (azVar.ejw().dYs() instanceof ar) || (azVar instanceof e)) {
            AppMethodBeat.o(122826);
            return true;
        }
        AppMethodBeat.o(122826);
        return false;
    }

    public static final w aN(w wVar) {
        az a;
        AppMethodBeat.i(122825);
        j.p(wVar, "receiver$0");
        az ekn = wVar.ekn();
        ad adVar;
        if (ekn instanceof q) {
            List parameters;
            Iterable<ar> iterable;
            Collection arrayList;
            ad adVar2 = ((q) ekn).BJx;
            if (!(adVar2.ejw().getParameters().isEmpty() || adVar2.ejw().dYs() == null)) {
                parameters = adVar2.ejw().getParameters();
                j.o(parameters, "constructor.parameters");
                iterable = parameters;
                arrayList = new ArrayList(m.d(iterable));
                for (ar ahVar : iterable) {
                    arrayList.add(new ah(ahVar));
                }
                adVar2 = at.a(adVar2, (List) arrayList);
            }
            ad adVar3 = ((q) ekn).BJy;
            if (adVar3.ejw().getParameters().isEmpty() || adVar3.ejw().dYs() == null) {
                adVar = adVar3;
            } else {
                parameters = adVar3.ejw().getParameters();
                j.o(parameters, "constructor.parameters");
                iterable = parameters;
                arrayList = new ArrayList(m.d(iterable));
                for (ar ahVar2 : iterable) {
                    arrayList.add(new ah(ahVar2));
                }
                adVar = at.a(adVar3, (List) arrayList);
            }
            a = x.a(adVar2, adVar);
        } else if (ekn instanceof ad) {
            adVar = (ad) ekn;
            if (!(adVar.ejw().getParameters().isEmpty() || adVar.ejw().dYs() == null)) {
                List parameters2 = adVar.ejw().getParameters();
                j.o(parameters2, "constructor.parameters");
                Iterable<ar> iterable2 = parameters2;
                Collection arrayList2 = new ArrayList(m.d(iterable2));
                for (ar ahVar3 : iterable2) {
                    arrayList2.add(new ah(ahVar3));
                }
                adVar = at.a(adVar, (List) arrayList2);
            }
            a = adVar;
        } else {
            a.m mVar = new a.m();
            AppMethodBeat.o(122825);
            throw mVar;
        }
        w a2 = ax.a(a, ekn);
        AppMethodBeat.o(122825);
        return a2;
    }
}
