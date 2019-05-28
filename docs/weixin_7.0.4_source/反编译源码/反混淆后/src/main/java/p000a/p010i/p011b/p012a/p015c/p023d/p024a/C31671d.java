package p000a.p010i.p011b.p012a.p015c.p023d.p024a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import p000a.C31826o;
import p000a.C8312u;
import p000a.p001a.C25032am;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p001a.C31586ag;
import p000a.p001a.C7986al;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C44897r;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C44898t;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p037i.p1366d.C25176c;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.d.a.d */
public final class C31671d {
    private static final List<C25122r> BkA;
    private static final List<String> BkB;
    private static final List<String> BkC;
    private static final Map<C25122r, C25112b> BkD;
    private static final Map<String, C25112b> BkE;
    private static final Set<C37022f> BkF;
    private static final Set<String> BkG;
    public static final C31671d BkH = new C31671d();

    /* renamed from: a.i.b.a.c.d.a.d$a */
    public enum C0058a {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);
        
        private final String BkM;
        private final boolean BkN;

        private C0058a(String str, boolean z) {
            this.BkM = str;
            this.BkN = z;
        }

        static {
            AppMethodBeat.m2505o(119666);
        }
    }

    /* renamed from: a.i.b.a.c.d.a.d$c */
    static final class C24615c extends C25053k implements C17126b<C25085b, Boolean> {
        public static final C24615c BkT = new C24615c();

        static {
            AppMethodBeat.m2504i(119673);
            AppMethodBeat.m2505o(119673);
        }

        C24615c() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(119672);
            C25085b c25085b = (C25085b) obj;
            C25052j.m39376p(c25085b, "it");
            C31671d c31671d = C31671d.BkH;
            Boolean valueOf = Boolean.valueOf(C31671d.m51234k(c25085b));
            AppMethodBeat.m2505o(119672);
            return valueOf;
        }
    }

    /* renamed from: a.i.b.a.c.d.a.d$b */
    public enum C25112b {
        NULL(null),
        INDEX(Integer.valueOf(-1)),
        FALSE(Boolean.FALSE);
        
        private final Object aze;

        /* renamed from: a.i.b.a.c.d.a.d$b$a */
        static final class C25113a extends C25112b {
            C25113a(String str) {
                super(str, 3, null);
            }
        }

        protected C25112b(Object obj) {
            this.aze = obj;
        }

        static {
            AppMethodBeat.m2505o(119669);
        }
    }

    /* renamed from: a.i.b.a.c.d.a.d$d */
    static final class C31672d extends C25053k implements C17126b<C25085b, Boolean> {
        public static final C31672d BkU = new C31672d();

        static {
            AppMethodBeat.m2504i(119675);
            AppMethodBeat.m2505o(119675);
        }

        C31672d() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            boolean z;
            Boolean valueOf;
            AppMethodBeat.m2504i(119674);
            C25085b c25085b = (C25085b) obj;
            C25052j.m39376p(c25085b, "it");
            if (c25085b instanceof C8083t) {
                C31671d c31671d = C31671d.BkH;
                if (C31671d.m51234k(c25085b)) {
                    z = true;
                    valueOf = Boolean.valueOf(z);
                    AppMethodBeat.m2505o(119674);
                    return valueOf;
                }
            }
            z = false;
            valueOf = Boolean.valueOf(z);
            AppMethodBeat.m2505o(119674);
            return valueOf;
        }
    }

    static {
        String str;
        AppMethodBeat.m2504i(119679);
        Iterable<String> of = C7986al.setOf("containsAll", "removeAll", "retainAll");
        Collection arrayList = new ArrayList(C25034m.m39318d(of));
        for (String v : of) {
            str = C25176c.BOOLEAN.desc;
            C25052j.m39375o(str, "JvmPrimitiveType.BOOLEAN.desc");
            arrayList.add(C44893t.m82104v("java/util/Collection", v, "Ljava/util/Collection;", str));
        }
        List list = (List) arrayList;
        BkA = list;
        Iterable<C25122r> iterable = list;
        Collection arrayList2 = new ArrayList(C25034m.m39318d(iterable));
        for (C25122r c25122r : iterable) {
            arrayList2.add(c25122r.signature);
        }
        BkB = (List) arrayList2;
        Iterable<C25122r> iterable2 = BkA;
        arrayList = new ArrayList(C25034m.m39318d(iterable2));
        for (C25122r c25122r2 : iterable2) {
            arrayList.add(c25122r2.BgZ.name);
        }
        BkC = (List) arrayList;
        C44898t c44898t = C44898t.BrJ;
        C31826o[] c31826oArr = new C31826o[10];
        String str2 = C25176c.BOOLEAN.desc;
        C25052j.m39375o(str2, "JvmPrimitiveType.BOOLEAN.desc");
        c31826oArr[0] = C8312u.m14628I(C44893t.m82104v(C44898t.avR("Collection"), "contains", "Ljava/lang/Object;", str2), C25112b.FALSE);
        str2 = C25176c.BOOLEAN.desc;
        C25052j.m39375o(str2, "JvmPrimitiveType.BOOLEAN.desc");
        c31826oArr[1] = C8312u.m14628I(C44893t.m82104v(C44898t.avR("Collection"), "remove", "Ljava/lang/Object;", str2), C25112b.FALSE);
        str2 = C25176c.BOOLEAN.desc;
        C25052j.m39375o(str2, "JvmPrimitiveType.BOOLEAN.desc");
        c31826oArr[2] = C8312u.m14628I(C44893t.m82104v(C44898t.avR("Map"), "containsKey", "Ljava/lang/Object;", str2), C25112b.FALSE);
        str2 = C25176c.BOOLEAN.desc;
        C25052j.m39375o(str2, "JvmPrimitiveType.BOOLEAN.desc");
        c31826oArr[3] = C8312u.m14628I(C44893t.m82104v(C44898t.avR("Map"), "containsValue", "Ljava/lang/Object;", str2), C25112b.FALSE);
        str = C25176c.BOOLEAN.desc;
        C25052j.m39375o(str, "JvmPrimitiveType.BOOLEAN.desc");
        c31826oArr[4] = C8312u.m14628I(C44893t.m82104v(C44898t.avR("Map"), "remove", "Ljava/lang/Object;Ljava/lang/Object;", str), C25112b.FALSE);
        c31826oArr[5] = C8312u.m14628I(C44893t.m82104v(C44898t.avR("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), C25112b.BkR);
        c31826oArr[6] = C8312u.m14628I(C44893t.m82104v(C44898t.avR("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;"), C25112b.NULL);
        c31826oArr[7] = C8312u.m14628I(C44893t.m82104v(C44898t.avR("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), C25112b.NULL);
        str = C25176c.INT.desc;
        C25052j.m39375o(str, "JvmPrimitiveType.INT.desc");
        c31826oArr[8] = C8312u.m14628I(C44893t.m82104v(C44898t.avR("List"), "indexOf", "Ljava/lang/Object;", str), C25112b.INDEX);
        str = C25176c.INT.desc;
        C25052j.m39375o(str, "JvmPrimitiveType.INT.desc");
        c31826oArr[9] = C8312u.m14628I(C44893t.m82104v(C44898t.avR("List"), "lastIndexOf", "Ljava/lang/Object;", str), C25112b.INDEX);
        Map a = C31586ag.m51049a(c31826oArr);
        BkD = a;
        Map linkedHashMap = new LinkedHashMap(C31586ag.m51047SI(a.size()));
        for (Object next : a.entrySet()) {
            linkedHashMap.put(((C25122r) ((Entry) next).getKey()).signature, ((Entry) next).getValue());
        }
        BkE = linkedHashMap;
        Set a2 = C25032am.m39316a(BkD.keySet(), BkA);
        iterable2 = a2;
        Collection arrayList3 = new ArrayList(C25034m.m39318d(iterable2));
        for (C25122r c25122r22 : iterable2) {
            arrayList3.add(c25122r22.BgZ);
        }
        BkF = C25035t.m39354o((List) arrayList3);
        iterable = a2;
        arrayList2 = new ArrayList(C25034m.m39318d(iterable));
        for (C25122r c25122r3 : iterable) {
            arrayList2.add(c25122r3.signature);
        }
        BkG = C25035t.m39354o((List) arrayList2);
        AppMethodBeat.m2505o(119679);
    }

    private C31671d() {
    }

    /* renamed from: e */
    public static final C8083t m51231e(C8083t c8083t) {
        AppMethodBeat.m2504i(119676);
        C25052j.m39376p(c8083t, "functionDescriptor");
        C37022f dZg = c8083t.dZg();
        C25052j.m39375o(dZg, "functionDescriptor.name");
        if (C31671d.m51232h(dZg)) {
            C8083t c8083t2 = (C8083t) C41434a.m72278b(c8083t, C24615c.BkT);
            AppMethodBeat.m2505o(119676);
            return c8083t2;
        }
        AppMethodBeat.m2505o(119676);
        return null;
    }

    /* renamed from: h */
    public static boolean m51232h(C37022f c37022f) {
        AppMethodBeat.m2504i(119677);
        C25052j.m39376p(c37022f, "receiver$0");
        boolean contains = BkF.contains(c37022f);
        AppMethodBeat.m2505o(119677);
        return contains;
    }

    /* renamed from: j */
    public static final C0058a m51233j(C25085b c25085b) {
        AppMethodBeat.m2504i(119678);
        C25052j.m39376p(c25085b, "receiver$0");
        if (BkF.contains(c25085b.dZg())) {
            C25085b b = C41434a.m72278b(c25085b, C31672d.BkU);
            if (b != null) {
                String c = C44897r.m82111c(b);
                if (c != null) {
                    C0058a c0058a;
                    if (BkB.contains(c)) {
                        c0058a = C0058a.ONE_COLLECTION_PARAMETER;
                        AppMethodBeat.m2505o(119678);
                        return c0058a;
                    }
                    Object obj = BkE.get(c);
                    if (obj == null) {
                        C25052j.dWJ();
                    }
                    if (((C25112b) obj) == C25112b.NULL) {
                        c0058a = C0058a.OBJECT_PARAMETER_GENERIC;
                        AppMethodBeat.m2505o(119678);
                        return c0058a;
                    }
                    c0058a = C0058a.OBJECT_PARAMETER_NON_GENERIC;
                    AppMethodBeat.m2505o(119678);
                    return c0058a;
                }
            }
            AppMethodBeat.m2505o(119678);
            return null;
        }
        AppMethodBeat.m2505o(119678);
        return null;
    }

    /* renamed from: k */
    public static final /* synthetic */ boolean m51234k(C25085b c25085b) {
        AppMethodBeat.m2504i(119680);
        boolean a = C25035t.m39327a((Iterable) BkG, (Object) C44897r.m82111c(c25085b));
        AppMethodBeat.m2505o(119680);
        return a;
    }
}
