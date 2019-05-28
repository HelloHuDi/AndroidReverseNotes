package com.bumptech.glide.c.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class h<K extends m, V> {
    private final a<K, V> aCv = new a();
    private final Map<K, a<K, V>> aCw = new HashMap();

    static class a<K, V> {
        a<K, V> aCA;
        final K aCx;
        private List<V> aCy;
        a<K, V> aCz;

        a() {
            this(null);
        }

        a(K k) {
            AppMethodBeat.i(91914);
            this.aCA = this;
            this.aCz = this;
            this.aCx = k;
            AppMethodBeat.o(91914);
        }

        public final V removeLast() {
            AppMethodBeat.i(91915);
            int size = size();
            if (size > 0) {
                Object remove = this.aCy.remove(size - 1);
                AppMethodBeat.o(91915);
                return remove;
            }
            AppMethodBeat.o(91915);
            return null;
        }

        public final int size() {
            AppMethodBeat.i(91916);
            if (this.aCy != null) {
                int size = this.aCy.size();
                AppMethodBeat.o(91916);
                return size;
            }
            AppMethodBeat.o(91916);
            return 0;
        }

        public final void add(V v) {
            AppMethodBeat.i(91917);
            if (this.aCy == null) {
                this.aCy = new ArrayList();
            }
            this.aCy.add(v);
            AppMethodBeat.o(91917);
        }
    }

    h() {
        AppMethodBeat.i(91918);
        AppMethodBeat.o(91918);
    }

    public final void a(K k, V v) {
        AppMethodBeat.i(91919);
        a aVar = (a) this.aCw.get(k);
        if (aVar == null) {
            aVar = new a(k);
            b(aVar);
            this.aCw.put(k, aVar);
        } else {
            k.mQ();
        }
        aVar.add(v);
        AppMethodBeat.o(91919);
    }

    public final V b(K k) {
        AppMethodBeat.i(91920);
        a aVar = (a) this.aCw.get(k);
        if (aVar == null) {
            aVar = new a(k);
            this.aCw.put(k, aVar);
        } else {
            k.mQ();
        }
        a(aVar);
        Object removeLast = aVar.removeLast();
        AppMethodBeat.o(91920);
        return removeLast;
    }

    public final V removeLast() {
        AppMethodBeat.i(91921);
        a aVar = this.aCv.aCA;
        while (true) {
            a aVar2 = aVar;
            if (aVar2.equals(this.aCv)) {
                AppMethodBeat.o(91921);
                return null;
            }
            Object removeLast = aVar2.removeLast();
            if (removeLast != null) {
                AppMethodBeat.o(91921);
                return removeLast;
            }
            d(aVar2);
            this.aCw.remove(aVar2.aCx);
            ((m) aVar2.aCx).mQ();
            aVar = aVar2.aCA;
        }
    }

    public final String toString() {
        AppMethodBeat.i(91922);
        StringBuilder stringBuilder = new StringBuilder("GroupedLinkedMap( ");
        Object obj = null;
        for (Object obj2 = this.aCv.aCz; !obj2.equals(this.aCv); obj2 = obj2.aCz) {
            obj = 1;
            stringBuilder.append('{').append(obj2.aCx).append(':').append(obj2.size()).append("}, ");
        }
        if (obj != null) {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }
        String stringBuilder2 = stringBuilder.append(" )").toString();
        AppMethodBeat.o(91922);
        return stringBuilder2;
    }

    private void a(a<K, V> aVar) {
        AppMethodBeat.i(91923);
        d(aVar);
        aVar.aCA = this.aCv;
        aVar.aCz = this.aCv.aCz;
        c(aVar);
        AppMethodBeat.o(91923);
    }

    private void b(a<K, V> aVar) {
        AppMethodBeat.i(91924);
        d(aVar);
        aVar.aCA = this.aCv.aCA;
        aVar.aCz = this.aCv;
        c(aVar);
        AppMethodBeat.o(91924);
    }

    private static <K, V> void c(a<K, V> aVar) {
        aVar.aCz.aCA = aVar;
        aVar.aCA.aCz = aVar;
    }

    private static <K, V> void d(a<K, V> aVar) {
        aVar.aCA.aCz = aVar.aCz;
        aVar.aCz.aCA = aVar.aCA;
    }
}
