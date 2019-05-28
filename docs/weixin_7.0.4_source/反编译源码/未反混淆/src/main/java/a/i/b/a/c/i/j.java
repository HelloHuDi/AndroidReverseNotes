package a.i.b.a.c.i;

import a.a.t;
import a.f.a.m;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.ak;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.ay;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.b;
import a.i.b.a.c.b.c.z;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.p;
import a.i.b.a.c.l.a.c;
import a.i.b.a.c.l.a.d;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.w;
import a.i.b.a.c.l.y;
import a.i.b.a.c.n.i;
import a.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.ServiceLoader;
import java.util.Set;

public class j {
    static final /* synthetic */ boolean $assertionsDisabled = (!j.class.desiredAssertionStatus());
    private static final List<e> BEl = t.m(ServiceLoader.load(e.class, e.class.getClassLoader()));
    public static final j BEm = new j(new a.i.b.a.c.l.a.c.a() {
        public final boolean a(an anVar, an anVar2) {
            AppMethodBeat.i(121994);
            boolean equals = anVar.equals(anVar2);
            AppMethodBeat.o(121994);
            return equals;
        }
    });
    private final a.i.b.a.c.l.a.c.a BEn;

    public static class a {
        private static final a BEx = new a(a.OVERRIDABLE, "SUCCESS");
        public final a BEy;
        private final String BEz;

        public enum a {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT;

            static {
                AppMethodBeat.o(122003);
            }
        }

        static {
            AppMethodBeat.i(122006);
            AppMethodBeat.o(122006);
        }

        public static a ejs() {
            return BEx;
        }

        public static a awg(String str) {
            AppMethodBeat.i(122004);
            a aVar = new a(a.INCOMPATIBLE, str);
            AppMethodBeat.o(122004);
            return aVar;
        }

        public static a awh(String str) {
            AppMethodBeat.i(122005);
            a aVar = new a(a.CONFLICT, str);
            AppMethodBeat.o(122005);
            return aVar;
        }

        private a(a aVar, String str) {
            this.BEy = aVar;
            this.BEz = str;
        }
    }

    static {
        AppMethodBeat.i(122036);
        AppMethodBeat.o(122036);
    }

    public static j a(a.i.b.a.c.l.a.c.a aVar) {
        AppMethodBeat.i(122007);
        j jVar = new j(aVar);
        AppMethodBeat.o(122007);
        return jVar;
    }

    private j(a.i.b.a.c.l.a.c.a aVar) {
        this.BEn = aVar;
    }

