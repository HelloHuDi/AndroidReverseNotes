package a.i.b.a.c.d.a.f;

import a.a.i;
import a.aa;
import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.ak;
import a.i.b.a.c.b.au;
import a.i.b.a.c.d.a.c.h;
import a.i.b.a.c.d.a.p;
import a.i.b.a.c.d.a.u;
import a.i.b.a.c.d.b.r;
import a.i.b.a.c.i.b.s;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.av;
import a.i.b.a.c.l.ax;
import a.i.b.a.c.l.az;
import a.i.b.a.c.l.q;
import a.i.b.a.c.l.t;
import a.i.b.a.c.l.w;
import a.o;
import a.v;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public final class l {
    private final a.i.b.a.c.n.e Bkf;
    private final a.i.b.a.c.d.a.a Bne;

    static final class d extends k implements a.f.a.b<a.i.b.a.c.b.b, w> {
        public static final d Bqy = new d();

        static {
            AppMethodBeat.i(120167);
            AppMethodBeat.o(120167);
        }

        d() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(120166);
            a.i.b.a.c.b.b bVar = (a.i.b.a.c.b.b) obj;
            j.p(bVar, "it");
            ak dYQ = bVar.dYQ();
            if (dYQ == null) {
                j.dWJ();
            }
            j.o(dYQ, "it.extensionReceiverParameter!!");
            w dZS = dYQ.dZS();
            j.o(dZS, "it.extensionReceiverParameter!!.type");
            AppMethodBeat.o(120166);
            return dZS;
        }
    }

    static final class e extends k implements a.f.a.b<a.i.b.a.c.b.b, w> {
        public static final e Bqz = new e();

        static {
            AppMethodBeat.i(120169);
            AppMethodBeat.o(120169);
        }

        e() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(120168);
            a.i.b.a.c.b.b bVar = (a.i.b.a.c.b.b) obj;
            j.p(bVar, "it");
            w dYT = bVar.dYT();
            if (dYT == null) {
                j.dWJ();
            }
            AppMethodBeat.o(120168);
            return dYT;
        }
    }

    static final class f extends k implements a.f.a.b<a.i.b.a.c.b.b, w> {
        final /* synthetic */ au BqA;

        f(au auVar) {
            this.BqA = auVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(120170);
            a.i.b.a.c.b.b bVar = (a.i.b.a.c.b.b) obj;
            j.p(bVar, "it");
            Object obj2 = bVar.dYV().get(this.BqA.getIndex());
            j.o(obj2, "it.valueParameters[p.index]");
            w dZS = ((au) obj2).dZS();
            j.o(dZS, "it.valueParameters[p.index].type");
            AppMethodBeat.o(120170);
            return dZS;
        }
    }

    static class a {
        final w AYl;
        final boolean Bqi;
        final boolean Bqj;

        public a(w wVar, boolean z, boolean z2) {
            j.p(wVar, "type");
            AppMethodBeat.i(120147);
            this.AYl = wVar;
            this.Bqi = z;
            this.Bqj = z2;
            AppMethodBeat.o(120147);
        }
    }

    static final class c extends a {
        final boolean BmM;

        public c(w wVar, boolean z, boolean z2, boolean z3) {
            j.p(wVar, "type");
            super(wVar, z2, z3);
            AppMethodBeat.i(120165);
            this.BmM = z;
            AppMethodBeat.o(120165);
        }
    }

    final class b {
        private final a.i.b.a.c.b.a.a Bqk;
        private final w Bql;
        private final Collection<w> Bqm;
        private final boolean Bqn;
        private final h Bqo;
        private final a.i.b.a.c.d.a.a.a Bqp;
        final /* synthetic */ l Bqq;

        static final class f extends k implements m<w, h, y> {
            final /* synthetic */ ArrayList Bqx;

            f(ArrayList arrayList) {
                this.Bqx = arrayList;
                super(2);
            }

            public final /* synthetic */ Object m(Object obj, Object obj2) {
                AppMethodBeat.i(120156);
                a((w) obj, (h) obj2);
                y yVar = y.AUy;
                AppMethodBeat.o(120156);
                return yVar;
            }

            public final void a(w wVar, h hVar) {
                AppMethodBeat.i(120157);
                j.p(wVar, "type");
                j.p(hVar, "ownerContext");
                h b = a.i.b.a.c.d.a.c.a.b(hVar, wVar.dYn());
                ArrayList arrayList = this.Bqx;
                a.i.b.a.c.d.a.c.d ebm = b.ebm();
                arrayList.add(new p(wVar, ebm != null ? ebm.b(a.i.b.a.c.d.a.a.a.TYPE_USE) : null));
                for (ap apVar : wVar.ejt()) {
                    w dZS;
                    if (apVar.ekp()) {
                        arrayList = this.Bqx;
                        dZS = apVar.dZS();
                        j.o(dZS, "arg.type");
                        arrayList.add(new p(dZS, null));
                    } else {
                        f fVar = this;
                        dZS = apVar.dZS();
                        j.o(dZS, "arg.type");
                        fVar.a(dZS, b);
                    }
                }
                AppMethodBeat.o(120157);
            }
        }

        static final class a extends k implements a.f.a.b<Integer, d> {
            final /* synthetic */ d[] Bqr;

            a(d[] dVarArr) {
                this.Bqr = dVarArr;
                super(1);
            }

            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(120148);
                int intValue = ((Number) obj).intValue();
                d[] dVarArr = this.Bqr;
                Object ecg;
                if (intValue < 0 || intValue > i.P(dVarArr)) {
                    a.i.b.a.c.d.a.f.d.a aVar = d.BpG;
                    ecg = d.BpF;
                    AppMethodBeat.o(120148);
                    return ecg;
                }
                ecg = dVarArr[intValue];
                AppMethodBeat.o(120148);
                return ecg;
            }
        }

        static final class d extends k implements m<List<? extends a.i.b.a.c.f.b>, T, T> {
            final /* synthetic */ g Bqv;

            d(g gVar) {
                this.Bqv = gVar;
                super(2);
            }

            public final /* synthetic */ Object m(Object obj, Object obj2) {
                AppMethodBeat.i(120152);
                Object b = b((List) obj, obj2);
                AppMethodBeat.o(120152);
                return b;
            }

            public final <T> T b(List<a.i.b.a.c.f.b> list, T t) {
                Object obj;
                AppMethodBeat.i(120153);
                j.p(list, "receiver$0");
                j.p(t, "qualifier");
                Iterable<a.i.b.a.c.f.b> iterable = list;
                if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                    for (a.i.b.a.c.f.b i : iterable) {
                        if (this.Bqv.i(i) != null) {
                            obj = 1;
                            continue;
                        } else {
                            obj = null;
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
                    AppMethodBeat.o(120153);
                    return t;
                }
                AppMethodBeat.o(120153);
                return null;
            }
        }

        static final class b extends k implements a.f.a.b<Integer, d> {
            final /* synthetic */ r Bqs;
            final /* synthetic */ a.f.a.b Bqt;

            b(r rVar, a.f.a.b bVar) {
                this.Bqs = rVar;
                this.Bqt = bVar;
                super(1);
            }

            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(120149);
                int intValue = ((Number) obj).intValue();
                Object obj2 = (d) this.Bqs.map.get(Integer.valueOf(intValue));
                if (obj2 == null) {
                    obj2 = (d) this.Bqt.am(Integer.valueOf(intValue));
                }
                AppMethodBeat.o(120149);
                return obj2;
            }
        }

        static final class c extends k implements a.f.a.b<az, Boolean> {
            public static final c Bqu = new c();

            static {
                AppMethodBeat.i(120151);
                AppMethodBeat.o(120151);
            }

            c() {
                super(1);
            }

            public final /* synthetic */ Object am(Object obj) {
                boolean z;
                Boolean valueOf;
                AppMethodBeat.i(120150);
                a.i.b.a.c.b.h dYs = ((az) obj).ejw().dYs();
                if (dYs != null) {
                    j.o(dYs, "it.constructor.declarati… ?: return@contains false");
                    a.i.b.a.c.f.f dZg = dYs.dZg();
                    a.i.b.a.c.a.b.c cVar = a.i.b.a.c.a.b.c.Bdq;
                    if (j.j(dZg, a.i.b.a.c.a.b.c.dYA().ByQ.ehK())) {
                        a.i.b.a.c.f.b I = a.i.b.a.c.i.c.a.I(dYs);
                        a.i.b.a.c.a.b.c cVar2 = a.i.b.a.c.a.b.c.Bdq;
                        if (j.j(I, a.i.b.a.c.a.b.c.dYA())) {
                            z = true;
                            valueOf = Boolean.valueOf(z);
                            AppMethodBeat.o(120150);
                            return valueOf;
                        }
                    }
                }
                z = false;
                valueOf = Boolean.valueOf(z);
                AppMethodBeat.o(120150);
                return valueOf;
            }
        }

        static final class e extends k implements m<T, T, T> {
            public static final e Bqw = new e();

            static {
                AppMethodBeat.i(120155);
                AppMethodBeat.o(120155);
            }

            e() {
                super(2);
            }

            public final <T> T m(T t, T t2) {
                AppMethodBeat.i(120154);
                if (t != null && t2 != null && !j.j(t, t2)) {
                    t = null;
                } else if (t == null) {
                    AppMethodBeat.o(120154);
                    return t2;
                }
                AppMethodBeat.o(120154);
                return t;
            }
        }

        public b(l lVar, a.i.b.a.c.b.a.a aVar, w wVar, Collection<? extends w> collection, boolean z, h hVar, a.i.b.a.c.d.a.a.a aVar2) {
            j.p(wVar, "fromOverride");
            j.p(collection, "fromOverridden");
            j.p(hVar, "containerContext");
            j.p(aVar2, "containerApplicabilityType");
            this.Bqq = lVar;
            AppMethodBeat.i(120164);
            this.Bqk = aVar;
            this.Bql = wVar;
            this.Bqm = collection;
            this.Bqn = z;
            this.Bqo = hVar;
            this.Bqp = aVar2;
            AppMethodBeat.o(120164);
        }

        public final a a(r rVar) {
            a.f.a.b bVar;
            AppMethodBeat.i(120158);
            a.f.a.b ecn = ecn();
            if (rVar != null) {
                bVar = new b(rVar, ecn);
            } else {
                bVar = null;
            }
            boolean b = av.b(this.Bql, (a.f.a.b) c.Bqu);
            w wVar = this.Bql;
            if (bVar == null) {
                bVar = ecn;
            }
            w a = s.a(wVar, bVar);
            a aVar;
            if (a != null) {
                aVar = new a(a, true, b);
                AppMethodBeat.o(120158);
                return aVar;
            }
            aVar = new a(this.Bql, false, b);
            AppMethodBeat.o(120158);
            return aVar;
        }

        private static d S(w wVar) {
            o oVar;
            Object obj;
            e eVar = null;
            AppMethodBeat.i(120159);
            if (t.ai(wVar)) {
                q aj = t.aj(wVar);
                oVar = new o(aj.BJx, aj.BJy);
            } else {
                oVar = new o(wVar, wVar);
            }
            w wVar2 = (w) oVar.first;
            w wVar3 = (w) oVar.second;
            a.i.b.a.c.a.b.c cVar = a.i.b.a.c.a.b.c.Bdq;
            g gVar = wVar2.eci() ? g.NULLABLE : !wVar3.eci() ? g.NOT_NULL : null;
            j.p(wVar2, "type");
            a.i.b.a.c.b.e aD = av.aD(wVar2);
            if (aD == null || !a.i.b.a.c.a.b.c.i(aD)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                eVar = e.READ_ONLY;
            } else {
                j.p(wVar3, "type");
                aD = av.aD(wVar3);
                if (aD == null || !a.i.b.a.c.a.b.c.h(aD)) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    eVar = e.MUTABLE;
                }
            }
            d dVar = new d(gVar, eVar, wVar.ekn() instanceof f);
            AppMethodBeat.o(120159);
            return dVar;
        }

        private final d a(w wVar, boolean z, d dVar) {
            g dYn;
            h i;
            h hVar;
            g gVar;
            boolean z2;
            boolean z3;
            g gVar2 = null;
            AppMethodBeat.i(120160);
            if (!z || this.Bqk == null) {
                dYn = wVar.dYn();
            } else {
                dYn = a.i.b.a.c.b.a.i.a(this.Bqk.dYn(), wVar.dYn());
            }
            d dVar2 = new d(dYn);
            e eVar = e.Bqw;
            if (z) {
                a.i.b.a.c.d.a.c.d ebm = this.Bqo.ebm();
                if (ebm != null) {
                    dVar = ebm.b(this.Bqp);
                } else {
                    dVar = null;
                }
            }
            Iterable<a.i.b.a.c.b.a.c> iterable = dYn;
            l lVar = this.Bqq;
            for (a.i.b.a.c.b.a.c i2 : iterable) {
                i = lVar.i(i2);
                if (i != null) {
                    break;
                }
            }
            i = null;
            if (i != null) {
                hVar = i;
            } else if (dVar == null || dVar.BpB == null) {
                hVar = null;
            } else {
                hVar = new h(dVar.BpB, dVar.BpE);
            }
            if (hVar != null) {
                gVar = hVar.BpP;
            } else {
                gVar = null;
            }
            e eVar2 = (e) eVar.m(dVar2.b(a.i.b.a.c.d.a.q.ebg(), e.READ_ONLY), dVar2.b(a.i.b.a.c.d.a.q.ebh(), e.MUTABLE));
            if (hVar != null) {
                gVar2 = hVar.BpP;
            }
            if (gVar2 == g.NOT_NULL && a.i.b.a.c.l.c.a.aE(wVar)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (hVar == null || !hVar.BpQ) {
                z3 = false;
            } else {
                z3 = true;
            }
            d dVar3 = new d(gVar, eVar2, z2, z3);
            AppMethodBeat.o(120160);
            return dVar3;
        }

        /* JADX WARNING: Removed duplicated region for block: B:37:0x0098  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x006f  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0076  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final a.f.a.b<Integer, d> ecn() {
            Object obj;
            int i;
            d[] dVarArr;
            int length;
            int i2;
            a.f.a.b aVar;
            AppMethodBeat.i(120161);
            Iterable<w> iterable = this.Bqm;
            Collection arrayList = new ArrayList(a.a.m.d(iterable));
            for (w T : iterable) {
                arrayList.add(T(T));
            }
            List<List> list = (List) arrayList;
            List T2 = T(this.Bql);
            if (this.Bqn) {
                Object obj2;
                iterable = this.Bqm;
                if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                    for (w T3 : iterable) {
                        if (a.i.b.a.c.l.a.c.BKs.d(T3, this.Bql)) {
                            obj2 = null;
                            continue;
                        } else {
                            obj2 = 1;
                            continue;
                        }
                        if (obj2 != null) {
                            obj2 = 1;
                            break;
                        }
                    }
                }
                obj2 = null;
                if (obj2 != null) {
                    obj = 1;
                    if (obj == null) {
                        i = 1;
                    } else {
                        i = T2.size();
                    }
                    dVarArr = new d[i];
                    length = dVarArr.length;
                    for (i2 = 0; i2 < length; i2++) {
                        boolean z;
                        if (i2 == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z || obj == null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if (aa.AUz && r0 == null) {
                            Throwable assertionError = new AssertionError("Only head type constructors should be computed");
                            AppMethodBeat.o(120161);
                            throw assertionError;
                        }
                        p pVar = (p) T2.get(i2);
                        w wVar = pVar.AYl;
                        d dVar = pVar.BqG;
                        Collection arrayList2 = new ArrayList();
                        for (List x : list) {
                            pVar = (p) a.a.t.x(x, i2);
                            if (pVar != null) {
                                obj2 = pVar.AYl;
                            } else {
                                obj2 = null;
                            }
                            if (obj2 != null) {
                                arrayList2.add(obj2);
                            }
                        }
                        dVarArr[i2] = a(wVar, (List) arrayList2, dVar, z);
                    }
                    aVar = new a(dVarArr);
                    AppMethodBeat.o(120161);
                    return aVar;
                }
            }
            obj = null;
            if (obj == null) {
            }
            dVarArr = new d[i];
            length = dVarArr.length;
            while (i2 < length) {
            }
            aVar = new a(dVarArr);
            AppMethodBeat.o(120161);
            return aVar;
        }

        private final List<p> T(w wVar) {
            AppMethodBeat.i(120162);
            ArrayList arrayList = new ArrayList(1);
            new f(arrayList).a(wVar, this.Bqo);
            List list = arrayList;
            AppMethodBeat.o(120162);
            return list;
        }

        /* JADX WARNING: Removed duplicated region for block: B:86:0x0182  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x0176  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final d a(w wVar, Collection<? extends w> collection, d dVar, boolean z) {
            w dZV;
            e eVar;
            d dVar2;
            g gVar;
            Object obj;
            boolean z2;
            boolean z3;
            boolean z4;
            AppMethodBeat.i(120163);
            Iterable<w> iterable = collection;
            Collection arrayList = new ArrayList(a.a.m.d(iterable));
            for (w dZV2 : iterable) {
                arrayList.add(S(dZV2));
            }
            List<d> list = (List) arrayList;
            Collection arrayList2 = new ArrayList();
            for (d dVar22 : list) {
                eVar = dVar22.BpC;
                if (eVar != null) {
                    arrayList2.add(eVar);
                }
            }
            Set o = a.a.t.o((List) arrayList2);
            arrayList2 = new ArrayList();
            for (d dVar222 : list) {
                g gVar2 = dVar222.BpB;
                if (gVar2 != null) {
                    arrayList2.add(gVar2);
                }
            }
            Set o2 = a.a.t.o((List) arrayList2);
            Collection arrayList3 = new ArrayList();
            for (w wVar2 : collection) {
                w wVar22;
                j.p(wVar22, "receiver$0");
                w aG = ax.aG(wVar22);
                if (aG != null) {
                    wVar22 = aG;
                }
                gVar = S(wVar22).BpB;
                if (gVar != null) {
                    arrayList3.add(gVar);
                }
            }
            Set o3 = a.a.t.o((List) arrayList3);
            d a = a(wVar, z, dVar);
            if (a.BpE) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                dVar222 = a;
            } else {
                dVar222 = null;
            }
            if (dVar222 != null) {
                gVar = dVar222.BpB;
            } else {
                gVar = null;
            }
            g gVar3 = a.BpB;
            if (this.Bqn && z) {
                z2 = true;
            } else {
                z2 = false;
            }
            g a2 = n.a(o2, gVar, z2);
            if (a2 != null) {
                a.i.b.a.c.b.a.a aVar = this.Bqk;
                if (!(aVar instanceof au)) {
                    aVar = null;
                }
                au auVar = (au) aVar;
                if (auVar != null) {
                    dZV2 = auVar.dZV();
                } else {
                    dZV2 = null;
                }
                obj = ((dZV2 != null ? 1 : null) != null && z && a2 == g.NULLABLE) ? 1 : null;
                if (obj != null) {
                    a2 = null;
                }
            } else {
                a2 = null;
            }
            eVar = (e) n.a(o, e.MUTABLE, e.READ_ONLY, a.BpC, z2);
            Object obj2;
            if (gVar3 == gVar && (j.j(o3, o2) ^ 1) == 0) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (!a.BpD) {
                Object obj3;
                Iterable<d> iterable2 = list;
                if (!((Collection) iterable2).isEmpty()) {
                    for (d dVar3 : iterable2) {
                        if (dVar3.BpD) {
                            obj3 = 1;
                            break;
                        }
                    }
                }
                obj3 = null;
                if (obj3 == null) {
                    z3 = false;
                    if (a2 == null || obj2 == null) {
                        if (a2 != null) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        dVar222 = n.a(a2, eVar, z4, z3);
                        AppMethodBeat.o(120163);
                        return dVar222;
                    }
                    dVar222 = n.a(n.a(o3, gVar3, z2), eVar, true, z3);
                    AppMethodBeat.o(120163);
                    return dVar222;
                }
            }
            z3 = true;
            if (a2 == null) {
            }
            if (a2 != null) {
            }
            dVar222 = n.a(a2, eVar, z4, z3);
            AppMethodBeat.o(120163);
            return dVar222;
        }
    }

    public l(a.i.b.a.c.d.a.a aVar, a.i.b.a.c.n.e eVar) {
        j.p(aVar, "annotationTypeQualifierResolver");
        j.p(eVar, "jsr305State");
        AppMethodBeat.i(120178);
        this.Bne = aVar;
        this.Bkf = eVar;
        AppMethodBeat.o(120178);
    }

    /* JADX WARNING: Missing block: B:8:0x002a, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(120171);
     */
    /* JADX WARNING: Missing block: B:10:0x0035, code skipped:
            if (r0.equals("MAYBE") != false) goto L_0x0037;
     */
    /* JADX WARNING: Missing block: B:11:0x0037, code skipped:
            r1 = new a.i.b.a.c.d.a.f.h(a.i.b.a.c.d.a.f.g.NULLABLE);
            com.tencent.matrix.trace.core.AppMethodBeat.o(120171);
     */
    /* JADX WARNING: Missing block: B:13:0x0049, code skipped:
            if (r0.equals("NEVER") != false) goto L_0x0037;
     */
    /* JADX WARNING: Missing block: B:21:?, code skipped:
            return null;
     */
    /* JADX WARNING: Missing block: B:22:?, code skipped:
            return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static h h(a.i.b.a.c.b.a.c cVar) {
        AppMethodBeat.i(120171);
        a.i.b.a.c.i.b.f m = a.i.b.a.c.i.c.a.m(cVar);
        if (!(m instanceof a.i.b.a.c.i.b.i)) {
            m = null;
        }
        a.i.b.a.c.i.b.i iVar = (a.i.b.a.c.i.b.i) m;
        h hVar;
        if (iVar != null) {
            String str = iVar.BES.name;
            switch (str.hashCode()) {
                case 73135176:
                    break;
                case 74175084:
                    break;
                case 433141802:
                    if (str.equals("UNKNOWN")) {
                        hVar = new h(g.FORCE_FLEXIBILITY);
                        AppMethodBeat.o(120171);
                        return hVar;
                    }
                    break;
                case 1933739535:
                    if (str.equals("ALWAYS")) {
                        hVar = new h(g.NOT_NULL);
                        AppMethodBeat.o(120171);
                        return hVar;
                    }
                    break;
            }
        }
        hVar = new h(g.NOT_NULL);
        AppMethodBeat.o(120171);
        return hVar;
    }

    public final h i(a.i.b.a.c.b.a.c cVar) {
        AppMethodBeat.i(120172);
        j.p(cVar, "annotationDescriptor");
        h j = j(cVar);
        if (j != null) {
            AppMethodBeat.o(120172);
            return j;
        }
        a.i.b.a.c.b.a.c d = this.Bne.d(cVar);
        if (d == null) {
            AppMethodBeat.o(120172);
            return null;
        }
        a.i.b.a.c.n.g f = this.Bne.f(cVar);
        if (f.ekz()) {
            AppMethodBeat.o(120172);
            return null;
        }
        j = j(d);
        if (j != null) {
            j = h.a(j, f.eky());
            AppMethodBeat.o(120172);
            return j;
        }
        AppMethodBeat.o(120172);
        return null;
    }

    private final h j(a.i.b.a.c.b.a.c cVar) {
        AppMethodBeat.i(120173);
        a.i.b.a.c.f.b dZF = cVar.dZF();
        h hVar;
        if (dZF == null) {
            AppMethodBeat.o(120173);
            return null;
        } else if (a.i.b.a.c.d.a.q.eaY().contains(dZF)) {
            hVar = new h(g.NULLABLE);
            AppMethodBeat.o(120173);
            return hVar;
        } else if (a.i.b.a.c.d.a.q.ebb().contains(dZF)) {
            hVar = new h(g.NOT_NULL);
            AppMethodBeat.o(120173);
            return hVar;
        } else if (j.j(dZF, a.i.b.a.c.d.a.q.eaZ())) {
            hVar = h(cVar);
            AppMethodBeat.o(120173);
            return hVar;
        } else if (j.j(dZF, a.i.b.a.c.d.a.q.ebc()) && this.Bkf.BNc) {
            hVar = new h(g.NULLABLE);
            AppMethodBeat.o(120173);
            return hVar;
        } else if (j.j(dZF, a.i.b.a.c.d.a.q.ebd()) && this.Bkf.BNc) {
            hVar = new h(g.NOT_NULL);
            AppMethodBeat.o(120173);
            return hVar;
        } else if (j.j(dZF, a.i.b.a.c.d.a.q.ebf())) {
            hVar = new h(g.NOT_NULL, true);
            AppMethodBeat.o(120173);
            return hVar;
        } else if (j.j(dZF, a.i.b.a.c.d.a.q.ebe())) {
            hVar = new h(g.NULLABLE, true);
            AppMethodBeat.o(120173);
            return hVar;
        } else {
            AppMethodBeat.o(120173);
            return null;
        }
    }

    public final <D extends a.i.b.a.c.b.b> Collection<D> a(h hVar, Collection<? extends D> collection) {
        AppMethodBeat.i(120174);
        j.p(hVar, "c");
        j.p(collection, "platformSignatures");
        Iterable<a.i.b.a.c.b.b> iterable = collection;
        Collection arrayList = new ArrayList(a.a.m.d(iterable));
        for (a.i.b.a.c.b.b a : iterable) {
            arrayList.add(a(a, hVar));
        }
        arrayList = (List) arrayList;
        AppMethodBeat.o(120174);
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:98:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0361  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0325  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x032a  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0364  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0361  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0262  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0325  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x032a  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <D extends a.i.b.a.c.b.b> D a(D d, h hVar) {
        AppMethodBeat.i(120175);
        if (d instanceof a.i.b.a.c.d.a.b.b) {
            a.i.b.a.c.b.b dYY;
            a.i.b.a.c.b.b bVar;
            D d2;
            a.i.b.a.c.d.a.b.e eVar;
            j jVar;
            Object obj;
            List dYV;
            Iterable<au> iterable;
            Collection arrayList;
            r rVar;
            List list;
            a.i.b.a.c.b.a.a aVar;
            ah ahVar;
            a.i.b.a.c.d.a.a.a aVar2;
            b a;
            a a2;
            Iterable<c> iterable2;
            Object obj2;
            if (((a.i.b.a.c.d.a.b.b) d).dYZ() == a.i.b.a.c.b.b.a.FAKE_OVERRIDE) {
                dYY = ((a.i.b.a.c.d.a.b.b) d).dYY();
                j.o(dYY, "original");
                if (dYY.dYX().size() == 1) {
                    AppMethodBeat.o(120175);
                    return d;
                }
            }
            h b = a.i.b.a.c.d.a.c.a.b(hVar, d.dYn());
            if (d instanceof a.i.b.a.c.d.a.b.f) {
                a.i.b.a.c.b.c.aa aaVar = ((a.i.b.a.c.d.a.b.f) d).Bjb;
                if (!(aaVar == null || aaVar.isDefault)) {
                    a a3;
                    aaVar = ((a.i.b.a.c.d.a.b.f) d).Bjb;
                    if (aaVar == null) {
                        j.dWJ();
                    }
                    j.o(aaVar, "getter!!");
                    bVar = aaVar;
                    if (((a.i.b.a.c.d.a.b.b) d).dYQ() == null) {
                        if (bVar instanceof a.i.b.a.c.b.t) {
                            dYY = bVar;
                        } else {
                            dYY = null;
                        }
                        a.i.b.a.c.b.t tVar = (a.i.b.a.c.b.t) dYY;
                        a3 = a(d, tVar != null ? (au) tVar.a(a.i.b.a.c.d.a.b.e.BmA) : null, b, d.Bqy).a(null);
                    } else {
                        a3 = null;
                    }
                    if (d instanceof a.i.b.a.c.d.a.b.e) {
                        d2 = null;
                    } else {
                        d2 = d;
                    }
                    eVar = (a.i.b.a.c.d.a.b.e) d2;
                    if (eVar != null) {
                        a.i.b.a.c.d.b.t tVar2 = a.i.b.a.c.d.b.t.BrJ;
                        a.i.b.a.c.b.l dXW = eVar.dXW();
                        v vVar;
                        if (dXW == null) {
                            vVar = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                            AppMethodBeat.o(120175);
                            throw vVar;
                        }
                        String a4 = a.i.b.a.c.d.b.t.a((a.i.b.a.c.b.e) dXW, r.a(eVar, false, false, 3));
                        if (a4 != null) {
                            jVar = (j) i.ecj().get(a4);
                            if (jVar != null) {
                                obj = jVar.Bqg.size() == ((a.i.b.a.c.d.a.b.b) d).dYV().size() ? 1 : null;
                                if (aa.AUz && obj == null) {
                                    Throwable assertionError = new AssertionError("Predefined enhancement info for " + d + " has " + jVar.Bqg.size() + ", but " + ((a.i.b.a.c.d.a.b.b) d).dYV().size() + " expected");
                                    AppMethodBeat.o(120175);
                                    throw assertionError;
                                }
                            }
                            dYV = bVar.dYV();
                            j.o(dYV, "annotationOwnerForMember.valueParameters");
                            iterable = dYV;
                            arrayList = new ArrayList(a.a.m.d(iterable));
                            for (au auVar : iterable) {
                                a a5;
                                g dYn;
                                a.i.b.a.c.f.b bVar2;
                                a.i.b.a.c.b.a.c i;
                                boolean z;
                                boolean z2;
                                b a6 = a(d, auVar, b, new f(auVar));
                                if (jVar != null) {
                                    dYV = jVar.Bqg;
                                    if (dYV != null) {
                                        w wVar;
                                        rVar = (r) a.a.t.x(dYV, auVar.getIndex());
                                        a5 = a6.a(rVar);
                                        if (a5.Bqi) {
                                            j.o(auVar, "p");
                                            w dZS = auVar.dZS();
                                            j.o(dZS, "p.type");
                                            wVar = dZS;
                                        } else {
                                            wVar = a5.AYl;
                                        }
                                        j.o(auVar, "p");
                                        j.p(auVar, "receiver$0");
                                        dYn = auVar.dYn();
                                        bVar2 = p.Bly;
                                        j.o(bVar2, "JvmAnnotationNames.DEFAULT_VALUE_FQ_NAME");
                                        i = dYn.i(bVar2);
                                        if (i != null) {
                                            a.i.b.a.c.i.b.f m = a.i.b.a.c.i.c.a.m(i);
                                            if (m != null) {
                                                if (!(m instanceof s)) {
                                                    m = null;
                                                }
                                                s sVar = (s) m;
                                                if (sVar != null) {
                                                    a4 = (String) sVar.getValue();
                                                    if (a4 != null) {
                                                        obj = new a.i.b.a.c.d.a.b.h(a4);
                                                        if (obj instanceof a.i.b.a.c.d.a.b.h) {
                                                            z = u.a(wVar, ((a.i.b.a.c.d.a.b.h) obj).value) != null;
                                                        } else if (j.j(obj, a.i.b.a.c.d.a.b.g.BmL)) {
                                                            z = av.aC(wVar);
                                                        } else if (obj == null) {
                                                            z = auVar.dZU();
                                                        } else {
                                                            a.m mVar = new a.m();
                                                            AppMethodBeat.o(120175);
                                                            throw mVar;
                                                        }
                                                        if (z || !auVar.dYX().isEmpty()) {
                                                            z = false;
                                                        } else {
                                                            z = true;
                                                        }
                                                        z2 = a5.Bqi || z != auVar.dZU();
                                                        arrayList.add(new c(a5.AYl, z, z2, a5.Bqj));
                                                    }
                                                }
                                            }
                                        }
                                        dYn = auVar.dYn();
                                        bVar2 = p.Blz;
                                        j.o(bVar2, "JvmAnnotationNames.DEFAULT_NULL_FQ_NAME");
                                        if (dYn.j(bVar2)) {
                                            obj = null;
                                        } else {
                                            a.i.b.a.c.d.a.b.a aVar3 = a.i.b.a.c.d.a.b.g.BmL;
                                        }
                                        if (obj instanceof a.i.b.a.c.d.a.b.h) {
                                        }
                                        if (z) {
                                        }
                                        z = false;
                                        if (!a5.Bqi) {
                                        }
                                        arrayList.add(new c(a5.AYl, z, z2, a5.Bqj));
                                    }
                                }
                                rVar = null;
                                a5 = a6.a(rVar);
                                if (a5.Bqi) {
                                }
                                j.o(auVar, "p");
                                j.p(auVar, "receiver$0");
                                dYn = auVar.dYn();
                                bVar2 = p.Bly;
                                j.o(bVar2, "JvmAnnotationNames.DEFAULT_VALUE_FQ_NAME");
                                i = dYn.i(bVar2);
                                if (i != null) {
                                }
                                dYn = auVar.dYn();
                                bVar2 = p.Blz;
                                j.o(bVar2, "JvmAnnotationNames.DEFAULT_NULL_FQ_NAME");
                                if (dYn.j(bVar2)) {
                                }
                                if (obj instanceof a.i.b.a.c.d.a.b.h) {
                                }
                                if (z) {
                                }
                                z = false;
                                if (a5.Bqi) {
                                }
                                arrayList.add(new c(a5.AYl, z, z2, a5.Bqj));
                            }
                            list = (List) arrayList;
                            aVar = bVar;
                            if (d instanceof ah) {
                                d2 = d;
                            } else {
                                d2 = null;
                            }
                            ahVar = (ah) d2;
                            if (ahVar == null && a.i.b.a.c.d.a.c.a.c.e(ahVar)) {
                                aVar2 = a.i.b.a.c.d.a.a.a.FIELD;
                            } else {
                                aVar2 = a.i.b.a.c.d.a.a.a.METHOD_RETURN_TYPE;
                            }
                            a = a(d, aVar, true, b, aVar2, e.Bqz);
                            if (jVar != null) {
                                rVar = jVar.Bqf;
                            } else {
                                rVar = null;
                            }
                            a2 = a.a(rVar);
                            if ((a3 == null || !a3.Bqj) && !a2.Bqj) {
                                iterable2 = list;
                                if (!((Collection) iterable2).isEmpty()) {
                                    for (c cVar : iterable2) {
                                        if (cVar.Bqj) {
                                            obj = 1;
                                            break;
                                        }
                                    }
                                }
                                obj = null;
                                if (obj == null) {
                                    o I;
                                    w wVar2;
                                    obj2 = null;
                                    if ((a3 == null || !a3.Bqi) && !a2.Bqi) {
                                        iterable2 = list;
                                        if (!((Collection) iterable2).isEmpty()) {
                                            for (c cVar2 : iterable2) {
                                                if (cVar2.Bqi) {
                                                    obj = 1;
                                                    break;
                                                }
                                            }
                                        }
                                        obj = null;
                                        if (obj == null && obj2 == null) {
                                            AppMethodBeat.o(120175);
                                            return d;
                                        }
                                    }
                                    if (obj2 != null) {
                                        I = a.u.I(a.i.b.a.c.i.a.ejr(), new a.i.b.a.c.d.a.g((a.i.b.a.c.b.l) d));
                                    } else {
                                        I = null;
                                    }
                                    a.i.b.a.c.d.a.b.b bVar3 = (a.i.b.a.c.d.a.b.b) d;
                                    if (a3 != null) {
                                        wVar2 = a3.AYl;
                                    } else {
                                        wVar2 = null;
                                    }
                                    Iterable<c> iterable3 = list;
                                    Collection arrayList2 = new ArrayList(a.a.m.d(iterable3));
                                    for (c cVar3 : iterable3) {
                                        arrayList2.add(new a.i.b.a.c.d.a.b.j(cVar3.AYl, cVar3.BmM));
                                    }
                                    a.i.b.a.c.d.a.b.b a7 = bVar3.a(wVar2, (List) arrayList2, a2.AYl, I);
                                    if (a7 == null) {
                                        vVar = new v("null cannot be cast to non-null type D");
                                        AppMethodBeat.o(120175);
                                        throw vVar;
                                    }
                                    d2 = a7;
                                    AppMethodBeat.o(120175);
                                    return d2;
                                }
                            }
                            obj2 = 1;
                            iterable2 = list;
                            if (((Collection) iterable2).isEmpty()) {
                            }
                            obj = null;
                            AppMethodBeat.o(120175);
                            return d;
                        }
                    }
                    jVar = null;
                    if (jVar != null) {
                    }
                    dYV = bVar.dYV();
                    j.o(dYV, "annotationOwnerForMember.valueParameters");
                    iterable = dYV;
                    arrayList = new ArrayList(a.a.m.d(iterable));
                    for (au auVar2 : iterable) {
                    }
                    list = (List) arrayList;
                    aVar = bVar;
                    if (d instanceof ah) {
                    }
                    ahVar = (ah) d2;
                    if (ahVar == null) {
                    }
                    aVar2 = a.i.b.a.c.d.a.a.a.METHOD_RETURN_TYPE;
                    a = a(d, aVar, true, b, aVar2, e.Bqz);
                    if (jVar != null) {
                    }
                    a2 = a.a(rVar);
                    iterable2 = list;
                    if (((Collection) iterable2).isEmpty()) {
                    }
                    obj = null;
                    if (obj == null) {
                    }
                    obj2 = 1;
                    iterable2 = list;
                    if (((Collection) iterable2).isEmpty()) {
                    }
                    obj = null;
                    AppMethodBeat.o(120175);
                    return d;
                }
            }
            D bVar4 = d;
            if (((a.i.b.a.c.d.a.b.b) d).dYQ() == null) {
            }
            if (d instanceof a.i.b.a.c.d.a.b.e) {
            }
            eVar = (a.i.b.a.c.d.a.b.e) d2;
            if (eVar != null) {
            }
            jVar = null;
            if (jVar != null) {
            }
            dYV = bVar4.dYV();
            j.o(dYV, "annotationOwnerForMember.valueParameters");
            iterable = dYV;
            arrayList = new ArrayList(a.a.m.d(iterable));
            for (au auVar22 : iterable) {
            }
            list = (List) arrayList;
            aVar = bVar4;
            if (d instanceof ah) {
            }
            ahVar = (ah) d2;
            if (ahVar == null) {
            }
            aVar2 = a.i.b.a.c.d.a.a.a.METHOD_RETURN_TYPE;
            a = a(d, aVar, true, b, aVar2, e.Bqz);
            if (jVar != null) {
            }
            a2 = a.a(rVar);
            iterable2 = list;
            if (((Collection) iterable2).isEmpty()) {
            }
            obj = null;
            if (obj == null) {
            }
            obj2 = 1;
            iterable2 = list;
            if (((Collection) iterable2).isEmpty()) {
            }
            obj = null;
            AppMethodBeat.o(120175);
            return d;
        }
        AppMethodBeat.o(120175);
        return d;
    }

    private final b a(a.i.b.a.c.b.b bVar, au auVar, h hVar, a.f.a.b<? super a.i.b.a.c.b.b, ? extends w> bVar2) {
        h b;
        a.i.b.a.c.b.b bVar3;
        l lVar;
        b a;
        AppMethodBeat.i(120176);
        a.i.b.a.c.b.a.a aVar = auVar;
        if (auVar != null) {
            b = a.i.b.a.c.d.a.c.a.b(hVar, auVar.dYn());
            if (b != null) {
                bVar3 = bVar;
                lVar = this;
                a = lVar.a(bVar3, aVar, false, b, a.i.b.a.c.d.a.a.a.VALUE_PARAMETER, bVar2);
                AppMethodBeat.o(120176);
                return a;
            }
        }
        b = hVar;
        bVar3 = bVar;
        lVar = this;
        a = lVar.a(bVar3, aVar, false, b, a.i.b.a.c.d.a.a.a.VALUE_PARAMETER, bVar2);
        AppMethodBeat.o(120176);
        return a;
    }

    private final b a(a.i.b.a.c.b.b bVar, a.i.b.a.c.b.a.a aVar, boolean z, h hVar, a.i.b.a.c.d.a.a.a aVar2, a.f.a.b<? super a.i.b.a.c.b.b, ? extends w> bVar2) {
        AppMethodBeat.i(120177);
        w wVar = (w) bVar2.am(bVar);
        Collection dYX = bVar.dYX();
        j.o(dYX, "this.overriddenDescriptors");
        Iterable<a.i.b.a.c.b.b> iterable = dYX;
        Collection arrayList = new ArrayList(a.a.m.d(iterable));
        for (a.i.b.a.c.b.b bVar3 : iterable) {
            j.o(bVar3, "it");
            arrayList.add((w) bVar2.am(bVar3));
        }
        b bVar4 = new b(this, aVar, wVar, (List) arrayList, z, a.i.b.a.c.d.a.c.a.b(hVar, ((w) bVar2.am(bVar)).dYn()), aVar2);
        AppMethodBeat.o(120177);
        return bVar4;
    }
}
