package com.tencent.p177mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Deprecated
/* renamed from: com.tencent.mm.sdk.platformtools.ba */
class C46613ba {
    private static final ConcurrentLinkedQueue<Runnable> xBa = new ConcurrentLinkedQueue();
    private static ExecutorService xBb = null;

    C46613ba() {
    }

    static {
        AppMethodBeat.m2504i(93590);
        AppMethodBeat.m2505o(93590);
    }

    public static ExecutorService dph() {
        ExecutorService executorService;
        AppMethodBeat.m2504i(93587);
        synchronized (C46613ba.class) {
            try {
                if (xBb == null) {
                    xBb = Executors.newSingleThreadExecutor();
                }
                executorService = xBb;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(93587);
            }
        }
        return executorService;
    }

    /* renamed from: ah */
    public static void m88167ah(Runnable runnable) {
        AppMethodBeat.m2504i(93588);
        xBa.add(runnable);
        AppMethodBeat.m2505o(93588);
    }

    /* renamed from: ai */
    public static void m88168ai(Runnable runnable) {
        AppMethodBeat.m2504i(93589);
        xBa.remove(runnable);
        AppMethodBeat.m2505o(93589);
    }
}
