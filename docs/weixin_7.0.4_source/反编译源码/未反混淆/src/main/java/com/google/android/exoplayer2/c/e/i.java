package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i {
    private final int baE;
    int baF;
    int baG;
    private final byte[] data;

    public i(byte[] bArr) {
        AppMethodBeat.i(95051);
        this.data = bArr;
        this.baE = bArr.length;
        AppMethodBeat.o(95051);
    }

    public final boolean rl() {
        AppMethodBeat.i(95052);
        boolean z = (((this.data[this.baF] & 255) >> this.baG) & 1) == 1;
        ee(1);
        AppMethodBeat.o(95052);
        return z;
    }

    public final int ed(int i) {
        AppMethodBeat.i(95053);
        int i2 = this.baF;
        int min = Math.min(i, 8 - this.baG);
        int i3 = i2 + 1;
        i2 = ((this.data[i2] & 255) >> this.baG) & (255 >> (8 - min));
        while (min < i) {
            i2 |= (this.data[i3] & 255) << min;
            min += 8;
            i3++;
        }
        i2 &= -1 >>> (32 - i);
        ee(i);
        AppMethodBeat.o(95053);
        return i2;
    }

    public final void ee(int i) {
        AppMethodBeat.i(95054);
        int i2 = i / 8;
        this.baF += i2;
        this.baG = (i - (i2 * 8)) + this.baG;
        if (this.baG > 7) {
            this.baF++;
            this.baG -= 8;
        }
        rm();
        AppMethodBeat.o(95054);
    }

    private void rm() {
        AppMethodBeat.i(95055);
        boolean z = this.baF >= 0 && (this.baF < this.baE || (this.baF == this.baE && this.baG == 0));
        a.checkState(z);
        AppMethodBeat.o(95055);
    }
}
