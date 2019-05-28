package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s {
    public long bbh;
    private long brK;
    public volatile long brL = -9223372036854775807L;

    public s(long j) {
        AppMethodBeat.i(95941);
        an(j);
        AppMethodBeat.o(95941);
    }

    public final synchronized void an(long j) {
        AppMethodBeat.i(95942);
        a.checkState(this.brL == -9223372036854775807L);
        this.bbh = j;
        AppMethodBeat.o(95942);
    }

    public final long tQ() {
        if (this.bbh == Long.MAX_VALUE) {
            return 0;
        }
        return this.brL != -9223372036854775807L ? this.brK : -9223372036854775807L;
    }

    public final long ao(long j) {
        AppMethodBeat.i(95943);
        if (j == -9223372036854775807L) {
            AppMethodBeat.o(95943);
            return -9223372036854775807L;
        }
        long j2;
        if (this.brL != -9223372036854775807L) {
            long ar = ar(this.brL);
            long j3 = (4294967296L + ar) / 8589934592L;
            j2 = ((j3 - 1) * 8589934592L) + j;
            j3 = (j3 * 8589934592L) + j;
            if (Math.abs(j2 - ar) >= Math.abs(j3 - ar)) {
                j2 = j3;
            }
        } else {
            j2 = j;
        }
        j2 = ap(aq(j2));
        AppMethodBeat.o(95943);
        return j2;
    }

    public final long ap(long j) {
        AppMethodBeat.i(95944);
        if (j == -9223372036854775807L) {
            AppMethodBeat.o(95944);
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
                    AppMethodBeat.o(95944);
                }
            }
        }
        long j2 = this.brK + j;
        AppMethodBeat.o(95944);
        return j2;
    }

    public final synchronized void tR() {
        AppMethodBeat.i(95945);
        while (this.brL == -9223372036854775807L) {
            wait();
        }
        AppMethodBeat.o(95945);
    }

    public static long aq(long j) {
        return (1000000 * j) / 90000;
    }

    public static long ar(long j) {
        return (90000 * j) / 1000000;
    }
}
