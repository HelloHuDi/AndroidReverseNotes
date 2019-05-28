package com.bumptech.glide.p086c.p088b.p089a;

import com.bumptech.glide.p095h.C45002j;
import java.util.Queue;

/* renamed from: com.bumptech.glide.c.b.a.d */
abstract class C37164d<T extends C31928m> {
    private final Queue<T> aCu = C45002j.m82420dn(20);

    /* renamed from: mR */
    public abstract T mo18619mR();

    C37164d() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: mS */
    public final T mo59240mS() {
        C31928m c31928m = (C31928m) this.aCu.poll();
        if (c31928m == null) {
            return mo18619mR();
        }
        return c31928m;
    }

    /* renamed from: a */
    public final void mo59239a(T t) {
        if (this.aCu.size() < 20) {
            this.aCu.offer(t);
        }
    }
}