    private static <D extends a.i.b.a.c.b.a> Set<D> o(Set<D> set) {
        AppMethodBeat.i(122008);
        AnonymousClass2 anonymousClass2 = new m<D, D, o<a.i.b.a.c.b.a, a.i.b.a.c.b.a>>() {
            public final /* synthetic */ Object m(Object obj, Object obj2) {
                AppMethodBeat.i(121995);
                o oVar = new o((a.i.b.a.c.b.a) obj, (a.i.b.a.c.b.a) obj2);
                AppMethodBeat.o(121995);
                return oVar;
            }
        };
        if (set.size() <= 1) {
            AppMethodBeat.o(122008);
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object next : set) {
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                o oVar = (o) anonymousClass2.m(next, it.next());
                a.i.b.a.c.b.a aVar = (a.i.b.a.c.b.a) oVar.first;
                a.i.b.a.c.b.a aVar2 = (a.i.b.a.c.b.a) oVar.second;
                if (!c(aVar, aVar2)) {
                    if (c(aVar2, aVar)) {
                        break;
                    }
                } else {
                    it.remove();
                }
            }
            linkedHashSet.add(next);
        }
        if ($assertionsDisabled || !linkedHashSet.isEmpty()) {
            AppMethodBeat.o(122008);
            return linkedHashSet;
        }
        AssertionError assertionError = new AssertionError("All candidates filtered out from ".concat(String.valueOf(set)));
        AppMethodBeat.o(122008);
        throw assertionError;
    }

    private static <D extends a.i.b.a.c.b.a> boolean c(D d, D d2) {
        AppMethodBeat.i(122009);
        if (d.equals(d2) || !b.BDK.d(d.dYU(), d2.dYU())) {
            a.i.b.a.c.b.a dYU = d2.dYU();
            for (a.i.b.a.c.b.a d3 : d.d(d)) {
                if (b.BDK.d(dYU, d3)) {
                    AppMethodBeat.o(122009);
                    return true;
                }
            }
            AppMethodBeat.o(122009);
            return false;
        }
        AppMethodBeat.o(122009);
        return true;
    }

    private static Set<b> w(b bVar) {
        AppMethodBeat.i(122010);
        Set linkedHashSet = new LinkedHashSet();
        a(bVar, linkedHashSet);
        AppMethodBeat.o(122010);
        return linkedHashSet;
    }

    private static void a(b bVar, Set<b> set) {
        AppMethodBeat.i(122011);
        if (bVar.dYZ().dZa()) {
            set.add(bVar);
            AppMethodBeat.o(122011);
        } else if (bVar.dYX().isEmpty()) {
            IllegalStateException illegalStateException = new IllegalStateException("No overridden descriptors found for (fake override) ".concat(String.valueOf(bVar)));
            AppMethodBeat.o(122011);
            throw illegalStateException;
        } else {
            for (b a : bVar.dYX()) {
                a(a, (Set) set);
            }
            AppMethodBeat.o(122011);
        }
    }

    private a b(a.i.b.a.c.b.a aVar, a.i.b.a.c.b.a aVar2, e eVar) {
        AppMethodBeat.i(122012);
        a a = a(aVar, aVar2, eVar, false);
        AppMethodBeat.o(122012);
        return a;
    }

    public final a a(a.i.b.a.c.b.a aVar, a.i.b.a.c.b.a aVar2, e eVar, boolean z) {
        a awh;
        AppMethodBeat.i(122013);
        a a = a(aVar, aVar2, z);
        Object obj = a.BEy == a.OVERRIDABLE ? 1 : null;
        Object obj2 = obj;
        for (e eVar2 : BEl) {
            if (eVar2.eaX() != a.i.b.a.c.i.e.a.CONFLICTS_ONLY && (obj2 == null || eVar2.eaX() != a.i.b.a.c.i.e.a.SUCCESS_ONLY)) {
                switch (eVar2.a(aVar, aVar2, eVar)) {
                    case OVERRIDABLE:
                        obj2 = 1;
                        break;
                    case CONFLICT:
                        awh = a.awh("External condition failed");
                        AppMethodBeat.o(122013);
                        return awh;
                    case INCOMPATIBLE:
                        awh = a.awg("External condition");
                        AppMethodBeat.o(122013);
                        return awh;
                    default:
                        break;
                }
            }
        }
        if (obj2 == null) {
            AppMethodBeat.o(122013);
            return a;
        }
        for (e eVar22 : BEl) {
            if (eVar22.eaX() == a.i.b.a.c.i.e.a.CONFLICTS_ONLY) {
                switch (eVar22.a(aVar, aVar2, eVar)) {
                    case OVERRIDABLE:
                        IllegalStateException illegalStateException = new IllegalStateException("Contract violation in " + eVar22.getClass().getName() + " condition. It's not supposed to end with success");
                        AppMethodBeat.o(122013);
                        throw illegalStateException;
                    case CONFLICT:
                        awh = a.awh("External condition failed");
                        AppMethodBeat.o(122013);
                        return awh;
                    case INCOMPATIBLE:
                        awh = a.awg("External condition");
                        AppMethodBeat.o(122013);
                        return awh;
                    default:
                        break;
                }
            }
        }
        awh = a.ejs();
        AppMethodBeat.o(122013);
        return awh;
    }

    public final a a(a.i.b.a.c.b.a aVar, a.i.b.a.c.b.a aVar2, boolean z) {
        int i = 0;
        AppMethodBeat.i(122014);
        a d = d(aVar, aVar2);
        if (d != null) {
            AppMethodBeat.o(122014);
            return d;
        }
        List e = e(aVar);
        List e2 = e(aVar2);
        List dYS = aVar.dYS();
        List dYS2 = aVar2.dYS();
        if (dYS.size() != dYS2.size()) {
            while (i < e.size()) {
                if (c.BKs.d((w) e.get(i), (w) e2.get(i))) {
                    i++;
                } else {
                    d = a.awg("Type parameter number mismatch");
                    AppMethodBeat.o(122014);
                    return d;
                }
            }
            d = a.awh("Type parameter number mismatch");
            AppMethodBeat.o(122014);
            return d;
        }
        c u = u(dYS, dYS2);
        int i2 = 0;
        while (i2 < dYS.size()) {
            if (a((ar) dYS.get(i2), (ar) dYS2.get(i2), u)) {
                i2++;
            } else {
                d = a.awg("Type parameter bounds mismatch");
                AppMethodBeat.o(122014);
                return d;
            }
        }
        i2 = 0;
        while (i2 < e.size()) {
            if (a((w) e.get(i2), (w) e2.get(i2), u)) {
                i2++;
            } else {
                d = a.awg("Value parameter type mismatch");
                AppMethodBeat.o(122014);
                return d;
            }
        }
        if ((aVar instanceof a.i.b.a.c.b.t) && (aVar2 instanceof a.i.b.a.c.b.t) && ((a.i.b.a.c.b.t) aVar).dZv() != ((a.i.b.a.c.b.t) aVar2).dZv()) {
            d = a.awh("Incompatible suspendability");
            AppMethodBeat.o(122014);
            return d;
        }
        if (z) {
            w dYT = aVar.dYT();
            w dYT2 = aVar2.dYT();
            if (!(dYT == null || dYT2 == null)) {
                if (y.an(dYT2) && y.an(dYT)) {
                    i = 1;
                }
                if (i == 0 && !u.c(dYT2, dYT)) {
                    d = a.awh("Return type mismatch");
                    AppMethodBeat.o(122014);
                    return d;
                }
            }
        }
        d = a.ejs();
        AppMethodBeat.o(122014);
        return d;
    }

    private static a d(a.i.b.a.c.b.a aVar, a.i.b.a.c.b.a aVar2) {
        AppMethodBeat.i(122015);
        a awg;
        if (((aVar instanceof a.i.b.a.c.b.t) && !(aVar2 instanceof a.i.b.a.c.b.t)) || ((aVar instanceof ah) && !(aVar2 instanceof ah))) {
            awg = a.awg("Member kind mismatch");
            AppMethodBeat.o(122015);
            return awg;
        } else if (!(aVar instanceof a.i.b.a.c.b.t) && !(aVar instanceof ah)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(122015);
            throw illegalArgumentException;
        } else if (aVar.dZg().equals(aVar2.dZg())) {
            awg = e(aVar, aVar2);
            if (awg != null) {
                AppMethodBeat.o(122015);
                return awg;
            }
            AppMethodBeat.o(122015);
            return null;
        } else {
            awg = a.awg("Name mismatch");
            AppMethodBeat.o(122015);
            return awg;
        }
    }

    private c u(List<ar> list, List<ar> list2) {
        AppMethodBeat.i(122016);
        c b;
        if (!$assertionsDisabled && list.size() != list2.size()) {
            AssertionError assertionError = new AssertionError("Should be the same number of type parameters: " + list + " vs " + list2);
            AppMethodBeat.o(122016);
            throw assertionError;
        } else if (list.isEmpty()) {
            b = d.b(this.BEn);
            AppMethodBeat.o(122016);
            return b;
        } else {
            final HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    hashMap.put(((ar) list.get(i2)).dXY(), ((ar) list2.get(i2)).dXY());
                    i = i2 + 1;
                } else {
                    b = d.b(new a.i.b.a.c.l.a.c.a() {
                        public final boolean a(an anVar, an anVar2) {
                            AppMethodBeat.i(121996);
                            if (j.this.BEn.a(anVar, anVar2)) {
                                AppMethodBeat.o(121996);
                                return true;
                            }
                            an anVar3 = (an) hashMap.get(anVar);
                            an anVar4 = (an) hashMap.get(anVar2);
                            if ((anVar3 == null || !anVar3.equals(anVar2)) && (anVar4 == null || !anVar4.equals(anVar))) {
                                AppMethodBeat.o(121996);
                                return false;
                            }
                            AppMethodBeat.o(121996);
                            return true;
                        }
                    });
                    AppMethodBeat.o(122016);
                    return b;
                }
            }
        }
    }

    private static a e(a.i.b.a.c.b.a aVar, a.i.b.a.c.b.a aVar2) {
        Object obj = 1;
        AppMethodBeat.i(122017);
        Object obj2 = aVar.dYQ() == null ? 1 : null;
        if (aVar2.dYQ() != null) {
            obj = null;
        }
        a awg;
        if (obj2 != obj) {
            awg = a.awg("Receiver presence mismatch");
            AppMethodBeat.o(122017);
            return awg;
        } else if (aVar.dYV().size() != aVar2.dYV().size()) {
            awg = a.awg("Value parameter number mismatch");
            AppMethodBeat.o(122017);
            return awg;
        } else {
            AppMethodBeat.o(122017);
            return null;
        }
    }

    private static boolean a(w wVar, w wVar2, c cVar) {
        boolean z;
        AppMethodBeat.i(122018);
        if (y.an(wVar) && y.an(wVar2)) {
            z = true;
        } else {
            z = false;
        }
        if (z || cVar.d(wVar, wVar2)) {
            AppMethodBeat.o(122018);
            return true;
        }
        AppMethodBeat.o(122018);
        return false;
    }

    private static boolean a(ar arVar, ar arVar2, c cVar) {
        AppMethodBeat.i(122019);
        List<w> dWP = arVar.dWP();
        ArrayList arrayList = new ArrayList(arVar2.dWP());
        if (dWP.size() != arrayList.size()) {
            AppMethodBeat.o(122019);
            return false;
        }
        for (w wVar : dWP) {
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (a(wVar, (w) listIterator.next(), cVar)) {
                    listIterator.remove();
                }
            }
            AppMethodBeat.o(122019);
            return false;
        }
        AppMethodBeat.o(122019);
        return true;
    }

    private static List<w> e(a.i.b.a.c.b.a aVar) {
        AppMethodBeat.i(122020);
        ak dYQ = aVar.dYQ();
        ArrayList arrayList = new ArrayList();
        if (dYQ != null) {
            arrayList.add(dYQ.dZS());
        }
        for (au dZS : aVar.dYV()) {
            arrayList.add(dZS.dZS());
        }
        AppMethodBeat.o(122020);
        return arrayList;
    }

    public static void a(Collection<? extends b> collection, Collection<? extends b> collection2, e eVar, i iVar) {
        AppMethodBeat.i(122021);
        Collection linkedHashSet = new LinkedHashSet(collection);
        for (b a : collection2) {
            linkedHashSet.removeAll(a(a, (Collection) collection, eVar, iVar));
        }
        a(eVar, linkedHashSet, iVar);
        AppMethodBeat.o(122021);
    }

    private static Collection<b> a(b bVar, Collection<? extends b> collection, e eVar, i iVar) {
        AppMethodBeat.i(122022);
        ArrayList arrayList = new ArrayList(collection.size());
        i ekD = i.ekD();
        for (p pVar : collection) {
            Object obj;
            a aVar = BEm.b(pVar, bVar, eVar).BEy;
            if (ay.b(pVar.dYf()) || !ay.a(pVar, (l) bVar)) {
                obj = null;
            } else {
                obj = 1;
            }
            switch (aVar) {
                case OVERRIDABLE:
                    if (obj != null) {
                        ekD.add(pVar);
                    }
                    arrayList.add(pVar);
                    break;
                case CONFLICT:
                    if (obj != null) {
                        iVar.b(pVar, bVar);
                    }
                    arrayList.add(pVar);
                    break;
                default:
                    break;
            }
        }
        iVar.a(bVar, ekD);
        AppMethodBeat.o(122022);
        return arrayList;
    }

    public static boolean f(a.i.b.a.c.b.a aVar, a.i.b.a.c.b.a aVar2) {
        AppMethodBeat.i(122024);
        w dYT = aVar.dYT();
        w dYT2 = aVar2.dYT();
        AssertionError assertionError;
        boolean a;
        if (!$assertionsDisabled && dYT == null) {
            assertionError = new AssertionError("Return type of " + aVar + " is null");
            AppMethodBeat.o(122024);
            throw assertionError;
        } else if (!$assertionsDisabled && dYT2 == null) {
            assertionError = new AssertionError("Return type of " + aVar2 + " is null");
            AppMethodBeat.o(122024);
            throw assertionError;
        } else if (!a((p) aVar, (p) aVar2)) {
            AppMethodBeat.o(122024);
            return false;
        } else if (aVar instanceof a.i.b.a.c.b.t) {
            if ($assertionsDisabled || (aVar2 instanceof a.i.b.a.c.b.t)) {
                a = a(aVar, dYT, aVar2, dYT2);
                AppMethodBeat.o(122024);
                return a;
            }
            assertionError = new AssertionError("b is " + aVar2.getClass());
            AppMethodBeat.o(122024);
            throw assertionError;
        } else if (!(aVar instanceof ah)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unexpected callable: " + aVar.getClass());
            AppMethodBeat.o(122024);
            throw illegalArgumentException;
        } else if ($assertionsDisabled || (aVar2 instanceof ah)) {
            boolean z;
            ah ahVar = (ah) aVar;
            ah ahVar2 = (ah) aVar2;
            p dZJ = ahVar.dZJ();
            p dZJ2 = ahVar2.dZJ();
            if (dZJ == null || dZJ2 == null) {
                z = true;
            } else {
                z = a(dZJ, dZJ2);
            }
            if (!z) {
                AppMethodBeat.o(122024);
                return false;
            } else if (ahVar.dZZ() && ahVar2.dZZ()) {
                a = BEm.u(aVar.dYS(), aVar2.dYS()).d(dYT, dYT2);
                AppMethodBeat.o(122024);
                return a;
            } else if ((ahVar.dZZ() || !ahVar2.dZZ()) && a(aVar, dYT, aVar2, dYT2)) {
                AppMethodBeat.o(122024);
                return true;
            } else {
                AppMethodBeat.o(122024);
                return false;
            }
        } else {
            assertionError = new AssertionError("b is " + aVar2.getClass());
            AppMethodBeat.o(122024);
            throw assertionError;
        }
    }

    private static boolean a(p pVar, p pVar2) {
        AppMethodBeat.i(122025);
        Integer b = ay.b(pVar.dYf(), pVar2.dYf());
        if (b == null || b.intValue() >= 0) {
            AppMethodBeat.o(122025);
            return true;
        }
        AppMethodBeat.o(122025);
        return false;
    }

    private static boolean a(a.i.b.a.c.b.a aVar, Collection<a.i.b.a.c.b.a> collection) {
        AppMethodBeat.i(122026);
        for (a.i.b.a.c.b.a f : collection) {
            if (!f(aVar, f)) {
                AppMethodBeat.o(122026);
                return false;
            }
        }
        AppMethodBeat.o(122026);
        return true;
    }

    private static boolean a(a.i.b.a.c.b.a aVar, w wVar, a.i.b.a.c.b.a aVar2, w wVar2) {
        AppMethodBeat.i(122027);
        boolean c = BEm.u(aVar.dYS(), aVar2.dYS()).c(wVar, wVar2);
        AppMethodBeat.o(122027);
        return c;
    }

    public static <H> H a(Collection<H> collection, a.f.a.b<H, a.i.b.a.c.b.a> bVar) {
        AppMethodBeat.i(122028);
        if (!$assertionsDisabled && collection.isEmpty()) {
            AssertionError assertionError = new AssertionError("Should have at least one overridable descriptor");
            AppMethodBeat.o(122028);
            throw assertionError;
        } else if (collection.size() == 1) {
            Object e = t.e(collection);
            AppMethodBeat.o(122028);
            return e;
        } else {
            H h;
            ArrayList arrayList = new ArrayList(2);
            Collection c = t.c((Iterable) collection, (a.f.a.b) bVar);
            H e2 = t.e(collection);
            a.i.b.a.c.b.a aVar = (a.i.b.a.c.b.a) bVar.am(e2);
            Iterator it = collection.iterator();
            while (true) {
                h = e2;
                if (!it.hasNext()) {
                    break;
                }
                H next = it.next();
                a.i.b.a.c.b.a aVar2 = (a.i.b.a.c.b.a) bVar.am(next);
                if (a(aVar2, c)) {
                    arrayList.add(next);
                }
                if (!f(aVar2, aVar) || f(aVar, aVar2)) {
                    e2 = h;
                } else {
                    e2 = next;
                }
            }
            if (arrayList.isEmpty()) {
                AppMethodBeat.o(122028);
                return h;
            } else if (arrayList.size() == 1) {
                h = t.e(arrayList);
                AppMethodBeat.o(122028);
                return h;
            } else {
                for (H h2 : arrayList) {
                    if (!a.i.b.a.c.l.t.ai(((a.i.b.a.c.b.a) bVar.am(h2)).dYT())) {
                        break;
                    }
                }
                h2 = null;
                if (h2 != null) {
                    AppMethodBeat.o(122028);
                    return h2;
                }
                h2 = t.e(arrayList);
                AppMethodBeat.o(122028);
                return h2;
            }
        }
    }

    private static void a(Collection<b> collection, e eVar, i iVar) {
        Collection collection2;
        AppMethodBeat.i(122029);
        Collection a = a(eVar, (Collection) collection2);
        boolean isEmpty = a.isEmpty();
        if (!isEmpty) {
            collection2 = a;
        }
        b a2 = ((b) a(collection2, new a.f.a.b<b, a.i.b.a.c.b.a>() {
            public final /* bridge */ /* synthetic */ Object am(Object obj) {
                return (b) obj;
            }
        })).a(eVar, a(collection2, eVar), isEmpty ? ay.Bfd : ay.Bfc, a.i.b.a.c.b.b.a.FAKE_OVERRIDE);
        iVar.a(a2, collection2);
        if ($assertionsDisabled || !a2.dYX().isEmpty()) {
            iVar.g(a2);
            AppMethodBeat.o(122029);
            return;
        }
        AssertionError assertionError = new AssertionError("Overridden descriptors should be set for " + a.i.b.a.c.b.b.a.FAKE_OVERRIDE);
        AppMethodBeat.o(122029);
        throw assertionError;
    }

    private static a.i.b.a.c.b.w a(Collection<b> collection, e eVar) {
        a.i.b.a.c.b.w wVar;
        boolean z = true;
        AppMethodBeat.i(122030);
        boolean z2 = false;
        boolean z3 = false;
        for (b bVar : collection) {
            boolean z4;
            switch (bVar.dYd()) {
                case FINAL:
                    wVar = a.i.b.a.c.b.w.FINAL;
                    AppMethodBeat.o(122030);
                    return wVar;
                case SEALED:
                    IllegalStateException illegalStateException = new IllegalStateException("Member cannot have SEALED modality: ".concat(String.valueOf(bVar)));
                    AppMethodBeat.o(122030);
                    throw illegalStateException;
                case OPEN:
                    z3 = true;
                    continue;
                case ABSTRACT:
                    z4 = true;
                    break;
                default:
                    z4 = z2;
                    break;
            }
            z2 = z4;
        }
        if (!eVar.dYk() || eVar.dYd() == a.i.b.a.c.b.w.ABSTRACT || eVar.dYd() == a.i.b.a.c.b.w.SEALED) {
            z = false;
        }
        if (z3 && !z2) {
            wVar = a.i.b.a.c.b.w.OPEN;
            AppMethodBeat.o(122030);
            return wVar;
        } else if (z3 || !z2) {
            HashSet hashSet = new HashSet();
            for (b bVar2 : collection) {
                hashSet.addAll(w(bVar2));
            }
            wVar = a(o(hashSet), z, eVar.dYd());
            AppMethodBeat.o(122030);
            return wVar;
        } else if (z) {
            wVar = eVar.dYd();
            AppMethodBeat.o(122030);
            return wVar;
        } else {
            wVar = a.i.b.a.c.b.w.ABSTRACT;
            AppMethodBeat.o(122030);
            return wVar;
        }
    }

    private static a.i.b.a.c.b.w a(Collection<b> collection, boolean z, a.i.b.a.c.b.w wVar) {
        AppMethodBeat.i(122031);
        Enum enumR = a.i.b.a.c.b.w.ABSTRACT;
        Iterator it = collection.iterator();
        while (true) {
            Enum enumR2 = enumR;
            if (it.hasNext()) {
                b bVar = (b) it.next();
                enumR = (z && bVar.dYd() == a.i.b.a.c.b.w.ABSTRACT) ? wVar : bVar.dYd();
                if (enumR.compareTo(enumR2) >= 0) {
                    enumR = enumR2;
                }
            } else {
                AppMethodBeat.o(122031);
                return enumR2;
            }
        }
    }

    private static Collection<b> a(final e eVar, Collection<b> collection) {
        AppMethodBeat.i(122032);
        List b = t.b((Iterable) collection, (a.f.a.b) new a.f.a.b<b, Boolean>() {
            public final /* synthetic */ Object am(Object obj) {
                boolean z;
                AppMethodBeat.i(121998);
                p pVar = (b) obj;
                if (ay.b(pVar.dYf()) || !ay.a(pVar, eVar)) {
                    z = false;
                } else {
                    z = true;
                }
                Boolean valueOf = Boolean.valueOf(z);
                AppMethodBeat.o(121998);
                return valueOf;
            }
        });
        AppMethodBeat.o(122032);
        return b;
    }

    public static <H> Collection<H> a(H h, Collection<H> collection, a.f.a.b<H, a.i.b.a.c.b.a> bVar, a.f.a.b<H, a.y> bVar2) {
        AppMethodBeat.i(122033);
        ArrayList arrayList = new ArrayList();
        arrayList.add(h);
        a.i.b.a.c.b.a aVar = (a.i.b.a.c.b.a) bVar.am(h);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            H next = it.next();
            a.i.b.a.c.b.a aVar2 = (a.i.b.a.c.b.a) bVar.am(next);
            if (h == next) {
                it.remove();
            } else {
                a g = g(aVar, aVar2);
                if (g == a.OVERRIDABLE) {
                    arrayList.add(next);
                    it.remove();
                } else if (g == a.CONFLICT) {
                    bVar2.am(next);
                    it.remove();
                }
            }
        }
        AppMethodBeat.o(122033);
        return arrayList;
    }

    public static a g(a.i.b.a.c.b.a aVar, a.i.b.a.c.b.a aVar2) {
        AppMethodBeat.i(122034);
        a aVar3 = BEm.b(aVar2, aVar, null).BEy;
        a aVar4 = BEm.b(aVar, aVar2, null).BEy;
        if (aVar3 == a.OVERRIDABLE && aVar4 == a.OVERRIDABLE) {
            aVar3 = a.OVERRIDABLE;
            AppMethodBeat.o(122034);
            return aVar3;
        } else if (aVar3 == a.CONFLICT || aVar4 == a.CONFLICT) {
            aVar3 = a.CONFLICT;
            AppMethodBeat.o(122034);
            return aVar3;
        } else {
            aVar3 = a.INCOMPATIBLE;
            AppMethodBeat.o(122034);
            return aVar3;
        }
    }

    public static void a(b bVar, a.f.a.b<b, a.y> bVar2) {
        AppMethodBeat.i(122035);
        for (b bVar3 : bVar.dYX()) {
            if (bVar3.dYf() == ay.Bfc) {
                a(bVar3, (a.f.a.b) bVar2);
            }
        }
        if (bVar.dYf() != ay.Bfc) {
            AppMethodBeat.o(122035);
            return;
        }
        az azVar;
        az azVar2;
        Collection<b> dYX = bVar.dYX();
        if (dYX.isEmpty()) {
            azVar = ay.Bfh;
        } else {
            Integer b;
            azVar2 = null;
            for (b bVar32 : dYX) {
                azVar = bVar32.dYf();
                if (!$assertionsDisabled && azVar == ay.Bfc) {
                    AssertionError assertionError = new AssertionError("Visibility should have been computed for ".concat(String.valueOf(bVar32)));
                    AppMethodBeat.o(122035);
                    throw assertionError;
                } else if (azVar2 == null) {
                    azVar2 = azVar;
                } else {
                    b = ay.b(azVar, azVar2);
                    if (b == null) {
                        azVar2 = null;
                    } else {
                        az azVar3;
                        if (b.intValue() > 0) {
                            azVar3 = azVar;
                        } else {
                            azVar3 = azVar2;
                        }
                        azVar2 = azVar3;
                    }
                }
            }
            if (azVar2 == null) {
                azVar = null;
            } else {
                for (b bVar322 : dYX) {
                    b = ay.b(azVar2, bVar322.dYf());
                    if (b != null) {
                        if (b.intValue() < 0) {
                        }
                    }
                    azVar = null;
                }
                azVar = azVar2;
            }
        }
        if (azVar == null) {
            azVar = null;
        } else if (bVar.dYZ() == a.i.b.a.c.b.b.a.FAKE_OVERRIDE) {
            for (b bVar3222 : dYX) {
                if (bVar3222.dYd() != a.i.b.a.c.b.w.ABSTRACT && !bVar3222.dYf().equals(azVar)) {
                    azVar = null;
                    break;
                }
            }
        } else {
            azVar = azVar.eag();
        }
        if (azVar == null) {
            if (bVar2 != null) {
                bVar2.am(bVar);
            }
            azVar2 = ay.Bfa;
        } else {
            azVar2 = azVar;
        }
        if (bVar instanceof z) {
            ((z) bVar).BhQ = azVar2;
            for (b bVar32222 : ((ah) bVar).dZK()) {
                a.f.a.b bVar4;
                if (azVar == null) {
                    bVar4 = null;
                } else {
                    a.f.a.b<b, a.y> bVar42 = bVar2;
                }
                a(bVar32222, bVar42);
            }
            AppMethodBeat.o(122035);
        } else if (bVar instanceof a.i.b.a.c.b.c.p) {
            ((a.i.b.a.c.b.c.p) bVar).BhQ = azVar2;
            AppMethodBeat.o(122035);
        } else if ($assertionsDisabled || (bVar instanceof a.i.b.a.c.b.c.y)) {
            a.i.b.a.c.b.c.y yVar = (a.i.b.a.c.b.c.y) bVar;
            yVar.BhQ = azVar2;
            if (azVar2 != yVar.BhL.dYf()) {
                yVar.isDefault = false;
            }
            AppMethodBeat.o(122035);
        } else {
            AssertionError assertionError2 = new AssertionError();
            AppMethodBeat.o(122035);
            throw assertionError2;
        }
    }

    private static void a(e eVar, Collection<b> collection, final i iVar) {
        Object obj;
        AppMethodBeat.i(122023);
        if (collection.size() >= 2) {
            final l dXW = ((b) collection.iterator().next()).dXW();
            AnonymousClass4 anonymousClass4 = new a.f.a.b<b, Boolean>() {
                public final /* synthetic */ Object am(Object obj) {
                    boolean z;
                    AppMethodBeat.i(121997);
                    if (((b) obj).dXW() == dXW) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Boolean valueOf = Boolean.valueOf(z);
                    AppMethodBeat.o(121997);
                    return valueOf;
                }
            };
            a.f.b.j.p(collection, "receiver$0");
            a.f.b.j.p(anonymousClass4, "predicate");
            if (!collection.isEmpty()) {
                for (Object obj2 : collection) {
                    if (!((Boolean) anonymousClass4.am(obj2)).booleanValue()) {
                        obj2 = null;
                        break;
                    }
                }
            }
        }
        obj2 = 1;
        if (obj2 != null) {
            for (b singleton : collection) {
                a(Collections.singleton(singleton), eVar, iVar);
            }
            AppMethodBeat.o(122023);
            return;
        }
        Collection linkedList = new LinkedList(collection);
        while (!linkedList.isEmpty()) {
            final Object n = l.n(linkedList);
            a(a(n, linkedList, new a.f.a.b<b, a.i.b.a.c.b.a>() {
                public final /* bridge */ /* synthetic */ Object am(Object obj) {
                    return (b) obj;
                }
            }, new a.f.a.b<b, a.y>() {
                public final /* synthetic */ Object am(Object obj) {
                    AppMethodBeat.i(121999);
                    iVar.c(n, (b) obj);
                    a.y yVar = a.y.AUy;
                    AppMethodBeat.o(121999);
                    return yVar;
                }
            }), eVar, iVar);
        }
        AppMethodBeat.o(122023);
    }
}
