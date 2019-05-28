package com.tencent.liteav.basic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXCTimeUtil {
    private static native long nativeGetTimeTick();

    private static native long nativeGetUtcTimeTick();

    public static long getTimeTick() {
        AppMethodBeat.m2504i(66038);
        long nativeGetTimeTick = nativeGetTimeTick();
        AppMethodBeat.m2505o(66038);
        return nativeGetTimeTick;
    }

    public static long getUtcTimeTick() {
        AppMethodBeat.m2504i(66039);
        long nativeGetUtcTimeTick = nativeGetUtcTimeTick();
        AppMethodBeat.m2505o(66039);
        return nativeGetUtcTimeTick;
    }

    static {
        AppMethodBeat.m2504i(66040);
        C17778b.m27756e();
        AppMethodBeat.m2505o(66040);
    }
}
