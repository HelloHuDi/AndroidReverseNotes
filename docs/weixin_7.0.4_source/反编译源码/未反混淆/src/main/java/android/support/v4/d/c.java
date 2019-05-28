package android.support.v4.d;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class c {
    private Callback Ku = new Callback() {
        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    c cVar = c.this;
                    synchronized (cVar.mLock) {
                        if (cVar.mHandler.hasMessages(1)) {
                            break;
                        }
                        cVar.mThread.quit();
                        cVar.mThread = null;
                        cVar.mHandler = null;
                    }
                case 1:
                    c cVar2 = c.this;
                    ((Runnable) message.obj).run();
                    synchronized (cVar2.mLock) {
                        cVar2.mHandler.removeMessages(0);
                        cVar2.mHandler.sendMessageDelayed(cVar2.mHandler.obtainMessage(0), (long) cVar2.Kv);
                    }
                    break;
            }
            return true;
        }
    };
    final int Kv;
    private int mGeneration;
    Handler mHandler;
    final Object mLock = new Object();
    private final int mPriority;
    HandlerThread mThread;
    private final String mThreadName;

    /* renamed from: android.support.v4.d.c$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ Handler Kx;
        final /* synthetic */ a Ky;
        final /* synthetic */ Callable val$callable;

        AnonymousClass2(Callable callable, Handler handler, a aVar) {
            this.val$callable = callable;
            this.Kx = handler;
            this.Ky = aVar;
        }

        public final void run() {
            Object call;
            try {
                call = this.val$callable.call();
            } catch (Exception e) {
                call = null;
            }
            this.Kx.post(new Runnable() {
                public final void run() {
                    AnonymousClass2.this.Ky.D(call);
                }
            });
        }
    }

    public interface a<T> {
        void D(T t);
    }

    public c(String str) {
        this.mThreadName = str;
        this.mPriority = 10;
        this.Kv = Downloads.MIN_WAIT_FOR_NETWORK;
        this.mGeneration = 0;
    }

    /* Access modifiers changed, original: final */
    public final void f(Runnable runnable) {
        synchronized (this.mLock) {
            if (this.mThread == null) {
                this.mThread = new HandlerThread(this.mThreadName, this.mPriority);
                this.mThread.start();
                this.mHandler = new Handler(this.mThread.getLooper(), this.Ku);
                this.mGeneration++;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, runnable));
        }
    }

    public final <T> T a(Callable<T> callable, int i) {
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition newCondition = reentrantLock.newCondition();
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        final Callable<T> callable2 = callable;
        f(new Runnable() {
            public final void run() {
                try {
                    atomicReference.set(callable2.call());
                } catch (Exception e) {
                }
                reentrantLock.lock();
                try {
                    atomicBoolean.set(false);
                    newCondition.signal();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
        reentrantLock.lock();
        try {
            T t;
            if (atomicBoolean.get()) {
                long toNanos = TimeUnit.MILLISECONDS.toNanos((long) i);
                while (true) {
                    try {
                        toNanos = newCondition.awaitNanos(toNanos);
                    } catch (InterruptedException e) {
                    }
                    if (!atomicBoolean.get()) {
                        t = atomicReference.get();
                        reentrantLock.unlock();
                        break;
                    } else if (toNanos <= 0) {
                        throw new InterruptedException("timeout");
                    }
                }
            }
            t = atomicReference.get();
            return t;
        } finally {
            reentrantLock.unlock();
        }
    }
}
