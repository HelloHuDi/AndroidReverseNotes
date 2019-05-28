package com.tencent.p177mm.plugin.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.p191a.p193c.C1281h;
import com.tencent.p177mm.sdk.p604g.p606b.C40613c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.tencent.mm.plugin.emoji.sync.b */
public final class C27743b {
    public final int eRC;
    public final int kXk;
    public final Executor kXl;

    /* renamed from: com.tencent.mm.plugin.emoji.sync.b$a */
    public static class C11562a {
        int eRC = 10;
        int kXk = 1;
        Executor kXl;
    }

    /* renamed from: com.tencent.mm.plugin.emoji.sync.b$b */
    public static class C27744b extends C40613c implements C1281h {
        private ReentrantLock eRw = new ReentrantLock();
        private Condition eRx = this.eRw.newCondition();
        private boolean isPaused;

        public C27744b(int i, int i2, BlockingQueue<Runnable> blockingQueue) {
            super("bkg_loader_", i, i2, blockingQueue);
            AppMethodBeat.m2504i(53174);
            AppMethodBeat.m2505o(53174);
        }

        public final void beforeExecute(Thread thread, Runnable runnable) {
            AppMethodBeat.m2504i(53175);
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
                    AppMethodBeat.m2505o(53175);
                }
            }
        }

        public final void pause() {
            AppMethodBeat.m2504i(53176);
            this.eRw.lock();
            try {
                this.isPaused = true;
            } finally {
                this.eRw.unlock();
                AppMethodBeat.m2505o(53176);
            }
        }

        public final void resume() {
            AppMethodBeat.m2504i(53177);
            this.eRw.lock();
            try {
                this.isPaused = false;
                this.eRx.signalAll();
            } finally {
                this.eRw.unlock();
                AppMethodBeat.m2505o(53177);
            }
        }

        public final void execute(Runnable runnable) {
            AppMethodBeat.m2504i(53178);
            super.execute(runnable);
            AppMethodBeat.m2505o(53178);
        }

        /* renamed from: DA */
        public final boolean mo4576DA() {
            return this.isPaused;
        }

        public final void remove(Object obj) {
        }

        public final boolean isShutdown() {
            AppMethodBeat.m2504i(53179);
            boolean isShutdown = super.isShutdown();
            AppMethodBeat.m2505o(53179);
            return isShutdown;
        }
    }

    public C27743b(C11562a c11562a) {
        this.kXk = c11562a.kXk;
        this.eRC = c11562a.eRC;
        this.kXl = c11562a.kXl;
    }
}
