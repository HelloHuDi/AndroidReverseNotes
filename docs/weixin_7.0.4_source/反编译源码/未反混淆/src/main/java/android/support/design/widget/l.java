package android.support.design.widget;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

final class l {
    private static l rr;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Callback() {
        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    l lVar = l.this;
                    b bVar = (b) message.obj;
                    synchronized (lVar.mLock) {
                        if (lVar.rs == bVar || lVar.rt == bVar) {
                            lVar.a(bVar);
                        }
                    }
                    return true;
                default:
                    return false;
            }
        }
    });
    final Object mLock = new Object();
    b rs;
    b rt;

    interface a {
    }

    static class b {
        int duration;
        final WeakReference<a> rv;
        boolean rw;

        /* Access modifiers changed, original: final */
        public final boolean f(a aVar) {
            return aVar != null && this.rv.get() == aVar;
        }
    }

    static l co() {
        if (rr == null) {
            rr = new l();
        }
        return rr;
    }

    private l() {
    }

    public final void a(a aVar) {
        synchronized (this.mLock) {
            if (d(aVar) && !this.rs.rw) {
                this.rs.rw = true;
                this.mHandler.removeCallbacksAndMessages(this.rs);
            }
        }
    }

    public final void b(a aVar) {
        synchronized (this.mLock) {
            if (d(aVar) && this.rs.rw) {
                this.rs.rw = false;
                b(this.rs);
            }
        }
    }

    public final boolean c(a aVar) {
        boolean z;
        synchronized (this.mLock) {
            z = d(aVar) || e(aVar);
        }
        return z;
    }

    /* Access modifiers changed, original: final */
    public final boolean a(b bVar) {
        if (((a) bVar.rv.get()) == null) {
            return false;
        }
        this.mHandler.removeCallbacksAndMessages(bVar);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final boolean d(a aVar) {
        return this.rs != null && this.rs.f(aVar);
    }

    /* Access modifiers changed, original: final */
    public final boolean e(a aVar) {
        return this.rt != null && this.rt.f(aVar);
    }

    /* Access modifiers changed, original: final */
    public final void b(b bVar) {
        if (bVar.duration != -2) {
            int i = 2750;
            if (bVar.duration > 0) {
                i = bVar.duration;
            } else if (bVar.duration == -1) {
                i = 1500;
            }
            this.mHandler.removeCallbacksAndMessages(bVar);
            this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 0, bVar), (long) i);
        }
    }
}
