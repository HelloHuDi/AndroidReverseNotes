package com.tencent.p177mm.compatible.p223i;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.compatible.i.b */
public final class C1436b {
    private static int euG = 0;

    /* renamed from: Ml */
    public static boolean m3061Ml() {
        AppMethodBeat.m2504i(93055);
        if (euG == 0) {
            SharedPreferences doB = C4996ah.doB();
            if (doB == null || !doB.getBoolean("settings_support_swipe", true)) {
                euG = 2;
            } else {
                euG = 1;
            }
        }
        if (euG == 1) {
            AppMethodBeat.m2505o(93055);
            return true;
        }
        AppMethodBeat.m2505o(93055);
        return false;
    }

    /* renamed from: bK */
    public static void m3062bK(boolean z) {
        AppMethodBeat.m2504i(93056);
        SharedPreferences doB = C4996ah.doB();
        if (doB.getBoolean("settings_support_swipe", true) != z) {
            doB.edit().putBoolean("settings_support_swipe", z).commit();
        }
        C4990ab.m7417i("MicroMsg.StyleUtil", "switchSwipebackMode, from %B to %B", Boolean.valueOf(r1), Boolean.valueOf(z));
        AppMethodBeat.m2505o(93056);
    }
}
