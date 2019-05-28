package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.l.k.c;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class af {
    private static c gQD = new c() {
        public final boolean xj(String str) {
            AppMethodBeat.i(129158);
            if (com.tencent.mm.plugin.appbrand.m.c.CU(str)) {
                ab.i("MicroMsg.WcWssSwitchLogic", "isWcWssOpen : true for hardcode case");
                AppMethodBeat.o(129158);
                return true;
            }
            boolean access$000 = af.access$000();
            AppMethodBeat.o(129158);
            return access$000;
        }

        public final boolean auB() {
            AppMethodBeat.i(129159);
            boolean access$100 = af.access$100();
            AppMethodBeat.o(129159);
            return access$100;
        }
    };
    private static c gQE = new c() {
        public final boolean xj(String str) {
            AppMethodBeat.i(129160);
            boolean access$000 = af.access$000();
            AppMethodBeat.o(129160);
            return access$000;
        }

        public final boolean auB() {
            AppMethodBeat.i(129161);
            boolean access$100 = af.access$100();
            AppMethodBeat.o(129161);
            return access$100;
        }
    };

    static {
        AppMethodBeat.i(129165);
        AppMethodBeat.o(129165);
    }

    public static c auy() {
        return gQD;
    }

    public static c auz() {
        return gQE;
    }

    private static Boolean auA() {
        AppMethodBeat.i(129162);
        String string = ah.doC().getString("appbrandgame_open_wcwss", "");
        Boolean bool;
        if (string != null && string.equalsIgnoreCase("wcwss")) {
            bool = Boolean.TRUE;
            AppMethodBeat.o(129162);
            return bool;
        } else if (string == null || !string.equalsIgnoreCase("websocket")) {
            AppMethodBeat.o(129162);
            return null;
        } else {
            bool = Boolean.FALSE;
            AppMethodBeat.o(129162);
            return bool;
        }
    }

    static /* synthetic */ boolean access$000() {
        boolean booleanValue;
        AppMethodBeat.i(129163);
        Boolean auA = auA();
        if (auA != null) {
            booleanValue = auA.booleanValue();
        } else {
            booleanValue = ((a) g.K(a.class)).a(a.a.clicfg_appbrand_socket_wcwss, false);
        }
        ab.i("MicroMsg.WcWssSwitchLogic", "isWcWssOpen : %b", Boolean.valueOf(booleanValue));
        AppMethodBeat.o(129163);
        return booleanValue;
    }

    static /* synthetic */ boolean access$100() {
        boolean booleanValue;
        AppMethodBeat.i(129164);
        Boolean auA = auA();
        if (auA != null) {
            booleanValue = auA.booleanValue();
        } else {
            booleanValue = ((a) g.K(a.class)).a(a.a.clicfg_appbrand_game_socket_wcwss, false);
        }
        ab.i("MicroMsg.WcWssSwitchLogic", "isGameABTestOpen : %b", Boolean.valueOf(booleanValue));
        AppMethodBeat.o(129164);
        return booleanValue;
    }
}
