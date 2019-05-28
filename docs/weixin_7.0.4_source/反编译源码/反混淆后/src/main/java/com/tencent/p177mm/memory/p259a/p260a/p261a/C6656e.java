package com.tencent.p177mm.memory.p259a.p260a.p261a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p178a.C1177f.C1174a;
import com.tencent.p177mm.p178a.C1177f.C1175b;
import com.tencent.p177mm.p178a.C6294h;
import java.util.Set;

/* renamed from: com.tencent.mm.memory.a.a.a.e */
public abstract class C6656e<T, V, X, Y> implements C1177f<T, V> {
    public C1177f<T, X> feD = null;
    public C1799d<T, Y> feE = null;
    public C1175b<T, V> feF = null;
    protected C1792a fey;
    public int maxSize;

    /* renamed from: com.tencent.mm.memory.a.a.a.e$1 */
    class C66541 implements C1175b<T, X> {
        C66541() {
        }

        /* renamed from: c */
        public final void mo4401c(T t, X x, X x2) {
            AppMethodBeat.m2504i(115467);
            if (C6656e.this.feF != null) {
                C6656e.this.feF.mo4401c(t, C6656e.this.mo14876aV(x), C6656e.this.mo14876aV(x2));
            }
            AppMethodBeat.m2505o(115467);
        }
    }

    /* renamed from: Xn */
    public abstract T mo14873Xn();

    /* renamed from: aV */
    public abstract V mo14876aV(X x);

    /* renamed from: aX */
    public abstract X mo14877aX(V v);

    /* renamed from: o */
    public abstract Y mo14879o(T t, V v);

    /* Access modifiers changed, original: protected */
    /* renamed from: Xo */
    public C1177f<T, X> mo14874Xo() {
        return new C6294h(this.maxSize, new C66541());
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public C1799d<T, Y> mo14875a(C1792a c1792a) {
        return null;
    }

    public C6656e(int i) {
        this.maxSize = i;
        init();
    }

    public C6656e(C1175b<T, V> c1175b) {
        this.feF = c1175b;
        this.maxSize = 10;
        init();
    }

    public C6656e(int i, C1175b<T, V> c1175b, C1792a c1792a) {
        this.feF = c1175b;
        this.maxSize = i;
        this.fey = c1792a;
        init();
    }

    /* Access modifiers changed, original: protected */
    public void init() {
        this.feD = mo14874Xo();
        this.feE = mo14875a(this.fey);
    }

    /* renamed from: k */
    public void mo4412k(T t, V v) {
        this.feD.mo4412k(t, mo14877aX(v));
        if (this.feE != null) {
            this.feE.mo5358e(mo14873Xn(), t, mo14879o(t, v));
        }
    }

    public V remove(T t) {
        Object aV = mo14876aV(this.feD.remove(t));
        if (this.feE != null) {
            this.feE.mo5361s(mo14873Xn(), t);
        }
        return aV;
    }

    public V get(T t) {
        Object aV = mo14876aV(this.feD.get(t));
        if (this.feE != null) {
            this.feE.mo5363t(mo14873Xn(), t);
        }
        return aV;
    }

    public V put(T t, V v) {
        Object aV = mo14876aV(this.feD.put(t, mo14877aX(v)));
        if (this.feE != null) {
            this.feE.mo5359f(mo14873Xn(), t, mo14879o(t, v));
        }
        return aV;
    }

    /* renamed from: aj */
    public final boolean mo4405aj(T t) {
        boolean aj = this.feD.mo4405aj(t);
        if (this.feE != null) {
            this.feE.mo5360q(mo14873Xn(), t);
        }
        return aj;
    }

    public final void clear() {
        this.feD.clear();
    }

    /* renamed from: ai */
    public V mo4404ai(T t) {
        Object aV = mo14876aV(this.feD.mo4404ai(t));
        if (this.feE != null) {
            this.feE.mo5365u(mo14873Xn(), t);
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
        return this.feD.sizeOf(t, mo14877aX(v));
    }

    /* renamed from: a */
    public final void mo4403a(final C1174a<T, V> c1174a) {
        this.feD.mo4403a(new C1174a<T, X>() {
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

    /* renamed from: ak */
    public final boolean mo4406ak(T t) {
        boolean ak = this.feD.mo4406ak(t);
        if (this.feE != null) {
            this.feE.mo5366v(mo14873Xn(), t);
        }
        return ak;
    }

    public final Set<T> keySet() {
        return this.feD.keySet();
    }
}
