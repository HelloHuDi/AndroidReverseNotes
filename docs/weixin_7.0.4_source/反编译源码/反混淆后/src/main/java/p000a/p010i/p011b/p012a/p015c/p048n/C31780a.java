package p000a.p010i.p011b.p012a.p015c.p048n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p000a.p001a.C17115v;
import p000a.p001a.C25033k;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;

/* renamed from: a.i.b.a.c.n.a */
public final class C31780a {
    /* renamed from: x */
    public static final <K> Map<K, Integer> m51479x(Iterable<? extends K> iterable) {
        AppMethodBeat.m2504i(122914);
        C25052j.m39376p(iterable, "receiver$0");
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
                AppMethodBeat.m2505o(122914);
                return map;
            }
        }
    }

    /* renamed from: b */
    public static final <T> void m51478b(Collection<T> collection, T t) {
        AppMethodBeat.m2504i(122915);
        C25052j.m39376p(collection, "receiver$0");
        if (t != null) {
            collection.add(t);
        }
        AppMethodBeat.m2505o(122915);
    }

    /* renamed from: UP */
    public static final <K, V> HashMap<K, V> m51474UP(int i) {
        AppMethodBeat.m2504i(122916);
        HashMap hashMap = new HashMap(C31780a.m51476UR(i));
        AppMethodBeat.m2505o(122916);
        return hashMap;
    }

    /* renamed from: UQ */
    public static final <E> HashSet<E> m51475UQ(int i) {
        AppMethodBeat.m2504i(122917);
        HashSet hashSet = new HashSet(C31780a.m51476UR(i));
        AppMethodBeat.m2505o(122917);
        return hashSet;
    }

    /* renamed from: UR */
    public static final int m51476UR(int i) {
        return i < 3 ? 3 : ((i / 3) + i) + 1;
    }

    /* renamed from: at */
    public static final <T> List<T> m51477at(ArrayList<T> arrayList) {
        AppMethodBeat.m2504i(122918);
        C25052j.m39376p(arrayList, "receiver$0");
        List<T> list;
        switch (arrayList.size()) {
            case 0:
                list = C17115v.AUP;
                AppMethodBeat.m2505o(122918);
                return list;
            case 1:
                list = C25033k.listOf(C25035t.m39337fJ(arrayList));
                AppMethodBeat.m2505o(122918);
                return list;
            default:
                arrayList.trimToSize();
                List<T> list2 = arrayList;
                AppMethodBeat.m2505o(122918);
                return list2;
        }
    }
}
