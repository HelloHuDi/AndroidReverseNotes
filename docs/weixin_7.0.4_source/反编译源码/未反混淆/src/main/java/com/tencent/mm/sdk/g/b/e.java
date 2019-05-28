package com.tencent.mm.sdk.g.b;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.b.b.AnonymousClass1;
import com.tencent.mm.sdk.g.b.d.b;
import com.tencent.mm.sdk.g.c.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public final class e implements a {
    public a xEB;

    class a implements b, RejectedExecutionHandler {
        public HandlerThread xEC;
        Handler xED;

        private a() {
            AppMethodBeat.i(52664);
            this.xEC = c.anN("ThreadPool#FallBackExecutor");
            this.xED = null;
            AppMethodBeat.o(52664);
        }

        /* synthetic */ a(e eVar, byte b) {
            this();
        }

        private void au(Runnable runnable) {
            AppMethodBeat.i(52665);
            if (this.xED == null) {
                synchronized (this.xEC) {
                    try {
                        if (this.xED == null) {
                            if (!this.xEC.isAlive()) {
                                this.xEC.start();
                            }
                            this.xED = new Handler(this.xEC.getLooper());
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(52665);
                        }
                    }
                }
            }
            this.xED.post(runnable);
            AppMethodBeat.o(52665);
        }

        public final void at(Runnable runnable) {
            AppMethodBeat.i(52666);
            au(runnable);
            AppMethodBeat.o(52666);
        }

        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            AppMethodBeat.i(52667);
            au(runnable);
            AppMethodBeat.o(52667);
        }
    }

    public e(com.tencent.mm.sdk.g.a.b bVar, com.tencent.mm.sdk.g.b.d.a aVar) {
        int i = 42;
        AppMethodBeat.i(52668);
        a aVar2 = new a(this, (byte) 0);
        int availableProcessors = Runtime.getRuntime().availableProcessors() * 6;
        if (availableProcessors <= 42) {
            if (availableProcessors < 28) {
                i = 28;
            } else {
                i = availableProcessors;
            }
        }
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(i * 2);
        ab.i("MicroMsg.ThreadPoolExecutorProxy", "isHandlerThreadPool:%s coreSize:%s", Boolean.TRUE, Integer.valueOf(i));
        this.xEB = new AnonymousClass1(i, Math.round(0.8f * ((float) i)), linkedBlockingQueue, c.xEI, aVar2, aVar, bVar);
        AppMethodBeat.o(52668);
    }

    public final void execute(Runnable runnable) {
        AppMethodBeat.i(52669);
        this.xEB.execute(runnable);
        AppMethodBeat.o(52669);
    }

    public final boolean remove(Runnable runnable) {
        AppMethodBeat.i(52670);
        boolean remove = this.xEB.remove(runnable);
        AppMethodBeat.o(52670);
        return remove;
    }

    public final void shutdown() {
        AppMethodBeat.i(52671);
        this.xEB.shutdown();
        AppMethodBeat.o(52671);
    }

    public final void reset() {
        AppMethodBeat.i(52672);
        this.xEB.reset();
        AppMethodBeat.o(52672);
    }

    public final void p(Runnable runnable, long j) {
        AppMethodBeat.i(52673);
        this.xEB.p(runnable, j);
        AppMethodBeat.o(52673);
    }

    public final int getCorePoolSize() {
        AppMethodBeat.i(52674);
        int corePoolSize = this.xEB.getCorePoolSize();
        AppMethodBeat.o(52674);
        return corePoolSize;
    }
}
