package com.google.android.exoplayer2.source.p1520a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p110h.C0867f;
import com.google.android.exoplayer2.p110h.C17665i;
import com.google.android.exoplayer2.p110h.C41613s.C32059c;
import com.google.android.exoplayer2.p111i.C45039a;

/* renamed from: com.google.android.exoplayer2.source.a.a */
public abstract class C41622a implements C32059c {
    protected final C0867f aSF;
    public final C17665i bib;
    public final Format bic;
    public final int bid;
    public final Object bie;
    public final long bif;
    public final long big;
    public final int type;

    /* renamed from: ss */
    public abstract long mo42818ss();

    public C41622a(C0867f c0867f, C17665i c17665i, int i, Format format, int i2, Object obj, long j, long j2) {
        this.aSF = (C0867f) C45039a.checkNotNull(c0867f);
        this.bib = (C17665i) C45039a.checkNotNull(c17665i);
        this.type = i;
        this.bic = format;
        this.bid = i2;
        this.bie = obj;
        this.bif = j;
        this.big = j2;
    }
}
