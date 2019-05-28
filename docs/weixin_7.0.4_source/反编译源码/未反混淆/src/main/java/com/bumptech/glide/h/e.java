package com.bumptech.glide.h;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e {
    private static final double aIb;

    static {
        double d = 1.0d;
        AppMethodBeat.i(92579);
        if (VERSION.SDK_INT >= 17) {
            d = 1.0d / Math.pow(10.0d, 6.0d);
        }
        aIb = d;
        AppMethodBeat.o(92579);
    }

    @TargetApi(17)
    public static long ok() {
        AppMethodBeat.i(92577);
        long elapsedRealtimeNanos;
        if (VERSION.SDK_INT >= 17) {
            elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            AppMethodBeat.o(92577);
            return elapsedRealtimeNanos;
        }
        elapsedRealtimeNanos = SystemClock.uptimeMillis();
        AppMethodBeat.o(92577);
        return elapsedRealtimeNanos;
    }

    public static double q(long j) {
        AppMethodBeat.i(92578);
        double ok = ((double) (ok() - j)) * aIb;
        AppMethodBeat.o(92578);
        return ok;
    }
}
