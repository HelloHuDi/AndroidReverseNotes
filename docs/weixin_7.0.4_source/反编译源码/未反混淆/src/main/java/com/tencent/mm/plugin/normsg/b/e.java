package com.tencent.mm.plugin.normsg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.Normsg.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class e {
    public static boolean oVb;

    static {
        AppMethodBeat.i(10438);
        oVb = false;
        long nanoTime = System.nanoTime();
        try {
            oVb = b.bVK();
            ab.i("MicroMsg.NormalMsgSource.DADH", "CDA, result: %b, time: %d ns", Boolean.valueOf(oVb), Long.valueOf(System.nanoTime() - nanoTime));
            AppMethodBeat.o(10438);
        } catch (Throwable th) {
            ab.i("MicroMsg.NormalMsgSource.DADH", "CDA, result: %b, time: %d ns", Boolean.valueOf(oVb), Long.valueOf(System.nanoTime() - nanoTime));
            AppMethodBeat.o(10438);
        }
    }
}
