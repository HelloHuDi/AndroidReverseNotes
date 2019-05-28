package com.bumptech.glide.c.b.a;

import com.bumptech.glide.h.j;
import java.util.Queue;

abstract class d<T extends m> {
    private final Queue<T> aCu = j.dn(20);

    public abstract T mR();

    d() {
    }

    /* Access modifiers changed, original: final */
    public final T mS() {
        m mVar = (m) this.aCu.poll();
        if (mVar == null) {
            return mR();
        }
        return mVar;
    }

    public final void a(T t) {
        if (this.aCu.size() < 20) {
            this.aCu.offer(t);
        }
    }
}
