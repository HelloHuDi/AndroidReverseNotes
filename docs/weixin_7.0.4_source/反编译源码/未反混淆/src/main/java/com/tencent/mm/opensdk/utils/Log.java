package com.tencent.mm.opensdk.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Log {
    private static ILog logImpl;

    public static void d(String str, String str2) {
        AppMethodBeat.i(128066);
        if (logImpl == null) {
            AppMethodBeat.o(128066);
            return;
        }
        logImpl.d(str, str2);
        AppMethodBeat.o(128066);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(128069);
        if (logImpl == null) {
            AppMethodBeat.o(128069);
            return;
        }
        logImpl.e(str, str2);
        AppMethodBeat.o(128069);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(128067);
        if (logImpl == null) {
            AppMethodBeat.o(128067);
            return;
        }
        logImpl.i(str, str2);
        AppMethodBeat.o(128067);
    }

    public static void setLogImpl(ILog iLog) {
        logImpl = iLog;
    }

    public static void v(String str, String str2) {
        AppMethodBeat.i(128065);
        if (logImpl == null) {
            AppMethodBeat.o(128065);
            return;
        }
        logImpl.v(str, str2);
        AppMethodBeat.o(128065);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(128068);
        if (logImpl == null) {
            AppMethodBeat.o(128068);
            return;
        }
        logImpl.w(str, str2);
        AppMethodBeat.o(128068);
    }
}
