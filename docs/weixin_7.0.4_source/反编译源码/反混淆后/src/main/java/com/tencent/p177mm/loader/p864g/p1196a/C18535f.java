package com.tencent.p177mm.loader.p864g.p1196a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.loader.g.a.f */
public final class C18535f implements ThreadFactory {
    private static final AtomicInteger eRB = new AtomicInteger(1);
    private final ThreadGroup cme;
    private final AtomicInteger cmf = new AtomicInteger(1);
    private final String cmg;
    private final int eRC;

    public C18535f(int i, String str) {
        this.eRC = i;
        SecurityManager securityManager = System.getSecurityManager();
        this.cme = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.cmg = str + eRB.getAndIncrement() + "-thread-";
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.cme, runnable, this.cmg + this.cmf.getAndIncrement(), 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        thread.setPriority(this.eRC);
        return thread;
    }
}
