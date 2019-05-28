package a.i.b.a.c.d.a.c.a;

import a.a.t;
import a.f.a.b;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.d.a.e.g;
import a.i.b.a.c.d.a.e.i;
import a.i.b.a.c.d.a.e.n;
import a.i.b.a.c.d.a.e.p;
import a.i.b.a.c.d.a.e.q;
import a.i.b.a.c.d.a.e.v;
import a.i.b.a.c.d.a.e.y;
import a.i.b.a.c.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a implements b {
    private final b<q, Boolean> BnG = new a(this);
    private final Map<f, List<q>> BnH;
    private final Map<f, n> BnI;
    private final g BnJ;
    final b<p, Boolean> BnK;

    static final class a extends k implements b<q, Boolean> {
        final /* synthetic */ a BnL;

        a(a aVar) {
            this.BnL = aVar;
            super(1);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0057  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ Object am(Object obj) {
            boolean isEmpty;
            Boolean valueOf;
            AppMethodBeat.i(119853);
            q qVar = (q) obj;
            j.p(qVar, "m");
            if (((Boolean) this.BnL.BnK.am(qVar)).booleanValue()) {
                int i;
                p pVar = qVar;
                if (pVar.ebU().isInterface() && (pVar instanceof q)) {
                    qVar = (q) pVar;
                    String str = qVar.dZg().name;
                    if (str.equals("toString") || str.equals("hashCode")) {
                        isEmpty = qVar.dYV().isEmpty();
                    } else if (str.equals("equals")) {
                        String str2 = "java.lang.Object";
                        List dYV = qVar.dYV();
                        if (dYV.size() == 1) {
                            v ebT = ((y) dYV.get(0)).ebT();
                            if (ebT instanceof a.i.b.a.c.d.a.e.j) {
                                i ebL = ((a.i.b.a.c.d.a.e.j) ebT).ebL();
                                if (ebL instanceof g) {
                                    a.i.b.a.c.f.b dZF = ((g) ebL).dZF();
                                    isEmpty = dZF != null && dZF.ByQ.ByV.equals(str2);
                                }
                            }
                        }
                        isEmpty = false;
                    } else {
                        isEmpty = false;
                    }
                    if (isEmpty) {
                        i = 1;
                        if (i == 0) {
                            isEmpty = true;
                            valueOf = Boolean.valueOf(isEmpty);
                            AppMethodBeat.o(119853);
                            return valueOf;
                        }
                    }
                }
                i = 0;
                if (i == 0) {
                }
            }
            isEmpty = false;
            valueOf = Boolean.valueOf(isEmpty);
            AppMethodBeat.o(119853);
            return valueOf;
        }
    }

    public a(g gVar, b<? super p, Boolean> bVar) {
        j.p(gVar, "jClass");
        j.p(bVar, "memberFilter");
        AppMethodBeat.i(119858);
        this.BnJ = gVar;
        this.BnK = bVar;
        Map linkedHashMap = new LinkedHashMap();
        for (Object next : a.j.n.a(t.t(this.BnJ.ebI()), this.BnG)) {
            f dZg = ((q) next).dZg();
            ArrayList arrayList = linkedHashMap.get(dZg);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(dZg, arrayList);
            }
            arrayList.add(next);
        }
        this.BnH = linkedHashMap;
        linkedHashMap = new LinkedHashMap();
        for (Object next2 : a.j.n.a(t.t(this.BnJ.ebJ()), this.BnK)) {
            linkedHashMap.put(((n) next2).dZg(), next2);
        }
        this.BnI = linkedHashMap;
        AppMethodBeat.o(119858);
    }

    public final Collection<q> k(f fVar) {
        AppMethodBeat.i(119854);
        j.p(fVar, "name");
        List list = (List) this.BnH.get(fVar);
        if (list != null) {
            Collection collection = list;
            AppMethodBeat.o(119854);
            return collection;
        }
        Collection<q> collection2 = a.a.v.AUP;
        AppMethodBeat.o(119854);
        return collection2;
    }

    public final Set<f> ebn() {
        AppMethodBeat.i(119855);
        Collection linkedHashSet = new LinkedHashSet();
        for (q dZg : a.j.n.a(t.t(this.BnJ.ebI()), this.BnG)) {
            linkedHashSet.add(dZg.dZg());
        }
        Set set = (Set) linkedHashSet;
        AppMethodBeat.o(119855);
        return set;
    }

    public final n l(f fVar) {
        AppMethodBeat.i(119856);
        j.p(fVar, "name");
        n nVar = (n) this.BnI.get(fVar);
        AppMethodBeat.o(119856);
        return nVar;
    }

    public final Set<f> ebo() {
        AppMethodBeat.i(119857);
        Collection linkedHashSet = new LinkedHashSet();
        for (n dZg : a.j.n.a(t.t(this.BnJ.ebJ()), this.BnK)) {
            linkedHashSet.add(dZg.dZg());
        }
        Set set = (Set) linkedHashSet;
        AppMethodBeat.o(119857);
        return set;
    }
}
