package com.tencent.p177mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.p321l.C19541k.C19544c;
import com.tencent.p177mm.plugin.appbrand.p322m.C10619c;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.appbrand.af */
public final class C42330af {
    private static C19544c gQD = new C100501();
    private static C19544c gQE = new C267202();

    /* renamed from: com.tencent.mm.plugin.appbrand.af$1 */
    static class C100501 implements C19544c {
        C100501() {
        }

        /* renamed from: xj */
        public final boolean mo21412xj(String str) {
            AppMethodBeat.m2504i(129158);
            if (C10619c.m18306CU(str)) {
                C4990ab.m7416i("MicroMsg.WcWssSwitchLogic", "isWcWssOpen : true for hardcode case");
                AppMethodBeat.m2505o(129158);
                return true;
            }
            boolean access$000 = C42330af.access$000();
            AppMethodBeat.m2505o(129158);
            return access$000;
        }

        public final boolean auB() {
            AppMethodBeat.m2504i(129159);
            boolean access$100 = C42330af.access$100();
            AppMethodBeat.m2505o(129159);
            return access$100;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.af$2 */
    static class C267202 implements C19544c {
        C267202() {
        }

        /* renamed from: xj */
        public final boolean mo21412xj(String str) {
            AppMethodBeat.m2504i(129160);
            boolean access$000 = C42330af.access$000();
            AppMethodBeat.m2505o(129160);
            return access$000;
        }

        public final boolean auB() {
            AppMethodBeat.m2504i(129161);
            boolean access$100 = C42330af.access$100();
            AppMethodBeat.m2505o(129161);
            return access$100;
        }
    }

    static {
        AppMethodBeat.m2504i(129165);
        AppMethodBeat.m2505o(129165);
    }

    public static C19544c auy() {
        return gQD;
    }

    public static C19544c auz() {
        return gQE;
    }

    private static Boolean auA() {
        AppMethodBeat.m2504i(129162);
        String string = C4996ah.doC().getString("appbrandgame_open_wcwss", "");
        Boolean bool;
        if (string != null && string.equalsIgnoreCase("wcwss")) {
            bool = Boolean.TRUE;
            AppMethodBeat.m2505o(129162);
            return bool;
        } else if (string == null || !string.equalsIgnoreCase("websocket")) {
            AppMethodBeat.m2505o(129162);
            return null;
        } else {
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(129162);
            return bool;
        }
    }

    static /* synthetic */ boolean access$000() {
        boolean booleanValue;
        AppMethodBeat.m2504i(129163);
        Boolean auA = C42330af.auA();
        if (auA != null) {
            booleanValue = auA.booleanValue();
        } else {
            booleanValue = ((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_appbrand_socket_wcwss, false);
        }
        C4990ab.m7417i("MicroMsg.WcWssSwitchLogic", "isWcWssOpen : %b", Boolean.valueOf(booleanValue));
        AppMethodBeat.m2505o(129163);
        return booleanValue;
    }

    static /* synthetic */ boolean access$100() {
        boolean booleanValue;
        AppMethodBeat.m2504i(129164);
        Boolean auA = C42330af.auA();
        if (auA != null) {
            booleanValue = auA.booleanValue();
        } else {
            booleanValue = ((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_appbrand_game_socket_wcwss, false);
        }
        C4990ab.m7417i("MicroMsg.WcWssSwitchLogic", "isGameABTestOpen : %b", Boolean.valueOf(booleanValue));
        AppMethodBeat.m2505o(129164);
        return booleanValue;
    }
}
