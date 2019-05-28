package p000a.p010i.p011b.p012a.p015c.p023d.p024a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000a.C31826o;
import p000a.C8312u;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.d.a.i */
public final class C25120i {
    private static final HashMap<C8174b, C8174b> Blc = new HashMap();
    public static final C25120i Bld = new C25120i();

    static {
        AppMethodBeat.m2504i(119693);
        C8174b c8174b = C31619g.Bag.Bbj;
        C25052j.m39375o(c8174b, "FQ_NAMES.mutableList");
        C25120i.m39507a(c8174b, C25120i.m39508ac("java.util.ArrayList", "java.util.LinkedList"));
        c8174b = C31619g.Bag.Bbl;
        C25052j.m39375o(c8174b, "FQ_NAMES.mutableSet");
        C25120i.m39507a(c8174b, C25120i.m39508ac("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        c8174b = C31619g.Bag.Bbm;
        C25052j.m39375o(c8174b, "FQ_NAMES.mutableMap");
        C25120i.m39507a(c8174b, C25120i.m39508ac("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        C25120i.m39507a(new C8174b("java.util.function.Function"), C25120i.m39508ac("java.util.function.UnaryOperator"));
        C25120i.m39507a(new C8174b("java.util.function.BiFunction"), C25120i.m39508ac("java.util.function.BinaryOperator"));
        AppMethodBeat.m2505o(119693);
    }

    private C25120i() {
    }

    /* renamed from: k */
    public static C8174b m39509k(C8174b c8174b) {
        AppMethodBeat.m2504i(119690);
        C25052j.m39376p(c8174b, "classFqName");
        C8174b c8174b2 = (C8174b) Blc.get(c8174b);
        AppMethodBeat.m2505o(119690);
        return c8174b2;
    }

    /* renamed from: a */
    private static void m39507a(C8174b c8174b, List<C8174b> list) {
        AppMethodBeat.m2504i(119691);
        Map map = Blc;
        for (C8174b I : list) {
            C31826o I2 = C8312u.m14628I(I, c8174b);
            map.put(I2.first, I2.second);
        }
        AppMethodBeat.m2505o(119691);
    }

    /* renamed from: ac */
    private static List<C8174b> m39508ac(String... strArr) {
        AppMethodBeat.m2504i(119692);
        Collection arrayList = new ArrayList(strArr.length);
        for (String c8174b : strArr) {
            arrayList.add(new C8174b(c8174b));
        }
        List list = (List) arrayList;
        AppMethodBeat.m2505o(119692);
        return list;
    }
}
