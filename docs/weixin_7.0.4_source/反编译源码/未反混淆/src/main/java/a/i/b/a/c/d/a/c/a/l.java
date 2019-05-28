package a.i.b.a.c.d.a.c.a;

import a.a.m;
import a.a.q;
import a.a.t;
import a.a.x;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.al;
import a.i.b.a.c.d.a.b.i;
import a.i.b.a.c.d.a.e.g;
import a.i.b.a.c.d.a.e.p;
import a.i.b.a.c.f.f;
import a.i.b.a.c.i.e.h;
import a.i.b.a.c.l.an;
import a.j.n;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class l extends m {
    private final g BnJ;
    private final f BoM;

    static final class c extends k implements a.f.a.b<h, Set<? extends f>> {
        public static final c BoO = new c();

        static {
            AppMethodBeat.i(120003);
            AppMethodBeat.o(120003);
        }

        c() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(120002);
            h hVar = (h) obj;
            j.p(hVar, "it");
            Set eav = hVar.eav();
            AppMethodBeat.o(120002);
            return eav;
        }
    }

    static final class a extends k implements a.f.a.b<p, Boolean> {
        public static final a BoN = new a();

        static {
            AppMethodBeat.i(120000);
            AppMethodBeat.o(120000);
        }

        a() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119999);
            p pVar = (p) obj;
            j.p(pVar, "it");
            Boolean valueOf = Boolean.valueOf(pVar.isStatic());
            AppMethodBeat.o(119999);
            return valueOf;
        }
    }

    static final class b extends k implements a.f.a.b<h, Collection<? extends ah>> {
        final /* synthetic */ f Beg;

        b(f fVar) {
            this.Beg = fVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(120001);
            h hVar = (h) obj;
            j.p(hVar, "it");
            Collection a = hVar.a(this.Beg, a.i.b.a.c.c.a.c.WHEN_GET_SUPER_MEMBERS);
            AppMethodBeat.o(120001);
            return a;
        }
    }

    static final class d<N> implements a.i.b.a.c.n.b.b<N> {
        public static final d BoP = new d();

        static {
            AppMethodBeat.i(120007);
            AppMethodBeat.o(120007);
        }

        d() {
        }

        public final /* synthetic */ Iterable dA(Object obj) {
            AppMethodBeat.i(120006);
            a.i.b.a.c.b.e eVar = (a.i.b.a.c.b.e) obj;
            j.o(eVar, "it");
            an dXY = eVar.dXY();
            j.o(dXY, "it.typeConstructor");
            Collection eap = dXY.eap();
            j.o(eap, "it.typeConstructor.supertypes");
            Iterable f = n.f(n.e(t.t(eap), AnonymousClass1.BoQ));
            AppMethodBeat.o(120006);
            return f;
        }
    }

    public static final class e extends a.i.b.a.c.n.b.a<a.i.b.a.c.b.e, y> {
        final /* synthetic */ a.i.b.a.c.b.e BoR;
        final /* synthetic */ Set BoS;
        final /* synthetic */ a.f.a.b BoT;

        e(a.i.b.a.c.b.e eVar, Set set, a.f.a.b bVar) {
            this.BoR = eVar;
            this.BoS = set;
            this.BoT = bVar;
        }

        public final /* synthetic */ boolean dB(Object obj) {
            AppMethodBeat.i(120008);
            a.i.b.a.c.b.e eVar = (a.i.b.a.c.b.e) obj;
            j.p(eVar, "current");
            if (eVar != this.BoR) {
                h dXX = eVar.dXX();
                j.o(dXX, "current.staticScope");
                if (dXX instanceof m) {
                    this.BoS.addAll((Collection) this.BoT.am(dXX));
                    AppMethodBeat.o(120008);
                    return false;
                }
            }
            AppMethodBeat.o(120008);
            return true;
        }

        public final /* bridge */ /* synthetic */ Object dYP() {
            return y.AUy;
        }
    }

    public l(a.i.b.a.c.d.a.c.h hVar, g gVar, f fVar) {
        j.p(hVar, "c");
        j.p(gVar, "jClass");
        j.p(fVar, "ownerDescriptor");
        super(hVar);
        AppMethodBeat.i(120018);
        this.BnJ = gVar;
        this.BoM = fVar;
        AppMethodBeat.o(120018);
    }

    public final a.i.b.a.c.b.h c(f fVar, a.i.b.a.c.c.a.a aVar) {
        AppMethodBeat.i(120013);
        j.p(fVar, "name");
        j.p(aVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        AppMethodBeat.o(120013);
        return null;
    }

    private static <R> Set<R> a(a.i.b.a.c.b.e eVar, Set<R> set, a.f.a.b<? super h, ? extends Collection<? extends R>> bVar) {
        AppMethodBeat.i(120016);
        a.i.b.a.c.n.b.a((Collection) a.a.k.listOf(eVar), (a.i.b.a.c.n.b.b) d.BoP, (a.i.b.a.c.n.b.c) new e(eVar, set, bVar));
        AppMethodBeat.o(120016);
        return set;
    }

    private final ah f(ah ahVar) {
        AppMethodBeat.i(120017);
        a.i.b.a.c.b.b.a dYZ = ahVar.dYZ();
        j.o(dYZ, "this.kind");
        if (dYZ.dZa()) {
            AppMethodBeat.o(120017);
            return ahVar;
        }
        Collection dYX = ahVar.dYX();
        j.o(dYX, "this.overriddenDescriptors");
        Iterable<ah> iterable = dYX;
        Collection arrayList = new ArrayList(m.d(iterable));
        for (ah ahVar2 : iterable) {
            j.o(ahVar2, "it");
            arrayList.add(f(ahVar2));
        }
        Iterable iterable2 = (List) arrayList;
        j.p(iterable2, "receiver$0");
        ah ahVar22 = (ah) t.fN(t.m(t.q(iterable2)));
        AppMethodBeat.o(120017);
        return ahVar22;
    }

    public final /* synthetic */ b ebt() {
        AppMethodBeat.i(120009);
        b aVar = new a(this.BnJ, a.BoN);
        AppMethodBeat.o(120009);
        return aVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final Set<f> b(a.i.b.a.c.i.e.d dVar, a.f.a.b<? super f, Boolean> bVar) {
        Set eau;
        AppMethodBeat.i(120010);
        j.p(dVar, "kindFilter");
        Set q = t.q(((b) this.BoC.invoke()).ebn());
        l s = i.s(this.BoM);
        if (s != null) {
            eau = s.eau();
        } else {
            eau = null;
        }
        if (eau == null) {
            eau = x.AUR;
        }
        q.addAll(eau);
        if (this.BnJ.isEnum()) {
            q.addAll(a.a.l.listOf(a.i.b.a.c.i.d.BDR, a.i.b.a.c.i.d.BDQ));
        }
        AppMethodBeat.o(120010);
        return q;
    }

    /* Access modifiers changed, original: protected|final */
    public final Set<f> a(a.i.b.a.c.i.e.d dVar) {
        AppMethodBeat.i(120011);
        j.p(dVar, "kindFilter");
        Set q = t.q(((b) this.BoC.invoke()).ebo());
        a(this.BoM, q, c.BoO);
        AppMethodBeat.o(120011);
        return q;
    }

    /* Access modifiers changed, original: protected|final */
    public final Set<f> c(a.i.b.a.c.i.e.d dVar, a.f.a.b<? super f, Boolean> bVar) {
        AppMethodBeat.i(120012);
        j.p(dVar, "kindFilter");
        Set set = x.AUR;
        AppMethodBeat.o(120012);
        return set;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(Collection<al> collection, f fVar) {
        Set set;
        AppMethodBeat.i(120014);
        j.p(collection, "result");
        j.p(fVar, "name");
        l s = i.s(this.BoM);
        if (s == null) {
            set = x.AUR;
        } else {
            set = t.o(s.b(fVar, (a.i.b.a.c.c.a.a) a.i.b.a.c.c.a.c.WHEN_GET_SUPER_MEMBERS));
        }
        Collection b = a.i.b.a.c.d.a.a.a.b(set, collection, this.BoM, this.Bnn.Bnv.BmV);
        j.o(b, "resolveOverridesForStati…components.errorReporter)");
        collection.addAll(b);
        if (this.BnJ.isEnum()) {
            al w;
            if (j.j(fVar, a.i.b.a.c.i.d.BDR)) {
                w = a.i.b.a.c.i.c.w(this.BoM);
                j.o(w, "createEnumValueOfMethod(ownerDescriptor)");
                collection.add(w);
                AppMethodBeat.o(120014);
                return;
            } else if (j.j(fVar, a.i.b.a.c.i.d.BDQ)) {
                w = a.i.b.a.c.i.c.v(this.BoM);
                j.o(w, "createEnumValuesMethod(ownerDescriptor)");
                collection.add(w);
            }
        }
        AppMethodBeat.o(120014);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(f fVar, Collection<ah> collection) {
        AppMethodBeat.i(120015);
        j.p(fVar, "name");
        j.p(collection, "result");
        Set a = a(this.BoM, new LinkedHashSet(), new b(fVar));
        Collection b;
        if ((!collection.isEmpty() ? 1 : null) != null) {
            b = a.i.b.a.c.d.a.a.a.b(a, collection, this.BoM, this.Bnn.Bnv.BmV);
            j.o(b, "resolveOverridesForStati…rorReporter\n            )");
            collection.addAll(b);
            AppMethodBeat.o(120015);
            return;
        }
        Map linkedHashMap = new LinkedHashMap();
        for (Object next : a) {
            ah f = f((ah) next);
            ArrayList arrayList = linkedHashMap.get(f);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(f, arrayList);
            }
            arrayList.add(next);
        }
        b = new ArrayList();
        for (Entry value : linkedHashMap.entrySet()) {
            q.a(b, (Iterable) a.i.b.a.c.d.a.a.a.b((Collection) value.getValue(), collection, this.BoM, this.Bnn.Bnv.BmV));
        }
        collection.addAll((List) b);
        AppMethodBeat.o(120015);
    }

    public final /* bridge */ /* synthetic */ a.i.b.a.c.b.l ebu() {
        return this.BoM;
    }
}
