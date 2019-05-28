package a.i.b.a.c.d.a;

import a.a.ag;
import a.a.al;
import a.a.am;
import a.a.m;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.b.t;
import a.i.b.a.c.d.b.r;
import a.i.b.a.c.f.f;
import a.o;
import a.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d {
    private static final List<r> BkA;
    private static final List<String> BkB;
    private static final List<String> BkC;
    private static final Map<r, b> BkD;
    private static final Map<String, b> BkE;
    private static final Set<f> BkF;
    private static final Set<String> BkG;
    public static final d BkH = new d();

    public enum a {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);
        
        private final String BkM;
        private final boolean BkN;

        private a(String str, boolean z) {
            this.BkM = str;
            this.BkN = z;
        }

        static {
            AppMethodBeat.o(119666);
        }
    }

    static final class c extends k implements a.f.a.b<a.i.b.a.c.b.b, Boolean> {
        public static final c BkT = new c();

        static {
            AppMethodBeat.i(119673);
            AppMethodBeat.o(119673);
        }

        c() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119672);
            a.i.b.a.c.b.b bVar = (a.i.b.a.c.b.b) obj;
            j.p(bVar, "it");
            d dVar = d.BkH;
            Boolean valueOf = Boolean.valueOf(d.k(bVar));
            AppMethodBeat.o(119672);
            return valueOf;
        }
    }

    public enum b {
        NULL(null),
        INDEX(Integer.valueOf(-1)),
        FALSE(Boolean.FALSE);
        
        private final Object aze;

        static final class a extends b {
            a(String str) {
                super(str, 3, null);
            }
        }

        protected b(Object obj) {
            this.aze = obj;
        }

        static {
            AppMethodBeat.o(119669);
        }
    }

    static final class d extends k implements a.f.a.b<a.i.b.a.c.b.b, Boolean> {
        public static final d BkU = new d();

        static {
            AppMethodBeat.i(119675);
            AppMethodBeat.o(119675);
        }

        d() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            boolean z;
            Boolean valueOf;
            AppMethodBeat.i(119674);
            a.i.b.a.c.b.b bVar = (a.i.b.a.c.b.b) obj;
            j.p(bVar, "it");
            if (bVar instanceof t) {
                d dVar = d.BkH;
                if (d.k(bVar)) {
                    z = true;
                    valueOf = Boolean.valueOf(z);
                    AppMethodBeat.o(119674);
                    return valueOf;
                }
            }
            z = false;
            valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(119674);
            return valueOf;
        }
    }

    static {
        String str;
        AppMethodBeat.i(119679);
        Iterable<String> of = al.setOf("containsAll", "removeAll", "retainAll");
        Collection arrayList = new ArrayList(m.d(of));
        for (String v : of) {
            str = a.i.b.a.c.i.d.c.BOOLEAN.desc;
            j.o(str, "JvmPrimitiveType.BOOLEAN.desc");
            arrayList.add(t.v("java/util/Collection", v, "Ljava/util/Collection;", str));
        }
        List list = (List) arrayList;
        BkA = list;
        Iterable<r> iterable = list;
        Collection arrayList2 = new ArrayList(m.d(iterable));
        for (r rVar : iterable) {
            arrayList2.add(rVar.signature);
        }
        BkB = (List) arrayList2;
        Iterable<r> iterable2 = BkA;
        arrayList = new ArrayList(m.d(iterable2));
        for (r rVar2 : iterable2) {
            arrayList.add(rVar2.BgZ.name);
        }
        BkC = (List) arrayList;
        a.i.b.a.c.d.b.t tVar = a.i.b.a.c.d.b.t.BrJ;
        o[] oVarArr = new o[10];
        String str2 = a.i.b.a.c.i.d.c.BOOLEAN.desc;
        j.o(str2, "JvmPrimitiveType.BOOLEAN.desc");
        oVarArr[0] = u.I(t.v(a.i.b.a.c.d.b.t.avR("Collection"), "contains", "Ljava/lang/Object;", str2), b.FALSE);
        str2 = a.i.b.a.c.i.d.c.BOOLEAN.desc;
        j.o(str2, "JvmPrimitiveType.BOOLEAN.desc");
        oVarArr[1] = u.I(t.v(a.i.b.a.c.d.b.t.avR("Collection"), "remove", "Ljava/lang/Object;", str2), b.FALSE);
        str2 = a.i.b.a.c.i.d.c.BOOLEAN.desc;
        j.o(str2, "JvmPrimitiveType.BOOLEAN.desc");
        oVarArr[2] = u.I(t.v(a.i.b.a.c.d.b.t.avR("Map"), "containsKey", "Ljava/lang/Object;", str2), b.FALSE);
        str2 = a.i.b.a.c.i.d.c.BOOLEAN.desc;
        j.o(str2, "JvmPrimitiveType.BOOLEAN.desc");
        oVarArr[3] = u.I(t.v(a.i.b.a.c.d.b.t.avR("Map"), "containsValue", "Ljava/lang/Object;", str2), b.FALSE);
        str = a.i.b.a.c.i.d.c.BOOLEAN.desc;
        j.o(str, "JvmPrimitiveType.BOOLEAN.desc");
        oVarArr[4] = u.I(t.v(a.i.b.a.c.d.b.t.avR("Map"), "remove", "Ljava/lang/Object;Ljava/lang/Object;", str), b.FALSE);
        oVarArr[5] = u.I(t.v(a.i.b.a.c.d.b.t.avR("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), b.BkR);
        oVarArr[6] = u.I(t.v(a.i.b.a.c.d.b.t.avR("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;"), b.NULL);
        oVarArr[7] = u.I(t.v(a.i.b.a.c.d.b.t.avR("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), b.NULL);
        str = a.i.b.a.c.i.d.c.INT.desc;
        j.o(str, "JvmPrimitiveType.INT.desc");
        oVarArr[8] = u.I(t.v(a.i.b.a.c.d.b.t.avR("List"), "indexOf", "Ljava/lang/Object;", str), b.INDEX);
        str = a.i.b.a.c.i.d.c.INT.desc;
        j.o(str, "JvmPrimitiveType.INT.desc");
        oVarArr[9] = u.I(t.v(a.i.b.a.c.d.b.t.avR("List"), "lastIndexOf", "Ljava/lang/Object;", str), b.INDEX);
        Map a = ag.a(oVarArr);
        BkD = a;
        Map linkedHashMap = new LinkedHashMap(ag.SI(a.size()));
        for (Object next : a.entrySet()) {
            linkedHashMap.put(((r) ((Entry) next).getKey()).signature, ((Entry) next).getValue());
        }
        BkE = linkedHashMap;
        Set a2 = am.a(BkD.keySet(), BkA);
        iterable2 = a2;
        Collection arrayList3 = new ArrayList(m.d(iterable2));
        for (r rVar22 : iterable2) {
            arrayList3.add(rVar22.BgZ);
        }
        BkF = a.a.t.o((List) arrayList3);
        iterable = a2;
        arrayList2 = new ArrayList(m.d(iterable));
        for (r rVar3 : iterable) {
            arrayList2.add(rVar3.signature);
        }
        BkG = a.a.t.o((List) arrayList2);
        AppMethodBeat.o(119679);
    }

    private d() {
    }

    public static final t e(t tVar) {
        AppMethodBeat.i(119676);
        j.p(tVar, "functionDescriptor");
        f dZg = tVar.dZg();
        j.o(dZg, "functionDescriptor.name");
        if (h(dZg)) {
            t tVar2 = (t) a.i.b.a.c.i.c.a.b(tVar, c.BkT);
            AppMethodBeat.o(119676);
            return tVar2;
        }
        AppMethodBeat.o(119676);
        return null;
    }

    public static boolean h(f fVar) {
        AppMethodBeat.i(119677);
        j.p(fVar, "receiver$0");
        boolean contains = BkF.contains(fVar);
        AppMethodBeat.o(119677);
        return contains;
    }

    public static final a j(a.i.b.a.c.b.b bVar) {
        AppMethodBeat.i(119678);
        j.p(bVar, "receiver$0");
        if (BkF.contains(bVar.dZg())) {
            a.i.b.a.c.b.b b = a.i.b.a.c.i.c.a.b(bVar, d.BkU);
            if (b != null) {
                String c = r.c(b);
                if (c != null) {
                    a aVar;
                    if (BkB.contains(c)) {
                        aVar = a.ONE_COLLECTION_PARAMETER;
                        AppMethodBeat.o(119678);
                        return aVar;
                    }
                    Object obj = BkE.get(c);
                    if (obj == null) {
                        j.dWJ();
                    }
                    if (((b) obj) == b.NULL) {
                        aVar = a.OBJECT_PARAMETER_GENERIC;
                        AppMethodBeat.o(119678);
                        return aVar;
                    }
                    aVar = a.OBJECT_PARAMETER_NON_GENERIC;
                    AppMethodBeat.o(119678);
                    return aVar;
                }
            }
            AppMethodBeat.o(119678);
            return null;
        }
        AppMethodBeat.o(119678);
        return null;
    }

    public static final /* synthetic */ boolean k(a.i.b.a.c.b.b bVar) {
        AppMethodBeat.i(119680);
        boolean a = a.a.t.a((Iterable) BkG, (Object) r.c(bVar));
        AppMethodBeat.o(119680);
        return a;
    }
}
