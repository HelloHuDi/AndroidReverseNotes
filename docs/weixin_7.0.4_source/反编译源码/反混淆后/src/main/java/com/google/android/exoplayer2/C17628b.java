package com.google.android.exoplayer2;

import com.google.android.exoplayer2.p111i.C17675v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

/* renamed from: com.google.android.exoplayer2.b */
public final class C17628b {
    public static final int CHANNEL_OUT_7POINT1_SURROUND;
    public static final UUID aMA = new UUID(-7348484286925749626L, -6083546864340672619L);
    public static final UUID aMx = new UUID(0, 0);
    public static final UUID aMy = new UUID(1186680826959645954L, -5988876978535335093L);
    public static final UUID aMz = new UUID(-1301668207276963122L, -6645017420763422227L);

    static {
        int i;
        AppMethodBeat.m2504i(94735);
        if (C17675v.SDK_INT < 23) {
            i = 1020;
        } else {
            i = 6396;
        }
        CHANNEL_OUT_7POINT1_SURROUND = i;
        AppMethodBeat.m2505o(94735);
    }

    /* renamed from: w */
    public static long m27433w(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j / 1000;
    }

    /* renamed from: x */
    public static long m27434x(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j * 1000;
    }
}
