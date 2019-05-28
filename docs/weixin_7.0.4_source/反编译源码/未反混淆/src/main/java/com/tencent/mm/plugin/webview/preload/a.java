package com.tencent.mm.plugin.webview.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {
    public static void kT(int i) {
        AppMethodBeat.i(80437);
        e(908, i, 1, true);
        AppMethodBeat.o(80437);
    }

    public static void IT(int i) {
        AppMethodBeat.i(80438);
        e(974, i, 1, false);
        AppMethodBeat.o(80438);
    }

    public static void gv(int i, int i2) {
        AppMethodBeat.i(80440);
        e(908, i, i2, true);
        AppMethodBeat.o(80440);
    }

    public static void e(int i, int i2, int i3, boolean z) {
        AppMethodBeat.i(80441);
        ab.i("ConstantsPreload", "id:%d, key:%d, valye:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        h.pYm.a((long) i, (long) i2, (long) i3, false);
        if (!(!z || i == 908 || i == 0)) {
            h.pYm.a(908, (long) i2, (long) i3, false);
        }
        h.pYm.e(15792, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(80441);
    }

    public static void IU(int i) {
        AppMethodBeat.i(80442);
        ae(i, 1);
        AppMethodBeat.o(80442);
    }

    public static void ae(int i, long j) {
        AppMethodBeat.i(80443);
        h.pYm.k(1009, (long) i, j);
        AppMethodBeat.o(80443);
    }

    public static void gu(int i, int i2) {
        AppMethodBeat.i(139080);
        e(i, i2, 1, true);
        AppMethodBeat.o(139080);
    }
}
