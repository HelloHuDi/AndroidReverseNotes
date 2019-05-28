package com.google.android.exoplayer2.source;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e implements m {
    private final m[] bgB;

    public e(m[] mVarArr) {
        this.bgB = mVarArr;
    }

    public final long rU() {
        AppMethodBeat.i(95474);
        long j = Long.MAX_VALUE;
        for (m rU : this.bgB) {
            long rU2 = rU.rU();
            if (rU2 != Long.MIN_VALUE) {
                j = Math.min(j, rU2);
            }
        }
        if (j == Long.MAX_VALUE) {
            AppMethodBeat.o(95474);
            return Long.MIN_VALUE;
        }
        AppMethodBeat.o(95474);
        return j;
    }

    public final long rV() {
        AppMethodBeat.i(95475);
        long j = Long.MAX_VALUE;
        for (m rV : this.bgB) {
            long rV2 = rV.rV();
            if (rV2 != Long.MIN_VALUE) {
                j = Math.min(j, rV2);
            }
        }
        if (j == Long.MAX_VALUE) {
            AppMethodBeat.o(95475);
            return Long.MIN_VALUE;
        }
        AppMethodBeat.o(95475);
        return j;
    }

    public final boolean Y(long j) {
        AppMethodBeat.i(95476);
        boolean z = false;
        int i;
        do {
            long rV = rV();
            if (rV == Long.MIN_VALUE) {
                break;
            }
            i = 0;
            for (m mVar : this.bgB) {
                if (mVar.rV() == rV) {
                    i |= mVar.Y(j);
                }
            }
            z |= i;
        } while (i != 0);
        AppMethodBeat.o(95476);
        return z;
    }
}
