package com.tencent.p177mm.pluginsdk.p592g.p593a.p596c;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.pluginsdk.g.a.c.f */
public abstract class C4716f<T extends C4719b> {
    final Map<String, C4719b> pendingRequests = new ConcurrentHashMap();
    final Map<String, Future<?>> veZ = new ConcurrentHashMap();

    /* renamed from: com.tencent.mm.pluginsdk.g.a.c.f$a */
    public class C4717a extends ThreadPoolExecutor {
        public C4717a(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, C44051u c44051u) {
            super(i, i2, j, timeUnit, blockingQueue, c44051u);
        }

        /* Access modifiers changed, original: protected|final */
        public final <V> RunnableFuture<V> newTaskFor(Runnable runnable, V v) {
            AppMethodBeat.m2504i(79567);
            if (runnable instanceof C4718d) {
                C4720c c4720c = new C4720c(runnable, v, ((C4718d) runnable).vfb);
                AppMethodBeat.m2505o(79567);
                return c4720c;
            }
            RunnableFuture<V> newTaskFor = super.newTaskFor(runnable, v);
            AppMethodBeat.m2505o(79567);
            return newTaskFor;
        }

        /* Access modifiers changed, original: protected|final */
        public final void terminated() {
            AppMethodBeat.m2504i(79568);
            C4716f.this.veZ.clear();
            super.terminated();
            AppMethodBeat.m2505o(79568);
        }

        /* Access modifiers changed, original: protected|final */
        public final void beforeExecute(Thread thread, Runnable runnable) {
            AppMethodBeat.m2504i(79569);
            if (runnable instanceof C4720c) {
                C4720c c4720c = (C4720c) runnable;
                if (C4716f.this.veZ.containsKey(c4720c.vfb.dib())) {
                    c4720c.cancel(false);
                } else {
                    C4716f.this.veZ.put(c4720c.vfb.dib(), c4720c);
                    C4716f.this.pendingRequests.remove(c4720c.vfb.dib());
                }
            } else {
                C4990ab.m7417i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", runnable.getClass().getSimpleName());
            }
            super.beforeExecute(thread, runnable);
            AppMethodBeat.m2505o(79569);
        }

        /* Access modifiers changed, original: protected|final */
        public final void afterExecute(Runnable runnable, Throwable th) {
            AppMethodBeat.m2504i(79570);
            if (runnable instanceof C4720c) {
                C4720c c4720c = (C4720c) runnable;
                C4716f.this.veZ.remove(c4720c.vfb.dib());
                C4716f.this.pendingRequests.remove(c4720c.vfb.dib());
            } else {
                C4990ab.m7417i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", runnable.getClass().getSimpleName());
            }
            super.afterExecute(runnable, th);
            AppMethodBeat.m2505o(79570);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.g.a.c.f$d */
    public static abstract class C4718d<Req extends C4719b> implements Runnable {
        private final Req vfb;

        /* Access modifiers changed, original: protected */
        public Req awh() {
            return this.vfb;
        }

        protected C4718d(Req req) {
            this.vfb = req;
        }

        public void run() {
            if (Process.getThreadPriority(Process.myTid()) != 10) {
                Process.setThreadPriority(10);
            }
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.g.a.c.f$b */
    public interface C4719b {
        String dib();
    }

    /* renamed from: com.tencent.mm.pluginsdk.g.a.c.f$c */
    protected static class C4720c<V> extends FutureTask<V> {
        protected final C4719b vfb;

        public C4720c(Runnable runnable, V v, C4719b c4719b) {
            super(runnable, v);
            this.vfb = c4719b;
        }
    }

    /* renamed from: a */
    public abstract C4718d mo9845a(T t);

    public abstract C4717a dik();

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo9848b(T t) {
        this.pendingRequests.put(t.dib(), t);
        dik().submit(mo9845a(t));
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
