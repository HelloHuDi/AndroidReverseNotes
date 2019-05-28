package com.tencent.mm.memory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.NavigableMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentSkipListMap;

public abstract class e<T, S extends Comparable> {
    protected NavigableMap<S, d<T, S>> fdA = new ConcurrentSkipListMap();
    private Vector<a> fdB = new Vector();
    protected long fdC = 0;

    public abstract class a {
        public abstract S Xa();

        public abstract long Xb();

        public abstract int Xc();
    }

    public abstract long WW();

    public abstract long WX();

    public abstract long aS(T t);

    public abstract S aT(T t);

    public abstract S b(S s);

    public abstract d<T, S> c(S s);

    public abstract T d(S s);

    public final void a(a aVar) {
        this.fdB.add(aVar);
        ab.i("MicroMsg.BucketPool", "%s addPreload: %s", this, aVar);
        Dw();
    }

    public final void Dw() {
        if (this.fdB.size() > 0) {
            d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(115370);
                    e.a(e.this);
                    AppMethodBeat.o(115370);
                }
            }, "BucketPool_preload");
        }
    }

    public synchronized T a(S s) {
        T t;
        d dVar = (d) this.fdA.get(s);
        if (dVar == null || dVar.size() <= 0) {
            ab.d("MicroMsg.BucketPool", "BucketPool get cannot get %s size", s);
            t = null;
        } else {
            T pop = dVar.pop();
            this.fdA.put(dVar.WZ(), dVar);
            fj(aS(pop));
            t = pop;
        }
        return t;
    }

    public synchronized void aR(T t) {
        if (t != null) {
            Comparable aT = aT(t);
            long aS = aS(t);
            if (aS > WX()) {
                ab.e("MicroMsg.BucketPool", "release, reach maximum element size: %s, ignore this", Long.valueOf(aS));
            } else if (this.fdC + aS > WW()) {
                ab.e("MicroMsg.BucketPool", "release, reach maximum size, just ignore %s %s", Long.valueOf(aS), Long.valueOf(this.fdC));
            } else {
                d dVar = (d) this.fdA.get(aT);
                if (dVar == null) {
                    dVar = c(aT);
                }
                dVar.put(t);
                this.fdA.put(aT, dVar);
                fi(aS);
            }
        }
    }

    private synchronized void fi(long j) {
        this.fdC += j;
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    public final synchronized void fj(long j) {
        this.fdC -= j;
    }

    public void WY() {
        ab.i("MicroMsg.BucketPool", "freeAll: %s", getClass().getName());
        this.fdA.clear();
        this.fdC = 0;
    }
}
