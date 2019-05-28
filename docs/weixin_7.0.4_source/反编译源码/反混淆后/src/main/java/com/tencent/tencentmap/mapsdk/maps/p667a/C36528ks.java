package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ks */
public final class C36528ks {
    /* renamed from: a */
    public static C16304ky m60515a(Collection<? extends C31074kv> collection) {
        float f = Float.MAX_VALUE;
        AppMethodBeat.m2504i(100266);
        if (collection.isEmpty()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.m2505o(100266);
            throw illegalArgumentException;
        }
        Iterator it = collection.iterator();
        float f2 = Float.MIN_VALUE;
        float f3 = Float.MIN_VALUE;
        float f4 = Float.MAX_VALUE;
        while (true) {
            float f5 = f;
            C16304ky a;
            if (it.hasNext()) {
                float f6;
                a = ((C31074kv) it.next()).mo29553b().mo29565a();
                if (a.mo29568c() < f5) {
                    f = a.mo29568c();
                } else {
                    f = f5;
                }
                if (a.mo29570d() < f4) {
                    f4 = a.mo29570d();
                }
                if (a.mo29571e() > f3) {
                    f3 = a.mo29571e();
                }
                if (a.mo29573f() > f2) {
                    f6 = a.mo29573f();
                } else {
                    f6 = f2;
                }
                f2 = f6;
            } else {
                a = C16304ky.m25122a(f5, f4, f3, f2);
                AppMethodBeat.m2505o(100266);
                return a;
            }
        }
    }

    /* renamed from: a */
    static <T> List<T> m60516a(List<T> list, T t) {
        AppMethodBeat.m2504i(100267);
        ArrayList arrayList = new ArrayList(list.size() + 2);
        arrayList.addAll(list);
        arrayList.add(t);
        AppMethodBeat.m2505o(100267);
        return arrayList;
    }

    /* renamed from: a */
    static <T> List<? extends T> m60517a(List<? extends T> list, T t, List<T> list2) {
        AppMethodBeat.m2504i(100268);
        ArrayList arrayList = new ArrayList(list.size() + list2.size());
        for (T next : list) {
            if (next != t) {
                arrayList.add(next);
            }
        }
        arrayList.addAll(list2);
        AppMethodBeat.m2505o(100268);
        return arrayList;
    }
}
