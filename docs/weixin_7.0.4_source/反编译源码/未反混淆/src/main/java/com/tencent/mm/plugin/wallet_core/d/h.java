package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public final class h extends j<ad> {
    public static final String[] fnj = new String[]{j.a(ad.ccO, "WalletPrefInfo")};
    private e bSd;

    static {
        AppMethodBeat.i(47083);
        AppMethodBeat.o(47083);
    }

    public h(e eVar) {
        super(eVar, ad.ccO, "WalletPrefInfo", null);
        this.bSd = eVar;
    }

    public final ad acO(String str) {
        ad adVar = null;
        AppMethodBeat.i(47081);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(47081);
        } else {
            Cursor a = this.bSd.a("select * from WalletPrefInfo where pref_key=?", new String[]{str}, 2);
            if (a == null) {
                AppMethodBeat.o(47081);
            } else {
                if (a.moveToFirst()) {
                    adVar = new ad();
                    adVar.d(a);
                }
                a.close();
                AppMethodBeat.o(47081);
            }
        }
        return adVar;
    }

    public final boolean acP(String str) {
        AppMethodBeat.i(47082);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(47082);
            return false;
        }
        boolean hY = this.bSd.hY("WalletPrefInfo", "delete from WalletPrefInfo where pref_key='" + str + "'");
        AppMethodBeat.o(47082);
        return hY;
    }
}
