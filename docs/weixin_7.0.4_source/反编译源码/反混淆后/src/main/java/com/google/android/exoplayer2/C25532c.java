package com.google.android.exoplayer2;

import com.google.android.exoplayer2.p109g.C37259g;
import com.google.android.exoplayer2.p110h.C32053b;
import com.google.android.exoplayer2.p110h.C45037j;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C25543o;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c */
public final class C25532c implements C8693m {
    private final C45037j aMB;
    private final long aMC;
    private final long aMD;
    private final long aME;
    private final long aMF;
    private final C25543o aMG;
    private int aMH;
    private boolean aMI;

    public C25532c() {
        this(new C45037j());
        AppMethodBeat.m2504i(94746);
        AppMethodBeat.m2505o(94746);
    }

    private C25532c(C45037j c45037j) {
        this(c45037j, (byte) 0);
    }

    private C25532c(C45037j c45037j, byte b) {
        this(c45037j, 0);
    }

    private C25532c(C45037j c45037j, char c) {
        this.aMB = c45037j;
        this.aMC = 15000000;
        this.aMD = 30000000;
        this.aME = 2500000;
        this.aMF = 5000000;
        this.aMG = null;
    }

    /* renamed from: pL */
    public final void mo19230pL() {
        AppMethodBeat.m2504i(94747);
        reset(false);
        AppMethodBeat.m2505o(94747);
    }

    /* renamed from: a */
    public final void mo19227a(C32069r[] c32069rArr, C37259g c37259g) {
        int i = 0;
        AppMethodBeat.m2504i(94748);
        this.aMH = 0;
        while (i < c32069rArr.length) {
            if (c37259g.bpE[i] != null) {
                this.aMH += C17675v.m27571eT(c32069rArr[i].getTrackType());
            }
            i++;
        }
        this.aMB.mo72547eJ(this.aMH);
        AppMethodBeat.m2505o(94748);
    }

    public final void onStopped() {
        AppMethodBeat.m2504i(94749);
        reset(true);
        AppMethodBeat.m2505o(94749);
    }

    /* renamed from: pM */
    public final void mo19231pM() {
        AppMethodBeat.m2504i(94750);
        reset(true);
        AppMethodBeat.m2505o(94750);
    }

    /* renamed from: pN */
    public final C32053b mo19232pN() {
        return this.aMB;
    }

    /* renamed from: c */
    public final boolean mo19228c(long j, boolean z) {
        long j2 = z ? this.aMF : this.aME;
        return j2 <= 0 || j >= j2;
    }

    private void reset(boolean z) {
        AppMethodBeat.m2504i(94752);
        this.aMH = 0;
        if (this.aMG != null && this.aMI) {
            this.aMG.mo42799tP();
        }
        this.aMI = false;
        if (z) {
            this.aMB.reset();
        }
        AppMethodBeat.m2505o(94752);
    }

    /* renamed from: y */
    public final boolean mo19233y(long j) {
        boolean z = false;
        AppMethodBeat.m2504i(94751);
        boolean z2 = j > this.aMD ? false : j < this.aMC ? true : true;
        boolean z3 = this.aMB.mo72549tp() >= this.aMH;
        boolean z4 = this.aMI;
        if (z2 || (z2 && this.aMI && !z3)) {
            z = true;
        }
        this.aMI = z;
        if (!(this.aMG == null || this.aMI == z4)) {
            if (this.aMI) {
                C25543o c25543o = this.aMG;
                synchronized (c25543o.lock) {
                    try {
                        c25543o.brx.add(Integer.valueOf(0));
                        c25543o.bry = Math.max(c25543o.bry, 0);
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(94751);
                        }
                    }
                }
            } else {
                this.aMG.mo42799tP();
            }
        }
        z2 = this.aMI;
        AppMethodBeat.m2505o(94751);
        return z2;
    }
}
