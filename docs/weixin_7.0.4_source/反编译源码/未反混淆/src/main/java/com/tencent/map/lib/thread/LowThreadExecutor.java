package com.tencent.map.lib.thread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class LowThreadExecutor implements Executor {
    private final ThreadFactory a = new ThreadFactory() {
        private final AtomicInteger b = new AtomicInteger(1);

        {
            AppMethodBeat.i(98203);
            AppMethodBeat.o(98203);
        }

        public Thread newThread(Runnable runnable) {
            AppMethodBeat.i(98204);
            Thread thread = new Thread(runnable, "AsyncTask Low #" + this.b.getAndIncrement());
            AppMethodBeat.o(98204);
            return thread;
        }
    };
    private final BlockingQueue<Runnable> b = new LinkedBlockingQueue(20);
    public final Executor mExecutor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, this.b, this.a, new DiscardOldestPolicy());

    public LowThreadExecutor() {
        AppMethodBeat.i(98205);
        AppMethodBeat.o(98205);
    }

    public void execute(Runnable runnable) {
        AppMethodBeat.i(98206);
        this.mExecutor.execute(runnable);
        AppMethodBeat.o(98206);
    }
}
