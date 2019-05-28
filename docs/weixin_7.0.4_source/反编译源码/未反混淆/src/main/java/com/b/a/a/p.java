package com.b.a.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

class p {
    final long bFB;
    final long bFC;
    final int what;

    private p(int i, long j, long j2) {
        this.what = i;
        this.bFB = j;
        this.bFC = j2;
    }

    p(int i) {
        this(i, System.currentTimeMillis(), SystemClock.elapsedRealtime());
        AppMethodBeat.i(55679);
        AppMethodBeat.o(55679);
    }
}
