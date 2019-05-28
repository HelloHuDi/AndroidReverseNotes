package com.tencent.mm.sdk.g.b;

import java.util.concurrent.Executor;

public interface a extends Executor {
    int getCorePoolSize();

    void p(Runnable runnable, long j);

    boolean remove(Runnable runnable);

    void reset();

    void shutdown();
}
