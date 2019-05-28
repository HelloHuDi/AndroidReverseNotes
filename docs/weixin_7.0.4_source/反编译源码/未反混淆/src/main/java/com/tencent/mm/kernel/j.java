package com.tencent.mm.kernel;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class j {
    private static long eKJ;
    private static long eKK;
    private static volatile a eKL = null;

    public interface a {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static void q(long j, long j2) {
        eKJ = j;
        eKK = j2;
    }

    public static void h(String str, long j) {
        AppMethodBeat.i(123266);
        long nanoTime = System.nanoTime() - j;
        ab.i("Blink-LOG", "since the %s : %s", str, Long.valueOf(nanoTime));
        AppMethodBeat.o(123266);
    }

    public static void jD(String str) {
        AppMethodBeat.i(123267);
        long elapsedRealtime = SystemClock.elapsedRealtime() - eKK;
        ab.i("Blink-LOG", "since startup %s : %s", str, Long.valueOf(elapsedRealtime));
        String.format("since startup %s : %s", new Object[]{str, Long.valueOf(elapsedRealtime)});
        AppMethodBeat.o(123267);
    }

    public static void a(a aVar) {
        eKL = aVar;
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(123268);
        if (eKL != null) {
            eKL.e(str, str2, objArr);
        }
        AppMethodBeat.o(123268);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(123269);
        if (eKL != null) {
            eKL.w(str, str2, objArr);
        }
        AppMethodBeat.o(123269);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(123270);
        if (eKL != null) {
            eKL.i(str, str2, objArr);
        }
        AppMethodBeat.o(123270);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(123271);
        if (eKL != null) {
            eKL.d(str, str2, objArr);
        }
        AppMethodBeat.o(123271);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(123272);
        if (eKL != null) {
            eKL.printErrStackTrace(str, th, str2, objArr);
        }
        AppMethodBeat.o(123272);
    }

    public static void RU() {
    }
}
