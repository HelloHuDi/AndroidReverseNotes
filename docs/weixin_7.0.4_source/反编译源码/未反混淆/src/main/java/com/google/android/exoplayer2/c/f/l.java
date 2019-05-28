package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f.v.d;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l implements h {
    private m aTw;
    private int aUy;
    private boolean bbH;
    private long bbJ;
    private final com.google.android.exoplayer2.i.l bcO = new com.google.android.exoplayer2.i.l(10);
    private int sampleSize;

    public l() {
        AppMethodBeat.i(95133);
        AppMethodBeat.o(95133);
    }

    public final void rn() {
        this.bbH = false;
    }

    public final void a(g gVar, d dVar) {
        AppMethodBeat.i(95134);
        dVar.rz();
        this.aTw = gVar.dM(dVar.rA());
        this.aTw.f(Format.k(dVar.rB(), "application/id3"));
        AppMethodBeat.o(95134);
    }

    public final void d(long j, boolean z) {
        if (z) {
            this.bbH = true;
            this.bbJ = j;
            this.sampleSize = 0;
            this.aUy = 0;
        }
    }

    public final void t(com.google.android.exoplayer2.i.l lVar) {
        AppMethodBeat.i(95135);
        if (this.bbH) {
            int tB = lVar.tB();
            if (this.aUy < 10) {
                int min = Math.min(tB, 10 - this.aUy);
                System.arraycopy(lVar.data, lVar.position, this.bcO.data, this.aUy, min);
                if (min + this.aUy == 10) {
                    this.bcO.setPosition(0);
                    if (73 == this.bcO.readUnsignedByte() && 68 == this.bcO.readUnsignedByte() && 51 == this.bcO.readUnsignedByte()) {
                        this.bcO.eM(3);
                        this.sampleSize = this.bcO.tH() + 10;
                    } else {
                        this.bbH = false;
                        AppMethodBeat.o(95135);
                        return;
                    }
                }
            }
            tB = Math.min(tB, this.sampleSize - this.aUy);
            this.aTw.a(lVar, tB);
            this.aUy = tB + this.aUy;
            AppMethodBeat.o(95135);
            return;
        }
        AppMethodBeat.o(95135);
    }

    public final void ro() {
        AppMethodBeat.i(95136);
        if (this.bbH && this.sampleSize != 0 && this.aUy == this.sampleSize) {
            this.aTw.a(this.bbJ, 1, this.sampleSize, 0, null);
            this.bbH = false;
            AppMethodBeat.o(95136);
            return;
        }
        AppMethodBeat.o(95136);
    }
}
