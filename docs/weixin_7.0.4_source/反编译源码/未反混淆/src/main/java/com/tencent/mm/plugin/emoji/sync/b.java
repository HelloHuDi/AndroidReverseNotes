package com.tencent.mm.plugin.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.h;
import com.tencent.mm.sdk.g.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class b {
    public final int eRC;
    public final int kXk;
    public final Executor kXl;

    public static class a {
        int eRC = 10;
        int kXk = 1;
        Executor kXl;
    }

    public static class b extends c implements h {
        private ReentrantLock eRw = new ReentrantLock();
        private Condition eRx = this.eRw.newCondition();
        private boolean isPaused;

        public b(int i, int i2, BlockingQueue<Runnable> blockingQueue) {
            super("bkg_loader_", i, i2, blockingQueue);
            AppMethodBeat.i(53174);
            AppMethodBeat.o(53174);
        }

        public final void beforeExecute(Thread thread, Runnable runnable) {
            AppMethodBeat.i(53175);
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
                    AppMethodBeat.o(53175);
                }
            }
        }

        public final void pause() {
            AppMethodBeat.i(53176);
            this.eRw.lock();
            try {
                this.isPaused = true;
            } finally {
                this.eRw.unlock();
                AppMethodBeat.o(53176);
            }
        }

        public final void resume() {
            AppMethodBeat.i(53177);
            this.eRw.lock();
            try {
                this.isPaused = false;
                this.eRx.signalAll();
            } finally {
                this.eRw.unlock();
                AppMethodBeat.o(53177);
            }
        }

        public final void execute(Runnable runnable) {
            AppMethodBeat.i(53178);
            super.execute(runnable);
            AppMethodBeat.o(53178);
        }

        public final boolean DA() {
            return this.isPaused;
        }

        public final void remove(Object obj) {
        }

        public final boolean isShutdown() {
            AppMethodBeat.i(53179);
            boolean isShutdown = super.isShutdown();
            AppMethodBeat.o(53179);
            return isShutdown;
        }
    }

    public b(a aVar) {
        this.kXk = aVar.kXk;
        this.eRC = aVar.eRC;
        this.kXl = aVar.kXl;
    }
}
