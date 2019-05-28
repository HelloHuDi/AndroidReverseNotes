package a.i.b.a.c.d.a.c.a;

import a.a.af;
import a.a.ag;
import a.a.m;
import a.f.b.t;
import a.f.b.v;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.ak;
import a.i.b.a.c.b.al;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.c.ai;
import a.i.b.a.c.b.c.z;
import a.i.b.a.c.b.l;
import a.i.b.a.c.d.a.e.n;
import a.i.b.a.c.d.a.e.q;
import a.i.b.a.c.d.a.e.x;
import a.i.b.a.c.d.a.e.y;
import a.i.b.a.c.d.a.p;
import a.i.b.a.c.i.b.s;
import a.i.b.a.c.l.w;
import a.o;
import a.u;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class k extends a.i.b.a.c.i.e.i {
    static final /* synthetic */ a.i.k[] eQB = new a.i.k[]{v.a(new t(v.aN(k.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), v.a(new t(v.aN(k.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), v.a(new t(v.aN(k.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    private final a.i.b.a.c.k.c<a.i.b.a.c.f.f, Collection<al>> BhE = this.Bnn.Bnv.Baf.f(new g(this));
    private final a.i.b.a.c.k.c<a.i.b.a.c.f.f, List<ah>> BhF = this.Bnn.Bnv.Baf.f(new h(this));
    private final a.i.b.a.c.k.f<Collection<l>> BhG = this.Bnn.Bnv.Baf.a(new c(this), a.a.v.AUP);
    final a.i.b.a.c.d.a.c.h Bnn;
    final a.i.b.a.c.k.f<b> BoC = this.Bnn.Bnv.Baf.i(new e(this));
    private final a.i.b.a.c.k.f BoD = this.Bnn.Bnv.Baf.i(new f(this));
    private final a.i.b.a.c.k.f BoE = this.Bnn.Bnv.Baf.i(new i(this));
    private final a.i.b.a.c.k.f BoF = this.Bnn.Bnv.Baf.i(new d(this));

    static final class c extends a.f.b.k implements a.f.a.a<List<? extends l>> {
        final /* synthetic */ k BoJ;

        c(k kVar) {
            this.BoJ = kVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119991);
            k kVar = this.BoJ;
            a.i.b.a.c.i.e.d dVar = a.i.b.a.c.i.e.d.BFL;
            a.i.b.a.c.i.e.h.a aVar = a.i.b.a.c.i.e.h.BGd;
            List a = kVar.a(dVar, a.i.b.a.c.i.e.h.a.ejN(), (a.i.b.a.c.c.a.a) a.i.b.a.c.c.a.c.WHEN_GET_ALL_DESCRIPTORS);
            AppMethodBeat.o(119991);
            return a;
        }
    }

    protected static final class b {
        final List<au> BoH;
        final boolean BoI;

        public b(List<? extends au> list, boolean z) {
            a.f.b.j.p(list, "descriptors");
            AppMethodBeat.i(119990);
            this.BoH = list;
            this.BoI = z;
            AppMethodBeat.o(119990);
        }
    }

    static final class e extends a.f.b.k implements a.f.a.a<b> {
        final /* synthetic */ k BoJ;

        e(k kVar) {
            this.BoJ = kVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119993);
            b ebt = this.BoJ.ebt();
            AppMethodBeat.o(119993);
            return ebt;
        }
    }

    static final class d extends a.f.b.k implements a.f.a.a<Set<? extends a.i.b.a.c.f.f>> {
        final /* synthetic */ k BoJ;

        d(k kVar) {
            this.BoJ = kVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119992);
            Set c = this.BoJ.c(a.i.b.a.c.i.e.d.BFQ, null);
            AppMethodBeat.o(119992);
            return c;
        }
    }

    protected static final class a {
        final List<ar> BeK;
        final boolean Bia;
        final w Bji;
        final w Bms;
        final List<au> Bmt;
        final List<String> BoG;

        /* JADX WARNING: Missing block: B:17:0x0049, code skipped:
            if (a.f.b.j.j(r5.BoG, r6.BoG) != false) goto L_0x004b;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(Object obj) {
            AppMethodBeat.i(119989);
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (a.f.b.j.j(this.Bji, aVar.Bji) && a.f.b.j.j(this.Bms, aVar.Bms) && a.f.b.j.j(this.Bmt, aVar.Bmt) && a.f.b.j.j(this.BeK, aVar.BeK)) {
                        if (this.Bia == aVar.Bia) {
                        }
                    }
                }
                AppMethodBeat.o(119989);
                return false;
            }
            AppMethodBeat.o(119989);
            return true;
        }

        public final int hashCode() {
            int i = 0;
            AppMethodBeat.i(119988);
            w wVar = this.Bji;
            int hashCode = (wVar != null ? wVar.hashCode() : 0) * 31;
            wVar = this.Bms;
            hashCode = ((wVar != null ? wVar.hashCode() : 0) + hashCode) * 31;
            List list = this.Bmt;
            hashCode = ((list != null ? list.hashCode() : 0) + hashCode) * 31;
            list = this.BeK;
            hashCode = ((list != null ? list.hashCode() : 0) + hashCode) * 31;
            int i2 = this.Bia;
            if (i2 != 0) {
                i2 = 1;
            }
            i2 = (i2 + hashCode) * 31;
            List list2 = this.BoG;
            if (list2 != null) {
                i = list2.hashCode();
            }
            i2 += i;
            AppMethodBeat.o(119988);
            return i2;
        }

        public final String toString() {
            AppMethodBeat.i(119987);
            String str = "MethodSignatureData(returnType=" + this.Bji + ", receiverType=" + this.Bms + ", valueParameters=" + this.Bmt + ", typeParameters=" + this.BeK + ", hasStableParameterNames=" + this.Bia + ", errors=" + this.BoG + ")";
            AppMethodBeat.o(119987);
            return str;
        }

        public a(w wVar, w wVar2, List<? extends au> list, List<? extends ar> list2, boolean z, List<String> list3) {
            a.f.b.j.p(wVar, "returnType");
            a.f.b.j.p(list, "valueParameters");
            a.f.b.j.p(list2, "typeParameters");
            a.f.b.j.p(list3, "errors");
            AppMethodBeat.i(119986);
            this.Bji = wVar;
            this.Bms = wVar2;
            this.Bmt = list;
            this.BeK = list2;
            this.Bia = z;
            this.BoG = list3;
            AppMethodBeat.o(119986);
        }
    }

    static final class g extends a.f.b.k implements a.f.a.b<a.i.b.a.c.f.f, List<? extends al>> {
        final /* synthetic */ k BoJ;

        g(k kVar) {
            this.BoJ = kVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119995);
            a.i.b.a.c.f.f fVar = (a.i.b.a.c.f.f) obj;
            a.f.b.j.p(fVar, "name");
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (q a : ((b) this.BoJ.BoC.invoke()).k(fVar)) {
                a.i.b.a.c.d.a.b.e a2 = this.BoJ.a(a);
                if (this.BoJ.a(a2)) {
                    linkedHashSet.add(a2);
                }
            }
            Collection collection = linkedHashSet;
            a.f.b.j.p(collection, "receiver$0");
            Collection b = a.i.b.a.c.i.k.b(collection, a.i.b.a.c.i.k.a.BEE);
            if (collection.size() != b.size()) {
                collection.retainAll(b);
            }
            this.BoJ.a((Collection) linkedHashSet, fVar);
            List m = a.a.t.m(this.BoJ.Bnn.Bnv.Bnf.a(this.BoJ.Bnn, (Collection) linkedHashSet));
            AppMethodBeat.o(119995);
            return m;
        }
    }

    static final class i extends a.f.b.k implements a.f.a.a<Set<? extends a.i.b.a.c.f.f>> {
        final /* synthetic */ k BoJ;

        i(k kVar) {
            this.BoJ = kVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119997);
            Set a = this.BoJ.a(a.i.b.a.c.i.e.d.BFT);
            AppMethodBeat.o(119997);
            return a;
        }
    }

    static final class j extends a.f.b.k implements a.f.a.a<a.i.b.a.c.i.b.f<?>> {
        final /* synthetic */ k BoJ;
        final /* synthetic */ n BoK;
        final /* synthetic */ z BoL;

        j(k kVar, n nVar, z zVar) {
            this.BoJ = kVar;
            this.BoK = nVar;
            this.BoL = zVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119998);
            a.i.b.a.c.i.b.f a = this.BoJ.Bnn.Bnv.BmX.a(this.BoK, this.BoL);
            AppMethodBeat.o(119998);
            return a;
        }
    }

    static final class f extends a.f.b.k implements a.f.a.a<Set<? extends a.i.b.a.c.f.f>> {
        final /* synthetic */ k BoJ;

        f(k kVar) {
            this.BoJ = kVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119994);
            Set b = this.BoJ.b(a.i.b.a.c.i.e.d.BFS, null);
            AppMethodBeat.o(119994);
            return b;
        }
    }

    static final class h extends a.f.b.k implements a.f.a.b<a.i.b.a.c.f.f, List<? extends ah>> {
        final /* synthetic */ k BoJ;

        h(k kVar) {
            this.BoJ = kVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119996);
            a.i.b.a.c.f.f fVar = (a.i.b.a.c.f.f) obj;
            a.f.b.j.p(fVar, "name");
            ArrayList arrayList = new ArrayList();
            n l = ((b) this.BoJ.BoC.invoke()).l(fVar);
            if (!(l == null || l.ebS())) {
                arrayList.add(k.a(this.BoJ, l));
            }
            this.BoJ.a(fVar, (Collection) arrayList);
            if (a.i.b.a.c.i.d.z(this.BoJ.ebu())) {
                List m = a.a.t.m(arrayList);
                AppMethodBeat.o(119996);
                return m;
            }
            Object m2 = a.a.t.m(this.BoJ.Bnn.Bnv.Bnf.a(this.BoJ.Bnn, (Collection) arrayList));
            AppMethodBeat.o(119996);
            return m2;
        }
    }

    public abstract a a(q qVar, List<? extends ar> list, w wVar, List<? extends au> list2);

    public abstract Set<a.i.b.a.c.f.f> a(a.i.b.a.c.i.e.d dVar);

    public abstract void a(a.i.b.a.c.f.f fVar, Collection<ah> collection);

    public abstract void a(Collection<al> collection, a.i.b.a.c.f.f fVar);

    public abstract Set<a.i.b.a.c.f.f> b(a.i.b.a.c.i.e.d dVar, a.f.a.b<? super a.i.b.a.c.f.f, Boolean> bVar);

    public abstract Set<a.i.b.a.c.f.f> c(a.i.b.a.c.i.e.d dVar, a.f.a.b<? super a.i.b.a.c.f.f, Boolean> bVar);

    public abstract ak dYR();

    public abstract b ebt();

    public abstract l ebu();

    public k(a.i.b.a.c.d.a.c.h hVar) {
        a.f.b.j.p(hVar, "c");
        this.Bnn = hVar;
    }

    /* Access modifiers changed, original: protected */
    public boolean a(a.i.b.a.c.d.a.b.e eVar) {
        a.f.b.j.p(eVar, "receiver$0");
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final a.i.b.a.c.d.a.b.e a(q qVar) {
        ak a;
        a.i.b.a.c.d.a.b.e eVar;
        Map a2;
        Object obj;
        a.f.b.j.p(qVar, com.google.firebase.analytics.FirebaseAnalytics.b.METHOD);
        a.i.b.a.c.d.a.b.e a3 = a.i.b.a.c.d.a.b.e.a(ebu(), a.i.b.a.c.d.a.c.f.a(this.Bnn, qVar), qVar.dZg(), (am) this.Bnn.Bnv.BmZ.a(qVar));
        a.f.b.j.o(a3, "JavaMethodDescriptor.cre….source(method)\n        )");
        a.i.b.a.c.d.a.c.h a4 = a.i.b.a.c.d.a.c.a.a(this.Bnn, (l) a3, (x) qVar, 0);
        Iterable<a.i.b.a.c.d.a.e.w> dYS = qVar.dYS();
        Collection arrayList = new ArrayList(m.d(dYS));
        for (a.i.b.a.c.d.a.e.w a5 : dYS) {
            ar a6 = a4.Bnw.a(a5);
            if (a6 == null) {
                a.f.b.j.dWJ();
            }
            arrayList.add(a6);
        }
        List list = (List) arrayList;
        b a7 = a(a4, (a.i.b.a.c.b.t) a3, qVar.dYV());
        a a8 = a(qVar, list, a(qVar, a4), a7.BoH);
        w wVar = a8.Bms;
        if (wVar != null) {
            a.i.b.a.c.b.a aVar = a3;
            a.i.b.a.c.b.a.g.a aVar2 = a.i.b.a.c.b.a.g.BfJ;
            a = a.i.b.a.c.i.c.a(aVar, wVar, a.i.b.a.c.b.a.g.a.eai());
            eVar = a3;
        } else {
            a = null;
            eVar = a3;
        }
        ak dYR = dYR();
        List list2 = a8.BeK;
        List list3 = a8.Bmt;
        w wVar2 = a8.Bji;
        a.i.b.a.c.b.w.a aVar3 = a.i.b.a.c.b.w.BeG;
        a.i.b.a.c.b.w an = a.i.b.a.c.b.w.a.an(qVar.ebX(), !qVar.ebY());
        az dYf = qVar.dYf();
        if (a8.Bms != null) {
            a2 = af.a(u.I(a.i.b.a.c.d.a.b.e.BmA, a.a.t.fJ(a7.BoH)));
        } else {
            a2 = ag.emptyMap();
        }
        eVar.a(a, dYR, list2, list3, wVar2, an, dYf, a2);
        a3.ao(a8.Bia, a7.BoI);
        if (a8.BoG.isEmpty()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            a4.Bnv.BmU.ebl();
        }
        return a3;
    }

    protected static w a(q qVar, a.i.b.a.c.d.a.c.h hVar) {
        a.f.b.j.p(qVar, com.google.firebase.analytics.FirebaseAnalytics.b.METHOD);
        a.f.b.j.p(hVar, "c");
        return hVar.Bnu.a(qVar.ebV(), a.i.b.a.c.d.a.c.b.d.a(a.i.b.a.c.d.a.a.l.COMMON, qVar.ebU().ebH(), null, 2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0100 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0166  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static b a(a.i.b.a.c.d.a.c.h hVar, a.i.b.a.c.b.t tVar, List<? extends y> list) {
        a.f.b.j.p(hVar, "c");
        a.f.b.j.p(tVar, "function");
        a.f.b.j.p(list, "jValueParameters");
        Set linkedHashSet = new LinkedHashSet();
        Iterable<a.a.y> p = a.a.t.p(list);
        Collection arrayList = new ArrayList(m.d(p));
        boolean z = false;
        for (a.a.y yVar : p) {
            Object obj;
            o I;
            w wVar;
            w wVar2;
            Object avX;
            boolean z2;
            int i = yVar.index;
            y yVar2 = (y) yVar.value;
            a.i.b.a.c.b.a.g a = a.i.b.a.c.d.a.c.f.a(hVar, yVar2);
            a.i.b.a.c.d.a.c.b.a a2 = a.i.b.a.c.d.a.c.b.d.a(a.i.b.a.c.d.a.a.l.COMMON, false, null, 3);
            a.i.b.a.c.f.b bVar = p.Blx;
            a.f.b.j.o(bVar, "JvmAnnotationNames.PARAMETER_NAME_FQ_NAME");
            a.i.b.a.c.b.a.c i2 = a.i(bVar);
            if (i2 != null) {
                a.i.b.a.c.i.b.f m = a.i.b.a.c.i.c.a.m(i2);
                if (m != null) {
                    if (!(m instanceof s)) {
                        m = null;
                    }
                    s sVar = (s) m;
                    if (sVar != null) {
                        obj = (String) sVar.getValue();
                        if (yVar2.ecc()) {
                            I = u.I(hVar.Bnu.a(yVar2.ebT(), a2), null);
                        } else {
                            a.i.b.a.c.d.a.e.v ebT = yVar2.ebT();
                            if (!(ebT instanceof a.i.b.a.c.d.a.e.f)) {
                                ebT = null;
                            }
                            a.i.b.a.c.d.a.e.f fVar = (a.i.b.a.c.d.a.e.f) ebT;
                            if (fVar == null) {
                                throw new AssertionError("Vararg parameter should be an array: ".concat(String.valueOf(yVar2)));
                            }
                            w a3 = hVar.Bnu.a(fVar, a2, true);
                            I = u.I(a3, hVar.Bnv.BcH.dZD().l(a3));
                        }
                        wVar = (w) I.first;
                        wVar2 = (w) I.second;
                        if (!a.f.b.j.j(tVar.dZg().name, "equals") && list.size() == 1 && a.f.b.j.j(hVar.Bnv.BcH.dZD().dXN(), wVar)) {
                            avX = a.i.b.a.c.f.f.avX(FacebookRequestErrorClassification.KEY_OTHER);
                        } else {
                            if (obj != null) {
                                if ((((CharSequence) obj).length() > 0 ? 1 : null) != null && linkedHashSet.add(obj)) {
                                    avX = a.i.b.a.c.f.f.avX(obj);
                                }
                            }
                            avX = yVar2.dZg();
                            if (avX == null) {
                                z = true;
                            }
                            if (avX != null) {
                                avX = a.i.b.a.c.f.f.avX("p".concat(String.valueOf(i)));
                            }
                        }
                        z2 = z;
                        a.f.b.j.o(avX, "if (function.name.asStri…(\"p$index\")\n            }");
                        arrayList.add(new ai(tVar, null, i, a, avX, wVar, false, false, false, wVar2, hVar.Bnv.BmZ.a(yVar2)));
                        z = z2;
                    }
                }
            }
            obj = null;
            if (yVar2.ecc()) {
            }
            wVar = (w) I.first;
            wVar2 = (w) I.second;
            if (!a.f.b.j.j(tVar.dZg().name, "equals")) {
            }
            if (obj != null) {
            }
            avX = yVar2.dZg();
            if (avX == null) {
            }
            if (avX != null) {
            }
            z2 = z;
            a.f.b.j.o(avX, "if (function.name.asStri…(\"p$index\")\n            }");
            arrayList.add(new ai(tVar, null, i, a, avX, wVar, false, false, false, wVar2, hVar.Bnv.BmZ.a(yVar2)));
            z = z2;
        }
        return new b(a.a.t.m((List) arrayList), z);
    }

    public Collection<al> b(a.i.b.a.c.f.f fVar, a.i.b.a.c.c.a.a aVar) {
        a.f.b.j.p(fVar, "name");
        a.f.b.j.p(aVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        if (eau().contains(fVar)) {
            return (Collection) this.BhE.am(fVar);
        }
        return a.a.v.AUP;
    }

    private static boolean a(n nVar) {
        return nVar.ebY() && nVar.isStatic();
    }

    public Collection<ah> a(a.i.b.a.c.f.f fVar, a.i.b.a.c.c.a.a aVar) {
        a.f.b.j.p(fVar, "name");
        a.f.b.j.p(aVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        if (eav().contains(fVar)) {
            return (Collection) this.BhF.am(fVar);
        }
        return a.a.v.AUP;
    }

    public Collection<l> a(a.i.b.a.c.i.e.d dVar, a.f.a.b<? super a.i.b.a.c.f.f, Boolean> bVar) {
        a.f.b.j.p(dVar, "kindFilter");
        a.f.b.j.p(bVar, "nameFilter");
        return (Collection) this.BhG.invoke();
    }

    /* Access modifiers changed, original: protected|final */
    public final List<l> a(a.i.b.a.c.i.e.d dVar, a.f.a.b<? super a.i.b.a.c.f.f, Boolean> bVar, a.i.b.a.c.c.a.a aVar) {
        a.f.b.j.p(dVar, "kindFilter");
        a.f.b.j.p(bVar, "nameFilter");
        a.f.b.j.p(aVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        a.i.b.a.c.i.e.d.a aVar2 = a.i.b.a.c.i.e.d.BFX;
        if (dVar.UI(a.i.b.a.c.i.e.d.BFI)) {
            for (a.i.b.a.c.f.f fVar : c(dVar, bVar)) {
                if (((Boolean) bVar.am(fVar)).booleanValue()) {
                    a.i.b.a.c.n.a.b(linkedHashSet, c(fVar, aVar));
                }
            }
        }
        aVar2 = a.i.b.a.c.i.e.d.BFX;
        if (dVar.UI(a.i.b.a.c.i.e.d.BFF) && !dVar.BFz.contains(a.i.b.a.c.i.e.c.a.BFw)) {
            for (a.i.b.a.c.f.f fVar2 : b(dVar, (a.f.a.b) bVar)) {
                if (((Boolean) bVar.am(fVar2)).booleanValue()) {
                    linkedHashSet.addAll(b(fVar2, aVar));
                }
            }
        }
        aVar2 = a.i.b.a.c.i.e.d.BFX;
        if (dVar.UI(a.i.b.a.c.i.e.d.BFG) && !dVar.BFz.contains(a.i.b.a.c.i.e.c.a.BFw)) {
            for (a.i.b.a.c.f.f fVar22 : a(dVar)) {
                if (((Boolean) bVar.am(fVar22)).booleanValue()) {
                    linkedHashSet.addAll(a(fVar22, aVar));
                }
            }
        }
        return a.a.t.m(linkedHashSet);
    }

    public String toString() {
        return "Lazy scope for " + ebu();
    }

    public final Set<a.i.b.a.c.f.f> eau() {
        return (Set) a.i.b.a.c.k.h.a(this.BoD, eQB[0]);
    }

    public final Set<a.i.b.a.c.f.f> eav() {
        return (Set) a.i.b.a.c.k.h.a(this.BoE, eQB[1]);
    }
}
