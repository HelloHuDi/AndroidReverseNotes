package com.tencent.p177mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.plugin.wepkg.downloader.h */
public final class C40396h extends ThreadPoolExecutor {
    public C40396h(TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(3, 3, 3000, timeUnit, blockingQueue, threadFactory);
    }

    /* Access modifiers changed, original: protected|final */
    public final <V> RunnableFuture<V> newTaskFor(Runnable runnable, V v) {
        AppMethodBeat.m2504i(63449);
        if (runnable instanceof C14800c) {
            C23199e c23199e = new C23199e(runnable, v, (C14800c) runnable);
            AppMethodBeat.m2505o(63449);
            return c23199e;
        }
        RunnableFuture<V> newTaskFor = super.newTaskFor(runnable, v);
        AppMethodBeat.m2505o(63449);
        return newTaskFor;
    }

    /* Access modifiers changed, original: protected|final */
    public final void terminated() {
        AppMethodBeat.m2504i(63450);
        C35755d dgw = C35755d.dgw();
        if (dgw.uVY != null) {
            dgw.uVY.clear();
        }
        super.terminated();
        AppMethodBeat.m2505o(63450);
    }

    /* Access modifiers changed, original: protected|final */
    public final void beforeExecute(Thread thread, Runnable runnable) {
        AppMethodBeat.m2504i(63451);
        super.beforeExecute(thread, runnable);
        C4990ab.m7416i("MicroMsg.Wepkg.WePkgThreadPoolExecutor", "beforeExecute");
        AppMethodBeat.m2505o(63451);
    }

    /* Access modifiers changed, original: protected|final */
    public final void afterExecute(Runnable runnable, Throwable th) {
        AppMethodBeat.m2504i(63452);
        if (runnable instanceof C23199e) {
            C23199e c23199e = (C23199e) runnable;
            if (!(c23199e.uWn == null || c23199e.uWn.uVO == null)) {
                C35755d.dgw().ahO(c23199e.uWn.uVO.uWo);
                C4990ab.m7416i("MicroMsg.Wepkg.WePkgThreadPoolExecutor", "remove download task");
            }
        }
        C4990ab.m7416i("MicroMsg.Wepkg.WePkgThreadPoolExecutor", "afterExecute");
        super.afterExecute(runnable, th);
        AppMethodBeat.m2505o(63452);
    }
}
