package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m {
    private int baE;
    private int baF;
    private int baG;
    private byte[] data;

    public m(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(95920);
        l(bArr, i, i2);
        AppMethodBeat.o(95920);
    }

    public final void l(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(95921);
        this.data = bArr;
        this.baF = i;
        this.baE = i2;
        this.baG = 0;
        rm();
        AppMethodBeat.o(95921);
    }

    public final void tz() {
        AppMethodBeat.i(95922);
        int i = this.baG + 1;
        this.baG = i;
        if (i == 8) {
            this.baG = 0;
            this.baF = (eP(this.baF + 1) ? 2 : 1) + this.baF;
        }
        rm();
        AppMethodBeat.o(95922);
    }

    public final void ee(int i) {
        AppMethodBeat.i(95923);
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
                rm();
                AppMethodBeat.o(95923);
                return;
            } else if (eP(i2)) {
                this.baF++;
                i2 += 2;
            }
        }
    }

    public final boolean eO(int i) {
        AppMethodBeat.i(95924);
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
            if (eP(i2)) {
                i4++;
                i2 += 2;
            }
            i2++;
        }
        if (i4 < this.baE || (i4 == this.baE && r1 == 0)) {
            AppMethodBeat.o(95924);
            return true;
        }
        AppMethodBeat.o(95924);
        return false;
    }

    public final boolean rl() {
        AppMethodBeat.i(95925);
        boolean z = (this.data[this.baF] & (128 >> this.baG)) != 0;
        tz();
        AppMethodBeat.o(95925);
        return z;
    }

    public final int ed(int i) {
        int i2 = 2;
        AppMethodBeat.i(95926);
        this.baG += i;
        int i3 = 0;
        while (this.baG > 8) {
            this.baG -= 8;
            i3 |= (this.data[this.baF] & 255) << this.baG;
            this.baF = (eP(this.baF + 1) ? 2 : 1) + this.baF;
        }
        i3 = (i3 | ((this.data[this.baF] & 255) >> (8 - this.baG))) & (-1 >>> (32 - i));
        if (this.baG == 8) {
            this.baG = 0;
            int i4 = this.baF;
            if (!eP(this.baF + 1)) {
                i2 = 1;
            }
            this.baF = i4 + i2;
        }
        rm();
        AppMethodBeat.o(95926);
        return i3;
    }

    public final boolean tM() {
        boolean z;
        AppMethodBeat.i(95927);
        int i = this.baF;
        int i2 = this.baG;
        int i3 = 0;
        while (this.baF < this.baE && !rl()) {
            i3++;
        }
        if (this.baF == this.baE) {
            z = true;
        } else {
            z = false;
        }
        this.baF = i;
        this.baG = i2;
        if (z || !eO((i3 * 2) + 1)) {
            AppMethodBeat.o(95927);
            return false;
        }
        AppMethodBeat.o(95927);
        return true;
    }

    public final int tN() {
        AppMethodBeat.i(95928);
        int tO = tO();
        int i = (tO % 2 == 0 ? -1 : 1) * ((tO + 1) / 2);
        AppMethodBeat.o(95928);
        return i;
    }

    public final int tO() {
        int i = 0;
        AppMethodBeat.i(95929);
        int i2 = 0;
        while (!rl()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = ed(i2);
        }
        i2 = i3 + i;
        AppMethodBeat.o(95929);
        return i2;
    }

    private boolean eP(int i) {
        return 2 <= i && i < this.baE && this.data[i] == (byte) 3 && this.data[i - 2] == (byte) 0 && this.data[i - 1] == (byte) 0;
    }

    private void rm() {
        AppMethodBeat.i(95930);
        boolean z = this.baF >= 0 && (this.baF < this.baE || (this.baF == this.baE && this.baG == 0));
        a.checkState(z);
        AppMethodBeat.o(95930);
    }
}
