package com.bumptech.glide.c.d.b;

import com.bumptech.glide.c.b.u;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b implements u<byte[]> {
    private final byte[] wR;

    public b(byte[] bArr) {
        AppMethodBeat.i(92283);
        this.wR = (byte[]) i.d(bArr, "Argument must not be null");
        AppMethodBeat.o(92283);
    }

    public final Class<byte[]> mK() {
        return byte[].class;
    }

    public final int getSize() {
        return this.wR.length;
    }

    public final void recycle() {
    }

    public final /* bridge */ /* synthetic */ Object get() {
        return this.wR;
    }
}
