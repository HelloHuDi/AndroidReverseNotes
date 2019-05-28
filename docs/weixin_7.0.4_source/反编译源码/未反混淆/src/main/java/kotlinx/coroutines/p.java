package kotlinx.coroutines;

import a.c.e;
import a.f.b.j;
import a.h.h;
import a.k.t;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@l(dWo = {1, 1, 13}, dWp = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0011\u001a\u0004\u0018\u0001H\u0012\"\u0004\b\u0000\u0010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0014H\b¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u001c\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\n\u0010\u0013\u001a\u00060\u001ej\u0002`\u001fH\u0016J\b\u0010 \u001a\u00020\u0006H\u0002J!\u0010!\u001a\u00020\u00102\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030#2\u0006\u0010\u0005\u001a\u00020\u0019H\u0000¢\u0006\u0002\b$J\r\u0010%\u001a\u00020\u0017H\u0000¢\u0006\u0002\b&J\u0015\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)H\u0000¢\u0006\u0002\b*J\b\u0010+\u001a\u00020\u0004H\u0016J\r\u0010\u000f\u001a\u00020\u0017H\u0000¢\u0006\u0002\b,R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, dWq = {"Lkotlinx/coroutines/CommonPool;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "()V", "DEFAULT_PARALLELISM_PROPERTY_NAME", "", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "parallelism", "", "getParallelism", "()I", "pool", "requestedParallelism", "usePrivatePool", "", "Try", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "close", "", "createPlainPool", "Ljava/util/concurrent/ExecutorService;", "createPool", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "getOrCreatePoolSync", "isGoodCommonPool", "fjpClass", "Ljava/lang/Class;", "isGoodCommonPool$kotlinx_coroutines_core", "restore", "restore$kotlinx_coroutines_core", "shutdown", "timeout", "", "shutdown$kotlinx_coroutines_core", "toString", "usePrivatePool$kotlinx_coroutines_core", "kotlinx-coroutines-core"})
public final class p extends av {
    private static final int BPB;
    private static boolean BPC;
    private static volatile Executor BPD;
    public static final p BPE = new p();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "Ljava/lang/Thread;", "it", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "newThread"})
    static final class a implements ThreadFactory {
        final /* synthetic */ AtomicInteger BPF;

        a(AtomicInteger atomicInteger) {
            this.BPF = atomicInteger;
        }

        public final Thread newThread(Runnable runnable) {
            AppMethodBeat.i(118523);
            Thread thread = new Thread(runnable, "CommonPool-worker-" + this.BPF.incrementAndGet());
            thread.setDaemon(true);
            AppMethodBeat.o(118523);
            return thread;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        public static final b BPG = new b();

        static {
            AppMethodBeat.i(118377);
            AppMethodBeat.o(118377);
        }

        b() {
        }

        public final void run() {
        }
    }

    static {
        String property;
        int i;
        AppMethodBeat.i(118569);
        try {
            property = System.getProperty("kotlinx.coroutines.default.parallelism");
        } catch (Throwable th) {
            property = null;
        }
        if (property == null) {
            i = -1;
        } else {
            Integer awy = t.awy(property);
            if (awy == null || awy.intValue() <= 0) {
                Throwable illegalStateException = new IllegalStateException("Expected positive number in kotlinx.coroutines.default.parallelism, but has ".concat(String.valueOf(property)).toString());
                AppMethodBeat.o(118569);
                throw illegalStateException;
            }
            i = awy.intValue();
        }
        BPB = i;
        AppMethodBeat.o(118569);
    }

    private p() {
    }

    private static int getParallelism() {
        AppMethodBeat.i(118562);
        Integer valueOf = Integer.valueOf(BPB);
        if ((((Number) valueOf).intValue() > 0 ? 1 : 0) == 0) {
            valueOf = null;
        }
        int intValue;
        if (valueOf != null) {
            intValue = valueOf.intValue();
            AppMethodBeat.o(118562);
            return intValue;
        }
        intValue = h.im(Runtime.getRuntime().availableProcessors() - 1, 1);
        AppMethodBeat.o(118562);
        return intValue;
    }

    private static ExecutorService ekW() {
        AppMethodBeat.i(118563);
        ExecutorService ekX;
        if (System.getSecurityManager() != null) {
            ekX = ekX();
            AppMethodBeat.o(118563);
            return ekX;
        }
        Class cls;
        try {
            cls = Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (Throwable th) {
            cls = null;
        }
        if (cls == null) {
            ekX = ekX();
            AppMethodBeat.o(118563);
            return ekX;
        }
        Object invoke;
        if (!BPC && BPB < 0) {
            try {
                Method method = cls.getMethod("commonPool", new Class[0]);
                if (method != null) {
                    invoke = method.invoke(null, new Object[0]);
                } else {
                    invoke = null;
                }
                if (!(invoke instanceof ExecutorService)) {
                    invoke = null;
                }
                ekX = (ExecutorService) invoke;
            } catch (Throwable th2) {
                ekX = null;
            }
            if (ekX != null) {
                if (!a(cls, ekX)) {
                    ekX = null;
                }
                if (ekX != null) {
                    AppMethodBeat.o(118563);
                    return ekX;
                }
            }
        }
        try {
            invoke = cls.getConstructor(new Class[]{Integer.TYPE}).newInstance(new Object[]{Integer.valueOf(getParallelism())});
            if (!(invoke instanceof ExecutorService)) {
                invoke = null;
            }
            ekX = (ExecutorService) invoke;
        } catch (Throwable th3) {
            ekX = null;
        }
        if (ekX != null) {
            AppMethodBeat.o(118563);
            return ekX;
        }
        ekX = ekX();
        AppMethodBeat.o(118563);
        return ekX;
    }

    private static boolean a(Class<?> cls, ExecutorService executorService) {
        Integer num;
        AppMethodBeat.i(118564);
        j.p(cls, "fjpClass");
        j.p(executorService, "executor");
        executorService.submit(b.BPG);
        try {
            Object invoke = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
            if (!(invoke instanceof Integer)) {
                invoke = null;
            }
            num = (Integer) invoke;
        } catch (Throwable th) {
            num = null;
        }
        if (num == null) {
            AppMethodBeat.o(118564);
            return false;
        } else if (num.intValue() > 0) {
            AppMethodBeat.o(118564);
            return true;
        } else {
            AppMethodBeat.o(118564);
            return false;
        }
    }

    private static ExecutorService ekX() {
        AppMethodBeat.i(118565);
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(getParallelism(), new a(new AtomicInteger()));
        j.o(newFixedThreadPool, "Executors.newFixedThread…Daemon = true }\n        }");
        AppMethodBeat.o(118565);
        return newFixedThreadPool;
    }

    private final synchronized Executor ekY() {
        Executor executor;
        AppMethodBeat.i(118566);
        executor = BPD;
        if (executor == null) {
            ExecutorService ekW = ekW();
            BPD = ekW;
            executor = ekW;
        }
        AppMethodBeat.o(118566);
        return executor;
    }

    public final void a(e eVar, Runnable runnable) {
        AppMethodBeat.i(118567);
        j.p(eVar, "context");
        j.p(runnable, "block");
        try {
            Executor executor = BPD;
            if (executor == null) {
                executor = ekY();
            }
            executor.execute(bs.elC().aD(runnable));
            AppMethodBeat.o(118567);
        } catch (RejectedExecutionException e) {
            bs.elC();
            ag.BPW.aE(runnable);
            AppMethodBeat.o(118567);
        }
    }

    public final String toString() {
        return "CommonPool";
    }

    public final void close() {
        AppMethodBeat.i(118568);
        Throwable illegalStateException = new IllegalStateException("Close cannot be invoked on CommonPool".toString());
        AppMethodBeat.o(118568);
        throw illegalStateException;
    }
}
