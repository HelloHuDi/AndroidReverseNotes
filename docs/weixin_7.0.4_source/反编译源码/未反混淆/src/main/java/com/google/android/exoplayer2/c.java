package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.i.o;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c implements m {
    private final j aMB;
    private final long aMC;
    private final long aMD;
    private final long aME;
    private final long aMF;
    private final o aMG;
    private int aMH;
    private boolean aMI;

    public c() {
        this(new j());
        AppMethodBeat.i(94746);
        AppMethodBeat.o(94746);
    }

    private c(j jVar) {
        this(jVar, (byte) 0);
    }

    private c(j jVar, byte b) {
        this(jVar, 0);
    }

    private c(j jVar, char c) {
        this.aMB = jVar;
        this.aMC = 15000000;
        this.aMD = 30000000;
        this.aME = 2500000;
        this.aMF = 5000000;
        this.aMG = null;
    }

    public final void pL() {
        AppMethodBeat.i(94747);
        reset(false);
        AppMethodBeat.o(94747);
    }

    public final void a(r[] rVarArr, g gVar) {
        int i = 0;
        AppMethodBeat.i(94748);
        this.aMH = 0;
        while (i < rVarArr.length) {
            if (gVar.bpE[i] != null) {
                this.aMH += v.eT(rVarArr[i].getTrackType());
            }
            i++;
        }
        this.aMB.eJ(this.aMH);
        AppMethodBeat.o(94748);
    }

    public final void onStopped() {
        AppMethodBeat.i(94749);
        reset(true);
        AppMethodBeat.o(94749);
    }

    public final void pM() {
        AppMethodBeat.i(94750);
        reset(true);
        AppMethodBeat.o(94750);
    }

    public final b pN() {
        return this.aMB;
    }

    public final boolean c(long j, boolean z) {
        long j2 = z ? this.aMF : this.aME;
        return j2 <= 0 || j >= j2;
    }

    private void reset(boolean z) {
        AppMethodBeat.i(94752);
        this.aMH = 0;
        if (this.aMG != null && this.aMI) {
            this.aMG.tP();
        }
        this.aMI = false;
        if (z) {
            this.aMB.reset();
        }
        AppMethodBeat.o(94752);
    }

    public final boolean y(long j) {
        boolean z = false;
        AppMethodBeat.i(94751);
        boolean z2 = j > this.aMD ? false : j < this.aMC ? true : true;
        boolean z3 = this.aMB.tp() >= this.aMH;
        boolean z4 = this.aMI;
        if (z2 || (z2 && this.aMI && !z3)) {
            z = true;
        }
        this.aMI = z;
        if (!(this.aMG == null || this.aMI == z4)) {
            if (this.aMI) {
                o oVar = this.aMG;
                synchronized (oVar.lock) {
                    try {
                        oVar.brx.add(Integer.valueOf(0));
                        oVar.bry = Math.max(oVar.bry, 0);
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(94751);
                        }
                    }
                }
            } else {
                this.aMG.tP();
            }
        }
        z2 = this.aMI;
        AppMethodBeat.o(94751);
        return z2;
    }
}
