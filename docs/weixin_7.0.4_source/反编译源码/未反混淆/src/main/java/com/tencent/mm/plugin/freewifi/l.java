package com.tencent.mm.plugin.freewifi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class l {
    public static void v(String str, String str2, int i) {
        AppMethodBeat.i(20617);
        h.pYm.e(12651, Integer.valueOf(1), str, Integer.valueOf(0), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i));
        AppMethodBeat.o(20617);
    }

    public static void w(String str, String str2, int i) {
        AppMethodBeat.i(20618);
        h.pYm.e(12651, Integer.valueOf(2), str, Integer.valueOf(0), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i));
        AppMethodBeat.o(20618);
    }

    public static void x(String str, String str2, int i) {
        AppMethodBeat.i(20619);
        h.pYm.e(12651, Integer.valueOf(3), str, Integer.valueOf(0), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i));
        AppMethodBeat.o(20619);
    }

    public static void a(String str, String str2, int i, boolean z) {
        AppMethodBeat.i(20620);
        if (z) {
            h.pYm.e(12651, Integer.valueOf(4), str, Integer.valueOf(1), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i));
            AppMethodBeat.o(20620);
            return;
        }
        h.pYm.e(12651, Integer.valueOf(4), str, Integer.valueOf(0), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i));
        AppMethodBeat.o(20620);
    }

    public static void b(String str, String str2, int i, boolean z) {
        AppMethodBeat.i(20621);
        if (z) {
            h.pYm.e(12651, Integer.valueOf(5), str, Integer.valueOf(1), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i));
            AppMethodBeat.o(20621);
            return;
        }
        h.pYm.e(12651, Integer.valueOf(5), str, Integer.valueOf(0), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i));
        AppMethodBeat.o(20621);
    }
}
