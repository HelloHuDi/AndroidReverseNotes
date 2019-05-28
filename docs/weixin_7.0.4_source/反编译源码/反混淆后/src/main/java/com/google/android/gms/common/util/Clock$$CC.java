package com.google.android.gms.common.util;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public /* synthetic */ class Clock$$CC {
    public static long currentThreadTimeMillis(Clock clock) {
        AppMethodBeat.m2504i(90046);
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        AppMethodBeat.m2505o(90046);
        return currentThreadTimeMillis;
    }
}
