package a.i.b.a.c.n;

import a.a.k;
import a.a.t;
import a.a.v;
import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class a {
    public static final <K> Map<K, Integer> x(Iterable<? extends K> iterable) {
        AppMethodBeat.i(122914);
        j.p(iterable, "receiver$0");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        Iterator it = iterable.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                linkedHashMap.put(it.next(), Integer.valueOf(i2));
                i = i2 + 1;
            } else {
                Map map = linkedHashMap;
                AppMethodBeat.o(122914);
                return map;
            }
        }
    }

    public static final <T> void b(Collection<T> collection, T t) {
        AppMethodBeat.i(122915);
        j.p(collection, "receiver$0");
        if (t != null) {
            collection.add(t);
        }
        AppMethodBeat.o(122915);
    }

    public static final <K, V> HashMap<K, V> UP(int i) {
        AppMethodBeat.i(122916);
        HashMap hashMap = new HashMap(UR(i));
        AppMethodBeat.o(122916);
        return hashMap;
    }

    public static final <E> HashSet<E> UQ(int i) {
        AppMethodBeat.i(122917);
        HashSet hashSet = new HashSet(UR(i));
        AppMethodBeat.o(122917);
        return hashSet;
    }

    public static final int UR(int i) {
        return i < 3 ? 3 : ((i / 3) + i) + 1;
    }

    public static final <T> List<T> at(ArrayList<T> arrayList) {
        AppMethodBeat.i(122918);
        j.p(arrayList, "receiver$0");
        List<T> list;
        switch (arrayList.size()) {
            case 0:
                list = v.AUP;
                AppMethodBeat.o(122918);
                return list;
            case 1:
                list = k.listOf(t.fJ(arrayList));
                AppMethodBeat.o(122918);
                return list;
            default:
                arrayList.trimToSize();
                List<T> list2 = arrayList;
                AppMethodBeat.o(122918);
                return list2;
        }
    }
}
