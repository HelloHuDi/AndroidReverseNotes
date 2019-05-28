package com.tencent.mm.plugin.walletlock.gesture.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;

public final class b {
    public static boolean cTz() {
        AppMethodBeat.i(51547);
        boolean booleanValue = ((Boolean) g.RP().Ry().get(a.USERINFO_WALLETLOCK_GESTURE_IS_OPENED_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(51547);
        return booleanValue;
    }

    public static void nx(boolean z) {
        AppMethodBeat.i(51548);
        ab.i("MicroMsg.GestureGuardManager", "alvinluo setUserSetGesturePwd: %b", Boolean.valueOf(z));
        g.RP().Ry().set(a.USERINFO_WALLETLOCK_GESTURE_IS_OPENED_BOOLEAN_SYNC, Boolean.valueOf(z));
        g.RP().Ry().dsb();
        AppMethodBeat.o(51548);
    }

    public static boolean cTA() {
        AppMethodBeat.i(51549);
        g cTB = d.cTB();
        ab.v("MicroMsg.GestureUtil", "alvinluo timeInfo: %d, %d", Long.valueOf(cTB.tVD), Long.valueOf(cTB.tVE));
        if (cTB.tVD != -1) {
            e.a(cTB);
            if (cTB.tVE / 1000 < 600) {
                d.ac(cTB.tVD, cTB.tVE);
                AppMethodBeat.o(51549);
                return true;
            }
            d.cTC();
        }
        AppMethodBeat.o(51549);
        return false;
    }
}
