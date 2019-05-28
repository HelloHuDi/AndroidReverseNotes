package com.google.android.exoplayer2.p101c.p102d;

import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c.d.l */
final class C8652l {
    public int aZA;
    public long[] aZB;
    public int[] aZC;
    public int[] aZD;
    public int[] aZE;
    public long[] aZF;
    public boolean[] aZG;
    public boolean aZH;
    public boolean[] aZI;
    public C25518k aZJ;
    public int aZK;
    public C32065l aZL;
    public boolean aZM;
    public long aZN;
    public C0839c aZw;
    public long aZx;
    public long aZy;
    public long aZz;
    public int sampleCount;

    C8652l() {
    }

    public final void reset() {
        this.aZA = 0;
        this.aZN = 0;
        this.aZH = false;
        this.aZM = false;
        this.aZJ = null;
    }

    /* renamed from: bd */
    public final void mo19148bd(int i, int i2) {
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

    /* renamed from: ea */
    public final void mo19149ea(int i) {
        AppMethodBeat.m2504i(95014);
        if (this.aZL == null || this.aZL.limit < i) {
            this.aZL = new C32065l(i);
        }
        this.aZK = i;
        this.aZH = true;
        this.aZM = true;
        AppMethodBeat.m2505o(95014);
    }

    /* renamed from: q */
    public final void mo19151q(C32065l c32065l) {
        AppMethodBeat.m2504i(95015);
        c32065l.readBytes(this.aZL.data, 0, this.aZK);
        this.aZL.setPosition(0);
        this.aZM = false;
        AppMethodBeat.m2505o(95015);
    }

    /* renamed from: eb */
    public final long mo19150eb(int i) {
        return this.aZF[i] + ((long) this.aZE[i]);
    }
}
