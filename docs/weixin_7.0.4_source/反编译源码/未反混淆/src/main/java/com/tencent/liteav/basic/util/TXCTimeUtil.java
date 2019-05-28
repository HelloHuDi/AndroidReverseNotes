package com.tencent.liteav.basic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXCTimeUtil {
    private static native long nativeGetTimeTick();

    private static native long nativeGetUtcTimeTick();

    public static long getTimeTick() {
        AppMethodBeat.i(66038);
        long nativeGetTimeTick = nativeGetTimeTick();
        AppMethodBeat.o(66038);
        return nativeGetTimeTick;
    }

    public static long getUtcTimeTick() {
        AppMethodBeat.i(66039);
        long nativeGetUtcTimeTick = nativeGetUtcTimeTick();
        AppMethodBeat.o(66039);
        return nativeGetUtcTimeTick;
    }

    static {
        AppMethodBeat.i(66040);
        b.e();
        AppMethodBeat.o(66040);
    }
}
