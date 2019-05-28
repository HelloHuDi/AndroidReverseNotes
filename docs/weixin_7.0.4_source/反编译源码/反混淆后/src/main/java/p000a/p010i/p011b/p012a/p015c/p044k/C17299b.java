package p000a.p010i.p011b.p012a.p015c.p044k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p048n.C37069j;
import p000a.p051k.C31820v;

/* renamed from: a.i.b.a.c.k.b */
public class C17299b implements C25212i {
    static final /* synthetic */ boolean $assertionsDisabled = (!C17299b.class.desiredAssertionStatus());
    public static final C25212i BIH = new C17299b("NO_LOCKS", C17309c.BIO, C41440e.BIZ) {
        /* Access modifiers changed, original: protected|final */
        public final <T> C17308j<T> ekd() {
            AppMethodBeat.m2504i(122432);
            C17308j ekg = C17308j.ekg();
            AppMethodBeat.m2505o(122432);
            return ekg;
        }
    };
    private static final String PACKAGE_NAME;
    private final C17309c BII;
    private final String BIJ;
    protected final Lock aCZ;

    /* renamed from: a.i.b.a.c.k.b$f */
    static class C8227f<T> extends C17300e<T> implements C41441f<T> {
        static final /* synthetic */ boolean $assertionsDisabled = (!C17299b.class.desiredAssertionStatus());

        static {
            AppMethodBeat.m2504i(122447);
            AppMethodBeat.m2505o(122447);
        }

        public C8227f(C17299b c17299b, C31214a<? extends T> c31214a) {
            super(c17299b, c31214a);
        }

        public final T invoke() {
            AppMethodBeat.m2504i(122446);
            Object invoke = super.invoke();
            if ($assertionsDisabled || invoke != null) {
                AppMethodBeat.m2505o(122446);
                return invoke;
            }
            AssertionError assertionError = new AssertionError("compute() returned null");
            AppMethodBeat.m2505o(122446);
            throw assertionError;
        }
    }

    /* renamed from: a.i.b.a.c.k.b$e */
    static class C17300e<T> implements C41442g<T> {
        private final C17299b BIQ;
        private final C31214a<? extends T> BIR;
        private volatile Object value = C17307i.NOT_COMPUTED;

        public C17300e(C17299b c17299b, C31214a<? extends T> c31214a) {
            this.BIQ = c17299b;
            this.BIR = c31214a;
        }

        public final boolean ekf() {
            return (this.value == C17307i.NOT_COMPUTED || this.value == C17307i.COMPUTING) ? false : true;
        }

