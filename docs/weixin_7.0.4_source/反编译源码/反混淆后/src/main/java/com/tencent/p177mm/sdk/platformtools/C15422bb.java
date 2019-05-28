package com.tencent.p177mm.sdk.platformtools;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.sdk.platformtools.bb */
public final class C15422bb<K, V> {
    public final C7564ap che;
    public volatile boolean chh = false;
    public final C4993ae<K, C15426a<V>> exy;
    private final long threshold;
    private final long timeoutMillis;
    public final LinkedHashMap<K, C15421b<K, V>> xBc = new LinkedHashMap();
    private final C15424c<K, V> xBd;
    public final C7564ap xBe;
    private final long xBf;
    private boolean xBg = true;

    /* renamed from: com.tencent.mm.sdk.platformtools.bb$b */
    public static class C15421b<K, V> {
        public K aCx;
        public V values;
        public int xBj;
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.bb$1 */
    class C154231 implements C5015a {
        C154231() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(52240);
            long currentTimeMillis = System.currentTimeMillis();
            C15422bb.this.mo27468pl(false);
            C4990ab.m7416i("MicroMsg.RWCache", "summer timer onTimerExpired e appendAll takes: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            AppMethodBeat.m2505o(52240);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.bb$c */
    public interface C15424c<K, V> {
        /* renamed from: a */
        void mo27469a(C15421b<K, V> c15421b);

        boolean akm();

        void akn();
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.bb$2 */
    class C154252 implements C5015a {
        C154252() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            C15422bb.this.chh = true;
            return false;
        }
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.bb$a */
    static class C15426a<V> {
        final V xBi;

        C15426a(V v) {
            this.xBi = v;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(52241);
            if (obj == null) {
                AppMethodBeat.m2505o(52241);
                return false;
            } else if (obj instanceof C15426a) {
                C15426a c15426a = (C15426a) obj;
                if (this.xBi != null) {
                    boolean equals = this.xBi.equals(c15426a.xBi);
                    AppMethodBeat.m2505o(52241);
                    return equals;
                } else if (c15426a.xBi == null) {
                    AppMethodBeat.m2505o(52241);
                    return true;
                } else {
                    AppMethodBeat.m2505o(52241);
                    return false;
                }
            } else {
                AppMethodBeat.m2505o(52241);
                return false;
            }
        }
    }

    public C15422bb(C15424c<K, V> c15424c, Looper looper, int i, int i2) {
        long j = 60000;
        AppMethodBeat.m2504i(52242);
        IllegalArgumentException illegalArgumentException;
        if (looper == null) {
            illegalArgumentException = new IllegalArgumentException("arg looper can not be null!");
            AppMethodBeat.m2505o(52242);
            throw illegalArgumentException;
        } else if (i <= 0) {
            illegalArgumentException = new IllegalArgumentException("arg size can not be <= 0!");
            AppMethodBeat.m2505o(52242);
            throw illegalArgumentException;
        } else {
            long j2;
            this.xBd = c15424c;
            this.exy = new C4993ae(i);
            this.threshold = i2 > 0 ? (long) i2 : 40;
            if (300000 > 0) {
                j2 = 300000;
            } else {
                j2 = 60000;
            }
            this.xBf = j2;
            if (1000 > 0) {
                j = 1000;
            }
            this.timeoutMillis = j;
            this.che = new C7564ap(looper, new C154231(), false);
            this.xBe = new C7564ap(new C5004al("RWCache_timeoutChecker").oAl.getLooper(), new C154252(), false);
            AppMethodBeat.m2505o(52242);
        }
    }

    public final V get(K k) {
        AppMethodBeat.m2504i(52243);
        if (k == null) {
            NullPointerException nullPointerException = new NullPointerException("key == null");
            AppMethodBeat.m2505o(52243);
            throw nullPointerException;
        }
        C15426a c15426a = (C15426a) this.exy.get(k);
        if (c15426a != null) {
            Object obj = c15426a.xBi;
            AppMethodBeat.m2505o(52243);
            return obj;
        }
        this.exy.put(k, new C15426a(null));
        AppMethodBeat.m2505o(52243);
        return null;
    }

    /* renamed from: A */
    public final boolean mo27466A(K k, V v) {
        AppMethodBeat.m2504i(52244);
        if (k == null) {
            NullPointerException nullPointerException = new NullPointerException("key == null");
            AppMethodBeat.m2505o(52244);
            throw nullPointerException;
        }
        C15426a c15426a = (C15426a) this.exy.get(k);
        C15426a c15426a2 = new C15426a(v);
        if (c15426a2.equals(c15426a)) {
            AppMethodBeat.m2505o(52244);
            return false;
        }
        int i;
        this.exy.put(k, c15426a2);
        C15421b c15421b = new C15421b();
        c15421b.aCx = k;
        c15421b.values = v;
        if (v == null) {
            i = 2;
        } else {
            i = 1;
        }
        c15421b.xBj = i;
        m23699a(k, c15421b);
        AppMethodBeat.m2505o(52244);
        return true;
    }

    /* renamed from: pl */
    public final void mo27468pl(boolean z) {
        AppMethodBeat.m2504i(52245);
        C4990ab.m7416i("MicroMsg.RWCache", "summer appendAll force: " + z + " tid: " + Thread.currentThread().getId() + " holderMap size: " + this.xBc.size());
        synchronized (this) {
            try {
                this.xBg = true;
                if (this.xBc.isEmpty()) {
                } else if (this.xBd.akm()) {
                    Iterator it = this.xBc.entrySet().iterator();
                    if (z) {
                        while (it.hasNext()) {
                            this.xBd.mo27469a((C15421b) ((Entry) it.next()).getValue());
                            it.remove();
                        }
                    } else {
                        this.chh = false;
                        C7564ap c7564ap = this.xBe;
                        long j = this.timeoutMillis;
                        c7564ap.mo16770ae(j, j);
                        while (!this.chh && it.hasNext()) {
                            this.xBd.mo27469a((C15421b) ((Entry) it.next()).getValue());
                            it.remove();
                        }
                        if (this.chh) {
                            C4990ab.m7417i("MicroMsg.RWCache", "summer appendAll timeout size[%d] hasNext[%b] end", Integer.valueOf(this.xBc.size()), Boolean.valueOf(it.hasNext()));
                        }
                        this.xBe.stopTimer();
                    }
                    this.xBd.akn();
                    AppMethodBeat.m2505o(52245);
                } else {
                    AppMethodBeat.m2505o(52245);
                }
            } finally {
                AppMethodBeat.m2505o(52245);
            }
        }
    }

    /* renamed from: a */
    private void m23699a(K k, C15421b<K, V> c15421b) {
        AppMethodBeat.m2504i(52246);
        synchronized (this) {
            try {
                this.xBc.put(k, c15421b);
                if (this.xBg && ((long) this.xBc.size()) > this.threshold) {
                    this.che.mo16770ae(0, 0);
                    this.xBg = false;
                } else if (this.che.doT()) {
                    C7564ap c7564ap = this.che;
                    long j = this.xBf;
                    c7564ap.mo16770ae(j, j);
                }
            } finally {
                AppMethodBeat.m2505o(52246);
            }
        }
    }
}
