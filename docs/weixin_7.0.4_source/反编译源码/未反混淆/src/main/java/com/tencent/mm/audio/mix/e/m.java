package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m extends f {
    /* Access modifiers changed, original: protected|final */
    public final byte[] D(int i, int i2, int i3) {
        AppMethodBeat.i(137132);
        for (int i4 = 0; i4 < i2; i4++) {
            float f = 1.0f;
            for (int i5 = 0; i5 < i; i5++) {
                if (i5 == 0) {
                    f = (float) this.cmZ[i5][i4];
                } else {
                    float f2 = (float) this.cmZ[i5][i4];
                    if (f < 0.0f && f2 < 0.0f) {
                        f = (f + f2) - ((f * f2) / ((float) this.MIN_VALUE));
                    } else if (f <= 0.0f || f2 <= 0.0f) {
                        f += f2;
                    } else {
                        f = (f + f2) - ((f * f2) / ((float) this.MAX_VALUE));
                    }
                }
            }
            this.cnc[i4] = gz((int) f);
        }
        byte[] bM = bM(i3, i2);
        AppMethodBeat.o(137132);
        return bM;
    }
}
