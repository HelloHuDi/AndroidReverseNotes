package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class ag {
    public static boolean a = false;
    public static boolean b = false;

    public static void a(String str, Object... objArr) {
        AppMethodBeat.i(98416);
        if (!((a ? 1 : null) == null || str == null)) {
            if (objArr == null || objArr.length == 0) {
                AppMethodBeat.o(98416);
                return;
            }
            String.format(Locale.US, str, objArr);
        }
        AppMethodBeat.o(98416);
    }

    public static void b(String str, Object... objArr) {
        AppMethodBeat.i(98417);
        if (!((a ? 1 : null) == null || str == null)) {
            if (objArr == null || objArr.length == 0) {
                AppMethodBeat.o(98417);
                return;
            }
            String.format(Locale.US, str, objArr);
        }
        AppMethodBeat.o(98417);
    }

    public static void c(String str, Object... objArr) {
        AppMethodBeat.i(98418);
        if (str != null) {
            if (objArr == null || objArr.length == 0) {
                AppMethodBeat.o(98418);
                return;
            }
            String.format(Locale.US, str, objArr);
        }
        AppMethodBeat.o(98418);
    }

    public static void d(String str, Object... objArr) {
        AppMethodBeat.i(98419);
        if (str != null) {
            if (objArr == null || objArr.length == 0) {
                AppMethodBeat.o(98419);
                return;
            }
            String.format(Locale.US, str, objArr);
        }
        AppMethodBeat.o(98419);
    }

    public static void a(Throwable th) {
        AppMethodBeat.i(98420);
        if (th != null && (th instanceof Throwable)) {
            if ((a ? 1 : 0) != 0) {
                AppMethodBeat.o(98420);
                return;
            }
            d(th.getMessage(), new Object[0]);
        }
        AppMethodBeat.o(98420);
    }

    private static void a(String str, String str2, Object... objArr) {
        AppMethodBeat.i(98421);
        if (!((a ? 1 : null) == null || str2 == null)) {
            if (objArr == null || objArr.length == 0) {
                AppMethodBeat.o(98421);
                return;
            }
            String.format(Locale.US, str2, objArr);
        }
        AppMethodBeat.o(98421);
    }

    public static void e(String str, Object... objArr) {
        AppMethodBeat.i(98422);
        a("beacon_step_api", str, objArr);
        AppMethodBeat.o(98422);
    }

    public static void f(String str, Object... objArr) {
        AppMethodBeat.i(98423);
        a("beacon_step_buffer", str, objArr);
        AppMethodBeat.o(98423);
    }

    public static void g(String str, Object... objArr) {
        AppMethodBeat.i(98424);
        a("beacon_step_db", str, objArr);
        AppMethodBeat.o(98424);
    }

    public static void h(String str, Object... objArr) {
        AppMethodBeat.i(98425);
        a("beacon_step_upload", str, objArr);
        AppMethodBeat.o(98425);
    }
}
