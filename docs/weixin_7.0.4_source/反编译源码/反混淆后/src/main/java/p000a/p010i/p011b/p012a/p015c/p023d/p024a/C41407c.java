package p000a.p010i.p011b.p012a.p015c.p023d.p024a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import p000a.C31826o;
import p000a.C44941v;
import p000a.C8312u;
import p000a.p001a.C17115v;
import p000a.p001a.C25034m;
import p000a.p001a.C31586ag;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C41397al;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C44897r;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C44898t;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p037i.p1366d.C25176c;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.d.a.c */
public final class C41407c {
    private static final C25122r Bkt;
    private static final Map<C25122r, C37022f> Bku;
    private static final Map<String, C37022f> Bkv;
    private static final List<C37022f> Bkw;
    private static final Map<C37022f, List<C37022f>> Bkx;
    public static final C41407c Bky = new C41407c();

    /* renamed from: a.i.b.a.c.d.a.c$a */
    static final class C36970a extends C25053k implements C17126b<C25085b, Boolean> {
        final /* synthetic */ C41397al Bkz;

        C36970a(C41397al c41397al) {
            this.Bkz = c41397al;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(119659);
            C25052j.m39376p((C25085b) obj, "it");
            C41407c c41407c = C41407c.Bky;
            Map eaV = C41407c.Bkv;
            String c = C44897r.m82111c(this.Bkz);
            if (eaV == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                AppMethodBeat.m2505o(119659);
                throw c44941v;
            }
            Boolean valueOf = Boolean.valueOf(eaV.containsKey(c));
            AppMethodBeat.m2505o(119659);
            return valueOf;
        }
    }

