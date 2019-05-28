package com.tencent.p177mm.sdk.p604g.p606b;

import java.util.concurrent.Executor;

/* renamed from: com.tencent.mm.sdk.g.b.a */
public interface C4946a extends Executor {
    int getCorePoolSize();

    /* renamed from: p */
    void mo10173p(Runnable runnable, long j);

    boolean remove(Runnable runnable);

    void reset();

    void shutdown();
}
