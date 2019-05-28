package com.google.android.exoplayer2.p101c;

import com.google.android.exoplayer2.p111i.C17675v;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c.a */
public final class C25515a implements C37247l {
    private final long aOz;
    public final int[] aSB;
    public final long[] aSC;
    public final long[] aSD;
    public final int length;
    public final long[] offsets;

    public C25515a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        AppMethodBeat.m2504i(94840);
        this.aSB = iArr;
        this.offsets = jArr;
        this.aSC = jArr2;
        this.aSD = jArr3;
        this.length = iArr.length;
        if (this.length > 0) {
            this.aOz = jArr2[this.length - 1] + jArr3[this.length - 1];
            AppMethodBeat.m2505o(94840);
            return;
        }
        this.aOz = 0;
        AppMethodBeat.m2505o(94840);
    }

    /* renamed from: qX */
    public final boolean mo2552qX() {
        return true;
    }

    public final long getDurationUs() {
        return this.aOz;
    }

    /* renamed from: M */
    public final long mo2548M(long j) {
        AppMethodBeat.m2504i(94841);
        long j2 = this.offsets[C17675v.m27553a(this.aSD, j, true)];
        AppMethodBeat.m2505o(94841);
        return j2;
    }
}
