package com.tencent.p177mm.modelappbrand;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.MultiProcessSharedPreferences;

/* renamed from: com.tencent.mm.modelappbrand.b */
public final class C45445b {
    public static String fpD;
    public static String fpE;

    public static String abv() {
        AppMethodBeat.m2504i(114902);
        StringBuilder stringBuilder = new StringBuilder("sid_");
        C1720g.m3534RN();
        fpD = stringBuilder.append(C1668a.m3383QF()).append("_").append(C5046bo.anU()).toString();
        C4990ab.m7419v("MicroMsg.AppBrandReporter", "refreshWeAppSearchSessionId : %s", fpD);
        String str = fpD;
        AppMethodBeat.m2505o(114902);
        return str;
    }

    /* renamed from: pj */
    public static void m83711pj(String str) {
        AppMethodBeat.m2504i(114903);
        try {
            SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "pref_appbrand_process", 4);
            String str2 = str + ":start_time";
            Editor edit = sharedPreferences.edit();
            edit.remove(str2);
            edit.commit();
            C7053e.pXa.mo8378a(365, 5, 1, false);
            C4990ab.m7418v("MicroMsg.AppBrandReporter", "onProcessExit");
            AppMethodBeat.m2505o(114903);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandReporter", th, "onProcessExit(%s)", str);
            AppMethodBeat.m2505o(114903);
        }
    }

    public static long abw() {
        AppMethodBeat.m2504i(114904);
        long currentTimeMillis;
        try {
            SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "pref_appbrand_process", 4);
            String str = C4996ah.getProcessName() + ":start_time";
            currentTimeMillis = System.currentTimeMillis();
            if (sharedPreferences.contains(str)) {
                currentTimeMillis = sharedPreferences.getLong(str, currentTimeMillis);
                AppMethodBeat.m2505o(114904);
                return currentTimeMillis;
            }
            AppMethodBeat.m2505o(114904);
            return currentTimeMillis;
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandReporter", th, "getProcessStartTime", new Object[0]);
            currentTimeMillis = System.currentTimeMillis();
            AppMethodBeat.m2505o(114904);
            return currentTimeMillis;
        }
    }
}
