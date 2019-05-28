package com.tencent.mm.plugin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {
    public static void wz(String str) {
        AppMethodBeat.i(123480);
        ah.getContext().getSharedPreferences(ah.doA(), 0).edit().putString("reg_last_exit_ui", str).commit();
        AppMethodBeat.o(123480);
    }

    public static String FP() {
        AppMethodBeat.i(123481);
        String string = ah.getContext().getSharedPreferences(ah.doA(), 0).getString("reg_last_exit_ui", "");
        AppMethodBeat.o(123481);
        return string;
    }

    public static void wA(String str) {
        AppMethodBeat.i(123482);
        ah.getContext().getSharedPreferences(ah.doA(), 0).edit().putString("reg_next_enter_ui", str).commit();
        AppMethodBeat.o(123482);
    }

    private static String arO() {
        AppMethodBeat.i(123483);
        String string = ah.getContext().getSharedPreferences(ah.doA(), 0).getString("reg_next_enter_ui", "");
        AppMethodBeat.o(123483);
        return string;
    }

    public static void wB(String str) {
        AppMethodBeat.i(123484);
        e.pXa.a(10645, str + "," + bo.anU() + "," + FP(), true, true);
        AppMethodBeat.o(123484);
    }

    public static void f(boolean z, String str) {
        String str2;
        AppMethodBeat.i(123485);
        if (z) {
            str2 = str + "," + bo.anU() + "," + FP();
        } else {
            str2 = str + "," + bo.anU() + "," + arO();
        }
        e.pXa.a(10645, str2, true, true);
        AppMethodBeat.o(123485);
    }
}
