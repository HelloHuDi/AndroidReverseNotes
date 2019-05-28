package com.bumptech.glide.p086c.p088b.p089a;

import android.util.Log;
import com.bumptech.glide.p095h.C8561i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* renamed from: com.bumptech.glide.c.b.a.j */
public final class C31927j implements C8515b {
    private final C25412b aCB;
    private final Map<Class<?>, NavigableMap<Integer, Integer>> aCC;
    private final Map<Class<?>, C25407a<?>> aCD;
    private final C44982h<C25411a, Object> aCr;
    /* renamed from: fu */
    private int f14670fu;
    private final int maxSize;

    /* renamed from: com.bumptech.glide.c.b.a.j$a */
    static final class C25411a implements C31928m {
        private final C25412b aCE;
        private Class<?> aCF;
        int size;

        C25411a(C25412b c25412b) {
            this.aCE = c25412b;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: c */
        public final void mo42455c(int i, Class<?> cls) {
            this.size = i;
            this.aCF = cls;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C25411a)) {
                return false;
            }
            C25411a c25411a = (C25411a) obj;
            if (this.size == c25411a.size && this.aCF == c25411a.aCF) {
                return true;
            }
            return false;
        }

        public final String toString() {
            AppMethodBeat.m2504i(91925);
            String str = "Key{size=" + this.size + "array=" + this.aCF + '}';
            AppMethodBeat.m2505o(91925);
            return str;
        }

