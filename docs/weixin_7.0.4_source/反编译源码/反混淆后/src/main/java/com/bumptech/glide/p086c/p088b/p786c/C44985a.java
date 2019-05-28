package com.bumptech.glide.p086c.p088b.p786c;

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

/* renamed from: com.bumptech.glide.c.b.c.a */
public final class C44985a implements ExecutorService {
    private static volatile int aDA;
    private static final long aDz = TimeUnit.SECONDS.toMillis(10);
    private final ExecutorService aDB;

    /* renamed from: com.bumptech.glide.c.b.c.a$b */
    public interface C25417b {
        public static final C25417b aDG = new C254181();
        public static final C25417b aDH = new C254202();
        public static final C25417b aDI = new C254193();
        public static final C25417b aDJ = aDH;

        /* renamed from: com.bumptech.glide.c.b.c.a$b$1 */
        class C254181 implements C25417b {
            C254181() {
            }

            /* renamed from: d */
            public final void mo42463d(Throwable th) {
            }
        }

        /* renamed from: com.bumptech.glide.c.b.c.a$b$3 */
        class C254193 implements C25417b {
            C254193() {
            }

            /* renamed from: d */
            public final void mo42463d(Throwable th) {
                AppMethodBeat.m2504i(92005);
                RuntimeException runtimeException = new RuntimeException("Request threw uncaught throwable", th);
                AppMethodBeat.m2505o(92005);
                throw runtimeException;
            }
        }

        /* renamed from: com.bumptech.glide.c.b.c.a$b$2 */
        class C254202 implements C25417b {
            C254202() {
            }

            /* renamed from: d */
            public final void mo42463d(Throwable th) {
                AppMethodBeat.m2504i(92004);
                Log.isLoggable("GlideExecutor", 6);
                AppMethodBeat.m2505o(92004);
            }
        }

        /* renamed from: d */
        void mo42463d(Throwable th);
    }

    /* renamed from: com.bumptech.glide.c.b.c.a$a */
    static final class C31934a implements ThreadFactory {
        final C25417b aDC;
        final boolean aDD;
        private int aDE;
        private final String name;

        C31934a(String str, C25417b c25417b, boolean z) {
            this.name = str;
            this.aDC = c25417b;
            this.aDD = z;
        }

        public final synchronized Thread newThread(Runnable runnable) {
            C85231 c85231;
            AppMethodBeat.m2504i(92003);
            c85231 = new Thread(runnable, "glide-" + this.name + "-thread-" + this.aDE) {
                public final void run() {
                    AppMethodBeat.m2504i(92002);
                    Process.setThreadPriority(9);
                    if (C31934a.this.aDD) {
                        StrictMode.setThreadPolicy(new Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                        AppMethodBeat.m2505o(92002);
                    } catch (Throwable th) {
                        C31934a.this.aDC.mo42463d(th);
                        AppMethodBeat.m2505o(92002);
                    }
                }
            };
            this.aDE++;
            AppMethodBeat.m2505o(92003);
            return c85231;
        }
    }

    static {
        AppMethodBeat.m2504i(92025);
        AppMethodBeat.m2505o(92025);
    }

    /* renamed from: nb */
    public static C44985a m82374nb() {
        AppMethodBeat.m2504i(92006);
        C25417b c25417b = C25417b.aDJ;
        C44985a c44985a = new C44985a(new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C31934a("disk-cache", c25417b, true)));
        AppMethodBeat.m2505o(92006);
        return c44985a;
    }

    /* renamed from: nc */
    public static C44985a m82375nc() {
        AppMethodBeat.m2504i(92007);
        int nf = C44985a.m82378nf();
        C25417b c25417b = C25417b.aDJ;
        C44985a c44985a = new C44985a(new ThreadPoolExecutor(nf, nf, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C31934a("source", c25417b, false)));
        AppMethodBeat.m2505o(92007);
        return c44985a;
    }

