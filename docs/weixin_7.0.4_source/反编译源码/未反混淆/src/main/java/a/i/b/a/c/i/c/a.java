package a.i.b.a.c.i.c;

import a.a.m;
import a.a.t;
import a.a.v;
import a.aa;
import a.f.b.i;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.ab;
import a.i.b.a.c.b.ag;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.l;
import a.i.b.a.c.i.e.h;
import a.i.b.a.c.l.w;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

public final class a {
    private static final a.i.b.a.c.f.f BEV;

    public static final class e extends a.i.b.a.c.n.b.a<a.i.b.a.c.b.b, a.i.b.a.c.b.b> {
        final /* synthetic */ a.f.a.b BFb;
        final /* synthetic */ a.f.b.u.c sao;

        e(a.f.b.u.c cVar, a.f.a.b bVar) {
            this.sao = cVar;
            this.BFb = bVar;
        }

        public final /* synthetic */ boolean dB(Object obj) {
            AppMethodBeat.i(122134);
            j.p((a.i.b.a.c.b.b) obj, "current");
            if (((a.i.b.a.c.b.b) this.sao.AVE) == null) {
                AppMethodBeat.o(122134);
                return true;
            }
            AppMethodBeat.o(122134);
            return false;
        }

        public final /* synthetic */ void dR(Object obj) {
            AppMethodBeat.i(122135);
            a.i.b.a.c.b.b bVar = (a.i.b.a.c.b.b) obj;
            j.p(bVar, "current");
            if (((a.i.b.a.c.b.b) this.sao.AVE) == null && ((Boolean) this.BFb.am(bVar)).booleanValue()) {
                this.sao.AVE = bVar;
            }
            AppMethodBeat.o(122135);
        }

        public final /* bridge */ /* synthetic */ Object dYP() {
            return (a.i.b.a.c.b.b) this.sao.AVE;
        }
    }

    static final class f extends k implements a.f.a.b<l, l> {
        public static final f BFc = new f();

        static {
            AppMethodBeat.i(122137);
            AppMethodBeat.o(122137);
        }

