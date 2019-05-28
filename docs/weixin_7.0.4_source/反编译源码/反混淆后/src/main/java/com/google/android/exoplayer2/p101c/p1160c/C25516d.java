package com.google.android.exoplayer2.p101c.p1160c;

import com.google.android.exoplayer2.p101c.p1160c.C45021b.C41597a;
import com.google.android.exoplayer2.p111i.C17675v;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c.c.d */
final class C25516d implements C41597a {
    private final long aOz;
    private final long aVD;
    private final long[] aVE;
    private final long aVF;
    private final int aVG;
    private final long firstFramePosition;

    C25516d(long j, long j2, long j3) {
        this(j, j2, j3, null, 0, 0);
    }

    C25516d(long j, long j2, long j3, long[] jArr, long j4, int i) {
        this.firstFramePosition = j;
        this.aOz = j2;
        this.aVD = j3;
        this.aVE = jArr;
        this.aVF = j4;
        this.aVG = i;
    }

    /* renamed from: qX */
    public final boolean mo2552qX() {
        return this.aVE != null;
    }

    /* renamed from: M */
    public final long mo2548M(long j) {
        float f = 256.0f;
        float f2 = 0.0f;
        AppMethodBeat.m2504i(94933);
        long min;
        if (mo2552qX()) {
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
            AppMethodBeat.m2505o(94933);
            return min;
        }
        min = this.firstFramePosition;
        AppMethodBeat.m2505o(94933);
        return min;
    }

    /* renamed from: O */
    public final long mo42777O(long j) {
        AppMethodBeat.m2504i(94934);
        if (!mo2552qX() || j < this.firstFramePosition) {
            AppMethodBeat.m2505o(94934);
            return 0;
        }
        double d = (256.0d * ((double) (j - this.firstFramePosition))) / ((double) this.aVF);
        int a = C17675v.m27553a(this.aVE, (long) d, false) + 1;
        long dS = m40318dS(a);
        long j2 = a == 0 ? 0 : this.aVE[a - 1];
        long j3 = a == 99 ? 256 : this.aVE[a];
        j3 = (j3 == j2 ? 0 : (long) (((d - ((double) j2)) * ((double) (m40318dS(a + 1) - dS))) / ((double) (j3 - j2)))) + dS;
        AppMethodBeat.m2505o(94934);
        return j3;
    }

    public final long getDurationUs() {
        return this.aOz;
    }

    /* renamed from: dS */
    private long m40318dS(int i) {
        return (this.aOz * ((long) i)) / 100;
    }
}
