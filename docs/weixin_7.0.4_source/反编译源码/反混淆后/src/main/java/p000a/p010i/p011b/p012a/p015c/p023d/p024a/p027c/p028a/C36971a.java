package p000a.p010i.p011b.p012a.p015c.p023d.p024a.p027c.p028a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p000a.p001a.C17115v;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C31674y;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C36984i;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C36985p;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C44635g;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C44886j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C44887q;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C8117n;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C8118v;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;
import p000a.p050j.C17348n;

/* renamed from: a.i.b.a.c.d.a.c.a.a */
public final class C36971a implements C41406b {
    private final C17126b<C44887q, Boolean> BnG = new C36972a(this);
    private final Map<C37022f, List<C44887q>> BnH;
    private final Map<C37022f, C8117n> BnI;
    private final C44635g BnJ;
    final C17126b<C36985p, Boolean> BnK;

    /* renamed from: a.i.b.a.c.d.a.c.a.a$a */
    static final class C36972a extends C25053k implements C17126b<C44887q, Boolean> {
        final /* synthetic */ C36971a BnL;

        C36972a(C36971a c36971a) {
            this.BnL = c36971a;
            super(1);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0057  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            boolean isEmpty;
            Boolean valueOf;
            AppMethodBeat.m2504i(119853);
            C44887q c44887q = (C44887q) obj;
            C25052j.m39376p(c44887q, "m");
            if (((Boolean) this.BnL.BnK.mo50am(c44887q)).booleanValue()) {
                int i;
                C36985p c36985p = c44887q;
                if (c36985p.ebU().isInterface() && (c36985p instanceof C44887q)) {
                    c44887q = (C44887q) c36985p;
                    String str = c44887q.dZg().name;
                    if (str.equals("toString") || str.equals("hashCode")) {
                        isEmpty = c44887q.dYV().isEmpty();
                    } else if (str.equals("equals")) {
                        String str2 = "java.lang.Object";
                        List dYV = c44887q.dYV();
                        if (dYV.size() == 1) {
                            C8118v ebT = ((C31674y) dYV.get(0)).ebT();
                            if (ebT instanceof C44886j) {
                                C36984i ebL = ((C44886j) ebT).ebL();
                                if (ebL instanceof C44635g) {
                                    C8174b dZF = ((C44635g) ebL).dZF();
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
                            AppMethodBeat.m2505o(119853);
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
            AppMethodBeat.m2505o(119853);
            return valueOf;
        }
    }

    public C36971a(C44635g c44635g, C17126b<? super C36985p, Boolean> c17126b) {
        C25052j.m39376p(c44635g, "jClass");
        C25052j.m39376p(c17126b, "memberFilter");
        AppMethodBeat.m2504i(119858);
        this.BnJ = c44635g;
        this.BnK = c17126b;
        Map linkedHashMap = new LinkedHashMap();
        for (Object next : C17348n.m26855a(C25035t.m39359t(this.BnJ.ebI()), this.BnG)) {
            C37022f dZg = ((C44887q) next).dZg();
            ArrayList arrayList = linkedHashMap.get(dZg);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(dZg, arrayList);
            }
            arrayList.add(next);
        }
        this.BnH = linkedHashMap;
        linkedHashMap = new LinkedHashMap();
        for (Object next2 : C17348n.m26855a(C25035t.m39359t(this.BnJ.ebJ()), this.BnK)) {
            linkedHashMap.put(((C8117n) next2).dZg(), next2);
        }
        this.BnI = linkedHashMap;
        AppMethodBeat.m2505o(119858);
    }

    /* renamed from: k */
    public final Collection<C44887q> mo58977k(C37022f c37022f) {
        AppMethodBeat.m2504i(119854);
        C25052j.m39376p(c37022f, "name");
        List list = (List) this.BnH.get(c37022f);
        if (list != null) {
            Collection collection = list;
            AppMethodBeat.m2505o(119854);
            return collection;
        }
        Collection<C44887q> collection2 = C17115v.AUP;
        AppMethodBeat.m2505o(119854);
        return collection2;
    }

    public final Set<C37022f> ebn() {
        AppMethodBeat.m2504i(119855);
        Collection linkedHashSet = new LinkedHashSet();
        for (C44887q dZg : C17348n.m26855a(C25035t.m39359t(this.BnJ.ebI()), this.BnG)) {
            linkedHashSet.add(dZg.dZg());
        }
        Set set = (Set) linkedHashSet;
        AppMethodBeat.m2505o(119855);
        return set;
    }

    /* renamed from: l */
    public final C8117n mo58978l(C37022f c37022f) {
        AppMethodBeat.m2504i(119856);
        C25052j.m39376p(c37022f, "name");
        C8117n c8117n = (C8117n) this.BnI.get(c37022f);
        AppMethodBeat.m2505o(119856);
        return c8117n;
    }

    public final Set<C37022f> ebo() {
        AppMethodBeat.m2504i(119857);
        Collection linkedHashSet = new LinkedHashSet();
        for (C8117n dZg : C17348n.m26855a(C25035t.m39359t(this.BnJ.ebJ()), this.BnK)) {
            linkedHashSet.add(dZg.dZg());
        }
        Set set = (Set) linkedHashSet;
        AppMethodBeat.m2505o(119857);
        return set;
    }
}
