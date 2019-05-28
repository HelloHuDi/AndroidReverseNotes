package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class bv implements ThreadFactory {
    private static final AtomicInteger a = new AtomicInteger(1);
    private final ThreadGroup b;
    private final AtomicInteger c = new AtomicInteger(1);
    private final String d;

    static {
        AppMethodBeat.i(98587);
        AppMethodBeat.o(98587);
    }

    public bv(String str) {
        AppMethodBeat.i(98585);
        SecurityManager securityManager = System.getSecurityManager();
        this.b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.d = str + "_" + a.getAndIncrement() + "_thread_";
        AppMethodBeat.o(98585);
    }

    public final Thread newThread(Runnable runnable) {
        AppMethodBeat.i(98586);
        Thread thread = new Thread(this.b, runnable, this.d + this.c.getAndIncrement(), 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        try {
            thread.setPriority(5);
        } catch (Exception e) {
        }
        AppMethodBeat.o(98586);
        return thread;
    }
}
