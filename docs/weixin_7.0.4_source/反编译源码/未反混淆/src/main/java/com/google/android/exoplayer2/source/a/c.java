package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.i.v;
import java.util.Arrays;

public abstract class c extends a {
    private volatile boolean bhf;
    public byte[] data;
    private int limit;

    public abstract void f(byte[] bArr, int i);

    public c(f fVar, i iVar, Format format, int i, Object obj, byte[] bArr) {
        super(fVar, iVar, 3, format, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.data = bArr;
    }

    public final long ss() {
        return (long) this.limit;
    }

    public final void se() {
        this.bhf = true;
    }

    public final boolean sf() {
        return this.bhf;
    }

    public final void sg() {
        int i = 0;
        try {
            this.aSF.a(this.bib);
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
                f(this.data, this.limit);
            }
            v.a(this.aSF);
        } catch (Throwable th) {
            v.a(this.aSF);
        }
    }
}
