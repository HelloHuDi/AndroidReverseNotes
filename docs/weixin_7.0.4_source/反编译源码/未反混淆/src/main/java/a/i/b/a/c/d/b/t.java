package a.i.b.a.c.d.b;

import a.f.a.b;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.a.b.c;
import a.i.b.a.c.b.e;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

public final class t {
    public static final t BrJ = new t();

    static final class a extends k implements b<String, String> {
        public static final a BrK = new a();

        static {
            AppMethodBeat.i(120307);
            AppMethodBeat.o(120307);
        }

        a() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(120306);
            String str = (String) obj;
            j.p(str, "it");
            t tVar = t.BrJ;
            String avU = t.avU(str);
            AppMethodBeat.o(120306);
            return avU;
        }
    }

    static {
        AppMethodBeat.i(120319);
        AppMethodBeat.o(120319);
    }

    private t() {
    }

    public static final /* synthetic */ String avU(String str) {
        AppMethodBeat.i(120320);
        String avT = avT(str);
        AppMethodBeat.o(120320);
        return avT;
    }

    public static String avQ(String str) {
        AppMethodBeat.i(120308);
        j.p(str, "name");
        String concat = "java/lang/".concat(String.valueOf(str));
        AppMethodBeat.o(120308);
        return concat;
    }

    public static String avR(String str) {
        AppMethodBeat.i(120309);
        j.p(str, "name");
        String concat = "java/util/".concat(String.valueOf(str));
        AppMethodBeat.o(120309);
        return concat;
    }

    public static String avS(String str) {
        AppMethodBeat.i(120310);
        j.p(str, "name");
        String concat = "java/util/function/".concat(String.valueOf(str));
        AppMethodBeat.o(120310);
        return concat;
    }

    public static LinkedHashSet<String> p(String str, String... strArr) {
        AppMethodBeat.i(120312);
        j.p(str, "name");
        j.p(strArr, "signatures");
        LinkedHashSet r = r(avQ(str), (String[]) Arrays.copyOf(strArr, strArr.length));
        AppMethodBeat.o(120312);
        return r;
    }

    public static LinkedHashSet<String> q(String str, String... strArr) {
        AppMethodBeat.i(120313);
        j.p(str, "name");
        j.p(strArr, "signatures");
        LinkedHashSet r = r(avR(str), (String[]) Arrays.copyOf(strArr, strArr.length));
        AppMethodBeat.o(120313);
        return r;
    }

    private static LinkedHashSet<String> r(String str, String... strArr) {
        AppMethodBeat.i(120314);
        j.p(str, "internalName");
        j.p(strArr, "signatures");
        Collection linkedHashSet = new LinkedHashSet();
        for (String str2 : strArr) {
            linkedHashSet.add(str + "." + str2);
        }
        LinkedHashSet linkedHashSet2 = (LinkedHashSet) linkedHashSet;
        AppMethodBeat.o(120314);
        return linkedHashSet2;
    }

    public static String a(e eVar, String str) {
        String str2;
        AppMethodBeat.i(120315);
        j.p(eVar, "classDescriptor");
        j.p(str, "jvmDescriptor");
        j.p(eVar, "receiver$0");
        c cVar = c.Bdq;
        a.i.b.a.c.f.c cVar2 = a.i.b.a.c.i.c.a.o(eVar).ByQ;
        j.o(cVar2, "fqNameSafe.toUnsafe()");
        a.i.b.a.c.f.a c = c.c(cVar2);
        if (c != null) {
            a.i.b.a.c.i.d.b h = a.i.b.a.c.i.d.b.h(c);
            j.o(h, "JvmClassName.byClassId(it)");
            str2 = h.BrD;
            j.o(str2, "JvmClassName.byClassId(it).internalName");
        } else {
            str2 = y.a(eVar, (u) v.BrL, false);
        }
        str2 = iV(str2, str);
        AppMethodBeat.o(120315);
        return str2;
    }

    public static String iV(String str, String str2) {
        AppMethodBeat.i(120316);
        j.p(str, "internalName");
        j.p(str2, "jvmDescriptor");
        String str3 = str + "." + str2;
        AppMethodBeat.o(120316);
        return str3;
    }

    public static String e(String str, List<String> list, String str2) {
        AppMethodBeat.i(120317);
        j.p(str, "name");
        j.p(list, "parameters");
        j.p(str2, "ret");
        String str3 = str + '(' + a.a.t.a((Iterable) list, (CharSequence) "", null, null, 0, null, (b) a.BrK, 30) + ')' + avT(str2);
        AppMethodBeat.o(120317);
        return str3;
    }

    private static String avT(String str) {
        AppMethodBeat.i(120318);
        if (str.length() > 1) {
            str = "L" + str + ';';
            AppMethodBeat.o(120318);
            return str;
        }
        AppMethodBeat.o(120318);
        return str;
    }

    public static String[] ad(String... strArr) {
        AppMethodBeat.i(120311);
        j.p(strArr, "signatures");
        Collection arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("<init>(" + str + ")V");
        }
        Object[] toArray = ((List) arrayList).toArray(new String[0]);
        if (toArray == null) {
            v vVar = new v("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(120311);
            throw vVar;
        }
        String[] strArr2 = (String[]) toArray;
        AppMethodBeat.o(120311);
        return strArr2;
    }
}