        f() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(122136);
            l lVar = (l) obj;
            j.p(lVar, "it");
            l dXW = lVar.dXW();
            AppMethodBeat.o(122136);
            return dXW;
        }
    }

    static final class d<N> implements a.i.b.a.c.n.b.b<N> {
        final /* synthetic */ boolean BFa = false;

        d() {
        }

        public final /* synthetic */ Iterable dA(Object obj) {
            Iterable iterable;
            AppMethodBeat.i(122133);
            a.i.b.a.c.b.b bVar = (a.i.b.a.c.b.b) obj;
            if (this.BFa) {
                bVar = bVar != null ? bVar.dYY() : null;
            }
            if (bVar != null) {
                Collection dYX = bVar.dYX();
                if (dYX != null) {
                    iterable = dYX;
                    AppMethodBeat.o(122133);
                    return iterable;
                }
            }
            iterable = v.AUP;
            AppMethodBeat.o(122133);
            return iterable;
        }
    }

    static final class c extends i implements a.f.a.b<au, Boolean> {
        public static final c BEZ = new c();

        static {
            AppMethodBeat.i(122132);
            AppMethodBeat.o(122132);
        }

        c() {
            super(1);
        }

        public final a.i.d dWF() {
            AppMethodBeat.i(122131);
            a.i.b aN = a.f.b.v.aN(au.class);
            AppMethodBeat.o(122131);
            return aN;
        }

        public final String due() {
            return "declaresDefaultValue()Z";
        }

        public final String getName() {
            return "declaresDefaultValue";
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(122130);
            au auVar = (au) obj;
            j.p(auVar, "p1");
            Boolean valueOf = Boolean.valueOf(auVar.dZU());
            AppMethodBeat.o(122130);
            return valueOf;
        }
    }

    static final class b<N> implements a.i.b.a.c.n.b.b<N> {
        public static final b BEY = new b();

        static {
            AppMethodBeat.i(122129);
            AppMethodBeat.o(122129);
        }

        b() {
        }

        public final /* synthetic */ Iterable dA(Object obj) {
            AppMethodBeat.i(122128);
            au auVar = (au) obj;
            j.o(auVar, "current");
            Iterable<au> dYX = auVar.dYX();
            Collection arrayList = new ArrayList(m.d(dYX));
            for (au dZW : dYX) {
                arrayList.add(dZW.dZW());
            }
            Iterable iterable = (List) arrayList;
            AppMethodBeat.o(122128);
            return iterable;
        }
    }

    static final class a extends k implements a.f.a.m<h, Boolean, y> {
        final /* synthetic */ a.i.b.a.c.b.e BEW;
        final /* synthetic */ LinkedHashSet BEX;

        a(a.i.b.a.c.b.e eVar, LinkedHashSet linkedHashSet) {
            this.BEW = eVar;
            this.BEX = linkedHashSet;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(122126);
            a((h) obj, ((Boolean) obj2).booleanValue());
            y yVar = y.AUy;
            AppMethodBeat.o(122126);
            return yVar;
        }

        public final void a(h hVar, boolean z) {
            AppMethodBeat.i(122127);
            j.p(hVar, "scope");
            for (l lVar : a.i.b.a.c.i.e.j.a.a(hVar, a.i.b.a.c.i.e.d.BFQ, null, 2)) {
                if (lVar instanceof a.i.b.a.c.b.e) {
                    if (a.i.b.a.c.i.d.b((a.i.b.a.c.b.e) lVar, this.BEW)) {
                        this.BEX.add(lVar);
                    }
                    if (z) {
                        a aVar = this;
                        h dZk = ((a.i.b.a.c.b.e) lVar).dZk();
                        j.o(dZk, "descriptor.unsubstitutedInnerClassesScope");
                        aVar.a(dZk, z);
                    }
                }
            }
            AppMethodBeat.o(122127);
        }
    }

    static {
        AppMethodBeat.i(122153);
        a.i.b.a.c.f.f avX = a.i.b.a.c.f.f.avX("value");
        j.o(avX, "Name.identifier(\"value\")");
        BEV = avX;
        AppMethodBeat.o(122153);
    }

    public static final a.i.b.a.c.f.c q(l lVar) {
        AppMethodBeat.i(122138);
        j.p(lVar, "receiver$0");
        a.i.b.a.c.f.c n = a.i.b.a.c.i.d.n(lVar);
        j.o(n, "DescriptorUtils.getFqName(this)");
        AppMethodBeat.o(122138);
        return n;
    }

    public static final a.i.b.a.c.f.b o(l lVar) {
        AppMethodBeat.i(122139);
        j.p(lVar, "receiver$0");
        a.i.b.a.c.f.b o = a.i.b.a.c.i.d.o(lVar);
        j.o(o, "DescriptorUtils.getFqNameSafe(this)");
        AppMethodBeat.o(122139);
        return o;
    }

    public static final a.i.b.a.c.b.y F(l lVar) {
        AppMethodBeat.i(122140);
        j.p(lVar, "receiver$0");
        a.i.b.a.c.b.y s = a.i.b.a.c.i.d.s(lVar);
        j.o(s, "DescriptorUtils.getContainingModule(this)");
        AppMethodBeat.o(122140);
        return s;
    }

    public static final a.i.b.a.c.b.e b(a.i.b.a.c.b.y yVar, a.i.b.a.c.f.b bVar, a.i.b.a.c.c.a.a aVar) {
        AppMethodBeat.i(122141);
        j.p(yVar, "receiver$0");
        j.p(bVar, "topLevelClassFqName");
        j.p(aVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        Object obj = !bVar.ehF() ? 1 : null;
        if (aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError("Assertion failed");
            AppMethodBeat.o(122141);
            throw assertionError;
        }
        a.i.b.a.c.f.b ehG = bVar.ehG();
        j.o(ehG, "topLevelClassFqName.parent()");
        h dXR = yVar.g(ehG).dXR();
        a.i.b.a.c.f.f ehK = bVar.ByQ.ehK();
        j.o(ehK, "topLevelClassFqName.shortName()");
        a.i.b.a.c.b.h c = dXR.c(ehK, aVar);
        if (!(c instanceof a.i.b.a.c.b.e)) {
            c = null;
        }
        a.i.b.a.c.b.e eVar = (a.i.b.a.c.b.e) c;
        AppMethodBeat.o(122141);
        return eVar;
    }

    public static final a.i.b.a.c.f.a c(a.i.b.a.c.b.h hVar) {
        AppMethodBeat.i(122142);
        if (hVar != null) {
            l dXW = hVar.dXW();
            if (dXW != null) {
                if (dXW instanceof ab) {
                    a.i.b.a.c.f.a aVar = new a.i.b.a.c.f.a(((ab) dXW).dZF(), hVar.dZg());
                    AppMethodBeat.o(122142);
                    return aVar;
                }
                if (dXW instanceof a.i.b.a.c.b.i) {
                    a.i.b.a.c.f.a c = c((a.i.b.a.c.b.h) dXW);
                    if (c != null) {
                        c = c.p(hVar.dZg());
                        AppMethodBeat.o(122142);
                        return c;
                    }
                }
                AppMethodBeat.o(122142);
                return null;
            }
        }
        AppMethodBeat.o(122142);
        return null;
    }

    public static final a.i.b.a.c.b.e z(a.i.b.a.c.b.e eVar) {
        AppMethodBeat.i(122143);
        j.p(eVar, "receiver$0");
        for (w wVar : eVar.dZf().ejw().eap()) {
            if (!g.A(wVar)) {
                a.i.b.a.c.b.h dYs = wVar.ejw().dYs();
                if (a.i.b.a.c.i.d.B(dYs)) {
                    if (dYs == null) {
                        a.v vVar = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        AppMethodBeat.o(122143);
                        throw vVar;
                    }
                    a.i.b.a.c.b.e eVar2 = (a.i.b.a.c.b.e) dYs;
                    AppMethodBeat.o(122143);
                    return eVar2;
                }
            }
        }
        AppMethodBeat.o(122143);
        return null;
    }

    public static final g G(l lVar) {
        AppMethodBeat.i(122144);
        j.p(lVar, "receiver$0");
        g dZD = F(lVar).dZD();
        AppMethodBeat.o(122144);
        return dZD;
    }

    public static final boolean b(au auVar) {
        AppMethodBeat.i(122145);
        j.p(auVar, "receiver$0");
        Boolean a = a.i.b.a.c.n.b.a((Collection) a.a.k.listOf(auVar), (a.i.b.a.c.n.b.b) b.BEY, (a.f.a.b) c.BEZ);
        j.o(a, "DFS.ifAny(\n        listO…eclaresDefaultValue\n    )");
        boolean booleanValue = a.booleanValue();
        AppMethodBeat.o(122145);
        return booleanValue;
    }

    public static final a.j.h<l> H(l lVar) {
        AppMethodBeat.i(122146);
        j.p(lVar, "receiver$0");
        j.p(lVar, "receiver$0");
        a.j.h a = a.j.l.a(lVar, f.BFc);
        j.p(a, "receiver$0");
        if (a instanceof a.j.c) {
            a = ((a.j.c) a).ekJ();
            AppMethodBeat.o(122146);
            return a;
        }
        a.j.h<l> bVar = new a.j.b(a, 1);
        AppMethodBeat.o(122146);
        return bVar;
    }

    public static final a.i.b.a.c.b.b x(a.i.b.a.c.b.b bVar) {
        AppMethodBeat.i(122147);
        j.p(bVar, "receiver$0");
        if (bVar instanceof ag) {
            ah dZH = ((ag) bVar).dZH();
            j.o(dZH, "correspondingProperty");
            a.i.b.a.c.b.b bVar2 = dZH;
            AppMethodBeat.o(122147);
            return bVar2;
        }
        AppMethodBeat.o(122147);
        return bVar;
    }

    public static final a.i.b.a.c.f.b I(l lVar) {
        AppMethodBeat.i(122148);
        j.p(lVar, "receiver$0");
        a.i.b.a.c.f.c q = q(lVar);
        if (!q.ehH()) {
            q = null;
        }
        if (q != null) {
            a.i.b.a.c.f.b ehI = q.ehI();
            AppMethodBeat.o(122148);
            return ehI;
        }
        AppMethodBeat.o(122148);
        return null;
    }

    public static /* synthetic */ a.i.b.a.c.b.b b(a.i.b.a.c.b.b bVar, a.f.a.b bVar2) {
        AppMethodBeat.i(122149);
        j.p(bVar, "receiver$0");
        j.p(bVar2, "predicate");
        a.f.b.u.c cVar = new a.f.b.u.c();
        cVar.AVE = null;
        a.i.b.a.c.b.b bVar3 = (a.i.b.a.c.b.b) a.i.b.a.c.n.b.a((Collection) a.a.k.listOf(bVar), (a.i.b.a.c.n.b.b) new d(), (a.i.b.a.c.n.b.c) new e(cVar, bVar2));
        AppMethodBeat.o(122149);
        return bVar3;
    }

    public static final Collection<a.i.b.a.c.b.e> A(a.i.b.a.c.b.e eVar) {
        AppMethodBeat.i(122150);
        j.p(eVar, "sealedClass");
        if (eVar.dYd() != a.i.b.a.c.b.w.SEALED) {
            Collection collection = v.AUP;
            AppMethodBeat.o(122150);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        a aVar = new a(eVar, linkedHashSet);
        l dXW = eVar.dXW();
        j.o(dXW, "sealedClass.containingDeclaration");
        if (dXW instanceof ab) {
            aVar.a(((ab) dXW).dXR(), false);
        }
        h dZk = eVar.dZk();
        j.o(dZk, "sealedClass.unsubstitutedInnerClassesScope");
        aVar.a(dZk, true);
        Collection<a.i.b.a.c.b.e> collection2 = linkedHashSet;
        AppMethodBeat.o(122150);
        return collection2;
    }

    public static final a.i.b.a.c.b.e l(a.i.b.a.c.b.a.c cVar) {
        AppMethodBeat.i(122151);
        j.p(cVar, "receiver$0");
        a.i.b.a.c.b.h dYs = cVar.dZS().ejw().dYs();
        if (!(dYs instanceof a.i.b.a.c.b.e)) {
            dYs = null;
        }
        a.i.b.a.c.b.e eVar = (a.i.b.a.c.b.e) dYs;
        AppMethodBeat.o(122151);
        return eVar;
    }

    public static final a.i.b.a.c.i.b.f<?> m(a.i.b.a.c.b.a.c cVar) {
        AppMethodBeat.i(122152);
        j.p(cVar, "receiver$0");
        a.i.b.a.c.i.b.f fVar = (a.i.b.a.c.i.b.f) t.f(cVar.eah().values());
        AppMethodBeat.o(122152);
        return fVar;
    }
}
