package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    private static a eEg = null;

    public interface a {
        void d(String str, String str2);

        void e(String str, String str2);

        void i(String str, String str2);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);
    }

    public static void a(a aVar) {
        eEg = aVar;
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(93919);
        if (eEg != null) {
            eEg.i(str, str2);
        }
        AppMethodBeat.o(93919);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(93920);
        if (HardCoderJNI.isHcDebug() && eEg != null) {
            eEg.d(str, str2);
        }
        AppMethodBeat.o(93920);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(93921);
        if (eEg != null) {
            eEg.e(str, str2);
        }
        AppMethodBeat.o(93921);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(93922);
        if (eEg != null) {
            eEg.printErrStackTrace(str, th, str2, objArr);
        }
        AppMethodBeat.o(93922);
    }
}
