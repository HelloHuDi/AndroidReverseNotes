package android.support.p057v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.p057v4.content.C44959e.C17437c;
import android.support.p057v4.content.C44959e.C415024;
import android.support.p057v4.p065f.C25336o;
import android.support.p057v4.p066os.C41514c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* renamed from: android.support.v4.content.a */
public abstract class C8383a<D> extends C0383c<D> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncTaskLoader";
    volatile C8384a mCancellingTask;
    private final Executor mExecutor;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile C8384a mTask;
    long mUpdateThrottle;

    /* renamed from: android.support.v4.content.a$a */
    final class C8384a extends C44959e<Void, Void, D> implements Runnable {
        /* renamed from: Gh */
        final CountDownLatch f2343Gh = new CountDownLatch(1);
        /* renamed from: Gi */
        boolean f2344Gi;

        C8384a() {
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        /* renamed from: dv */
        public final /* synthetic */ Object mo18325dv() {
            return m14792du();
        }

        /* renamed from: du */
        private D m14792du() {
            try {
                return C8383a.this.onLoadInBackground();
            } catch (C41514c e) {
                if (this.f17692GC.get()) {
                    return null;
                }
                throw e;
            }
        }

        /* Access modifiers changed, original: protected|final */
        public final void onPostExecute(D d) {
            try {
                C8383a.this.dispatchOnLoadComplete(this, d);
            } finally {
                this.f2343Gh.countDown();
            }
        }

        /* Access modifiers changed, original: protected|final */
        public final void onCancelled(D d) {
            try {
                C8383a.this.dispatchOnCancelled(this, d);
            } finally {
                this.f2343Gh.countDown();
            }
        }

        public final void run() {
            this.f2344Gi = false;
            C8383a.this.executePendingTask();
        }
    }

    public abstract D loadInBackground();

    public C8383a(Context context) {
        this(context, C44959e.THREAD_POOL_EXECUTOR);
    }

    private C8383a(Context context, Executor executor) {
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
        this.mTask = new C8384a();
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
                if (this.mTask.f2344Gi) {
                    this.mTask.f2344Gi = false;
                    this.mHandler.removeCallbacks(this.mTask);
                }
                this.mTask = null;
            } else if (this.mTask.f2344Gi) {
                this.mTask.f2344Gi = false;
                this.mHandler.removeCallbacks(this.mTask);
                this.mTask = null;
            } else {
                C8384a c8384a = this.mTask;
                c8384a.f17692GC.set(true);
                z = c8384a.f17690GA.cancel(false);
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
            if (this.mTask.f2344Gi) {
                this.mTask.f2344Gi = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            if (this.mUpdateThrottle <= 0 || SystemClock.uptimeMillis() >= this.mLastLoadCompleteTime + this.mUpdateThrottle) {
                C8384a c8384a = this.mTask;
                Executor executor = this.mExecutor;
                if (c8384a.f17691GB != C17437c.PENDING) {
                    switch (C415024.f16783GF[c8384a.f17691GB.ordinal()]) {
                        case 1:
                            throw new IllegalStateException("Cannot execute task: the task is already running.");
                        case 2:
                            throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                        default:
                            throw new IllegalStateException("We should never reach this state");
                    }
                }
                c8384a.f17691GB = C17437c.RUNNING;
                c8384a.f17694Gz.f3897GM = null;
                executor.execute(c8384a.f17690GA);
                return;
            }
            this.mTask.f2344Gi = true;
            this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void dispatchOnCancelled(C8384a c8384a, D d) {
        onCanceled(d);
        if (this.mCancellingTask == c8384a) {
            rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            deliverCancellation();
            executePendingTask();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void dispatchOnLoadComplete(C8384a c8384a, D d) {
        if (this.mTask != c8384a) {
            dispatchOnCancelled(c8384a, d);
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
        C8384a c8384a = this.mTask;
        if (c8384a != null) {
            try {
                c8384a.f2343Gh.await();
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
            printWriter.println(this.mTask.f2344Gi);
        }
        if (this.mCancellingTask != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.mCancellingTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mCancellingTask.f2344Gi);
        }
        if (this.mUpdateThrottle != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            C25336o.m39984b(this.mUpdateThrottle, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            C25336o.m39982a(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
}
