package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class i extends j<ag> {
    public static final String[] fnj = new String[]{j.a(ag.ccO, "WalletRegionGreyAreaList")};
    private e bSd;

    static {
        AppMethodBeat.i(47086);
        AppMethodBeat.o(47086);
    }

    public i(e eVar) {
        super(eVar, ag.ccO, "WalletRegionGreyAreaList", null);
        this.bSd = eVar;
    }

    public final void a(int i, bjg bjg) {
        AppMethodBeat.i(47084);
        ag agVar = new ag();
        agVar.field_wallet_region = i;
        try {
            agVar.field_wallet_grey_item_buf = bjg.toByteArray();
        } catch (Exception e) {
            ab.e("MicroMsg.WalletRegionGreyItemStg", "setWalletRegionGreyItem error " + e.getMessage());
        }
        super.a(agVar);
        AppMethodBeat.o(47084);
    }

    public final ag Ht(int i) {
        AppMethodBeat.i(47085);
        String concat = "select * from WalletRegionGreyAreaList where wallet_region = ".concat(String.valueOf(i));
        Cursor a = this.bSd.a(concat, null, 2);
        ab.i("MicroMsg.WalletRegionGreyItemStg", "getWalletRegionGreyItem ".concat(String.valueOf(concat)));
        ag agVar;
        if (a == null) {
            agVar = new ag();
            AppMethodBeat.o(47085);
            return agVar;
        }
        agVar = new ag();
        if (a.moveToNext()) {
            agVar = new ag();
            agVar.d(a);
        }
        ab.i("MicroMsg.WalletRegionGreyItemStg", "get grey item ");
        a.close();
        AppMethodBeat.o(47085);
        return agVar;
    }
}
