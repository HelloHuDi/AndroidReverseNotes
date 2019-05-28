package com.tencent.mm.at.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class a {

    static class c extends ThreadPoolExecutor implements h {
        private ReentrantLock eRw = new ReentrantLock();
        private Condition eRx = this.eRw.newCondition();
        private BlockingQueue<Runnable> eRy;
        private boolean isPaused;

        public c(int i, int i2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
            super(i, i2, 0, timeUnit, blockingQueue, threadFactory);
            AppMethodBeat.i(116058);
            this.eRy = blockingQueue;
            AppMethodBeat.o(116058);
        }

        /* Access modifiers changed, original: protected|final */
        public final void beforeExecute(Thread thread, Runnable runnable) {
            AppMethodBeat.i(116059);
            super.beforeExecute(thread, runnable);
            this.eRw.lock();
            while (this.isPaused) {
                try {
                    this.eRx.await();
                } catch (Exception e) {
                    thread.interrupt();
                    ab.w("MicroMsg.imageloader.DefaultThreadPoolExecutor", "[cpan] before execute exception:%s", e.toString());
                } finally {
                    this.eRw.unlock();
                    AppMethodBeat.o(116059);
                }
            }
        }

        public final void pause() {
            AppMethodBeat.i(116060);
            this.eRw.lock();
            try {
                this.isPaused = true;
            } finally {
                this.eRw.unlock();
                AppMethodBeat.o(116060);
            }
        }

        public final void resume() {
            AppMethodBeat.i(116061);
            this.eRw.lock();
            try {
                this.isPaused = false;
                this.eRx.signalAll();
            } finally {
                this.eRw.unlock();
                AppMethodBeat.o(116061);
            }
        }

        public final void execute(Runnable runnable) {
            AppMethodBeat.i(116062);
            super.execute(runnable);
            AppMethodBeat.o(116062);
        }

        public final boolean DA() {
            return this.isPaused;
        }

        public final void remove(Object obj) {
            AppMethodBeat.i(116063);
            if (this.eRy != null) {
                this.eRy.remove(obj);
            }
            AppMethodBeat.o(116063);
        }
    }

    static class a extends com.tencent.mm.sdk.g.b.c implements h {
        private ReentrantLock eRw = new ReentrantLock();
        private Condition eRx = this.eRw.newCondition();
        private BlockingQueue<Runnable> eRy;
        private boolean isPaused;

        public a(int i, int i2, BlockingQueue<Runnable> blockingQueue) {
            super("image_loader_", i, i2, blockingQueue);
            AppMethodBeat.i(116048);
            this.eRy = blockingQueue;
            AppMethodBeat.o(116048);
        }

        public final void beforeExecute(Thread thread, Runnable runnable) {
            AppMethodBeat.i(116049);
            super.beforeExecute(thread, runnable);
            this.eRw.lock();
            while (this.isPaused) {
                try {
                    this.eRx.await();
                } catch (Exception e) {
                    thread.interrupt();
                    ab.w("MicroMsg.imageloader.DefaultThreadPoolExecutor", "[cpan] before execute exception:%s", e.toString());
                } finally {
                    this.eRw.unlock();
                    AppMethodBeat.o(116049);
                }
            }
        }

        public final void pause() {
            AppMethodBeat.i(116050);
            this.eRw.lock();
            try {
                this.isPaused = true;
            } finally {
                this.eRw.unlock();
                AppMethodBeat.o(116050);
            }
        }

        public final void resume() {
            AppMethodBeat.i(116051);
            this.eRw.lock();
            try {
                this.isPaused = false;
                this.eRx.signalAll();
            } finally {
                this.eRw.unlock();
                AppMethodBeat.o(116051);
            }
        }

        public final void execute(Runnable runnable) {
            AppMethodBeat.i(116052);
            super.execute(runnable);
            AppMethodBeat.o(116052);
        }

        public final boolean DA() {
            return this.isPaused;
        }

        public final void remove(Object obj) {
            AppMethodBeat.i(116053);
            if (this.eRy != null) {
                this.eRy.remove(obj);
            }
            AppMethodBeat.o(116053);
        }

        public final boolean isShutdown() {
            AppMethodBeat.i(116054);
            boolean isShutdown = super.isShutdown();
            AppMethodBeat.o(116054);
            return isShutdown;
        }
    }

    static class b implements ThreadFactory {
        private static final AtomicInteger eRB = new AtomicInteger(1);
        private final ThreadGroup cme;
        private final AtomicInteger cmf = new AtomicInteger(1);
        private final String cmg;
        private final int eRC;

        static {
            AppMethodBeat.i(116057);
            AppMethodBeat.o(116057);
        }

        b(int i, String str) {
            AppMethodBeat.i(116055);
            this.eRC = i;
            SecurityManager securityManager = System.getSecurityManager();
            this.cme = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.cmg = str + eRB.getAndIncrement() + "-thread-";
            AppMethodBeat.o(116055);
        }

        public final Thread newThread(Runnable runnable) {
            AppMethodBeat.i(116056);
            Thread thread = new Thread(this.cme, runnable, this.cmg + this.cmf.getAndIncrement(), 0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.eRC);
            AppMethodBeat.o(116056);
            return thread;
        }
    }

    public static h cs(int i, int i2) {
        AppMethodBeat.i(116064);
        com.tencent.mm.at.a.e.a aVar = new com.tencent.mm.at.a.e.a();
        if (d.xDC) {
            c cVar = new c(i, i, TimeUnit.MILLISECONDS, aVar, w(i2, "image_loader_"));
            AppMethodBeat.o(116064);
            return cVar;
        }
        h aVar2 = new a(i, i, aVar);
        AppMethodBeat.o(116064);
        return aVar2;
    }

    private static ThreadFactory w(int i, String str) {
        AppMethodBeat.i(116065);
        b bVar = new b(i, str);
        AppMethodBeat.o(116065);
        return bVar;
    }
}
