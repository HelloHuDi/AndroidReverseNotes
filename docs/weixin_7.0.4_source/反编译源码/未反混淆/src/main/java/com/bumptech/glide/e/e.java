package com.bumptech.glide.e;

import com.bumptech.glide.c.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e {
    private final List<String> aHd = new ArrayList();
    private final Map<String, List<a<?, ?>>> aHe = new HashMap();

    static class a<T, R> {
        final Class<R> aAf;
        private final Class<T> aBd;
        final k<T, R> aES;

        public a(Class<T> cls, Class<R> cls2, k<T, R> kVar) {
            this.aBd = cls;
            this.aAf = cls2;
            this.aES = kVar;
        }

        public final boolean e(Class<?> cls, Class<?> cls2) {
            AppMethodBeat.i(92440);
            if (this.aBd.isAssignableFrom(cls) && cls2.isAssignableFrom(this.aAf)) {
                AppMethodBeat.o(92440);
                return true;
            }
            AppMethodBeat.o(92440);
            return false;
        }
    }

    public e() {
        AppMethodBeat.i(92441);
        AppMethodBeat.o(92441);
    }

    public final synchronized void s(List<String> list) {
        AppMethodBeat.i(92442);
        ArrayList<String> arrayList = new ArrayList(this.aHd);
        this.aHd.clear();
        this.aHd.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.aHd.add(str);
            }
        }
        AppMethodBeat.o(92442);
    }

    public final synchronized <T, R> List<k<T, R>> g(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        AppMethodBeat.i(92443);
        arrayList = new ArrayList();
        for (String str : this.aHd) {
            List<a> list = (List) this.aHe.get(str);
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.e(cls, cls2)) {
                        arrayList.add(aVar.aES);
                    }
                }
            }
        }
        AppMethodBeat.o(92443);
        return arrayList;
    }

    public final synchronized <T, R> List<Class<R>> h(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        AppMethodBeat.i(92444);
        arrayList = new ArrayList();
        for (String str : this.aHd) {
            List<a> list = (List) this.aHe.get(str);
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.e(cls, cls2) && !arrayList.contains(aVar.aAf)) {
                        arrayList.add(aVar.aAf);
                    }
                }
            }
        }
        AppMethodBeat.o(92444);
        return arrayList;
    }

    public final synchronized <T, R> void a(String str, k<T, R> kVar, Class<T> cls, Class<R> cls2) {
        AppMethodBeat.i(92445);
        ad(str).add(new a(cls, cls2, kVar));
        AppMethodBeat.o(92445);
    }

    private synchronized List<a<?, ?>> ad(String str) {
        List<a<?, ?>> list;
        AppMethodBeat.i(92446);
        if (!this.aHd.contains(str)) {
            this.aHd.add(str);
        }
        list = (List) this.aHe.get(str);
        if (list == null) {
            list = new ArrayList();
            this.aHe.put(str, list);
        }
        AppMethodBeat.o(92446);
        return list;
    }
}
