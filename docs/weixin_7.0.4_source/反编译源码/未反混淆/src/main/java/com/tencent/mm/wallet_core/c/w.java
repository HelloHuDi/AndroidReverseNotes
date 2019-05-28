package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class w {
    private static String AfQ = "";
    private static long kfQ = 0;
    private static String tyv = "";

    public static void setTimeStamp(String str) {
        AppMethodBeat.i(49083);
        tyv = str;
        kfQ = System.currentTimeMillis() / 1000;
        AfQ = bo.dpG().toString();
        AppMethodBeat.o(49083);
    }

    public static boolean dNQ() {
        AppMethodBeat.i(49084);
        long fp = bo.fp(kfQ);
        ab.d("MicroMsg.TimeStampHelper", "pass time ".concat(String.valueOf(fp)));
        if (fp > 300) {
            AppMethodBeat.o(49084);
            return true;
        }
        AppMethodBeat.o(49084);
        return false;
    }

    public static String dNR() {
        AppMethodBeat.i(49085);
        if (bo.isNullOrNil(tyv) || b.dnO()) {
            ab.i("MicroMsg.TimeStampHelper", "getTimeStamp is null from %s isOverdue %s update_time: %s", AfQ, Boolean.valueOf(dNQ()), Long.valueOf(kfQ));
        }
        String str = tyv;
        AppMethodBeat.o(49085);
        return str;
    }
}
