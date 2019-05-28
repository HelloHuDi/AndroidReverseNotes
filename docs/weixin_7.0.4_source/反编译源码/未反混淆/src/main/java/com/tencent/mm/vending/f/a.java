package com.tencent.mm.vending.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static a zXJ = null;

    public interface a {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static void a(a aVar) {
        zXJ = aVar;
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(126138);
        if (zXJ != null) {
            zXJ.e(str, str2, objArr);
        }
        AppMethodBeat.o(126138);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(126139);
        if (zXJ != null) {
            zXJ.w(str, str2, objArr);
        }
        AppMethodBeat.o(126139);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(126140);
        if (zXJ != null) {
            zXJ.i(str, str2, objArr);
        }
        AppMethodBeat.o(126140);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(126141);
        if (zXJ != null) {
            zXJ.d(str, str2, objArr);
        }
        AppMethodBeat.o(126141);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(126142);
        if (zXJ != null) {
            zXJ.printErrStackTrace(str, th, str2, objArr);
        }
        AppMethodBeat.o(126142);
    }
}
