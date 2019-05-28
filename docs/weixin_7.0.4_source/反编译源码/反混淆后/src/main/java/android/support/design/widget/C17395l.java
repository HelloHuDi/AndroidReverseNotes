package android.support.design.widget;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* renamed from: android.support.design.widget.l */
final class C17395l {
    /* renamed from: rr */
    private static C17395l f3800rr;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new C83481());
    final Object mLock = new Object();
    /* renamed from: rs */
    C17397b f3801rs;
    /* renamed from: rt */
    C17397b f3802rt;

    /* renamed from: android.support.design.widget.l$1 */
    class C83481 implements Callback {
        C83481() {
        }

        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    C17395l c17395l = C17395l.this;
                    C17397b c17397b = (C17397b) message.obj;
                    synchronized (c17395l.mLock) {
                        if (c17395l.f3801rs == c17397b || c17395l.f3802rt == c17397b) {
                            c17395l.mo31610a(c17397b);
                        }
                    }
                    return true;
                default:
                    return false;
            }
        }
    }

    /* renamed from: android.support.design.widget.l$a */
    interface C17396a {
    }

    /* renamed from: android.support.design.widget.l$b */
    static class C17397b {
        int duration;
        /* renamed from: rv */
        final WeakReference<C17396a> f3803rv;
        /* renamed from: rw */
        boolean f3804rw;

        /* Access modifiers changed, original: final */
        /* renamed from: f */
        public final boolean mo31616f(C17396a c17396a) {
            return c17396a != null && this.f3803rv.get() == c17396a;
        }
    }

    /* renamed from: co */
    static C17395l m27011co() {
        if (f3800rr == null) {
            f3800rr = new C17395l();
        }
        return f3800rr;
    }

    private C17395l() {
    }

    /* renamed from: a */
    public final void mo31609a(C17396a c17396a) {
        synchronized (this.mLock) {
            if (mo31614d(c17396a) && !this.f3801rs.f3804rw) {
                this.f3801rs.f3804rw = true;
                this.mHandler.removeCallbacksAndMessages(this.f3801rs);
            }
        }
    }

    /* renamed from: b */
    public final void mo31611b(C17396a c17396a) {
        synchronized (this.mLock) {
            if (mo31614d(c17396a) && this.f3801rs.f3804rw) {
                this.f3801rs.f3804rw = false;
                mo31612b(this.f3801rs);
            }
        }
    }

    /* renamed from: c */
    public final boolean mo31613c(C17396a c17396a) {
        boolean z;
        synchronized (this.mLock) {
            z = mo31614d(c17396a) || mo31615e(c17396a);
        }
        return z;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo31610a(C17397b c17397b) {
        if (((C17396a) c17397b.f3803rv.get()) == null) {
            return false;
        }
        this.mHandler.removeCallbacksAndMessages(c17397b);
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: d */
    public final boolean mo31614d(C17396a c17396a) {
        return this.f3801rs != null && this.f3801rs.mo31616f(c17396a);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: e */
    public final boolean mo31615e(C17396a c17396a) {
        return this.f3802rt != null && this.f3802rt.mo31616f(c17396a);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo31612b(C17397b c17397b) {
        if (c17397b.duration != -2) {
            int i = 2750;
            if (c17397b.duration > 0) {
                i = c17397b.duration;
            } else if (c17397b.duration == -1) {
                i = 1500;
            }
            this.mHandler.removeCallbacksAndMessages(c17397b);
            this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 0, c17397b), (long) i);
        }
    }
}
