package com.tencent.mm.compatible.i;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class b {
    private static int euG = 0;

    public static boolean Ml() {
        AppMethodBeat.i(93055);
        if (euG == 0) {
            SharedPreferences doB = ah.doB();
            if (doB == null || !doB.getBoolean("settings_support_swipe", true)) {
                euG = 2;
            } else {
                euG = 1;
            }
        }
        if (euG == 1) {
            AppMethodBeat.o(93055);
            return true;
        }
        AppMethodBeat.o(93055);
        return false;
    }

    public static void bK(boolean z) {
        AppMethodBeat.i(93056);
        SharedPreferences doB = ah.doB();
        if (doB.getBoolean("settings_support_swipe", true) != z) {
            doB.edit().putBoolean("settings_support_swipe", z).commit();
        }
        ab.i("MicroMsg.StyleUtil", "switchSwipebackMode, from %B to %B", Boolean.valueOf(r1), Boolean.valueOf(z));
        AppMethodBeat.o(93056);
    }
}
