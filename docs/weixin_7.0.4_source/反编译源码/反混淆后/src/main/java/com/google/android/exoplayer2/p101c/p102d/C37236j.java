package com.google.android.exoplayer2.p101c.p102d;

import com.google.android.exoplayer2.Format;

/* renamed from: com.google.android.exoplayer2.c.d.j */
public final class C37236j {
    public final Format aOv;
    public final long aOz;
    public final int aTz;
    public final long aZm;
    public final long aZn;
    public final int aZo;
    public final long[] aZp;
    public final long[] aZq;
    private final C25518k[] aZr;
    /* renamed from: id */
    public final int f15847id;
    public final int type;

    public C37236j(int i, int i2, long j, long j2, long j3, Format format, int i3, C25518k[] c25518kArr, int i4, long[] jArr, long[] jArr2) {
        this.f15847id = i;
        this.type = i2;
        this.aZm = j;
        this.aZn = j2;
        this.aOz = j3;
        this.aOv = format;
        this.aZo = i3;
        this.aZr = c25518kArr;
        this.aTz = i4;
        this.aZp = jArr;
        this.aZq = jArr2;
    }

    /* renamed from: dZ */
    public final C25518k mo59490dZ(int i) {
        return this.aZr == null ? null : this.aZr[i];
    }
}
