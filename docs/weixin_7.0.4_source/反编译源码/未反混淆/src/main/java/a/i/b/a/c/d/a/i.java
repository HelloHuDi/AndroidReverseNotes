package a.i.b.a.c.d.a;

import a.f.b.j;
import a.i.b.a.c.a.g;
import a.i.b.a.c.f.b;
import a.o;
import a.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class i {
    private static final HashMap<b, b> Blc = new HashMap();
    public static final i Bld = new i();

    static {
        AppMethodBeat.i(119693);
        b bVar = g.Bag.Bbj;
        j.o(bVar, "FQ_NAMES.mutableList");
        a(bVar, ac("java.util.ArrayList", "java.util.LinkedList"));
        bVar = g.Bag.Bbl;
        j.o(bVar, "FQ_NAMES.mutableSet");
        a(bVar, ac("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        bVar = g.Bag.Bbm;
        j.o(bVar, "FQ_NAMES.mutableMap");
        a(bVar, ac("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        a(new b("java.util.function.Function"), ac("java.util.function.UnaryOperator"));
        a(new b("java.util.function.BiFunction"), ac("java.util.function.BinaryOperator"));
        AppMethodBeat.o(119693);
    }

    private i() {
    }

    public static b k(b bVar) {
        AppMethodBeat.i(119690);
        j.p(bVar, "classFqName");
        b bVar2 = (b) Blc.get(bVar);
        AppMethodBeat.o(119690);
        return bVar2;
    }

    private static void a(b bVar, List<b> list) {
        AppMethodBeat.i(119691);
        Map map = Blc;
        for (b I : list) {
            o I2 = u.I(I, bVar);
            map.put(I2.first, I2.second);
        }
        AppMethodBeat.o(119691);
    }

    private static List<b> ac(String... strArr) {
        AppMethodBeat.i(119692);
        Collection arrayList = new ArrayList(strArr.length);
        for (String bVar : strArr) {
            arrayList.add(new b(bVar));
        }
        List list = (List) arrayList;
        AppMethodBeat.o(119692);
        return list;
    }
}
