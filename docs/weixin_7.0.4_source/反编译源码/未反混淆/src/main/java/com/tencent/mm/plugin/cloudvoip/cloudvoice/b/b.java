package com.tencent.mm.plugin.cloudvoip.cloudvoice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class b {
    public static int bgo() {
        AppMethodBeat.i(135467);
        if (ab.dos() != null) {
            int logLevel = ab.dos().getLogLevel();
            AppMethodBeat.o(135467);
            return logLevel;
        }
        AppMethodBeat.o(135467);
        return 0;
    }
}
