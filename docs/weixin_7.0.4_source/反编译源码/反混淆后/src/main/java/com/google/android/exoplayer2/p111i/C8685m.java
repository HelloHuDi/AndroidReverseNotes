package com.google.android.exoplayer2.p111i;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.i.m */
public final class C8685m {
    private int baE;
    private int baF;
    private int baG;
    private byte[] data;

    public C8685m(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(95920);
        mo19218l(bArr, i, i2);
        AppMethodBeat.m2505o(95920);
    }

    /* renamed from: l */
    public final void mo19218l(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(95921);
        this.data = bArr;
        this.baF = i;
        this.baE = i2;
        this.baG = 0;
        m15417rm();
        AppMethodBeat.m2505o(95921);
    }

    /* renamed from: tz */
    public final void mo19223tz() {
        AppMethodBeat.m2504i(95922);
        int i = this.baG + 1;
        this.baG = i;
        if (i == 8) {
            this.baG = 0;
            this.baF = (m15416eP(this.baF + 1) ? 2 : 1) + this.baF;
        }
        m15417rm();
        AppMethodBeat.m2505o(95922);
    }

    /* renamed from: ee */
    public final void mo19217ee(int i) {
        AppMethodBeat.m2504i(95923);
        int i2 = this.baF;
        int i3 = i / 8;
        this.baF += i3;
        this.baG = (i - (i3 * 8)) + this.baG;
        if (this.baG > 7) {
            this.baF++;
            this.baG -= 8;
        }
        while (true) {
            i2++;
            if (i2 > this.baF) {
                m15417rm();
                AppMethodBeat.m2505o(95923);
                return;
            } else if (m15416eP(i2)) {
                this.baF++;
                i2 += 2;
            }
        }
    }

    /* renamed from: eO */
    public final boolean mo19215eO(int i) {
        AppMethodBeat.m2504i(95924);
        int i2 = this.baF;
        int i3 = i / 8;
        int i4 = this.baF + i3;
        i3 = (this.baG + i) - (i3 * 8);
        if (i3 > 7) {
            i4++;
            i3 -= 8;
        }
        i2++;
        while (i2 <= i4 && i4 < this.baE) {
            if (m15416eP(i2)) {
                i4++;
                i2 += 2;
            }
            i2++;
        }
        if (i4 < this.baE || (i4 == this.baE && r1 == 0)) {
            AppMethodBeat.m2505o(95924);
            return true;
        }
        AppMethodBeat.m2505o(95924);
        return false;
    }

    /* renamed from: rl */
    public final boolean mo19219rl() {
        AppMethodBeat.m2504i(95925);
        boolean z = (this.data[this.baF] & (128 >> this.baG)) != 0;
        mo19223tz();
        AppMethodBeat.m2505o(95925);
        return z;
    }

    /* renamed from: ed */
    public final int mo19216ed(int i) {
        int i2 = 2;
        AppMethodBeat.m2504i(95926);
        this.baG += i;
        int i3 = 0;
        while (this.baG > 8) {
            this.baG -= 8;
            i3 |= (this.data[this.baF] & 255) << this.baG;
            this.baF = (m15416eP(this.baF + 1) ? 2 : 1) + this.baF;
        }
        i3 = (i3 | ((this.data[this.baF] & 255) >> (8 - this.baG))) & (-1 >>> (32 - i));
        if (this.baG == 8) {
            this.baG = 0;
            int i4 = this.baF;
            if (!m15416eP(this.baF + 1)) {
                i2 = 1;
            }
            this.baF = i4 + i2;
        }
        m15417rm();
        AppMethodBeat.m2505o(95926);
        return i3;
    }

    /* renamed from: tM */
    public final boolean mo19220tM() {
        boolean z;
        AppMethodBeat.m2504i(95927);
        int i = this.baF;
        int i2 = this.baG;
        int i3 = 0;
        while (this.baF < this.baE && !mo19219rl()) {
            i3++;
        }
        if (this.baF == this.baE) {
            z = true;
        } else {
            z = false;
        }
        this.baF = i;
        this.baG = i2;
        if (z || !mo19215eO((i3 * 2) + 1)) {
            AppMethodBeat.m2505o(95927);
            return false;
        }
        AppMethodBeat.m2505o(95927);
        return true;
    }

    /* renamed from: tN */
    public final int mo19221tN() {
        AppMethodBeat.m2504i(95928);
        int tO = mo19222tO();
        int i = (tO % 2 == 0 ? -1 : 1) * ((tO + 1) / 2);
        AppMethodBeat.m2505o(95928);
        return i;
    }

    /* renamed from: tO */
    public final int mo19222tO() {
        int i = 0;
        AppMethodBeat.m2504i(95929);
        int i2 = 0;
        while (!mo19219rl()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = mo19216ed(i2);
        }
        i2 = i3 + i;
        AppMethodBeat.m2505o(95929);
        return i2;
    }

    /* renamed from: eP */
    private boolean m15416eP(int i) {
        return 2 <= i && i < this.baE && this.data[i] == (byte) 3 && this.data[i - 2] == (byte) 0 && this.data[i - 1] == (byte) 0;
    }

    /* renamed from: rm */
    private void m15417rm() {
        AppMethodBeat.m2504i(95930);
        boolean z = this.baF >= 0 && (this.baF < this.baE || (this.baF == this.baE && this.baG == 0));
        C45039a.checkState(z);
        AppMethodBeat.m2505o(95930);
    }
}
