package com.google.android.exoplayer2.i;

import android.os.SystemClock;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.p;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q implements h {
    private p aNg = p.aOC;
    private long brI;
    private long brJ;
    private boolean started;

    public final void start() {
        AppMethodBeat.i(95934);
        if (!this.started) {
            this.brJ = SystemClock.elapsedRealtime();
            this.started = true;
        }
        AppMethodBeat.o(95934);
    }

    public final void stop() {
        AppMethodBeat.i(95935);
        if (this.started) {
            ai(qy());
            this.started = false;
        }
        AppMethodBeat.o(95935);
    }

    public final void ai(long j) {
        AppMethodBeat.i(95936);
        this.brI = j;
        if (this.started) {
            this.brJ = SystemClock.elapsedRealtime();
        }
        AppMethodBeat.o(95936);
    }

    public final void a(h hVar) {
        AppMethodBeat.i(95937);
        ai(hVar.qy());
        this.aNg = hVar.qC();
        AppMethodBeat.o(95937);
    }

    public final long qy() {
        AppMethodBeat.i(95938);
        long j = this.brI;
        if (this.started) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.brJ;
            if (this.aNg.speed == 1.0f) {
                j += b.x(elapsedRealtime);
            } else {
                j += elapsedRealtime * ((long) this.aNg.aOD);
            }
        }
        AppMethodBeat.o(95938);
        return j;
    }

    public final p b(p pVar) {
        AppMethodBeat.i(95939);
        if (this.started) {
            ai(qy());
        }
        this.aNg = pVar;
        AppMethodBeat.o(95939);
        return pVar;
    }

    public final p qC() {
        return this.aNg;
    }
}
