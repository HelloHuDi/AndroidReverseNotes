package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.Format;

public final class j {
    public final Format aOv;
    public final long aOz;
    public final int aTz;
    public final long aZm;
    public final long aZn;
    public final int aZo;
    public final long[] aZp;
    public final long[] aZq;
    private final k[] aZr;
    public final int id;
    public final int type;

    public j(int i, int i2, long j, long j2, long j3, Format format, int i3, k[] kVarArr, int i4, long[] jArr, long[] jArr2) {
        this.id = i;
        this.type = i2;
        this.aZm = j;
        this.aZn = j2;
        this.aOz = j3;
        this.aOv = format;
        this.aZo = i3;
        this.aZr = kVarArr;
        this.aTz = i4;
        this.aZp = jArr;
        this.aZq = jArr2;
    }

    public final k dZ(int i) {
        return this.aZr == null ? null : this.aZr[i];
    }
}
