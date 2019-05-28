package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class j implements b {
    private int aMH;
    private final boolean bpR;
    private final int bpS;
    private final byte[] bpT;
    private final a[] bpU;
    private int bpV;
    private int bpW;
    private a[] bpX;

    public j() {
        this((byte) 0);
    }

    private j(byte b) {
        AppMethodBeat.i(95806);
        a.checkArgument(true);
        a.checkArgument(true);
        this.bpR = true;
        this.bpS = 65536;
        this.bpW = 0;
        this.bpX = new a[100];
        this.bpT = null;
        this.bpU = new a[1];
        AppMethodBeat.o(95806);
    }

    public final synchronized void reset() {
        AppMethodBeat.i(95807);
        if (this.bpR) {
            eJ(0);
        }
        AppMethodBeat.o(95807);
    }

    public final synchronized void eJ(int i) {
        AppMethodBeat.i(95808);
        Object obj = i < this.aMH ? 1 : null;
        this.aMH = i;
        if (obj != null) {
            trim();
        }
        AppMethodBeat.o(95808);
    }

    public final synchronized a tj() {
        a aVar;
        AppMethodBeat.i(95809);
        this.bpV++;
        if (this.bpW > 0) {
            a[] aVarArr = this.bpX;
            int i = this.bpW - 1;
            this.bpW = i;
            aVar = aVarArr[i];
            this.bpX[this.bpW] = null;
        } else {
            aVar = new a(new byte[this.bpS]);
        }
        AppMethodBeat.o(95809);
        return aVar;
    }

    public final synchronized void a(a aVar) {
        AppMethodBeat.i(95810);
        this.bpU[0] = aVar;
        a(this.bpU);
        AppMethodBeat.o(95810);
    }

    public final synchronized void a(a[] aVarArr) {
        AppMethodBeat.i(95811);
        if (this.bpW + aVarArr.length >= this.bpX.length) {
            this.bpX = (a[]) Arrays.copyOf(this.bpX, Math.max(this.bpX.length * 2, this.bpW + aVarArr.length));
        }
        for (a aVar : aVarArr) {
            boolean z;
            if (aVar.data == this.bpT || aVar.data.length == this.bpS) {
                z = true;
            } else {
                z = false;
            }
            a.checkArgument(z);
            a[] aVarArr2 = this.bpX;
            int i = this.bpW;
            this.bpW = i + 1;
            aVarArr2[i] = aVar;
        }
        this.bpV -= aVarArr.length;
        notifyAll();
        AppMethodBeat.o(95811);
    }

    public final synchronized void trim() {
        AppMethodBeat.i(95812);
        int max = Math.max(0, v.bi(this.aMH, this.bpS) - this.bpV);
        if (max >= this.bpW) {
            AppMethodBeat.o(95812);
        } else {
            if (this.bpT != null) {
                int i = this.bpW - 1;
                int i2 = 0;
                while (i2 <= i) {
                    a aVar = this.bpX[i2];
                    if (aVar.data == this.bpT) {
                        i2++;
                    } else {
                        a aVar2 = this.bpX[i];
                        if (aVar2.data != this.bpT) {
                            i--;
                        } else {
                            int i3 = i2 + 1;
                            this.bpX[i2] = aVar2;
                            int i4 = i - 1;
                            this.bpX[i] = aVar;
                            i = i4;
                            i2 = i3;
                        }
                    }
                }
                max = Math.max(max, i2);
                if (max >= this.bpW) {
                    AppMethodBeat.o(95812);
                }
            }
            Arrays.fill(this.bpX, max, this.bpW, null);
            this.bpW = max;
            AppMethodBeat.o(95812);
        }
    }

    public final synchronized int tp() {
        return this.bpV * this.bpS;
    }

    public final int tk() {
        return this.bpS;
    }
}
