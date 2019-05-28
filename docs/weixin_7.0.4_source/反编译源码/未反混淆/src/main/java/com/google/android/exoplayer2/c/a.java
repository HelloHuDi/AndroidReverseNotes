package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements l {
    private final long aOz;
    public final int[] aSB;
    public final long[] aSC;
    public final long[] aSD;
    public final int length;
    public final long[] offsets;

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        AppMethodBeat.i(94840);
        this.aSB = iArr;
        this.offsets = jArr;
        this.aSC = jArr2;
        this.aSD = jArr3;
        this.length = iArr.length;
        if (this.length > 0) {
            this.aOz = jArr2[this.length - 1] + jArr3[this.length - 1];
            AppMethodBeat.o(94840);
            return;
        }
        this.aOz = 0;
        AppMethodBeat.o(94840);
    }

    public final boolean qX() {
        return true;
    }

    public final long getDurationUs() {
        return this.aOz;
    }

    public final long M(long j) {
        AppMethodBeat.i(94841);
        long j2 = this.offsets[v.a(this.aSD, j, true)];
        AppMethodBeat.o(94841);
        return j2;
    }
}
