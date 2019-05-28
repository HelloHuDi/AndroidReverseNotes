package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class d {
    private static SharedPreferences ehZ = ah.doB();
    private static boolean iZB = false;
    private static boolean iZC = false;
    private static boolean iZD = true;

    static {
        AppMethodBeat.i(133973);
        AppMethodBeat.o(133973);
    }

    public static boolean aPI() {
        return iZD;
    }

    public static boolean aPJ() {
        AppMethodBeat.i(133965);
        if (ehZ != null) {
            int i = ehZ.getInt("dynamic_bg_init_start_point_count", 0);
            int i2 = ehZ.getInt("dynamic_bg_draw_start_point_count", 0);
            boolean z = ehZ.getBoolean("dynamic_bg_init_crash", false);
            iZC = z;
            if (z || i >= 2 || i2 >= 2) {
                iZB = true;
                ehZ.edit().putBoolean("dynamic_bg_will_crash", true).apply();
                AppMethodBeat.o(133965);
                return true;
            }
            iZB = false;
            AppMethodBeat.o(133965);
            return false;
        }
        AppMethodBeat.o(133965);
        return false;
    }

    public static void aPK() {
        AppMethodBeat.i(133966);
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
        AppMethodBeat.o(133966);
    }

    public static void aPL() {
        AppMethodBeat.i(133967);
        b.eT(false);
        if (ehZ == null) {
            ehZ = ah.doB();
        }
        if (ehZ != null) {
            ehZ.edit().putBoolean("dynamic_bg_init_crash", true).apply();
        }
        iZC = true;
        AppMethodBeat.o(133967);
    }

    public static void aPM() {
        AppMethodBeat.i(133968);
        if (ehZ == null) {
            ehZ = ah.doB();
        }
        if (ehZ != null) {
            b.eT(false);
            ehZ.edit().putBoolean("dynamic_bg_will_crash", true).apply();
        }
        iZB = true;
        AppMethodBeat.o(133968);
    }

    public static boolean aPN() {
        return iZC;
    }

    public static void aPO() {
        AppMethodBeat.i(133969);
        if (ehZ == null) {
            ehZ = ah.doB();
        }
        if (ehZ != null) {
            int i = ehZ.getInt("dynamic_bg_init_start_point_count", 0);
            ab.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitStartPoint current: %d", Integer.valueOf(i));
            if (i > 2) {
                b.eT(false);
                ehZ.edit().putBoolean("dynamic_bg_will_crash", true).apply();
            }
            ehZ.edit().putInt("dynamic_bg_init_start_point_count", i + 1).apply();
        }
        AppMethodBeat.o(133969);
    }

    public static void aPP() {
        AppMethodBeat.i(133970);
        ab.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitEndPoint");
        ehZ.edit().putInt("dynamic_bg_init_start_point_count", 0).apply();
        ehZ.edit().putBoolean("dynamic_bg_will_crash", false).apply();
        ehZ.edit().putBoolean("dynamic_bg_init_crash", false).apply();
        iZB = false;
        iZC = false;
        b.eT(true);
        AppMethodBeat.o(133970);
    }

    public static void aPQ() {
        AppMethodBeat.i(133971);
        if (ehZ == null) {
            ehZ = ah.doB();
        }
        if (ehZ != null) {
            int i = ehZ.getInt("dynamic_bg_draw_start_point_count", 0);
            ab.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markDrawStartPoint current: %d", Integer.valueOf(i));
            if (i > 2) {
                b.eT(false);
                ehZ.edit().putBoolean("dynamic_bg_will_crash", true).apply();
            }
            ehZ.edit().putInt("dynamic_bg_draw_start_point_count", i + 1).apply();
        }
        AppMethodBeat.o(133971);
    }

    public static void aPR() {
        AppMethodBeat.i(133972);
        ab.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markDrawEndPoint");
        ehZ.edit().putInt("dynamic_bg_draw_start_point_count", 0).apply();
        ehZ.edit().putBoolean("dynamic_bg_will_crash", false).apply();
        b.eT(true);
        iZD = false;
        AppMethodBeat.o(133972);
    }

    public static boolean aPS() {
        return iZB;
    }
}
