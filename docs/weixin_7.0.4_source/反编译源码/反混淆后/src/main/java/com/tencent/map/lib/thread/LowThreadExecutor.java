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
    /* renamed from: a */
    private final ThreadFactory f2852a = new C88971();
    /* renamed from: b */
    private final BlockingQueue<Runnable> f2853b = new LinkedBlockingQueue(20);
    public final Executor mExecutor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, this.f2853b, this.f2852a, new DiscardOldestPolicy());

    /* renamed from: com.tencent.map.lib.thread.LowThreadExecutor$1 */
    class C88971 implements ThreadFactory {
        /* renamed from: b */
        private final AtomicInteger f2855b = new AtomicInteger(1);

        C88971() {
            AppMethodBeat.m2504i(98203);
            AppMethodBeat.m2505o(98203);
        }

        public Thread newThread(Runnable runnable) {
            AppMethodBeat.m2504i(98204);
            Thread thread = new Thread(runnable, "AsyncTask Low #" + this.f2855b.getAndIncrement());
            AppMethodBeat.m2505o(98204);
            return thread;
        }
    }

    public LowThreadExecutor() {
        AppMethodBeat.m2504i(98205);
        AppMethodBeat.m2505o(98205);
    }

    public void execute(Runnable runnable) {
        AppMethodBeat.m2504i(98206);
        this.mExecutor.execute(runnable);
        AppMethodBeat.m2505o(98206);
    }
}
