package com.tencent.mm.loader.g.a;

import com.tencent.mm.loader.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class b extends ThreadPoolExecutor implements a {
    private ReentrantLock eRw = new ReentrantLock();
    private Condition eRx = this.eRw.newCondition();
    private BlockingQueue<Runnable> eRy;
    private boolean isPaused;

    public b(int i, int i2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
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
                ab.w("MicroMsg.Loader.imageloader.DefaultThreadPoolExecutor", "[cpan] before execute exception:%s", e.toString());
            } finally {
                this.eRw.unlock();
            }
        }
    }

    public final void execute(Runnable runnable) {
        super.execute(runnable);
    }
}
