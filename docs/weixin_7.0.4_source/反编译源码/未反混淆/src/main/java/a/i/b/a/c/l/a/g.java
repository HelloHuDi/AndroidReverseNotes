package a.i.b.a.c.l.a;

import a.a.t;
import a.aa;
import a.f.a.m;
import a.f.b.j;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.ao;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.au;
import a.i.b.a.c.l.az;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.c.a;
import a.i.b.a.c.l.w;
import a.i.b.a.c.l.x;
import a.i.b.a.c.n.d;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class g {
    public static /* synthetic */ ad a(ad adVar, a aVar) {
        AppMethodBeat.i(122732);
        m ekv = d.ekv();
        j.p(adVar, "type");
        j.p(aVar, "status");
        j.p(ekv, "acceptNewCapturedType");
        if (adVar.ejt().size() != adVar.ejw().getParameters().size()) {
            AppMethodBeat.o(122732);
            return null;
        }
        Object obj;
        List ejt = adVar.ejt();
        Iterable<ap> iterable = ejt;
        if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
            for (ap ekq : iterable) {
                if (ekq.ekq() == ba.INVARIANT) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
                if (obj == null) {
                    obj = null;
                    break;
                }
            }
        }
        obj = 1;
        if (obj != null) {
            AppMethodBeat.o(122732);
            return null;
        }
        iterable = ejt;
        Collection arrayList = new ArrayList(a.a.m.d(iterable));
        for (ap ekq2 : iterable) {
            if (ekq2.ekq() != ba.INVARIANT) {
                az azVar;
                if (ekq2.ekp() || ekq2.ekq() != ba.IN_VARIANCE) {
                    azVar = null;
                } else {
                    azVar = ekq2.dZS().ekn();
                }
                obj = a.aM(new e(aVar, azVar, ekq2));
            }
            arrayList.add(obj);
        }
        List list = (List) arrayList;
        ao.a aVar2 = ao.BJQ;
        au ekr = ao.a.a(adVar.ejw(), list).ekr();
        int size = ejt.size();
        for (int i = 0; i < size; i++) {
            ap apVar = (ap) ejt.get(i);
            ap apVar2 = (ap) list.get(i);
            if (apVar.ekq() != ba.INVARIANT) {
                Object a;
                obj = adVar.ejw().getParameters().get(i);
                j.o(obj, "type.constructor.parameters[index]");
                List dWP = ((ar) obj).dWP();
                j.o(dWP, "type.constructor.parameters[index].upperBounds");
                Iterable<w> iterable2 = dWP;
                Collection arrayList2 = new ArrayList(a.a.m.d(iterable2));
                for (w wVar : iterable2) {
                    h hVar = h.BKA;
                    arrayList2.add(h.c(ekr.b(wVar, ba.INVARIANT).ekn()));
                }
                dWP = (List) arrayList2;
                if (apVar.ekp() || apVar.ekq() != ba.OUT_VARIANCE) {
                    List a2 = dWP;
                } else {
                    arrayList2 = dWP;
                    h hVar2 = h.BKA;
                    a2 = t.a(arrayList2, (Object) h.c(apVar.dZS().ekn()));
                }
                w dZS = apVar2.dZS();
                if (dZS == null) {
                    v vVar = new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
                    AppMethodBeat.o(122732);
                    throw vVar;
                }
                e eVar = (e) dZS;
                f fVar = eVar.BKw;
                j.p(a2, "supertypes");
                Object obj2 = fVar.BKz == null ? 1 : null;
                if (aa.AUz && obj2 == null) {
                    Throwable assertionError = new AssertionError("Already initialized! oldValue = " + fVar.BKz + ", newValue = " + a2);
                    AppMethodBeat.o(122732);
                    throw assertionError;
                }
                fVar.BKz = a2;
                ekv.m(Integer.valueOf(i), eVar);
            }
        }
        ad c = x.c(adVar.dYn(), adVar.ejw(), list, adVar.eci());
        AppMethodBeat.o(122732);
        return c;
    }
}
