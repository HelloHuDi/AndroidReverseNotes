package android.arch.a.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class b extends c {
    private ExecutorService bQ = Executors.newFixedThreadPool(2);
    private final Object mLock = new Object();
    private volatile Handler mMainHandler;

    public final void c(Runnable runnable) {
        this.bQ.execute(runnable);
    }

    public final void d(Runnable runnable) {
        if (this.mMainHandler == null) {
            synchronized (this.mLock) {
                if (this.mMainHandler == null) {
                    this.mMainHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.mMainHandler.post(runnable);
    }

    public final boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
