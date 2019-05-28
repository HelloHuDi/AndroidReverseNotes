package com.google.android.exoplayer2;

import com.google.android.exoplayer2.p100b.C32022e;
import com.google.android.exoplayer2.p111i.C32063h;
import com.google.android.exoplayer2.p111i.C45039a;
import com.google.android.exoplayer2.source.C17688l;

/* renamed from: com.google.android.exoplayer2.a */
public abstract class C41591a implements C32069r, C8703s {
    private final int aMr;
    protected C0882t aMs;
    protected C17688l aMt;
    protected long aMu;
    protected boolean aMv = true;
    protected boolean aMw;
    protected int index;
    protected int state;

    public C41591a(int i) {
        this.aMr = i;
    }

    public final int getTrackType() {
        return this.aMr;
    }

    /* renamed from: pC */
    public final C8703s mo52404pC() {
        return this;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    /* renamed from: pD */
    public C32063h mo52405pD() {
        return null;
    }

    public final int getState() {
        return this.state;
    }

    /* renamed from: a */
    public final void mo52399a(C0882t c0882t, Format[] formatArr, C17688l c17688l, long j, boolean z, long j2) {
        C45039a.checkState(this.state == 0);
        this.aMs = c0882t;
        this.state = 1;
        mo59462aD(z);
        mo52400a(formatArr, c17688l, j2);
        mo32349b(j, z);
    }

    public final void start() {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        C45039a.checkState(z);
        this.state = 2;
        onStarted();
    }

    /* renamed from: a */
    public final void mo52400a(Format[] formatArr, C17688l c17688l, long j) {
        C45039a.checkState(!this.aMw);
        this.aMt = c17688l;
        this.aMv = false;
        this.aMu = j;
        mo32348a(formatArr, j);
    }

    /* renamed from: pE */
    public final C17688l mo52406pE() {
        return this.aMt;
    }

    /* renamed from: pF */
    public final boolean mo52407pF() {
        return this.aMv;
    }

    /* renamed from: pG */
    public final void mo52408pG() {
        this.aMw = true;
    }

    /* renamed from: pH */
    public final boolean mo52409pH() {
        return this.aMw;
    }

    /* renamed from: pI */
    public final void mo52410pI() {
        this.aMt.mo19295rW();
    }

    /* renamed from: v */
    public final void mo52414v(long j) {
        this.aMw = false;
        this.aMv = false;
        mo32349b(j, false);
    }

    public final void stop() {
        C45039a.checkState(this.state == 2);
        this.state = 1;
        onStopped();
    }

    public final void disable() {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        C45039a.checkState(z);
        this.state = 0;
        this.aMt = null;
        this.aMw = false;
        mo32353pK();
    }

    /* renamed from: pJ */
    public int mo19258pJ() {
        return 0;
    }

    /* renamed from: c */
    public void mo59463c(int i, Object obj) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: aD */
    public void mo59462aD(boolean z) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo32348a(Format[] formatArr, long j) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo32349b(long j, boolean z) {
    }

    /* Access modifiers changed, original: protected */
    public void onStarted() {
    }

    /* Access modifiers changed, original: protected */
    public void onStopped() {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: pK */
    public void mo32353pK() {
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final int mo66727a(C8692k c8692k, C32022e c32022e, boolean z) {
        int b = this.aMt.mo19293b(c8692k, c32022e, z);
        if (b == -4) {
            if (c32022e.mo42774qG()) {
                this.aMv = true;
                if (this.aMw) {
                    return -4;
                }
                return -3;
            }
            c32022e.aSk += this.aMu;
        } else if (b == -5) {
            Format format = c8692k.aOv;
            if (format.aOr != Long.MAX_VALUE) {
                c8692k.aOv = format.mo19111E(format.aOr + this.aMu);
            }
        }
        return b;
    }
}
