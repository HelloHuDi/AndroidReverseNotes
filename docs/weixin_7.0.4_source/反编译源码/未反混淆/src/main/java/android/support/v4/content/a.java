package android.support.v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.content.e.AnonymousClass4;
import android.support.v4.f.o;
import android.support.v4.os.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public abstract class a<D> extends c<D> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncTaskLoader";
    volatile a mCancellingTask;
    private final Executor mExecutor;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile a mTask;
    long mUpdateThrottle;

    final class a extends e<Void, Void, D> implements Runnable {
        final CountDownLatch Gh = new CountDownLatch(1);
        boolean Gi;

        a() {
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object dv() {
            return du();
        }

        private D du() {
            try {
                return a.this.onLoadInBackground();
            } catch (c e) {
                if (this.GC.get()) {
                    return null;
                }
                throw e;
            }
        }

        /* Access modifiers changed, original: protected|final */
        public final void onPostExecute(D d) {
            try {
                a.this.dispatchOnLoadComplete(this, d);
            } finally {
                this.Gh.countDown();
            }
        }

        /* Access modifiers changed, original: protected|final */
        public final void onCancelled(D d) {
            try {
                a.this.dispatchOnCancelled(this, d);
            } finally {
                this.Gh.countDown();
            }
        }

        public final void run() {
            this.Gi = false;
            a.this.executePendingTask();
        }
    }

    public abstract D loadInBackground();

    public a(Context context) {
        this(context, e.THREAD_POOL_EXECUTOR);
    }

    private a(Context context, Executor executor) {
        super(context);
        this.mLastLoadCompleteTime = -10000;
        this.mExecutor = executor;
    }

    public void setUpdateThrottle(long j) {
        this.mUpdateThrottle = j;
        if (j != 0) {
            this.mHandler = new Handler();
        }
    }

    /* Access modifiers changed, original: protected */
    public void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new a();
        executePendingTask();
    }

    /* Access modifiers changed, original: protected */
    public boolean onCancelLoad() {
        boolean z = false;
        if (this.mTask != null) {
            if (!this.mStarted) {
                this.mContentChanged = true;
            }
            if (this.mCancellingTask != null) {
                if (this.mTask.Gi) {
                    this.mTask.Gi = false;
                    this.mHandler.removeCallbacks(this.mTask);
                }
                this.mTask = null;
            } else if (this.mTask.Gi) {
                this.mTask.Gi = false;
                this.mHandler.removeCallbacks(this.mTask);
                this.mTask = null;
            } else {
                a aVar = this.mTask;
                aVar.GC.set(true);
                z = aVar.GA.cancel(false);
                if (z) {
                    this.mCancellingTask = this.mTask;
                    cancelLoadInBackground();
                }
                this.mTask = null;
            }
        }
        return z;
    }

    public void onCanceled(D d) {
    }

    /* Access modifiers changed, original: 0000 */
    public void executePendingTask() {
        if (this.mCancellingTask == null && this.mTask != null) {
            if (this.mTask.Gi) {
                this.mTask.Gi = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            if (this.mUpdateThrottle <= 0 || SystemClock.uptimeMillis() >= this.mLastLoadCompleteTime + this.mUpdateThrottle) {
                a aVar = this.mTask;
                Executor executor = this.mExecutor;
                if (aVar.GB != e.c.PENDING) {
                    switch (AnonymousClass4.GF[aVar.GB.ordinal()]) {
                        case 1:
                            throw new IllegalStateException("Cannot execute task: the task is already running.");
                        case 2:
                            throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                        default:
                            throw new IllegalStateException("We should never reach this state");
                    }
                }
                aVar.GB = e.c.RUNNING;
                aVar.Gz.GM = null;
                executor.execute(aVar.GA);
                return;
            }
            this.mTask.Gi = true;
            this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void dispatchOnCancelled(a aVar, D d) {
        onCanceled(d);
        if (this.mCancellingTask == aVar) {
            rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            deliverCancellation();
            executePendingTask();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void dispatchOnLoadComplete(a aVar, D d) {
        if (this.mTask != aVar) {
            dispatchOnCancelled(aVar, d);
        } else if (isAbandoned()) {
            onCanceled(d);
        } else {
            commitContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mTask = null;
            deliverResult(d);
        }
    }

    /* Access modifiers changed, original: protected */
    public D onLoadInBackground() {
        return loadInBackground();
    }

    public void cancelLoadInBackground() {
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.mCancellingTask != null;
    }

    public void waitForLoader() {
        a aVar = this.mTask;
        if (aVar != null) {
            try {
                aVar.Gh.await();
            } catch (InterruptedException e) {
            }
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.mTask != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.mTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mTask.Gi);
        }
        if (this.mCancellingTask != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.mCancellingTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mCancellingTask.Gi);
        }
        if (this.mUpdateThrottle != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            o.b(this.mUpdateThrottle, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            o.a(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
}
