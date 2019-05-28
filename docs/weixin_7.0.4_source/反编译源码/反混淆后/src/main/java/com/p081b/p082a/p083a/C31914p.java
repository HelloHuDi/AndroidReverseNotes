package com.p081b.p082a.p083a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.b.a.a.p */
class C31914p {
    final long bFB;
    final long bFC;
    final int what;

    private C31914p(int i, long j, long j2) {
        this.what = i;
        this.bFB = j;
        this.bFC = j2;
    }

    C31914p(int i) {
        this(i, System.currentTimeMillis(), SystemClock.elapsedRealtime());
        AppMethodBeat.m2504i(55679);
        AppMethodBeat.m2505o(55679);
    }
}
