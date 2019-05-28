package a.i.b.a.c.k;

import a.k.v;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class b implements i {
    static final /* synthetic */ boolean $assertionsDisabled = (!b.class.desiredAssertionStatus());
    public static final i BIH = new b("NO_LOCKS", c.BIO, e.BIZ) {
        /* Access modifiers changed, original: protected|final */
        public final <T> j<T> ekd() {
            AppMethodBeat.i(122432);
            j ekg = j.ekg();
            AppMethodBeat.o(122432);
            return ekg;
        }
    };
    private static final String PACKAGE_NAME;
    private final c BII;
    private final String BIJ;
    protected final Lock aCZ;

    static class f<T> extends e<T> implements f<T> {
        static final /* synthetic */ boolean $assertionsDisabled = (!b.class.desiredAssertionStatus());

        static {
            AppMethodBeat.i(122447);
            AppMethodBeat.o(122447);
        }

        public f(b bVar, a.f.a.a<? extends T> aVar) {
            super(bVar, aVar);
        }

        public final T invoke() {
            AppMethodBeat.i(122446);
            Object invoke = super.invoke();
            if ($assertionsDisabled || invoke != null) {
                AppMethodBeat.o(122446);
                return invoke;
            }
            AssertionError assertionError = new AssertionError("compute() returned null");
            AppMethodBeat.o(122446);
            throw assertionError;
        }
    }

    static class e<T> implements g<T> {
        private final b BIQ;
        private final a.f.a.a<? extends T> BIR;
        private volatile Object value = i.NOT_COMPUTED;

        public e(b bVar, a.f.a.a<? extends T> aVar) {
            this.BIQ = bVar;
            this.BIR = aVar;
        }

        public final boolean ekf() {
            return (this.value == i.NOT_COMPUTED || this.value == i.COMPUTING) ? false : true;
        }

        public T invoke() {
            AppMethodBeat.i(122444);
            Object obj = this.value;
            if (obj instanceof i) {
                this.BIQ.aCZ.lock();
                i iVar = this.value;
                T value;
                if (iVar instanceof i) {
                    if (iVar == i.COMPUTING) {
                        this.value = i.RECURSION_WAS_DETECTED;
                        j rZ = rZ(true);
                        if (!rZ.BIY) {
                            value = rZ.getValue();
                            this.BIQ.aCZ.unlock();
                            AppMethodBeat.o(122444);
                            return value;
                        }
                    }
                    try {
                        if (iVar == i.RECURSION_WAS_DETECTED) {
                            j rZ2 = rZ(false);
                            if (!rZ2.BIY) {
                                value = rZ2.getValue();
                                this.BIQ.aCZ.unlock();
                                AppMethodBeat.o(122444);
                                return value;
                            }
                        }
                        this.value = i.COMPUTING;
                        value = this.BIR.invoke();
                        this.value = value;
                        dS(value);
                        this.BIQ.aCZ.unlock();
                        AppMethodBeat.o(122444);
                        return value;
                    } catch (Throwable th) {
                        this.BIQ.aCZ.unlock();
                        AppMethodBeat.o(122444);
                    }
                } else {
                    value = a.i.b.a.c.n.j.dY(iVar);
                    this.BIQ.aCZ.unlock();
                    AppMethodBeat.o(122444);
                    return value;
                }
            }
            obj = a.i.b.a.c.n.j.dY(obj);
            AppMethodBeat.o(122444);
            return obj;
        }

        /* Access modifiers changed, original: protected */
        public j<T> rZ(boolean z) {
            AppMethodBeat.i(122445);
            j ekd = this.BIQ.ekd();
            AppMethodBeat.o(122445);
            return ekd;
        }

        /* Access modifiers changed, original: protected */
        public void dS(T t) {
        }
    }

    static class g<K, V> implements d<K, V> {
        final b BIQ;
        private final ConcurrentMap<K, Object> BIS;
        private final a.f.a.b<? super K, ? extends V> BIT;

        public g(b bVar, ConcurrentMap<K, Object> concurrentMap, a.f.a.b<? super K, ? extends V> bVar2) {
            this.BIQ = bVar;
            this.BIS = concurrentMap;
            this.BIT = bVar2;
        }

        public V am(K k) {
            AppMethodBeat.i(122448);
            i iVar = this.BIS.get(k);
            if (iVar == null || iVar == i.COMPUTING) {
                this.BIQ.aCZ.lock();
                AssertionError assertionError;
                try {
                    iVar = this.BIS.get(k);
                    V dX;
                    if (iVar == i.COMPUTING) {
                        assertionError = (AssertionError) b.p(new AssertionError("Recursion detected on input: " + k + " under " + this.BIQ));
                        AppMethodBeat.o(122448);
                        throw assertionError;
                    } else if (iVar != null) {
                        dX = a.i.b.a.c.n.j.dX(iVar);
                        this.BIQ.aCZ.unlock();
                        AppMethodBeat.o(122448);
                        return dX;
                    } else {
                        this.BIS.put(k, i.COMPUTING);
                        dX = this.BIT.am(k);
                        i put = this.BIS.put(k, a.i.b.a.c.n.j.dW(dX));
                        if (put != i.COMPUTING) {
                            AssertionError J = J(k, put);
                            AppMethodBeat.o(122448);
                            throw J;
                        }
                        this.BIQ.aCZ.unlock();
                        AppMethodBeat.o(122448);
                        return dX;
                    }
                } catch (Throwable th) {
                    this.BIQ.aCZ.unlock();
                    AppMethodBeat.o(122448);
                }
            } else {
                Object dX2 = a.i.b.a.c.n.j.dX(iVar);
                AppMethodBeat.o(122448);
                return dX2;
            }
        }

        private AssertionError J(K k, Object obj) {
            AppMethodBeat.i(122449);
            AssertionError assertionError = (AssertionError) b.p(new AssertionError("Race condition detected on input " + k + ". Old value is " + obj + " under " + this.BIQ));
            AppMethodBeat.o(122449);
            return assertionError;
        }
    }

    static class h<K, V> extends g<K, V> implements c<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = (!b.class.desiredAssertionStatus());

        static {
            AppMethodBeat.i(122451);
            AppMethodBeat.o(122451);
        }

        public h(b bVar, ConcurrentMap<K, Object> concurrentMap, a.f.a.b<? super K, ? extends V> bVar2) {
            super(bVar, concurrentMap, bVar2);
        }

        public final V am(K k) {
            AppMethodBeat.i(122450);
            Object am = super.am(k);
            if ($assertionsDisabled || am != null) {
                AppMethodBeat.o(122450);
                return am;
            }
            AssertionError assertionError = new AssertionError("compute() returned null under " + this.BIQ);
            AppMethodBeat.o(122450);
            throw assertionError;
        }
    }

    static class a<K, V> extends b<K, V> implements a<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = (!b.class.desiredAssertionStatus());

        static {
            AppMethodBeat.i(122437);
            AppMethodBeat.o(122437);
        }

        /* synthetic */ a(b bVar, ConcurrentMap concurrentMap, byte b) {
            this(bVar, concurrentMap);
        }

        private a(b bVar, ConcurrentMap<d<K, V>, Object> concurrentMap) {
            super(bVar, concurrentMap, (byte) 0);
        }

        public final V b(K k, a.f.a.a<? extends V> aVar) {
            AppMethodBeat.i(122436);
            Object b = super.b(k, aVar);
            if ($assertionsDisabled || b != null) {
                AppMethodBeat.o(122436);
                return b;
            }
            AssertionError assertionError = new AssertionError("computeIfAbsent() returned null under " + this.BIQ);
            AppMethodBeat.o(122436);
            throw assertionError;
        }
    }

    static class b<K, V> extends g<d<K, V>, V> {
        /* synthetic */ b(b bVar, ConcurrentMap concurrentMap, byte b) {
            this(bVar, concurrentMap);
        }

        private b(b bVar, ConcurrentMap<d<K, V>, Object> concurrentMap) {
            super(bVar, concurrentMap, new a.f.a.b<d<K, V>, V>() {
                public final /* synthetic */ Object am(Object obj) {
                    AppMethodBeat.i(122438);
                    Object invoke = ((d) obj).BIP.invoke();
                    AppMethodBeat.o(122438);
                    return invoke;
                }
            });
            AppMethodBeat.i(122439);
            AppMethodBeat.o(122439);
        }

        public V b(K k, a.f.a.a<? extends V> aVar) {
            AppMethodBeat.i(122440);
            Object am = am(new d(k, aVar));
            AppMethodBeat.o(122440);
            return am;
        }
    }

    static class d<K, V> {
        final a.f.a.a<? extends V> BIP;
        private final K aCx;

        public d(K k, a.f.a.a<? extends V> aVar) {
            this.aCx = k;
            this.BIP = aVar;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(122442);
            if (this == obj) {
                AppMethodBeat.o(122442);
                return true;
            } else if (obj == null || getClass() != obj.getClass()) {
                AppMethodBeat.o(122442);
                return false;
            } else {
                if (this.aCx.equals(((d) obj).aCx)) {
                    AppMethodBeat.o(122442);
                    return true;
                }
                AppMethodBeat.o(122442);
                return false;
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(122443);
            int hashCode = this.aCx.hashCode();
            AppMethodBeat.o(122443);
            return hashCode;
        }
    }

    enum i {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED;

        static {
            AppMethodBeat.o(122454);
        }
    }

    static class j<T> {
        static final /* synthetic */ boolean $assertionsDisabled = (!b.class.desiredAssertionStatus());
        final boolean BIY;
        private final T value;

        static {
            AppMethodBeat.i(122459);
            AppMethodBeat.o(122459);
        }

        public static <T> j<T> dT(T t) {
            AppMethodBeat.i(122455);
            j jVar = new j(t, false);
            AppMethodBeat.o(122455);
            return jVar;
        }

        public static <T> j<T> ekg() {
            AppMethodBeat.i(122456);
            j jVar = new j(null, true);
            AppMethodBeat.o(122456);
            return jVar;
        }

        private j(T t, boolean z) {
            this.value = t;
            this.BIY = z;
        }

        public final T getValue() {
            AppMethodBeat.i(122457);
            if ($assertionsDisabled || !this.BIY) {
                Object obj = this.value;
                AppMethodBeat.o(122457);
                return obj;
            }
            AssertionError assertionError = new AssertionError("A value requested from FALL_THROUGH in ".concat(String.valueOf(this)));
            AppMethodBeat.o(122457);
            throw assertionError;
        }

        public final String toString() {
            AppMethodBeat.i(122458);
            String str;
            if (this.BIY) {
                str = "FALL_THROUGH";
                AppMethodBeat.o(122458);
                return str;
            }
            str = String.valueOf(this.value);
            AppMethodBeat.o(122458);
            return str;
        }
    }

    public interface c {
        public static final c BIO = new c() {
            public final RuntimeException q(Throwable th) {
                AppMethodBeat.i(122441);
                a.f.b.j.p(th, "e");
                AppMethodBeat.o(122441);
                throw th;
            }
        };

        RuntimeException q(Throwable th);
    }

    static {
        String str;
        AppMethodBeat.i(122473);
        String canonicalName = b.class.getCanonicalName();
        String str2 = ".";
        String str3 = "";
        a.f.b.j.p(canonicalName, "receiver$0");
        a.f.b.j.p(str2, "delimiter");
        a.f.b.j.p(str3, "missingDelimiterValue");
        int d = v.d((CharSequence) canonicalName, str2);
        if (d == -1) {
            str = str3;
        } else {
            str = canonicalName.substring(0, d);
            a.f.b.j.o(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        PACKAGE_NAME = str;
        AppMethodBeat.o(122473);
    }

    /* synthetic */ b(String str, c cVar, Lock lock, byte b) {
        this(str, cVar, lock);
    }

    static /* synthetic */ Throwable p(Throwable th) {
        AppMethodBeat.i(122472);
        Throwable o = o(th);
        AppMethodBeat.o(122472);
        return o;
    }

    private b(String str, c cVar, Lock lock) {
        this.aCZ = lock;
        this.BII = cVar;
        this.BIJ = str;
    }

    public b() {
        this("<unknown creating class>", c.BIO, new ReentrantLock());
        AppMethodBeat.i(122460);
        AppMethodBeat.o(122460);
    }

    public String toString() {
        AppMethodBeat.i(122461);
        String str = getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.BIJ + ")";
        AppMethodBeat.o(122461);
        return str;
    }

    public final <K, V> c<K, V> f(a.f.a.b<? super K, ? extends V> bVar) {
        AppMethodBeat.i(122462);
        h hVar = new h(this, ekc(), bVar);
        AppMethodBeat.o(122462);
        return hVar;
    }

    public final <K, V> d<K, V> g(a.f.a.b<? super K, ? extends V> bVar) {
        AppMethodBeat.i(122463);
        g gVar = new g(this, ekc(), bVar);
        AppMethodBeat.o(122463);
        return gVar;
    }

    public final <T> f<T> i(a.f.a.a<? extends T> aVar) {
        AppMethodBeat.i(122464);
        f fVar = new f(this, aVar);
        AppMethodBeat.o(122464);
        return fVar;
    }

    public final <T> f<T> a(a.f.a.a<? extends T> aVar, final T t) {
        AppMethodBeat.i(122465);
        AnonymousClass2 anonymousClass2 = new f<T>(this, aVar) {
            /* Access modifiers changed, original: protected|final */
            public final j<T> rZ(boolean z) {
                AppMethodBeat.i(122433);
                j dT = j.dT(t);
                AppMethodBeat.o(122433);
                return dT;
            }
        };
        AppMethodBeat.o(122465);
        return anonymousClass2;
    }

    public final <T> f<T> a(a.f.a.a<? extends T> aVar, a.f.a.b<? super Boolean, ? extends T> bVar, a.f.a.b<? super T, y> bVar2) {
        AppMethodBeat.i(122466);
        final a.f.a.b<? super Boolean, ? extends T> bVar3 = bVar;
        final a.f.a.b<? super T, y> bVar4 = bVar2;
        AnonymousClass3 anonymousClass3 = new f<T>(this, aVar) {
            /* Access modifiers changed, original: protected|final */
            public final j<T> rZ(boolean z) {
                AppMethodBeat.i(122434);
                if (bVar3 == null) {
                    j rZ = super.rZ(z);
                    AppMethodBeat.o(122434);
                    return rZ;
                }
                j<T> dT = j.dT(bVar3.am(Boolean.valueOf(z)));
                AppMethodBeat.o(122434);
                return dT;
            }

            /* Access modifiers changed, original: protected|final */
            public final void dS(T t) {
                AppMethodBeat.i(122435);
                bVar4.am(t);
                AppMethodBeat.o(122435);
            }
        };
        AppMethodBeat.o(122466);
        return anonymousClass3;
    }

    public final <T> g<T> j(a.f.a.a<? extends T> aVar) {
        AppMethodBeat.i(122467);
        e eVar = new e(this, aVar);
        AppMethodBeat.o(122467);
        return eVar;
    }

    private static <K> ConcurrentMap<K, Object> ekc() {
        AppMethodBeat.i(122468);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(3, 1.0f, 2);
        AppMethodBeat.o(122468);
        return concurrentHashMap;
    }

    /* Access modifiers changed, original: protected */
    public <T> j<T> ekd() {
        AppMethodBeat.i(122469);
        IllegalStateException illegalStateException = (IllegalStateException) o(new IllegalStateException("Recursive call in a lazy value under ".concat(String.valueOf(this))));
        AppMethodBeat.o(122469);
        throw illegalStateException;
    }

    private static <T extends Throwable> T o(T t) {
        AppMethodBeat.i(122470);
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
            AppMethodBeat.o(122470);
            return t;
        }
        AssertionError assertionError = new AssertionError("This method should only be called on exceptions created in LockBasedStorageManager");
        AppMethodBeat.o(122470);
        throw assertionError;
    }

    public final <K, V> a<K, V> eke() {
        AppMethodBeat.i(122471);
        a aVar = new a(this, ekc(), (byte) 0);
        AppMethodBeat.o(122471);
        return aVar;
    }
}
