package com.google.android.exoplayer2.p101c.p1160c;

import com.google.android.exoplayer2.p101c.p1160c.C45021b.C41597a;
import com.google.android.exoplayer2.p111i.C17675v;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c.c.a */
final class C37233a implements C41597a {
    private final long aOz;
    private final int bitrate;
    private final long firstFramePosition;

    public C37233a(long j, int i, long j2) {
        AppMethodBeat.m2504i(94919);
        this.firstFramePosition = j;
        this.bitrate = i;
        this.aOz = j2 == -1 ? -9223372036854775807L : mo42777O(j2);
        AppMethodBeat.m2505o(94919);
    }

    /* renamed from: qX */
    public final boolean mo2552qX() {
        return this.aOz != -9223372036854775807L;
    }

    /* renamed from: M */
    public final long mo2548M(long j) {
        AppMethodBeat.m2504i(94920);
        if (this.aOz == -9223372036854775807L) {
            AppMethodBeat.m2505o(94920);
            return 0;
        }
        long l = C17675v.m27575l(j, this.aOz);
        l = ((l * ((long) this.bitrate)) / 8000000) + this.firstFramePosition;
        AppMethodBeat.m2505o(94920);
        return l;
    }

    /* renamed from: O */
    public final long mo42777O(long j) {
        AppMethodBeat.m2504i(94921);
        long max = ((Math.max(0, j - this.firstFramePosition) * 1000000) * 8) / ((long) this.bitrate);
        AppMethodBeat.m2505o(94921);
        return max;
    }

    public final long getDurationUs() {
        return this.aOz;
    }
}
