package a.i.b.a.c.l.a;

import a.a.k;
import a.a.l;
import a.a.m;
import a.aa;
import a.f.b.j;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.f;
import a.i.b.a.c.i.a.a.b;
import a.i.b.a.c.l.a.o.c;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.ag;
import a.i.b.a.c.l.aj;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.ao;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.av;
import a.i.b.a.c.l.ax;
import a.i.b.a.c.l.az;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.c.a;
import a.i.b.a.c.l.n;
import a.i.b.a.c.l.q;
import a.i.b.a.c.l.t;
import a.i.b.a.c.l.v;
import a.i.b.a.c.l.w;
import a.i.b.a.c.l.x;
import a.i.b.a.c.l.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class h implements c {
    public static final h BKA = new h();

    static {
        AppMethodBeat.i(122750);
        AppMethodBeat.o(122750);
    }

    private h() {
    }

    public final boolean c(w wVar, w wVar2) {
        AppMethodBeat.i(122734);
        j.p(wVar, "subtype");
        j.p(wVar2, "supertype");
        boolean b = b(new o(true, (byte) 0), wVar.ekn(), wVar2.ekn());
        AppMethodBeat.o(122734);
        return b;
    }

    public final boolean d(w wVar, w wVar2) {
        AppMethodBeat.i(122735);
        j.p(wVar, "a");
        j.p(wVar2, "b");
        boolean a = a(new o(false, (byte) 0), wVar.ekn(), wVar2.ekn());
        AppMethodBeat.o(122735);
        return a;
    }

    private boolean a(o oVar, az azVar, az azVar2) {
        AppMethodBeat.i(122736);
        j.p(oVar, "receiver$0");
        j.p(azVar, "a");
        j.p(azVar2, "b");
        if (azVar == azVar2) {
            AppMethodBeat.o(122736);
            return true;
        }
        if (aI(azVar) && aI(azVar2)) {
            if (!o.c(azVar.ejw(), azVar2.ejw())) {
                AppMethodBeat.o(122736);
                return false;
            } else if (azVar.ejt().isEmpty()) {
                if (aH(azVar) || aH(azVar2)) {
                    AppMethodBeat.o(122736);
                    return true;
                } else if (azVar.eci() == azVar2.eci()) {
                    AppMethodBeat.o(122736);
                    return true;
                } else {
                    AppMethodBeat.o(122736);
                    return false;
                }
            }
        }
        if (b(oVar, azVar, azVar2) && b(oVar, azVar2, azVar)) {
            AppMethodBeat.o(122736);
            return true;
        }
        AppMethodBeat.o(122736);
        return false;
    }

    private static boolean aH(w wVar) {
        AppMethodBeat.i(122737);
        if (t.ak(wVar).eci() != t.al(wVar).eci()) {
            AppMethodBeat.o(122737);
            return true;
        }
        AppMethodBeat.o(122737);
        return false;
    }

    private static boolean aI(w wVar) {
        AppMethodBeat.i(122738);
        if (!wVar.ejw().dYu() || n.ag(wVar) || ag.ap(wVar) || !j.j(t.ak(wVar).ejw(), t.al(wVar).ejw())) {
            AppMethodBeat.o(122738);
            return false;
        }
        AppMethodBeat.o(122738);
        return true;
    }

    private boolean b(o oVar, az azVar, az azVar2) {
        AppMethodBeat.i(122739);
        j.p(oVar, "receiver$0");
        j.p(azVar, "subType");
        j.p(azVar2, "superType");
        if (azVar == azVar2) {
            AppMethodBeat.o(122739);
            return true;
        }
        az c = c(azVar);
        az c2 = c(azVar2);
        Boolean a = a(oVar, t.ak(c), t.al(c2));
        boolean booleanValue;
        if (a != null) {
            booleanValue = a.booleanValue();
            o.b(c, c2);
            AppMethodBeat.o(122739);
            return booleanValue;
        }
        o.b(c, c2);
        booleanValue = b(oVar, t.ak(c), t.al(c2));
        AppMethodBeat.o(122739);
        return booleanValue;
    }

    private static ad b(ad adVar) {
        az azVar = null;
        AppMethodBeat.i(122740);
        j.p(adVar, "type");
        an ejw = adVar.ejw();
        w dZS;
        ad eVar;
        Iterable<w> iterable;
        Collection arrayList;
        if (ejw instanceof b) {
            boolean z;
            ap apVar = ((b) ejw).BEG;
            if (apVar.ekq() == ba.IN_VARIANCE) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                apVar = null;
            }
            if (apVar != null) {
                dZS = apVar.dZS();
                if (dZS != null) {
                    azVar = dZS.ekn();
                }
            }
            if (((b) ejw).BEJ == null) {
                b bVar = (b) ejw;
                ap apVar2 = ((b) ejw).BEG;
                Iterable<w> eap = ((b) ejw).eap();
                Collection arrayList2 = new ArrayList(m.d(eap));
                for (w ekn : eap) {
                    arrayList2.add(ekn.ekn());
                }
                bVar.BEJ = new f(apVar2, (List) arrayList2);
            }
            a aVar = a.FOR_SUBTYPING;
            f fVar = ((b) ejw).BEJ;
            if (fVar == null) {
                j.dWJ();
            }
            eVar = new e(aVar, fVar, azVar, adVar.dYn(), adVar.eci());
            AppMethodBeat.o(122740);
            return eVar;
        } else if (ejw instanceof a.i.b.a.c.i.b.n) {
            iterable = ((a.i.b.a.c.i.b.n) ejw).BEU;
            arrayList = new ArrayList(m.d(iterable));
            for (w dZS2 : iterable) {
                arrayList.add(av.a(dZS2, adVar.eci()));
            }
            eVar = x.a(adVar.dYn(), new v((List) arrayList), a.a.v.AUP, false, adVar.dXR());
            AppMethodBeat.o(122740);
            return eVar;
        } else if ((ejw instanceof v) && adVar.eci()) {
            Set set = ((v) ejw).BJH;
            j.o(set, "constructor.supertypes");
            iterable = set;
            arrayList = new ArrayList(m.d(iterable));
            for (w dZS22 : iterable) {
                j.o(dZS22, "it");
                arrayList.add(a.az(dZS22));
            }
            v vVar = new v((List) arrayList);
            g dYn = adVar.dYn();
            an anVar = vVar;
            List list = a.a.v.AUP;
            a.i.b.a.c.i.e.h ekm = vVar.ekm();
            j.o(ekm, "newConstructor.createScopeForKotlinType()");
            eVar = x.a(dYn, anVar, list, false, ekm);
            AppMethodBeat.o(122740);
            return eVar;
        } else {
            AppMethodBeat.o(122740);
            return adVar;
        }
    }

    public static az c(az azVar) {
        az b;
        AppMethodBeat.i(122741);
        j.p(azVar, "type");
        if (azVar instanceof ad) {
            b = b((ad) azVar);
        } else if (azVar instanceof q) {
            ad b2 = b(((q) azVar).BJx);
            ad b3 = b(((q) azVar).BJy);
            b = (b2 == ((q) azVar).BJx && b3 == ((q) azVar).BJy) ? azVar : x.a(b2, b3);
        } else {
            a.m mVar = new a.m();
            AppMethodBeat.o(122741);
            throw mVar;
        }
        b = ax.a(b, azVar);
        AppMethodBeat.o(122741);
        return b;
    }

    private final Boolean a(o oVar, ad adVar, ad adVar2) {
        boolean z = false;
        AppMethodBeat.i(122742);
        Boolean bool;
        if (y.an(adVar) || y.an(adVar2)) {
            if (oVar.BKI) {
                bool = Boolean.TRUE;
                AppMethodBeat.o(122742);
                return bool;
            } else if (!adVar.eci() || adVar2.eci()) {
                bool = Boolean.valueOf(m.BKC.c(adVar.rL(false), adVar2.rL(false)));
                AppMethodBeat.o(122742);
                return bool;
            } else {
                bool = Boolean.FALSE;
                AppMethodBeat.o(122742);
                return bool;
            }
        } else if ((adVar instanceof aj) || (adVar2 instanceof aj)) {
            bool = Boolean.TRUE;
            AppMethodBeat.o(122742);
            return bool;
        } else {
            if ((adVar2 instanceof e) && ((e) adVar2).BKx != null) {
                switch (i.eQZ[o.a(adVar, (e) adVar2).ordinal()]) {
                    case 1:
                        bool = Boolean.valueOf(b(oVar, (az) adVar, ((e) adVar2).BKx));
                        AppMethodBeat.o(122742);
                        return bool;
                    case 2:
                        if (b(oVar, (az) adVar, ((e) adVar2).BKx)) {
                            bool = Boolean.TRUE;
                            AppMethodBeat.o(122742);
                            return bool;
                        }
                        break;
                }
            }
            an ejw = adVar2.ejw();
            if (!(ejw instanceof v)) {
                ejw = null;
            }
            v vVar = (v) ejw;
            if (vVar != null) {
                boolean z2;
                if (adVar2.eci()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!aa.AUz || z2) {
                    Set set = vVar.BJH;
                    j.o(set, "it.supertypes");
                    Iterable<w> iterable = set;
                    if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                        for (w ekn : iterable) {
                            if (!BKA.b(oVar, (az) adVar, ekn.ekn())) {
                                bool = Boolean.valueOf(z);
                                AppMethodBeat.o(122742);
                                return bool;
                            }
                        }
                    }
                    z = true;
                    bool = Boolean.valueOf(z);
                    AppMethodBeat.o(122742);
                    return bool;
                }
                Throwable assertionError = new AssertionError("Intersection type should not be marked nullable!: ".concat(String.valueOf(adVar2)));
                AppMethodBeat.o(122742);
                throw assertionError;
            }
            AppMethodBeat.o(122742);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:76:0x01df  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b(o oVar, ad adVar, ad adVar2) {
        AppMethodBeat.i(122744);
        Object obj = (j.d(adVar) || j.e(adVar) || oVar.e(adVar)) ? 1 : null;
        Throwable assertionError;
        if (aa.AUz && obj == null) {
            assertionError = new AssertionError("Not singleClassifierType and not intersection subType: ".concat(String.valueOf(adVar)));
            AppMethodBeat.o(122744);
            throw assertionError;
        }
        obj = (j.d(adVar2) || oVar.e(adVar2)) ? 1 : null;
        if (aa.AUz && obj == null) {
            assertionError = new AssertionError("Not singleClassifierType superType: ".concat(String.valueOf(adVar2)));
            AppMethodBeat.o(122744);
            throw assertionError;
        }
        l lVar = l.BKB;
        if (l.c(oVar, adVar, adVar2)) {
            an ejw = adVar2.ejw();
            if (j.j(adVar.ejw(), ejw) && ejw.getParameters().isEmpty()) {
                AppMethodBeat.o(122744);
                return true;
            } else if (a.A(adVar2)) {
                AppMethodBeat.o(122744);
                return true;
            } else {
                List b = b(oVar, adVar, ejw);
                boolean a;
                switch (b.size()) {
                    case 0:
                        a = a(oVar, adVar);
                        AppMethodBeat.o(122744);
                        return a;
                    case 1:
                        a = a(oVar, ((ad) a.a.t.fJ(b)).ejt(), adVar2);
                        AppMethodBeat.o(122744);
                        return a;
                    default:
                        Iterable<ad> iterable;
                        switch (i.pCY[o.b.INTERSECT_ARGUMENTS_AND_CHECK_AGAIN.ordinal()]) {
                            case 1:
                                AppMethodBeat.o(122744);
                                return false;
                            case 2:
                                a = a(oVar, ((ad) a.a.t.fJ(b)).ejt(), adVar2);
                                AppMethodBeat.o(122744);
                                return a;
                            case 3:
                            case 4:
                                iterable = b;
                                if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                                    for (ad ejt : iterable) {
                                        if (a(oVar, ejt.ejt(), adVar2)) {
                                            obj = 1;
                                            if (obj != null) {
                                                AppMethodBeat.o(122744);
                                                return true;
                                            }
                                        }
                                    }
                                }
                                obj = null;
                                if (obj != null) {
                                }
                                break;
                        }
                        o.b bVar = o.b.INTERSECT_ARGUMENTS_AND_CHECK_AGAIN;
                        List parameters = ejw.getParameters();
                        j.o(parameters, "superConstructor.parameters");
                        Iterable iterable2 = parameters;
                        Collection arrayList = new ArrayList(m.d(iterable2));
                        Iterator it = iterable2.iterator();
                        int i = 0;
                        while (it.hasNext()) {
                            it.next();
                            int i2 = i + 1;
                            if (i < 0) {
                                l.dWs();
                            }
                            iterable = b;
                            Collection arrayList2 = new ArrayList(m.d(iterable));
                            for (ad ejt2 : iterable) {
                                ap apVar = (ap) a.a.t.x(ejt2.ejt(), i);
                                if (apVar != null) {
                                    if ((apVar.ekq() == ba.INVARIANT ? 1 : null) == null) {
                                        apVar = null;
                                    }
                                    if (apVar != null) {
                                        w dZS = apVar.dZS();
                                        if (dZS != null) {
                                            az ekn = dZS.ekn();
                                            if (ekn != null) {
                                                arrayList2.add(ekn);
                                            }
                                        }
                                    }
                                }
                                assertionError = new IllegalStateException(("Incorrect type: " + ejt2 + ", subType: " + adVar + ", superType: " + adVar2).toString());
                                AppMethodBeat.o(122744);
                                throw assertionError;
                            }
                            arrayList.add(a.aM(b.gb((List) arrayList2)));
                            i = i2;
                        }
                        a = a(oVar, (List) arrayList, adVar2);
                        AppMethodBeat.o(122744);
                        return a;
                }
            }
        }
        AppMethodBeat.o(122744);
        return false;
    }

    private static List<ad> a(o oVar, ad adVar, an anVar) {
        AppMethodBeat.i(122745);
        List<ad> c = c(oVar, adVar, anVar);
        if (c.size() >= 2) {
            Collection arrayList = new ArrayList();
            for (Object next : c) {
                Object obj;
                Iterable<ap> ejt = ((ad) next).ejt();
                if (!((ejt instanceof Collection) && ((Collection) ejt).isEmpty())) {
                    for (ap dZS : ejt) {
                        w dZS2 = dZS.dZS();
                        j.o(dZS2, "it.type");
                        if (t.ai(dZS2)) {
                            obj = null;
                            continue;
                        } else {
                            obj = 1;
                            continue;
                        }
                        if (obj == null) {
                            obj = null;
                            break;
                        }
                    }
                }
                int i = 1;
                if (obj != null) {
                    arrayList.add(next);
                }
            }
            List list = (List) arrayList;
            if ((!((Collection) list).isEmpty() ? 1 : null) != null) {
                AppMethodBeat.o(122745);
                return list;
            }
        }
        AppMethodBeat.o(122745);
        return c;
    }

    private static List<ad> b(o oVar, ad adVar, an anVar) {
        AppMethodBeat.i(122746);
        j.p(oVar, "receiver$0");
        j.p(adVar, "baseType");
        j.p(anVar, "constructor");
        List<ad> list;
        if (j.c(adVar)) {
            List a = a(oVar, adVar, anVar);
            AppMethodBeat.o(122746);
            return a;
        } else if (anVar.dYs() instanceof e) {
            a.i.b.a.c.n.h<ad> hVar = new a.i.b.a.c.n.h();
            oVar.initialize();
            ArrayDeque arrayDeque = oVar.BKG;
            if (arrayDeque == null) {
                j.dWJ();
            }
            Set set = oVar.BKH;
            if (set == null) {
                j.dWJ();
            }
            arrayDeque.push(adVar);
            while (true) {
                int i;
                if (arrayDeque.isEmpty()) {
                    i = 0;
                } else {
                    i = 1;
                }
                ad adVar2;
                if (i == 0) {
                    oVar.clear();
                    Collection arrayList = new ArrayList();
                    for (ad adVar22 : hVar) {
                        j.o(adVar22, "it");
                        a.a.q.a(arrayList, (Iterable) a(oVar, adVar22, anVar));
                    }
                    list = (List) arrayList;
                    AppMethodBeat.o(122746);
                    return list;
                } else if (set.size() > 1000) {
                    Throwable illegalStateException = new IllegalStateException(("Too many supertypes for type: " + adVar + ". Supertypes = " + a.a.t.a((Iterable) set, null, null, null, 0, null, null, 63)).toString());
                    AppMethodBeat.o(122746);
                    throw illegalStateException;
                } else {
                    adVar22 = (ad) arrayDeque.pop();
                    j.o(adVar22, "current");
                    if (set.add(adVar22)) {
                        c cVar;
                        if (j.c(adVar22)) {
                            hVar.add(adVar22);
                            cVar = c.c.BKU;
                        } else {
                            cVar = c.a.BKT;
                        }
                        if ((j.j(cVar, c.c.BKU) ^ 1) == 0) {
                            cVar = null;
                        }
                        if (cVar != null) {
                            for (w wVar : adVar22.ejw().eap()) {
                                j.o(wVar, "supertype");
                                arrayDeque.add(cVar.aJ(wVar));
                            }
                        }
                    }
                }
            }
        } else {
            list = c(oVar, adVar, anVar);
            AppMethodBeat.o(122746);
            return list;
        }
    }

    private static List<ad> c(o oVar, ad adVar, an anVar) {
        AppMethodBeat.i(122747);
        a.i.b.a.c.b.h dYs = anVar.dYs();
        if (!(dYs instanceof e)) {
            dYs = null;
        }
        e eVar = (e) dYs;
        List<ad> hVar;
        if (eVar == null || !B(eVar)) {
            hVar = new a.i.b.a.c.n.h();
            oVar.initialize();
            ArrayDeque arrayDeque = oVar.BKG;
            if (arrayDeque == null) {
                j.dWJ();
            }
            Set set = oVar.BKH;
            if (set == null) {
                j.dWJ();
            }
            arrayDeque.push(adVar);
            while (true) {
                int i;
                if (arrayDeque.isEmpty()) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i == 0) {
                    oVar.clear();
                    AppMethodBeat.o(122747);
                    return hVar;
                } else if (set.size() > 1000) {
                    Throwable illegalStateException = new IllegalStateException(("Too many supertypes for type: " + adVar + ". Supertypes = " + a.a.t.a((Iterable) set, null, null, null, 0, null, null, 63)).toString());
                    AppMethodBeat.o(122747);
                    throw illegalStateException;
                } else {
                    ad adVar2 = (ad) arrayDeque.pop();
                    j.o(adVar2, "current");
                    if (set.add(adVar2)) {
                        c cVar;
                        ad a = g.a(adVar2, a.FOR_SUBTYPING);
                        if (a == null) {
                            a = adVar2;
                        }
                        if (o.c(a.ejw(), anVar)) {
                            hVar.add(a);
                            cVar = c.c.BKU;
                        } else if (a.ejt().isEmpty()) {
                            cVar = c.a.BKT;
                        } else {
                            ao.a aVar = ao.BJQ;
                            cVar = new c.b(ao.a.au(a).ekr());
                        }
                        if ((j.j(cVar, c.c.BKU) ^ 1) == 0) {
                            cVar = null;
                        }
                        if (cVar != null) {
                            for (w wVar : adVar2.ejw().eap()) {
                                j.o(wVar, "supertype");
                                arrayDeque.add(cVar.aJ(wVar));
                            }
                        }
                    }
                }
            }
        } else if (o.c(adVar.ejw(), anVar)) {
            ad a2 = g.a(adVar, a.FOR_SUBTYPING);
            if (a2 != null) {
                adVar = a2;
            }
            List listOf = k.listOf(adVar);
            AppMethodBeat.o(122747);
            return listOf;
        } else {
            hVar = a.a.v.AUP;
            AppMethodBeat.o(122747);
            return hVar;
        }
    }

    private static boolean B(e eVar) {
        AppMethodBeat.i(122748);
        if (!a.i.b.a.c.b.x.p(eVar) || eVar.dYc() == f.ENUM_ENTRY || eVar.dYc() == f.ANNOTATION_CLASS) {
            AppMethodBeat.o(122748);
            return false;
        }
        AppMethodBeat.o(122748);
        return true;
    }

    private static boolean a(o oVar, List<? extends ap> list, ad adVar) {
        AppMethodBeat.i(122749);
        if (list == adVar.ejt()) {
            AppMethodBeat.o(122749);
            return true;
        }
        List parameters = adVar.ejw().getParameters();
        j.o(parameters, "superType.constructor.parameters");
        int size = parameters.size();
        for (int i = 0; i < size; i++) {
            ap apVar = (ap) adVar.ejt().get(i);
            if (!apVar.ekp()) {
                az ekn = apVar.dZS().ekn();
                ap apVar2 = (ap) list.get(i);
                boolean z = apVar2.ekq() == ba.INVARIANT;
                Throwable illegalStateException;
                if (!aa.AUz || z) {
                    az ekn2 = apVar2.dZS().ekn();
                    Object obj = parameters.get(i);
                    j.o(obj, "parameters[index]");
                    ba dZh = ((ar) obj).dZh();
                    j.o(dZh, "parameters[index].variance");
                    ba ekq = apVar.ekq();
                    j.o(ekq, "superProjection.projectionKind");
                    j.p(dZh, "declared");
                    j.p(ekq, "useSite");
                    if (dZh != ba.INVARIANT) {
                        if (ekq == ba.INVARIANT) {
                            ekq = dZh;
                        } else if (dZh == ekq) {
                            ekq = dZh;
                        } else {
                            ekq = null;
                        }
                    }
                    if (ekq == null) {
                        boolean z2 = oVar.BKI;
                        AppMethodBeat.o(122749);
                        return z2;
                    } else if (oVar.BKE > 100) {
                        illegalStateException = new IllegalStateException("Arguments depth is too high. Some related argument: ".concat(String.valueOf(ekn2)).toString());
                        AppMethodBeat.o(122749);
                        throw illegalStateException;
                    } else {
                        boolean a;
                        oVar.BKE++;
                        switch (i.pEv[ekq.ordinal()]) {
                            case 1:
                                a = BKA.a(oVar, ekn2, ekn);
                                break;
                            case 2:
                                a = BKA.b(oVar, ekn2, ekn);
                                break;
                            case 3:
                                a = BKA.b(oVar, ekn, ekn2);
                                break;
                            default:
                                a.m mVar = new a.m();
                                AppMethodBeat.o(122749);
                                throw mVar;
                        }
                        oVar.BKE--;
                        if (!a) {
                            AppMethodBeat.o(122749);
                            return false;
                        }
                    }
                } else {
                    illegalStateException = new AssertionError("Incorrect sub argument: ".concat(String.valueOf(apVar2)));
                    AppMethodBeat.o(122749);
                    throw illegalStateException;
                }
            }
        }
        AppMethodBeat.o(122749);
        return true;
    }

    private static boolean a(o oVar, ad adVar) {
        AppMethodBeat.i(122743);
        if (a.i.b.a.c.a.g.z(adVar)) {
            AppMethodBeat.o(122743);
            return true;
        }
        oVar.initialize();
        ArrayDeque arrayDeque = oVar.BKG;
        if (arrayDeque == null) {
            j.dWJ();
        }
        Set set = oVar.BKH;
        if (set == null) {
            j.dWJ();
        }
        arrayDeque.push(adVar);
        while (true) {
            boolean z;
            if (arrayDeque.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                oVar.clear();
                AppMethodBeat.o(122743);
                return false;
            } else if (set.size() > 1000) {
                Throwable illegalStateException = new IllegalStateException(("Too many supertypes for type: " + adVar + ". Supertypes = " + a.a.t.a((Iterable) set, null, null, null, 0, null, null, 63)).toString());
                AppMethodBeat.o(122743);
                throw illegalStateException;
            } else {
                ad adVar2 = (ad) arrayDeque.pop();
                j.o(adVar2, "current");
                if (set.add(adVar2)) {
                    c cVar = j.c(adVar2) ? c.c.BKU : c.a.BKT;
                    c cVar2 = (j.j(cVar, c.c.BKU) ^ 1) != 0 ? cVar : null;
                    if (cVar2 != null) {
                        for (w wVar : adVar2.ejw().eap()) {
                            j.o(wVar, "supertype");
                            ad aJ = cVar2.aJ(wVar);
                            if (a.i.b.a.c.a.g.z(aJ)) {
                                oVar.clear();
                                AppMethodBeat.o(122743);
                                return true;
                            }
                            arrayDeque.add(aJ);
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            }
        }
    }
}
