package com.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.TimeZone;

final class aa {
    private static long ax(long j) {
        AppMethodBeat.i(55696);
        long offset = ((long) TimeZone.getDefault().getOffset(j)) + j;
        AppMethodBeat.o(55696);
        return offset;
    }

    static long ay(long j) {
        AppMethodBeat.i(55697);
        long ax = ax(j) / 1000;
        AppMethodBeat.o(55697);
        return ax;
    }
}
