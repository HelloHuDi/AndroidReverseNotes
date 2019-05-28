package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d implements a {
    private final long aOz;
    private final long aVD;
    private final long[] aVE;
    private final long aVF;
    private final int aVG;
    private final long firstFramePosition;

    d(long j, long j2, long j3) {
        this(j, j2, j3, null, 0, 0);
    }

    d(long j, long j2, long j3, long[] jArr, long j4, int i) {
        this.firstFramePosition = j;
        this.aOz = j2;
        this.aVD = j3;
        this.aVE = jArr;
        this.aVF = j4;
        this.aVG = i;
    }

    public final boolean qX() {
        return this.aVE != null;
    }

    public final long M(long j) {
        float f = 256.0f;
        float f2 = 0.0f;
        AppMethodBeat.i(94933);
        long min;
        if (qX()) {
            float f3 = (((float) j) * 100.0f) / ((float) this.aOz);
            if (f3 <= 0.0f) {
                f = 0.0f;
            } else if (f3 < 100.0f) {
                int i = (int) f3;
                if (i != 0) {
                    f2 = (float) this.aVE[i - 1];
                }
                if (i < 99) {
                    f = (float) this.aVE[i];
                }
                f = ((f - f2) * (f3 - ((float) i))) + f2;
            }
            min = Math.min(this.firstFramePosition + Math.round((((double) f) * 0.00390625d) * ((double) this.aVF)), this.aVD != -1 ? this.aVD - 1 : ((this.firstFramePosition - ((long) this.aVG)) + this.aVF) - 1);
            AppMethodBeat.o(94933);
            return min;
        }
        min = this.firstFramePosition;
        AppMethodBeat.o(94933);
        return min;
    }

    public final long O(long j) {
        AppMethodBeat.i(94934);
        if (!qX() || j < this.firstFramePosition) {
            AppMethodBeat.o(94934);
            return 0;
        }
        double d = (256.0d * ((double) (j - this.firstFramePosition))) / ((double) this.aVF);
        int a = v.a(this.aVE, (long) d, false) + 1;
        long dS = dS(a);
        long j2 = a == 0 ? 0 : this.aVE[a - 1];
        long j3 = a == 99 ? 256 : this.aVE[a];
        j3 = (j3 == j2 ? 0 : (long) (((d - ((double) j2)) * ((double) (dS(a + 1) - dS))) / ((double) (j3 - j2)))) + dS;
        AppMethodBeat.o(94934);
        return j3;
    }

    public final long getDurationUs() {
        return this.aOz;
    }

    private long dS(int i) {
        return (this.aOz * ((long) i)) / 100;
    }
}
