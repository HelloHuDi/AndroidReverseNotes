package com.tencent.p177mm.memory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.NavigableMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentSkipListMap;

/* renamed from: com.tencent.mm.memory.e */
public abstract class C42181e<T, S extends Comparable> {
    protected NavigableMap<S, C42179d<T, S>> fdA = new ConcurrentSkipListMap();
    private Vector<C42180a> fdB = new Vector();
    protected long fdC = 0;

    /* renamed from: com.tencent.mm.memory.e$1 */
    class C264051 implements Runnable {
        C264051() {
        }

        public final void run() {
            AppMethodBeat.m2504i(115370);
            C42181e.m74397a(C42181e.this);
            AppMethodBeat.m2505o(115370);
        }
    }

    /* renamed from: com.tencent.mm.memory.e$a */
    public abstract class C42180a {
        /* renamed from: Xa */
        public abstract S mo25487Xa();

        /* renamed from: Xb */
        public abstract long mo25488Xb();

        /* renamed from: Xc */
        public abstract int mo25489Xc();
    }

    /* renamed from: WW */
    public abstract long mo20953WW();

    /* renamed from: WX */
    public abstract long mo20954WX();

    /* renamed from: aS */
    public abstract long mo20958aS(T t);

    /* renamed from: aT */
    public abstract S mo20959aT(T t);

    /* renamed from: b */
    public abstract S mo20960b(S s);

    /* renamed from: c */
    public abstract C42179d<T, S> mo20961c(S s);

    /* renamed from: d */
    public abstract T mo20962d(S s);

    /* renamed from: a */
    public final void mo67730a(C42180a c42180a) {
        this.fdB.add(c42180a);
        C4990ab.m7417i("MicroMsg.BucketPool", "%s addPreload: %s", this, c42180a);
        mo67729Dw();
    }

    /* renamed from: Dw */
    public final void mo67729Dw() {
        if (this.fdB.size() > 0) {
            C7305d.post(new C264051(), "BucketPool_preload");
        }
    }

    /* renamed from: a */
    public synchronized T mo20956a(S s) {
        T t;
        C42179d c42179d = (C42179d) this.fdA.get(s);
        if (c42179d == null || c42179d.size() <= 0) {
            C4990ab.m7411d("MicroMsg.BucketPool", "BucketPool get cannot get %s size", s);
            t = null;
        } else {
            T pop = c42179d.pop();
            this.fdA.put(c42179d.mo67725WZ(), c42179d);
            mo67731fj(mo20958aS(pop));
            t = pop;
        }
        return t;
    }

    /* renamed from: aR */
    public synchronized void mo20957aR(T t) {
        if (t != null) {
            Comparable aT = mo20959aT(t);
            long aS = mo20958aS(t);
            if (aS > mo20954WX()) {
                C4990ab.m7413e("MicroMsg.BucketPool", "release, reach maximum element size: %s, ignore this", Long.valueOf(aS));
            } else if (this.fdC + aS > mo20953WW()) {
                C4990ab.m7413e("MicroMsg.BucketPool", "release, reach maximum size, just ignore %s %s", Long.valueOf(aS), Long.valueOf(this.fdC));
            } else {
                C42179d c42179d = (C42179d) this.fdA.get(aT);
                if (c42179d == null) {
                    c42179d = mo20961c(aT);
                }
                c42179d.put(t);
                this.fdA.put(aT, c42179d);
                m74398fi(aS);
            }
        }
    }

    /* renamed from: fi */
    private synchronized void m74398fi(long j) {
        this.fdC += j;
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    /* renamed from: fj */
    public final synchronized void mo67731fj(long j) {
        this.fdC -= j;
    }

    /* renamed from: WY */
    public void mo45830WY() {
        C4990ab.m7417i("MicroMsg.BucketPool", "freeAll: %s", getClass().getName());
        this.fdA.clear();
        this.fdC = 0;
    }
}
