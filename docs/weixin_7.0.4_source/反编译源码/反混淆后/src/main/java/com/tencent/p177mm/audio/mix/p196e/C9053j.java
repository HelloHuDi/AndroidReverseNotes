package com.tencent.p177mm.audio.mix.p196e;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.audio.mix.e.j */
public final class C9053j extends C45169f {
    private float cnh = 1.0f;
    private boolean cni = true;

    /* Access modifiers changed, original: protected|final */
    /* renamed from: D */
    public final byte[] mo4603D(int i, int i2, int i3) {
        AppMethodBeat.m2504i(137128);
        this.cni = true;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5;
            int i6 = 0;
            for (int i7 = 0; i7 < i; i7++) {
                i6 += this.cmZ[i7][i4];
            }
            boolean z = this.cni;
            while (true) {
                i5 = (int) (this.cnh * ((float) i6));
                if (i5 <= this.MAX_VALUE) {
                    if (i5 >= this.MIN_VALUE) {
                        break;
                    }
                    this.cnh = ((float) this.MIN_VALUE) / ((float) i6);
                    if (this.cnh < 1.0f) {
                        this.cnh -= (1.0f - this.cnh) / 16.0f;
                    }
                    z = false;
                    i6 = i5;
                } else {
                    this.cnh = ((float) this.MAX_VALUE) / ((float) i6);
                    if (this.cnh < 1.0f) {
                        this.cnh -= (1.0f - this.cnh) / 16.0f;
                    }
                    z = false;
                    i6 = i5;
                }
            }
            if (z && i6 < this.MAX_VALUE && i6 > this.MIN_VALUE) {
                if (this.cnh < 1.0f) {
                    this.cnh += (1.0f - this.cnh) / 16.0f;
                } else {
                    this.cnh = 1.0f;
                }
                this.cni = false;
            }
            if (i4 == i2 / 2) {
                this.cni = true;
            }
            this.cnc[i4] = mo73138gz(i5);
        }
        byte[] bM = mo73137bM(i3, i2);
        AppMethodBeat.m2505o(137128);
        return bM;
    }
}
