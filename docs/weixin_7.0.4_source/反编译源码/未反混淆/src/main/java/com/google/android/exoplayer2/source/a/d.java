package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.i.a;

public abstract class d extends a {
    public final int bih;

    public d(f fVar, i iVar, Format format, int i, Object obj, long j, long j2, int i2) {
        super(fVar, iVar, 1, format, i, obj, j, j2);
        a.checkNotNull(format);
        this.bih = i2;
    }
}
