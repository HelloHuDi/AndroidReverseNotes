package com.tencent.p177mm.audio.mix.p196e;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.audio.mix.e.n */
public final class C41779n extends C45169f {
    /* Access modifiers changed, original: protected|final */
    /* renamed from: D */
    public final byte[] mo4603D(int i, int i2, int i3) {
        AppMethodBeat.m2504i(137133);
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < i; i6++) {
                i5 += this.cmZ[i6][i4];
            }
            this.cnc[i4] = (short) (i5 / i);
        }
        byte[] bM = mo73137bM(i3, i2);
        AppMethodBeat.m2505o(137133);
        return bM;
    }
}
