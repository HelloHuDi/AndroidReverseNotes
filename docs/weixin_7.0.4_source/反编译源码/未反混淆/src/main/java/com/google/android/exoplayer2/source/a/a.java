package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.h.s.c;

public abstract class a implements c {
    protected final f aSF;
    public final i bib;
    public final Format bic;
    public final int bid;
    public final Object bie;
    public final long bif;
    public final long big;
    public final int type;

    public abstract long ss();

    public a(f fVar, i iVar, int i, Format format, int i2, Object obj, long j, long j2) {
        this.aSF = (f) com.google.android.exoplayer2.i.a.checkNotNull(fVar);
        this.bib = (i) com.google.android.exoplayer2.i.a.checkNotNull(iVar);
        this.type = i;
        this.bic = format;
        this.bid = i2;
        this.bie = obj;
        this.bif = j;
        this.big = j2;
    }
}
