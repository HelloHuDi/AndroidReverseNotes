package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class kr implements kq {
    public final <T extends kv> kw<T> a(List<T> list, int i) {
        AppMethodBeat.i(100262);
        if (list.size() < 2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(100262);
            throw illegalArgumentException;
        }
        la a = a(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a.a());
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(a.b());
        ArrayList arrayList3 = new ArrayList(list);
        arrayList3.remove(a.a());
        arrayList3.remove(a.b());
        int size = list.size() / 2;
        while (arrayList3.size() > 0) {
            a(arrayList, arrayList2, arrayList3, size);
        }
        kw kwVar = new kw(arrayList, arrayList2);
        AppMethodBeat.o(100262);
        return kwVar;
    }

    private <T extends kv> void a(List<T> list, List<T> list2, List<T> list3, int i) {
        AppMethodBeat.i(100263);
        ky a = ks.a(list);
        ky a2 = ks.a(list2);
        kv a3 = a(list3, list, a);
        kv a4 = a(list3, list2, a2);
        Object obj = a3.b().a().b(a).g() <= a4.b().a().b(a2).g() ? 1 : null;
        if ((obj == null || (list2.size() + list3.size()) - 1 < i) && !(obj == null && list.size() + list3.size() == i)) {
            list2.add(a4);
            list3.remove(a4);
            AppMethodBeat.o(100263);
            return;
        }
        list.add(a3);
        list3.remove(a3);
        AppMethodBeat.o(100263);
    }

    static <T extends kv> T a(List<T> list, List<T> list2, ky kyVar) {
        T t = null;
        AppMethodBeat.i(100264);
        Iterator it = list.iterator();
        Double d = null;
        while (true) {
            T t2 = t;
            if (it.hasNext()) {
                t = (kv) it.next();
                double g = (double) kyVar.b(t.b().a()).g();
                if (d == null || g < d.doubleValue()) {
                    d = Double.valueOf(g);
                } else {
                    t = t2;
                }
            } else {
                AppMethodBeat.o(100264);
                return t2;
            }
        }
    }

    static <T extends kv> la<T> a(List<T> list) {
        AppMethodBeat.i(100265);
        Double d = null;
        Object obj = null;
        Object obj2 = null;
        for (T t : list) {
            for (T t2 : list) {
                kv obj3;
                if (t != t2) {
                    double g = (double) t.b().a().b(t2.b().a()).g();
                    if (d == null || g > d.doubleValue()) {
                        d = Double.valueOf(g);
                        obj2 = t;
                        obj3 = t2;
                    }
                }
                kv t22 = obj3;
                obj3 = t22;
            }
        }
        if (obj2 != null) {
            la laVar = new la(obj2, obj3);
            AppMethodBeat.o(100265);
            return laVar;
        }
        la<T> laVar2 = new la(list.get(0), list.get(1));
        AppMethodBeat.o(100265);
        return laVar2;
    }
}
