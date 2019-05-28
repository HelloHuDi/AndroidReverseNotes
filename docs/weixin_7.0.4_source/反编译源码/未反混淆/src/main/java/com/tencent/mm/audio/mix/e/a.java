package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends f {
    /* Access modifiers changed, original: protected|final */
    public final byte[] D(int i, int i2, int i3) {
        AppMethodBeat.i(137085);
        for (int i4 = 0; i4 < i2; i4++) {
            short s;
            int i5 = 0;
            float f = 0.0f;
            float f2 = 0.0f;
            while (i5 < i) {
                f = (float) (((double) f) + (Math.pow((double) this.cmZ[i5][i4], 2.0d) * ((double) Math.signum((float) this.cmZ[i5][i4]))));
                i5++;
                f2 = ((float) Math.abs(this.cmZ[i5][i4])) + f2;
            }
            int i6 = f2 == 0.0f ? 0 : (int) (f / f2);
            short[] sArr = this.cnc;
            if (f2 == 0.0f) {
                s = (short) 0;
            } else {
                s = gz(i6);
            }
            sArr[i4] = s;
        }
        byte[] bM = bM(i3, i2);
        AppMethodBeat.o(137085);
        return bM;
    }
}
