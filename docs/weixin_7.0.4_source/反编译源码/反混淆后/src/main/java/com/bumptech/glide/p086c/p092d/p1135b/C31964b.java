package com.bumptech.glide.p086c.p092d.p1135b;

import com.bumptech.glide.p086c.p088b.C17526u;
import com.bumptech.glide.p095h.C8561i;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.c.d.b.b */
public final class C31964b implements C17526u<byte[]> {
    /* renamed from: wR */
    private final byte[] f14671wR;

    public C31964b(byte[] bArr) {
        AppMethodBeat.m2504i(92283);
        this.f14671wR = (byte[]) C8561i.m15217d(bArr, "Argument must not be null");
        AppMethodBeat.m2505o(92283);
    }

    /* renamed from: mK */
    public final Class<byte[]> mo2232mK() {
        return byte[].class;
    }

    public final int getSize() {
        return this.f14671wR.length;
    }

    public final void recycle() {
    }

    public final /* bridge */ /* synthetic */ Object get() {
        return this.f14671wR;
    }
}
