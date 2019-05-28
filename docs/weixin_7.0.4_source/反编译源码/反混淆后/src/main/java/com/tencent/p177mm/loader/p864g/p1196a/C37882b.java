package com.tencent.p177mm.loader.p864g.p1196a;

import com.tencent.p177mm.loader.p864g.C26364a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.tencent.mm.loader.g.a.b */
public final class C37882b extends ThreadPoolExecutor implements C26364a {
    private ReentrantLock eRw = new ReentrantLock();
    private Condition eRx = this.eRw.newCondition();
    private BlockingQueue<Runnable> eRy;
    private boolean isPaused;

    public C37882b(int i, int i2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, 0, timeUnit, blockingQueue, threadFactory);
        this.eRy = blockingQueue;
    }

    /* Access modifiers changed, original: protected|final */
    public final void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        this.eRw.lock();
        while (this.isPaused) {
            try {
                this.eRx.await();
            } catch (Exception e) {
                thread.interrupt();
                C4990ab.m7421w("MicroMsg.Loader.imageloader.DefaultThreadPoolExecutor", "[cpan] before execute exception:%s", e.toString());
            } finally {
                this.eRw.unlock();
            }
        }
    }

    public final void execute(Runnable runnable) {
        super.execute(runnable);
    }
}
