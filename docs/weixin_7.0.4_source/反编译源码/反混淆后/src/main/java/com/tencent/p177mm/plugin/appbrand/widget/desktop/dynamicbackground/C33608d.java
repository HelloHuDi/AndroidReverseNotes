package com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.C2545b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.d */
public final class C33608d {
    private static SharedPreferences ehZ = C4996ah.doB();
    private static boolean iZB = false;
    private static boolean iZC = false;
    private static boolean iZD = true;

    static {
        AppMethodBeat.m2504i(133973);
        AppMethodBeat.m2505o(133973);
    }

    public static boolean aPI() {
        return iZD;
    }

    public static boolean aPJ() {
        AppMethodBeat.m2504i(133965);
        if (ehZ != null) {
            int i = ehZ.getInt("dynamic_bg_init_start_point_count", 0);
            int i2 = ehZ.getInt("dynamic_bg_draw_start_point_count", 0);
            boolean z = ehZ.getBoolean("dynamic_bg_init_crash", false);
            iZC = z;
            if (z || i >= 2 || i2 >= 2) {
                iZB = true;
                ehZ.edit().putBoolean("dynamic_bg_will_crash", true).apply();
                AppMethodBeat.m2505o(133965);
                return true;
            }
            iZB = false;
            AppMethodBeat.m2505o(133965);
            return false;
        }
        AppMethodBeat.m2505o(133965);
        return false;
    }

    public static void aPK() {
        AppMethodBeat.m2504i(133966);
        if (ehZ != null) {
            Editor edit = ehZ.edit();
            if (edit != null) {
                edit.putInt("dynamic_bg_init_start_point_count", 0);
                edit.putInt("dynamic_bg_draw_start_point_count", 0);
                edit.putBoolean("dynamic_bg_init_crash", false);
                edit.putBoolean("dynamic_bg_will_crash", false);
                edit.apply();
            }
        }
        iZC = false;
        iZB = false;
        AppMethodBeat.m2505o(133966);
    }

    public static void aPL() {
        AppMethodBeat.m2504i(133967);
        C2545b.m4793eT(false);
        if (ehZ == null) {
            ehZ = C4996ah.doB();
        }
        if (ehZ != null) {
            ehZ.edit().putBoolean("dynamic_bg_init_crash", true).apply();
        }
        iZC = true;
        AppMethodBeat.m2505o(133967);
    }

    public static void aPM() {
        AppMethodBeat.m2504i(133968);
        if (ehZ == null) {
            ehZ = C4996ah.doB();
        }
        if (ehZ != null) {
            C2545b.m4793eT(false);
            ehZ.edit().putBoolean("dynamic_bg_will_crash", true).apply();
        }
        iZB = true;
        AppMethodBeat.m2505o(133968);
    }

    public static boolean aPN() {
        return iZC;
    }

    public static void aPO() {
        AppMethodBeat.m2504i(133969);
        if (ehZ == null) {
            ehZ = C4996ah.doB();
        }
        if (ehZ != null) {
            int i = ehZ.getInt("dynamic_bg_init_start_point_count", 0);
            C4990ab.m7417i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitStartPoint current: %d", Integer.valueOf(i));
            if (i > 2) {
                C2545b.m4793eT(false);
                ehZ.edit().putBoolean("dynamic_bg_will_crash", true).apply();
            }
            ehZ.edit().putInt("dynamic_bg_init_start_point_count", i + 1).apply();
        }
        AppMethodBeat.m2505o(133969);
    }

    public static void aPP() {
        AppMethodBeat.m2504i(133970);
        C4990ab.m7416i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitEndPoint");
        ehZ.edit().putInt("dynamic_bg_init_start_point_count", 0).apply();
        ehZ.edit().putBoolean("dynamic_bg_will_crash", false).apply();
        ehZ.edit().putBoolean("dynamic_bg_init_crash", false).apply();
        iZB = false;
        iZC = false;
        C2545b.m4793eT(true);
        AppMethodBeat.m2505o(133970);
    }

    public static void aPQ() {
        AppMethodBeat.m2504i(133971);
        if (ehZ == null) {
            ehZ = C4996ah.doB();
        }
        if (ehZ != null) {
            int i = ehZ.getInt("dynamic_bg_draw_start_point_count", 0);
            C4990ab.m7417i("MicroMsg.DynamicBgCrashHelper", "alvinluo markDrawStartPoint current: %d", Integer.valueOf(i));
            if (i > 2) {
                C2545b.m4793eT(false);
                ehZ.edit().putBoolean("dynamic_bg_will_crash", true).apply();
            }
            ehZ.edit().putInt("dynamic_bg_draw_start_point_count", i + 1).apply();
        }
        AppMethodBeat.m2505o(133971);
    }

    public static void aPR() {
        AppMethodBeat.m2504i(133972);
        C4990ab.m7416i("MicroMsg.DynamicBgCrashHelper", "alvinluo markDrawEndPoint");
        ehZ.edit().putInt("dynamic_bg_draw_start_point_count", 0).apply();
        ehZ.edit().putBoolean("dynamic_bg_will_crash", false).apply();
        C2545b.m4793eT(true);
        iZD = false;
        AppMethodBeat.m2505o(133972);
    }

    public static boolean aPS() {
        return iZB;
    }
}
