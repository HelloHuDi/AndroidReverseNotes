package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class u implements ThreadFactory {
    private static final AtomicInteger vfG = new AtomicInteger(1);
    private final AtomicInteger cmf;
    private String cmg;

    static {
        AppMethodBeat.i(79640);
        AppMethodBeat.o(79640);
    }

    public u() {
        this("ResDownloaderPool", "ResDownloaderThread");
    }

    public u(String str, String str2) {
        AppMethodBeat.i(79638);
        this.cmf = new AtomicInteger(1);
        this.cmg = String.format("%s-%d-%s-", new Object[]{str, Integer.valueOf(vfG.getAndIncrement()), str2});
        AppMethodBeat.o(79638);
    }

    public final Thread newThread(Runnable runnable) {
        AppMethodBeat.i(79639);
        Thread a = d.a(runnable, this.cmg + this.cmf.getAndIncrement(), 1);
        if (a.isDaemon()) {
            a.setDaemon(false);
        }
        AppMethodBeat.o(79639);
        return a;
    }
}
