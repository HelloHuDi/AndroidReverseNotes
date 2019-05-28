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
import p000a.C44847aa;
import p000a.C8312u;
import p000a.p001a.C17115v;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p001a.C31586ag;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;
import p000a.p010i.p011b.p012a.p015c.p778f.C8175c;

/* renamed from: a.i.b.a.c.d.a.e */
public final class C31675e {
    private static final Map<C8174b, C37022f> BkV;
    private static final Map<C37022f, List<C37022f>> BkW;
    private static final Set<C8174b> BkX;
    private static final Set<C37022f> BkY;
    public static final C31675e BkZ = new C31675e();

    /* renamed from: a.i.b.a.c.d.a.e$a */
    static final class C0059a extends C25053k implements C17126b<C25085b, Boolean> {
        public static final C0059a Bla = new C0059a();

        static {
            AppMethodBeat.m2504i(119682);
            AppMethodBeat.m2505o(119682);
        }

        C0059a() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(119681);
            C25085b c25085b = (C25085b) obj;
            C25052j.m39376p(c25085b, "it");
            C31675e c31675e = C31675e.BkZ;
            Boolean valueOf = Boolean.valueOf(C31675e.m51237l(c25085b));
            AppMethodBeat.m2505o(119681);
            return valueOf;
        }
    }

    static {
        AppMethodBeat.m2504i(119686);
        C31826o[] c31826oArr = new C31826o[8];
        C8175c c8175c = C31619g.Bag.BaD;
        C25052j.m39375o(c8175c, "BUILTIN_NAMES._enum");
        c31826oArr[0] = C8312u.m14628I(C44893t.m82097b(c8175c, "name"), C37022f.avX("name"));
        c8175c = C31619g.Bag.BaD;
        C25052j.m39375o(c8175c, "BUILTIN_NAMES._enum");
        c31826oArr[1] = C8312u.m14628I(C44893t.m82097b(c8175c, "ordinal"), C37022f.avX("ordinal"));
        C8174b c8174b = C31619g.Bag.Bba;
        C25052j.m39375o(c8174b, "BUILTIN_NAMES.collection");
        c31826oArr[2] = C8312u.m14628I(C44893t.m82095a(c8174b, "size"), C37022f.avX("size"));
        c8174b = C31619g.Bag.Bbe;
        C25052j.m39375o(c8174b, "BUILTIN_NAMES.map");
        c31826oArr[3] = C8312u.m14628I(C44893t.m82095a(c8174b, "size"), C37022f.avX("size"));
        c8175c = C31619g.Bag.Bar;
        C25052j.m39375o(c8175c, "BUILTIN_NAMES.charSequence");
        c31826oArr[4] = C8312u.m14628I(C44893t.m82097b(c8175c, "length"), C37022f.avX("length"));
        c8174b = C31619g.Bag.Bbe;
        C25052j.m39375o(c8174b, "BUILTIN_NAMES.map");
        c31826oArr[5] = C8312u.m14628I(C44893t.m82095a(c8174b, "keys"), C37022f.avX("keySet"));
        c8174b = C31619g.Bag.Bbe;
        C25052j.m39375o(c8174b, "BUILTIN_NAMES.map");
        c31826oArr[6] = C8312u.m14628I(C44893t.m82095a(c8174b, "values"), C37022f.avX("values"));
        c8174b = C31619g.Bag.Bbe;
        C25052j.m39375o(c8174b, "BUILTIN_NAMES.map");
        c31826oArr[7] = C8312u.m14628I(C44893t.m82095a(c8174b, "entries"), C37022f.avX("entrySet"));
        Map a = C31586ag.m51049a(c31826oArr);
        BkV = a;
        Iterable<Entry> entrySet = a.entrySet();
        Collection arrayList = new ArrayList(C25034m.m39318d(entrySet));
        for (Entry entry : entrySet) {
            arrayList.add(new C31826o(((C8174b) entry.getKey()).ByQ.ehK(), entry.getValue()));
        }
        a = new LinkedHashMap();
        for (Object next : (List) arrayList) {
            C37022f c37022f = (C37022f) ((C31826o) next).second;
            ArrayList arrayList2 = a.get(c37022f);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                a.put(c37022f, arrayList2);
            }
            arrayList2.add((C37022f) ((C31826o) next).first);
        }
        BkW = a;
        Set keySet = BkV.keySet();
        BkX = keySet;
        Iterable<C8174b> iterable = keySet;
        arrayList = new ArrayList(C25034m.m39318d(iterable));
        for (C8174b c8174b2 : iterable) {
            arrayList.add(c8174b2.ByQ.ehK());
        }
        BkY = C25035t.m39354o((List) arrayList);
        AppMethodBeat.m2505o(119686);
    }

    private C31675e() {
    }

    public static Set<C37022f> eaW() {
        return BkY;
    }

    /* renamed from: l */
    public static boolean m51237l(C25085b c25085b) {
        AppMethodBeat.m2504i(119683);
        C25052j.m39376p(c25085b, "callableMemberDescriptor");
        if (!BkY.contains(c25085b.dZg())) {
            AppMethodBeat.m2505o(119683);
            return false;
        } else if (C25035t.m39327a((Iterable) BkX, (Object) C41434a.m72277I(c25085b)) && c25085b.dYV().isEmpty()) {
            AppMethodBeat.m2505o(119683);
            return true;
        } else {
            if (C31619g.m51108b((C31642l) c25085b)) {
                Collection dYX = c25085b.dYX();
                C25052j.m39375o(dYX, "overriddenDescriptors");
                Iterable<C25085b> iterable = dYX;
                if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                    for (C25085b c25085b2 : iterable) {
                        C25052j.m39375o(c25085b2, "it");
                        if (C31675e.m51237l(c25085b2)) {
                            AppMethodBeat.m2505o(119683);
                            return true;
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(119683);
            return false;
        }
    }

    /* renamed from: i */
    public static List<C37022f> m51236i(C37022f c37022f) {
        AppMethodBeat.m2504i(119684);
        C25052j.m39376p(c37022f, "name1");
        List<C37022f> list = (List) BkW.get(c37022f);
        if (list == null) {
            list = C17115v.AUP;
        }
        AppMethodBeat.m2505o(119684);
        return list;
    }

    /* renamed from: m */
    public static String m51238m(C25085b c25085b) {
        AppMethodBeat.m2504i(119685);
        C25052j.m39376p(c25085b, "receiver$0");
        boolean b = C31619g.m51108b((C31642l) c25085b);
        if (!C44847aa.AUz || b) {
            C25085b b2 = C41434a.m72278b(C41434a.m72286x(c25085b), C0059a.Bla);
            if (b2 == null) {
                AppMethodBeat.m2505o(119685);
                return null;
            }
            C37022f c37022f = (C37022f) BkV.get(C41434a.m72284o(b2));
            if (c37022f != null) {
                String str = c37022f.name;
                AppMethodBeat.m2505o(119685);
                return str;
            }
            AppMethodBeat.m2505o(119685);
            return null;
        }
        Throwable assertionError = new AssertionError("This method is defined only for builtin members, but " + c25085b + " found");
        AppMethodBeat.m2505o(119685);
        throw assertionError;
    }
}