        public T invoke() {
            AppMethodBeat.m2504i(122444);
            Object obj = this.value;
            if (obj instanceof C17307i) {
                this.BIQ.aCZ.lock();
                C17307i c17307i = this.value;
                T value;
                if (c17307i instanceof C17307i) {
                    if (c17307i == C17307i.COMPUTING) {
                        this.value = C17307i.RECURSION_WAS_DETECTED;
                        C17308j rZ = mo241rZ(true);
                        if (!rZ.BIY) {
                            value = rZ.getValue();
                            this.BIQ.aCZ.unlock();
                            AppMethodBeat.m2505o(122444);
                            return value;
                        }
                    }
                    try {
                        if (c17307i == C17307i.RECURSION_WAS_DETECTED) {
                            C17308j rZ2 = mo241rZ(false);
                            if (!rZ2.BIY) {
                                value = rZ2.getValue();
                                this.BIQ.aCZ.unlock();
                                AppMethodBeat.m2505o(122444);
                                return value;
                            }
                        }
                        this.value = C17307i.COMPUTING;
                        value = this.BIR.invoke();
                        this.value = value;
                        mo242dS(value);
                        this.BIQ.aCZ.unlock();
                        AppMethodBeat.m2505o(122444);
                        return value;
                    } catch (Throwable th) {
                        this.BIQ.aCZ.unlock();
                        AppMethodBeat.m2505o(122444);
                    }
                } else {
                    value = C37069j.m62023dY(c17307i);
                    this.BIQ.aCZ.unlock();
                    AppMethodBeat.m2505o(122444);
                    return value;
                }
            }
            obj = C37069j.m62023dY(obj);
            AppMethodBeat.m2505o(122444);
            return obj;
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: rZ */
        public C17308j<T> mo241rZ(boolean z) {
            AppMethodBeat.m2504i(122445);
            C17308j ekd = this.BIQ.ekd();
            AppMethodBeat.m2505o(122445);
            return ekd;
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: dS */
        public void mo242dS(T t) {
        }
    }

    /* renamed from: a.i.b.a.c.k.b$g */
    static class C17301g<K, V> implements C41439d<K, V> {
        final C17299b BIQ;
        private final ConcurrentMap<K, Object> BIS;
        private final C17126b<? super K, ? extends V> BIT;

        public C17301g(C17299b c17299b, ConcurrentMap<K, Object> concurrentMap, C17126b<? super K, ? extends V> c17126b) {
            this.BIQ = c17299b;
            this.BIS = concurrentMap;
            this.BIT = c17126b;
        }

        /* renamed from: am */
        public V mo50am(K k) {
            AppMethodBeat.m2504i(122448);
            C17307i c17307i = this.BIS.get(k);
            if (c17307i == null || c17307i == C17307i.COMPUTING) {
                this.BIQ.aCZ.lock();
                AssertionError assertionError;
                try {
                    c17307i = this.BIS.get(k);
                    V dX;
                    if (c17307i == C17307i.COMPUTING) {
                        assertionError = (AssertionError) C17299b.m26782p(new AssertionError("Recursion detected on input: " + k + " under " + this.BIQ));
                        AppMethodBeat.m2505o(122448);
                        throw assertionError;
                    } else if (c17307i != null) {
                        dX = C37069j.m62022dX(c17307i);
                        this.BIQ.aCZ.unlock();
                        AppMethodBeat.m2505o(122448);
                        return dX;
                    } else {
                        this.BIS.put(k, C17307i.COMPUTING);
                        dX = this.BIT.mo50am(k);
                        C17307i put = this.BIS.put(k, C37069j.m62021dW(dX));
                        if (put != C17307i.COMPUTING) {
                            AssertionError J = m26791J(k, put);
                            AppMethodBeat.m2505o(122448);
                            throw J;
                        }
                        this.BIQ.aCZ.unlock();
                        AppMethodBeat.m2505o(122448);
                        return dX;
                    }
                } catch (Throwable th) {
                    this.BIQ.aCZ.unlock();
                    AppMethodBeat.m2505o(122448);
                }
            } else {
                Object dX2 = C37069j.m62022dX(c17307i);
                AppMethodBeat.m2505o(122448);
                return dX2;
            }
        }

        /* renamed from: J */
        private AssertionError m26791J(K k, Object obj) {
            AppMethodBeat.m2504i(122449);
            AssertionError assertionError = (AssertionError) C17299b.m26782p(new AssertionError("Race condition detected on input " + k + ". Old value is " + obj + " under " + this.BIQ));
            AppMethodBeat.m2505o(122449);
            return assertionError;
        }
    }

    /* renamed from: a.i.b.a.c.k.b$h */
    static class C17302h<K, V> extends C17301g<K, V> implements C24619c<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = (!C17299b.class.desiredAssertionStatus());

        static {
            AppMethodBeat.m2504i(122451);
            AppMethodBeat.m2505o(122451);
        }

        public C17302h(C17299b c17299b, ConcurrentMap<K, Object> concurrentMap, C17126b<? super K, ? extends V> c17126b) {
            super(c17299b, concurrentMap, c17126b);
        }

        /* renamed from: am */
        public final V mo50am(K k) {
            AppMethodBeat.m2504i(122450);
            Object am = super.mo50am(k);
            if ($assertionsDisabled || am != null) {
                AppMethodBeat.m2505o(122450);
                return am;
            }
            AssertionError assertionError = new AssertionError("compute() returned null under " + this.BIQ);
            AppMethodBeat.m2505o(122450);
            throw assertionError;
        }
    }

