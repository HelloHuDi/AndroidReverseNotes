package com.tencent.p177mm.plugin.walletlock.gesture.p1059a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.walletlock.gesture.a.b */
public final class C40175b {
    public static boolean cTz() {
        AppMethodBeat.m2504i(51547);
        boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLETLOCK_GESTURE_IS_OPENED_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        AppMethodBeat.m2505o(51547);
        return booleanValue;
    }

    /* renamed from: nx */
    public static void m68909nx(boolean z) {
        AppMethodBeat.m2504i(51548);
        C4990ab.m7417i("MicroMsg.GestureGuardManager", "alvinluo setUserSetGesturePwd: %b", Boolean.valueOf(z));
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLETLOCK_GESTURE_IS_OPENED_BOOLEAN_SYNC, Boolean.valueOf(z));
        C1720g.m3536RP().mo5239Ry().dsb();
        AppMethodBeat.m2505o(51548);
    }

    public static boolean cTA() {
        AppMethodBeat.m2504i(51549);
        C14394g cTB = C40176d.cTB();
        C4990ab.m7419v("MicroMsg.GestureUtil", "alvinluo timeInfo: %d, %d", Long.valueOf(cTB.tVD), Long.valueOf(cTB.tVE));
        if (cTB.tVD != -1) {
            C46391e.m87260a(cTB);
            if (cTB.tVE / 1000 < 600) {
                C40176d.m68913ac(cTB.tVD, cTB.tVE);
                AppMethodBeat.m2505o(51549);
                return true;
            }
            C40176d.cTC();
        }
        AppMethodBeat.m2505o(51549);
        return false;
    }
}
