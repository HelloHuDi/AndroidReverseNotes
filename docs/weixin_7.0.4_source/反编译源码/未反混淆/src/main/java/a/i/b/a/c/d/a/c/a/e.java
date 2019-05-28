package a.i.b.a.c.d.a.c.a;

import a.a.ag;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.au;
import a.i.b.a.c.d.a.a.l;
import a.i.b.a.c.d.a.c.b.d;
import a.i.b.a.c.d.a.c.h;
import a.i.b.a.c.d.a.e.m;
import a.i.b.a.c.d.a.e.o;
import a.i.b.a.c.d.a.p;
import a.i.b.a.c.i.b.i;
import a.i.b.a.c.i.b.q;
import a.i.b.a.c.k.f;
import a.i.b.a.c.k.g;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.ar;
import a.i.b.a.c.l.av;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.w;
import a.i.b.a.c.l.x;
import a.i.b.a.c.l.y;
import a.i.k;
import a.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class e implements a.i.b.a.c.b.a.c {
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(e.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), v.a(new t(v.aN(e.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), v.a(new t(v.aN(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    private final f BlR = this.Bnn.Bnv.Baf.i(new c(this));
    private final f Bmk = this.Bnn.Bnv.Baf.i(new a(this));
    private final g BnR = this.Bnn.Bnv.Baf.j(new b(this));
    private final a.i.b.a.c.d.a.d.a BnS = this.Bnn.Bnv.BmZ.a(this.BnT);
    private final a.i.b.a.c.d.a.e.a BnT;
    private final h Bnn;

    static final class a extends a.f.b.k implements a.f.a.a<Map<a.i.b.a.c.f.f, ? extends a.i.b.a.c.i.b.f<?>>> {
        final /* synthetic */ e BnU;

        a(e eVar) {
            this.BnU = eVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119874);
            Collection arrayList = new ArrayList();
            for (a.i.b.a.c.d.a.e.b bVar : this.BnU.BnT.ebz()) {
                Object I;
                Object dZg = bVar.dZg();
                if (dZg == null) {
                    dZg = p.Bln;
                }
                a.i.b.a.c.i.b.f a = e.a(this.BnU, bVar);
                if (a != null) {
                    I = u.I(dZg, a);
                } else {
                    I = null;
                }
                if (I != null) {
                    arrayList.add(I);
                }
            }
            Map v = ag.v((List) arrayList);
            AppMethodBeat.o(119874);
            return v;
        }
    }

    static final class b extends a.f.b.k implements a.f.a.a<a.i.b.a.c.f.b> {
        final /* synthetic */ e BnU;

        b(e eVar) {
            this.BnU = eVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119875);
            a.i.b.a.c.f.a dWY = this.BnU.BnT.dWY();
            if (dWY != null) {
                a.i.b.a.c.f.b ehE = dWY.ehE();
                AppMethodBeat.o(119875);
                return ehE;
            }
            AppMethodBeat.o(119875);
            return null;
        }
    }

    static final class c extends a.f.b.k implements a.f.a.a<ad> {
        final /* synthetic */ e BnU;

        c(e eVar) {
            this.BnU = eVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119876);
            a.i.b.a.c.f.b dZF = this.BnU.dZF();
            if (dZF == null) {
                ad awn = a.i.b.a.c.l.p.awn("No fqName: " + this.BnU.BnT);
                AppMethodBeat.o(119876);
                return awn;
            }
            j.o(dZF, "fqName ?: return@createL…fqName: $javaAnnotation\")");
            a.i.b.a.c.a.b.c cVar = a.i.b.a.c.a.b.c.Bdq;
            a.i.b.a.c.b.e a = a.i.b.a.c.a.b.c.a(dZF, this.BnU.Bnn.Bnv.BcH.dZD());
            if (a == null) {
                a = this.BnU.Bnn.Bnv.Bna.b(this.BnU.BnT.ebA());
            }
            if (a == null) {
                a = e.a(this.BnU, dZF);
            }
            Object dZf = a.dZf();
            AppMethodBeat.o(119876);
            return dZf;
        }
    }

    static {
        AppMethodBeat.i(119877);
        AppMethodBeat.o(119877);
    }

    private ad ebq() {
        AppMethodBeat.i(119879);
        ad adVar = (ad) a.i.b.a.c.k.h.a(this.BlR, eQB[1]);
        AppMethodBeat.o(119879);
        return adVar;
    }

    public final Map<a.i.b.a.c.f.f, a.i.b.a.c.i.b.f<?>> eah() {
        AppMethodBeat.i(119881);
        Map map = (Map) a.i.b.a.c.k.h.a(this.Bmk, eQB[2]);
        AppMethodBeat.o(119881);
        return map;
    }

    public e(h hVar, a.i.b.a.c.d.a.e.a aVar) {
        j.p(hVar, "c");
        j.p(aVar, "javaAnnotation");
        AppMethodBeat.i(119884);
        this.Bnn = hVar;
        this.BnT = aVar;
        AppMethodBeat.o(119884);
    }

    public final /* synthetic */ w dZS() {
        AppMethodBeat.i(119880);
        w ebq = ebq();
        AppMethodBeat.o(119880);
        return ebq;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final a.i.b.a.c.i.b.f<?> b(a.i.b.a.c.d.a.e.b bVar) {
        AppMethodBeat.i(119882);
        a.i.b.a.c.f.f ebR;
        a.i.b.a.c.i.b.f<?> iVar;
        if (bVar instanceof o) {
            a.i.b.a.c.i.b.f dQ = a.i.b.a.c.i.b.g.BEO.dQ(((o) bVar).getValue());
            AppMethodBeat.o(119882);
            return dQ;
        } else if (bVar instanceof m) {
            a.i.b.a.c.f.a ebQ = ((m) bVar).ebQ();
            ebR = ((m) bVar).ebR();
            if (ebQ == null || ebR == null) {
                AppMethodBeat.o(119882);
                return null;
            }
            iVar = new i(ebQ, ebR);
            AppMethodBeat.o(119882);
            return iVar;
        } else {
            List ebD;
            a.i.b.a.c.b.e l;
            if (bVar instanceof a.i.b.a.c.d.a.e.e) {
                a.i.b.a.c.f.f dZg = bVar.dZg();
                if (dZg == null) {
                    dZg = p.Bln;
                    j.o(dZg, "DEFAULT_ANNOTATION_MEMBER_NAME");
                }
                ebR = dZg;
                ebD = ((a.i.b.a.c.d.a.e.e) bVar).ebD();
                ad ebq = ebq();
                j.o(ebq, "type");
                if (!y.an(ebq)) {
                    w wVar;
                    Iterable<a.i.b.a.c.d.a.e.b> iterable;
                    Collection arrayList;
                    a.i.b.a.c.i.b.g gVar;
                    l = a.i.b.a.c.i.c.a.l(this);
                    if (l == null) {
                        j.dWJ();
                    }
                    au b = a.i.b.a.c.d.a.a.a.b(ebR, l);
                    if (b != null) {
                        w dZS = b.dZS();
                        if (dZS != null) {
                            wVar = dZS;
                            j.o(wVar, "DescriptorResolverUtils.…e\")\n                    )");
                            iterable = ebD;
                            arrayList = new ArrayList(a.a.m.d(iterable));
                            for (a.i.b.a.c.d.a.e.b b2 : iterable) {
                                Object b3 = b(b2);
                                if (b3 == null) {
                                    b3 = new q();
                                }
                                arrayList.add(b3);
                            }
                            ebD = (List) arrayList;
                            gVar = a.i.b.a.c.i.b.g.BEO;
                            iVar = a.i.b.a.c.i.b.g.a(ebD, wVar);
                            AppMethodBeat.o(119882);
                            return iVar;
                        }
                    }
                    wVar = this.Bnn.Bnv.BcH.dZD().a(ba.INVARIANT, (w) a.i.b.a.c.l.p.awn("Unknown array element type"));
                    j.o(wVar, "DescriptorResolverUtils.…e\")\n                    )");
                    iterable = ebD;
                    arrayList = new ArrayList(a.a.m.d(iterable));
                    while (r3.hasNext()) {
                    }
                    ebD = (List) arrayList;
                    gVar = a.i.b.a.c.i.b.g.BEO;
                    iVar = a.i.b.a.c.i.b.g.a(ebD, wVar);
                    AppMethodBeat.o(119882);
                    return iVar;
                }
            } else if (bVar instanceof a.i.b.a.c.d.a.e.c) {
                iVar = new a.i.b.a.c.i.b.a(new e(this.Bnn, ((a.i.b.a.c.d.a.e.c) bVar).ebB()));
                AppMethodBeat.o(119882);
                return iVar;
            } else if (bVar instanceof a.i.b.a.c.d.a.e.h) {
                w aA = av.aA(this.Bnn.Bnu.a(((a.i.b.a.c.d.a.e.h) bVar).ebK(), d.a(l.COMMON, false, null, 3)));
                j.o(aA, "TypeUtils.makeNotNullabl…toAttributes())\n        )");
                l = a.i.b.a.c.i.c.a.b(this.Bnn.Bnv.BcH, new a.i.b.a.c.f.b("java.lang.Class"), a.i.b.a.c.c.a.c.FOR_NON_TRACKED_SCOPE);
                if (l != null) {
                    ebD = a.a.k.listOf(new ar(aA));
                    a.i.b.a.c.b.a.g.a aVar = a.i.b.a.c.b.a.g.BfJ;
                    iVar = new a.i.b.a.c.i.b.o(x.a(a.i.b.a.c.b.a.g.a.eai(), l, ebD));
                    AppMethodBeat.o(119882);
                    return iVar;
                }
            }
            AppMethodBeat.o(119882);
            return null;
        }
    }

    public final String toString() {
        AppMethodBeat.i(119883);
        String a = a.i.b.a.c.h.c.BBL.a((a.i.b.a.c.b.a.c) this, null);
        AppMethodBeat.o(119883);
        return a;
    }

    public final a.i.b.a.c.f.b dZF() {
        AppMethodBeat.i(119878);
        g gVar = this.BnR;
        Object obj = eQB[0];
        j.p(gVar, "receiver$0");
        j.p(obj, "p");
        a.i.b.a.c.f.b bVar = (a.i.b.a.c.f.b) gVar.invoke();
        AppMethodBeat.o(119878);
        return bVar;
    }

    public final /* bridge */ /* synthetic */ am dYo() {
        return this.BnS;
    }
}
