package p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p000a.C44941v;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p001a.C31586ag;
import p000a.p001a.C41364y;
import p000a.p001a.C44629x;
import p000a.p001a.C7987l;
import p000a.p005f.p007b.C25052j;
import p000a.p009h.C0016h;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.C0092b.C0096g;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.C0092b.C0096g.C0099b;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.C0092b.C0096g.C0099b.C0101b;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C31702c;
import p000a.p051k.C6163u;

/* renamed from: a.i.b.a.c.e.b.a.h */
public final class C41422h implements C31702c {
    private static final Map<String, Integer> ByA;
    public static final C8171a ByB = new C8171a();
    private static final List<String> Byz;
    private final Set<Integer> Byx;
    private final C0096g Byy;
    private final List<C0099b> kCH;
    private final String[] strings;

    /* renamed from: a.i.b.a.c.e.b.a.h$a */
    public static final class C8171a {
        private C8171a() {
        }

        public /* synthetic */ C8171a(byte b) {
            this();
        }
    }

    public C41422h(C0096g c0096g, String[] strArr) {
        Set set;
        C25052j.m39376p(c0096g, "types");
        C25052j.m39376p(strArr, "strings");
        AppMethodBeat.m2504i(121326);
        this.Byy = c0096g;
        this.strings = strArr;
        List list = this.Byy.BxW;
        if (list.isEmpty()) {
            set = C44629x.AUR;
        } else {
            set = C25035t.m39354o(list);
        }
        this.Byx = set;
        ArrayList arrayList = new ArrayList();
        List<C0099b> list2 = this.Byy.BxV;
        arrayList.ensureCapacity(list2.size());
        for (C0099b c0099b : list2) {
            C25052j.m39375o(c0099b, "record");
            int i = c0099b.BxZ;
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(c0099b);
            }
        }
        arrayList.trimToSize();
        this.kCH = arrayList;
        AppMethodBeat.m2505o(121326);
    }

    public final String getString(int i) {
        Object string;
        int size;
        int i2;
        List list;
        Integer num;
        Integer num2;
        C44941v c44941v;
        AppMethodBeat.m2504i(121323);
        C0099b c0099b = (C0099b) this.kCH.get(i);
        if (c0099b.ehm()) {
            string = c0099b.getString();
        } else {
            String string2;
            if (c0099b.ehl()) {
                size = Byz.size();
                i2 = c0099b.Bya;
                if (i2 >= 0 && size > i2) {
                    string2 = (String) Byz.get(c0099b.Bya);
                }
            }
            string2 = this.strings[i];
        }
        if (c0099b.ehp() >= 2) {
            list = c0099b.Byd;
            num = (Integer) list.get(0);
            num2 = (Integer) list.get(1);
            C25052j.m39375o(num, "begin");
            if (C25052j.compare(0, num.intValue()) <= 0) {
                int intValue = num.intValue();
                C25052j.m39375o(num2, "end");
                if (C25052j.compare(intValue, num2.intValue()) <= 0 && C25052j.compare(num2.intValue(), string2.length()) <= 0) {
                    C25052j.m39375o(string2, "string");
                    size = num.intValue();
                    i2 = num2.intValue();
                    if (string2 == null) {
                        c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.m2505o(121323);
                        throw c44941v;
                    }
                    string2 = string2.substring(size, i2);
                    C25052j.m39375o(string2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
            }
        }
        if (c0099b.ehq() >= 2) {
            list = c0099b.Byf;
            num = (Integer) list.get(0);
            num2 = (Integer) list.get(1);
            C25052j.m39375o(string2, "string");
            string2 = C6163u.m9834a(string2, (char) num.intValue(), (char) num2.intValue());
        }
        C0101b c0101b = c0099b.Byc;
        if (c0101b == null) {
            c0101b = C0101b.NONE;
        }
        switch (C41423i.eQZ[c0101b.ordinal()]) {
            case 2:
                C25052j.m39375o(string2, "string");
                string2 = C6163u.m9834a(string2, '$', '.');
                break;
            case 3:
                if (string2.length() >= 2) {
                    C25052j.m39375o(string2, "string");
                    int length = string2.length() - 1;
                    if (string2 == null) {
                        c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.m2505o(121323);
                        throw c44941v;
                    }
                    string2 = string2.substring(1, length);
                    C25052j.m39375o(string2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                C25052j.m39375o(string2, "string");
                string2 = C6163u.m9834a(string2, '$', '.');
                break;
        }
        C25052j.m39375o(string2, "string");
        AppMethodBeat.m2505o(121323);
        return string2;
    }

    /* renamed from: Uh */
    public final String mo17959Uh(int i) {
        AppMethodBeat.m2504i(121324);
        String string = getString(i);
        AppMethodBeat.m2505o(121324);
        return string;
    }

    /* renamed from: Ui */
    public final boolean mo17960Ui(int i) {
        AppMethodBeat.m2504i(121325);
        boolean contains = this.Byx.contains(Integer.valueOf(i));
        AppMethodBeat.m2505o(121325);
        return contains;
    }

    static {
        AppMethodBeat.m2504i(121327);
        List listOf = C7987l.listOf("kotlin/Any", "kotlin/Nothing", "kotlin/Unit", "kotlin/Throwable", "kotlin/Number", "kotlin/Byte", "kotlin/Double", "kotlin/Float", "kotlin/Int", "kotlin/Long", "kotlin/Short", "kotlin/Boolean", "kotlin/Char", "kotlin/CharSequence", "kotlin/String", "kotlin/Comparable", "kotlin/Enum", "kotlin/Array", "kotlin/ByteArray", "kotlin/DoubleArray", "kotlin/FloatArray", "kotlin/IntArray", "kotlin/LongArray", "kotlin/ShortArray", "kotlin/BooleanArray", "kotlin/CharArray", "kotlin/Cloneable", "kotlin/Annotation", "kotlin/collections/Iterable", "kotlin/collections/MutableIterable", "kotlin/collections/Collection", "kotlin/collections/MutableCollection", "kotlin/collections/List", "kotlin/collections/MutableList", "kotlin/collections/Set", "kotlin/collections/MutableSet", "kotlin/collections/Map", "kotlin/collections/MutableMap", "kotlin/collections/Map.Entry", "kotlin/collections/MutableMap.MutableEntry", "kotlin/collections/Iterator", "kotlin/collections/MutableIterator", "kotlin/collections/ListIterator", "kotlin/collections/MutableListIterator");
        Byz = listOf;
        Iterable p = C25035t.m39355p(listOf);
        Map linkedHashMap = new LinkedHashMap(C0016h.m19im(C31586ag.m51047SI(C25034m.m39318d(p)), 16));
        for (Object next : p) {
            linkedHashMap.put((String) ((C41364y) next).value, Integer.valueOf(((C41364y) next).index));
        }
        ByA = linkedHashMap;
        AppMethodBeat.m2505o(121327);
    }
}
