package com.tencent.mm.modelvoiceaddr.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private int gbD = 0;
    private int gbE = 0;
    int gbF = 0;
    private short[] gbG;

    public a(int i) {
        AppMethodBeat.i(116754);
        if (i <= 1) {
            i = 512;
        }
        this.gbG = new short[i];
        AppMethodBeat.o(116754);
    }

    /* Access modifiers changed, original: final */
    public final int d(short[] sArr, int i) {
        int length;
        AppMethodBeat.i(116755);
        if (i > sArr.length) {
            length = sArr.length;
        } else {
            length = i;
        }
        if (length == 0) {
            AppMethodBeat.o(116755);
            return 0;
        }
        int length2 = this.gbG.length;
        if (length >= this.gbF) {
            length = this.gbF;
        }
        if (length <= length2 - this.gbD) {
            System.arraycopy(this.gbG, this.gbD, sArr, 0, length);
            this.gbD += length;
            if (this.gbD >= length2) {
                this.gbD = 0;
            }
        } else {
            length2 -= this.gbD;
            System.arraycopy(this.gbG, this.gbD, sArr, 0, length2);
            int i2 = length - length2;
            System.arraycopy(this.gbG, 0, sArr, length2, i2);
            this.gbD = i2;
        }
        this.gbF -= length;
        AppMethodBeat.o(116755);
        return length;
    }

    /* Access modifiers changed, original: final */
    public final int e(short[] sArr, int i) {
        AppMethodBeat.i(116756);
        if (sArr.length < 0) {
            AppMethodBeat.o(116756);
            return 0;
        }
        int length;
        if (i > sArr.length + 0) {
            length = sArr.length + 0;
        } else {
            length = i;
        }
        if (length == 0) {
            AppMethodBeat.o(116756);
            return 0;
        }
        int length2 = this.gbG.length - this.gbF;
        if (length > length2) {
            length2 = length - length2;
            if (length2 != 0) {
                if (length2 >= this.gbF) {
                    length2 = this.gbF;
                }
                if (length2 <= this.gbG.length - this.gbD) {
                    this.gbD += length2;
                    if (this.gbD >= this.gbG.length) {
                        this.gbD = 0;
                    }
                } else {
                    this.gbD = length2 - (this.gbG.length - this.gbD);
                }
                this.gbF -= length2;
            }
        }
        if (length > this.gbG.length) {
            length2 = (length - this.gbG.length) + 0;
            length = this.gbG.length;
        } else {
            length2 = 0;
        }
        if (length <= this.gbG.length - this.gbE) {
            System.arraycopy(sArr, length2, this.gbG, this.gbE, length);
            this.gbE += length;
            if (this.gbE >= this.gbG.length) {
                this.gbE = 0;
            }
        } else {
            int length3 = this.gbG.length - this.gbE;
            System.arraycopy(sArr, length2, this.gbG, this.gbE, length3);
            int i2 = length - length3;
            System.arraycopy(sArr, length2 + length3, this.gbG, 0, i2);
            this.gbE = i2;
        }
        this.gbF += length;
        AppMethodBeat.o(116756);
        return length;
    }
}
