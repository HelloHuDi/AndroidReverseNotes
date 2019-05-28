package com.b.a.a;

import android.net.wifi.ScanResult;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.List;

abstract class b extends a {
    private z bCI;

    static class a implements Runnable {
        private final WeakReference<b> bCJ;
        private final p bCK;

        private a(b bVar, p pVar) {
            AppMethodBeat.i(55672);
            if (bVar == null || pVar == null) {
                Exception exception = new Exception("CoreAssembly: HandleMsgTask: null arg");
                AppMethodBeat.o(55672);
                throw exception;
            }
            this.bCJ = new WeakReference(bVar);
            this.bCK = pVar;
            AppMethodBeat.o(55672);
        }

        /* synthetic */ a(b bVar, p pVar, byte b) {
            this(bVar, pVar);
        }

        public final void run() {
            AppMethodBeat.i(55673);
            b bVar = (b) this.bCJ.get();
            if (bVar != null) {
                switch (this.bCK.what) {
                    case 202:
                        f fVar = (f) this.bCK;
                        if (fVar.bFZ != 1) {
                            bVar.a(fVar.bFZ, fVar.message, fVar.bFB, fVar.bFC);
                            break;
                        }
                        bVar.a(fVar.bGa, fVar.bFB, fVar.bFC);
                        AppMethodBeat.o(55673);
                        return;
                }
            }
            AppMethodBeat.o(55673);
        }
    }

    public abstract void a(double d, double d2, int i, int i2, int i3, int i4, int i5, float f, long j, long j2);

    public abstract void a(float f, float f2, int i, float f3, float f4, float f5, long j);

    public abstract void a(int i, String str, long j, long j2);

    public abstract void a(x xVar, long j, long j2);

    public abstract void a(List<ScanResult> list, long j, long j2);

    b() {
        super(ab.wD(), r.wg(), u.wx(), k.wc());
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized void a(Handler handler, a aVar) {
        if (handler == null) {
            throw new Exception("CoreAssembly: master thread handler must be specified and cannot be null");
        }
        this.bCI = z.b(handler);
        super.a(handler, aVar);
    }

    /* Access modifiers changed, original: final */
    public final void a(Handler handler, Handler[] handlerArr) {
        handlerArr[0] = handler;
        handlerArr[1] = null;
        handlerArr[2] = handler;
        handlerArr[3] = handler;
    }

    /* Access modifiers changed, original: final */
    public final void a(a aVar, a[] aVarArr) {
        aVarArr[0] = aVar;
        aVarArr[1] = null;
        aVarArr[2] = null;
        aVarArr[3] = a(aVar);
    }

    public void a(p pVar) {
        switch (pVar.what) {
            case 101:
                a(((a) pVar).bJi, pVar.bFB, pVar.bFC);
                return;
            case 201:
                b(pVar);
                return;
            case 202:
                b(pVar);
                return;
            case 301:
                e eVar = (e) pVar;
                a(eVar.x, eVar.y, eVar.bIb, eVar.bHZ, eVar.bIa, eVar.speed, eVar.bFC);
                return;
            case 401:
                b bVar = (b) pVar;
                a(bVar.lat, bVar.lng, Double.valueOf(bVar.bEI).intValue(), Math.round(bVar.bEJ), Math.round(bVar.speed), bVar.bEL, bVar.bEM, bVar.bEK, bVar.bEN, bVar.bFC);
                return;
            default:
                return;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public a a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new a(Math.max(aVar.bCP, 10000));
    }

    private void b(p pVar) {
        if (this.bCI != null) {
            try {
                this.bCI.execute(new a(this, pVar, (byte) 0));
            } catch (Exception e) {
            }
        }
    }
}
