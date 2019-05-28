package com.tencent.p177mm.audio.mix.p196e;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.audio.mix.e.b */
public final class C9051b extends C45169f {
    /* Access modifiers changed, original: protected|final */
    /* renamed from: D */
    public final byte[] mo4603D(int i, int i2, int i3) {
        AppMethodBeat.m2504i(137086);
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = 1;
            for (int i6 = 0; i6 < i; i6++) {
                if (i6 == 0) {
                    i5 = this.cmZ[i6][i4];
                } else {
                    i5 = (int) (((double) (i5 + this.cmZ[i6][i4])) / Math.sqrt(2.0d));
                }
            }
            this.cnc[i4] = mo73138gz(i5);
        }
        byte[] bM = mo73137bM(i3, i2);
        AppMethodBeat.m2505o(137086);
        return bM;
    }
}
