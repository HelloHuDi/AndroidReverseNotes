package com.tencent.mm.svg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    private static a ydv = null;

    public interface a {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);
    }

    public static void b(a aVar) {
        ydv = aVar;
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(70128);
        if (ydv != null) {
            ydv.e(str, str2, objArr);
        }
        AppMethodBeat.o(70128);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(70129);
        if (ydv != null) {
            ydv.i(str, str2, objArr);
        }
        AppMethodBeat.o(70129);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(70130);
        if (ydv != null) {
            ydv.d(str, str2, objArr);
        }
        AppMethodBeat.o(70130);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(70131);
        if (ydv != null) {
            ydv.printErrStackTrace(str, th, str2, objArr);
        }
        AppMethodBeat.o(70131);
    }
}
