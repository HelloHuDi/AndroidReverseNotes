package com.tencent.matrix.resource.p167d.p168a;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.tencent.matrix.resource.d.a.a */
public final class C1115a<T> {
    public final AtomicReference<T> bXP = new AtomicReference();
    public final CountDownLatch bXQ = new CountDownLatch(1);

    /* renamed from: a */
    public final boolean mo4329a(TimeUnit timeUnit) {
        try {
            return this.bXQ.await(5, timeUnit);
        } catch (InterruptedException e) {
            throw new RuntimeException("Did not expect thread to be interrupted", e);
        }
    }
}
