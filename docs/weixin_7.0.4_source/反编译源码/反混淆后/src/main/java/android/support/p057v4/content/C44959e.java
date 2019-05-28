package android.support.p057v4.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: android.support.v4.content.e */
abstract class C44959e<Params, Progress, Result> {
    /* renamed from: Gw */
    private static final BlockingQueue<Runnable> f17687Gw = new LinkedBlockingQueue(10);
    /* renamed from: Gx */
    private static C44958b f17688Gx;
    /* renamed from: Gy */
    private static volatile Executor f17689Gy;
    public static final Executor THREAD_POOL_EXECUTOR;
    private static final ThreadFactory sThreadFactory = new C174361();
    /* renamed from: GA */
    final FutureTask<Result> f17690GA = new FutureTask<Result>(this.f17694Gz) {
        /* Access modifiers changed, original: protected|final */
        public final void done() {
            try {
                C44959e.this.mo72173n(get());
            } catch (InterruptedException e) {
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
            } catch (CancellationException e3) {
                C44959e.this.mo72173n(null);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    };
    /* renamed from: GB */
    volatile C17437c f17691GB = C17437c.PENDING;
    /* renamed from: GC */
    final AtomicBoolean f17692GC = new AtomicBoolean();
    /* renamed from: GD */
    private final AtomicBoolean f17693GD = new AtomicBoolean();
    /* renamed from: Gz */
    final C17438d<Params, Result> f17694Gz = new C253342();

    /* renamed from: android.support.v4.content.e$1 */
    static class C174361 implements ThreadFactory {
        private final AtomicInteger mCount = new AtomicInteger(1);

        C174361() {
        }

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.mCount.getAndIncrement());
        }
    }

    /* renamed from: android.support.v4.content.e$c */
    public enum C17437c {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* renamed from: android.support.v4.content.e$d */
    static abstract class C17438d<Params, Result> implements Callable<Result> {
        /* renamed from: GM */
        Params[] f3897GM;

        C17438d() {
        }
    }

    /* renamed from: android.support.v4.content.e$2 */
    class C253342 extends C17438d<Params, Result> {
        C253342() {
        }

        public final Result call() {
            C44959e.this.f17693GD.set(true);
            Object obj = null;
            try {
                Process.setThreadPriority(10);
                obj = C44959e.this.mo18325dv();
                Binder.flushPendingCommands();
                C44959e.this.mo72174o(obj);
                return obj;
            } catch (Throwable th) {
                C44959e.this.mo72174o(obj);
            }
        }
    }

    /* renamed from: android.support.v4.content.e$4 */
    static /* synthetic */ class C415024 {
        /* renamed from: GF */
        static final /* synthetic */ int[] f16783GF = new int[C17437c.values().length];

        static {
            try {
                f16783GF[C17437c.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f16783GF[C17437c.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* renamed from: android.support.v4.content.e$a */
    static class C41503a<Data> {
        /* renamed from: GG */
        final C44959e f16784GG;
        /* renamed from: GH */
        final Data[] f16785GH;

        C41503a(C44959e c44959e, Data... dataArr) {
            this.f16784GG = c44959e;
            this.f16785GH = dataArr;
        }
    }

    /* renamed from: android.support.v4.content.e$b */
    static class C44958b extends Handler {
        C44958b() {
            super(Looper.getMainLooper());
        }

        public final void handleMessage(Message message) {
            C41503a c41503a = (C41503a) message.obj;
            switch (message.what) {
                case 1:
                    c41503a.f16784GG.mo72175p(c41503a.f16785GH[0]);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: dv */
    public abstract Result mo18325dv();

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f17687Gw, sThreadFactory);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
        f17689Gy = threadPoolExecutor;
    }

    private static Handler getHandler() {
        C44958b c44958b;
        synchronized (C44959e.class) {
            if (f17688Gx == null) {
                f17688Gx = new C44958b();
            }
            c44958b = f17688Gx;
        }
        return c44958b;
    }

    C44959e() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: n */
    public final void mo72173n(Result result) {
        if (!this.f17693GD.get()) {
            mo72174o(result);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: o */
    public final Result mo72174o(Result result) {
        C44959e.getHandler().obtainMessage(1, new C41503a(this, result)).sendToTarget();
        return result;
    }

    /* Access modifiers changed, original: protected */
    public void onPostExecute(Result result) {
    }

    /* Access modifiers changed, original: protected */
    public void onCancelled(Result result) {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: p */
    public final void mo72175p(Result result) {
        if (this.f17692GC.get()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.f17691GB = C17437c.FINISHED;
    }
}
