package android.support.p057v4.p063d;

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

/* renamed from: android.support.v4.d.c */
public final class C0399c {
    /* renamed from: Ku */
    private Callback f461Ku = new C03941();
    /* renamed from: Kv */
    final int f462Kv;
    private int mGeneration;
    Handler mHandler;
    final Object mLock = new Object();
    private final int mPriority;
    HandlerThread mThread;
    private final String mThreadName;

    /* renamed from: android.support.v4.d.c$1 */
    class C03941 implements Callback {
        C03941() {
        }

        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    C0399c c0399c = C0399c.this;
                    synchronized (c0399c.mLock) {
                        if (c0399c.mHandler.hasMessages(1)) {
                            break;
                        }
                        c0399c.mThread.quit();
                        c0399c.mThread = null;
                        c0399c.mHandler = null;
                    }
                case 1:
                    C0399c c0399c2 = C0399c.this;
                    ((Runnable) message.obj).run();
                    synchronized (c0399c2.mLock) {
                        c0399c2.mHandler.removeMessages(0);
                        c0399c2.mHandler.sendMessageDelayed(c0399c2.mHandler.obtainMessage(0), (long) c0399c2.f462Kv);
                    }
                    break;
            }
            return true;
        }
    }

    /* renamed from: android.support.v4.d.c$2 */
    class C03962 implements Runnable {
        /* renamed from: Kx */
        final /* synthetic */ Handler f454Kx;
        /* renamed from: Ky */
        final /* synthetic */ C0398a f455Ky;
        final /* synthetic */ Callable val$callable;

        C03962(Callable callable, Handler handler, C0398a c0398a) {
            this.val$callable = callable;
            this.f454Kx = handler;
            this.f455Ky = c0398a;
        }

        public final void run() {
            Object call;
            try {
                call = this.val$callable.call();
            } catch (Exception e) {
                call = null;
            }
            this.f454Kx.post(new Runnable() {
                public final void run() {
                    C03962.this.f455Ky.mo699D(call);
                }
            });
        }
    }

    /* renamed from: android.support.v4.d.c$a */
    public interface C0398a<T> {
        /* renamed from: D */
        void mo699D(T t);
    }

    public C0399c(String str) {
        this.mThreadName = str;
        this.mPriority = 10;
        this.f462Kv = Downloads.MIN_WAIT_FOR_NETWORK;
        this.mGeneration = 0;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: f */
    public final void mo705f(Runnable runnable) {
        synchronized (this.mLock) {
            if (this.mThread == null) {
                this.mThread = new HandlerThread(this.mThreadName, this.mPriority);
                this.mThread.start();
                this.mHandler = new Handler(this.mThread.getLooper(), this.f461Ku);
                this.mGeneration++;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, runnable));
        }
    }

    /* renamed from: a */
    public final <T> T mo704a(Callable<T> callable, int i) {
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition newCondition = reentrantLock.newCondition();
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        final Callable<T> callable2 = callable;
        mo705f(new Runnable() {
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