        /* renamed from: mQ */
        public final void mo18616mQ() {
            AppMethodBeat.m2504i(91926);
            this.aCE.mo59239a(this);
            AppMethodBeat.m2505o(91926);
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(91927);
            int hashCode = (this.aCF != null ? this.aCF.hashCode() : 0) + (this.size * 31);
            AppMethodBeat.m2505o(91927);
            return hashCode;
        }
    }

    /* renamed from: com.bumptech.glide.c.b.a.j$b */
    static final class C25412b extends C37164d<C25411a> {
        C25412b() {
        }

        /* Access modifiers changed, original: final */
        /* renamed from: d */
        public final C25411a mo42459d(int i, Class<?> cls) {
            AppMethodBeat.m2504i(91928);
            C25411a c25411a = (C25411a) mo59240mS();
            c25411a.mo42455c(i, cls);
            AppMethodBeat.m2505o(91928);
            return c25411a;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        /* renamed from: mR */
        public final /* synthetic */ C31928m mo18619mR() {
            AppMethodBeat.m2504i(91929);
            C25411a c25411a = new C25411a(this);
            AppMethodBeat.m2505o(91929);
            return c25411a;
        }
    }

    public C31927j() {
        AppMethodBeat.m2504i(91930);
        this.aCr = new C44982h();
        this.aCB = new C25412b();
        this.aCC = new HashMap();
        this.aCD = new HashMap();
        this.maxSize = 4194304;
        AppMethodBeat.m2505o(91930);
    }

    public C31927j(int i) {
        AppMethodBeat.m2504i(91931);
        this.aCr = new C44982h();
        this.aCB = new C25412b();
        this.aCC = new HashMap();
        this.aCD = new HashMap();
        this.maxSize = i;
        AppMethodBeat.m2505o(91931);
    }

    public final synchronized <T> void put(T t) {
        Object obj;
        AppMethodBeat.m2504i(91932);
        Class cls = t.getClass();
        C25407a q = m51862q(cls);
        int U = q.mo31945U(t);
        int mN = U * q.mo31948mN();
        if (mN <= this.maxSize / 2) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            AppMethodBeat.m2505o(91932);
        } else {
            C25411a d = this.aCB.mo42459d(U, cls);
            this.aCr.mo72259a(d, t);
            NavigableMap p = m51861p(cls);
            Integer num = (Integer) p.get(Integer.valueOf(d.size));
            p.put(Integer.valueOf(d.size), Integer.valueOf(num == null ? 1 : num.intValue() + 1));
            this.f14670fu += mN;
            m51860de(this.maxSize);
            AppMethodBeat.m2505o(91932);
        }
    }

    /* renamed from: o */
    public final synchronized <T> T mo18610o(Class<T> cls) {
        Object a;
        AppMethodBeat.m2504i(91933);
        a = m51858a(this.aCB.mo42459d(8, cls), (Class) cls);
        AppMethodBeat.m2505o(91933);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004c A:{SYNTHETIC, Splitter:B:21:0x004c} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARNING: Missing block: B:13:0x002e, code skipped:
            if (r0.intValue() > (r6 * 8)) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final synchronized <T> T mo18608a(int i, Class<T> cls) {
        Object a;
        Object obj = 1;
        synchronized (this) {
            C25411a d;
            AppMethodBeat.m2504i(91934);
            Integer num = (Integer) m51861p(cls).ceilingKey(Integer.valueOf(i));
            if (num != null) {
                Object obj2 = (this.f14670fu == 0 || this.maxSize / this.f14670fu >= 2) ? 1 : null;
                if (obj2 == null) {
                }
                if (obj == null) {
                    d = this.aCB.mo42459d(num.intValue(), cls);
                } else {
                    d = this.aCB.mo42459d(i, cls);
                }
                a = m51858a(d, (Class) cls);
                AppMethodBeat.m2505o(91934);
            }
            obj = null;
            if (obj == null) {
            }
            a = m51858a(d, (Class) cls);
            AppMethodBeat.m2505o(91934);
        }
        return a;
    }

    /* renamed from: a */
    private <T> T m51858a(C25411a c25411a, Class<T> cls) {
        AppMethodBeat.m2504i(91935);
        C25407a q = m51862q(cls);
        T a = m51857a(c25411a);
        if (a != null) {
            this.f14670fu -= q.mo31945U(a) * q.mo31948mN();
            m51859b(q.mo31945U(a), cls);
        }
        if (a == null) {
            if (Log.isLoggable(q.getTag(), 2)) {
                q.getTag();
                new StringBuilder("Allocated ").append(c25411a.size).append(" bytes");
            }
            a = q.mo31946dd(c25411a.size);
        }
        AppMethodBeat.m2505o(91935);
        return a;
    }

    /* renamed from: a */
    private <T> T m51857a(C25411a c25411a) {
        AppMethodBeat.m2504i(91936);
        Object b = this.aCr.mo72260b((C31928m) c25411a);
        AppMethodBeat.m2505o(91936);
        return b;
    }

    /* renamed from: mO */
    public final synchronized void mo18609mO() {
        AppMethodBeat.m2504i(91937);
        m51860de(0);
        AppMethodBeat.m2505o(91937);
    }

    public final synchronized void trimMemory(int i) {
        AppMethodBeat.m2504i(91938);
        if (i >= 40) {
            mo18609mO();
            AppMethodBeat.m2505o(91938);
        } else {
            if (i >= 20 || i == 15) {
                m51860de(this.maxSize / 2);
            }
            AppMethodBeat.m2505o(91938);
        }
    }

    /* renamed from: de */
    private void m51860de(int i) {
        AppMethodBeat.m2504i(91939);
        while (this.f14670fu > i) {
            Object removeLast = this.aCr.removeLast();
            C8561i.m15217d(removeLast, "Argument must not be null");
            C25407a V = m51856V(removeLast);
            this.f14670fu -= V.mo31945U(removeLast) * V.mo31948mN();
            m51859b(V.mo31945U(removeLast), removeLast.getClass());
            if (Log.isLoggable(V.getTag(), 2)) {
                V.getTag();
                new StringBuilder("evicted: ").append(V.mo31945U(removeLast));
            }
        }
        AppMethodBeat.m2505o(91939);
    }

    /* renamed from: b */
    private void m51859b(int i, Class<?> cls) {
        AppMethodBeat.m2504i(91940);
        NavigableMap p = m51861p(cls);
        Integer num = (Integer) p.get(Integer.valueOf(i));
        if (num == null) {
            NullPointerException nullPointerException = new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
            AppMethodBeat.m2505o(91940);
            throw nullPointerException;
        } else if (num.intValue() == 1) {
            p.remove(Integer.valueOf(i));
            AppMethodBeat.m2505o(91940);
        } else {
            p.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
            AppMethodBeat.m2505o(91940);
        }
    }

    /* renamed from: p */
    private NavigableMap<Integer, Integer> m51861p(Class<?> cls) {
        AppMethodBeat.m2504i(91941);
        NavigableMap<Integer, Integer> navigableMap = (NavigableMap) this.aCC.get(cls);
        if (navigableMap == null) {
            navigableMap = new TreeMap();
            this.aCC.put(cls, navigableMap);
        }
        AppMethodBeat.m2505o(91941);
        return navigableMap;
    }

    /* renamed from: V */
    private <T> C25407a<T> m51856V(T t) {
        AppMethodBeat.m2504i(91942);
        C25407a q = m51862q(t.getClass());
        AppMethodBeat.m2505o(91942);
        return q;
    }

    /* renamed from: q */
    private <T> C25407a<T> m51862q(Class<T> cls) {
        AppMethodBeat.m2504i(91943);
        C25407a<T> c25407a = (C25407a) this.aCD.get(cls);
        if (c25407a == null) {
            if (cls.equals(int[].class)) {
                c25407a = new C17516i();
            } else if (cls.equals(byte[].class)) {
                c25407a = new C31926g();
            } else {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
                AppMethodBeat.m2505o(91943);
                throw illegalArgumentException;
            }
            this.aCD.put(cls, c25407a);
        }
        AppMethodBeat.m2505o(91943);
        return c25407a;
    }
}
