package com.bumptech.glide.p095h;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.h.e */
public final class C31975e {
    private static final double aIb;

    static {
        double d = 1.0d;
        AppMethodBeat.m2504i(92579);
        if (VERSION.SDK_INT >= 17) {
            d = 1.0d / Math.pow(10.0d, 6.0d);
        }
        aIb = d;
        AppMethodBeat.m2505o(92579);
    }

    @TargetApi(17)
    /* renamed from: ok */
    public static long m51954ok() {
        AppMethodBeat.m2504i(92577);
        long elapsedRealtimeNanos;
        if (VERSION.SDK_INT >= 17) {
            elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            AppMethodBeat.m2505o(92577);
            return elapsedRealtimeNanos;
        }
        elapsedRealtimeNanos = SystemClock.uptimeMillis();
        AppMethodBeat.m2505o(92577);
        return elapsedRealtimeNanos;
    }

    /* renamed from: q */
    public static double m51955q(long j) {
        AppMethodBeat.m2504i(92578);
        double ok = ((double) (C31975e.m51954ok() - j)) * aIb;
        AppMethodBeat.m2505o(92578);
        return ok;
    }
}
