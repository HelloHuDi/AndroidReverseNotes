package com.tencent.mm.plugin.appbrand.game.g;

import android.support.v4.f.k.a;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class c<T> implements a<T> {
    public ConcurrentLinkedQueue<T> hup = new ConcurrentLinkedQueue();

    public abstract T aAJ();

    public final T aA() {
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
