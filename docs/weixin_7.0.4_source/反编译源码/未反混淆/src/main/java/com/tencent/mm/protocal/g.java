package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class g {
    public static void gu(int i, int i2) {
        AppMethodBeat.i(56666);
        if (i >= 0) {
            h.pYm.a(320, (long) (i + i2), 1, true);
        }
        AppMethodBeat.o(56666);
    }
}
