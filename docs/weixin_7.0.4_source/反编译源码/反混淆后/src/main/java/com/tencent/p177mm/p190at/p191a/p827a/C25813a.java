package com.tencent.p177mm.p190at.p191a.p827a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.p191a.p1592e.C41760a;
import com.tencent.p177mm.p190at.p191a.p193c.C1281h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.p604g.p606b.C40613c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.tencent.mm.at.a.a.a */
public final class C25813a {

    /* renamed from: com.tencent.mm.at.a.a.a$c */
    static class C9011c extends ThreadPoolExecutor implements C1281h {
        private ReentrantLock eRw = new ReentrantLock();
        private Condition eRx = this.eRw.newCondition();
        private BlockingQueue<Runnable> eRy;
        private boolean isPaused;

        public C9011c(int i, int i2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
            super(i, i2, 0, timeUnit, blockingQueue, threadFactory);
            AppMethodBeat.m2504i(116058);
            this.eRy = blockingQueue;
            AppMethodBeat.m2505o(116058);
        }

        /* Access modifiers changed, original: protected|final */
        public final void beforeExecute(Thread thread, Runnable runnable) {
            AppMethodBeat.m2504i(116059);
            super.beforeExecute(thread, runnable);
            this.eRw.lock();
            while (this.isPaused) {
                try {
                    this.eRx.await();
                } catch (Exception e) {
                    thread.interrupt();
                    C4990ab.m7421w("MicroMsg.imageloader.DefaultThreadPoolExecutor", "[cpan] before execute exception:%s", e.toString());
                } finally {
                    this.eRw.unlock();
                    AppMethodBeat.m2505o(116059);
                }
            }
        }

        public final void pause() {
            AppMethodBeat.m2504i(116060);
            this.eRw.lock();
            try {
                this.isPaused = true;
            } finally {
                this.eRw.unlock();
                AppMethodBeat.m2505o(116060);
            }
        }

        public final void resume() {
            AppMethodBeat.m2504i(116061);
            this.eRw.lock();
            try {
                this.isPaused = false;
                this.eRx.signalAll();
            } finally {
                this.eRw.unlock();
                AppMethodBeat.m2505o(116061);
            }
        }

        public final void execute(Runnable runnable) {
            AppMethodBeat.m2504i(116062);
            super.execute(runnable);
            AppMethodBeat.m2505o(116062);
        }

        /* renamed from: DA */
        public final boolean mo4576DA() {
            return this.isPaused;
        }

        public final void remove(Object obj) {
            AppMethodBeat.m2504i(116063);
            if (this.eRy != null) {
                this.eRy.remove(obj);
            }
            AppMethodBeat.m2505o(116063);
        }
    }

    /* renamed from: com.tencent.mm.at.a.a.a$a */
    static class C17924a extends C40613c implements C1281h {
        private ReentrantLock eRw = new ReentrantLock();
        private Condition eRx = this.eRw.newCondition();
        private BlockingQueue<Runnable> eRy;
        private boolean isPaused;

        public C17924a(int i, int i2, BlockingQueue<Runnable> blockingQueue) {
            super("image_loader_", i, i2, blockingQueue);
            AppMethodBeat.m2504i(116048);
            this.eRy = blockingQueue;
            AppMethodBeat.m2505o(116048);
        }

        public final void beforeExecute(Thread thread, Runnable runnable) {
            AppMethodBeat.m2504i(116049);
            super.beforeExecute(thread, runnable);
            this.eRw.lock();
            while (this.isPaused) {
                try {
                    this.eRx.await();
                } catch (Exception e) {
                    thread.interrupt();
                    C4990ab.m7421w("MicroMsg.imageloader.DefaultThreadPoolExecutor", "[cpan] before execute exception:%s", e.toString());
                } finally {
                    this.eRw.unlock();
                    AppMethodBeat.m2505o(116049);
                }
            }
        }

        public final void pause() {
            AppMethodBeat.m2504i(116050);
            this.eRw.lock();
            try {
                this.isPaused = true;
            } finally {
                this.eRw.unlock();
                AppMethodBeat.m2505o(116050);
            }
        }

        public final void resume() {
            AppMethodBeat.m2504i(116051);
            this.eRw.lock();
            try {
                this.isPaused = false;
                this.eRx.signalAll();
            } finally {
                this.eRw.unlock();
                AppMethodBeat.m2505o(116051);
            }
        }

        public final void execute(Runnable runnable) {
            AppMethodBeat.m2504i(116052);
            super.execute(runnable);
            AppMethodBeat.m2505o(116052);
        }

        /* renamed from: DA */
        public final boolean mo4576DA() {
            return this.isPaused;
        }

        public final void remove(Object obj) {
            AppMethodBeat.m2504i(116053);
            if (this.eRy != null) {
                this.eRy.remove(obj);
            }
            AppMethodBeat.m2505o(116053);
        }

        public final boolean isShutdown() {
            AppMethodBeat.m2504i(116054);
            boolean isShutdown = super.isShutdown();
            AppMethodBeat.m2505o(116054);
            return isShutdown;
        }
    }

    /* renamed from: com.tencent.mm.at.a.a.a$b */
    static class C25812b implements ThreadFactory {
        private static final AtomicInteger eRB = new AtomicInteger(1);
        private final ThreadGroup cme;
        private final AtomicInteger cmf = new AtomicInteger(1);
        private final String cmg;
        private final int eRC;

        static {
            AppMethodBeat.m2504i(116057);
            AppMethodBeat.m2505o(116057);
        }

        C25812b(int i, String str) {
            AppMethodBeat.m2504i(116055);
            this.eRC = i;
            SecurityManager securityManager = System.getSecurityManager();
            this.cme = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.cmg = str + eRB.getAndIncrement() + "-thread-";
            AppMethodBeat.m2505o(116055);
        }

        public final Thread newThread(Runnable runnable) {
            AppMethodBeat.m2504i(116056);
            Thread thread = new Thread(this.cme, runnable, this.cmg + this.cmf.getAndIncrement(), 0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.eRC);
            AppMethodBeat.m2505o(116056);
            return thread;
        }
    }

    /* renamed from: cs */
    public static C1281h m41070cs(int i, int i2) {
        AppMethodBeat.m2504i(116064);
        C41760a c41760a = new C41760a();
        if (C7305d.xDC) {
            C9011c c9011c = new C9011c(i, i, TimeUnit.MILLISECONDS, c41760a, C25813a.m41071w(i2, "image_loader_"));
            AppMethodBeat.m2505o(116064);
            return c9011c;
        }
        C1281h c17924a = new C17924a(i, i, c41760a);
        AppMethodBeat.m2505o(116064);
        return c17924a;
    }

    /* renamed from: w */
    private static ThreadFactory m41071w(int i, String str) {
        AppMethodBeat.m2504i(116065);
        C25812b c25812b = new C25812b(i, str);
        AppMethodBeat.m2505o(116065);
        return c25812b;
    }
}
