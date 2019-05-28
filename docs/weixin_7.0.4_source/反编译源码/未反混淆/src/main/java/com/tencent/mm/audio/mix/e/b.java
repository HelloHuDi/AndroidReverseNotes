package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b extends f {
    /* Access modifiers changed, original: protected|final */
    public final byte[] D(int i, int i2, int i3) {
        AppMethodBeat.i(137086);
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = 1;
            for (int i6 = 0; i6 < i; i6++) {
                if (i6 == 0) {
                    i5 = this.cmZ[i6][i4];
                } else {
                    i5 = (int) (((double) (i5 + this.cmZ[i6][i4])) / Math.sqrt(2.0d));
                }
            }
            this.cnc[i4] = gz(i5);
        }
        byte[] bM = bM(i3, i2);
        AppMethodBeat.o(137086);
        return bM;
    }
}
