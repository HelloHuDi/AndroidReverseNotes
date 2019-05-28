package com.tencent.mm.sdk.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;

@Deprecated
public final class b {
    private ThreadGroup cme = new ThreadGroup("MM_FREE_THREAD_GROUP");
    private final AtomicInteger xEF = new AtomicInteger(1);

    static class a extends Thread {
        private com.tencent.mm.sdk.g.d.a xEG;

        a(ThreadGroup threadGroup, com.tencent.mm.sdk.g.d.a aVar, String str) {
            super(threadGroup, aVar, str);
            this.xEG = aVar;
        }

        public final void start() {
            AppMethodBeat.i(52679);
            super.start();
            AppMethodBeat.o(52679);
        }

        public final void run() {
            AppMethodBeat.i(52680);
            super.run();
            AppMethodBeat.o(52680);
        }
    }

    public b() {
        AppMethodBeat.i(52681);
        AppMethodBeat.o(52681);
    }

    public final Thread newThread(Runnable runnable, String str, int i) {
        Thread thread;
        AppMethodBeat.i(52682);
        Assert.assertNotNull("newThread arg name is null!", str);
        if (runnable != null) {
            Thread aVar = new a(this.cme, new com.tencent.mm.sdk.g.d.a(runnable, str, null, 0, null, null, null), "mmt_f".concat(String.valueOf(str)));
            aVar.setPriority(i);
            thread = aVar;
        } else {
            thread = new a(this.cme, null, "mmt_f".concat(String.valueOf(str)));
            thread.setPriority(i);
        }
        AppMethodBeat.o(52682);
        return thread;
    }
}
