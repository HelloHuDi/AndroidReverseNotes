package com.tencent.p177mm.audio.mix.p196e;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.audio.mix.e.m */
public final class C46875m extends C45169f {
    /* Access modifiers changed, original: protected|final */
    /* renamed from: D */
    public final byte[] mo4603D(int i, int i2, int i3) {
        AppMethodBeat.m2504i(137132);
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
            this.cnc[i4] = mo73138gz((int) f);
        }
        byte[] bM = mo73137bM(i3, i2);
        AppMethodBeat.m2505o(137132);
        return bM;
    }
}
