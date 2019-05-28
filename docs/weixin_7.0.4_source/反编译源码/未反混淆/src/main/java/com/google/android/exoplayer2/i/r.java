package com.google.android.exoplayer2.i;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class r implements b {
    r() {
    }

    public final long elapsedRealtime() {
        AppMethodBeat.i(95940);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        AppMethodBeat.o(95940);
        return elapsedRealtime;
    }
}
