package a.i.b.a.c.l.a;

import a.a.m;
import a.aa;
import a.f.b.j;
import a.i.b.a.c.i.e.h;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.az;
import a.i.b.a.c.l.g;
import a.i.b.a.c.l.t;
import a.i.b.a.c.l.v;
import a.i.b.a.c.l.w;
import a.i.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class s {
    public static final s BLd = new s();

    enum a {
        ;

        static final class a extends a {
            a(String str) {
                super(str, 1);
            }

            public final a f(az azVar) {
                AppMethodBeat.i(122802);
                j.p(azVar, "nextType");
                a g = a.g(azVar);
                AppMethodBeat.o(122802);
                return g;
            }
        }

        static final class d extends a {
            d(String str) {
                super(str, 2);
            }

            public final a f(az azVar) {
                AppMethodBeat.i(122805);
                j.p(azVar, "nextType");
                a g = a.g(azVar);
                if (g == a.BLf) {
                    a aVar = this;
                    AppMethodBeat.o(122805);
                    return aVar;
                }
                AppMethodBeat.o(122805);
                return g;
            }
        }

        static final class b extends a {
            b(String str) {
                super(str, 3);
            }

            public final /* synthetic */ a f(az azVar) {
                AppMethodBeat.i(122803);
                j.p(azVar, "nextType");
                a aVar = this;
                AppMethodBeat.o(122803);
                return aVar;
            }
        }

        static final class c extends a {
            c(String str) {
                super(str, 0);
            }

            public final a f(az azVar) {
                AppMethodBeat.i(122804);
                j.p(azVar, "nextType");
                a g = a.g(azVar);
                AppMethodBeat.o(122804);
                return g;
            }
        }

        public abstract a f(az azVar);

        protected static a g(az azVar) {
            j.p(azVar, "receiver$0");
            if (azVar.eci()) {
                return BLf;
            }
            l lVar = l.BKB;
            if (l.d(azVar)) {
                return BLh;
            }
            return BLg;
        }
    }

    static {
        AppMethodBeat.i(122808);
        AppMethodBeat.o(122808);
    }

    private s() {
    }

    public static ad gc(List<? extends ad> list) {
        AppMethodBeat.i(122806);
        j.p(list, "types");
        boolean z = list.size() > 1;
        if (!aa.AUz || z) {
            Collection eap;
            ArrayList<ad> arrayList = new ArrayList();
            for (ad adVar : list) {
                if (adVar.ejw() instanceof v) {
                    eap = adVar.ejw().eap();
                    j.o(eap, "type.constructor.supertypes");
                    Iterable<w> iterable = eap;
                    Collection arrayList2 = new ArrayList(m.d(iterable));
                    for (w wVar : iterable) {
                        j.o(wVar, "it");
                        Object al = t.al(wVar);
                        if (adVar.eci()) {
                            al = al.rL(true);
                        }
                        arrayList2.add(al);
                    }
                    arrayList.addAll((List) arrayList2);
                } else {
                    arrayList.add(adVar);
                }
            }
            Iterable<az> iterable2 = arrayList;
            a aVar = a.BLe;
            a aVar2 = aVar;
            for (az f : iterable2) {
                aVar2 = aVar2.f(f);
            }
            eap = new LinkedHashSet();
            for (ad adVar2 : arrayList) {
                Object obj;
                if (aVar2 == a.BLh) {
                    j.p(adVar2, "receiver$0");
                    a.i.b.a.c.l.g.a aVar3 = g.BJi;
                    g a = a.i.b.a.c.l.g.a.a(adVar2);
                    obj = a != null ? a : adVar2.rL(false);
                } else {
                    ad obj2 = adVar2;
                }
                eap.add(obj2);
            }
            ad p = p((LinkedHashSet) eap);
            AppMethodBeat.o(122806);
            return p;
        }
        Throwable assertionError = new AssertionError("Size should be at least 2, but it is " + list.size());
        AppMethodBeat.o(122806);
        throw assertionError;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x008a A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static ad p(Set<? extends ad> set) {
        AppMethodBeat.i(122807);
        ad adVar;
        if (set.size() == 1) {
            adVar = (ad) a.a.t.h((Iterable) set);
            AppMethodBeat.o(122807);
            return adVar;
        }
        int i;
        ArrayList arrayList = new ArrayList(set);
        Iterator it = arrayList.iterator();
        j.o(it, "filteredSuperAndEqualTypes.iterator()");
        while (it.hasNext()) {
            adVar = (ad) it.next();
            Iterable<ad> iterable = arrayList;
            if (!((Collection) iterable).isEmpty()) {
                for (ad adVar2 : iterable) {
                    int i2;
                    if (adVar2 != adVar) {
                        int i3;
                        j.o(adVar2, "lower");
                        w wVar = adVar2;
                        j.o(adVar, "upper");
                        w wVar2 = adVar;
                        h hVar = h.BKA;
                        if (!hVar.c(wVar, wVar2) || hVar.c(wVar2, wVar)) {
                            i3 = 0;
                        } else {
                            i3 = 1;
                        }
                        if (i3 != 0 || h.BKA.d(adVar2, adVar)) {
                            i2 = 1;
                            continue;
                            if (i2 != 0) {
                                i = 1;
                                break;
                            }
                        }
                    }
                    i2 = 0;
                    continue;
                    if (i2 != 0) {
                    }
                }
            }
            i = 0;
            if (i != 0) {
                it.remove();
            }
        }
        i = !((Collection) arrayList).isEmpty() ? 1 : 0;
        if (aa.AUz && i == 0) {
            Throwable assertionError = new AssertionError("This collections cannot be empty! input types: " + a.a.t.a((Iterable) set, null, null, null, 0, null, null, 63));
            AppMethodBeat.o(122807);
            throw assertionError;
        } else if (arrayList.size() < 2) {
            Object fN = a.a.t.fN(arrayList);
            j.o(fN, "filteredSuperAndEqualTypes.single()");
            adVar = (ad) fN;
            AppMethodBeat.o(122807);
            return adVar;
        } else {
            v vVar = new v(set);
            a.i.b.a.c.b.a.g.a aVar = a.i.b.a.c.b.a.g.BfJ;
            a.i.b.a.c.b.a.g eai = a.i.b.a.c.b.a.g.a.eai();
            an anVar = vVar;
            List list = a.a.v.AUP;
            h ekm = vVar.ekm();
            j.o(ekm, "constructor.createScopeForKotlinType()");
            adVar = x.a(eai, anVar, list, false, ekm);
            AppMethodBeat.o(122807);
            return adVar;
        }
    }
}
