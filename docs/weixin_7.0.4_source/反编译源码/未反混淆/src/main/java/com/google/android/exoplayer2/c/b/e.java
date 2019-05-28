package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e {
    final l aTj = new l(8);
    int aVo;

    public e() {
        AppMethodBeat.i(94915);
        AppMethodBeat.o(94915);
    }

    /* Access modifiers changed, original: final */
    public final long d(f fVar) {
        int i = 0;
        AppMethodBeat.i(94916);
        fVar.b(this.aTj.data, 0, 1);
        int i2 = this.aTj.data[0] & 255;
        if (i2 == 0) {
            AppMethodBeat.o(94916);
            return Long.MIN_VALUE;
        }
        int i3 = 0;
        int i4 = 128;
        while ((i2 & i4) == 0) {
            i4 >>= 1;
            i3++;
        }
        int i5 = (i4 ^ -1) & i2;
        fVar.b(this.aTj.data, 1, i3);
        while (i < i3) {
            i5 = (i5 << 8) + (this.aTj.data[i + 1] & 255);
            i++;
        }
        this.aVo += i3 + 1;
        long j = (long) i5;
        AppMethodBeat.o(94916);
        return j;
    }
}
