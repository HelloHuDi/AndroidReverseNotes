package com.tencent.p177mm.pluginsdk.p592g.p593a.p596c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.C7305d;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.pluginsdk.g.a.c.u */
public final class C44051u implements ThreadFactory {
    private static final AtomicInteger vfG = new AtomicInteger(1);
    private final AtomicInteger cmf;
    private String cmg;

    static {
        AppMethodBeat.m2504i(79640);
        AppMethodBeat.m2505o(79640);
    }

    public C44051u() {
        this("ResDownloaderPool", "ResDownloaderThread");
    }

    public C44051u(String str, String str2) {
        AppMethodBeat.m2504i(79638);
        this.cmf = new AtomicInteger(1);
        this.cmg = String.format("%s-%d-%s-", new Object[]{str, Integer.valueOf(vfG.getAndIncrement()), str2});
        AppMethodBeat.m2505o(79638);
    }

    public final Thread newThread(Runnable runnable) {
        AppMethodBeat.m2504i(79639);
        Thread a = C7305d.m12285a(runnable, this.cmg + this.cmf.getAndIncrement(), 1);
        if (a.isDaemon()) {
            a.setDaemon(false);
        }
        AppMethodBeat.m2505o(79639);
        return a;
    }
}
