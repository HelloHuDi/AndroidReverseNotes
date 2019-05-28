package a.i.b.a.c.l.d;

import a.aa;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.a.g;
import a.i.b.a.c.h.i;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.ao;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.ar;
import a.i.b.a.c.l.as;
import a.i.b.a.c.l.at;
import a.i.b.a.c.l.au;
import a.i.b.a.c.l.av;
import a.i.b.a.c.l.ax;
import a.i.b.a.c.l.az;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.t;
import a.i.b.a.c.l.w;
import a.i.b.a.c.l.x;
import a.m;
import a.o;
import a.v;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class b {

    static final class b extends k implements a.f.a.b<az, Boolean> {
        public static final b BLo = new b();

        static {
            AppMethodBeat.i(122834);
            AppMethodBeat.o(122834);
        }

        b() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(122833);
            az azVar = (az) obj;
            j.o(azVar, "it");
            Boolean valueOf = Boolean.valueOf(a.i.b.a.c.i.a.a.c.ae(azVar));
            AppMethodBeat.o(122833);
            return valueOf;
        }
    }

    static final class d extends k implements a.f.a.b<i, y> {
        public static final d BLp = new d();

        static {
            AppMethodBeat.i(122837);
            AppMethodBeat.o(122837);
        }

        d() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(122836);
            i iVar = (i) obj;
            j.p(iVar, "receiver$0");
            iVar.a((a.i.b.a.c.h.b) a.i.b.a.c.h.b.a.BBD);
            y yVar = y.AUy;
            AppMethodBeat.o(122836);
            return yVar;
        }
    }

    static final class e extends k implements a.f.a.b<ba, ba> {
        final /* synthetic */ d BLq;

        e(d dVar) {
            this.BLq = dVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(122838);
            ba b = b((ba) obj);
            AppMethodBeat.o(122838);
            return b;
        }

        public final ba b(ba baVar) {
            AppMethodBeat.i(122839);
            j.p(baVar, "variance");
            if (baVar == this.BLq.BJL.dZh()) {
                baVar = ba.INVARIANT;
                AppMethodBeat.o(122839);
                return baVar;
            }
            AppMethodBeat.o(122839);
            return baVar;
        }
    }

    public static final class c extends ao {
        c() {
        }

        public final ap c(an anVar) {
            ap apVar;
            AppMethodBeat.i(122835);
            j.p(anVar, "key");
            if (anVar instanceof a.i.b.a.c.i.a.a.b) {
                Object apVar2 = anVar;
            } else {
                apVar2 = null;
            }
            a.i.b.a.c.i.a.a.b bVar = (a.i.b.a.c.i.a.a.b) apVar2;
            if (bVar == null) {
                AppMethodBeat.o(122835);
                return null;
            } else if (bVar.BEG.ekp()) {
                apVar2 = new ar(ba.OUT_VARIANCE, bVar.BEG.dZS());
                AppMethodBeat.o(122835);
                return apVar2;
            } else {
                ap apVar3 = bVar.BEG;
                AppMethodBeat.o(122835);
                return apVar3;
            }
        }
    }

    static final class a extends k implements a.f.a.b<w, w> {
        final /* synthetic */ w BEP;

        a(w wVar) {
            this.BEP = wVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(122831);
            w aP = aP((w) obj);
            AppMethodBeat.o(122831);
            return aP;
        }

        public final w aP(w wVar) {
            AppMethodBeat.i(122832);
            j.p(wVar, "receiver$0");
            w b = av.b(wVar, this.BEP.eci());
            j.o(b, "TypeUtils.makeNullableIf…s, type.isMarkedNullable)");
            AppMethodBeat.o(122832);
            return b;
        }
    }

    private static final d b(ap apVar, a.i.b.a.c.b.ar arVar) {
        AppMethodBeat.i(122840);
        w dZS;
        ad dXN;
        d dVar;
        switch (c.eQZ[au.a(arVar.dZh(), apVar).ordinal()]) {
            case 1:
                w dZS2 = apVar.dZS();
                j.o(dZS2, "type");
                dZS = apVar.dZS();
                j.o(dZS, "type");
                d dVar2 = new d(arVar, dZS2, dZS);
                AppMethodBeat.o(122840);
                return dVar2;
            case 2:
                dZS = apVar.dZS();
                j.o(dZS, "type");
                dXN = a.i.b.a.c.i.c.a.G(arVar).dXN();
                j.o(dXN, "typeParameter.builtIns.nullableAnyType");
                dVar = new d(arVar, dZS, dXN);
                AppMethodBeat.o(122840);
                return dVar;
            case 3:
                dXN = a.i.b.a.c.i.c.a.G(arVar).dXL();
                j.o(dXN, "typeParameter.builtIns.nothingType");
                w wVar = dXN;
                dZS = apVar.dZS();
                j.o(dZS, "type");
                dVar = new d(arVar, wVar, dZS);
                AppMethodBeat.o(122840);
                return dVar;
            default:
                m mVar = new m();
                AppMethodBeat.o(122840);
                throw mVar;
        }
    }

    public static final ap a(ap apVar, boolean z) {
        AppMethodBeat.i(122841);
        if (apVar == null) {
            AppMethodBeat.o(122841);
            return null;
        } else if (apVar.ekp()) {
            AppMethodBeat.o(122841);
            return apVar;
        } else {
            w dZS = apVar.dZS();
            j.o(dZS, "typeProjection.type");
            if (av.b(dZS, (a.f.a.b) b.BLo)) {
                ba ekq = apVar.ekq();
                j.o(ekq, "typeProjection.projectionKind");
                ap arVar;
                if (ekq == ba.OUT_VARIANCE) {
                    arVar = new ar(ekq, (w) aO(dZS).BLn);
                    AppMethodBeat.o(122841);
                    return arVar;
                } else if (z) {
                    arVar = new ar(ekq, (w) aO(dZS).BLm);
                    AppMethodBeat.o(122841);
                    return arVar;
                } else {
                    apVar = e(apVar);
                    AppMethodBeat.o(122841);
                    return apVar;
                }
            }
            AppMethodBeat.o(122841);
            return apVar;
        }
    }

    private static final ap e(ap apVar) {
        AppMethodBeat.i(122842);
        au d = au.d((as) new c());
        j.o(d, "TypeSubstitutor.create(o…ojection\n        }\n    })");
        ap d2 = d.d(apVar);
        AppMethodBeat.o(122842);
        return d2;
    }

    public static final a<w> aO(w wVar) {
        AppMethodBeat.i(122843);
        j.p(wVar, "type");
        a<w> aVar;
        if (t.ai(wVar)) {
            a aO = aO(t.ak(wVar));
            a aO2 = aO(t.al(wVar));
            aVar = new a(ax.a(x.a(t.ak((w) aO.BLm), t.al((w) aO2.BLm)), wVar), ax.a(x.a(t.ak((w) aO.BLn), t.al((w) aO2.BLn)), wVar));
            AppMethodBeat.o(122843);
            return aVar;
        }
        an ejw = wVar.ejw();
        a<w> aVar2;
        ad dXL;
        if (a.i.b.a.c.i.a.a.c.ae(wVar)) {
            if (ejw == null) {
                v vVar = new v("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
                AppMethodBeat.o(122843);
                throw vVar;
            }
            ap apVar = ((a.i.b.a.c.i.a.a.b) ejw).BEG;
            a aVar3 = new a(wVar);
            w dZS = apVar.dZS();
            j.o(dZS, "typeProjection.type");
            w aP = aVar3.aP(dZS);
            switch (c.pCY[apVar.ekq().ordinal()]) {
                case 1:
                    ad dXN = a.i.b.a.c.l.c.a.aL(wVar).dXN();
                    j.o(dXN, "type.builtIns.nullableAnyType");
                    aVar2 = new a(aP, dXN);
                    AppMethodBeat.o(122843);
                    return aVar2;
                case 2:
                    dXL = a.i.b.a.c.l.c.a.aL(wVar).dXL();
                    j.o(dXL, "type.builtIns.nothingType");
                    aVar = new a(aVar3.aP(dXL), aP);
                    AppMethodBeat.o(122843);
                    return aVar;
                default:
                    Throwable assertionError = new AssertionError("Only nontrivial projections should have been captured, not: ".concat(String.valueOf(apVar)));
                    AppMethodBeat.o(122843);
                    throw assertionError;
            }
        } else if (wVar.ejt().isEmpty() || wVar.ejt().size() != ejw.getParameters().size()) {
            aVar2 = new a(wVar, wVar);
            AppMethodBeat.o(122843);
            return aVar2;
        } else {
            d dVar;
            Object obj;
            Object obj2;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterable ejt = wVar.ejt();
            List parameters = ejw.getParameters();
            j.o(parameters, "typeConstructor.parameters");
            for (o oVar : a.a.t.a(ejt, (Iterable) parameters)) {
                ap apVar2 = (ap) oVar.first;
                a.i.b.a.c.b.ar arVar = (a.i.b.a.c.b.ar) oVar.second;
                j.o(arVar, "typeParameter");
                d b = b(apVar2, arVar);
                if (apVar2.ekp()) {
                    arrayList.add(b);
                    arrayList2.add(b);
                } else {
                    a a = a(b);
                    dVar = (d) a.BLm;
                    b = (d) a.BLn;
                    arrayList.add(dVar);
                    arrayList2.add(b);
                }
            }
            Iterable<d> iterable = arrayList;
            if (!((Collection) iterable).isEmpty()) {
                for (d dVar2 : iterable) {
                    if (dVar2.eks()) {
                        obj = null;
                        continue;
                    } else {
                        obj = 1;
                        continue;
                    }
                    if (obj != null) {
                        obj = 1;
                        break;
                    }
                }
            }
            obj = null;
            if (obj != null) {
                dXL = a.i.b.a.c.l.c.a.aL(wVar).dXL();
                j.o(dXL, "type.builtIns.nothingType");
                obj2 = dXL;
            } else {
                w obj22 = a(wVar, (List) arrayList);
            }
            a<w> aVar4 = new a(obj22, a(wVar, (List) arrayList2));
            AppMethodBeat.o(122843);
            return aVar4;
        }
    }

    private static final w a(w wVar, List<d> list) {
        AppMethodBeat.i(122844);
        Object obj = wVar.ejt().size() == list.size() ? 1 : null;
        Throwable assertionError;
        if (aa.AUz && obj == null) {
            assertionError = new AssertionError("Incorrect type arguments ".concat(String.valueOf(list)));
            AppMethodBeat.o(122844);
            throw assertionError;
        }
        Iterable<d> iterable = list;
        Collection arrayList = new ArrayList(a.a.m.d(iterable));
        for (d dVar : iterable) {
            boolean eks = dVar.eks();
            if (!aa.AUz || eks) {
                ar arVar;
                e eVar = new e(dVar);
                if (j.j(dVar.BLr, dVar.BLs)) {
                    arVar = new ar(dVar.BLr);
                } else if (g.y(dVar.BLr) && dVar.BJL.dZh() != ba.IN_VARIANCE) {
                    arVar = new ar(eVar.b(ba.OUT_VARIANCE), dVar.BLs);
                } else if (g.B(dVar.BLs)) {
                    arVar = new ar(eVar.b(ba.IN_VARIANCE), dVar.BLr);
                } else {
                    arVar = new ar(eVar.b(ba.OUT_VARIANCE), dVar.BLs);
                }
                arrayList.add(arVar);
            } else {
                a.i.b.a.c.h.c.a aVar = a.i.b.a.c.h.c.BBP;
                a.i.b.a.c.h.c e = a.i.b.a.c.h.c.a.e(d.BLp);
                assertionError = new AssertionError("Only consistent enhanced type projection can be converted to type projection, but [" + e.k(dVar.BJL) + ": <" + e.b(dVar.BLr) + ", " + e.b(dVar.BLs) + ">] was found");
                AppMethodBeat.o(122844);
                throw assertionError;
            }
        }
        w a = at.a(wVar, (List) arrayList, wVar.dYn());
        AppMethodBeat.o(122844);
        return a;
    }

    private static final a<d> a(d dVar) {
        AppMethodBeat.i(122845);
        a aO = aO(dVar.BLr);
        w wVar = (w) aO.BLm;
        w wVar2 = (w) aO.BLn;
        a aO2 = aO(dVar.BLs);
        a aVar = new a(new d(dVar.BJL, wVar2, (w) aO2.BLm), new d(dVar.BJL, wVar, (w) aO2.BLn));
        AppMethodBeat.o(122845);
        return aVar;
    }
}
