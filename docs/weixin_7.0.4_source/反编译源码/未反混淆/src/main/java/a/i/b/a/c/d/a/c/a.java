package a.i.b.a.c.d.a.c;

import a.f;
import a.f.b.j;
import a.f.b.k;
import a.i;
import a.i.b.a.c.b.a.c;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.l;
import a.i.b.a.c.d.a.e.x;
import a.i.b.a.c.d.a.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;

public final class a {

    static final class b extends k implements a.f.a.a<d> {
        final /* synthetic */ h BmP;
        final /* synthetic */ g BmQ;

        b(h hVar, g gVar) {
            this.BmP = hVar;
            this.BmQ = gVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119817);
            d a = a.a(this.BmP, this.BmQ);
            AppMethodBeat.o(119817);
            return a;
        }
    }

    static final class a extends k implements a.f.a.a<d> {
        final /* synthetic */ h BmN;
        final /* synthetic */ a.i.b.a.c.b.g BmO;

        a(h hVar, a.i.b.a.c.b.g gVar) {
            this.BmN = hVar;
            this.BmO = gVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119816);
            d a = a.a(this.BmN, this.BmO.dYn());
            AppMethodBeat.o(119816);
            return a;
        }
    }

    public static final h b(h hVar, g gVar) {
        AppMethodBeat.i(119822);
        j.p(hVar, "receiver$0");
        j.p(gVar, "additionalAnnotations");
        if (gVar.isEmpty()) {
            AppMethodBeat.o(119822);
            return hVar;
        }
        h hVar2 = new h(hVar.Bnv, hVar.Bnw, i.a(a.k.NONE, new b(hVar, gVar)));
        AppMethodBeat.o(119822);
        return hVar2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x012a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final d a(h hVar, g gVar) {
        AppMethodBeat.i(119818);
        j.p(hVar, "receiver$0");
        j.p(gVar, "additionalAnnotations");
        d ebm;
        if (hVar.Bnv.Bne.Bke) {
            ebm = hVar.ebm();
            AppMethodBeat.o(119818);
            return ebm;
        }
        Object obj;
        Collection arrayList = new ArrayList();
        for (c cVar : gVar) {
            k kVar;
            a.i.b.a.c.d.a.a aVar = hVar.Bnv.Bne;
            j.p(cVar, "annotationDescriptor");
            if (aVar.Bkf.ekx()) {
                obj = null;
            } else {
                kVar = (k) a.i.b.a.c.d.a.b.Bkr.get(cVar.dZF());
                if (kVar != null) {
                    h hVar2 = kVar.BnC;
                    Collection collection = kVar.BnD;
                    a.i.b.a.c.n.g f = aVar.f(cVar);
                    a.i.b.a.c.n.g gVar2 = (f != a.i.b.a.c.n.g.IGNORE ? 1 : null) != null ? f : null;
                    obj = gVar2 == null ? null : new k(h.a(hVar2, gVar2.eky()), collection);
                } else {
                    obj = null;
                }
            }
            if (obj == null) {
                a.i.b.a.c.d.a.a.b e = aVar.e(cVar);
                if (e == null) {
                    obj = null;
                } else {
                    c cVar2 = e.Bkl;
                    List eaP = e.eaP();
                    a.i.b.a.c.n.g g = aVar.g(cVar);
                    if (g == null) {
                        g = aVar.f(cVar2);
                    }
                    if (g.ekz()) {
                        obj = null;
                    } else {
                        h i = hVar.Bnv.Bnf.i(cVar2);
                        if (i != null) {
                            i = h.a(i, g.eky());
                            if (i != null) {
                                kVar = new k(i, eaP);
                            }
                        }
                        obj = null;
                    }
                }
            }
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        List<k> list = (List) arrayList;
        if (list.isEmpty()) {
            ebm = hVar.ebm();
            AppMethodBeat.o(119818);
            return ebm;
        }
        EnumMap enumMap;
        d ebm2 = hVar.ebm();
        if (ebm2 != null) {
            EnumMap enumMap2 = ebm2.Bnl;
            if (enumMap2 != null) {
                enumMap = new EnumMap(enumMap2);
                obj = null;
                for (k kVar2 : list) {
                    h hVar3 = kVar2.BnC;
                    Object obj2 = obj;
                    for (a.i.b.a.c.d.a.a.a put : kVar2.BnD) {
                        enumMap.put(put, hVar3);
                        int obj22 = 1;
                    }
                    obj = obj22;
                }
                if (obj != null) {
                    ebm = hVar.ebm();
                    AppMethodBeat.o(119818);
                    return ebm;
                }
                ebm = new d(enumMap);
                AppMethodBeat.o(119818);
                return ebm;
            }
        }
        enumMap = new EnumMap(a.i.b.a.c.d.a.a.a.class);
        obj = null;
        for (k kVar22 : list) {
        }
        if (obj != null) {
        }
    }

    private static final h a(h hVar, l lVar, x xVar, int i, f<d> fVar) {
        m iVar;
        AppMethodBeat.i(119819);
        b bVar = hVar.Bnv;
        if (xVar != null) {
            iVar = new i(hVar, lVar, xVar, i);
        } else {
            iVar = hVar.Bnw;
        }
        h hVar2 = new h(bVar, iVar, fVar);
        AppMethodBeat.o(119819);
        return hVar2;
    }

    public static final h a(h hVar, l lVar, x xVar, int i) {
        AppMethodBeat.i(119820);
        j.p(hVar, "receiver$0");
        j.p(lVar, "containingDeclaration");
        j.p(xVar, "typeParameterOwner");
        h a = a(hVar, lVar, xVar, i, hVar.Bnx);
        AppMethodBeat.o(119820);
        return a;
    }
}
