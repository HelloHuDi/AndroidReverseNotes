package android.support.v4.content;

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

abstract class e<Params, Progress, Result> {
    private static final BlockingQueue<Runnable> Gw = new LinkedBlockingQueue(10);
    private static b Gx;
    private static volatile Executor Gy;
    public static final Executor THREAD_POOL_EXECUTOR;
    private static final ThreadFactory sThreadFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.mCount.getAndIncrement());
        }
    };
    final FutureTask<Result> GA = new FutureTask<Result>(this.Gz) {
        /* Access modifiers changed, original: protected|final */
        public final void done() {
            try {
                e.this.n(get());
            } catch (InterruptedException e) {
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
            } catch (CancellationException e3) {
                e.this.n(null);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    };
    volatile c GB = c.PENDING;
    final AtomicBoolean GC = new AtomicBoolean();
    private final AtomicBoolean GD = new AtomicBoolean();
    final d<Params, Result> Gz = new d<Params, Result>() {
        public final Result call() {
            e.this.GD.set(true);
            Object obj = null;
            try {
                Process.setThreadPriority(10);
                obj = e.this.dv();
                Binder.flushPendingCommands();
                e.this.o(obj);
                return obj;
            } catch (Throwable th) {
                e.this.o(obj);
            }
        }
    };

    public enum c {
        PENDING,
        RUNNING,
        FINISHED
    }

    static abstract class d<Params, Result> implements Callable<Result> {
        Params[] GM;

        d() {
        }
    }

    /* renamed from: android.support.v4.content.e$4 */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] GF = new int[c.values().length];

        static {
            try {
                GF[c.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                GF[c.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    static class a<Data> {
        final e GG;
        final Data[] GH;

        a(e eVar, Data... dataArr) {
            this.GG = eVar;
            this.GH = dataArr;
        }
    }

    static class b extends Handler {
        b() {
            super(Looper.getMainLooper());
        }

        public final void handleMessage(Message message) {
            a aVar = (a) message.obj;
            switch (message.what) {
                case 1:
                    aVar.GG.p(aVar.GH[0]);
                    return;
                default:
                    return;
            }
        }
    }

    public abstract Result dv();

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, Gw, sThreadFactory);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
        Gy = threadPoolExecutor;
    }

    private static Handler getHandler() {
        b bVar;
        synchronized (e.class) {
            if (Gx == null) {
                Gx = new b();
            }
            bVar = Gx;
        }
        return bVar;
    }

    e() {
    }

    /* Access modifiers changed, original: final */
    public final void n(Result result) {
        if (!this.GD.get()) {
            o(result);
        }
    }

    /* Access modifiers changed, original: final */
    public final Result o(Result result) {
        getHandler().obtainMessage(1, new a(this, result)).sendToTarget();
        return result;
    }

    /* Access modifiers changed, original: protected */
    public void onPostExecute(Result result) {
    }

    /* Access modifiers changed, original: protected */
    public void onCancelled(Result result) {
    }

    /* Access modifiers changed, original: final */
    public final void p(Result result) {
        if (this.GC.get()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.GB = c.FINISHED;
    }
}
