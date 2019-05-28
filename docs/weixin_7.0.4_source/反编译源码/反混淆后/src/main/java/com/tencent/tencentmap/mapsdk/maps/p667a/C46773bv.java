package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.bv */
public final class C46773bv implements ThreadFactory {
    /* renamed from: a */
    private static final AtomicInteger f18110a = new AtomicInteger(1);
    /* renamed from: b */
    private final ThreadGroup f18111b;
    /* renamed from: c */
    private final AtomicInteger f18112c = new AtomicInteger(1);
    /* renamed from: d */
    private final String f18113d;

    static {
        AppMethodBeat.m2504i(98587);
        AppMethodBeat.m2505o(98587);
    }

    public C46773bv(String str) {
        AppMethodBeat.m2504i(98585);
        SecurityManager securityManager = System.getSecurityManager();
        this.f18111b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f18113d = str + "_" + f18110a.getAndIncrement() + "_thread_";
        AppMethodBeat.m2505o(98585);
    }

    public final Thread newThread(Runnable runnable) {
        AppMethodBeat.m2504i(98586);
        Thread thread = new Thread(this.f18111b, runnable, this.f18113d + this.f18112c.getAndIncrement(), 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        try {
            thread.setPriority(5);
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(98586);
        return thread;
    }
}