    /* renamed from: a.i.b.a.c.k.b$a */
    static class C17303a<K, V> extends C17304b<K, V> implements C17297a<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = (!C17299b.class.desiredAssertionStatus());

        static {
            AppMethodBeat.m2504i(122437);
            AppMethodBeat.m2505o(122437);
        }

        /* synthetic */ C17303a(C17299b c17299b, ConcurrentMap concurrentMap, byte b) {
            this(c17299b, concurrentMap);
        }

        private C17303a(C17299b c17299b, ConcurrentMap<C17306d<K, V>, Object> concurrentMap) {
            super(c17299b, concurrentMap, (byte) 0);
        }

        /* renamed from: b */
        public final V mo31366b(K k, C31214a<? extends V> c31214a) {
            AppMethodBeat.m2504i(122436);
            Object b = super.mo31366b(k, c31214a);
            if ($assertionsDisabled || b != null) {
                AppMethodBeat.m2505o(122436);
                return b;
            }
            AssertionError assertionError = new AssertionError("computeIfAbsent() returned null under " + this.BIQ);
            AppMethodBeat.m2505o(122436);
            throw assertionError;
        }
    }

    /* renamed from: a.i.b.a.c.k.b$b */
    static class C17304b<K, V> extends C17301g<C17306d<K, V>, V> {

        /* renamed from: a.i.b.a.c.k.b$b$1 */
        class C173051 implements C17126b<C17306d<K, V>, V> {
            C173051() {
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                AppMethodBeat.m2504i(122438);
                Object invoke = ((C17306d) obj).BIP.invoke();
                AppMethodBeat.m2505o(122438);
                return invoke;
            }
        }

        /* synthetic */ C17304b(C17299b c17299b, ConcurrentMap concurrentMap, byte b) {
            this(c17299b, concurrentMap);
        }

        private C17304b(C17299b c17299b, ConcurrentMap<C17306d<K, V>, Object> concurrentMap) {
            super(c17299b, concurrentMap, new C173051());
            AppMethodBeat.m2504i(122439);
            AppMethodBeat.m2505o(122439);
        }

        /* renamed from: b */
        public V mo31366b(K k, C31214a<? extends V> c31214a) {
            AppMethodBeat.m2504i(122440);
            Object am = mo50am(new C17306d(k, c31214a));
            AppMethodBeat.m2505o(122440);
            return am;
        }
    }

    /* renamed from: a.i.b.a.c.k.b$d */
    static class C17306d<K, V> {
        final C31214a<? extends V> BIP;
        private final K aCx;

        public C17306d(K k, C31214a<? extends V> c31214a) {
            this.aCx = k;
            this.BIP = c31214a;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(122442);
            if (this == obj) {
                AppMethodBeat.m2505o(122442);
                return true;
            } else if (obj == null || getClass() != obj.getClass()) {
                AppMethodBeat.m2505o(122442);
                return false;
            } else {
                if (this.aCx.equals(((C17306d) obj).aCx)) {
                    AppMethodBeat.m2505o(122442);
                    return true;
                }
                AppMethodBeat.m2505o(122442);
                return false;
            }
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(122443);
            int hashCode = this.aCx.hashCode();
            AppMethodBeat.m2505o(122443);
            return hashCode;
        }
    }

    /* renamed from: a.i.b.a.c.k.b$i */
    enum C17307i {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED;

        static {
            AppMethodBeat.m2505o(122454);
        }
    }

    /* renamed from: a.i.b.a.c.k.b$j */
    static class C17308j<T> {
        static final /* synthetic */ boolean $assertionsDisabled = (!C17299b.class.desiredAssertionStatus());
        final boolean BIY;
        private final T value;

        static {
            AppMethodBeat.m2504i(122459);
            AppMethodBeat.m2505o(122459);
        }

        /* renamed from: dT */
        public static <T> C17308j<T> m26797dT(T t) {
            AppMethodBeat.m2504i(122455);
            C17308j c17308j = new C17308j(t, false);
            AppMethodBeat.m2505o(122455);
            return c17308j;
        }

