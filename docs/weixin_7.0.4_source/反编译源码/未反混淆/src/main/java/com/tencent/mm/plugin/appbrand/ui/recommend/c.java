package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.storage.ac;

public final class c {
    public static boolean aNE() {
        AppMethodBeat.i(133562);
        if (((a) g.K(a.class)).a(a.a.clicfg_app_brand_recommend_enter_switch, 0) > 0) {
            AppMethodBeat.o(133562);
            return true;
        }
        AppMethodBeat.o(133562);
        return false;
    }

    public static boolean aNF() {
        AppMethodBeat.i(133563);
        if (((Integer) g.RP().Ry().get(ac.a.USERINFO_APP_BRAND_RECOMMEND_DATA_STATE_INT_SYNC, Integer.valueOf(0))).intValue() == 1) {
            AppMethodBeat.o(133563);
            return true;
        }
        AppMethodBeat.o(133563);
        return false;
    }
}
