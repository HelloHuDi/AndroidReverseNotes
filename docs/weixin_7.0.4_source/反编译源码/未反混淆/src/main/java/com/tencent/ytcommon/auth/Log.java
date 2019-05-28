package com.tencent.ytcommon.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Log {
    public static void e(String str, String str2) {
        boolean z = Config.DEBUG;
    }

    public static void w(String str, String str2) {
        boolean z = Config.DEBUG;
    }

    public static void d(String str, Object obj) {
        AppMethodBeat.i(19);
        if (Config.DEBUG) {
            String.valueOf(obj);
            AppMethodBeat.o(19);
            return;
        }
        AppMethodBeat.o(19);
    }

    public static void d(String str, String str2, Throwable th) {
        if (!Config.DEBUG) {
        }
    }
}