        public static <T> C17308j<T> ekg() {
            AppMethodBeat.m2504i(122456);
            C17308j c17308j = new C17308j(null, true);
            AppMethodBeat.m2505o(122456);
            return c17308j;
        }

        private C17308j(T t, boolean z) {
            this.value = t;
            this.BIY = z;
        }

        public final T getValue() {
            AppMethodBeat.m2504i(122457);
            if ($assertionsDisabled || !this.BIY) {
                Object obj = this.value;
                AppMethodBeat.m2505o(122457);
                return obj;
            }
            AssertionError assertionError = new AssertionError("A value requested from FALL_THROUGH in ".concat(String.valueOf(this)));
            AppMethodBeat.m2505o(122457);
            throw assertionError;
        }

        public final String toString() {
            AppMethodBeat.m2504i(122458);
            String str;
            if (this.BIY) {
                str = "FALL_THROUGH";
                AppMethodBeat.m2505o(122458);
                return str;
            }
            str = String.valueOf(this.value);
            AppMethodBeat.m2505o(122458);
            return str;
        }
    }

    /* renamed from: a.i.b.a.c.k.b$c */
    public interface C17309c {
        public static final C17309c BIO = new C172981();

        /* renamed from: a.i.b.a.c.k.b$c$1 */
        static class C172981 implements C17309c {
            C172981() {
            }

            /* renamed from: q */
            public final RuntimeException mo31367q(Throwable th) {
                AppMethodBeat.m2504i(122441);
                C25052j.m39376p(th, "e");
                AppMethodBeat.m2505o(122441);
                throw th;
            }
        }

        /* renamed from: q */
        RuntimeException mo31367q(Throwable th);
    }

