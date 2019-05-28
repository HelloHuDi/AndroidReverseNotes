package com.tencent.mm.plugin.webview.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public enum a {
    ;

    private a(String str) {
    }

    static {
        AppMethodBeat.o(10131);
    }

    public static void a(String str, long j, int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(10130);
        if (j <= 0) {
            AppMethodBeat.o(10130);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - j;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str).append(",");
        stringBuilder.append(i2).append(",");
        stringBuilder.append(i);
        stringBuilder.append(",").append(i3).append(",").append(currentTimeMillis).append(",").append(i4).append(",").append(i5);
        ab.i("MicroMsg.AuthReport", stringBuilder.toString());
        h.pYm.e(16488, str, Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3), Long.valueOf(currentTimeMillis), Integer.valueOf(i4), Integer.valueOf(0), Integer.valueOf(i5));
        AppMethodBeat.o(10130);
    }
}
