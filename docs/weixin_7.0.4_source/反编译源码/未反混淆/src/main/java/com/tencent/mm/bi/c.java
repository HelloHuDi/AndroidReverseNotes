package com.tencent.mm.bi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ax;

public final class c {
    public static long q(String str, long j) {
        AppMethodBeat.i(16618);
        long j2 = 0;
        if (str != null) {
            ax apw = d.akO().apw(str);
            if (apw != null) {
                j2 = apw.field_createTime + 1;
            }
        }
        if (j2 > j * 1000) {
            AppMethodBeat.o(16618);
            return j2;
        }
        j2 = j * 1000;
        AppMethodBeat.o(16618);
        return j2;
    }

    public static void e(long j, String str) {
        AppMethodBeat.i(16619);
        ab.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, rowId: %d, talker: %s", Long.valueOf(j), str);
        ab.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fconversation, ret = ".concat(String.valueOf(d.akP().p(j, str))));
        ab.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fmsginfo, ret = ".concat(String.valueOf(d.akO().QS(str))));
        AppMethodBeat.o(16619);
    }
}
