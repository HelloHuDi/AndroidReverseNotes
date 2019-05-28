package com.tencent.mm.plugin.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;

public final class b {
    public static String XZ() {
        AppMethodBeat.i(111119);
        StringBuilder stringBuilder = new StringBuilder();
        g.RQ();
        String stringBuilder2 = stringBuilder.append(g.RP().eJM).append("recbiz/").toString();
        AppMethodBeat.o(111119);
        return stringBuilder2;
    }
}
