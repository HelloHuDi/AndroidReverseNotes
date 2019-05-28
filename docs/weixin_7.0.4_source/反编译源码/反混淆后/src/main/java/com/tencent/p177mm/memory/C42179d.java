package com.tencent.p177mm.memory;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.tencent.mm.memory.d */
public abstract class C42179d<T, S> {
    protected Queue<T> fdy = new ConcurrentLinkedQueue();
    protected S fdz;

    public C42179d(S s) {
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

    /* renamed from: WZ */
    public final S mo67725WZ() {
        return this.fdz;
    }
}
