package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a implements a {
    private final long aOz;
    private final int bitrate;
    private final long firstFramePosition;

    public a(long j, int i, long j2) {
        AppMethodBeat.i(94919);
        this.firstFramePosition = j;
        this.bitrate = i;
        this.aOz = j2 == -1 ? -9223372036854775807L : O(j2);
        AppMethodBeat.o(94919);
    }

    public final boolean qX() {
        return this.aOz != -9223372036854775807L;
    }

    public final long M(long j) {
        AppMethodBeat.i(94920);
        if (this.aOz == -9223372036854775807L) {
            AppMethodBeat.o(94920);
            return 0;
        }
        long l = v.l(j, this.aOz);
        l = ((l * ((long) this.bitrate)) / 8000000) + this.firstFramePosition;
        AppMethodBeat.o(94920);
        return l;
    }

    public final long O(long j) {
        AppMethodBeat.i(94921);
        long max = ((Math.max(0, j - this.firstFramePosition) * 1000000) * 8) / ((long) this.bitrate);
        AppMethodBeat.o(94921);
        return max;
    }

    public final long getDurationUs() {
        return this.aOz;
    }
}
