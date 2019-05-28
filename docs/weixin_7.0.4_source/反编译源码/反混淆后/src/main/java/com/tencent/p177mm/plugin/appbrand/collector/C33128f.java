package com.tencent.p177mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.tencent.mm.plugin.appbrand.collector.f */
public final class C33128f {
    private static final AtomicInteger heH = new AtomicInteger();
    private static final AtomicLong heI = new AtomicLong();
    private static boolean heJ;

    static {
        AppMethodBeat.m2504i(57044);
        AppMethodBeat.m2505o(57044);
    }

    public static void reset() {
        AppMethodBeat.m2504i(57042);
        heH.set(0);
        heI.set(0);
        AppMethodBeat.m2505o(57042);
    }

    /* renamed from: dH */
    public static void m54149dH(boolean z) {
        heJ = z;
    }

    public static boolean ayu() {
        return heJ;
    }

    public static String ayv() {
        float f;
        float f2 = 0.0f;
        AppMethodBeat.m2504i(57043);
        int i = heH.get();
        long j = heI.get();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append = stringBuilder.append("fps : ");
        int i2 = heH.get();
        long j2 = heI.get();
        if (!heJ || j2 <= 0) {
            f = 0.0f;
        } else {
            f = (((float) i2) * 1000.0f) / ((float) j2);
        }
        append.append(f);
        stringBuilder.append("\ncount : ").append(i);
        StringBuilder append2 = stringBuilder.append("\naverage cost : ");
        if (i > 0) {
            f2 = (1.0f * ((float) j)) / ((float) i);
        }
        append2.append(f2);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(57043);
        return stringBuilder2;
    }
}
