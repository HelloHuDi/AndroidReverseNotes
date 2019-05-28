package com.google.android.exoplayer2.source.p1520a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p110h.C0867f;
import com.google.android.exoplayer2.p110h.C17665i;
import com.google.android.exoplayer2.p111i.C45039a;

/* renamed from: com.google.android.exoplayer2.source.a.d */
public abstract class C45046d extends C41622a {
    public final int bih;

    public C45046d(C0867f c0867f, C17665i c17665i, Format format, int i, Object obj, long j, long j2, int i2) {
        super(c0867f, c17665i, 1, format, i, obj, j, j2);
        C45039a.checkNotNull(format);
        this.bih = i2;
    }
}
