package com.google.android.exoplayer2;

import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.source.l;

public abstract class a implements r, s {
    private final int aMr;
    protected t aMs;
    protected l aMt;
    protected long aMu;
    protected boolean aMv = true;
    protected boolean aMw;
    protected int index;
    protected int state;

    public a(int i) {
        this.aMr = i;
    }

    public final int getTrackType() {
        return this.aMr;
    }

    public final s pC() {
        return this;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public h pD() {
        return null;
    }

    public final int getState() {
        return this.state;
    }

    public final void a(t tVar, Format[] formatArr, l lVar, long j, boolean z, long j2) {
        com.google.android.exoplayer2.i.a.checkState(this.state == 0);
        this.aMs = tVar;
        this.state = 1;
        aD(z);
        a(formatArr, lVar, j2);
        b(j, z);
    }

    public final void start() {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        com.google.android.exoplayer2.i.a.checkState(z);
        this.state = 2;
        onStarted();
    }

    public final void a(Format[] formatArr, l lVar, long j) {
        com.google.android.exoplayer2.i.a.checkState(!this.aMw);
        this.aMt = lVar;
        this.aMv = false;
        this.aMu = j;
        a(formatArr, j);
    }

    public final l pE() {
        return this.aMt;
    }

    public final boolean pF() {
        return this.aMv;
    }

    public final void pG() {
        this.aMw = true;
    }

    public final boolean pH() {
        return this.aMw;
    }

    public final void pI() {
        this.aMt.rW();
    }

    public final void v(long j) {
        this.aMw = false;
        this.aMv = false;
        b(j, false);
    }

    public final void stop() {
        com.google.android.exoplayer2.i.a.checkState(this.state == 2);
        this.state = 1;
        onStopped();
    }

    public final void disable() {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        com.google.android.exoplayer2.i.a.checkState(z);
        this.state = 0;
        this.aMt = null;
        this.aMw = false;
        pK();
    }

    public int pJ() {
        return 0;
    }

    public void c(int i, Object obj) {
    }

    /* Access modifiers changed, original: protected */
    public void aD(boolean z) {
    }

    /* Access modifiers changed, original: protected */
    public void a(Format[] formatArr, long j) {
    }

    /* Access modifiers changed, original: protected */
    public void b(long j, boolean z) {
    }

    /* Access modifiers changed, original: protected */
    public void onStarted() {
    }

    /* Access modifiers changed, original: protected */
    public void onStopped() {
    }

    /* Access modifiers changed, original: protected */
    public void pK() {
    }

    /* Access modifiers changed, original: protected|final */
    public final int a(k kVar, e eVar, boolean z) {
        int b = this.aMt.b(kVar, eVar, z);
        if (b == -4) {
            if (eVar.qG()) {
                this.aMv = true;
                if (this.aMw) {
                    return -4;
                }
                return -3;
            }
            eVar.aSk += this.aMu;
        } else if (b == -5) {
            Format format = kVar.aOv;
            if (format.aOr != Long.MAX_VALUE) {
                kVar.aOv = format.E(format.aOr + this.aMu);
            }
        }
        return b;
    }
}
