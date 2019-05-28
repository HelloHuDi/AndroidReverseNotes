package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f.v.d;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.s;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t implements q {
    private m aTw;
    private s aYf;
    private boolean bdq;

    public final void a(s sVar, g gVar, d dVar) {
        AppMethodBeat.i(95163);
        this.aYf = sVar;
        dVar.rz();
        this.aTw = gVar.dM(dVar.rA());
        this.aTw.f(Format.k(dVar.rB(), "application/x-scte35"));
        AppMethodBeat.o(95163);
    }

    public final void t(l lVar) {
        long j = -9223372036854775807L;
        AppMethodBeat.i(95164);
        if (!this.bdq) {
            if (this.aYf.tQ() == -9223372036854775807L) {
                AppMethodBeat.o(95164);
                return;
            } else {
                this.aTw.f(Format.c("application/x-scte35", this.aYf.tQ()));
                this.bdq = true;
            }
        }
        int tB = lVar.tB();
        this.aTw.a(lVar, tB);
        m mVar = this.aTw;
        s sVar = this.aYf;
        if (sVar.brL != -9223372036854775807L) {
            j = sVar.brL;
        } else if (sVar.bbh != Long.MAX_VALUE) {
            j = sVar.bbh;
        }
        mVar.a(j, 1, tB, 0, null);
        AppMethodBeat.o(95164);
    }
}
