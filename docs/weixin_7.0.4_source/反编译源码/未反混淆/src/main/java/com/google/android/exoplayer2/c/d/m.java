package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class m {
    public final int[] aSB;
    public final int aXU;
    public final int[] aXW;
    public final long[] aZO;
    public final long[] offsets;
    public final int sampleCount;

    public m(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(95016);
        a.checkArgument(iArr.length == jArr2.length);
        if (jArr.length == jArr2.length) {
            z = true;
        } else {
            z = false;
        }
        a.checkArgument(z);
        if (iArr2.length != jArr2.length) {
            z2 = false;
        }
        a.checkArgument(z2);
        this.offsets = jArr;
        this.aSB = iArr;
        this.aXU = i;
        this.aZO = jArr2;
        this.aXW = iArr2;
        this.sampleCount = jArr.length;
        AppMethodBeat.o(95016);
    }

    public final int Q(long j) {
        AppMethodBeat.i(95017);
        for (int a = v.a(this.aZO, j, false); a >= 0; a--) {
            if ((this.aXW[a] & 1) != 0) {
                AppMethodBeat.o(95017);
                return a;
            }
        }
        AppMethodBeat.o(95017);
        return -1;
    }

    public final int R(long j) {
        AppMethodBeat.i(95018);
        for (int a = v.a(this.aZO, j, true, false); a < this.aZO.length; a++) {
            if ((this.aXW[a] & 1) != 0) {
                AppMethodBeat.o(95018);
                return a;
            }
        }
        AppMethodBeat.o(95018);
        return -1;
    }
}
