package com.tencent.mm.plugin.expt.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.e.c;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {
    public static boolean bqW() {
        AppMethodBeat.i(73520);
        c.bru();
        if (bo.getInt(c.a(com.tencent.mm.plugin.expt.a.a.a.clicfg_weixin_rpt_mm_app_mgr, "", false), 0) > 0) {
            AppMethodBeat.o(73520);
            return true;
        }
        AppMethodBeat.o(73520);
        return false;
    }

    public static boolean bqX() {
        AppMethodBeat.i(73521);
        c.bru();
        if (bo.getInt(c.a(com.tencent.mm.plugin.expt.a.a.a.clicfg_weixin_rpt_mm_life_call, "", false), 0) > 0) {
            AppMethodBeat.o(73521);
            return true;
        }
        AppMethodBeat.o(73521);
        return false;
    }

    public static boolean bqY() {
        AppMethodBeat.i(73522);
        c.bru();
        if (bo.getInt(c.a(com.tencent.mm.plugin.expt.a.a.a.clicfg_weixin_rpt_mm_hell_hound, "", false), 0) > 0) {
            AppMethodBeat.o(73522);
            return true;
        }
        AppMethodBeat.o(73522);
        return false;
    }

    public static int b(com.tencent.mm.plugin.expt.a.a.a aVar) {
        AppMethodBeat.i(73523);
        c.bru();
        int i = bo.getInt(c.a(aVar, "", false), 0);
        AppMethodBeat.o(73523);
        return i;
    }
}
