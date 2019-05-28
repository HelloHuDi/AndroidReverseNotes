package a.i.b.a.c.j.a;

import a.a.ag;
import a.a.m;
import a.a.t;
import a.a.v;
import a.f.b.i;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.b.ad;
import a.i.b.a.c.b.aq;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.h;
import a.i.b.a.c.b.s;
import a.i.b.a.c.b.y;
import a.i.b.a.c.e.a.aa;
import a.i.b.a.c.e.a.ae;
import a.i.b.a.c.e.a.g;
import a.i.b.a.c.f.f;
import a.i.b.a.c.l.ah;
import a.i.b.a.c.l.al;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.p;
import a.i.b.a.c.l.x;
import a.j.l;
import a.j.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class w {
    private final a.f.a.b<Integer, a.i.b.a.c.b.e> BHD;
    private final a.f.a.b<Integer, h> BHE;
    private final Map<Integer, ar> BHF;
    private final w BHG;
    boolean BHH;
    final k BHj;
    private final String ByG;

    static final class a extends k implements a.f.a.b<Integer, a.i.b.a.c.b.e> {
        final /* synthetic */ w BHI;

        a(w wVar) {
            this.BHI = wVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(122307);
            int intValue = ((Number) obj).intValue();
            w wVar = this.BHI;
            a.i.b.a.c.f.a a = r.a(wVar.BHj.AWq, intValue);
            if (a.ByO) {
                a.i.b.a.c.b.e i = wVar.BHj.Brl.i(a);
                AppMethodBeat.o(122307);
                return i;
            }
            Object a2 = s.a(wVar.BHj.Brl.Bdv, a);
            AppMethodBeat.o(122307);
            return a2;
        }
    }

    static final class b extends k implements a.f.a.b<aa, List<? extends a.i.b.a.c.e.a.aa.a>> {
        final /* synthetic */ w BHI;

        b(w wVar) {
            this.BHI = wVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(122308);
            List u = u((aa) obj);
            AppMethodBeat.o(122308);
            return u;
        }

        public final List<a.i.b.a.c.e.a.aa.a> u(aa aaVar) {
            List u;
            AppMethodBeat.i(122309);
            j.p(aaVar, "receiver$0");
            List list = aaVar.BsF;
            j.o(list, "argumentList");
            Collection collection = list;
            aa b = g.b(aaVar, this.BHI.BHj.AWr);
            if (b != null) {
                u = u(b);
            } else {
                u = null;
            }
            if (u == null) {
                u = v.AUP;
            }
            list = t.b(collection, (Iterable) u);
            AppMethodBeat.o(122309);
            return list;
        }
    }

    static final class d extends k implements a.f.a.b<Integer, h> {
        final /* synthetic */ w BHI;

        d(w wVar) {
            this.BHI = wVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(122311);
            int intValue = ((Number) obj).intValue();
            w wVar = this.BHI;
            a.i.b.a.c.f.a a = r.a(wVar.BHj.AWq, intValue);
            if (a.ByO) {
                AppMethodBeat.o(122311);
                return null;
            }
            aq aqVar;
            y yVar = wVar.BHj.Brl.Bdv;
            j.p(yVar, "receiver$0");
            j.p(a, "classId");
            a.i.b.a.c.f.b bVar = a.BcW;
            j.o(bVar, "classId.packageFqName");
            ad g = yVar.g(bVar);
            List ehM = a.ByN.ByQ.ehM();
            j.o(ehM, "classId.relativeClassName.pathSegments()");
            int size = ehM.size() - 1;
            a.i.b.a.c.i.e.h dXR = g.dXR();
            Object fJ = t.fJ(ehM);
            j.o(fJ, "segments.first()");
            h c = dXR.c((f) fJ, a.i.b.a.c.c.a.c.FROM_DESERIALIZATION);
            if (size == 0) {
                if (!(c instanceof aq)) {
                    c = null;
                }
                aqVar = (aq) c;
            } else {
                if (!(c instanceof a.i.b.a.c.b.e)) {
                    c = null;
                }
                a.i.b.a.c.b.e eVar = (a.i.b.a.c.b.e) c;
                if (eVar == null) {
                    aqVar = null;
                } else {
                    Iterator it = ehM.subList(1, size).iterator();
                    while (true) {
                        a.i.b.a.c.b.e eVar2 = eVar;
                        f fVar;
                        if (it.hasNext()) {
                            fVar = (f) it.next();
                            a.i.b.a.c.i.e.h dZk = eVar2.dZk();
                            j.o(fVar, "name");
                            c = dZk.c(fVar, a.i.b.a.c.c.a.c.FROM_DESERIALIZATION);
                            if (!(c instanceof a.i.b.a.c.b.e)) {
                                c = null;
                            }
                            eVar = (a.i.b.a.c.b.e) c;
                            if (eVar == null) {
                                aqVar = null;
                                break;
                            }
                        } else {
                            fVar = (f) ehM.get(size);
                            a.i.b.a.c.i.e.h dXZ = eVar2.dXZ();
                            j.o(fVar, "lastName");
                            c = dXZ.c(fVar, a.i.b.a.c.c.a.c.FROM_DESERIALIZATION);
                            if (!(c instanceof aq)) {
                                c = null;
                            }
                            aqVar = (aq) c;
                        }
                    }
                }
            }
            c = aqVar;
            AppMethodBeat.o(122311);
            return c;
        }
    }

    static final class e extends k implements a.f.a.b<Integer, a.i.b.a.c.b.e> {
        final /* synthetic */ w BHI;
        final /* synthetic */ aa BHJ;

        static final class a extends i implements a.f.a.b<a.i.b.a.c.f.a, a.i.b.a.c.f.a> {
            public static final a BHK = new a();

            static {
                AppMethodBeat.i(122314);
                AppMethodBeat.o(122314);
            }

            a() {
                super(1);
            }

            public final a.i.d dWF() {
                AppMethodBeat.i(122313);
                a.i.b aN = a.f.b.v.aN(a.i.b.a.c.f.a.class);
                AppMethodBeat.o(122313);
                return aN;
            }

            public final String due() {
                return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
            }

            public final String getName() {
                return "getOuterClassId";
            }

            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(122312);
                a.i.b.a.c.f.a aVar = (a.i.b.a.c.f.a) obj;
                j.p(aVar, "p1");
                a.i.b.a.c.f.a ehC = aVar.ehC();
                AppMethodBeat.o(122312);
                return ehC;
            }
        }

        static final class b extends k implements a.f.a.b<aa, aa> {
            final /* synthetic */ e BHL;

            b(e eVar) {
                this.BHL = eVar;
                super(1);
            }

            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(122315);
                aa aaVar = (aa) obj;
                j.p(aaVar, "it");
                aa b = g.b(aaVar, this.BHL.BHI.BHj.AWr);
                AppMethodBeat.o(122315);
                return b;
            }
        }

        static final class c extends k implements a.f.a.b<aa, Integer> {
            public static final c BHM = new c();

            static {
                AppMethodBeat.i(122317);
                AppMethodBeat.o(122317);
            }

            c() {
                super(1);
            }

            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(122316);
                aa aaVar = (aa) obj;
                j.p(aaVar, "it");
                Integer valueOf = Integer.valueOf(aaVar.getArgumentCount());
                AppMethodBeat.o(122316);
                return valueOf;
            }
        }

        e(w wVar, aa aaVar) {
            this.BHI = wVar;
            this.BHJ = aaVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(122318);
            a.i.b.a.c.b.e UN = UN(((Number) obj).intValue());
            AppMethodBeat.o(122318);
            return UN;
        }

        public final a.i.b.a.c.b.e UN(int i) {
            AppMethodBeat.i(122319);
            a.i.b.a.c.f.a a = r.a(this.BHI.BHj.AWq, i);
            List d = n.d(n.d(l.a(this.BHJ, new b(this)), c.BHM));
            int e = n.e(l.a(a, a.BHK));
            while (d.size() < e) {
                d.add(Integer.valueOf(0));
            }
            a.i.b.a.c.b.e a2 = this.BHI.BHj.Brl.Bcm.a(a, d);
            AppMethodBeat.o(122319);
            return a2;
        }
    }

    static final class c extends k implements a.f.a.a<List<? extends a.i.b.a.c.b.a.c>> {
        final /* synthetic */ w BHI;
        final /* synthetic */ aa BHJ;

        c(w wVar, aa aaVar) {
            this.BHI = wVar;
            this.BHJ = aaVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(122310);
            List a = this.BHI.BHj.Brl.BGR.a(this.BHJ, this.BHI.BHj.AWq);
            AppMethodBeat.o(122310);
            return a;
        }
    }

    private w(k kVar, w wVar, List<ae> list, String str) {
        Map emptyMap;
        j.p(kVar, "c");
        j.p(list, "typeParameterProtos");
        j.p(str, "debugName");
        AppMethodBeat.i(122332);
        this.BHj = kVar;
        this.BHG = wVar;
        this.ByG = str;
        this.BHH = false;
        this.BHD = this.BHj.Brl.Baf.g(new a(this));
        this.BHE = this.BHj.Brl.Baf.g(new d(this));
        if (list.isEmpty()) {
            emptyMap = ag.emptyMap();
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = 0;
            for (ae aeVar : list) {
                linkedHashMap.put(Integer.valueOf(aeVar.BsE), new a.i.b.a.c.j.a.a.l(this.BHj, aeVar, i));
                i++;
            }
            emptyMap = linkedHashMap;
            this = this;
        }
        this.BHF = emptyMap;
        AppMethodBeat.o(122332);
    }

    public /* synthetic */ w(k kVar, w wVar, List list, String str, byte b) {
        this(kVar, wVar, list, str);
    }

    public final List<ar> ejS() {
        AppMethodBeat.i(122320);
        List m = t.m(this.BHF.values());
        AppMethodBeat.o(122320);
        return m;
    }

    public final a.i.b.a.c.l.w r(aa aaVar) {
        AppMethodBeat.i(122321);
        j.p(aaVar, "proto");
        a.i.b.a.c.l.w a;
        if (aaVar.eeZ()) {
            String string = this.BHj.AWq.getString(aaVar.Bvb);
            a.i.b.a.c.l.ad s = s(aaVar);
            aa a2 = g.a(aaVar, this.BHj.AWr);
            if (a2 == null) {
                j.dWJ();
            }
            a = this.BHj.Brl.BGU.a(aaVar, string, s, s(a2));
            AppMethodBeat.o(122321);
            return a;
        }
        a = s(aaVar);
        AppMethodBeat.o(122321);
        return a;
    }

    public final a.i.b.a.c.l.ad s(aa aaVar) {
        AppMethodBeat.i(122322);
        j.p(aaVar, "proto");
        if (aaVar.efc()) {
            UM(aaVar.Bve);
        } else if (aaVar.eff()) {
            UM(aaVar.Bvh);
        }
        an t = t(aaVar);
        a.i.b.a.c.l.ad a;
        if (p.L(t.dYs())) {
            a = p.a(t.toString(), t);
            j.o(a, "ErrorUtils.createErrorTy….toString(), constructor)");
            AppMethodBeat.o(122322);
            return a;
        }
        a.i.b.a.c.j.a.a.a aVar = new a.i.b.a.c.j.a.a.a(this.BHj.Brl.Baf, new c(this, aaVar));
        Iterable u = new b(this).u(aaVar);
        Collection arrayList = new ArrayList(m.d(u));
        int i = 0;
        for (Object next : u) {
            int i2 = i + 1;
            if (i < 0) {
                a.a.l.dWs();
            }
            a.i.b.a.c.e.a.aa.a aVar2 = (a.i.b.a.c.e.a.aa.a) next;
            List parameters = t.getParameters();
            j.o(parameters, "constructor.parameters");
            arrayList.add(a((ar) t.x(parameters, i), aVar2));
            i = i2;
        }
        List m = t.m((List) arrayList);
        Boolean Ug = a.i.b.a.c.e.a.b.Bwt.Ug(aaVar.BsW);
        j.o(Ug, "Flags.SUSPEND_TYPE.get(proto.flags)");
        if (Ug.booleanValue()) {
            a = a(aVar, t, m, aaVar.Bva);
        } else {
            a = x.c(aVar, t, m, aaVar.Bva);
        }
        aa c = g.c(aaVar, this.BHj.AWr);
        if (c == null) {
            AppMethodBeat.o(122322);
            return a;
        }
        a = a.i.b.a.c.l.ag.b(a, s(c));
        AppMethodBeat.o(122322);
        return a;
    }

    /* JADX WARNING: Missing block: B:22:0x00a3, code skipped:
            if (r0 == null) goto L_0x00a5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final an t(aa aaVar) {
        AppMethodBeat.i(122323);
        e eVar = new e(this, aaVar);
        an dXY;
        if (aaVar.efc()) {
            a.i.b.a.c.b.e eVar2 = (a.i.b.a.c.b.e) this.BHD.am(Integer.valueOf(aaVar.Bve));
            if (eVar2 == null) {
                eVar2 = eVar.UN(aaVar.Bve);
            }
            dXY = eVar2.dXY();
            j.o(dXY, "(classDescriptors(proto.…assName)).typeConstructor");
            AppMethodBeat.o(122323);
            return dXY;
        }
        if (aaVar.efd()) {
            dXY = UL(aaVar.Bvf);
            if (dXY == null) {
                dXY = p.awp("Unknown type parameter " + aaVar.Bvf);
                j.o(dXY, "ErrorUtils.createErrorTy… ${proto.typeParameter}\")");
                AppMethodBeat.o(122323);
                return dXY;
            }
        } else if (aaVar.efe()) {
            Object obj;
            a.i.b.a.c.b.l lVar = this.BHj.Bht;
            String string = this.BHj.AWq.getString(aaVar.Bvg);
            for (Object next : ejS()) {
                if (j.j(((ar) next).dZg().name, string)) {
                    obj = next;
                    break;
                }
            }
            obj = null;
            ar arVar = (ar) obj;
            if (arVar != null) {
                dXY = arVar.dXY();
            }
            dXY = p.awp("Deserialized type parameter " + string + " in " + lVar);
            j.o(dXY, "ErrorUtils.createErrorTy…ter $name in $container\")");
            AppMethodBeat.o(122323);
            return dXY;
        } else if (aaVar.eff()) {
            h hVar = (h) this.BHE.am(Integer.valueOf(aaVar.Bvh));
            if (hVar == null) {
                hVar = eVar.UN(aaVar.Bvh);
            }
            dXY = hVar.dXY();
            j.o(dXY, "(typeAliasDescriptors(pr…iasName)).typeConstructor");
            AppMethodBeat.o(122323);
            return dXY;
        } else {
            dXY = p.awp("Unknown type");
            j.o(dXY, "ErrorUtils.createErrorTy…nstructor(\"Unknown type\")");
        }
        AppMethodBeat.o(122323);
        return dXY;
    }

    private final a.i.b.a.c.l.ad a(a.i.b.a.c.b.a.g gVar, an anVar, List<? extends ap> list, boolean z) {
        a.i.b.a.c.l.ad adVar = null;
        AppMethodBeat.i(122324);
        switch (anVar.getParameters().size() - list.size()) {
            case 0:
                adVar = b(gVar, anVar, list, z);
                break;
            case 1:
                int size = list.size() - 1;
                if (size >= 0) {
                    a.i.b.a.c.b.e SM = anVar.dZD().SM(size);
                    j.o(SM, "functionTypeConstructor.…getSuspendFunction(arity)");
                    an dXY = SM.dXY();
                    j.o(dXY, "functionTypeConstructor.…on(arity).typeConstructor");
                    adVar = x.c(gVar, dXY, list, z);
                    break;
                }
                break;
        }
        if (adVar == null) {
            adVar = p.C("Bad suspend function in metadata with constructor: ".concat(String.valueOf(anVar)), list);
            j.o(adVar, "ErrorUtils.createErrorTy…      arguments\n        )");
        }
        AppMethodBeat.o(122324);
        return adVar;
    }

    private final a.i.b.a.c.l.ad b(a.i.b.a.c.b.a.g gVar, an anVar, List<? extends ap> list, boolean z) {
        AppMethodBeat.i(122325);
        a.i.b.a.c.l.ad c = x.c(gVar, anVar, list, z);
        if (a.i.b.a.c.a.f.d(c)) {
            a.i.b.a.c.l.ad af = af(c);
            AppMethodBeat.o(122325);
            return af;
        }
        AppMethodBeat.o(122325);
        return null;
    }

    private final a.i.b.a.c.l.ad af(a.i.b.a.c.l.w wVar) {
        Object obj = null;
        AppMethodBeat.i(122326);
        ap apVar = (ap) t.fM(a.i.b.a.c.a.f.j(wVar));
        if (apVar != null) {
            a.i.b.a.c.l.w dZS = apVar.dZS();
            if (dZS != null) {
                j.o(dZS, "funType.getValueParamete…ll()?.type ?: return null");
                h dYs = dZS.ejw().dYs();
                a.i.b.a.c.f.b o;
                if (dYs != null) {
                    o = a.i.b.a.c.i.c.a.o(dYs);
                } else {
                    o = null;
                }
                a.i.b.a.c.l.ad a;
                if (dZS.ejt().size() == 1 && (a.i.b.a.c.a.k.a(o, true) || a.i.b.a.c.a.k.a(o, false))) {
                    dZS = ((ap) t.fN(dZS.ejt())).dZS();
                    j.o(dZS, "continuationArgumentType.arguments.single().type");
                    a.i.b.a.c.b.l lVar = this.BHj.Bht;
                    if (!(lVar instanceof a.i.b.a.c.b.a)) {
                        lVar = null;
                    }
                    a.i.b.a.c.b.a aVar = (a.i.b.a.c.b.a) lVar;
                    if (aVar != null) {
                        obj = a.i.b.a.c.i.c.a.I(aVar);
                    }
                    if (j.j(obj, v.BHC)) {
                        a = a(wVar, dZS);
                        AppMethodBeat.o(122326);
                        return a;
                    }
                    boolean z;
                    if (this.BHH) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.BHH = z;
                    a = a(wVar, dZS);
                    AppMethodBeat.o(122326);
                    return a;
                }
                a = (a.i.b.a.c.l.ad) wVar;
                AppMethodBeat.o(122326);
                return a;
            }
        }
        AppMethodBeat.o(122326);
        return null;
    }

    private static a.i.b.a.c.l.ad a(a.i.b.a.c.l.w wVar, a.i.b.a.c.l.w wVar2) {
        AppMethodBeat.i(122327);
        a.i.b.a.c.a.g aL = a.i.b.a.c.l.c.a.aL(wVar);
        a.i.b.a.c.b.a.g dYn = wVar.dYn();
        a.i.b.a.c.l.w h = a.i.b.a.c.a.f.h(wVar);
        Iterable<ap> fP = t.fP(a.i.b.a.c.a.f.j(wVar));
        Collection arrayList = new ArrayList(m.d(fP));
        for (ap dZS : fP) {
            arrayList.add(dZS.dZS());
        }
        a.i.b.a.c.l.ad rL = a.i.b.a.c.a.f.a(aL, dYn, h, (List) arrayList, wVar2, true).rL(wVar.eci());
        AppMethodBeat.o(122327);
        return rL;
    }

    private final an UL(int i) {
        an dXY;
        AppMethodBeat.i(122328);
        do {
            ar arVar = (ar) this.BHF.get(Integer.valueOf(i));
            if (arVar != null) {
                dXY = arVar.dXY();
                if (dXY != null) {
                    break;
                }
            }
            this = this.BHG;
        } while (this != null);
        dXY = null;
        AppMethodBeat.o(122328);
        return dXY;
    }

    private final a.i.b.a.c.l.ad UM(int i) {
        AppMethodBeat.i(122329);
        if (r.a(this.BHj.AWq, i).ByO) {
            AppMethodBeat.o(122329);
        } else {
            AppMethodBeat.o(122329);
        }
        return null;
    }

    public final String toString() {
        AppMethodBeat.i(122331);
        String str = this.ByG + (this.BHG == null ? "" : ". Child of " + this.BHG.ByG);
        AppMethodBeat.o(122331);
        return str;
    }

    private final ap a(ar arVar, a.i.b.a.c.e.a.aa.a aVar) {
        AppMethodBeat.i(122330);
        ap arVar2;
        if (aVar.Bvn != a.i.b.a.c.e.a.aa.a.b.STAR) {
            t tVar = t.BHx;
            a.i.b.a.c.e.a.aa.a.b bVar = aVar.Bvn;
            j.o(bVar, "typeArgumentProto.projection");
            ba b = t.b(bVar);
            aa a = g.a(aVar, this.BHj.AWr);
            if (a == null) {
                arVar2 = new a.i.b.a.c.l.ar(p.awn("No type recorded"));
                AppMethodBeat.o(122330);
                return arVar2;
            }
            arVar2 = new a.i.b.a.c.l.ar(b, r(a));
            AppMethodBeat.o(122330);
            return arVar2;
        } else if (arVar == null) {
            a.i.b.a.c.l.ad dXN = this.BHj.Brl.Bdv.dZD().dXN();
            j.o(dXN, "c.components.moduleDescr….builtIns.nullableAnyType");
            arVar2 = new al(dXN);
            AppMethodBeat.o(122330);
            return arVar2;
        } else {
            arVar2 = new ah(arVar);
            AppMethodBeat.o(122330);
            return arVar2;
        }
    }
}
