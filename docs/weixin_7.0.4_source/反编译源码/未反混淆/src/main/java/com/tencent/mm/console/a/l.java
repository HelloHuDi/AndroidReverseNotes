package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.x.c;

public final class l implements a {
    static {
        AppMethodBeat.i(16147);
        b.a(new l(), "//pay");
        AppMethodBeat.o(16147);
    }

    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(16146);
        if (strArr.length < 2) {
            AppMethodBeat.o(16146);
            return true;
        }
        String str2 = strArr[1];
        int i = -1;
        switch (str2.hashCode()) {
            case -1943286194:
                if (str2.equals("forcenewcashier")) {
                    i = 3;
                    break;
                }
                break;
            case -1326045846:
                if (str2.equals("dorder")) {
                    i = 0;
                    break;
                }
                break;
            case 99657:
                if (str2.equals("dot")) {
                    i = 2;
                    break;
                }
                break;
            case 174797075:
                if (str2.equals("sethassource")) {
                    boolean i2 = true;
                    break;
                }
                break;
        }
        switch (i2) {
            case 0:
                d.H(context, "wallet", ".pwd.ui.WalletUniversalPayOrderUI");
                AppMethodBeat.o(16146);
                return true;
            case 1:
                g.RP().Ry().set(ac.a.USERINFO_LUCKY_MONEY_ENVELOPE_HAS_SOURCE_INT_SYNC, Integer.valueOf(1));
                AppMethodBeat.o(16146);
                return true;
            case 2:
                c.PK().b(ac.a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, true);
                AppMethodBeat.o(16146);
                return true;
            case 3:
                if (strArr.length >= 3) {
                    g.RP().Ry().set(ac.a.USERINFO_FORCE_USE_NEW_CASHIER_INT_SYNC, Integer.valueOf(bo.getInt(strArr[2], 0)));
                }
                AppMethodBeat.o(16146);
                return true;
            default:
                AppMethodBeat.o(16146);
                return false;
        }
    }

    public static void init() {
    }
}
