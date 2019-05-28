package com.google.android.exoplayer2.p101c.p795a;

import com.google.android.exoplayer2.C37269o;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p111i.C32065l;

/* renamed from: com.google.android.exoplayer2.c.a.d */
abstract class C41592d {
    protected final C32041m aTw;

    /* renamed from: com.google.android.exoplayer2.c.a.d$a */
    public static final class C8644a extends C37269o {
        public C8644a(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    public abstract void mo32313a(C32065l c32065l, long j);

    /* renamed from: a */
    public abstract boolean mo32314a(C32065l c32065l);

    protected C41592d(C32041m c32041m) {
        this.aTw = c32041m;
    }

    /* renamed from: b */
    public final void mo66728b(C32065l c32065l, long j) {
        if (mo32314a(c32065l)) {
            mo32313a(c32065l, j);
        }
    }
}
