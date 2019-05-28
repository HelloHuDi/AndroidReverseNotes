package com.p081b.p082a.p083a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.b.a.a.e */
abstract class C25393e {
    private C25392a bCQ;
    long bCR;
    final Handler handler;

    /* renamed from: com.b.a.a.e$a */
    class C25392a implements Runnable {
        private boolean bCS;
        private boolean started;

        private C25392a() {
        }

        /* synthetic */ C25392a(C25393e c25393e, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(55612);
            if (this.bCS) {
                AppMethodBeat.m2505o(55612);
                return;
            }
            C25393e.this.mo42422vZ();
            C25393e.this.handler.postDelayed(this, C25393e.this.bCR);
            AppMethodBeat.m2505o(55612);
        }

        /* renamed from: a */
        static /* synthetic */ void m40109a(C25392a c25392a, long j) {
            AppMethodBeat.m2504i(55613);
            if (c25392a.started || c25392a.bCS) {
                AppMethodBeat.m2505o(55613);
                return;
            }
            C25393e.this.handler.postDelayed(c25392a, j);
            c25392a.started = true;
            AppMethodBeat.m2505o(55613);
        }

        /* renamed from: a */
        static /* synthetic */ void m40108a(C25392a c25392a) {
            AppMethodBeat.m2504i(55614);
            c25392a.bCS = true;
            C25393e.this.handler.removeCallbacks(c25392a);
            AppMethodBeat.m2505o(55614);
        }
    }

    /* renamed from: vZ */
    public abstract void mo42422vZ();

    C25393e(Handler handler) {
        if (handler == null) {
            handler = new Handler();
        }
        this.handler = handler;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: n */
    public final void mo42420n(long j, long j2) {
        stop();
        this.bCR = j;
        this.bCQ = new C25392a(this, (byte) 0);
        C25392a.m40109a(this.bCQ, j2);
    }

    /* Access modifiers changed, original: final */
    public final void stop() {
        if (this.bCQ != null) {
            C25392a.m40108a(this.bCQ);
        }
    }
}
