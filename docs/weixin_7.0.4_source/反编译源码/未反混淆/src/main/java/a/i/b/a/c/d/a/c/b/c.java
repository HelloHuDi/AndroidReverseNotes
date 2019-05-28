package a.i.b.a.c.d.a.c.b;

import a.a.t;
import a.a.y;
import a.aa;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.d.a.a.l;
import a.i.b.a.c.d.a.c.e;
import a.i.b.a.c.d.a.c.h;
import a.i.b.a.c.d.a.c.m;
import a.i.b.a.c.d.a.e.f;
import a.i.b.a.c.d.a.e.i;
import a.i.b.a.c.d.a.e.u;
import a.i.b.a.c.d.a.e.v;
import a.i.b.a.c.d.a.e.z;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.p;
import a.i.b.a.c.l.w;
import a.i.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class c {
    private final h Bnn;
    private final m Bnw;

    static final class b extends k implements a.f.a.a<w> {
        final /* synthetic */ ar Bpf;
        final /* synthetic */ c Bpg;
        final /* synthetic */ a Bph;
        final /* synthetic */ an Bpi;
        final /* synthetic */ boolean Bpj;

        /* renamed from: a.i.b.a.c.d.a.c.b.c$b$1 */
        static final class AnonymousClass1 extends k implements a.f.a.a<w> {
            final /* synthetic */ b Bpk;

            AnonymousClass1(b bVar) {
                this.Bpk = bVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(120034);
                a.i.b.a.c.b.h dYs = this.Bpk.Bpi.dYs();
                if (dYs == null) {
                    j.dWJ();
                }
                j.o(dYs, "constructor.declarationDescriptor!!");
                ad dZf = dYs.dZf();
                j.o(dZf, "constructor.declarationDescriptor!!.defaultType");
                w aN = a.i.b.a.c.l.c.a.aN(dZf);
                AppMethodBeat.o(120034);
                return aN;
            }
        }

        b(ar arVar, c cVar, a aVar, an anVar, boolean z) {
            this.Bpf = arVar;
            this.Bpg = cVar;
            this.Bph = aVar;
            this.Bpi = anVar;
            this.Bpj = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(120035);
            ar arVar = this.Bpf;
            j.o(arVar, "parameter");
            w a = d.a(arVar, this.Bph.BoZ, new AnonymousClass1(this));
            AppMethodBeat.o(120035);
            return a;
        }
    }

    static final class c extends k implements a.f.a.a<ad> {
        final /* synthetic */ a.i.b.a.c.d.a.e.j Bpl;

        c(a.i.b.a.c.d.a.e.j jVar) {
            this.Bpl = jVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(120036);
            ad ebw = ebw();
            AppMethodBeat.o(120036);
            return ebw;
        }

        public final ad ebw() {
            AppMethodBeat.i(120037);
            ad awn = p.awn("Unresolved java class " + this.Bpl.ebP());
            j.o(awn, "ErrorUtils.createErrorTy…vaType.presentableText}\")");
            AppMethodBeat.o(120037);
            return awn;
        }
    }

    static final class a extends k implements a.f.a.b<v, Boolean> {
        public static final a Bpe = new a();

        static {
            AppMethodBeat.i(120033);
            AppMethodBeat.o(120033);
        }

        a() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(120031);
            Boolean valueOf = Boolean.valueOf(a((v) obj));
            AppMethodBeat.o(120031);
            return valueOf;
        }

        public static boolean a(v vVar) {
            AppMethodBeat.i(120032);
            z zVar = (z) (!(vVar instanceof z) ? null : vVar);
            if (zVar == null) {
                AppMethodBeat.o(120032);
                return false;
            } else if (zVar.ecd() == null || zVar.ece()) {
                AppMethodBeat.o(120032);
                return false;
            } else {
                AppMethodBeat.o(120032);
                return true;
            }
        }
    }

    public c(h hVar, m mVar) {
        j.p(hVar, "c");
        j.p(mVar, "typeParameterResolver");
        AppMethodBeat.i(120049);
        this.Bnn = hVar;
        this.Bnw = mVar;
        AppMethodBeat.o(120049);
    }

    public final w a(v vVar, a aVar) {
        AppMethodBeat.i(120038);
        j.p(vVar, "javaType");
        j.p(aVar, "attr");
        w wVar;
        if (vVar instanceof u) {
            Object a;
            a.i.b.a.c.a.h eca = ((u) vVar).eca();
            if (eca != null) {
                a = this.Bnn.Bnv.BcH.dZD().a(eca);
            } else {
                a = this.Bnn.Bnv.BcH.dZD().dXO();
            }
            j.o(a, "if (primitiveType != nul….module.builtIns.unitType");
            wVar = (w) a;
            AppMethodBeat.o(120038);
            return wVar;
        } else if (vVar instanceof a.i.b.a.c.d.a.e.j) {
            wVar = a((a.i.b.a.c.d.a.e.j) vVar, aVar);
            AppMethodBeat.o(120038);
            return wVar;
        } else if (vVar instanceof f) {
            wVar = a((f) vVar, aVar, false);
            AppMethodBeat.o(120038);
            return wVar;
        } else if (vVar instanceof z) {
            v ecd = ((z) vVar).ecd();
            if (ecd != null) {
                wVar = a(ecd, aVar);
                if (wVar != null) {
                    AppMethodBeat.o(120038);
                    return wVar;
                }
            }
            ad dXN = this.Bnn.Bnv.BcH.dZD().dXN();
            j.o(dXN, "c.module.builtIns.defaultBound");
            wVar = dXN;
            AppMethodBeat.o(120038);
            return wVar;
        } else {
            Throwable unsupportedOperationException = new UnsupportedOperationException("Unsupported type: ".concat(String.valueOf(vVar)));
            AppMethodBeat.o(120038);
            throw unsupportedOperationException;
        }
    }

    public final w a(f fVar, a aVar, boolean z) {
        ar arVar;
        AppMethodBeat.i(120039);
        j.p(fVar, "arrayType");
        j.p(aVar, "attr");
        v ebE = fVar.ebE();
        if (ebE instanceof u) {
            Object arVar2 = ebE;
        } else {
            arVar2 = null;
        }
        u uVar = (u) arVar2;
        a.i.b.a.c.a.h eca = uVar != null ? uVar.eca() : null;
        ad b;
        w wVar;
        if (eca != null) {
            b = this.Bnn.Bnv.BcH.dZD().b(eca);
            j.o(b, "c.module.builtIns.getPri…KotlinType(primitiveType)");
            if (aVar.BoY) {
                wVar = b;
                AppMethodBeat.o(120039);
                return wVar;
            }
            wVar = x.a(b, b.rL(true));
            AppMethodBeat.o(120039);
            return wVar;
        }
        w a = a(ebE, d.a(l.COMMON, aVar.BoY, null, 2));
        if (aVar.BoY) {
            b = this.Bnn.Bnv.BcH.dZD().a(z ? ba.OUT_VARIANCE : ba.INVARIANT, a);
            j.o(b, "c.module.builtIns.getArr…ctionKind, componentType)");
            wVar = b;
            AppMethodBeat.o(120039);
            return wVar;
        }
        b = this.Bnn.Bnv.BcH.dZD().a(ba.INVARIANT, a);
        j.o(b, "c.module.builtIns.getArr…INVARIANT, componentType)");
        wVar = x.a(b, this.Bnn.Bnv.BcH.dZD().a(ba.OUT_VARIANCE, a).rL(true));
        AppMethodBeat.o(120039);
        return wVar;
    }

    private final w a(a.i.b.a.c.d.a.e.j jVar, a aVar) {
        AppMethodBeat.i(120040);
        c cVar = new c(jVar);
        Object obj = (aVar.BoY || aVar.BoW == l.SUPERTYPE) ? null : 1;
        boolean ebN = jVar.ebN();
        w ebw;
        if (ebN || obj != null) {
            ad a = a(jVar, aVar.a(b.FLEXIBLE_LOWER_BOUND), null);
            if (a == null) {
                ebw = cVar.ebw();
                AppMethodBeat.o(120040);
                return ebw;
            }
            ad a2 = a(jVar, aVar.a(b.FLEXIBLE_UPPER_BOUND), a);
            if (a2 == null) {
                ebw = cVar.ebw();
                AppMethodBeat.o(120040);
                return ebw;
            } else if (ebN) {
                ebw = new g(a, a2);
                AppMethodBeat.o(120040);
                return ebw;
            } else {
                ebw = x.a(a, a2);
                AppMethodBeat.o(120040);
                return ebw;
            }
        }
        ad a3 = a(jVar, aVar, null);
        if (a3 != null) {
            ebw = a3;
            AppMethodBeat.o(120040);
            return ebw;
        }
        ebw = cVar.ebw();
        AppMethodBeat.o(120040);
        return ebw;
    }

    /* JADX WARNING: Missing block: B:3:0x000d, code skipped:
            if (r0 == null) goto L_0x000f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final ad a(a.i.b.a.c.d.a.e.j jVar, a aVar, ad adVar) {
        g dYn;
        AppMethodBeat.i(120041);
        if (adVar != null) {
            dYn = adVar.dYn();
        }
        dYn = new e(this.Bnn, jVar);
        an b = b(jVar, aVar);
        if (b == null) {
            AppMethodBeat.o(120041);
            return null;
        }
        Object ejw;
        boolean a = a(aVar);
        if (adVar != null) {
            ejw = adVar.ejw();
        } else {
            ejw = null;
        }
        ad rL;
        if (j.j(ejw, b) && !jVar.ebN() && a) {
            rL = adVar.rL(true);
            AppMethodBeat.o(120041);
            return rL;
        }
        rL = x.c(dYn, b, a(jVar, aVar, b), a);
        AppMethodBeat.o(120041);
        return rL;
    }

    private final an b(a.i.b.a.c.d.a.e.j jVar, a aVar) {
        AppMethodBeat.i(120042);
        i ebL = jVar.ebL();
        an a;
        Throwable assertionError;
        if (ebL == null) {
            a = a(jVar);
            AppMethodBeat.o(120042);
            return a;
        } else if (ebL instanceof a.i.b.a.c.d.a.e.g) {
            a.i.b.a.c.f.b dZF = ((a.i.b.a.c.d.a.e.g) ebL).dZF();
            if (dZF == null) {
                assertionError = new AssertionError("Class type should have a FQ name: ".concat(String.valueOf(ebL)));
                AppMethodBeat.o(120042);
                throw assertionError;
            }
            a.i.b.a.c.b.e a2 = a(jVar, aVar, dZF);
            if (a2 == null) {
                a2 = this.Bnn.Bnv.Bna.b((a.i.b.a.c.d.a.e.g) ebL);
            }
            if (a2 != null) {
                a = a2.dXY();
                if (a != null) {
                    AppMethodBeat.o(120042);
                    return a;
                }
            }
            a = a(jVar);
            AppMethodBeat.o(120042);
            return a;
        } else if (ebL instanceof a.i.b.a.c.d.a.e.w) {
            ar a3 = this.Bnw.a((a.i.b.a.c.d.a.e.w) ebL);
            if (a3 != null) {
                a = a3.dXY();
                AppMethodBeat.o(120042);
                return a;
            }
            AppMethodBeat.o(120042);
            return null;
        } else {
            assertionError = new IllegalStateException("Unknown classifier kind: ".concat(String.valueOf(ebL)));
            AppMethodBeat.o(120042);
            throw assertionError;
        }
    }

    private final an a(a.i.b.a.c.d.a.e.j jVar) {
        AppMethodBeat.i(120043);
        a.i.b.a.c.f.a n = a.i.b.a.c.f.a.n(new a.i.b.a.c.f.b(jVar.ebO()));
        j.o(n, "ClassId.topLevel(FqName(…classifierQualifiedName))");
        an dXY = this.Bnn.Bnv.BmT.ecp().Bcm.a(n, a.a.k.listOf(Integer.valueOf(0))).dXY();
        j.o(dXY, "c.components.deserialize…istOf(0)).typeConstructor");
        AppMethodBeat.o(120043);
        return dXY;
    }

    private static boolean a(a.i.b.a.c.d.a.e.j jVar, a.i.b.a.c.b.e eVar) {
        AppMethodBeat.i(120045);
        a aVar = a.Bpe;
        if (a.a((v) t.fM(jVar.ebM()))) {
            a.i.b.a.c.a.b.c cVar = a.i.b.a.c.a.b.c.Bdq;
            an dXY = a.i.b.a.c.a.b.c.k(eVar).dXY();
            j.o(dXY, "JavaToKotlinClassMap.con…         .typeConstructor");
            List parameters = dXY.getParameters();
            j.o(parameters, "JavaToKotlinClassMap.con…ypeConstructor.parameters");
            ar arVar = (ar) t.fM(parameters);
            if (arVar != null) {
                ba dZh = arVar.dZh();
                if (dZh != null) {
                    j.o(dZh, "JavaToKotlinClassMap.con….variance ?: return false");
                    if (dZh != ba.OUT_VARIANCE) {
                        AppMethodBeat.o(120045);
                        return true;
                    }
                    AppMethodBeat.o(120045);
                    return false;
                }
            }
            AppMethodBeat.o(120045);
            return false;
        }
        AppMethodBeat.o(120045);
        return false;
    }

    private final List<ap> a(a.i.b.a.c.d.a.e.j jVar, a aVar, an anVar) {
        AppMethodBeat.i(120046);
        boolean ebN = jVar.ebN();
        boolean z = ebN || (jVar.ebM().isEmpty() && !anVar.getParameters().isEmpty());
        List parameters = anVar.getParameters();
        j.o(parameters, "constructor.parameters");
        Iterable<ar> iterable;
        Collection arrayList;
        List<ap> m;
        if (z) {
            iterable = parameters;
            Collection arrayList2 = new ArrayList(a.a.m.d(iterable));
            for (ar arVar : iterable) {
                a aVar2;
                a.i.b.a.c.l.z zVar = new a.i.b.a.c.l.z(this.Bnn.Bnv.Baf, new b(arVar, this, aVar, anVar, ebN));
                e eVar = e.Bpq;
                j.o(arVar, "parameter");
                if (ebN) {
                    aVar2 = aVar;
                } else {
                    aVar2 = aVar.a(b.INFLEXIBLE);
                }
                arrayList2.add(e.a(arVar, aVar2, (w) zVar));
            }
            parameters = t.m((List) arrayList2);
            AppMethodBeat.o(120046);
            return parameters;
        } else if (parameters.size() != jVar.ebM().size()) {
            iterable = parameters;
            arrayList = new ArrayList(a.a.m.d(iterable));
            for (ar arVar2 : iterable) {
                j.o(arVar2, "p");
                arrayList.add(new a.i.b.a.c.l.ar(p.awn(arVar2.dZg().name)));
            }
            m = t.m((List) arrayList);
            AppMethodBeat.o(120046);
            return m;
        } else {
            Iterable<y> p = t.p(jVar.ebM());
            arrayList = new ArrayList(a.a.m.d(p));
            for (y yVar : p) {
                int i = yVar.index;
                v vVar = (v) yVar.value;
                boolean z2 = i < parameters.size();
                if (!aa.AUz || z2) {
                    ar arVar3 = (ar) parameters.get(i);
                    a a = d.a(l.COMMON, false, null, 3);
                    j.o(arVar3, "parameter");
                    arrayList.add(a(vVar, a, arVar3));
                } else {
                    Throwable assertionError = new AssertionError("Argument index should be less then type parameters count, but " + i + " > " + parameters.size());
                    AppMethodBeat.o(120046);
                    throw assertionError;
                }
            }
            m = t.m((List) arrayList);
            AppMethodBeat.o(120046);
            return m;
        }
    }

    private final ap a(v vVar, a aVar, ar arVar) {
        AppMethodBeat.i(120047);
        ap a;
        if (vVar instanceof z) {
            v ecd = ((z) vVar).ecd();
            ba baVar = ((z) vVar).ece() ? ba.OUT_VARIANCE : ba.IN_VARIANCE;
            if (ecd == null || a(baVar, arVar)) {
                a = d.a(arVar, aVar);
                AppMethodBeat.o(120047);
                return a;
            }
            a = a.i.b.a.c.l.c.a.a(a(ecd, d.a(l.COMMON, false, null, 3)), baVar, arVar);
            AppMethodBeat.o(120047);
            return a;
        }
        a = new a.i.b.a.c.l.ar(ba.INVARIANT, a(vVar, aVar));
        AppMethodBeat.o(120047);
        return a;
    }

    private static boolean a(ba baVar, ar arVar) {
        AppMethodBeat.i(120048);
        if (arVar.dZh() == ba.INVARIANT) {
            AppMethodBeat.o(120048);
            return false;
        } else if (baVar != arVar.dZh()) {
            AppMethodBeat.o(120048);
            return true;
        } else {
            AppMethodBeat.o(120048);
            return false;
        }
    }

    private static boolean a(a aVar) {
        if (aVar.BoX == b.FLEXIBLE_LOWER_BOUND || aVar.BoY || aVar.BoW == l.SUPERTYPE) {
            return false;
        }
        return true;
    }

    private final a.i.b.a.c.b.e a(a.i.b.a.c.d.a.e.j jVar, a aVar, a.i.b.a.c.f.b bVar) {
        AppMethodBeat.i(120044);
        a.i.b.a.c.b.e dXS;
        if (aVar.BoY && j.j(bVar, d.Bpm)) {
            dXS = this.Bnn.Bnv.Bnd.dXS();
            AppMethodBeat.o(120044);
            return dXS;
        }
        a.i.b.a.c.a.b.c cVar = a.i.b.a.c.a.b.c.Bdq;
        dXS = a.i.b.a.c.a.b.c.a(bVar, this.Bnn.Bnv.BcH.dZD());
        if (dXS == null) {
            AppMethodBeat.o(120044);
            return null;
        } else if (a.i.b.a.c.a.b.c.i(dXS) && (aVar.BoX == b.FLEXIBLE_LOWER_BOUND || aVar.BoW == l.SUPERTYPE || a(jVar, dXS))) {
            dXS = a.i.b.a.c.a.b.c.k(dXS);
            AppMethodBeat.o(120044);
            return dXS;
        } else {
            AppMethodBeat.o(120044);
            return dXS;
        }
    }
}
