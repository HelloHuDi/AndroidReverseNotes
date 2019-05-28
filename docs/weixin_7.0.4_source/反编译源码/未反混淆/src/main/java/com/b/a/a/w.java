package com.b.a.a;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class w extends n {
    private static w bIs;
    private boolean bIt;
    private int bIu;
    private long bIv;
    private long bIw;

    static w wC() {
        AppMethodBeat.i(55606);
        if (bIs == null) {
            bIs = new w();
        }
        w wVar = bIs;
        AppMethodBeat.o(55606);
        return wVar;
    }

    w() {
    }

    /* Access modifiers changed, original: final */
    public final void a(Context context, Handler handler, a aVar) {
        AppMethodBeat.i(55607);
        if (this.bIt) {
            if (k.wc().bCM) {
                k.wc().vY();
            }
        } else if (!k.wc().bCM) {
            try {
                k.wc().a(context, this);
            } catch (Exception e) {
            }
        }
        super.a(context, handler, aVar);
        AppMethodBeat.o(55607);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void a(Handler handler, a aVar) {
        AppMethodBeat.i(55608);
        this.bIt = false;
        super.a(handler, aVar);
        AppMethodBeat.o(55608);
    }

    public final void a(p pVar) {
        Object obj;
        AppMethodBeat.i(55609);
        long j = pVar.bFC;
        if (!this.bIt || j - this.bIw <= this.bIv) {
            obj = null;
        } else {
            stop();
            obj = 1;
        }
        if (obj != null) {
            AppMethodBeat.o(55609);
            return;
        }
        super.a(pVar);
        AppMethodBeat.o(55609);
    }

    /* Access modifiers changed, original: final */
    public final void a(int i, String str, long j, long j2) {
        AppMethodBeat.i(55611);
        if (this.bIt) {
            stop();
        }
        super.a(i, str, j, j2);
        AppMethodBeat.o(55611);
    }

    /* Access modifiers changed, original: final */
    public final void a(x xVar, long j, long j2) {
        Object obj;
        AppMethodBeat.i(55610);
        if (xVar.bIB == null) {
            xVar.bIB = new a();
        }
        float f = xVar.bIB.bIE;
        if (!this.bIt || f < ((float) this.bIu)) {
            obj = null;
        } else {
            stop();
            obj = 1;
        }
        if (obj != null) {
            AppMethodBeat.o(55610);
            return;
        }
        super.a(xVar, j, j2);
        AppMethodBeat.o(55610);
    }
}
