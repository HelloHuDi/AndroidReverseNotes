package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class n {
    public static void IO(int i) {
        int i2;
        AppMethodBeat.i(6856);
        if (2 == i) {
            i2 = 11;
        } else if (1 == i) {
            i2 = 10;
        } else {
            i2 = -1;
        }
        if (-1 == i2) {
            AppMethodBeat.o(6856);
            return;
        }
        h.pYm.a(238, (long) i2, 1, false);
        AppMethodBeat.o(6856);
    }

    public static void lQ(long j) {
        AppMethodBeat.i(6857);
        h.pYm.a(238, j, 1, false);
        AppMethodBeat.o(6857);
    }
}
