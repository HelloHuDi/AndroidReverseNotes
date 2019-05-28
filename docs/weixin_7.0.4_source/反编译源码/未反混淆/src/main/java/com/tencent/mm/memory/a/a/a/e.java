package com.tencent.mm.memory.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.a.f.a;
import com.tencent.mm.a.f.b;
import com.tencent.mm.a.h;
import java.util.Set;

public abstract class e<T, V, X, Y> implements f<T, V> {
    public f<T, X> feD = null;
    public d<T, Y> feE = null;
    public b<T, V> feF = null;
    protected a fey;
    public int maxSize;

    public abstract T Xn();

    public abstract V aV(X x);

    public abstract X aX(V v);

    public abstract Y o(T t, V v);

    /* Access modifiers changed, original: protected */
    public f<T, X> Xo() {
        return new h(this.maxSize, new b<T, X>() {
            public final void c(T t, X x, X x2) {
                AppMethodBeat.i(115467);
                if (e.this.feF != null) {
                    e.this.feF.c(t, e.this.aV(x), e.this.aV(x2));
                }
                AppMethodBeat.o(115467);
            }
        });
    }

    /* Access modifiers changed, original: protected */
    public d<T, Y> a(a aVar) {
        return null;
    }

    public e(int i) {
        this.maxSize = i;
        init();
    }

    public e(b<T, V> bVar) {
        this.feF = bVar;
        this.maxSize = 10;
        init();
    }

    public e(int i, b<T, V> bVar, a aVar) {
        this.feF = bVar;
        this.maxSize = i;
        this.fey = aVar;
        init();
    }

    /* Access modifiers changed, original: protected */
    public void init() {
        this.feD = Xo();
        this.feE = a(this.fey);
    }

    public void k(T t, V v) {
        this.feD.k(t, aX(v));
        if (this.feE != null) {
            this.feE.e(Xn(), t, o(t, v));
        }
    }

    public V remove(T t) {
        Object aV = aV(this.feD.remove(t));
        if (this.feE != null) {
            this.feE.s(Xn(), t);
        }
        return aV;
    }

    public V get(T t) {
        Object aV = aV(this.feD.get(t));
        if (this.feE != null) {
            this.feE.t(Xn(), t);
        }
        return aV;
    }

    public V put(T t, V v) {
        Object aV = aV(this.feD.put(t, aX(v)));
        if (this.feE != null) {
            this.feE.f(Xn(), t, o(t, v));
        }
        return aV;
    }

    public final boolean aj(T t) {
        boolean aj = this.feD.aj(t);
        if (this.feE != null) {
            this.feE.q(Xn(), t);
        }
        return aj;
    }

    public final void clear() {
        this.feD.clear();
    }

    public V ai(T t) {
        Object aV = aV(this.feD.ai(t));
        if (this.feE != null) {
            this.feE.u(Xn(), t);
        }
        return aV;
    }

    public final int maxSize() {
        return this.feD.maxSize();
    }

    public final void trimToSize(int i) {
        this.feD.trimToSize(i);
    }

    public final int size() {
        return this.feD.size();
    }

    public final int sizeOf(T t, V v) {
        return this.feD.sizeOf(t, aX(v));
    }

    public final void a(final a<T, V> aVar) {
        this.feD.a(new a<T, X>() {
        });
    }

    public final int hitCount() {
        return this.feD.hitCount();
    }

    public final int missCount() {
        return this.feD.missCount();
    }

    public final int createCount() {
        return this.feD.createCount();
    }

    public final int putCount() {
        return this.feD.putCount();
    }

    public final int evictionCount() {
        return this.feD.evictionCount();
    }

    public final boolean ak(T t) {
        boolean ak = this.feD.ak(t);
        if (this.feE != null) {
            this.feE.v(Xn(), t);
        }
        return ak;
    }

    public final Set<T> keySet() {
        return this.feD.keySet();
    }
}
