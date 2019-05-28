package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c implements a {
    private final long aOz;
    private final long[] aSD;
    private final long[] aVC;

    c(long[] jArr, long[] jArr2, long j) {
        this.aSD = jArr;
        this.aVC = jArr2;
        this.aOz = j;
    }

    public final boolean qX() {
        return true;
    }

    public final long M(long j) {
        AppMethodBeat.i(94931);
        long j2 = this.aVC[v.a(this.aSD, j, true)];
        AppMethodBeat.o(94931);
        return j2;
    }

    public final long O(long j) {
        AppMethodBeat.i(94932);
        long j2 = this.aSD[v.a(this.aVC, j, true)];
        AppMethodBeat.o(94932);
        return j2;
    }

    public final long getDurationUs() {
        return this.aOz;
    }
}
