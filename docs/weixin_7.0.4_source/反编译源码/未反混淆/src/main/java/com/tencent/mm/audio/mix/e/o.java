package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o extends f {
    /* Access modifiers changed, original: protected|final */
    public final byte[] D(int i, int i2, int i3) {
        AppMethodBeat.i(137134);
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < i; i6++) {
                i5 += this.cmZ[i6][i4];
            }
            this.cnc[i4] = gz(i5);
        }
        byte[] bM = bM(i3, i2);
        AppMethodBeat.o(137134);
        return bM;
    }
}
