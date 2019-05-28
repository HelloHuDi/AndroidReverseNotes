package com.tencent.ttpic.gameplaysdk.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class GPLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    public static final boolean isLoggable(int i) {
        return false;
    }

    public static final void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(83223);
        if (isLoggable(3)) {
            String.format(str2, objArr);
            AppMethodBeat.o(83223);
            return;
        }
        AppMethodBeat.o(83223);
    }

    public static final void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(83224);
        if (isLoggable(3)) {
            String.format(str2, objArr);
            AppMethodBeat.o(83224);
            return;
        }
        AppMethodBeat.o(83224);
    }

    public static final void debug(int i, String str, String str2) {
        AppMethodBeat.i(83225);
        if (!isLoggable(3)) {
            AppMethodBeat.o(83225);
        } else if (str2 == null) {
            AppMethodBeat.o(83225);
        } else {
            AppMethodBeat.o(83225);
        }
    }

    public static final void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(83226);
        if (isLoggable(3)) {
            String.format(str2, objArr);
            AppMethodBeat.o(83226);
            return;
        }
        AppMethodBeat.o(83226);
    }

    public static final void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(83227);
        if (isLoggable(3)) {
            String.format(str2, objArr);
            AppMethodBeat.o(83227);
            return;
        }
        AppMethodBeat.o(83227);
    }

    public static final void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(83228);
        if (isLoggable(3)) {
            String.format(str2, objArr);
            AppMethodBeat.o(83228);
            return;
        }
        AppMethodBeat.o(83228);
    }
}
