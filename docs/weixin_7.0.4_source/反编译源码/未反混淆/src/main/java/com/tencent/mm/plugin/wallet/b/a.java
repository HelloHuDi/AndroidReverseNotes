package com.tencent.mm.plugin.wallet.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {
    public static boolean Hn(int i) {
        AppMethodBeat.i(46462);
        g.RQ();
        if (((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_LOAN_ENTRANCE_RED_POINT_INT, Integer.valueOf(-1))).intValue() >= i || i <= 0) {
            AppMethodBeat.o(46462);
            return false;
        }
        AppMethodBeat.o(46462);
        return true;
    }

    public static boolean cOQ() {
        boolean z;
        AppMethodBeat.i(46463);
        l lVar = (l) g.K(l.class);
        ab.i("MicroMsg.WalletUtil", "mgr==null?" + (lVar == null));
        if (lVar != null) {
            ab.i("MicroMsg.WalletUtil", " mgr.isSupportAndLoadSuccess()=" + lVar.bxs());
        }
        s.cNC();
        ak cND = s.cND();
        ai cQo = cND.cQo();
        String str = "MicroMsg.WalletUtil";
        StringBuilder stringBuilder = new StringBuilder("config==null?");
        if (cQo == null) {
            z = true;
        } else {
            z = false;
        }
        ab.i(str, stringBuilder.append(z).toString());
        if (cQo != null) {
            ab.i("MicroMsg.WalletUtil", "config.isSupportTouchPay()=" + cQo.cPY());
        }
        ab.i("MicroMsg.WalletUtil", "userInfoManger.isReg()=" + cND.cQg());
        if (lVar != null && lVar.bxs() && cQo != null && cQo.cPY() && cND.cQg()) {
            AppMethodBeat.o(46463);
            return true;
        }
        AppMethodBeat.o(46463);
        return false;
    }

    public static boolean cOR() {
        AppMethodBeat.i(46464);
        l lVar = (l) g.K(l.class);
        if (lVar == null) {
            ab.w("MicroMsg.WalletUtil", "no finger mgr!");
            AppMethodBeat.o(46464);
            return false;
        }
        s.cNC();
        ak cND = s.cND();
        ai cQo = cND.cQo();
        h.pYm.k(916, 0, 1);
        ab.i("MicroMsg.WalletUtil", "support faceid: %s, %s, %s", Boolean.valueOf(lVar.bxA()), Boolean.valueOf(cQo.cPY()), Boolean.valueOf(cND.cQg()));
        if (lVar.bxA() && cQo.cPY() && cND.cQg()) {
            AppMethodBeat.o(46464);
            return true;
        }
        AppMethodBeat.o(46464);
        return false;
    }
}
