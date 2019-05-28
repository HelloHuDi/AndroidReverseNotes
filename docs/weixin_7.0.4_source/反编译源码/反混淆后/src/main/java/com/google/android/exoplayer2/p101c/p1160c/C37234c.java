package com.google.android.exoplayer2.p101c.p1160c;

import com.google.android.exoplayer2.p101c.p1160c.C45021b.C41597a;
import com.google.android.exoplayer2.p111i.C17675v;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c.c.c */
final class C37234c implements C41597a {
    private final long aOz;
    private final long[] aSD;
    private final long[] aVC;

    C37234c(long[] jArr, long[] jArr2, long j) {
        this.aSD = jArr;
        this.aVC = jArr2;
        this.aOz = j;
    }

    /* renamed from: qX */
    public final boolean mo2552qX() {
        return true;
    }

    /* renamed from: M */
    public final long mo2548M(long j) {
        AppMethodBeat.m2504i(94931);
        long j2 = this.aVC[C17675v.m27553a(this.aSD, j, true)];
        AppMethodBeat.m2505o(94931);
        return j2;
    }

    /* renamed from: O */
    public final long mo42777O(long j) {
        AppMethodBeat.m2504i(94932);
        long j2 = this.aSD[C17675v.m27553a(this.aVC, j, true)];
        AppMethodBeat.m2505o(94932);
        return j2;
    }

    public final long getDurationUs() {
        return this.aOz;
    }
}
