package com.google.android.exoplayer2.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public static boolean DEBUG = true;
    private static a bdW = null;

    public static void a(a aVar) {
        bdW = aVar;
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(95227);
        if (bdW != null) {
            bdW.i(str, str2, objArr);
        }
        AppMethodBeat.o(95227);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(95228);
        if (bdW != null) {
            bdW.w(str, str2, objArr);
        }
        AppMethodBeat.o(95228);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(95229);
        if (bdW != null) {
            bdW.e(str, str2, objArr);
        }
        AppMethodBeat.o(95229);
    }
}
