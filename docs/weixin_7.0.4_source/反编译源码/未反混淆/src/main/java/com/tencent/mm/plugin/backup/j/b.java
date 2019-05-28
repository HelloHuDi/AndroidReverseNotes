package com.tencent.mm.plugin.backup.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.c;

public final class b {
    private static b jDg;
    c gRa;
    c jDe;
    c jDf;

    public static b aVg() {
        AppMethodBeat.i(18107);
        if (jDg == null) {
            jDg = new b();
        }
        b bVar = jDg;
        AppMethodBeat.o(18107);
        return bVar;
    }
}
