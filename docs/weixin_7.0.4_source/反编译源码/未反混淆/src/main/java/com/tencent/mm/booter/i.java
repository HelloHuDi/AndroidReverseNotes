package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;

public final class i {
    public static boolean Iv() {
        AppMethodBeat.i(15852);
        try {
            aw.ZK();
            ah.d((Long) c.Ry().get(66817, null));
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.PostTaskMediaNoteStat", e, "", new Object[0]);
        }
        if (ah.fp(0) * 1000 > 1800000) {
            AppMethodBeat.o(15852);
            return true;
        }
        AppMethodBeat.o(15852);
        return false;
    }
}
