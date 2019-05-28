package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class h extends ThreadPoolExecutor {
    public h(TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(3, 3, 3000, timeUnit, blockingQueue, threadFactory);
    }

    /* Access modifiers changed, original: protected|final */
    public final <V> RunnableFuture<V> newTaskFor(Runnable runnable, V v) {
        AppMethodBeat.i(63449);
        if (runnable instanceof c) {
            e eVar = new e(runnable, v, (c) runnable);
            AppMethodBeat.o(63449);
            return eVar;
        }
        RunnableFuture<V> newTaskFor = super.newTaskFor(runnable, v);
        AppMethodBeat.o(63449);
        return newTaskFor;
    }

    /* Access modifiers changed, original: protected|final */
    public final void terminated() {
        AppMethodBeat.i(63450);
        d dgw = d.dgw();
        if (dgw.uVY != null) {
            dgw.uVY.clear();
        }
        super.terminated();
        AppMethodBeat.o(63450);
    }

    /* Access modifiers changed, original: protected|final */
    public final void beforeExecute(Thread thread, Runnable runnable) {
        AppMethodBeat.i(63451);
        super.beforeExecute(thread, runnable);
        ab.i("MicroMsg.Wepkg.WePkgThreadPoolExecutor", "beforeExecute");
        AppMethodBeat.o(63451);
    }

    /* Access modifiers changed, original: protected|final */
    public final void afterExecute(Runnable runnable, Throwable th) {
        AppMethodBeat.i(63452);
        if (runnable instanceof e) {
            e eVar = (e) runnable;
            if (!(eVar.uWn == null || eVar.uWn.uVO == null)) {
                d.dgw().ahO(eVar.uWn.uVO.uWo);
                ab.i("MicroMsg.Wepkg.WePkgThreadPoolExecutor", "remove download task");
            }
        }
        ab.i("MicroMsg.Wepkg.WePkgThreadPoolExecutor", "afterExecute");
        super.afterExecute(runnable, th);
        AppMethodBeat.o(63452);
    }
}
