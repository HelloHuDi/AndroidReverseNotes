package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class ks {
    public static ky a(Collection<? extends kv> collection) {
        float f = Float.MAX_VALUE;
        AppMethodBeat.i(100266);
        if (collection.isEmpty()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(100266);
            throw illegalArgumentException;
        }
        Iterator it = collection.iterator();
        float f2 = Float.MIN_VALUE;
        float f3 = Float.MIN_VALUE;
        float f4 = Float.MAX_VALUE;
        while (true) {
            float f5 = f;
            ky a;
            if (it.hasNext()) {
                float f6;
                a = ((kv) it.next()).b().a();
                if (a.c() < f5) {
                    f = a.c();
                } else {
                    f = f5;
                }
                if (a.d() < f4) {
                    f4 = a.d();
                }
                if (a.e() > f3) {
                    f3 = a.e();
                }
                if (a.f() > f2) {
                    f6 = a.f();
                } else {
                    f6 = f2;
                }
                f2 = f6;
            } else {
                a = ky.a(f5, f4, f3, f2);
                AppMethodBeat.o(100266);
                return a;
            }
        }
    }

    static <T> List<T> a(List<T> list, T t) {
        AppMethodBeat.i(100267);
        ArrayList arrayList = new ArrayList(list.size() + 2);
        arrayList.addAll(list);
        arrayList.add(t);
        AppMethodBeat.o(100267);
        return arrayList;
    }

    static <T> List<? extends T> a(List<? extends T> list, T t, List<T> list2) {
        AppMethodBeat.i(100268);
        ArrayList arrayList = new ArrayList(list.size() + list2.size());
        for (T next : list) {
            if (next != t) {
                arrayList.add(next);
            }
        }
        arrayList.addAll(list2);
        AppMethodBeat.o(100268);
        return arrayList;
    }
}
