package com.tencent.p177mm.plugin.appbrand.game.p895g;

import android.support.p057v4.p065f.C37122k.C8387a;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.tencent.mm.plugin.appbrand.game.g.c */
public abstract class C16612c<T> implements C8387a<T> {
    public ConcurrentLinkedQueue<T> hup = new ConcurrentLinkedQueue();

    public abstract T aAJ();

    /* renamed from: aA */
    public final T mo6364aA() {
        T poll = this.hup.poll();
        if (poll == null) {
            return aAJ();
        }
        return poll;
    }

    public final boolean release(T t) {
        return this.hup.offer(t);
    }
}
