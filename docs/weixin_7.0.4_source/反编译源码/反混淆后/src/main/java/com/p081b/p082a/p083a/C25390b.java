package com.p081b.p082a.p083a;

import android.net.wifi.ScanResult;
import android.os.Handler;
import com.p081b.p082a.p083a.C25394u.C0738e;
import com.p081b.p082a.p083a.C37155r.C37154f;
import com.p081b.p082a.p083a.C44975ab.C17503a;
import com.p081b.p082a.p083a.C8482d.C8483a;
import com.p081b.p082a.p083a.C8487k.C8488a;
import com.p081b.p082a.p083a.C8487k.C8489b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.List;

/* renamed from: com.b.a.a.b */
abstract class C25390b extends C41541a {
    private C37158z bCI;

    /* renamed from: com.b.a.a.b$a */
    static class C25389a implements Runnable {
        private final WeakReference<C25390b> bCJ;
        private final C31914p bCK;

        private C25389a(C25390b c25390b, C31914p c31914p) {
            AppMethodBeat.m2504i(55672);
            if (c25390b == null || c31914p == null) {
                Exception exception = new Exception("CoreAssembly: HandleMsgTask: null arg");
                AppMethodBeat.m2505o(55672);
                throw exception;
            }
            this.bCJ = new WeakReference(c25390b);
            this.bCK = c31914p;
            AppMethodBeat.m2505o(55672);
        }

        /* synthetic */ C25389a(C25390b c25390b, C31914p c31914p, byte b) {
            this(c25390b, c31914p);
        }

        public final void run() {
            AppMethodBeat.m2504i(55673);
            C25390b c25390b = (C25390b) this.bCJ.get();
            if (c25390b != null) {
                switch (this.bCK.what) {
                    case 202:
                        C37154f c37154f = (C37154f) this.bCK;
                        if (c37154f.bFZ != 1) {
                            c25390b.mo42413a(c37154f.bFZ, c37154f.message, c37154f.bFB, c37154f.bFC);
                            break;
                        }
                        c25390b.mo42416a(c37154f.bGa, c37154f.bFB, c37154f.bFC);
                        AppMethodBeat.m2505o(55673);
                        return;
                }
            }
            AppMethodBeat.m2505o(55673);
        }
    }

    /* renamed from: a */
    public abstract void mo42411a(double d, double d2, int i, int i2, int i3, int i4, int i5, float f, long j, long j2);

    /* renamed from: a */
    public abstract void mo42412a(float f, float f2, int i, float f3, float f4, float f5, long j);

    /* renamed from: a */
    public abstract void mo42413a(int i, String str, long j, long j2);

    /* renamed from: a */
    public abstract void mo42416a(C37157x c37157x, long j, long j2);

    /* renamed from: a */
    public abstract void mo42417a(List<ScanResult> list, long j, long j2);

    C25390b() {
        super(C44975ab.m82345wD(), C37155r.m62256wg(), C25394u.m40118wx(), C8487k.m15084wc());
    }

    /* Access modifiers changed, original: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo18559a(Handler handler, C8483a c8483a) {
        if (handler == null) {
            throw new Exception("CoreAssembly: master thread handler must be specified and cannot be null");
        }
        this.bCI = C37158z.m62269b(handler);
        super.mo18559a(handler, c8483a);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo42414a(Handler handler, Handler[] handlerArr) {
        handlerArr[0] = handler;
        handlerArr[1] = null;
        handlerArr[2] = handler;
        handlerArr[3] = handler;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo42415a(C8483a c8483a, C8483a[] c8483aArr) {
        c8483aArr[0] = c8483a;
        c8483aArr[1] = null;
        c8483aArr[2] = null;
        c8483aArr[3] = mo42410a(c8483a);
    }

    /* renamed from: a */
    public void mo2178a(C31914p c31914p) {
        switch (c31914p.what) {
            case 101:
                mo42417a(((C17503a) c31914p).bJi, c31914p.bFB, c31914p.bFC);
                return;
            case 201:
                m40093b(c31914p);
                return;
            case 202:
                m40093b(c31914p);
                return;
            case 301:
                C0738e c0738e = (C0738e) c31914p;
                mo42412a(c0738e.f1027x, c0738e.f1028y, c0738e.bIb, c0738e.bHZ, c0738e.bIa, c0738e.speed, c0738e.bFC);
                return;
            case 401:
                C8489b c8489b = (C8489b) c31914p;
                mo42411a(c8489b.lat, c8489b.lng, Double.valueOf(c8489b.bEI).intValue(), Math.round(c8489b.bEJ), Math.round(c8489b.speed), c8489b.bEL, c8489b.bEM, c8489b.bEK, c8489b.bEN, c8489b.bFC);
                return;
            default:
                return;
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public C8488a mo42410a(C8483a c8483a) {
        if (c8483a == null) {
            return null;
        }
        return new C8488a(Math.max(c8483a.bCP, 10000));
    }

    /* renamed from: b */
    private void m40093b(C31914p c31914p) {
        if (this.bCI != null) {
            try {
                this.bCI.execute(new C25389a(this, c31914p, (byte) 0));
            } catch (Exception e) {
            }
        }
    }
}
