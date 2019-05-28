package com.tencent.p177mm.vending.p636b;

import com.tencent.p177mm.vending.p642h.C5703d;
import com.tencent.p177mm.vending.p642h.C5706f;
import com.tencent.p177mm.vending.p642h.C5707g;
import java.util.LinkedList;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.vending.b.a */
public abstract class C5677a<_Callback> {
    /* renamed from: a */
    private LinkedList<C7358b> f1340a;
    protected C5703d ceu;
    protected C5706f zXB;

    public C5677a() {
        this(C5707g.dMq());
    }

    public C5677a(C5703d c5703d) {
        this.f1340a = new LinkedList();
        Assert.assertNotNull(c5703d);
        this.ceu = c5703d;
        this.zXB = new C5706f(c5703d, null);
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    /* renamed from: a */
    public final synchronized C7358b mo11556a(C7358b c7358b) {
        this.f1340a.add(c7358b);
        return c7358b;
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    /* renamed from: b */
    public final synchronized void mo11557b(C7358b c7358b) {
        this.f1340a.remove(c7358b);
    }

    public final synchronized LinkedList<C7358b> dMf() {
        return dMg();
    }

    /* Access modifiers changed, original: protected|final */
    public final LinkedList<C7358b> dMg() {
        return new LinkedList(this.f1340a);
    }

    public final synchronized int size() {
        return this.f1340a.size();
    }

    public final synchronized boolean contains(_Callback _callback) {
        return this.f1340a.contains(new C7358b(_callback, this));
    }
}
