package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;

public final class f {
    public static void k(int i, String str, int i2) {
        AppMethodBeat.i(94486);
        ab.i("MicroMsg.SNS.SnsReportLogic", "snsRedDotAction 16172 report %s", String.format("%s,%s,%s,%s", new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis())}));
        e.pXa.X(16172, r0);
        AppMethodBeat.o(94486);
    }
}
