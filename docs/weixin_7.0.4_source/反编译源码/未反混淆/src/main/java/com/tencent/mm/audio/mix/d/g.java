package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class g implements ThreadFactory {
    private final ThreadGroup cme = new ThreadGroup("AUDIO_MIX_THREAD_POOL_GROUP");
    private final AtomicInteger cmf = new AtomicInteger(1);
    private final String cmg = "audio_mix_thread#";

    public g() {
        AppMethodBeat.i(137074);
        AppMethodBeat.o(137074);
    }

    public final Thread newThread(Runnable runnable) {
        AppMethodBeat.i(137075);
        Thread thread = new Thread(this.cme, runnable, "audio_mix_thread#" + this.cmf.getAndIncrement(), 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        AppMethodBeat.o(137075);
        return thread;
    }
}
