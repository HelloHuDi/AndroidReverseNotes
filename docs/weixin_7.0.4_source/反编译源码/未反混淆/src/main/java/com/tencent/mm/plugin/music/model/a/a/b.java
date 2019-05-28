package com.tencent.mm.plugin.music.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.ag;

public final class b {
    public static String Tm(String str) {
        AppMethodBeat.i(104961);
        e bTQ = k.bUf().oLX.bTQ();
        String str2;
        if (bTQ == null || !str.equalsIgnoreCase(bTQ.fJU)) {
            str2 = "0_" + ag.ck(str);
            AppMethodBeat.o(104961);
            return str2;
        }
        str2 = com.tencent.mm.plugin.music.h.b.K(bTQ);
        AppMethodBeat.o(104961);
        return str2;
    }
}