    /* renamed from: nd */
    public static C44985a m82376nd() {
        AppMethodBeat.m2504i(92008);
        C44985a c44985a = new C44985a(new ThreadPoolExecutor(0, BaseClientBuilder.API_PRIORITY_OTHER, aDz, TimeUnit.MILLISECONDS, new SynchronousQueue(), new C31934a("source-unlimited", C25417b.aDJ, false)));
        AppMethodBeat.m2505o(92008);
        return c44985a;
    }

    /* renamed from: ne */
    public static C44985a m82377ne() {
        int i;
        AppMethodBeat.m2504i(92009);
        if (C44985a.m82378nf() >= 4) {
            i = 2;
        } else {
            i = 1;
        }
        C44985a c44985a = new C44985a(new ThreadPoolExecutor(0, i, aDz, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C31934a("animation", C25417b.aDJ, true)));
        AppMethodBeat.m2505o(92009);
        return c44985a;
    }

    private C44985a(ExecutorService executorService) {
        this.aDB = executorService;
    }

    public final void execute(Runnable runnable) {
        AppMethodBeat.m2504i(92010);
        this.aDB.execute(runnable);
        AppMethodBeat.m2505o(92010);
    }

    public final Future<?> submit(Runnable runnable) {
        AppMethodBeat.m2504i(92011);
        Future submit = this.aDB.submit(runnable);
        AppMethodBeat.m2505o(92011);
        return submit;
    }

    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        AppMethodBeat.m2504i(92012);
        List invokeAll = this.aDB.invokeAll(collection);
        AppMethodBeat.m2505o(92012);
        return invokeAll;
    }

    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        AppMethodBeat.m2504i(92013);
        List invokeAll = this.aDB.invokeAll(collection, j, timeUnit);
        AppMethodBeat.m2505o(92013);
        return invokeAll;
    }

    public final <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        AppMethodBeat.m2504i(92014);
        Object invokeAny = this.aDB.invokeAny(collection);
        AppMethodBeat.m2505o(92014);
        return invokeAny;
    }

    public final <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        AppMethodBeat.m2504i(92015);
        Object invokeAny = this.aDB.invokeAny(collection, j, timeUnit);
        AppMethodBeat.m2505o(92015);
        return invokeAny;
    }

    public final <T> Future<T> submit(Runnable runnable, T t) {
        AppMethodBeat.m2504i(92016);
        Future submit = this.aDB.submit(runnable, t);
        AppMethodBeat.m2505o(92016);
        return submit;
    }

    public final <T> Future<T> submit(Callable<T> callable) {
        AppMethodBeat.m2504i(92017);
        Future submit = this.aDB.submit(callable);
        AppMethodBeat.m2505o(92017);
        return submit;
    }

    public final void shutdown() {
        AppMethodBeat.m2504i(92018);
        this.aDB.shutdown();
        AppMethodBeat.m2505o(92018);
    }

    public final List<Runnable> shutdownNow() {
        AppMethodBeat.m2504i(92019);
        List shutdownNow = this.aDB.shutdownNow();
        AppMethodBeat.m2505o(92019);
        return shutdownNow;
    }

    public final boolean isShutdown() {
        AppMethodBeat.m2504i(92020);
        boolean isShutdown = this.aDB.isShutdown();
        AppMethodBeat.m2505o(92020);
        return isShutdown;
    }

    public final boolean isTerminated() {
        AppMethodBeat.m2504i(92021);
        boolean isTerminated = this.aDB.isTerminated();
        AppMethodBeat.m2505o(92021);
        return isTerminated;
    }

    public final boolean awaitTermination(long j, TimeUnit timeUnit) {
        AppMethodBeat.m2504i(92022);
        boolean awaitTermination = this.aDB.awaitTermination(j, timeUnit);
        AppMethodBeat.m2505o(92022);
        return awaitTermination;
    }

    public final String toString() {
        AppMethodBeat.m2504i(92023);
        String obj = this.aDB.toString();
        AppMethodBeat.m2505o(92023);
        return obj;
    }

    /* renamed from: nf */
    private static int m82378nf() {
        AppMethodBeat.m2504i(92024);
        if (aDA == 0) {
            aDA = Math.min(4, C37167b.availableProcessors());
        }
        int i = aDA;
        AppMethodBeat.m2505o(92024);
        return i;
    }
}
