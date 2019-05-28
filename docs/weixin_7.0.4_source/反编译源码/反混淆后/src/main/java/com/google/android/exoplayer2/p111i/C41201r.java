package com.google.android.exoplayer2.p111i;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.i.r */
final class C41201r implements C37264b {
    C41201r() {
    }

    public final long elapsedRealtime() {
        AppMethodBeat.m2504i(95940);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        AppMethodBeat.m2505o(95940);
        return elapsedRealtime;
    }
}
