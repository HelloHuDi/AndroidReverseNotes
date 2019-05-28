package com.google.android.exoplayer2.p111i;

import android.os.SystemClock;
import com.google.android.exoplayer2.C17628b;
import com.google.android.exoplayer2.C45045p;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.i.q */
public final class C41618q implements C32063h {
    private C45045p aNg = C45045p.aOC;
    private long brI;
    private long brJ;
    private boolean started;

    public final void start() {
        AppMethodBeat.m2504i(95934);
        if (!this.started) {
            this.brJ = SystemClock.elapsedRealtime();
            this.started = true;
        }
        AppMethodBeat.m2505o(95934);
    }

    public final void stop() {
        AppMethodBeat.m2504i(95935);
        if (this.started) {
            mo66746ai(mo52353qy());
            this.started = false;
        }
        AppMethodBeat.m2505o(95935);
    }

    /* renamed from: ai */
    public final void mo66746ai(long j) {
        AppMethodBeat.m2504i(95936);
        this.brI = j;
        if (this.started) {
            this.brJ = SystemClock.elapsedRealtime();
        }
        AppMethodBeat.m2505o(95936);
    }

    /* renamed from: a */
    public final void mo66745a(C32063h c32063h) {
        AppMethodBeat.m2504i(95937);
        mo66746ai(c32063h.mo52353qy());
        this.aNg = c32063h.mo52352qC();
        AppMethodBeat.m2505o(95937);
    }

    /* renamed from: qy */
    public final long mo52353qy() {
        AppMethodBeat.m2504i(95938);
        long j = this.brI;
        if (this.started) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.brJ;
            if (this.aNg.speed == 1.0f) {
                j += C17628b.m27434x(elapsedRealtime);
            } else {
                j += elapsedRealtime * ((long) this.aNg.aOD);
            }
        }
        AppMethodBeat.m2505o(95938);
        return j;
    }

    /* renamed from: b */
    public final C45045p mo52351b(C45045p c45045p) {
        AppMethodBeat.m2504i(95939);
        if (this.started) {
            mo66746ai(mo52353qy());
        }
        this.aNg = c45045p;
        AppMethodBeat.m2505o(95939);
        return c45045p;
    }

    /* renamed from: qC */
    public final C45045p mo52352qC() {
        return this.aNg;
    }
}
