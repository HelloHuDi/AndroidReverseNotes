package com.tencent.map.lib.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AsyncTask<Params, Progress, Result> {
    private static final b a = new b(Looper.getMainLooper());
    public static final Executor sHighThreadExecutor = new HighThreadExecutor();
    public static final Executor sHightSerialExecutor = new c();
    public static final Executor sLowSerialExecutor = new c();
    public static final Executor sLowThreadExecutor = new LowThreadExecutor();
    private final e<Params, Result> b = new e<Params, Result>() {
        public Result call() {
            AppMethodBeat.i(98165);
            AsyncTask.this.f.set(true);
            Object a = AsyncTask.this.b(AsyncTask.this.doInBackground(this.b));
            AppMethodBeat.o(98165);
            return a;
        }
    };
    private final FutureTask<Result> c = new FutureTask<Result>(this.b) {
        /* Access modifiers changed, original: protected */
        public void done() {
            AppMethodBeat.i(98166);
            try {
                AsyncTask.this.a(get());
                AppMethodBeat.o(98166);
            } catch (InterruptedException e) {
                AppMethodBeat.o(98166);
            } catch (ExecutionException e2) {
                RuntimeException runtimeException = new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
                AppMethodBeat.o(98166);
                throw runtimeException;
            } catch (CancellationException e3) {
                AsyncTask.this.a(null);
                AppMethodBeat.o(98166);
            }
        }
    };
    private volatile d d = d.PENDING;
    private final AtomicBoolean e = new AtomicBoolean();
    private final AtomicBoolean f = new AtomicBoolean();
    private boolean g = true;

    static class a<Data> {
        final AsyncTask<?, ?, ?> a;
        final Data[] b;

        a(AsyncTask<?, ?, ?> asyncTask, Data... dataArr) {
            this.a = asyncTask;
            this.b = dataArr;
        }
    }

    static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            AppMethodBeat.i(98169);
            a aVar = (a) message.obj;
            switch (message.what) {
                case 1:
                    aVar.a.c(aVar.b[0]);
                    AppMethodBeat.o(98169);
                    return;
                case 2:
                    aVar.a.onProgressUpdate(aVar.b);
                    break;
            }
            AppMethodBeat.o(98169);
        }
    }

    public enum d {
        PENDING,
        RUNNING,
        FINISHED;

        static {
            AppMethodBeat.o(98176);
        }
    }

    static class c implements Executor {
        final LinkedList<Runnable> a;
        Runnable b;

        private c() {
            AppMethodBeat.i(98171);
            this.a = new LinkedList();
            AppMethodBeat.o(98171);
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        public synchronized void execute(final Runnable runnable) {
            AppMethodBeat.i(98172);
            this.a.offer(new Runnable() {
                public void run() {
                    AppMethodBeat.i(98170);
                    try {
                        runnable.run();
                    } finally {
                        c.this.a();
                        AppMethodBeat.o(98170);
                    }
                }
            });
            if (this.b == null) {
                a();
            }
            AppMethodBeat.o(98172);
        }

        /* Access modifiers changed, original: protected|declared_synchronized */
        public synchronized void a() {
            AppMethodBeat.i(98173);
            Runnable runnable = (Runnable) this.a.poll();
            this.b = runnable;
            if (runnable != null) {
                AsyncTask.sHighThreadExecutor.execute(this.b);
            }
            AppMethodBeat.o(98173);
        }
    }

    static abstract class e<Params, Result> implements Callable<Result> {
        Params[] b;

        private e() {
        }

        /* synthetic */ e(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public abstract Result doInBackground(Params... paramsArr);

    public static void init() {
        a.getLooper();
    }

    private void a(Result result) {
        if (!this.f.get()) {
            b((Object) result);
        }
    }

    private Result b(Result result) {
        Message obtainMessage = a.obtainMessage(1, new a(this, result));
        if (this.g) {
            obtainMessage.sendToTarget();
        } else {
            a.sendMessageAtFrontOfQueue(obtainMessage);
        }
        return result;
    }

    public final d getStatus() {
        return this.d;
    }

    /* Access modifiers changed, original: protected */
    public void onPreExecute() {
    }

    /* Access modifiers changed, original: protected */
    public void onPostExecute(Result result) {
    }

    /* Access modifiers changed, original: protected|varargs */
    public void onProgressUpdate(Progress... progressArr) {
    }

    /* Access modifiers changed, original: protected */
    public void onCancelled(Result result) {
        onCancelled();
    }

    /* Access modifiers changed, original: protected */
    public void onCancelled() {
    }

    public final boolean isCancelled() {
        return this.e.get();
    }

    public final boolean cancel(boolean z) {
        this.e.set(true);
        return this.c.cancel(z);
    }

    public final Result get() {
        return this.c.get();
    }

    public final Result get(long j, TimeUnit timeUnit) {
        return this.c.get(j, timeUnit);
    }

    public final AsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        return execute(true, (Object[]) paramsArr);
    }

    public final AsyncTask<Params, Progress, Result> execute(boolean z, Params... paramsArr) {
        this.g = z;
        if (this.g) {
            return executeOnExecutor(sLowThreadExecutor, paramsArr);
        }
        return executeOnExecutor(sHighThreadExecutor, paramsArr);
    }

    public final void execute(long j, final Params... paramsArr) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                AppMethodBeat.i(98167);
                if (AsyncTask.this.d == d.PENDING) {
                    AsyncTask.this.execute(paramsArr);
                }
                AppMethodBeat.o(98167);
            }
        }, j);
    }

    public final AsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        if (this.d != d.PENDING) {
            switch (this.d) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.d = d.RUNNING;
        onPreExecute();
        this.b.b = paramsArr;
        executor.execute(this.c);
        return this;
    }

    public static void execute(Runnable runnable) {
        sLowThreadExecutor.execute(runnable);
    }

    /* Access modifiers changed, original: protected|final|varargs */
    public final void publishProgress(Progress... progressArr) {
        if (!isCancelled()) {
            a.obtainMessage(2, new a(this, progressArr)).sendToTarget();
        }
    }

    private void c(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.d = d.FINISHED;
    }
}
