package com.bumptech.glide.c.b.c;

import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.util.Log;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a implements ExecutorService {
    private static volatile int aDA;
    private static final long aDz = TimeUnit.SECONDS.toMillis(10);
    private final ExecutorService aDB;

    public interface b {
        public static final b aDG = new b() {
            public final void d(Throwable th) {
            }
        };
        public static final b aDH = new b() {
            public final void d(Throwable th) {
                AppMethodBeat.i(92004);
                Log.isLoggable("GlideExecutor", 6);
                AppMethodBeat.o(92004);
            }
        };
        public static final b aDI = new b() {
            public final void d(Throwable th) {
                AppMethodBeat.i(92005);
                RuntimeException runtimeException = new RuntimeException("Request threw uncaught throwable", th);
                AppMethodBeat.o(92005);
                throw runtimeException;
            }
        };
        public static final b aDJ = aDH;

        void d(Throwable th);
    }

    static final class a implements ThreadFactory {
        final b aDC;
        final boolean aDD;
        private int aDE;
        private final String name;

        a(String str, b bVar, boolean z) {
            this.name = str;
            this.aDC = bVar;
            this.aDD = z;
        }

        public final synchronized Thread newThread(Runnable runnable) {
            AnonymousClass1 anonymousClass1;
            AppMethodBeat.i(92003);
            anonymousClass1 = new Thread(runnable, "glide-" + this.name + "-thread-" + this.aDE) {
                public final void run() {
                    AppMethodBeat.i(92002);
                    Process.setThreadPriority(9);
                    if (a.this.aDD) {
                        StrictMode.setThreadPolicy(new Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                        AppMethodBeat.o(92002);
                    } catch (Throwable th) {
                        a.this.aDC.d(th);
                        AppMethodBeat.o(92002);
                    }
                }
            };
            this.aDE++;
            AppMethodBeat.o(92003);
            return anonymousClass1;
        }
    }

    static {
        AppMethodBeat.i(92025);
        AppMethodBeat.o(92025);
    }

    public static a nb() {
        AppMethodBeat.i(92006);
        b bVar = b.aDJ;
        a aVar = new a(new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a("disk-cache", bVar, true)));
        AppMethodBeat.o(92006);
        return aVar;
    }

    public static a nc() {
        AppMethodBeat.i(92007);
        int nf = nf();
        b bVar = b.aDJ;
        a aVar = new a(new ThreadPoolExecutor(nf, nf, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a("source", bVar, false)));
        AppMethodBeat.o(92007);
        return aVar;
    }

    public static a nd() {
        AppMethodBeat.i(92008);
        a aVar = new a(new ThreadPoolExecutor(0, BaseClientBuilder.API_PRIORITY_OTHER, aDz, TimeUnit.MILLISECONDS, new SynchronousQueue(), new a("source-unlimited", b.aDJ, false)));
        AppMethodBeat.o(92008);
        return aVar;
    }

    public static a ne() {
        int i;
        AppMethodBeat.i(92009);
        if (nf() >= 4) {
            i = 2;
        } else {
            i = 1;
        }
        a aVar = new a(new ThreadPoolExecutor(0, i, aDz, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a("animation", b.aDJ, true)));
        AppMethodBeat.o(92009);
        return aVar;
    }

    private a(ExecutorService executorService) {
        this.aDB = executorService;
    }

    public final void execute(Runnable runnable) {
        AppMethodBeat.i(92010);
        this.aDB.execute(runnable);
        AppMethodBeat.o(92010);
    }

    public final Future<?> submit(Runnable runnable) {
        AppMethodBeat.i(92011);
        Future submit = this.aDB.submit(runnable);
        AppMethodBeat.o(92011);
        return submit;
    }

    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        AppMethodBeat.i(92012);
        List invokeAll = this.aDB.invokeAll(collection);
        AppMethodBeat.o(92012);
        return invokeAll;
    }

    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        AppMethodBeat.i(92013);
        List invokeAll = this.aDB.invokeAll(collection, j, timeUnit);
        AppMethodBeat.o(92013);
        return invokeAll;
    }

    public final <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        AppMethodBeat.i(92014);
        Object invokeAny = this.aDB.invokeAny(collection);
        AppMethodBeat.o(92014);
        return invokeAny;
    }

    public final <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        AppMethodBeat.i(92015);
        Object invokeAny = this.aDB.invokeAny(collection, j, timeUnit);
        AppMethodBeat.o(92015);
        return invokeAny;
    }

    public final <T> Future<T> submit(Runnable runnable, T t) {
        AppMethodBeat.i(92016);
        Future submit = this.aDB.submit(runnable, t);
        AppMethodBeat.o(92016);
        return submit;
    }

    public final <T> Future<T> submit(Callable<T> callable) {
        AppMethodBeat.i(92017);
        Future submit = this.aDB.submit(callable);
        AppMethodBeat.o(92017);
        return submit;
    }

    public final void shutdown() {
        AppMethodBeat.i(92018);
        this.aDB.shutdown();
        AppMethodBeat.o(92018);
    }

    public final List<Runnable> shutdownNow() {
        AppMethodBeat.i(92019);
        List shutdownNow = this.aDB.shutdownNow();
        AppMethodBeat.o(92019);
        return shutdownNow;
    }

    public final boolean isShutdown() {
        AppMethodBeat.i(92020);
        boolean isShutdown = this.aDB.isShutdown();
        AppMethodBeat.o(92020);
        return isShutdown;
    }

    public final boolean isTerminated() {
        AppMethodBeat.i(92021);
        boolean isTerminated = this.aDB.isTerminated();
        AppMethodBeat.o(92021);
        return isTerminated;
    }

    public final boolean awaitTermination(long j, TimeUnit timeUnit) {
        AppMethodBeat.i(92022);
        boolean awaitTermination = this.aDB.awaitTermination(j, timeUnit);
        AppMethodBeat.o(92022);
        return awaitTermination;
    }

    public final String toString() {
        AppMethodBeat.i(92023);
        String obj = this.aDB.toString();
        AppMethodBeat.o(92023);
        return obj;
    }

    private static int nf() {
        AppMethodBeat.i(92024);
        if (aDA == 0) {
            aDA = Math.min(4, b.availableProcessors());
        }
        int i = aDA;
        AppMethodBeat.o(92024);
        return i;
    }
}
