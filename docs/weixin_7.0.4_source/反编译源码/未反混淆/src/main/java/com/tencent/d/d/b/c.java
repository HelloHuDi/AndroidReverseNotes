package com.tencent.d.d.b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class c {
    private static Object Atg;
    private static Method Ath;
    private static boolean Ati;

    static {
        AppMethodBeat.i(114521);
        Atg = null;
        Ath = null;
        if (VERSION.SDK_INT >= 14) {
            try {
                Atg = e.iB("libcore.io.Libcore", "os");
                Ath = e.a("libcore.io.Os", "stat", String.class);
                Ati = true;
                AppMethodBeat.o(114521);
                return;
            } catch (Throwable th) {
            }
        }
        Ati = false;
        AppMethodBeat.o(114521);
    }

    public static boolean isAvailable() {
        return Ati;
    }

    public static int atS(String str) {
        AppMethodBeat.i(114520);
        if (Ati) {
            Object invoke = Ath.invoke(Atg, new Object[]{str});
            if (invoke == null) {
                AppMethodBeat.o(114520);
                return 0;
            }
            int intValue = ((Integer) e.a(invoke.getClass(), "st_mode", invoke)).intValue();
            AppMethodBeat.o(114520);
            return intValue;
        }
        AppMethodBeat.o(114520);
        return 0;
    }
}
