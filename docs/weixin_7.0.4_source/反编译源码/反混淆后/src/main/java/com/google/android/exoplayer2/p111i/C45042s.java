package com.google.android.exoplayer2.p111i;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.i.s */
public final class C45042s {
    public long bbh;
    private long brK;
    public volatile long brL = -9223372036854775807L;

    public C45042s(long j) {
        AppMethodBeat.m2504i(95941);
        mo72550an(j);
        AppMethodBeat.m2505o(95941);
    }

    /* renamed from: an */
    public final synchronized void mo72550an(long j) {
        AppMethodBeat.m2504i(95942);
        C45039a.checkState(this.brL == -9223372036854775807L);
        this.bbh = j;
        AppMethodBeat.m2505o(95942);
    }

    /* renamed from: tQ */
    public final long mo72553tQ() {
        if (this.bbh == Long.MAX_VALUE) {
            return 0;
        }
        return this.brL != -9223372036854775807L ? this.brK : -9223372036854775807L;
    }

    /* renamed from: ao */
    public final long mo72551ao(long j) {
        AppMethodBeat.m2504i(95943);
        if (j == -9223372036854775807L) {
            AppMethodBeat.m2505o(95943);
            return -9223372036854775807L;
        }
        long j2;
        if (this.brL != -9223372036854775807L) {
            long ar = C45042s.m82584ar(this.brL);
            long j3 = (4294967296L + ar) / 8589934592L;
            j2 = ((j3 - 1) * 8589934592L) + j;
            j3 = (j3 * 8589934592L) + j;
            if (Math.abs(j2 - ar) >= Math.abs(j3 - ar)) {
                j2 = j3;
            }
        } else {
            j2 = j;
        }
        j2 = mo72552ap(C45042s.m82583aq(j2));
        AppMethodBeat.m2505o(95943);
        return j2;
    }

    /* renamed from: ap */
    public final long mo72552ap(long j) {
        AppMethodBeat.m2504i(95944);
        if (j == -9223372036854775807L) {
            AppMethodBeat.m2505o(95944);
            return -9223372036854775807L;
        }
        if (this.brL != -9223372036854775807L) {
            this.brL = j;
        } else {
            if (this.bbh != Long.MAX_VALUE) {
                this.brK = this.bbh - j;
            }
            synchronized (this) {
                try {
                    this.brL = j;
                    notifyAll();
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(95944);
                }
            }
        }
        long j2 = this.brK + j;
        AppMethodBeat.m2505o(95944);
        return j2;
    }

    /* renamed from: tR */
    public final synchronized void mo72554tR() {
        AppMethodBeat.m2504i(95945);
        while (this.brL == -9223372036854775807L) {
            wait();
        }
        AppMethodBeat.m2505o(95945);
    }

    /* renamed from: aq */
    public static long m82583aq(long j) {
        return (1000000 * j) / 90000;
    }

    /* renamed from: ar */
    public static long m82584ar(long j) {
        return (90000 * j) / 1000000;
    }
}
