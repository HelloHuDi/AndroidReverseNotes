package com.b.a.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

abstract class e {
    private a bCQ;
    long bCR;
    final Handler handler;

    class a implements Runnable {
        private boolean bCS;
        private boolean started;

        private a() {
        }

        /* synthetic */ a(e eVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(55612);
            if (this.bCS) {
                AppMethodBeat.o(55612);
                return;
            }
            e.this.vZ();
            e.this.handler.postDelayed(this, e.this.bCR);
            AppMethodBeat.o(55612);
        }

        static /* synthetic */ void a(a aVar, long j) {
            AppMethodBeat.i(55613);
            if (aVar.started || aVar.bCS) {
                AppMethodBeat.o(55613);
                return;
            }
            e.this.handler.postDelayed(aVar, j);
            aVar.started = true;
            AppMethodBeat.o(55613);
        }

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(55614);
            aVar.bCS = true;
            e.this.handler.removeCallbacks(aVar);
            AppMethodBeat.o(55614);
        }
    }

    public abstract void vZ();

    e(Handler handler) {
        if (handler == null) {
            handler = new Handler();
        }
        this.handler = handler;
    }

    /* Access modifiers changed, original: final */
    public final void n(long j, long j2) {
        stop();
        this.bCR = j;
        this.bCQ = new a(this, (byte) 0);
        a.a(this.bCQ, j2);
    }

    /* Access modifiers changed, original: final */
    public final void stop() {
        if (this.bCQ != null) {
            a.a(this.bCQ);
        }
    }
}
