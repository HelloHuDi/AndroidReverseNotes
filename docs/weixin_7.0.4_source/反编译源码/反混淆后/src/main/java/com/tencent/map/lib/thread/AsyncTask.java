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
    /* renamed from: a */
    private static final C32214b f14995a = new C32214b(Looper.getMainLooper());
    public static final Executor sHighThreadExecutor = new HighThreadExecutor();
    public static final Executor sHightSerialExecutor = new C32217c();
    public static final Executor sLowSerialExecutor = new C32217c();
    public static final Executor sLowThreadExecutor = new LowThreadExecutor();
    /* renamed from: b */
    private final C32218e<Params, Result> f14996b = new C322161();
    /* renamed from: c */
    private final FutureTask<Result> f14997c = new FutureTask<Result>(this.f14996b) {
        /* Access modifiers changed, original: protected */
        public void done() {
            AppMethodBeat.m2504i(98166);
            try {
                AsyncTask.this.m52560a(get());
                AppMethodBeat.m2505o(98166);
            } catch (InterruptedException e) {
                AppMethodBeat.m2505o(98166);
            } catch (ExecutionException e2) {
                RuntimeException runtimeException = new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
                AppMethodBeat.m2505o(98166);
                throw runtimeException;
            } catch (CancellationException e3) {
                AsyncTask.this.m52560a(null);
                AppMethodBeat.m2505o(98166);
            }
        }
    };
    /* renamed from: d */
    private volatile C32215d f14998d = C32215d.PENDING;
    /* renamed from: e */
    private final AtomicBoolean f14999e = new AtomicBoolean();
    /* renamed from: f */
    private final AtomicBoolean f15000f = new AtomicBoolean();
    /* renamed from: g */
    private boolean f15001g = true;

    /* renamed from: com.tencent.map.lib.thread.AsyncTask$a */
    static class C25733a<Data> {
        /* renamed from: a */
        final AsyncTask<?, ?, ?> f5456a;
        /* renamed from: b */
        final Data[] f5457b;

        C25733a(AsyncTask<?, ?, ?> asyncTask, Data... dataArr) {
            this.f5456a = asyncTask;
            this.f5457b = dataArr;
        }
    }

    /* renamed from: com.tencent.map.lib.thread.AsyncTask$b */
    static class C32214b extends Handler {
        public C32214b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            AppMethodBeat.m2504i(98169);
            C25733a c25733a = (C25733a) message.obj;
            switch (message.what) {
                case 1:
                    c25733a.f5456a.m52565c(c25733a.f5457b[0]);
                    AppMethodBeat.m2505o(98169);
                    return;
                case 2:
                    c25733a.f5456a.onProgressUpdate(c25733a.f5457b);
                    break;
            }
            AppMethodBeat.m2505o(98169);
        }
    }

    /* renamed from: com.tencent.map.lib.thread.AsyncTask$d */
    public enum C32215d {
        PENDING,
        RUNNING,
        FINISHED;

        static {
            AppMethodBeat.m2505o(98176);
        }
    }

    /* renamed from: com.tencent.map.lib.thread.AsyncTask$1 */
    class C322161 extends C32218e<Params, Result> {
        C322161() {
            super();
        }

        public Result call() {
            AppMethodBeat.m2504i(98165);
            AsyncTask.this.f15000f.set(true);
            Object a = AsyncTask.this.m52562b(AsyncTask.this.doInBackground(this.f15009b));
            AppMethodBeat.m2505o(98165);
            return a;
        }
    }

    /* renamed from: com.tencent.map.lib.thread.AsyncTask$c */
    static class C32217c implements Executor {
        /* renamed from: a */
        final LinkedList<Runnable> f15007a;
        /* renamed from: b */
        Runnable f15008b;

        private C32217c() {
            AppMethodBeat.m2504i(98171);
            this.f15007a = new LinkedList();
            AppMethodBeat.m2505o(98171);
        }

        /* synthetic */ C32217c(C322161 c322161) {
            this();
        }

        public synchronized void execute(final Runnable runnable) {
            AppMethodBeat.m2504i(98172);
            this.f15007a.offer(new Runnable() {
                public void run() {
                    AppMethodBeat.m2504i(98170);
                    try {
                        runnable.run();
                    } finally {
                        C32217c.this.mo52905a();
                        AppMethodBeat.m2505o(98170);
                    }
                }
            });
            if (this.f15008b == null) {
                mo52905a();
            }
            AppMethodBeat.m2505o(98172);
        }

        /* Access modifiers changed, original: protected|declared_synchronized */
        /* renamed from: a */
        public synchronized void mo52905a() {
            AppMethodBeat.m2504i(98173);
            Runnable runnable = (Runnable) this.f15007a.poll();
            this.f15008b = runnable;
            if (runnable != null) {
                AsyncTask.sHighThreadExecutor.execute(this.f15008b);
            }
            AppMethodBeat.m2505o(98173);
        }
    }

    /* renamed from: com.tencent.map.lib.thread.AsyncTask$e */
    static abstract class C32218e<Params, Result> implements Callable<Result> {
        /* renamed from: b */
        Params[] f15009b;

        private C32218e() {
        }

        /* synthetic */ C32218e(C322161 c322161) {
            this();
        }
    }

    public abstract Result doInBackground(Params... paramsArr);

    public static void init() {
        f14995a.getLooper();
    }

    /* renamed from: a */
    private void m52560a(Result result) {
        if (!this.f15000f.get()) {
            m52562b((Object) result);
        }
    }

    /* renamed from: b */
    private Result m52562b(Result result) {
        Message obtainMessage = f14995a.obtainMessage(1, new C25733a(this, result));
        if (this.f15001g) {
            obtainMessage.sendToTarget();
        } else {
            f14995a.sendMessageAtFrontOfQueue(obtainMessage);
        }
        return result;
    }

    public final C32215d getStatus() {
        return this.f14998d;
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
        return this.f14999e.get();
    }

    public final boolean cancel(boolean z) {
        this.f14999e.set(true);
        return this.f14997c.cancel(z);
    }

    public final Result get() {
        return this.f14997c.get();
    }

    public final Result get(long j, TimeUnit timeUnit) {
        return this.f14997c.get(j, timeUnit);
    }

    public final AsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        return execute(true, (Object[]) paramsArr);
    }

    public final AsyncTask<Params, Progress, Result> execute(boolean z, Params... paramsArr) {
        this.f15001g = z;
        if (this.f15001g) {
            return executeOnExecutor(sLowThreadExecutor, paramsArr);
        }
        return executeOnExecutor(sHighThreadExecutor, paramsArr);
    }

    public final void execute(long j, final Params... paramsArr) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(98167);
                if (AsyncTask.this.f14998d == C32215d.PENDING) {
                    AsyncTask.this.execute(paramsArr);
                }
                AppMethodBeat.m2505o(98167);
            }
        }, j);
    }

    public final AsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        if (this.f14998d != C32215d.PENDING) {
            switch (this.f14998d) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f14998d = C32215d.RUNNING;
        onPreExecute();
        this.f14996b.f15009b = paramsArr;
        executor.execute(this.f14997c);
        return this;
    }

    public static void execute(Runnable runnable) {
        sLowThreadExecutor.execute(runnable);
    }

    /* Access modifiers changed, original: protected|final|varargs */
    public final void publishProgress(Progress... progressArr) {
        if (!isCancelled()) {
            f14995a.obtainMessage(2, new C25733a(this, progressArr)).sendToTarget();
        }
    }

    /* renamed from: c */
    private void m52565c(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.f14998d = C32215d.FINISHED;
    }
}
