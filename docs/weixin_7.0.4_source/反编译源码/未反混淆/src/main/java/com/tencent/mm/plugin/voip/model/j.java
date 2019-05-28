package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;

final class j {
    private InputStream aEZ;
    protected f sOE;
    int sOF;
    private int sOG;
    private int sOH;
    private final OutputStream sOI;
    private int[] sOJ;
    int sOK;

    public j(InputStream inputStream) {
        AppMethodBeat.i(4369);
        this.sOE = new f();
        this.sOJ = new int[8];
        this.aEZ = inputStream;
        this.sOI = null;
        this.sOG = inputStream.read();
        this.sOH = inputStream.read();
        AppMethodBeat.o(4369);
    }

    public j(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(4370);
        this.sOE = new f();
        this.sOJ = new int[8];
        this.aEZ = inputStream;
        this.sOI = outputStream;
        this.sOG = inputStream.read();
        this.sOH = inputStream.read();
        AppMethodBeat.o(4370);
    }

    public final boolean ml(boolean z) {
        AppMethodBeat.i(4371);
        if (mm(z) == 1) {
            AppMethodBeat.o(4371);
            return true;
        }
        AppMethodBeat.o(4371);
        return false;
    }

    private int mm(boolean z) {
        int i = -1;
        AppMethodBeat.i(4372);
        if (this.sOF == 8) {
            advance();
            if (this.sOG == -1) {
                AppMethodBeat.o(4372);
                return i;
            }
        }
        i = (this.sOG >> (7 - this.sOF)) & 1;
        this.sOF++;
        if (z && this.sOI != null) {
            Ga(i);
        }
        AppMethodBeat.o(4372);
        return i;
    }

    private long FW(int i) {
        AppMethodBeat.i(4373);
        if (i > 64) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can not readByte more then 64 bit");
            AppMethodBeat.o(4373);
            throw illegalArgumentException;
        }
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 1) | ((long) mm(true));
        }
        AppMethodBeat.o(4373);
        return j;
    }

    public final void FX(int i) {
        AppMethodBeat.i(4374);
        if (i > 64) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can not skip more then 64 bit");
            AppMethodBeat.o(4374);
            throw illegalArgumentException;
        }
        for (int i2 = 0; i2 < i; i2++) {
            mm(true);
        }
        AppMethodBeat.o(4374);
    }

    private void advance() {
        AppMethodBeat.i(4375);
        this.sOG = this.sOH;
        this.sOH = this.aEZ.read();
        this.sOF = 0;
        AppMethodBeat.o(4375);
    }

    public final long cIx() {
        AppMethodBeat.i(4376);
        long FW = FW(8);
        String.valueOf(FW);
        AppMethodBeat.o(4376);
        return FW;
    }

    public final void FY(int i) {
        AppMethodBeat.i(4377);
        FX(i);
        AppMethodBeat.o(4377);
    }

    private int cIy() {
        int i = 0;
        AppMethodBeat.i(4378);
        int i2 = 0;
        while (mm(true) == 0) {
            i2++;
        }
        if (i2 > 0) {
            i = (int) (((long) ((1 << i2) - 1)) + FW(i2));
        }
        AppMethodBeat.o(4378);
        return i;
    }

    /* Access modifiers changed, original: final */
    public final void cIz() {
        AppMethodBeat.i(4379);
        int i = 0;
        while (mm(true) == 0) {
            i++;
        }
        if (i > 0) {
            FX(i);
        }
        AppMethodBeat.o(4379);
    }

    public final int cIA() {
        AppMethodBeat.i(4380);
        int cIy = cIy();
        String.valueOf(cIy);
        AppMethodBeat.o(4380);
        return cIy;
    }

    public final void cIB() {
        AppMethodBeat.i(4381);
        cIz();
        AppMethodBeat.o(4381);
    }

    private int cIC() {
        AppMethodBeat.i(4382);
        int cIy = cIy();
        cIy = ((cIy & 1) + (cIy >> 1)) * (((cIy & 1) << 1) - 1);
        String.valueOf(cIy);
        AppMethodBeat.o(4382);
        return cIy;
    }

    public final void FZ(int i) {
        AppMethodBeat.i(4383);
        int[] iArr = new int[i];
        int i2 = 8;
        int i3 = 8;
        for (int i4 = 0; i4 < i; i4++) {
            if (i2 != 0) {
                i2 = ((cIC() + i3) + 256) % 256;
            }
            if (i2 != 0) {
                i3 = i2;
            }
            iArr[i4] = i3;
            i3 = iArr[i4];
        }
        AppMethodBeat.o(4383);
    }

    public final void flush() {
        AppMethodBeat.i(4384);
        for (int i = this.sOK; i < 8; i++) {
            this.sOJ[i] = 0;
        }
        this.sOK = 0;
        cID();
        AppMethodBeat.o(4384);
    }

    private void cID() {
        AppMethodBeat.i(4385);
        this.sOI.write((((((((this.sOJ[0] << 7) | (this.sOJ[1] << 6)) | (this.sOJ[2] << 5)) | (this.sOJ[3] << 4)) | (this.sOJ[4] << 3)) | (this.sOJ[5] << 2)) | (this.sOJ[6] << 1)) | this.sOJ[7]);
        AppMethodBeat.o(4385);
    }

    public final void Ga(int i) {
        AppMethodBeat.i(4386);
        if (this.sOK == 8) {
            this.sOK = 0;
            cID();
        }
        int[] iArr = this.sOJ;
        int i2 = this.sOK;
        this.sOK = i2 + 1;
        iArr[i2] = i;
        AppMethodBeat.o(4386);
    }

    public final void G(long j, int i) {
        AppMethodBeat.i(4387);
        for (int i2 = 0; i2 < i; i2++) {
            Ga(((int) (j >> ((i - i2) - 1))) & 1);
        }
        AppMethodBeat.o(4387);
    }

    private void Gb(int i) {
        AppMethodBeat.i(4388);
        int i2 = 0;
        int i3 = 0;
        while (i2 < 15) {
            if (i < (1 << i2) + i3) {
                break;
            }
            i3 += 1 << i2;
            i2++;
        }
        i2 = 0;
        G(0, i2);
        Ga(1);
        G((long) (i - i3), i2);
        AppMethodBeat.o(4388);
    }

    public final void Gc(int i) {
        AppMethodBeat.i(4389);
        Gb(i);
        AppMethodBeat.o(4389);
    }

    public final void mn(boolean z) {
        AppMethodBeat.i(4390);
        Ga(z ? 1 : 0);
        AppMethodBeat.o(4390);
    }
}
