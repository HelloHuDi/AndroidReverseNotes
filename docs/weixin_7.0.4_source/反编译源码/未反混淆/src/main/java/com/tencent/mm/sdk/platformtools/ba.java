package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Deprecated
class ba {
    private static final ConcurrentLinkedQueue<Runnable> xBa = new ConcurrentLinkedQueue();
    private static ExecutorService xBb = null;

    ba() {
    }

    static {
        AppMethodBeat.i(93590);
        AppMethodBeat.o(93590);
    }

    public static ExecutorService dph() {
        ExecutorService executorService;
        AppMethodBeat.i(93587);
        synchronized (ba.class) {
            try {
                if (xBb == null) {
                    xBb = Executors.newSingleThreadExecutor();
                }
                executorService = xBb;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(93587);
            }
        }
        return executorService;
    }

    public static void ah(Runnable runnable) {
        AppMethodBeat.i(93588);
        xBa.add(runnable);
        AppMethodBeat.o(93588);
    }

    public static void ai(Runnable runnable) {
        AppMethodBeat.i(93589);
        xBa.remove(runnable);
        AppMethodBeat.o(93589);
    }
}
