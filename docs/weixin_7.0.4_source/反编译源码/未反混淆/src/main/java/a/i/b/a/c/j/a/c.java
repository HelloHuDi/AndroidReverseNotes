package a.i.b.a.c.j.a;

import a.a.ag;
import a.a.m;
import a.f.b.j;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.aa;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.y;
import a.i.b.a.c.e.a.a.a.b;
import a.i.b.a.c.f.a;
import a.i.b.a.c.i.b.d;
import a.i.b.a.c.i.b.e;
import a.i.b.a.c.i.b.f;
import a.i.b.a.c.i.b.h;
import a.i.b.a.c.i.b.i;
import a.i.b.a.c.i.b.k;
import a.i.b.a.c.i.b.l;
import a.i.b.a.c.i.b.o;
import a.i.b.a.c.i.b.p;
import a.i.b.a.c.i.b.r;
import a.i.b.a.c.i.b.s;
import a.i.b.a.c.i.b.t;
import a.i.b.a.c.i.b.u;
import a.i.b.a.c.i.b.v;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.ar;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.w;
import a.i.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class c {
    private final y BcH;
    private final aa Bcm;

    public c(y yVar, aa aaVar) {
        j.p(yVar, "module");
        j.p(aaVar, "notFoundClasses");
        AppMethodBeat.i(122247);
        this.BcH = yVar;
        this.Bcm = aaVar;
        AppMethodBeat.o(122247);
    }

    private final g dZD() {
        AppMethodBeat.i(122242);
        g dZD = this.BcH.dZD();
        AppMethodBeat.o(122242);
        return dZD;
    }

    /* JADX WARNING: Missing block: B:11:0x0085, code skipped:
            if (a.i.b.a.c.l.c.a.c(r0.b(r10.BcH), r11) == false) goto L_0x0368;
     */
    /* JADX WARNING: Missing block: B:12:0x0087, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(122245);
     */
    /* JADX WARNING: Missing block: B:61:0x020f, code skipped:
            r0 = dZD().m(r2);
     */
    /* JADX WARNING: Missing block: B:62:0x021a, code skipped:
            if (r0 == null) goto L_0x0320;
     */
    /* JADX WARNING: Missing block: B:63:0x021c, code skipped:
            r2 = r0;
     */
    /* JADX WARNING: Missing block: B:85:0x0320, code skipped:
            r0 = dZD().a(a.i.b.a.c.l.ba.INVARIANT, (a.i.b.a.c.l.w) r2);
            a.f.b.j.o(r0, "builtIns.getArrayType(Va…RIANT, actualElementType)");
            r2 = r0;
     */
    /* JADX WARNING: Missing block: B:91:0x0368, code skipped:
            r1 = a.i.b.a.c.i.b.j.BET;
            r0 = a.i.b.a.c.i.b.j.a.awi("Unexpected argument value: type " + r0.b(r10.BcH) + " is not a subtype of " + r11 + " (value.type = " + r12.BsM + ')');
            com.tencent.matrix.trace.core.AppMethodBeat.o(122245);
     */
    /* JADX WARNING: Missing block: B:94:?, code skipped:
            return r0;
     */
    /* JADX WARNING: Missing block: B:95:?, code skipped:
            return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private f<?> a(w wVar, b bVar, a.i.b.a.c.e.a.c cVar) {
        Throwable illegalStateException;
        int i = 1;
        int i2 = 0;
        AppMethodBeat.i(122245);
        j.p(wVar, "expectedType");
        j.p(bVar, "value");
        j.p(cVar, "nameResolver");
        Boolean Ug = a.i.b.a.c.e.a.b.Bxd.Ug(bVar.BsW);
        j.o(Ug, "Flags.IS_UNSIGNED.get(value.flags)");
        boolean booleanValue = Ug.booleanValue();
        b.b bVar2 = bVar.BsM;
        if (bVar2 != null) {
            f tVar;
            int i3;
            ad dZf;
            w aN;
            switch (d.eQZ[bVar2.ordinal()]) {
                case 1:
                    byte b = (byte) ((int) bVar.BsN);
                    tVar = booleanValue ? new t(b) : new d(b);
                    break;
                case 2:
                    tVar = new e((char) ((int) bVar.BsN));
                    break;
                case 3:
                    a.i.b.a.c.i.b.w wVar2;
                    short s = (short) ((int) bVar.BsN);
                    if (booleanValue) {
                        wVar2 = new a.i.b.a.c.i.b.w(s);
                    } else {
                        wVar2 = new r(s);
                    }
                    tVar = wVar2;
                    break;
                case 4:
                    u uVar;
                    i3 = (int) bVar.BsN;
                    if (booleanValue) {
                        uVar = new u(i3);
                    } else {
                        uVar = new l(i3);
                    }
                    tVar = uVar;
                    break;
                case 5:
                    long j = bVar.BsN;
                    tVar = booleanValue ? new v(j) : new p(j);
                    break;
                case 6:
                    tVar = new k(bVar.BsO);
                    break;
                case 7:
                    tVar = new h(bVar.BsP);
                    break;
                case 8:
                    tVar = new a.i.b.a.c.i.b.c(bVar.BsN != 0);
                    break;
                case 9:
                    tVar = new s(cVar.getString(bVar.BsQ));
                    break;
                case 10:
                    a a = r.a(cVar, bVar.BsR);
                    i3 = bVar.BsV;
                    dZf = f(a).dZf();
                    j.o(dZf, "resolveClass(classId).defaultType");
                    aN = a.i.b.a.c.l.c.a.aN(dZf);
                    while (i2 < i3) {
                        dZf = dZD().a(ba.INVARIANT, aN);
                        j.o(dZf, "builtIns.getArrayType(Variance.INVARIANT, type)");
                        aN = dZf;
                        i2++;
                    }
                    a n = a.n(g.Bag.Bbo.ehI());
                    j.o(n, "ClassId.topLevel(KotlinB…FQ_NAMES.kClass.toSafe())");
                    a.i.b.a.c.b.e f = f(n);
                    a.i.b.a.c.b.a.g.a aVar = a.i.b.a.c.b.a.g.BfJ;
                    tVar = new o(x.a(a.i.b.a.c.b.a.g.a.eai(), f, a.a.k.listOf(new ar(aN))));
                    break;
                case 11:
                    tVar = new i(r.a(cVar, bVar.BsR), r.b(cVar, bVar.BsS));
                    break;
                case 12:
                    a.i.b.a.c.e.a.a aVar2 = bVar.BsT;
                    j.o(aVar2, "value.annotation");
                    tVar = new a.i.b.a.c.i.b.a(b(aVar2, cVar));
                    break;
                case 13:
                    int i4;
                    w wVar3;
                    if (g.n(wVar) || g.o(wVar)) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    List list = bVar.BsU;
                    j.o(list, "arrayElements");
                    if (list.isEmpty()) {
                        i = 0;
                    }
                    if (i != 0) {
                        Object fJ = a.a.t.fJ(list);
                        j.o(fJ, "arrayElements.first()");
                        b bVar3 = (b) fJ;
                        g dZD = dZD();
                        b.b bVar4 = bVar3.BsM;
                        if (bVar4 != null) {
                            ad a2;
                            switch (d.pCY[bVar4.ordinal()]) {
                                case 1:
                                    a2 = dZD.a(a.i.b.a.c.a.h.BYTE);
                                    j.o(a2, "byteType");
                                    break;
                                case 2:
                                    a2 = dZD.a(a.i.b.a.c.a.h.CHAR);
                                    j.o(a2, "charType");
                                    break;
                                case 3:
                                    a2 = dZD.a(a.i.b.a.c.a.h.SHORT);
                                    j.o(a2, "shortType");
                                    break;
                                case 4:
                                    a2 = dZD.a(a.i.b.a.c.a.h.INT);
                                    j.o(a2, "intType");
                                    break;
                                case 5:
                                    a2 = dZD.a(a.i.b.a.c.a.h.LONG);
                                    j.o(a2, "longType");
                                    break;
                                case 6:
                                    a2 = dZD.a(a.i.b.a.c.a.h.FLOAT);
                                    j.o(a2, "floatType");
                                    break;
                                case 7:
                                    a2 = dZD.a(a.i.b.a.c.a.h.DOUBLE);
                                    j.o(a2, "doubleType");
                                    break;
                                case 8:
                                    a2 = dZD.a(a.i.b.a.c.a.h.BOOLEAN);
                                    j.o(a2, "booleanType");
                                    break;
                                case 9:
                                    a2 = dZD.dXP();
                                    j.o(a2, "stringType");
                                    break;
                                case 10:
                                    illegalStateException = new IllegalStateException("Arrays of class literals are not supported yet".toString());
                                    AppMethodBeat.o(122245);
                                    throw illegalStateException;
                                case 11:
                                    a2 = f(r.a(cVar, bVar3.BsR)).dZf();
                                    j.o(a2, "resolveClass(nameResolve…lue.classId)).defaultType");
                                    break;
                                case 12:
                                    a.i.b.a.c.e.a.a aVar3 = bVar3.BsT;
                                    j.o(aVar3, "value.annotation");
                                    a2 = f(r.a(cVar, aVar3.BsE)).dZf();
                                    j.o(a2, "resolveClass(nameResolve…notation.id)).defaultType");
                                    break;
                                case 13:
                                    illegalStateException = new IllegalStateException("Array of arrays is impossible".toString());
                                    AppMethodBeat.o(122245);
                                    throw illegalStateException;
                            }
                        }
                        illegalStateException = new IllegalStateException(("Unknown type: " + bVar3.BsM).toString());
                        AppMethodBeat.o(122245);
                        throw illegalStateException;
                    } else if (i4 != 0) {
                        wVar3 = wVar;
                    } else {
                        dZf = dZD().a(ba.INVARIANT, (w) dZD().dXM());
                        j.o(dZf, "builtIns.getArrayType(Va…ARIANT, builtIns.anyType)");
                        wVar3 = dZf;
                    }
                    g dZD2 = dZD();
                    if (i4 != 0) {
                        aN = wVar;
                    } else {
                        aN = wVar3;
                    }
                    w l = dZD2.l(aN);
                    j.o(l, "builtIns.getArrayElement…ype else actualArrayType)");
                    a.i.b.a.c.i.b.g gVar = a.i.b.a.c.i.b.g.BEO;
                    Iterable<b> iterable = list;
                    Collection arrayList = new ArrayList(m.d(iterable));
                    for (b bVar5 : iterable) {
                        j.o(bVar5, "it");
                        arrayList.add(a(l, bVar5, cVar));
                    }
                    tVar = a.i.b.a.c.i.b.g.a((List) arrayList, wVar3);
                    break;
            }
        }
        illegalStateException = new IllegalStateException(("Unsupported annotation argument type: " + bVar.BsM + " (expected " + wVar + ')').toString());
        AppMethodBeat.o(122245);
        throw illegalStateException;
    }

    private final a.i.b.a.c.b.e f(a aVar) {
        AppMethodBeat.i(122246);
        a.i.b.a.c.b.e a = a.i.b.a.c.b.s.a(this.BcH, aVar, this.Bcm);
        AppMethodBeat.o(122246);
        return a;
    }

    public final a.i.b.a.c.b.a.c b(a.i.b.a.c.e.a.a aVar, a.i.b.a.c.e.a.c cVar) {
        Map v;
        a.i.b.a.c.b.a.c dVar;
        AppMethodBeat.i(122243);
        j.p(aVar, "proto");
        j.p(cVar, "nameResolver");
        a.i.b.a.c.b.e f = f(r.a(cVar, aVar.BsE));
        Map emptyMap = ag.emptyMap();
        if (!(aVar.getArgumentCount() == 0 || a.i.b.a.c.l.p.L(f) || !a.i.b.a.c.i.d.z(f))) {
            Collection dYb = f.dYb();
            j.o(dYb, "annotationClass.constructors");
            a.i.b.a.c.b.d dVar2 = (a.i.b.a.c.b.d) a.a.t.i((Iterable) dYb);
            if (dVar2 != null) {
                List dYV = dVar2.dYV();
                j.o(dYV, "constructor.valueParameters");
                Iterable iterable = dYV;
                emptyMap = new LinkedHashMap(a.h.h.im(ag.SI(m.d(iterable)), 16));
                for (Object next : iterable) {
                    au auVar = (au) next;
                    j.o(auVar, "it");
                    emptyMap.put(auVar.dZg(), next);
                }
                List<a.i.b.a.c.e.a.a.a> list = aVar.BsF;
                j.o(list, "proto.argumentList");
                Collection arrayList = new ArrayList();
                for (a.i.b.a.c.e.a.a.a aVar2 : list) {
                    j.o(aVar2, "it");
                    a.o a = a(aVar2, emptyMap, cVar);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                v = ag.v((List) arrayList);
                dVar = new a.i.b.a.c.b.a.d(f.dZf(), v, am.BeR);
                AppMethodBeat.o(122243);
                return dVar;
            }
        }
        v = emptyMap;
        dVar = new a.i.b.a.c.b.a.d(f.dZf(), v, am.BeR);
        AppMethodBeat.o(122243);
        return dVar;
    }

    private final a.o<a.i.b.a.c.f.f, f<?>> a(a.i.b.a.c.e.a.a.a aVar, Map<a.i.b.a.c.f.f, ? extends au> map, a.i.b.a.c.e.a.c cVar) {
        AppMethodBeat.i(122244);
        au auVar = (au) map.get(r.b(cVar, aVar.BsJ));
        if (auVar == null) {
            AppMethodBeat.o(122244);
            return null;
        }
        a.i.b.a.c.f.f b = r.b(cVar, aVar.BsJ);
        w dZS = auVar.dZS();
        j.o(dZS, "parameter.type");
        b bVar = aVar.BsK;
        j.o(bVar, "proto.value");
        a.o<a.i.b.a.c.f.f, f<?>> oVar = new a.o(b, a(dZS, bVar, cVar));
        AppMethodBeat.o(122244);
        return oVar;
    }
}