    static {
        AppMethodBeat.m2504i(119665);
        String str = C25176c.INT.desc;
        C25052j.m39375o(str, "JvmPrimitiveType.INT.desc");
        Bkt = C44893t.m82104v("java/util/List", "removeAt", str, "Ljava/lang/Object;");
        C44898t c44898t = C44898t.BrJ;
        C31826o[] c31826oArr = new C31826o[8];
        String str2 = C25176c.BYTE.desc;
        C25052j.m39375o(str2, "JvmPrimitiveType.BYTE.desc");
        c31826oArr[0] = C8312u.m14628I(C44893t.m82104v(C44898t.avQ("Number"), "toByte", "", str2), C37022f.avX("byteValue"));
        str2 = C25176c.SHORT.desc;
        C25052j.m39375o(str2, "JvmPrimitiveType.SHORT.desc");
        c31826oArr[1] = C8312u.m14628I(C44893t.m82104v(C44898t.avQ("Number"), "toShort", "", str2), C37022f.avX("shortValue"));
        str2 = C25176c.INT.desc;
        C25052j.m39375o(str2, "JvmPrimitiveType.INT.desc");
        c31826oArr[2] = C8312u.m14628I(C44893t.m82104v(C44898t.avQ("Number"), "toInt", "", str2), C37022f.avX("intValue"));
        str2 = C25176c.LONG.desc;
        C25052j.m39375o(str2, "JvmPrimitiveType.LONG.desc");
        c31826oArr[3] = C8312u.m14628I(C44893t.m82104v(C44898t.avQ("Number"), "toLong", "", str2), C37022f.avX("longValue"));
        str2 = C25176c.FLOAT.desc;
        C25052j.m39375o(str2, "JvmPrimitiveType.FLOAT.desc");
        c31826oArr[4] = C8312u.m14628I(C44893t.m82104v(C44898t.avQ("Number"), "toFloat", "", str2), C37022f.avX("floatValue"));
        str2 = C25176c.DOUBLE.desc;
        C25052j.m39375o(str2, "JvmPrimitiveType.DOUBLE.desc");
        c31826oArr[5] = C8312u.m14628I(C44893t.m82104v(C44898t.avQ("Number"), "toDouble", "", str2), C37022f.avX("doubleValue"));
        c31826oArr[6] = C8312u.m14628I(Bkt, C37022f.avX("remove"));
        String str3 = C25176c.INT.desc;
        C25052j.m39375o(str3, "JvmPrimitiveType.INT.desc");
        str2 = C25176c.CHAR.desc;
        C25052j.m39375o(str2, "JvmPrimitiveType.CHAR.desc");
        c31826oArr[7] = C8312u.m14628I(C44893t.m82104v(C44898t.avQ("CharSequence"), "get", str3, str2), C37022f.avX("charAt"));
        Map a = C31586ag.m51049a(c31826oArr);
        Bku = a;
        Map linkedHashMap = new LinkedHashMap(C31586ag.m51047SI(a.size()));
        for (Object next : a.entrySet()) {
            linkedHashMap.put(((C25122r) ((Entry) next).getKey()).signature, ((Entry) next).getValue());
        }
        Bkv = linkedHashMap;
        Iterable<C25122r> keySet = Bku.keySet();
        Collection arrayList = new ArrayList(C25034m.m39318d(keySet));
        for (C25122r c25122r : keySet) {
            arrayList.add(c25122r.BgZ);
        }
        Bkw = (List) arrayList;
        Iterable<Entry> entrySet = Bku.entrySet();
        arrayList = new ArrayList(C25034m.m39318d(entrySet));
        for (Entry entry : entrySet) {
            arrayList.add(new C31826o(((C25122r) entry.getKey()).BgZ, entry.getValue()));
        }
        linkedHashMap = new LinkedHashMap();
        for (Object next2 : (List) arrayList) {
            C37022f c37022f = (C37022f) ((C31826o) next2).second;
            ArrayList arrayList2 = linkedHashMap.get(c37022f);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(c37022f, arrayList2);
            }
            arrayList2.add((C37022f) ((C31826o) next2).first);
        }
        Bkx = linkedHashMap;
        AppMethodBeat.m2505o(119665);
    }

    private C41407c() {
    }

    public static List<C37022f> eaU() {
        return Bkw;
    }

    /* renamed from: f */
    public static boolean m72222f(C37022f c37022f) {
        AppMethodBeat.m2504i(119660);
        C25052j.m39376p(c37022f, "receiver$0");
        boolean contains = Bkw.contains(c37022f);
        AppMethodBeat.m2505o(119660);
        return contains;
    }

    /* renamed from: a */
    public static C37022f m72219a(C41397al c41397al) {
        AppMethodBeat.m2504i(119661);
        C25052j.m39376p(c41397al, "functionDescriptor");
        Map map = Bkv;
        String c = C44897r.m82111c(c41397al);
        if (c == null) {
            AppMethodBeat.m2505o(119661);
            return null;
        }
        C37022f c37022f = (C37022f) map.get(c);
        AppMethodBeat.m2505o(119661);
        return c37022f;
    }

    /* renamed from: b */
    public static boolean m72220b(C41397al c41397al) {
        AppMethodBeat.m2504i(119662);
        C25052j.m39376p(c41397al, "functionDescriptor");
        if (!C31619g.m51108b((C31642l) c41397al) || C41434a.m72278b(c41397al, new C36970a(c41397al)) == null) {
            AppMethodBeat.m2505o(119662);
            return false;
        }
        AppMethodBeat.m2505o(119662);
        return true;
    }

    /* renamed from: g */
    public static List<C37022f> m72223g(C37022f c37022f) {
        AppMethodBeat.m2504i(119663);
        C25052j.m39376p(c37022f, "name");
        List<C37022f> list = (List) Bkx.get(c37022f);
        if (list == null) {
            list = C17115v.AUP;
        }
        AppMethodBeat.m2505o(119663);
        return list;
    }

    /* renamed from: c */
    public static boolean m72221c(C41397al c41397al) {
        AppMethodBeat.m2504i(119664);
        C25052j.m39376p(c41397al, "receiver$0");
        if (C25052j.m39373j(c41397al.dZg().name, "removeAt") && C25052j.m39373j(C44897r.m82111c(c41397al), Bkt.signature)) {
            AppMethodBeat.m2505o(119664);
            return true;
        }
        AppMethodBeat.m2505o(119664);
        return false;
    }
}
