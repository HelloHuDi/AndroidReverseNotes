package com.p081b.p082a.p083a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.TimeZone;

/* renamed from: com.b.a.a.aa */
final class C8481aa {
    /* renamed from: ax */
    private static long m15060ax(long j) {
        AppMethodBeat.m2504i(55696);
        long offset = ((long) TimeZone.getDefault().getOffset(j)) + j;
        AppMethodBeat.m2505o(55696);
        return offset;
    }

    /* renamed from: ay */
    static long m15061ay(long j) {
        AppMethodBeat.m2504i(55697);
        long ax = C8481aa.m15060ax(j) / 1000;
        AppMethodBeat.m2505o(55697);
        return ax;
    }
}
