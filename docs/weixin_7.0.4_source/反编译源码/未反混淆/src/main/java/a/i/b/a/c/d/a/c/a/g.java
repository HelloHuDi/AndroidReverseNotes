package a.i.b.a.c.d.a.c.a;

import a.a.ag;
import a.a.am;
import a.a.m;
import a.a.t;
import a.f.b.k;
import a.f.b.v;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.ai;
import a.i.b.a.c.b.aj;
import a.i.b.a.c.b.ak;
import a.i.b.a.c.b.al;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.c.aa;
import a.i.b.a.c.b.c.ab;
import a.i.b.a.c.b.c.ad;
import a.i.b.a.c.b.l;
import a.i.b.a.c.d.a.e.n;
import a.i.b.a.c.d.a.e.p;
import a.i.b.a.c.d.a.e.q;
import a.i.b.a.c.d.a.e.x;
import a.i.b.a.c.d.a.o;
import a.i.b.a.c.d.a.s;
import a.i.b.a.c.d.b.r;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.av;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class g extends k {
    private final a.i.b.a.c.d.a.e.g BnJ;
    final a.i.b.a.c.k.f<List<a.i.b.a.c.b.d>> Bog;
    private final a.i.b.a.c.k.f<Set<a.i.b.a.c.f.f>> Boh;
    private final a.i.b.a.c.k.f<Map<a.i.b.a.c.f.f, n>> Boi;
    private final a.i.b.a.c.k.d<a.i.b.a.c.f.f, a.i.b.a.c.b.c.g> Boj;
    final a.i.b.a.c.b.e Bok;

    static final class c extends a.f.b.i implements a.f.a.b<a.i.b.a.c.f.f, Collection<? extends al>> {
        c(g gVar) {
            super((Object) gVar);
        }

        public final a.i.d dWF() {
            AppMethodBeat.i(119907);
            a.i.b aN = v.aN(g.class);
            AppMethodBeat.o(119907);
            return aN;
        }

        public final String due() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        public final String getName() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic";
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119906);
            a.i.b.a.c.f.f fVar = (a.i.b.a.c.f.f) obj;
            a.f.b.j.p(fVar, "p1");
            Collection b = g.b((g) this.AVx, fVar);
            AppMethodBeat.o(119906);
            return b;
        }
    }

    static final class i extends k implements a.f.a.a<Set<? extends a.i.b.a.c.f.f>> {
        final /* synthetic */ g Bom;

        i(g gVar) {
            this.Bom = gVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119913);
            Set o = t.o(this.Bom.BnJ.ebF());
            AppMethodBeat.o(119913);
            return o;
        }
    }

    static final class j extends k implements a.f.a.b<a.i.b.a.c.f.f, a.i.b.a.c.b.c.g> {
        final /* synthetic */ a.i.b.a.c.d.a.c.h BlU;
        final /* synthetic */ g Bom;

        static final class a extends k implements a.f.a.a<Set<? extends a.i.b.a.c.f.f>> {
            final /* synthetic */ j Boo;

            a(j jVar) {
                this.Boo = jVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(119914);
                Set a = am.a(this.Boo.Bom.eau(), this.Boo.Bom.eav());
                AppMethodBeat.o(119914);
                return a;
            }
        }

        j(g gVar, a.i.b.a.c.d.a.c.h hVar) {
            this.Bom = gVar;
            this.BlU = hVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119915);
            a.i.b.a.c.f.f fVar = (a.i.b.a.c.f.f) obj;
            a.f.b.j.p(fVar, "name");
            a.i.b.a.c.b.c.g gVar;
            if (((Set) this.Bom.Boh.invoke()).contains(fVar)) {
                f fVar2;
                a.i.b.a.c.d.a.j jVar = this.BlU.Bnv.BmR;
                a.i.b.a.c.f.a c = a.i.b.a.c.i.c.a.c(this.Bom.Bok);
                if (c == null) {
                    a.f.b.j.dWJ();
                }
                a.i.b.a.c.d.a.e.g a = jVar.a(c.p(fVar));
                if (a != null) {
                    a.i.b.a.c.d.a.c.h hVar = this.BlU;
                    l lVar = this.Bom.Bok;
                    a.f.b.j.o(a, "it");
                    f fVar3 = new f(hVar, lVar, a);
                    this.BlU.Bnv.Bng.a(fVar3);
                    fVar2 = fVar3;
                } else {
                    fVar2 = null;
                }
                gVar = fVar2;
                AppMethodBeat.o(119915);
                return gVar;
            }
            a.i.b.a.c.b.c.n a2;
            n nVar = (n) ((Map) this.Bom.Boi.invoke()).get(fVar);
            if (nVar != null) {
                a2 = a.i.b.a.c.b.c.n.a(this.BlU.Bnv.Baf, this.Bom.Bok, fVar, this.BlU.Bnv.Baf.i(new a(this)), a.i.b.a.c.d.a.c.f.a(this.BlU, nVar), this.BlU.Bnv.BmZ.a(nVar));
            } else {
                a2 = null;
            }
            gVar = a2;
            AppMethodBeat.o(119915);
            return gVar;
        }
    }

    static final class a extends k implements a.f.a.b<p, Boolean> {
        public static final a Bol = new a();

        static {
            AppMethodBeat.i(119903);
            AppMethodBeat.o(119903);
        }

        a() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            boolean z;
            AppMethodBeat.i(119902);
            p pVar = (p) obj;
            a.f.b.j.p(pVar, "it");
            if (pVar.isStatic()) {
                z = false;
            } else {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(119902);
            return valueOf;
        }
    }

    static final class b extends a.f.b.i implements a.f.a.b<a.i.b.a.c.f.f, Collection<? extends al>> {
        b(g gVar) {
            super((Object) gVar);
        }

        public final a.i.d dWF() {
            AppMethodBeat.i(119905);
            a.i.b aN = v.aN(g.class);
            AppMethodBeat.o(119905);
            return aN;
        }

        public final String due() {
            return "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        public final String getName() {
            return "searchMethodsByNameWithoutBuiltinMagic";
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119904);
            a.i.b.a.c.f.f fVar = (a.i.b.a.c.f.f) obj;
            a.f.b.j.p(fVar, "p1");
            Collection a = g.a((g) this.AVx, fVar);
            AppMethodBeat.o(119904);
            return a;
        }
    }

    static final class d extends k implements a.f.a.b<a.i.b.a.c.f.f, Collection<? extends al>> {
        final /* synthetic */ g Bom;

        d(g gVar) {
            this.Bom = gVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119908);
            a.i.b.a.c.f.f fVar = (a.i.b.a.c.f.f) obj;
            a.f.b.j.p(fVar, "it");
            Collection a = g.a(this.Bom, fVar);
            AppMethodBeat.o(119908);
            return a;
        }
    }

    static final class e extends k implements a.f.a.b<a.i.b.a.c.f.f, Collection<? extends al>> {
        final /* synthetic */ g Bom;

        e(g gVar) {
            this.Bom = gVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119909);
            a.i.b.a.c.f.f fVar = (a.i.b.a.c.f.f) obj;
            a.f.b.j.p(fVar, "it");
            Collection b = g.b(this.Bom, fVar);
            AppMethodBeat.o(119909);
            return b;
        }
    }

    static final class g extends k implements a.f.a.a<Map<a.i.b.a.c.f.f, ? extends n>> {
        final /* synthetic */ g Bom;

        g(g gVar) {
            this.Bom = gVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119911);
            Collection arrayList = new ArrayList();
            for (Object next : this.Bom.BnJ.ebJ()) {
                if (((n) next).ebS()) {
                    arrayList.add(next);
                }
            }
            Iterable iterable = (List) arrayList;
            Map linkedHashMap = new LinkedHashMap(a.h.h.im(ag.SI(m.d(iterable)), 16));
            for (Object next2 : iterable) {
                linkedHashMap.put(((n) next2).dZg(), next2);
            }
            AppMethodBeat.o(119911);
            return linkedHashMap;
        }
    }

    static final class h extends k implements a.f.a.b<a.i.b.a.c.f.f, Collection<? extends al>> {
        final /* synthetic */ g Bom;
        final /* synthetic */ al Bon;

        h(g gVar, al alVar) {
            this.Bom = gVar;
            this.Bon = alVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119912);
            a.i.b.a.c.f.f fVar = (a.i.b.a.c.f.f) obj;
            a.f.b.j.p(fVar, "accessorName");
            Collection listOf;
            if (a.f.b.j.j(this.Bon.dZg(), fVar)) {
                listOf = a.a.k.listOf(this.Bon);
                AppMethodBeat.o(119912);
                return listOf;
            }
            listOf = t.b(g.a(this.Bom, fVar), (Iterable) g.b(this.Bom, fVar));
            AppMethodBeat.o(119912);
            return listOf;
        }
    }

    static final class f extends k implements a.f.a.a<List<? extends a.i.b.a.c.b.d>> {
        final /* synthetic */ a.i.b.a.c.d.a.c.h BlU;
        final /* synthetic */ g Bom;

        f(g gVar, a.i.b.a.c.d.a.c.h hVar) {
            this.Bom = gVar;
            this.BlU = hVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119910);
            Collection<a.i.b.a.c.d.a.e.k> dYb = this.Bom.BnJ.dYb();
            ArrayList arrayList = new ArrayList(dYb.size());
            for (a.i.b.a.c.d.a.e.k a : dYb) {
                arrayList.add(g.a(this.Bom, a));
            }
            a.i.b.a.c.d.a.f.l lVar = this.BlU.Bnv.Bnf;
            a.i.b.a.c.d.a.c.h hVar = this.BlU;
            Collection collection = arrayList;
            if (collection.isEmpty()) {
                collection = a.a.l.dm(g.b(this.Bom));
            }
            List m = t.m(lVar.a(hVar, collection));
            AppMethodBeat.o(119910);
            return m;
        }
    }

    public g(a.i.b.a.c.d.a.c.h hVar, a.i.b.a.c.b.e eVar, a.i.b.a.c.d.a.e.g gVar) {
        a.f.b.j.p(hVar, "c");
        a.f.b.j.p(eVar, "ownerDescriptor");
        a.f.b.j.p(gVar, "jClass");
        super(hVar);
        AppMethodBeat.i(119952);
        this.Bok = eVar;
        this.BnJ = gVar;
        this.Bog = hVar.Bnv.Baf.i(new f(this, hVar));
        this.Boh = hVar.Bnv.Baf.i(new i(this));
        this.Boi = hVar.Bnv.Baf.i(new g(this));
        this.Boj = hVar.Bnv.Baf.g(new j(this, hVar));
        AppMethodBeat.o(119952);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a(a.i.b.a.c.d.a.b.e eVar) {
        AppMethodBeat.i(119918);
        a.f.b.j.p(eVar, "receiver$0");
        if (this.BnJ.ebH()) {
            AppMethodBeat.o(119918);
            return false;
        }
        boolean d = d((al) eVar);
        AppMethodBeat.o(119918);
        return d;
    }

    private final boolean d(al alVar) {
        Object obj;
        AppMethodBeat.i(119919);
        a.i.b.a.c.f.f dZg = alVar.dZg();
        a.f.b.j.o(dZg, "function.name");
        Iterable<a.i.b.a.c.f.f> j = s.j(dZg);
        if (!((j instanceof Collection) && ((Collection) j).isEmpty())) {
            for (a.i.b.a.c.f.f dZg2 : j) {
                Iterable<ah> n = n(dZg2);
                if (!((n instanceof Collection) && ((Collection) n).isEmpty())) {
                    for (ah ahVar : n) {
                        if (!c(ahVar, (a.f.a.b) new h(this, alVar)) || (!ahVar.dZZ() && o.avI(alVar.dZg().name))) {
                            obj = null;
                            continue;
                        } else {
                            obj = 1;
                            continue;
                        }
                        if (obj != null) {
                            obj = 1;
                            continue;
                            break;
                        }
                    }
                }
                obj = null;
                continue;
                if (obj != null) {
                    obj = 1;
                    break;
                }
            }
        }
        obj = null;
        if (obj != null) {
            AppMethodBeat.o(119919);
            return false;
        } else if (f(alVar) || e(alVar) || g(alVar)) {
            AppMethodBeat.o(119919);
            return false;
        } else {
            AppMethodBeat.o(119919);
            return true;
        }
    }

    private final boolean e(al alVar) {
        AppMethodBeat.i(119920);
        a.i.b.a.c.d.a.d dVar = a.i.b.a.c.d.a.d.BkH;
        a.i.b.a.c.f.f dZg = alVar.dZg();
        a.f.b.j.o(dZg, "name");
        if (a.i.b.a.c.d.a.d.h(dZg)) {
            a.i.b.a.c.b.t e;
            dZg = alVar.dZg();
            a.f.b.j.o(dZg, "name");
            Collection arrayList = new ArrayList();
            for (al e2 : m(dZg)) {
                e = a.i.b.a.c.d.a.d.e(e2);
                if (e != null) {
                    arrayList.add(e);
                }
            }
            Iterable<a.i.b.a.c.b.t> iterable = (List) arrayList;
            if (!((Collection) iterable).isEmpty()) {
                for (a.i.b.a.c.b.t e3 : iterable) {
                    if (b(alVar, e3)) {
                        AppMethodBeat.o(119920);
                        return true;
                    }
                }
            }
            AppMethodBeat.o(119920);
            return false;
        }
        AppMethodBeat.o(119920);
        return false;
    }

    private final boolean f(al alVar) {
        AppMethodBeat.i(119921);
        a.i.b.a.c.d.a.c cVar = a.i.b.a.c.d.a.c.Bky;
        a.i.b.a.c.f.f dZg = alVar.dZg();
        a.f.b.j.o(dZg, "name");
        Iterable<a.i.b.a.c.f.f> g = a.i.b.a.c.d.a.c.g(dZg);
        if (!((g instanceof Collection) && ((Collection) g).isEmpty())) {
            for (a.i.b.a.c.f.f dZg2 : g) {
                Object obj;
                Collection arrayList = new ArrayList();
                for (Object next : m(dZg2)) {
                    if (a.i.b.a.c.d.a.t.o((al) next)) {
                        arrayList.add(next);
                    }
                }
                List list = (List) arrayList;
                if (!list.isEmpty()) {
                    al a = a(alVar, dZg2);
                    Iterable<al> iterable = list;
                    if (!((Collection) iterable).isEmpty()) {
                        for (al a2 : iterable) {
                            if (a(a2, (a.i.b.a.c.b.t) a)) {
                                obj = 1;
                                continue;
                                break;
                            }
                        }
                    }
                }
                obj = null;
                continue;
                if (obj != null) {
                    AppMethodBeat.o(119921);
                    return true;
                }
            }
        }
        AppMethodBeat.o(119921);
        return false;
    }

    private final boolean g(al alVar) {
        AppMethodBeat.i(119922);
        al h = h(alVar);
        if (h == null) {
            AppMethodBeat.o(119922);
            return false;
        }
        a.i.b.a.c.f.f dZg = alVar.dZg();
        a.f.b.j.o(dZg, "name");
        Iterable<al> m = m(dZg);
        if (!((Collection) m).isEmpty()) {
            for (al alVar2 : m) {
                Object obj;
                if (alVar2.dZv() && b((a.i.b.a.c.b.a) h, (a.i.b.a.c.b.a) alVar2)) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
                if (obj != null) {
                    AppMethodBeat.o(119922);
                    return true;
                }
            }
        }
        AppMethodBeat.o(119922);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static al h(al alVar) {
        AppMethodBeat.i(119923);
        List dYV = alVar.dYV();
        a.f.b.j.o(dYV, "valueParameters");
        au auVar = (au) t.fM(dYV);
        if (auVar != null) {
            a.i.b.a.c.f.b ehI;
            a.i.b.a.c.b.h dYs = auVar.dZS().ejw().dYs();
            if (dYs != null) {
                a.i.b.a.c.f.c q = a.i.b.a.c.i.c.a.q(dYs);
                if (q != null) {
                    if (!q.ehH()) {
                        q = null;
                    }
                    if (q != null) {
                        ehI = q.ehI();
                        if (!a.i.b.a.c.a.k.a(ehI, false)) {
                            auVar = null;
                        }
                        if (auVar != null) {
                            a.i.b.a.c.b.t.a dZw = alVar.dZw();
                            List dYV2 = alVar.dYV();
                            a.f.b.j.o(dYV2, "valueParameters");
                            al alVar2 = (al) dZw.fR(t.fP(dYV2)).I(((ap) auVar.dZS().ejt().get(0)).dZS()).dZC();
                            ad adVar = (ad) alVar2;
                            if (adVar != null) {
                                adVar.BhZ = true;
                            }
                            AppMethodBeat.o(119923);
                            return alVar2;
                        }
                    }
                }
            }
            ehI = null;
            if (a.i.b.a.c.a.k.a(ehI, false)) {
            }
            if (auVar != null) {
            }
        }
        AppMethodBeat.o(119923);
        return null;
    }

    private static al a(al alVar, a.i.b.a.c.f.f fVar) {
        AppMethodBeat.i(119924);
        a.i.b.a.c.b.t.a dZw = alVar.dZw();
        dZw.e(fVar);
        dZw.dZx();
        dZw.dZy();
        a.i.b.a.c.b.t dZC = dZw.dZC();
        if (dZC == null) {
            a.f.b.j.dWJ();
        }
        al alVar2 = (al) dZC;
        AppMethodBeat.o(119924);
        return alVar2;
    }

    private static boolean a(al alVar, a.i.b.a.c.b.t tVar) {
        Object dZp;
        AppMethodBeat.i(119925);
        a.i.b.a.c.d.a.c cVar = a.i.b.a.c.d.a.c.Bky;
        if (a.i.b.a.c.d.a.c.c(alVar)) {
            dZp = tVar.dZp();
        } else {
            a.i.b.a.c.b.t dZp2 = tVar;
        }
        a.f.b.j.o(dZp2, "if (superDescriptor.isRe…iginal else subDescriptor");
        boolean b = b((a.i.b.a.c.b.a) dZp2, (a.i.b.a.c.b.a) alVar);
        AppMethodBeat.o(119925);
        return b;
    }

    private static boolean b(a.i.b.a.c.b.a aVar, a.i.b.a.c.b.a aVar2) {
        AppMethodBeat.i(119926);
        a.i.b.a.c.i.j.a a = a.i.b.a.c.i.j.BEm.a(aVar2, aVar, true);
        a.f.b.j.o(a, "OverridingUtil.DEFAULT.i…erDescriptor, this, true)");
        a.i.b.a.c.i.j.a.a aVar3 = a.BEy;
        a.f.b.j.o(aVar3, "OverridingUtil.DEFAULT.i…iptor, this, true).result");
        if (aVar3 == a.i.b.a.c.i.j.a.a.OVERRIDABLE) {
            a.i.b.a.c.d.a.m.a aVar4 = a.i.b.a.c.d.a.m.Blf;
            if (!a.i.b.a.c.d.a.m.a.a(aVar2, aVar)) {
                AppMethodBeat.o(119926);
                return true;
            }
        }
        AppMethodBeat.o(119926);
        return false;
    }

    private final al a(ah ahVar, a.f.a.b<? super a.i.b.a.c.f.f, ? extends Collection<? extends al>> bVar) {
        String m;
        AppMethodBeat.i(119927);
        ai dZI = ahVar.dZI();
        ai aiVar = dZI != null ? (ai) a.i.b.a.c.d.a.t.n(dZI) : null;
        if (aiVar != null) {
            a.i.b.a.c.d.a.e eVar = a.i.b.a.c.d.a.e.BkZ;
            m = a.i.b.a.c.d.a.e.m(aiVar);
        } else {
            m = null;
        }
        al a;
        if (m == null || a.i.b.a.c.d.a.t.a(this.Bok, (a.i.b.a.c.b.a) aiVar)) {
            m = o.avJ(ahVar.dZg().name);
            a.f.b.j.o(m, "JvmAbi.getterName(name.asString())");
            a = a(ahVar, m, (a.f.a.b) bVar);
            AppMethodBeat.o(119927);
            return a;
        }
        a = a(ahVar, m, (a.f.a.b) bVar);
        AppMethodBeat.o(119927);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static al a(ah ahVar, String str, a.f.a.b<? super a.i.b.a.c.f.f, ? extends Collection<? extends al>> bVar) {
        AppMethodBeat.i(119928);
        a.i.b.a.c.f.f avX = a.i.b.a.c.f.f.avX(str);
        a.f.b.j.o(avX, "Name.identifier(getterName)");
        for (al alVar : (Iterable) bVar.am(avX)) {
            if (alVar.dYV().size() == 0) {
                boolean z;
                a.i.b.a.c.l.a.c cVar = a.i.b.a.c.l.a.c.BKs;
                w dYT = alVar.dYT();
                if (dYT == null) {
                    z = false;
                } else {
                    z = cVar.c(dYT, ahVar.dZS());
                }
                if (z) {
                    continue;
                    if (alVar != null) {
                        AppMethodBeat.o(119928);
                        return alVar;
                    }
                }
            }
            al alVar2 = null;
            continue;
            if (alVar2 != null) {
            }
        }
        AppMethodBeat.o(119928);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0045 A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static al b(ah ahVar, a.f.a.b<? super a.i.b.a.c.f.f, ? extends Collection<? extends al>> bVar) {
        AppMethodBeat.i(119929);
        a.i.b.a.c.f.f avX = a.i.b.a.c.f.f.avX(o.avK(ahVar.dZg().name));
        a.f.b.j.o(avX, "Name.identifier(JvmAbi.s…terName(name.asString()))");
        for (al alVar : (Iterable) bVar.am(avX)) {
            if (alVar.dYV().size() == 1) {
                w dYT = alVar.dYT();
                if (dYT != null && a.i.b.a.c.a.g.D(dYT)) {
                    a.i.b.a.c.l.a.c cVar = a.i.b.a.c.l.a.c.BKs;
                    List dYV = alVar.dYV();
                    a.f.b.j.o(dYV, "descriptor.valueParameters");
                    Object fN = t.fN(dYV);
                    a.f.b.j.o(fN, "descriptor.valueParameters.single()");
                    if (cVar.d(((au) fN).dZS(), ahVar.dZS())) {
                        continue;
                        if (alVar != null) {
                            AppMethodBeat.o(119929);
                            return alVar;
                        }
                    }
                }
            }
            al alVar2 = null;
            continue;
            if (alVar2 != null) {
            }
        }
        AppMethodBeat.o(119929);
        return null;
    }

    private final boolean c(ah ahVar, a.f.a.b<? super a.i.b.a.c.f.f, ? extends Collection<? extends al>> bVar) {
        AppMethodBeat.i(119930);
        if (c.e(ahVar)) {
            AppMethodBeat.o(119930);
            return false;
        }
        al a = a(ahVar, (a.f.a.b) bVar);
        al b = b(ahVar, (a.f.a.b) bVar);
        if (a == null) {
            AppMethodBeat.o(119930);
            return false;
        } else if (!ahVar.dZZ()) {
            AppMethodBeat.o(119930);
            return true;
        } else if (b == null || b.dYd() != a.dYd()) {
            AppMethodBeat.o(119930);
            return false;
        } else {
            AppMethodBeat.o(119930);
            return true;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(Collection<al> collection, a.i.b.a.c.f.f fVar) {
        Collection arrayList;
        AppMethodBeat.i(119931);
        a.f.b.j.p(collection, "result");
        a.f.b.j.p(fVar, "name");
        Set m = m(fVar);
        a.i.b.a.c.d.a.c cVar = a.i.b.a.c.d.a.c.Bky;
        if (!a.i.b.a.c.d.a.c.f(fVar)) {
            a.i.b.a.c.d.a.d dVar = a.i.b.a.c.d.a.d.BkH;
            if (!a.i.b.a.c.d.a.d.h(fVar)) {
                boolean z;
                Iterable<a.i.b.a.c.b.t> iterable = m;
                if (!((Collection) iterable).isEmpty()) {
                    for (a.i.b.a.c.b.t dZv : iterable) {
                        if (dZv.dZv()) {
                            z = false;
                            break;
                        }
                    }
                }
                z = true;
                if (z) {
                    arrayList = new ArrayList();
                    for (Object next : m) {
                        if (d((al) next)) {
                            arrayList.add(next);
                        }
                    }
                    a((Collection) collection, (Collection) (List) arrayList, false);
                    AppMethodBeat.o(119931);
                    return;
                }
            }
        }
        a.i.b.a.c.n.i.b bVar = a.i.b.a.c.n.i.BNv;
        a.i.b.a.c.n.i ekD = a.i.b.a.c.n.i.b.ekD();
        Collection a = a.i.b.a.c.d.a.a.a.a(m, a.a.v.AUP, this.Bok, a.i.b.a.c.j.a.m.BHf);
        a.f.b.j.o(a, "resolveOverridesForNonSt…rter.DO_NOTHING\n        )");
        a(fVar, collection, a, collection, new b(this));
        a(fVar, collection, a, ekD, new c(this));
        arrayList = new ArrayList();
        for (Object next2 : m) {
            if (d((al) next2)) {
                arrayList.add(next2);
            }
        }
        a((Collection) collection, (Collection) t.b((Collection) (List) arrayList, (Iterable) ekD), true);
        AppMethodBeat.o(119931);
    }

    private final void a(a.i.b.a.c.f.f fVar, Collection<? extends al> collection, Collection<? extends al> collection2, Collection<al> collection3, a.f.a.b<? super a.i.b.a.c.f.f, ? extends Collection<? extends al>> bVar) {
        AppMethodBeat.i(119933);
        for (al alVar : collection2) {
            al alVar2;
            Object a;
            al alVar3 = (al) a.i.b.a.c.d.a.t.n(alVar);
            if (alVar3 != null) {
                String q = a.i.b.a.c.d.a.t.q(alVar3);
                if (q == null) {
                    a.f.b.j.dWJ();
                }
                a.i.b.a.c.f.f avX = a.i.b.a.c.f.f.avX(q);
                a.f.b.j.o(avX, "Name.identifier(nameInJava)");
                for (al alVar22 : (Collection) bVar.am(avX)) {
                    al a2 = a(alVar22, fVar);
                    if (a(alVar3, (a.i.b.a.c.b.t) a2)) {
                        a = a(a2, (a.i.b.a.c.b.a) alVar3, (Collection) collection);
                        break;
                    }
                }
            }
            a = null;
            a.i.b.a.c.n.a.b(collection3, a);
            a.i.b.a.c.b.t e = a.i.b.a.c.d.a.d.e(alVar);
            if (e == null) {
                a = null;
            } else {
                a.i.b.a.c.f.f dZg = e.dZg();
                a.f.b.j.o(dZg, "overridden.name");
                for (Object next : (Iterable) bVar.am(dZg)) {
                    if (b((al) next, e)) {
                        a = next;
                        break;
                    }
                }
                a = null;
                alVar3 = (al) a;
                if (alVar3 != null) {
                    a.i.b.a.c.b.t.a dZw = alVar3.dZw();
                    List dYV = e.dYV();
                    a.f.b.j.o(dYV, "overridden.valueParameters");
                    Iterable<au> iterable = dYV;
                    Collection arrayList = new ArrayList(m.d(iterable));
                    for (au auVar : iterable) {
                        a.f.b.j.o(auVar, "it");
                        w dZS = auVar.dZS();
                        a.f.b.j.o(dZS, "it.type");
                        arrayList.add(new a.i.b.a.c.d.a.b.j(dZS, auVar.dZU()));
                    }
                    arrayList = (List) arrayList;
                    List dYV2 = alVar3.dYV();
                    a.f.b.j.o(dYV2, "override.valueParameters");
                    dZw.fR(a.i.b.a.c.d.a.b.i.a(arrayList, dYV2, e));
                    dZw.dZx();
                    dZw.dZy();
                    alVar22 = (al) dZw.dZC();
                } else {
                    alVar22 = null;
                }
                if (alVar22 != null) {
                    alVar3 = ((g) this).d(alVar22) ? alVar22 : null;
                    if (alVar3 != null) {
                        a = a(alVar3, (a.i.b.a.c.b.a) e, (Collection) collection);
                    }
                }
                a = null;
            }
            a.i.b.a.c.n.a.b(collection3, a);
            a.i.b.a.c.n.a.b(collection3, a(alVar, (a.f.a.b) bVar));
        }
        AppMethodBeat.o(119933);
    }

    private static al a(al alVar, a.f.a.b<? super a.i.b.a.c.f.f, ? extends Collection<? extends al>> bVar) {
        AppMethodBeat.i(119934);
        if (alVar.dZv()) {
            a.i.b.a.c.f.f dZg = alVar.dZg();
            a.f.b.j.o(dZg, "descriptor.name");
            for (al h : (Iterable) bVar.am(dZg)) {
                al h2;
                al h3 = h(h2);
                if (h3 == null) {
                    h2 = null;
                    continue;
                } else if (b((a.i.b.a.c.b.a) h3, (a.i.b.a.c.b.a) alVar)) {
                    h2 = h3;
                    continue;
                } else {
                    h2 = null;
                    continue;
                }
                if (h2 != null) {
                    AppMethodBeat.o(119934);
                    return h2;
                }
            }
            AppMethodBeat.o(119934);
            return null;
        }
        AppMethodBeat.o(119934);
        return null;
    }

    private static al a(al alVar, a.i.b.a.c.b.a aVar, Collection<? extends al> collection) {
        al alVar2;
        Object obj;
        AppMethodBeat.i(119935);
        Iterable<al> iterable = collection;
        if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
            for (al alVar22 : iterable) {
                if ((a.f.b.j.j(alVar, alVar22) ^ 1) != 0 && alVar22.dZq() == null && b((a.i.b.a.c.b.a) alVar22, aVar)) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
                if (obj != null) {
                    obj = null;
                    break;
                }
            }
        }
        int i = 1;
        if (obj != null) {
            AppMethodBeat.o(119935);
            return alVar;
        }
        a.i.b.a.c.b.t dZC = alVar.dZw().dZA().dZC();
        if (dZC == null) {
            a.f.b.j.dWJ();
        }
        alVar22 = (al) dZC;
        AppMethodBeat.o(119935);
        return alVar22;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(a.i.b.a.c.f.f fVar, Collection<ah> collection) {
        AppMethodBeat.i(119937);
        a.f.b.j.p(fVar, "name");
        a.f.b.j.p(collection, "result");
        if (this.BnJ.ebH()) {
            q qVar = (q) t.i((Iterable) ((b) this.BoC.invoke()).k(fVar));
            if (qVar != null) {
                a.i.b.a.c.b.w wVar = a.i.b.a.c.b.w.FINAL;
                a.i.b.a.c.d.a.b.f a = a.i.b.a.c.d.a.b.f.a(this.Bok, a.i.b.a.c.d.a.c.f.a(this.Bnn, qVar), wVar, qVar.dYf(), false, qVar.dZg(), this.Bnn.Bnv.BmZ.a(qVar), false);
                a.f.b.j.o(a, "JavaPropertyDescriptor.c…inal = */ false\n        )");
                ah ahVar = a;
                a.i.b.a.c.b.a.g.a aVar = a.i.b.a.c.b.a.g.BfJ;
                aa a2 = a.i.b.a.c.i.c.a(ahVar, a.i.b.a.c.b.a.g.a.eai());
                a.f.b.j.o(a2, "DescriptorFactory.create…iptor, Annotations.EMPTY)");
                a.a(a2, null);
                w a3 = k.a(qVar, a.i.b.a.c.d.a.c.a.a(this.Bnn, (l) a, (x) qVar, 0));
                a.a(a3, (List) a.a.v.AUP, dYR(), null);
                a2.K(a3);
                collection.add(a);
            }
        }
        Set n = n(fVar);
        if (n.isEmpty()) {
            AppMethodBeat.o(119937);
            return;
        }
        a.i.b.a.c.n.i.b bVar = a.i.b.a.c.n.i.BNv;
        a.i.b.a.c.n.i ekD = a.i.b.a.c.n.i.b.ekD();
        a(n, (Collection) collection, (a.f.a.b) new d(this));
        a(n, (Collection) ekD, (a.f.a.b) new e(this));
        Collection a4 = a.i.b.a.c.d.a.a.a.a(am.a(n, ekD), collection, this.Bok, this.Bnn.Bnv.BmV);
        a.f.b.j.o(a4, "resolveOverridesForNonSt…rorReporter\n            )");
        collection.addAll(a4);
        AppMethodBeat.o(119937);
    }

    private final void a(Set<? extends ah> set, Collection<ah> collection, a.f.a.b<? super a.i.b.a.c.f.f, ? extends Collection<? extends al>> bVar) {
        AppMethodBeat.i(119938);
        for (ah d : set) {
            a.i.b.a.c.d.a.b.f d2 = d(d, (a.f.a.b) bVar);
            if (d2 != null) {
                collection.add(d2);
                AppMethodBeat.o(119938);
                return;
            }
        }
        AppMethodBeat.o(119938);
    }

    private final a.i.b.a.c.d.a.b.f d(ah ahVar, a.f.a.b<? super a.i.b.a.c.f.f, ? extends Collection<? extends al>> bVar) {
        boolean z = true;
        AppMethodBeat.i(119939);
        if (c(ahVar, (a.f.a.b) bVar)) {
            al b;
            al a = a(ahVar, (a.f.a.b) bVar);
            if (a == null) {
                a.f.b.j.dWJ();
            }
            if (ahVar.dZZ()) {
                b = b(ahVar, (a.f.a.b) bVar);
                if (b == null) {
                    a.f.b.j.dWJ();
                }
            } else {
                b = null;
            }
            boolean z2 = b != null ? b.dYd() == a.dYd() : true;
            Throwable assertionError;
            if (!a.aa.AUz || z2) {
                ab abVar;
                l lVar = this.Bok;
                a.i.b.a.c.b.a.g.a aVar = a.i.b.a.c.b.a.g.BfJ;
                a.i.b.a.c.b.a.g eai = a.i.b.a.c.b.a.g.a.eai();
                a.i.b.a.c.b.w dYd = a.dYd();
                az dYf = a.dYf();
                if (b == null) {
                    z = false;
                }
                a.i.b.a.c.d.a.b.f a2 = a.i.b.a.c.d.a.b.f.a(lVar, eai, dYd, dYf, z, ahVar.dZg(), a.dYo(), false);
                a.f.b.j.o(a2, "JavaPropertyDescriptor.c…inal = */ false\n        )");
                w dYT = a.dYT();
                if (dYT == null) {
                    a.f.b.j.dWJ();
                }
                a2.a(dYT, (List) a.a.v.AUP, dYR(), null);
                aa a3 = a.i.b.a.c.i.c.a((ah) a2, a.dYn(), false, a.dYo());
                a3.Big = a;
                a3.K(a2.dZS());
                a.f.b.j.o(a3, "DescriptorFactory.create…escriptor.type)\n        }");
                if (b != null) {
                    List dYV = b.dYV();
                    a.f.b.j.o(dYV, "setterMethod.valueParameters");
                    au auVar = (au) t.fK(dYV);
                    if (auVar == null) {
                        assertionError = new AssertionError("No parameter found for ".concat(String.valueOf(b)));
                        AppMethodBeat.o(119939);
                        throw assertionError;
                    }
                    ab a4 = a.i.b.a.c.i.c.a(a2, b.dYn(), auVar.dYn(), false, b.dYf(), b.dYo());
                    a4.Big = b;
                    abVar = a4;
                } else {
                    a.i.b.a.c.b.c.k abVar2 = null;
                }
                a2.a(a3, (aj) abVar2);
                AppMethodBeat.o(119939);
                return a2;
            }
            Object dYd2;
            StringBuilder append = new StringBuilder("Different accessors modalities when creating overrides for ").append(ahVar).append(" in ").append(this.Bok).append("for getter is ").append(a.dYd()).append(", but for setter is ");
            if (b != null) {
                dYd2 = b.dYd();
            } else {
                dYd2 = null;
            }
            assertionError = new AssertionError(append.append(dYd2).toString());
            AppMethodBeat.o(119939);
            throw assertionError;
        }
        AppMethodBeat.o(119939);
        return null;
    }

    private static boolean b(al alVar, a.i.b.a.c.b.t tVar) {
        AppMethodBeat.i(119942);
        String a = r.a(alVar, false, false, 2);
        a.i.b.a.c.b.t dZp = tVar.dZp();
        a.f.b.j.o(dZp, "builtinWithErasedParameters.original");
        if (!a.f.b.j.j(a, r.a(dZp, false, false, 2)) || b((a.i.b.a.c.b.a) alVar, (a.i.b.a.c.b.a) tVar)) {
            AppMethodBeat.o(119942);
            return false;
        }
        AppMethodBeat.o(119942);
        return true;
    }

    private final void a(List<au> list, a.i.b.a.c.b.k kVar, int i, q qVar, w wVar, w wVar2) {
        w aA;
        int i2;
        a.i.b.a.c.b.a aVar;
        AppMethodBeat.i(119943);
        a.i.b.a.c.b.a aVar2 = kVar;
        a.i.b.a.c.b.a.g.a aVar3 = a.i.b.a.c.b.a.g.BfJ;
        a.i.b.a.c.b.a.g eai = a.i.b.a.c.b.a.g.a.eai();
        a.i.b.a.c.f.f dZg = qVar.dZg();
        w aA2 = av.aA(wVar);
        a.f.b.j.o(aA2, "TypeUtils.makeNotNullable(returnType)");
        boolean ebW = qVar.ebW();
        if (wVar2 != null) {
            aA = av.aA(wVar2);
            i2 = i;
            aVar = aVar2;
        } else {
            aA = null;
            i2 = i;
            aVar = aVar2;
        }
        list.add(new a.i.b.a.c.b.c.ai(aVar, null, i2, eai, dZg, aA2, ebW, false, false, aA, this.Bnn.Bnv.BmZ.a(qVar)));
        AppMethodBeat.o(119943);
    }

    public final a.i.b.a.c.b.h c(a.i.b.a.c.f.f fVar, a.i.b.a.c.c.a.a aVar) {
        AppMethodBeat.i(119945);
        a.f.b.j.p(fVar, "name");
        a.f.b.j.p(aVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        d(fVar, aVar);
        a.i.b.a.c.b.h hVar = (a.i.b.a.c.b.h) this.Boj.am(fVar);
        AppMethodBeat.o(119945);
        return hVar;
    }

    public final Collection<al> b(a.i.b.a.c.f.f fVar, a.i.b.a.c.c.a.a aVar) {
        AppMethodBeat.i(119946);
        a.f.b.j.p(fVar, "name");
        a.f.b.j.p(aVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        d(fVar, aVar);
        Collection b = super.b(fVar, aVar);
        AppMethodBeat.o(119946);
        return b;
    }

    public final Collection<ah> a(a.i.b.a.c.f.f fVar, a.i.b.a.c.c.a.a aVar) {
        AppMethodBeat.i(119947);
        a.f.b.j.p(fVar, "name");
        a.f.b.j.p(aVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        d(fVar, aVar);
        Collection a = super.a(fVar, aVar);
        AppMethodBeat.o(119947);
        return a;
    }

    /* Access modifiers changed, original: protected|final */
    public final Set<a.i.b.a.c.f.f> c(a.i.b.a.c.i.e.d dVar, a.f.a.b<? super a.i.b.a.c.f.f, Boolean> bVar) {
        AppMethodBeat.i(119948);
        a.f.b.j.p(dVar, "kindFilter");
        Set a = am.a((Set) this.Boh.invoke(), ((Map) this.Boi.invoke()).keySet());
        AppMethodBeat.o(119948);
        return a;
    }

    /* Access modifiers changed, original: protected|final */
    public final Set<a.i.b.a.c.f.f> a(a.i.b.a.c.i.e.d dVar) {
        AppMethodBeat.i(119949);
        a.f.b.j.p(dVar, "kindFilter");
        if (this.BnJ.ebH()) {
            Set eau = eau();
            AppMethodBeat.o(119949);
            return eau;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(((b) this.BoC.invoke()).ebo());
        an dXY = this.Bok.dXY();
        a.f.b.j.o(dXY, "ownerDescriptor.typeConstructor");
        Collection<w> eap = dXY.eap();
        a.f.b.j.o(eap, "ownerDescriptor.typeConstructor.supertypes");
        for (w dXR : eap) {
            a.a.q.a((Collection) linkedHashSet, (Iterable) dXR.dXR().eav());
        }
        Set<a.i.b.a.c.f.f> set = linkedHashSet;
        AppMethodBeat.o(119949);
        return set;
    }

    public final String toString() {
        AppMethodBeat.i(119951);
        String str = "Lazy Java member scope for " + this.BnJ.dZF();
        AppMethodBeat.o(119951);
        return str;
    }

    public final /* synthetic */ b ebt() {
        AppMethodBeat.i(119916);
        b aVar = new a(this.BnJ, a.Bol);
        AppMethodBeat.o(119916);
        return aVar;
    }

    private final void a(Collection<al> collection, Collection<? extends al> collection2, boolean z) {
        AppMethodBeat.i(119932);
        Collection a = a.i.b.a.c.d.a.a.a.a(collection2, collection, this.Bok, this.Bnn.Bnv.BmV);
        a.f.b.j.o(a, "resolveOverridesForNonSt…s.errorReporter\n        )");
        if (z) {
            List b = t.b((Collection) collection, (Iterable) a);
            Iterable<al> iterable = a;
            Collection arrayList = new ArrayList(m.d(iterable));
            for (al alVar : iterable) {
                Object alVar2;
                al alVar3 = (al) a.i.b.a.c.d.a.t.p(alVar2);
                if (alVar3 != null) {
                    a.f.b.j.o(alVar2, "resolvedOverride");
                    alVar2 = a(alVar2, (a.i.b.a.c.b.a) alVar3, (Collection) b);
                }
                arrayList.add(alVar2);
            }
            collection.addAll((List) arrayList);
            AppMethodBeat.o(119932);
            return;
        }
        collection.addAll(a);
        AppMethodBeat.o(119932);
    }

    private final Set<al> m(a.i.b.a.c.f.f fVar) {
        AppMethodBeat.i(119936);
        an dXY = this.Bok.dXY();
        a.f.b.j.o(dXY, "ownerDescriptor.typeConstructor");
        Collection<w> eap = dXY.eap();
        a.f.b.j.o(eap, "ownerDescriptor.typeConstructor.supertypes");
        Collection linkedHashSet = new LinkedHashSet();
        for (w dXR : eap) {
            a.a.q.a(linkedHashSet, (Iterable) dXR.dXR().b(fVar, a.i.b.a.c.c.a.c.WHEN_GET_SUPER_MEMBERS));
        }
        Set set = (Set) linkedHashSet;
        AppMethodBeat.o(119936);
        return set;
    }

    private final Set<ah> n(a.i.b.a.c.f.f fVar) {
        AppMethodBeat.i(119940);
        an dXY = this.Bok.dXY();
        a.f.b.j.o(dXY, "ownerDescriptor.typeConstructor");
        Collection<w> eap = dXY.eap();
        a.f.b.j.o(eap, "ownerDescriptor.typeConstructor.supertypes");
        Collection arrayList = new ArrayList();
        for (w dXR : eap) {
            Iterable<ah> a = dXR.dXR().a(fVar, a.i.b.a.c.c.a.c.WHEN_GET_SUPER_MEMBERS);
            Collection arrayList2 = new ArrayList(m.d(a));
            for (ah add : a) {
                arrayList2.add(add);
            }
            a.a.q.a(arrayList, (Iterable) (List) arrayList2);
        }
        Set o = t.o((List) arrayList);
        AppMethodBeat.o(119940);
        return o;
    }

    /* Access modifiers changed, original: protected|final */
    public final a a(q qVar, List<? extends ar> list, w wVar, List<? extends au> list2) {
        AppMethodBeat.i(119941);
        a.f.b.j.p(qVar, com.google.firebase.analytics.FirebaseAnalytics.b.METHOD);
        a.f.b.j.p(list, "methodTypeParameters");
        a.f.b.j.p(wVar, "returnType");
        a.f.b.j.p(list2, "valueParameters");
        a.i.b.a.c.d.a.a.k.a a = this.Bnn.Bnv.BmU.a(wVar, list2, list);
        a.f.b.j.o(a, "c.components.signaturePr…dTypeParameters\n        )");
        w wVar2 = a.Bji;
        a.f.b.j.o(wVar2, "propagated.returnType");
        w wVar3 = a.Bms;
        List list3 = a.Bmt;
        a.f.b.j.o(list3, "propagated.valueParameters");
        List list4 = a.BeK;
        a.f.b.j.o(list4, "propagated.typeParameters");
        boolean z = a.Bia;
        List list5 = a.Bmu;
        a.f.b.j.o(list5, "propagated.errors");
        a aVar = new a(wVar2, wVar3, list3, list4, z, list5);
        AppMethodBeat.o(119941);
        return aVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final ak dYR() {
        AppMethodBeat.i(119944);
        ak l = a.i.b.a.c.i.d.l(this.Bok);
        AppMethodBeat.o(119944);
        return l;
    }

    public final void d(a.i.b.a.c.f.f fVar, a.i.b.a.c.c.a.a aVar) {
        AppMethodBeat.i(119950);
        a.f.b.j.p(fVar, "name");
        a.f.b.j.p(aVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        a.i.b.a.c.c.a.a(this.Bnn.Bnv.Bnc, aVar, this.Bok, fVar);
        AppMethodBeat.o(119950);
    }

    public final /* bridge */ /* synthetic */ l ebu() {
        return this.Bok;
    }

    public static final /* synthetic */ a.i.b.a.c.b.d b(g gVar) {
        AppMethodBeat.i(119956);
        boolean ebH = gVar.BnJ.ebH();
        if (!gVar.BnJ.isInterface() || ebH) {
            List list;
            a.i.b.a.c.b.e eVar = gVar.Bok;
            a.i.b.a.c.b.a.g.a aVar = a.i.b.a.c.b.a.g.BfJ;
            a.i.b.a.c.d.a.b.c a = a.i.b.a.c.d.a.b.c.a(eVar, a.i.b.a.c.b.a.g.a.eai(), true, (a.i.b.a.c.b.am) gVar.Bnn.Bnv.BmZ.a(gVar.BnJ));
            a.f.b.j.o(a, "JavaClassConstructorDesc….source(jClass)\n        )");
            if (ebH) {
                a.i.b.a.c.b.c.f fVar = a;
                Collection ebI = gVar.BnJ.ebI();
                ArrayList arrayList = new ArrayList(ebI.size());
                a.i.b.a.c.d.a.c.b.a a2 = a.i.b.a.c.d.a.c.b.d.a(a.i.b.a.c.d.a.a.l.COMMON, true, null, 2);
                Iterable iterable = ebI;
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                for (Object next : iterable) {
                    if (a.f.b.j.j(((q) next).dZg(), a.i.b.a.c.d.a.p.Bln)) {
                        arrayList2.add(next);
                    } else {
                        arrayList3.add(next);
                    }
                }
                a.o oVar = new a.o(arrayList2, arrayList3);
                List list2 = (List) oVar.first;
                List list3 = (List) oVar.second;
                Object next2 = list2.size() <= 1 ? 1 : null;
                if (a.aa.AUz && next2 == null) {
                    Throwable assertionError = new AssertionError("There can't be more than one method named 'value' in annotation class: " + gVar.BnJ);
                    AppMethodBeat.o(119956);
                    throw assertionError;
                }
                q qVar = (q) t.fK(list2);
                if (qVar != null) {
                    a.o oVar2;
                    a.i.b.a.c.d.a.e.v ebV = qVar.ebV();
                    if (ebV instanceof a.i.b.a.c.d.a.e.f) {
                        oVar2 = new a.o(gVar.Bnn.Bnu.a((a.i.b.a.c.d.a.e.f) ebV, a2, true), gVar.Bnn.Bnu.a(((a.i.b.a.c.d.a.e.f) ebV).ebE(), a2));
                    } else {
                        oVar2 = new a.o(gVar.Bnn.Bnu.a(ebV, a2), null);
                    }
                    gVar.a(arrayList, fVar, 0, qVar, (w) oVar2.first, (w) oVar2.second);
                }
                int i = qVar != null ? 1 : 0;
                int i2 = 0;
                Iterator it = list3.iterator();
                while (true) {
                    int i3 = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    qVar = (q) it.next();
                    gVar.a(arrayList, fVar, i3 + i, qVar, gVar.Bnn.Bnu.a(qVar.ebV(), a2), null);
                    i2 = i3 + 1;
                }
                list = arrayList;
            } else {
                list = Collections.emptyList();
            }
            a.rI(false);
            az dYf = eVar.dYf();
            a.f.b.j.o(dYf, "classDescriptor.visibility");
            if (a.f.b.j.j(dYf, a.i.b.a.c.d.a.n.Blh)) {
                dYf = a.i.b.a.c.d.a.n.Bli;
                a.f.b.j.o(dYf, "JavaVisibilities.PROTECTED_AND_PACKAGE");
            }
            a.a(list, dYf);
            a.rH(true);
            a.BhN = eVar.dZf();
            a.i.b.a.c.b.d dVar = a;
            AppMethodBeat.o(119956);
            return dVar;
        }
        AppMethodBeat.o(119956);
        return null;
    }
}
