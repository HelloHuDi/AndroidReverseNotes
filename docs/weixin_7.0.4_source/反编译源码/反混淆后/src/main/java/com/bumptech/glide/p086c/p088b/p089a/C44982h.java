package com.bumptech.glide.p086c.p088b.p089a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.c.b.a.h */
final class C44982h<K extends C31928m, V> {
    private final C37165a<K, V> aCv = new C37165a();
    private final Map<K, C37165a<K, V>> aCw = new HashMap();

    /* renamed from: com.bumptech.glide.c.b.a.h$a */
    static class C37165a<K, V> {
        C37165a<K, V> aCA;
        final K aCx;
        private List<V> aCy;
        C37165a<K, V> aCz;

        C37165a() {
            this(null);
        }

        C37165a(K k) {
            AppMethodBeat.m2504i(91914);
            this.aCA = this;
            this.aCz = this;
            this.aCx = k;
            AppMethodBeat.m2505o(91914);
        }

        public final V removeLast() {
            AppMethodBeat.m2504i(91915);
            int size = size();
            if (size > 0) {
                Object remove = this.aCy.remove(size - 1);
                AppMethodBeat.m2505o(91915);
                return remove;
            }
            AppMethodBeat.m2505o(91915);
            return null;
        }

        public final int size() {
            AppMethodBeat.m2504i(91916);
            if (this.aCy != null) {
                int size = this.aCy.size();
                AppMethodBeat.m2505o(91916);
                return size;
            }
            AppMethodBeat.m2505o(91916);
            return 0;
        }

        public final void add(V v) {
            AppMethodBeat.m2504i(91917);
            if (this.aCy == null) {
                this.aCy = new ArrayList();
            }
            this.aCy.add(v);
            AppMethodBeat.m2505o(91917);
        }
    }

    C44982h() {
        AppMethodBeat.m2504i(91918);
        AppMethodBeat.m2505o(91918);
    }

    /* renamed from: a */
    public final void mo72259a(K k, V v) {
        AppMethodBeat.m2504i(91919);
        C37165a c37165a = (C37165a) this.aCw.get(k);
        if (c37165a == null) {
            c37165a = new C37165a(k);
            m82367b(c37165a);
            this.aCw.put(k, c37165a);
        } else {
            k.mo18616mQ();
        }
        c37165a.add(v);
        AppMethodBeat.m2505o(91919);
    }

    /* renamed from: b */
    public final V mo72260b(K k) {
        AppMethodBeat.m2504i(91920);
        C37165a c37165a = (C37165a) this.aCw.get(k);
        if (c37165a == null) {
            c37165a = new C37165a(k);
            this.aCw.put(k, c37165a);
        } else {
            k.mo18616mQ();
        }
        m82366a(c37165a);
        Object removeLast = c37165a.removeLast();
        AppMethodBeat.m2505o(91920);
        return removeLast;
    }

    public final V removeLast() {
        AppMethodBeat.m2504i(91921);
        C37165a c37165a = this.aCv.aCA;
        while (true) {
            C37165a c37165a2 = c37165a;
            if (c37165a2.equals(this.aCv)) {
                AppMethodBeat.m2505o(91921);
                return null;
            }
            Object removeLast = c37165a2.removeLast();
            if (removeLast != null) {
                AppMethodBeat.m2505o(91921);
                return removeLast;
            }
            C44982h.m82369d(c37165a2);
            this.aCw.remove(c37165a2.aCx);
            ((C31928m) c37165a2.aCx).mo18616mQ();
            c37165a = c37165a2.aCA;
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(91922);
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
        AppMethodBeat.m2505o(91922);
        return stringBuilder2;
    }

    /* renamed from: a */
    private void m82366a(C37165a<K, V> c37165a) {
        AppMethodBeat.m2504i(91923);
        C44982h.m82369d(c37165a);
        c37165a.aCA = this.aCv;
        c37165a.aCz = this.aCv.aCz;
        C44982h.m82368c(c37165a);
        AppMethodBeat.m2505o(91923);
    }

    /* renamed from: b */
    private void m82367b(C37165a<K, V> c37165a) {
        AppMethodBeat.m2504i(91924);
        C44982h.m82369d(c37165a);
        c37165a.aCA = this.aCv.aCA;
        c37165a.aCz = this.aCv;
        C44982h.m82368c(c37165a);
        AppMethodBeat.m2505o(91924);
    }

    /* renamed from: c */
    private static <K, V> void m82368c(C37165a<K, V> c37165a) {
        c37165a.aCz.aCA = c37165a;
        c37165a.aCA.aCz = c37165a;
    }

    /* renamed from: d */
    private static <K, V> void m82369d(C37165a<K, V> c37165a) {
        c37165a.aCA.aCz = c37165a.aCz;
        c37165a.aCz.aCA = c37165a.aCA;
    }
}