    static {
        String str;
        AppMethodBeat.m2504i(122473);
        String canonicalName = C17299b.class.getCanonicalName();
        String str2 = ".";
        String str3 = "";
        C25052j.m39376p(canonicalName, "receiver$0");
        C25052j.m39376p(str2, "delimiter");
        C25052j.m39376p(str3, "missingDelimiterValue");
        int d = C31820v.m51539d((CharSequence) canonicalName, str2);
        if (d == -1) {
            str = str3;
        } else {
            str = canonicalName.substring(0, d);
            C25052j.m39375o(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        PACKAGE_NAME = str;
        AppMethodBeat.m2505o(122473);
    }

    /* synthetic */ C17299b(String str, C17309c c17309c, Lock lock, byte b) {
        this(str, c17309c, lock);
    }

    /* renamed from: p */
    static /* synthetic */ Throwable m26782p(Throwable th) {
        AppMethodBeat.m2504i(122472);
        Throwable o = C17299b.m26781o(th);
        AppMethodBeat.m2505o(122472);
        return o;
    }

    private C17299b(String str, C17309c c17309c, Lock lock) {
        this.aCZ = lock;
        this.BII = c17309c;
        this.BIJ = str;
    }

    public C17299b() {
        this("<unknown creating class>", C17309c.BIO, new ReentrantLock());
        AppMethodBeat.m2504i(122460);
        AppMethodBeat.m2505o(122460);
    }

    public String toString() {
        AppMethodBeat.m2504i(122461);
        String str = getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.BIJ + ")";
        AppMethodBeat.m2505o(122461);
        return str;
    }

    /* renamed from: f */
    public final <K, V> C24619c<K, V> mo31371f(C17126b<? super K, ? extends V> c17126b) {
        AppMethodBeat.m2504i(122462);
        C17302h c17302h = new C17302h(this, C17299b.ekc(), c17126b);
        AppMethodBeat.m2505o(122462);
        return c17302h;
    }

    /* renamed from: g */
    public final <K, V> C41439d<K, V> mo31372g(C17126b<? super K, ? extends V> c17126b) {
        AppMethodBeat.m2504i(122463);
        C17301g c17301g = new C17301g(this, C17299b.ekc(), c17126b);
        AppMethodBeat.m2505o(122463);
        return c17301g;
    }

    /* renamed from: i */
    public final <T> C41441f<T> mo31373i(C31214a<? extends T> c31214a) {
        AppMethodBeat.m2504i(122464);
        C8227f c8227f = new C8227f(this, c31214a);
        AppMethodBeat.m2505o(122464);
        return c8227f;
    }

    /* renamed from: a */
    public final <T> C41441f<T> mo31369a(C31214a<? extends T> c31214a, final T t) {
        AppMethodBeat.m2504i(122465);
        C01562 c01562 = new C8227f<T>(this, c31214a) {
            /* Access modifiers changed, original: protected|final */
            /* renamed from: rZ */
            public final C17308j<T> mo241rZ(boolean z) {
                AppMethodBeat.m2504i(122433);
                C17308j dT = C17308j.m26797dT(t);
                AppMethodBeat.m2505o(122433);
                return dT;
            }
        };
        AppMethodBeat.m2505o(122465);
        return c01562;
    }

    /* renamed from: a */
    public final <T> C41441f<T> mo31368a(C31214a<? extends T> c31214a, C17126b<? super Boolean, ? extends T> c17126b, C17126b<? super T, C37091y> c17126b2) {
        AppMethodBeat.m2504i(122466);
        final C17126b<? super Boolean, ? extends T> c17126b3 = c17126b;
        final C17126b<? super T, C37091y> c17126b4 = c17126b2;
        C01573 c01573 = new C8227f<T>(this, c31214a) {
            /* Access modifiers changed, original: protected|final */
            /* renamed from: rZ */
            public final C17308j<T> mo241rZ(boolean z) {
                AppMethodBeat.m2504i(122434);
                if (c17126b3 == null) {
                    C17308j rZ = super.mo241rZ(z);
                    AppMethodBeat.m2505o(122434);
                    return rZ;
                }
                C17308j<T> dT = C17308j.m26797dT(c17126b3.mo50am(Boolean.valueOf(z)));
                AppMethodBeat.m2505o(122434);
                return dT;
            }

            /* Access modifiers changed, original: protected|final */
            /* renamed from: dS */
            public final void mo242dS(T t) {
                AppMethodBeat.m2504i(122435);
                c17126b4.mo50am(t);
                AppMethodBeat.m2505o(122435);
            }
        };
        AppMethodBeat.m2505o(122466);
        return c01573;
    }

    /* renamed from: j */
    public final <T> C41442g<T> mo31374j(C31214a<? extends T> c31214a) {
        AppMethodBeat.m2504i(122467);
        C17300e c17300e = new C17300e(this, c31214a);
        AppMethodBeat.m2505o(122467);
        return c17300e;
    }

    private static <K> ConcurrentMap<K, Object> ekc() {
        AppMethodBeat.m2504i(122468);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(3, 1.0f, 2);
        AppMethodBeat.m2505o(122468);
        return concurrentHashMap;
    }

    /* Access modifiers changed, original: protected */
    public <T> C17308j<T> ekd() {
        AppMethodBeat.m2504i(122469);
        IllegalStateException illegalStateException = (IllegalStateException) C17299b.m26781o(new IllegalStateException("Recursive call in a lazy value under ".concat(String.valueOf(this))));
        AppMethodBeat.m2505o(122469);
        throw illegalStateException;
    }

    /* renamed from: o */
    private static <T extends Throwable> T m26781o(T t) {
        AppMethodBeat.m2504i(122470);
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (i < length) {
            if (!stackTrace[i].getClassName().startsWith(PACKAGE_NAME)) {
                break;
            }
            i++;
        }
        i = -1;
        if ($assertionsDisabled || i >= 0) {
            List subList = Arrays.asList(stackTrace).subList(i, length);
            t.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
            AppMethodBeat.m2505o(122470);
            return t;
        }
        AssertionError assertionError = new AssertionError("This method should only be called on exceptions created in LockBasedStorageManager");
        AppMethodBeat.m2505o(122470);
        throw assertionError;
    }

    public final <K, V> C17297a<K, V> eke() {
        AppMethodBeat.m2504i(122471);
        C17303a c17303a = new C17303a(this, C17299b.ekc(), (byte) 0);
        AppMethodBeat.m2505o(122471);
        return c17303a;
    }
}
