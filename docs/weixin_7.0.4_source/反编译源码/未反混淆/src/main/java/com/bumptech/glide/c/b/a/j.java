package com.bumptech.glide.c.b.a;

import android.util.Log;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class j implements b {
    private final b aCB;
    private final Map<Class<?>, NavigableMap<Integer, Integer>> aCC;
    private final Map<Class<?>, a<?>> aCD;
    private final h<a, Object> aCr;
    private int fu;
    private final int maxSize;

    static final class a implements m {
        private final b aCE;
        private Class<?> aCF;
        int size;

        a(b bVar) {
            this.aCE = bVar;
        }

        /* Access modifiers changed, original: final */
        public final void c(int i, Class<?> cls) {
            this.size = i;
            this.aCF = cls;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.size == aVar.size && this.aCF == aVar.aCF) {
                return true;
            }
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(91925);
            String str = "Key{size=" + this.size + "array=" + this.aCF + '}';
            AppMethodBeat.o(91925);
            return str;
        }

        public final void mQ() {
            AppMethodBeat.i(91926);
            this.aCE.a(this);
            AppMethodBeat.o(91926);
        }

        public final int hashCode() {
            AppMethodBeat.i(91927);
            int hashCode = (this.aCF != null ? this.aCF.hashCode() : 0) + (this.size * 31);
            AppMethodBeat.o(91927);
            return hashCode;
        }
    }

    static final class b extends d<a> {
        b() {
        }

        /* Access modifiers changed, original: final */
        public final a d(int i, Class<?> cls) {
            AppMethodBeat.i(91928);
            a aVar = (a) mS();
            aVar.c(i, cls);
            AppMethodBeat.o(91928);
            return aVar;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ m mR() {
            AppMethodBeat.i(91929);
            a aVar = new a(this);
            AppMethodBeat.o(91929);
            return aVar;
        }
    }

    public j() {
        AppMethodBeat.i(91930);
        this.aCr = new h();
        this.aCB = new b();
        this.aCC = new HashMap();
        this.aCD = new HashMap();
        this.maxSize = 4194304;
        AppMethodBeat.o(91930);
    }

    public j(int i) {
        AppMethodBeat.i(91931);
        this.aCr = new h();
        this.aCB = new b();
        this.aCC = new HashMap();
        this.aCD = new HashMap();
        this.maxSize = i;
        AppMethodBeat.o(91931);
    }

    public final synchronized <T> void put(T t) {
        Object obj;
        AppMethodBeat.i(91932);
        Class cls = t.getClass();
        a q = q(cls);
        int U = q.U(t);
        int mN = U * q.mN();
        if (mN <= this.maxSize / 2) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            AppMethodBeat.o(91932);
        } else {
            a d = this.aCB.d(U, cls);
            this.aCr.a(d, t);
            NavigableMap p = p(cls);
            Integer num = (Integer) p.get(Integer.valueOf(d.size));
            p.put(Integer.valueOf(d.size), Integer.valueOf(num == null ? 1 : num.intValue() + 1));
            this.fu += mN;
            de(this.maxSize);
            AppMethodBeat.o(91932);
        }
    }

    public final synchronized <T> T o(Class<T> cls) {
        Object a;
        AppMethodBeat.i(91933);
        a = a(this.aCB.d(8, cls), (Class) cls);
        AppMethodBeat.o(91933);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004c A:{SYNTHETIC, Splitter:B:21:0x004c} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARNING: Missing block: B:13:0x002e, code skipped:
            if (r0.intValue() > (r6 * 8)) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized <T> T a(int i, Class<T> cls) {
        Object a;
        Object obj = 1;
        synchronized (this) {
            a d;
            AppMethodBeat.i(91934);
            Integer num = (Integer) p(cls).ceilingKey(Integer.valueOf(i));
            if (num != null) {
                Object obj2 = (this.fu == 0 || this.maxSize / this.fu >= 2) ? 1 : null;
                if (obj2 == null) {
                }
                if (obj == null) {
                    d = this.aCB.d(num.intValue(), cls);
                } else {
                    d = this.aCB.d(i, cls);
                }
                a = a(d, (Class) cls);
                AppMethodBeat.o(91934);
            }
            obj = null;
            if (obj == null) {
            }
            a = a(d, (Class) cls);
            AppMethodBeat.o(91934);
        }
        return a;
    }

    private <T> T a(a aVar, Class<T> cls) {
        AppMethodBeat.i(91935);
        a q = q(cls);
        T a = a(aVar);
        if (a != null) {
            this.fu -= q.U(a) * q.mN();
            b(q.U(a), cls);
        }
        if (a == null) {
            if (Log.isLoggable(q.getTag(), 2)) {
                q.getTag();
                new StringBuilder("Allocated ").append(aVar.size).append(" bytes");
            }
            a = q.dd(aVar.size);
        }
        AppMethodBeat.o(91935);
        return a;
    }

    private <T> T a(a aVar) {
        AppMethodBeat.i(91936);
        Object b = this.aCr.b((m) aVar);
        AppMethodBeat.o(91936);
        return b;
    }

    public final synchronized void mO() {
        AppMethodBeat.i(91937);
        de(0);
        AppMethodBeat.o(91937);
    }

    public final synchronized void trimMemory(int i) {
        AppMethodBeat.i(91938);
        if (i >= 40) {
            mO();
            AppMethodBeat.o(91938);
        } else {
            if (i >= 20 || i == 15) {
                de(this.maxSize / 2);
            }
            AppMethodBeat.o(91938);
        }
    }

    private void de(int i) {
        AppMethodBeat.i(91939);
        while (this.fu > i) {
            Object removeLast = this.aCr.removeLast();
            i.d(removeLast, "Argument must not be null");
            a V = V(removeLast);
            this.fu -= V.U(removeLast) * V.mN();
            b(V.U(removeLast), removeLast.getClass());
            if (Log.isLoggable(V.getTag(), 2)) {
                V.getTag();
                new StringBuilder("evicted: ").append(V.U(removeLast));
            }
        }
        AppMethodBeat.o(91939);
    }

    private void b(int i, Class<?> cls) {
        AppMethodBeat.i(91940);
        NavigableMap p = p(cls);
        Integer num = (Integer) p.get(Integer.valueOf(i));
        if (num == null) {
            NullPointerException nullPointerException = new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
            AppMethodBeat.o(91940);
            throw nullPointerException;
        } else if (num.intValue() == 1) {
            p.remove(Integer.valueOf(i));
            AppMethodBeat.o(91940);
        } else {
            p.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
            AppMethodBeat.o(91940);
        }
    }

    private NavigableMap<Integer, Integer> p(Class<?> cls) {
        AppMethodBeat.i(91941);
        NavigableMap<Integer, Integer> navigableMap = (NavigableMap) this.aCC.get(cls);
        if (navigableMap == null) {
            navigableMap = new TreeMap();
            this.aCC.put(cls, navigableMap);
        }
        AppMethodBeat.o(91941);
        return navigableMap;
    }

    private <T> a<T> V(T t) {
        AppMethodBeat.i(91942);
        a q = q(t.getClass());
        AppMethodBeat.o(91942);
        return q;
    }

    private <T> a<T> q(Class<T> cls) {
        AppMethodBeat.i(91943);
        a<T> aVar = (a) this.aCD.get(cls);
        if (aVar == null) {
            if (cls.equals(int[].class)) {
                aVar = new i();
            } else if (cls.equals(byte[].class)) {
                aVar = new g();
            } else {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
                AppMethodBeat.o(91943);
                throw illegalArgumentException;
            }
            this.aCD.put(cls, aVar);
        }
        AppMethodBeat.o(91943);
        return aVar;
    }
}
