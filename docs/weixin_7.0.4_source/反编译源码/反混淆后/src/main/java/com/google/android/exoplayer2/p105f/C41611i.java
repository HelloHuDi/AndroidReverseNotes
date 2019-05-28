package com.google.android.exoplayer2.p105f;

import com.google.android.exoplayer2.p100b.C32023f;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.f.i */
public abstract class C41611i extends C32023f implements C17659d {
    private long aOr;
    private C17659d ble;

    public abstract void release();

    /* renamed from: a */
    public final void mo66740a(long j, C17659d c17659d, long j2) {
        this.aSk = j;
        this.ble = c17659d;
        if (j2 == Long.MAX_VALUE) {
            j2 = this.aSk;
        }
        this.aOr = j2;
    }

    /* renamed from: sG */
    public final int mo2578sG() {
        return this.ble.mo2578sG();
    }

    /* renamed from: et */
    public final long mo2577et(int i) {
        return this.ble.mo2577et(i) + this.aOr;
    }

    /* renamed from: aj */
    public final int mo2575aj(long j) {
        return this.ble.mo2575aj(j - this.aOr);
    }

    /* renamed from: ak */
    public final List<C32044a> mo2576ak(long j) {
        return this.ble.mo2576ak(j - this.aOr);
    }

    public final void clear() {
        super.clear();
        this.ble = null;
    }
}
