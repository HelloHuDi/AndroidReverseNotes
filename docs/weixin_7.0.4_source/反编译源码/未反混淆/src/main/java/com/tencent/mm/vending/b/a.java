package com.tencent.mm.vending.b;

import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.f;
import com.tencent.mm.vending.h.g;
import java.util.LinkedList;
import junit.framework.Assert;

public abstract class a<_Callback> {
    private LinkedList<b> a;
    protected d ceu;
    protected f zXB;

    public a() {
        this(g.dMq());
    }

    public a(d dVar) {
        this.a = new LinkedList();
        Assert.assertNotNull(dVar);
        this.ceu = dVar;
        this.zXB = new f(dVar, null);
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    public final synchronized b a(b bVar) {
        this.a.add(bVar);
        return bVar;
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    public final synchronized void b(b bVar) {
        this.a.remove(bVar);
    }

    public final synchronized LinkedList<b> dMf() {
        return dMg();
    }

    /* Access modifiers changed, original: protected|final */
    public final LinkedList<b> dMg() {
        return new LinkedList(this.a);
    }

    public final synchronized int size() {
        return this.a.size();
    }

    public final synchronized boolean contains(_Callback _callback) {
        return this.a.contains(new b(_callback, this));
    }
}
