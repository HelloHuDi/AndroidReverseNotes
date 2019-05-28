package com.tencent.mm.modelappbrand;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class b {
    public static String fpD;
    public static String fpE;

    public static String abv() {
        AppMethodBeat.i(114902);
        StringBuilder stringBuilder = new StringBuilder("sid_");
        g.RN();
        fpD = stringBuilder.append(a.QF()).append("_").append(bo.anU()).toString();
        ab.v("MicroMsg.AppBrandReporter", "refreshWeAppSearchSessionId : %s", fpD);
        String str = fpD;
        AppMethodBeat.o(114902);
        return str;
    }

    public static void pj(String str) {
        AppMethodBeat.i(114903);
        try {
            SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "pref_appbrand_process", 4);
            String str2 = str + ":start_time";
            Editor edit = sharedPreferences.edit();
            edit.remove(str2);
            edit.commit();
            e.pXa.a(365, 5, 1, false);
            ab.v("MicroMsg.AppBrandReporter", "onProcessExit");
            AppMethodBeat.o(114903);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.AppBrandReporter", th, "onProcessExit(%s)", str);
            AppMethodBeat.o(114903);
        }
    }

    public static long abw() {
        AppMethodBeat.i(114904);
        long currentTimeMillis;
        try {
            SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "pref_appbrand_process", 4);
            String str = ah.getProcessName() + ":start_time";
            currentTimeMillis = System.currentTimeMillis();
            if (sharedPreferences.contains(str)) {
                currentTimeMillis = sharedPreferences.getLong(str, currentTimeMillis);
                AppMethodBeat.o(114904);
                return currentTimeMillis;
            }
            AppMethodBeat.o(114904);
            return currentTimeMillis;
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.AppBrandReporter", th, "getProcessStartTime", new Object[0]);
            currentTimeMillis = System.currentTimeMillis();
            AppMethodBeat.o(114904);
            return currentTimeMillis;
        }
    }
}
