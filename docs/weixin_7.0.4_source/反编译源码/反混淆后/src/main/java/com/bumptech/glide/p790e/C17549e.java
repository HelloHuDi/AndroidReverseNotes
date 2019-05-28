package com.bumptech.glide.p790e;

import com.bumptech.glide.p086c.C31968k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.e.e */
public final class C17549e {
    private final List<String> aHd = new ArrayList();
    private final Map<String, List<C17550a<?, ?>>> aHe = new HashMap();

    /* renamed from: com.bumptech.glide.e.e$a */
    static class C17550a<T, R> {
        final Class<R> aAf;
        private final Class<T> aBd;
        final C31968k<T, R> aES;

        public C17550a(Class<T> cls, Class<R> cls2, C31968k<T, R> c31968k) {
            this.aBd = cls;
            this.aAf = cls2;
            this.aES = c31968k;
        }

        /* renamed from: e */
        public final boolean mo31975e(Class<?> cls, Class<?> cls2) {
            AppMethodBeat.m2504i(92440);
            if (this.aBd.isAssignableFrom(cls) && cls2.isAssignableFrom(this.aAf)) {
                AppMethodBeat.m2505o(92440);
                return true;
            }
            AppMethodBeat.m2505o(92440);
            return false;
        }
    }

    public C17549e() {
        AppMethodBeat.m2504i(92441);
        AppMethodBeat.m2505o(92441);
    }

    /* renamed from: s */
    public final synchronized void mo31974s(List<String> list) {
        AppMethodBeat.m2504i(92442);
        ArrayList<String> arrayList = new ArrayList(this.aHd);
        this.aHd.clear();
        this.aHd.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.aHd.add(str);
            }
        }
        AppMethodBeat.m2505o(92442);
    }

    /* renamed from: g */
    public final synchronized <T, R> List<C31968k<T, R>> mo31972g(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        AppMethodBeat.m2504i(92443);
        arrayList = new ArrayList();
        for (String str : this.aHd) {
            List<C17550a> list = (List) this.aHe.get(str);
            if (list != null) {
                for (C17550a c17550a : list) {
                    if (c17550a.mo31975e(cls, cls2)) {
                        arrayList.add(c17550a.aES);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(92443);
        return arrayList;
    }

    /* renamed from: h */
    public final synchronized <T, R> List<Class<R>> mo31973h(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        AppMethodBeat.m2504i(92444);
        arrayList = new ArrayList();
        for (String str : this.aHd) {
            List<C17550a> list = (List) this.aHe.get(str);
            if (list != null) {
                for (C17550a c17550a : list) {
                    if (c17550a.mo31975e(cls, cls2) && !arrayList.contains(c17550a.aAf)) {
                        arrayList.add(c17550a.aAf);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(92444);
        return arrayList;
    }

    /* renamed from: a */
    public final synchronized <T, R> void mo31971a(String str, C31968k<T, R> c31968k, Class<T> cls, Class<R> cls2) {
        AppMethodBeat.m2504i(92445);
        m27401ad(str).add(new C17550a(cls, cls2, c31968k));
        AppMethodBeat.m2505o(92445);
    }

    /* renamed from: ad */
    private synchronized List<C17550a<?, ?>> m27401ad(String str) {
        List<C17550a<?, ?>> list;
        AppMethodBeat.m2504i(92446);
        if (!this.aHd.contains(str)) {
            this.aHd.add(str);
        }
        list = (List) this.aHe.get(str);
        if (list == null) {
            list = new ArrayList();
            this.aHe.put(str, list);
        }
        AppMethodBeat.m2505o(92446);
        return list;
    }
}
