package com.tencent.mm.pluginsdk.g.a.c;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class f<T extends b> {
    final Map<String, b> pendingRequests = new ConcurrentHashMap();
    final Map<String, Future<?>> veZ = new ConcurrentHashMap();

    public class a extends ThreadPoolExecutor {
        public a(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, u uVar) {
            super(i, i2, j, timeUnit, blockingQueue, uVar);
        }

        /* Access modifiers changed, original: protected|final */
        public final <V> RunnableFuture<V> newTaskFor(Runnable runnable, V v) {
            AppMethodBeat.i(79567);
            if (runnable instanceof d) {
                c cVar = new c(runnable, v, ((d) runnable).vfb);
                AppMethodBeat.o(79567);
                return cVar;
            }
            RunnableFuture<V> newTaskFor = super.newTaskFor(runnable, v);
            AppMethodBeat.o(79567);
            return newTaskFor;
        }

        /* Access modifiers changed, original: protected|final */
        public final void terminated() {
            AppMethodBeat.i(79568);
            f.this.veZ.clear();
            super.terminated();
            AppMethodBeat.o(79568);
        }

        /* Access modifiers changed, original: protected|final */
        public final void beforeExecute(Thread thread, Runnable runnable) {
            AppMethodBeat.i(79569);
            if (runnable instanceof c) {
                c cVar = (c) runnable;
                if (f.this.veZ.containsKey(cVar.vfb.dib())) {
                    cVar.cancel(false);
                } else {
                    f.this.veZ.put(cVar.vfb.dib(), cVar);
                    f.this.pendingRequests.remove(cVar.vfb.dib());
                }
            } else {
                ab.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", runnable.getClass().getSimpleName());
            }
            super.beforeExecute(thread, runnable);
            AppMethodBeat.o(79569);
        }

        /* Access modifiers changed, original: protected|final */
        public final void afterExecute(Runnable runnable, Throwable th) {
            AppMethodBeat.i(79570);
            if (runnable instanceof c) {
                c cVar = (c) runnable;
                f.this.veZ.remove(cVar.vfb.dib());
                f.this.pendingRequests.remove(cVar.vfb.dib());
            } else {
                ab.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", runnable.getClass().getSimpleName());
            }
            super.afterExecute(runnable, th);
            AppMethodBeat.o(79570);
        }
    }

    public static abstract class d<Req extends b> implements Runnable {
        private final Req vfb;

        /* Access modifiers changed, original: protected */
        public Req awh() {
            return this.vfb;
        }

        protected d(Req req) {
            this.vfb = req;
        }

        public void run() {
            if (Process.getThreadPriority(Process.myTid()) != 10) {
                Process.setThreadPriority(10);
            }
        }
    }

    public interface b {
        String dib();
    }

    protected static class c<V> extends FutureTask<V> {
        protected final b vfb;

        public c(Runnable runnable, V v, b bVar) {
            super(runnable, v);
            this.vfb = bVar;
        }
    }

    public abstract d a(T t);

    public abstract a dik();

    /* Access modifiers changed, original: protected|final */
    public final void b(T t) {
        this.pendingRequests.put(t.dib(), t);
        dik().submit(a(t));
    }

    public final boolean ajc(String str) {
        return this.veZ.containsKey(str);
    }

    public final synchronized boolean ajd(String str) {
        boolean z;
        z = this.veZ.containsKey(str) || this.pendingRequests.containsKey(str);
        return z;
    }
}
