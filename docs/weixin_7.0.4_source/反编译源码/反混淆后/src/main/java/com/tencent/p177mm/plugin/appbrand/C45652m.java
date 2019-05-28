package com.tencent.p177mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.task.C27310e;
import com.tencent.p177mm.plugin.report.service.C7060h;

/* renamed from: com.tencent.mm.plugin.appbrand.m */
public final class C45652m {
    /* renamed from: cD */
    int f17885cD;
    long[] gOU = new long[15];
    int gOV;
    int gOW;
    private int gOX = 0;
    boolean gOY;
    boolean gOZ;
    int gPa;
    int mType;

    public C45652m() {
        int i = 0;
        AppMethodBeat.m2504i(128973);
        if (C27310e.auw()) {
            i = 1;
        }
        this.gOX = i;
        AppMethodBeat.m2505o(128973);
    }

    /* renamed from: y */
    public final void mo73432y(int i, long j) {
        if (i < this.gOU.length && this.gOU[i] == 0) {
            this.gOU[i] = j;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: f */
    public final void mo73431f(String str, int i, int i2, int i3) {
        int i4;
        int i5 = 1;
        AppMethodBeat.m2504i(128974);
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[17];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(this.f17885cD);
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
        c7060h.mo8381e(13886, objArr);
        AppMethodBeat.m2505o(128974);
    }
}
