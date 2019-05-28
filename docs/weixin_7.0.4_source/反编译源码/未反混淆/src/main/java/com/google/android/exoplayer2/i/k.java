package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k {
    private int baE;
    public int baF;
    public int baG;
    public byte[] data;

    public k(byte[] bArr) {
        this(bArr, bArr.length);
        AppMethodBeat.i(95893);
        AppMethodBeat.o(95893);
    }

    public k(byte[] bArr, int i) {
        this.data = bArr;
        this.baE = i;
    }

    public final void n(byte[] bArr, int i) {
        this.data = bArr;
        this.baF = 0;
        this.baG = 0;
        this.baE = i;
    }

    public final int tx() {
        return ((this.baE - this.baF) * 8) - this.baG;
    }

    public final int ty() {
        AppMethodBeat.i(95894);
        a.checkState(this.baG == 0);
        int i = this.baF;
        AppMethodBeat.o(95894);
        return i;
    }

    public final void setPosition(int i) {
        AppMethodBeat.i(95895);
        this.baF = i / 8;
        this.baG = i - (this.baF * 8);
        rm();
        AppMethodBeat.o(95895);
    }

    private void tz() {
        AppMethodBeat.i(95896);
        int i = this.baG + 1;
        this.baG = i;
        if (i == 8) {
            this.baG = 0;
            this.baF++;
        }
        rm();
        AppMethodBeat.o(95896);
    }

    public final void ee(int i) {
        AppMethodBeat.i(95897);
        int i2 = i / 8;
        this.baF += i2;
        this.baG = (i - (i2 * 8)) + this.baG;
        if (this.baG > 7) {
            this.baF++;
            this.baG -= 8;
        }
        rm();
        AppMethodBeat.o(95897);
    }

    public final boolean rl() {
        AppMethodBeat.i(95898);
        boolean z = (this.data[this.baF] & (128 >> this.baG)) != 0;
        tz();
        AppMethodBeat.o(95898);
        return z;
    }

    public final int ed(int i) {
        AppMethodBeat.i(95899);
        if (i == 0) {
            AppMethodBeat.o(95899);
            return 0;
        }
        this.baG += i;
        int i2 = 0;
        while (this.baG > 8) {
            this.baG -= 8;
            byte[] bArr = this.data;
            int i3 = this.baF;
            this.baF = i3 + 1;
            i2 |= (bArr[i3] & 255) << this.baG;
        }
        i2 = (i2 | ((this.data[this.baF] & 255) >> (8 - this.baG))) & (-1 >>> (32 - i));
        if (this.baG == 8) {
            this.baG = 0;
            this.baF++;
        }
        rm();
        AppMethodBeat.o(95899);
        return i2;
    }

    public final void tA() {
        AppMethodBeat.i(95900);
        if (this.baG == 0) {
            AppMethodBeat.o(95900);
            return;
        }
        this.baG = 0;
        this.baF++;
        rm();
        AppMethodBeat.o(95900);
    }

    public final void p(byte[] bArr, int i) {
        boolean z;
        AppMethodBeat.i(95901);
        if (this.baG == 0) {
            z = true;
        } else {
            z = false;
        }
        a.checkState(z);
        System.arraycopy(this.data, this.baF, bArr, 0, i);
        this.baF += i;
        rm();
        AppMethodBeat.o(95901);
    }

    public final void rm() {
        AppMethodBeat.i(95902);
        boolean z = this.baF >= 0 && (this.baF < this.baE || (this.baF == this.baE && this.baG == 0));
        a.checkState(z);
        AppMethodBeat.o(95902);
    }
}
