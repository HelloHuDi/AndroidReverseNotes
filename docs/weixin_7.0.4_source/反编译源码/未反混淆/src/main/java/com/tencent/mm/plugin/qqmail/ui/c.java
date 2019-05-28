package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;

public final class c implements f {
    private static long pzl = 0;
    private Activity czX;
    private a pzm;

    public static abstract class a {
        public abstract void ccF();

        public abstract void ccG();
    }

    public c(Activity activity) {
        AppMethodBeat.i(68413);
        g.RO().eJo.a(138, (f) this);
        this.czX = activity;
        AppMethodBeat.o(68413);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(68414);
        this.pzm = aVar;
        final b kiVar = new ki();
        kiVar.cFO.czX = this.czX;
        kiVar.cFO.cFQ = new Runnable() {
            public final void run() {
                AppMethodBeat.i(68411);
                if (kiVar.cFP.cvi) {
                    c.a(c.this);
                    AppMethodBeat.o(68411);
                    return;
                }
                if (c.this.pzm != null) {
                    c.this.pzm.ccG();
                }
                AppMethodBeat.o(68411);
            }
        };
        com.tencent.mm.sdk.b.a.xxA.a(kiVar, Looper.myLooper());
        AppMethodBeat.o(68414);
    }

    public final void release() {
        AppMethodBeat.i(68415);
        g.RO().eJo.b(138, (f) this);
        AppMethodBeat.o(68415);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.i(68416);
        release();
        super.finalize();
        AppMethodBeat.o(68416);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(68417);
        if (i == 0 && i2 == 0) {
            if (this.pzm != null) {
                this.pzm.ccF();
                this.pzm = null;
            }
        } else if (this.pzm != null) {
            this.pzm.ccG();
            this.pzm = null;
        }
        pzl = System.currentTimeMillis();
        AppMethodBeat.o(68417);
    }
}
