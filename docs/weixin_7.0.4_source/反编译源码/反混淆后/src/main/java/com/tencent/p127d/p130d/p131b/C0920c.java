package com.tencent.p127d.p130d.p131b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

/* renamed from: com.tencent.d.d.b.c */
public final class C0920c {
    private static Object Atg;
    private static Method Ath;
    private static boolean Ati;

    static {
        AppMethodBeat.m2504i(114521);
        Atg = null;
        Ath = null;
        if (VERSION.SDK_INT >= 14) {
            try {
                Atg = C17727e.m27654iB("libcore.io.Libcore", "os");
                Ath = C17727e.m27651a("libcore.io.Os", "stat", String.class);
                Ati = true;
                AppMethodBeat.m2505o(114521);
                return;
            } catch (Throwable th) {
            }
        }
        Ati = false;
        AppMethodBeat.m2505o(114521);
    }

    public static boolean isAvailable() {
        return Ati;
    }

    public static int atS(String str) {
        AppMethodBeat.m2504i(114520);
        if (Ati) {
            Object invoke = Ath.invoke(Atg, new Object[]{str});
            if (invoke == null) {
                AppMethodBeat.m2505o(114520);
                return 0;
            }
            int intValue = ((Integer) C17727e.m27650a(invoke.getClass(), "st_mode", invoke)).intValue();
            AppMethodBeat.m2505o(114520);
            return intValue;
        }
        AppMethodBeat.m2505o(114520);
        return 0;
    }
}
