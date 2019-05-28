package android.arch.p1150a.p1151a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: android.arch.a.a.b */
public final class C25281b extends C17361c {
    /* renamed from: bQ */
    private ExecutorService f5020bQ = Executors.newFixedThreadPool(2);
    private final Object mLock = new Object();
    private volatile Handler mMainHandler;

    /* renamed from: c */
    public final void mo31435c(Runnable runnable) {
        this.f5020bQ.execute(runnable);
    }

    /* renamed from: d */
    public final void mo31436d(Runnable runnable) {
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
