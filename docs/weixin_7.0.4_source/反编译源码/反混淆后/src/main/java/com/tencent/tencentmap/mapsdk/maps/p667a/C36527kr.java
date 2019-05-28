package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.kr */
public final class C36527kr implements C5902kq {
    /* renamed from: a */
    public final <T extends C31074kv> C16303kw<T> mo12532a(List<T> list, int i) {
        AppMethodBeat.m2504i(100262);
        if (list.size() < 2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.m2505o(100262);
            throw illegalArgumentException;
        }
        C24399la a = C36527kr.m60512a(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a.mo40686a());
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(a.mo40687b());
        ArrayList arrayList3 = new ArrayList(list);
        arrayList3.remove(a.mo40686a());
        arrayList3.remove(a.mo40687b());
        int size = list.size() / 2;
        while (arrayList3.size() > 0) {
            m60513a(arrayList, arrayList2, arrayList3, size);
        }
        C16303kw c16303kw = new C16303kw(arrayList, arrayList2);
        AppMethodBeat.m2505o(100262);
        return c16303kw;
    }

    /* renamed from: a */
    private <T extends C31074kv> void m60513a(List<T> list, List<T> list2, List<T> list3, int i) {
        AppMethodBeat.m2504i(100263);
        C16304ky a = C36528ks.m60515a(list);
        C16304ky a2 = C36528ks.m60515a(list2);
        C31074kv a3 = C36527kr.m60511a(list3, list, a);
        C31074kv a4 = C36527kr.m60511a(list3, list2, a2);
        Object obj = a3.mo29553b().mo29565a().mo29567b(a).mo29574g() <= a4.mo29553b().mo29565a().mo29567b(a2).mo29574g() ? 1 : null;
        if ((obj == null || (list2.size() + list3.size()) - 1 < i) && !(obj == null && list.size() + list3.size() == i)) {
            list2.add(a4);
            list3.remove(a4);
            AppMethodBeat.m2505o(100263);
            return;
        }
        list.add(a3);
        list3.remove(a3);
        AppMethodBeat.m2505o(100263);
    }

    /* renamed from: a */
    static <T extends C31074kv> T m60511a(List<T> list, List<T> list2, C16304ky c16304ky) {
        T t = null;
        AppMethodBeat.m2504i(100264);
        Iterator it = list.iterator();
        Double d = null;
        while (true) {
            T t2 = t;
            if (it.hasNext()) {
                t = (C31074kv) it.next();
                double g = (double) c16304ky.mo29567b(t.mo29553b().mo29565a()).mo29574g();
                if (d == null || g < d.doubleValue()) {
                    d = Double.valueOf(g);
                } else {
                    t = t2;
                }
            } else {
                AppMethodBeat.m2505o(100264);
                return t2;
            }
        }
    }

    /* renamed from: a */
    static <T extends C31074kv> C24399la<T> m60512a(List<T> list) {
        AppMethodBeat.m2504i(100265);
        Double d = null;
        Object obj = null;
        Object obj2 = null;
        for (T t : list) {
            for (T t2 : list) {
                C31074kv obj3;
                if (t != t2) {
                    double g = (double) t.mo29553b().mo29565a().mo29567b(t2.mo29553b().mo29565a()).mo29574g();
                    if (d == null || g > d.doubleValue()) {
                        d = Double.valueOf(g);
                        obj2 = t;
                        obj3 = t2;
                    }
                }
                C31074kv t22 = obj3;
                obj3 = t22;
            }
        }
        if (obj2 != null) {
            C24399la c24399la = new C24399la(obj2, obj3);
            AppMethodBeat.m2505o(100265);
            return c24399la;
        }
        C24399la<T> c24399la2 = new C24399la(list.get(0), list.get(1));
        AppMethodBeat.m2505o(100265);
        return c24399la2;
    }
}
