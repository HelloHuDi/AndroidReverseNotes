package com.google.android.gms.common.util;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DefaultClock implements Clock {
    private static final DefaultClock zzzk = new DefaultClock();

    static {
        AppMethodBeat.m2504i(90167);
        AppMethodBeat.m2505o(90167);
    }

    private DefaultClock() {
    }

    public static Clock getInstance() {
        return zzzk;
    }

    public long currentThreadTimeMillis() {
        AppMethodBeat.m2504i(90166);
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        AppMethodBeat.m2505o(90166);
        return currentThreadTimeMillis;
    }

    public long currentTimeMillis() {
        AppMethodBeat.m2504i(90163);
        long currentTimeMillis = System.currentTimeMillis();
        AppMethodBeat.m2505o(90163);
        return currentTimeMillis;
    }

    public long elapsedRealtime() {
        AppMethodBeat.m2504i(90164);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        AppMethodBeat.m2505o(90164);
        return elapsedRealtime;
    }

    public long nanoTime() {
        AppMethodBeat.m2504i(90165);
        long nanoTime = System.nanoTime();
        AppMethodBeat.m2505o(90165);
        return nanoTime;
    }
}
