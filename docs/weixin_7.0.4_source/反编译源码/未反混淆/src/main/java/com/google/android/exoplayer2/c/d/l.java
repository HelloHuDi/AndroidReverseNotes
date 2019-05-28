package com.google.android.exoplayer2.c.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class l {
    public int aZA;
    public long[] aZB;
    public int[] aZC;
    public int[] aZD;
    public int[] aZE;
    public long[] aZF;
    public boolean[] aZG;
    public boolean aZH;
    public boolean[] aZI;
    public k aZJ;
    public int aZK;
    public com.google.android.exoplayer2.i.l aZL;
    public boolean aZM;
    public long aZN;
    public c aZw;
    public long aZx;
    public long aZy;
    public long aZz;
    public int sampleCount;

    l() {
    }

    public final void reset() {
        this.aZA = 0;
        this.aZN = 0;
        this.aZH = false;
        this.aZM = false;
        this.aZJ = null;
    }

    public final void bd(int i, int i2) {
        this.aZA = i;
        this.sampleCount = i2;
        if (this.aZC == null || this.aZC.length < i) {
            this.aZB = new long[i];
            this.aZC = new int[i];
        }
        if (this.aZD == null || this.aZD.length < i2) {
            int i3 = (i2 * 125) / 100;
            this.aZD = new int[i3];
            this.aZE = new int[i3];
            this.aZF = new long[i3];
            this.aZG = new boolean[i3];
            this.aZI = new boolean[i3];
        }
    }

    public final void ea(int i) {
        AppMethodBeat.i(95014);
        if (this.aZL == null || this.aZL.limit < i) {
            this.aZL = new com.google.android.exoplayer2.i.l(i);
        }
        this.aZK = i;
        this.aZH = true;
        this.aZM = true;
        AppMethodBeat.o(95014);
    }

    public final void q(com.google.android.exoplayer2.i.l lVar) {
        AppMethodBeat.i(95015);
        lVar.readBytes(this.aZL.data, 0, this.aZK);
        this.aZL.setPosition(0);
        this.aZM = false;
        AppMethodBeat.o(95015);
    }

    public final long eb(int i) {
        return this.aZF[i] + ((long) this.aZE[i]);
    }
}
