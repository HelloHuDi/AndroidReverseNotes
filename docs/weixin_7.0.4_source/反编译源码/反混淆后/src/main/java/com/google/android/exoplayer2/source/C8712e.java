package com.google.android.exoplayer2.source;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.source.e */
public final class C8712e implements C17689m {
    private final C17689m[] bgB;

    public C8712e(C17689m[] c17689mArr) {
        this.bgB = c17689mArr;
    }

    /* renamed from: rU */
    public final long mo19284rU() {
        AppMethodBeat.m2504i(95474);
        long j = Long.MAX_VALUE;
        for (C17689m rU : this.bgB) {
            long rU2 = rU.mo19284rU();
            if (rU2 != Long.MIN_VALUE) {
                j = Math.min(j, rU2);
            }
        }
        if (j == Long.MAX_VALUE) {
            AppMethodBeat.m2505o(95474);
            return Long.MIN_VALUE;
        }
        AppMethodBeat.m2505o(95474);
        return j;
    }

    /* renamed from: rV */
    public final long mo19285rV() {
        AppMethodBeat.m2504i(95475);
        long j = Long.MAX_VALUE;
        for (C17689m rV : this.bgB) {
            long rV2 = rV.mo19285rV();
            if (rV2 != Long.MIN_VALUE) {
                j = Math.min(j, rV2);
            }
        }
        if (j == Long.MAX_VALUE) {
            AppMethodBeat.m2505o(95475);
            return Long.MIN_VALUE;
        }
        AppMethodBeat.m2505o(95475);
        return j;
    }

    /* renamed from: Y */
    public final boolean mo19275Y(long j) {
        AppMethodBeat.m2504i(95476);
        boolean z = false;
        int i;
        do {
            long rV = mo19285rV();
            if (rV == Long.MIN_VALUE) {
                break;
            }
            i = 0;
            for (C17689m c17689m : this.bgB) {
                if (c17689m.mo19285rV() == rV) {
                    i |= c17689m.mo19275Y(j);
                }
            }
            z |= i;
        } while (i != 0);
        AppMethodBeat.m2505o(95476);
        return z;
    }
}
