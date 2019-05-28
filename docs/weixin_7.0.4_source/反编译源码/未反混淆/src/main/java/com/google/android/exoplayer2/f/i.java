package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.b.f;
import java.util.List;

public abstract class i extends f implements d {
    private long aOr;
    private d ble;

    public abstract void release();

    public final void a(long j, d dVar, long j2) {
        this.aSk = j;
        this.ble = dVar;
        if (j2 == Long.MAX_VALUE) {
            j2 = this.aSk;
        }
        this.aOr = j2;
    }

    public final int sG() {
        return this.ble.sG();
    }

    public final long et(int i) {
        return this.ble.et(i) + this.aOr;
    }

    public final int aj(long j) {
        return this.ble.aj(j - this.aOr);
    }

    public final List<a> ak(long j) {
        return this.ble.ak(j - this.aOr);
    }

    public final void clear() {
        super.clear();
        this.ble = null;
    }
}
