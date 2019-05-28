package a.i.b.a.c.e.b.a;

import a.a.ag;
import a.a.l;
import a.a.m;
import a.a.t;
import a.a.x;
import a.a.y;
import a.f.b.j;
import a.i.b.a.c.e.a.c;
import a.i.b.a.c.e.b.b.g;
import a.i.b.a.c.e.b.b.g.b;
import a.k.u;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class h implements c {
    private static final Map<String, Integer> ByA;
    public static final a ByB = new a();
    private static final List<String> Byz;
    private final Set<Integer> Byx;
    private final g Byy;
    private final List<b> kCH;
    private final String[] strings;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public h(g gVar, String[] strArr) {
        Set set;
        j.p(gVar, "types");
        j.p(strArr, "strings");
        AppMethodBeat.i(121326);
        this.Byy = gVar;
        this.strings = strArr;
        List list = this.Byy.BxW;
        if (list.isEmpty()) {
            set = x.AUR;
        } else {
            set = t.o(list);
        }
        this.Byx = set;
        ArrayList arrayList = new ArrayList();
        List<b> list2 = this.Byy.BxV;
        arrayList.ensureCapacity(list2.size());
        for (b bVar : list2) {
            j.o(bVar, "record");
            int i = bVar.BxZ;
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(bVar);
            }
        }
        arrayList.trimToSize();
        this.kCH = arrayList;
        AppMethodBeat.o(121326);
    }

    public final String getString(int i) {
        Object string;
        int size;
        int i2;
        List list;
        Integer num;
        Integer num2;
        v vVar;
        AppMethodBeat.i(121323);
        b bVar = (b) this.kCH.get(i);
        if (bVar.ehm()) {
            string = bVar.getString();
        } else {
            String string2;
            if (bVar.ehl()) {
                size = Byz.size();
                i2 = bVar.Bya;
                if (i2 >= 0 && size > i2) {
                    string2 = (String) Byz.get(bVar.Bya);
                }
            }
            string2 = this.strings[i];
        }
        if (bVar.ehp() >= 2) {
            list = bVar.Byd;
            num = (Integer) list.get(0);
            num2 = (Integer) list.get(1);
            j.o(num, "begin");
            if (j.compare(0, num.intValue()) <= 0) {
                int intValue = num.intValue();
                j.o(num2, "end");
                if (j.compare(intValue, num2.intValue()) <= 0 && j.compare(num2.intValue(), string2.length()) <= 0) {
                    j.o(string2, "string");
                    size = num.intValue();
                    i2 = num2.intValue();
                    if (string2 == null) {
                        vVar = new v("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.o(121323);
                        throw vVar;
                    }
                    string2 = string2.substring(size, i2);
                    j.o(string2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
            }
        }
        if (bVar.ehq() >= 2) {
            list = bVar.Byf;
            num = (Integer) list.get(0);
            num2 = (Integer) list.get(1);
            j.o(string2, "string");
            string2 = u.a(string2, (char) num.intValue(), (char) num2.intValue());
        }
        b.b bVar2 = bVar.Byc;
        if (bVar2 == null) {
            bVar2 = b.b.NONE;
        }
        switch (i.eQZ[bVar2.ordinal()]) {
            case 2:
                j.o(string2, "string");
                string2 = u.a(string2, '$', '.');
                break;
            case 3:
                if (string2.length() >= 2) {
                    j.o(string2, "string");
                    int length = string2.length() - 1;
                    if (string2 == null) {
                        vVar = new v("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.o(121323);
                        throw vVar;
                    }
                    string2 = string2.substring(1, length);
                    j.o(string2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                j.o(string2, "string");
                string2 = u.a(string2, '$', '.');
                break;
        }
        j.o(string2, "string");
        AppMethodBeat.o(121323);
        return string2;
    }

    public final String Uh(int i) {
        AppMethodBeat.i(121324);
        String string = getString(i);
        AppMethodBeat.o(121324);
        return string;
    }

    public final boolean Ui(int i) {
        AppMethodBeat.i(121325);
        boolean contains = this.Byx.contains(Integer.valueOf(i));
        AppMethodBeat.o(121325);
        return contains;
    }

    static {
        AppMethodBeat.i(121327);
        List listOf = l.listOf("kotlin/Any", "kotlin/Nothing", "kotlin/Unit", "kotlin/Throwable", "kotlin/Number", "kotlin/Byte", "kotlin/Double", "kotlin/Float", "kotlin/Int", "kotlin/Long", "kotlin/Short", "kotlin/Boolean", "kotlin/Char", "kotlin/CharSequence", "kotlin/String", "kotlin/Comparable", "kotlin/Enum", "kotlin/Array", "kotlin/ByteArray", "kotlin/DoubleArray", "kotlin/FloatArray", "kotlin/IntArray", "kotlin/LongArray", "kotlin/ShortArray", "kotlin/BooleanArray", "kotlin/CharArray", "kotlin/Cloneable", "kotlin/Annotation", "kotlin/collections/Iterable", "kotlin/collections/MutableIterable", "kotlin/collections/Collection", "kotlin/collections/MutableCollection", "kotlin/collections/List", "kotlin/collections/MutableList", "kotlin/collections/Set", "kotlin/collections/MutableSet", "kotlin/collections/Map", "kotlin/collections/MutableMap", "kotlin/collections/Map.Entry", "kotlin/collections/MutableMap.MutableEntry", "kotlin/collections/Iterator", "kotlin/collections/MutableIterator", "kotlin/collections/ListIterator", "kotlin/collections/MutableListIterator");
        Byz = listOf;
        Iterable p = t.p(listOf);
        Map linkedHashMap = new LinkedHashMap(a.h.h.im(ag.SI(m.d(p)), 16));
        for (Object next : p) {
            linkedHashMap.put((String) ((y) next).value, Integer.valueOf(((y) next).index));
        }
        ByA = linkedHashMap;
        AppMethodBeat.o(121327);
    }
}
