package p000a.p010i.p011b.p012a.p015c.p023d.p031b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import p000a.C44941v;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p016a.p017b.C41391c;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p037i.p1147c.C41434a;
import p000a.p010i.p011b.p012a.p015c.p037i.p1366d.C41436b;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8175c;

/* renamed from: a.i.b.a.c.d.b.t */
public final class C44898t {
    public static final C44898t BrJ = new C44898t();

    /* renamed from: a.i.b.a.c.d.b.t$a */
    static final class C0078a extends C25053k implements C17126b<String, String> {
        public static final C0078a BrK = new C0078a();

        static {
            AppMethodBeat.m2504i(120307);
            AppMethodBeat.m2505o(120307);
        }

        C0078a() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(120306);
            String str = (String) obj;
            C25052j.m39376p(str, "it");
            C44898t c44898t = C44898t.BrJ;
            String avU = C44898t.avU(str);
            AppMethodBeat.m2505o(120306);
            return avU;
        }
    }

    static {
        AppMethodBeat.m2504i(120319);
        AppMethodBeat.m2505o(120319);
    }

    private C44898t() {
    }

    public static final /* synthetic */ String avU(String str) {
        AppMethodBeat.m2504i(120320);
        String avT = C44898t.avT(str);
        AppMethodBeat.m2505o(120320);
        return avT;
    }

    public static String avQ(String str) {
        AppMethodBeat.m2504i(120308);
        C25052j.m39376p(str, "name");
        String concat = "java/lang/".concat(String.valueOf(str));
        AppMethodBeat.m2505o(120308);
        return concat;
    }

    public static String avR(String str) {
        AppMethodBeat.m2504i(120309);
        C25052j.m39376p(str, "name");
        String concat = "java/util/".concat(String.valueOf(str));
        AppMethodBeat.m2505o(120309);
        return concat;
    }

    public static String avS(String str) {
        AppMethodBeat.m2504i(120310);
        C25052j.m39376p(str, "name");
        String concat = "java/util/function/".concat(String.valueOf(str));
        AppMethodBeat.m2505o(120310);
        return concat;
    }

    /* renamed from: p */
    public static LinkedHashSet<String> m82116p(String str, String... strArr) {
        AppMethodBeat.m2504i(120312);
        C25052j.m39376p(str, "name");
        C25052j.m39376p(strArr, "signatures");
        LinkedHashSet r = C44898t.m82118r(C44898t.avQ(str), (String[]) Arrays.copyOf(strArr, strArr.length));
        AppMethodBeat.m2505o(120312);
        return r;
    }

    /* renamed from: q */
    public static LinkedHashSet<String> m82117q(String str, String... strArr) {
        AppMethodBeat.m2504i(120313);
        C25052j.m39376p(str, "name");
        C25052j.m39376p(strArr, "signatures");
        LinkedHashSet r = C44898t.m82118r(C44898t.avR(str), (String[]) Arrays.copyOf(strArr, strArr.length));
        AppMethodBeat.m2505o(120313);
        return r;
    }

    /* renamed from: r */
    private static LinkedHashSet<String> m82118r(String str, String... strArr) {
        AppMethodBeat.m2504i(120314);
        C25052j.m39376p(str, "internalName");
        C25052j.m39376p(strArr, "signatures");
        Collection linkedHashSet = new LinkedHashSet();
        for (String str2 : strArr) {
            linkedHashSet.add(str + "." + str2);
        }
        LinkedHashSet linkedHashSet2 = (LinkedHashSet) linkedHashSet;
        AppMethodBeat.m2505o(120314);
        return linkedHashSet2;
    }

    /* renamed from: a */
    public static String m82112a(C46865e c46865e, String str) {
        String str2;
        AppMethodBeat.m2504i(120315);
        C25052j.m39376p(c46865e, "classDescriptor");
        C25052j.m39376p(str, "jvmDescriptor");
        C25052j.m39376p(c46865e, "receiver$0");
        C41391c c41391c = C41391c.Bdq;
        C8175c c8175c = C41434a.m72284o(c46865e).ByQ;
        C25052j.m39375o(c8175c, "fqNameSafe.toUnsafe()");
        C8173a c = C41391c.m72179c(c8175c);
        if (c != null) {
            C41436b h = C41436b.m72290h(c);
            C25052j.m39375o(h, "JvmClassName.byClassId(it)");
            str2 = h.BrD;
            C25052j.m39375o(str2, "JvmClassName.byClassId(it).internalName");
        } else {
            str2 = C17236y.m26627a(c46865e, (C36997u) C25130v.BrL, false);
        }
        str2 = C44898t.m82115iV(str2, str);
        AppMethodBeat.m2505o(120315);
        return str2;
    }

    /* renamed from: iV */
    public static String m82115iV(String str, String str2) {
        AppMethodBeat.m2504i(120316);
        C25052j.m39376p(str, "internalName");
        C25052j.m39376p(str2, "jvmDescriptor");
        String str3 = str + "." + str2;
        AppMethodBeat.m2505o(120316);
        return str3;
    }

    /* renamed from: e */
    public static String m82114e(String str, List<String> list, String str2) {
        AppMethodBeat.m2504i(120317);
        C25052j.m39376p(str, "name");
        C25052j.m39376p(list, "parameters");
        C25052j.m39376p(str2, "ret");
        String str3 = str + '(' + C25035t.m39322a((Iterable) list, (CharSequence) "", null, null, 0, null, (C17126b) C0078a.BrK, 30) + ')' + C44898t.avT(str2);
        AppMethodBeat.m2505o(120317);
        return str3;
    }

    private static String avT(String str) {
        AppMethodBeat.m2504i(120318);
        if (str.length() > 1) {
            str = "L" + str + ';';
            AppMethodBeat.m2505o(120318);
            return str;
        }
        AppMethodBeat.m2505o(120318);
        return str;
    }

    /* renamed from: ad */
    public static String[] m82113ad(String... strArr) {
        AppMethodBeat.m2504i(120311);
        C25052j.m39376p(strArr, "signatures");
        Collection arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("<init>(" + str + ")V");
        }
        Object[] toArray = ((List) arrayList).toArray(new String[0]);
        if (toArray == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.m2505o(120311);
            throw c44941v;
        }
        String[] strArr2 = (String[]) toArray;
        AppMethodBeat.m2505o(120311);
        return strArr2;
    }
}
