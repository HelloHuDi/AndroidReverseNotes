package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class bb<K, V> {
    public final ap che;
    public volatile boolean chh = false;
    public final ae<K, a<V>> exy;
    private final long threshold;
    private final long timeoutMillis;
    public final LinkedHashMap<K, b<K, V>> xBc = new LinkedHashMap();
    private final c<K, V> xBd;
    public final ap xBe;
    private final long xBf;
    private boolean xBg = true;

    public static class b<K, V> {
        public K aCx;
        public V values;
        public int xBj;
    }

    public interface c<K, V> {
        void a(b<K, V> bVar);

        boolean akm();

        void akn();
    }

    static class a<V> {
        final V xBi;

        a(V v) {
            this.xBi = v;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(52241);
            if (obj == null) {
                AppMethodBeat.o(52241);
                return false;
            } else if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.xBi != null) {
                    boolean equals = this.xBi.equals(aVar.xBi);
                    AppMethodBeat.o(52241);
                    return equals;
                } else if (aVar.xBi == null) {
                    AppMethodBeat.o(52241);
                    return true;
                } else {
                    AppMethodBeat.o(52241);
                    return false;
                }
            } else {
                AppMethodBeat.o(52241);
                return false;
            }
        }
    }

    public bb(c<K, V> cVar, Looper looper, int i, int i2) {
        long j = 60000;
        AppMethodBeat.i(52242);
        IllegalArgumentException illegalArgumentException;
        if (looper == null) {
            illegalArgumentException = new IllegalArgumentException("arg looper can not be null!");
            AppMethodBeat.o(52242);
            throw illegalArgumentException;
        } else if (i <= 0) {
            illegalArgumentException = new IllegalArgumentException("arg size can not be <= 0!");
            AppMethodBeat.o(52242);
            throw illegalArgumentException;
        } else {
            long j2;
            this.xBd = cVar;
            this.exy = new ae(i);
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
            this.che = new ap(looper, new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(52240);
                    long currentTimeMillis = System.currentTimeMillis();
                    bb.this.pl(false);
                    ab.i("MicroMsg.RWCache", "summer timer onTimerExpired e appendAll takes: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    AppMethodBeat.o(52240);
                    return false;
                }
            }, false);
            this.xBe = new ap(new al("RWCache_timeoutChecker").oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    bb.this.chh = true;
                    return false;
                }
            }, false);
            AppMethodBeat.o(52242);
        }
    }

    public final V get(K k) {
        AppMethodBeat.i(52243);
        if (k == null) {
            NullPointerException nullPointerException = new NullPointerException("key == null");
            AppMethodBeat.o(52243);
            throw nullPointerException;
        }
        a aVar = (a) this.exy.get(k);
        if (aVar != null) {
            Object obj = aVar.xBi;
            AppMethodBeat.o(52243);
            return obj;
        }
        this.exy.put(k, new a(null));
        AppMethodBeat.o(52243);
        return null;
    }

    public final boolean A(K k, V v) {
        AppMethodBeat.i(52244);
        if (k == null) {
            NullPointerException nullPointerException = new NullPointerException("key == null");
            AppMethodBeat.o(52244);
            throw nullPointerException;
        }
        a aVar = (a) this.exy.get(k);
        a aVar2 = new a(v);
        if (aVar2.equals(aVar)) {
            AppMethodBeat.o(52244);
            return false;
        }
        int i;
        this.exy.put(k, aVar2);
        b bVar = new b();
        bVar.aCx = k;
        bVar.values = v;
        if (v == null) {
            i = 2;
        } else {
            i = 1;
        }
        bVar.xBj = i;
        a(k, bVar);
        AppMethodBeat.o(52244);
        return true;
    }

    public final void pl(boolean z) {
        AppMethodBeat.i(52245);
        ab.i("MicroMsg.RWCache", "summer appendAll force: " + z + " tid: " + Thread.currentThread().getId() + " holderMap size: " + this.xBc.size());
        synchronized (this) {
            try {
                this.xBg = true;
                if (this.xBc.isEmpty()) {
                } else if (this.xBd.akm()) {
                    Iterator it = this.xBc.entrySet().iterator();
                    if (z) {
                        while (it.hasNext()) {
                            this.xBd.a((b) ((Entry) it.next()).getValue());
                            it.remove();
                        }
                    } else {
                        this.chh = false;
                        ap apVar = this.xBe;
                        long j = this.timeoutMillis;
                        apVar.ae(j, j);
                        while (!this.chh && it.hasNext()) {
                            this.xBd.a((b) ((Entry) it.next()).getValue());
                            it.remove();
                        }
                        if (this.chh) {
                            ab.i("MicroMsg.RWCache", "summer appendAll timeout size[%d] hasNext[%b] end", Integer.valueOf(this.xBc.size()), Boolean.valueOf(it.hasNext()));
                        }
                        this.xBe.stopTimer();
                    }
                    this.xBd.akn();
                    AppMethodBeat.o(52245);
                } else {
                    AppMethodBeat.o(52245);
                }
            } finally {
                AppMethodBeat.o(52245);
            }
        }
    }

    private void a(K k, b<K, V> bVar) {
        AppMethodBeat.i(52246);
        synchronized (this) {
            try {
                this.xBc.put(k, bVar);
                if (this.xBg && ((long) this.xBc.size()) > this.threshold) {
                    this.che.ae(0, 0);
                    this.xBg = false;
                } else if (this.che.doT()) {
                    ap apVar = this.che;
                    long j = this.xBf;
                    apVar.ae(j, j);
                }
            } finally {
                AppMethodBeat.o(52246);
            }
        }
    }
}
