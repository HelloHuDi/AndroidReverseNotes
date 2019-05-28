package com.google.android.exoplayer2.source.p1520a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p110h.C0867f;
import com.google.android.exoplayer2.p110h.C17665i;
import com.google.android.exoplayer2.p111i.C17675v;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.source.a.c */
public abstract class C37270c extends C41622a {
    private volatile boolean bhf;
    public byte[] data;
    private int limit;

    /* renamed from: f */
    public abstract void mo2610f(byte[] bArr, int i);

    public C37270c(C0867f c0867f, C17665i c17665i, Format format, int i, Object obj, byte[] bArr) {
        super(c0867f, c17665i, 3, format, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.data = bArr;
    }

    /* renamed from: ss */
    public final long mo42818ss() {
        return (long) this.limit;
    }

    /* renamed from: se */
    public final void mo19287se() {
        this.bhf = true;
    }

    /* renamed from: sf */
    public final boolean mo19288sf() {
        return this.bhf;
    }

    /* renamed from: sg */
    public final void mo19289sg() {
        int i = 0;
        try {
            this.aSF.mo2583a(this.bib);
            this.limit = 0;
            while (i != -1 && !this.bhf) {
                if (this.data == null) {
                    this.data = new byte[16384];
                } else if (this.data.length < this.limit + 16384) {
                    this.data = Arrays.copyOf(this.data, this.data.length + 16384);
                }
                i = this.aSF.read(this.data, this.limit, 16384);
                if (i != -1) {
                    this.limit += i;
                }
            }
            if (!this.bhf) {
                mo2610f(this.data, this.limit);
            }
            C17675v.m27555a(this.aSF);
        } catch (Throwable th) {
            C17675v.m27555a(this.aSF);
        }
    }
}
