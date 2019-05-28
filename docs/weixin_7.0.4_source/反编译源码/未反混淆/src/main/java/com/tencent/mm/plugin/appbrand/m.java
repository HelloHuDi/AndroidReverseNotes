package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.report.service.h;

public final class m {
    int cD;
    long[] gOU = new long[15];
    int gOV;
    int gOW;
    private int gOX = 0;
    boolean gOY;
    boolean gOZ;
    int gPa;
    int mType;

    public m() {
        int i = 0;
        AppMethodBeat.i(128973);
        if (e.auw()) {
            i = 1;
        }
        this.gOX = i;
        AppMethodBeat.o(128973);
    }

    public final void y(int i, long j) {
        if (i < this.gOU.length && this.gOU[i] == 0) {
            this.gOU[i] = j;
        }
    }

    /* Access modifiers changed, original: final */
    public final void f(String str, int i, int i2, int i3) {
        int i4;
        int i5 = 1;
        AppMethodBeat.i(128974);
        h hVar = h.pYm;
        Object[] objArr = new Object[17];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(this.cD);
        objArr[2] = Integer.valueOf(this.mType);
        objArr[3] = Integer.valueOf(i);
        objArr[4] = "";
        objArr[5] = "";
        objArr[6] = Long.valueOf(this.gOU[i2]);
        objArr[7] = Integer.valueOf(this.gOV);
        objArr[8] = Integer.valueOf(this.gOX);
        objArr[9] = Integer.valueOf(this.gOW);
        if (this.gOY) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        objArr[10] = Integer.valueOf(i4);
        if (!this.gOZ) {
            i5 = 0;
        }
        objArr[11] = Integer.valueOf(i5);
        objArr[12] = Integer.valueOf(i3);
        objArr[13] = Integer.valueOf(0);
        objArr[14] = Integer.valueOf(0);
        objArr[15] = Integer.valueOf(0);
        objArr[16] = Integer.valueOf(this.gPa);
        hVar.e(13886, objArr);
        AppMethodBeat.o(128974);
    }
}
