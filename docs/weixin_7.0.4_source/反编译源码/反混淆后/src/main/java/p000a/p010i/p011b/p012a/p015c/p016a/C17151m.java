package p000a.p010i.p011b.p012a.p015c.p016a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C36953ab;
import p000a.p010i.p011b.p012a.p015c.p045l.C17316av;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;

/* renamed from: a.i.b.a.c.a.m */
public final class C17151m {
    private static final Set<C37022f> BcC;
    private static final HashMap<C8173a, C8173a> BcD = new HashMap();
    private static final HashMap<C8173a, C8173a> BcE = new HashMap();
    private static final Set<C37022f> BcF;
    public static final C17151m BcG = new C17151m();

    static {
        int i = 0;
        AppMethodBeat.m2504i(119123);
        C25079l[] values = C25079l.values();
        Collection arrayList = new ArrayList(values.length);
        for (C25079l c25079l : values) {
            arrayList.add(c25079l.BbZ);
        }
        BcC = C25035t.m39354o((List) arrayList);
        values = C25079l.values();
        arrayList = new LinkedHashSet();
        for (C25079l c25079l2 : values) {
            arrayList.add(c25079l2.BcA.ByN.ByQ.ehK());
        }
        BcF = (Set) arrayList;
        C25079l[] values2 = C25079l.values();
        int length = values2.length;
        while (i < length) {
            C25079l c25079l3 = values2[i];
            BcD.put(c25079l3.BcA, c25079l3.BcB);
            BcE.put(c25079l3.BcB, c25079l3.BcA);
            i++;
        }
        AppMethodBeat.m2505o(119123);
    }

    private C17151m() {
    }

    /* renamed from: d */
    public static boolean m26525d(C37022f c37022f) {
        AppMethodBeat.m2504i(119119);
        C25052j.m39376p(c37022f, "name");
        boolean contains = BcF.contains(c37022f);
        AppMethodBeat.m2505o(119119);
        return contains;
    }

    /* renamed from: c */
    public static C8173a m26523c(C8173a c8173a) {
        AppMethodBeat.m2504i(119120);
        C25052j.m39376p(c8173a, "arrayClassId");
        C8173a c8173a2 = (C8173a) BcD.get(c8173a);
        AppMethodBeat.m2505o(119120);
        return c8173a2;
    }

    /* renamed from: d */
    public static C8173a m26524d(C8173a c8173a) {
        AppMethodBeat.m2504i(119121);
        C25052j.m39376p(c8173a, "arrayClassId");
        C8173a c8173a2 = (C8173a) BcE.get(c8173a);
        AppMethodBeat.m2505o(119121);
        return c8173a2;
    }

    /* renamed from: G */
    public static boolean m26522G(C46867w c46867w) {
        AppMethodBeat.m2504i(119122);
        C25052j.m39376p(c46867w, "type");
        if (C17316av.m26818ax(c46867w)) {
            AppMethodBeat.m2505o(119122);
            return false;
        }
        C0036h dYs = c46867w.ejw().dYs();
        if (dYs == null) {
            AppMethodBeat.m2505o(119122);
            return false;
        }
        C25052j.m39375o(dYs, "type.constructor.declara…escriptor ?: return false");
        C31642l c31642l = dYs;
        C25052j.m39376p(c31642l, "descriptor");
        C31642l dXW = c31642l.dXW();
        if ((dXW instanceof C36953ab) && C25052j.m39373j(((C36953ab) dXW).dZF(), C31619g.AZV) && BcC.contains(c31642l.dZg())) {
            AppMethodBeat.m2505o(119122);
            return true;
        }
        AppMethodBeat.m2505o(119122);
        return false;
    }
}
