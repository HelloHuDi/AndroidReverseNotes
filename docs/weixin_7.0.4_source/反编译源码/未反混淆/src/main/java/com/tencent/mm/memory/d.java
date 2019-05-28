package com.tencent.mm.memory;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class d<T, S> {
    protected Queue<T> fdy = new ConcurrentLinkedQueue();
    protected S fdz;

    public d(S s) {
        this.fdz = s;
    }

    public final T pop() {
        return this.fdy.poll();
    }

    public final void put(T t) {
        this.fdy.add(t);
    }

    public final int size() {
        return this.fdy.size();
    }

    public final S WZ() {
        return this.fdz;
    }
}
