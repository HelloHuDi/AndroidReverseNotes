package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import java.util.HashMap;
import java.util.Map;

public final class g extends j<ab> {
    public static final String[] fnj = new String[]{j.a(ab.ccO, "WalletLuckyMoney")};
    public static Map<String, ab> gms = new HashMap();
    private e bSd;

    static {
        AppMethodBeat.i(47080);
        AppMethodBeat.o(47080);
    }

    public g(e eVar) {
        super(eVar, ab.ccO, "WalletLuckyMoney", null);
        this.bSd = eVar;
    }

    public final ab acN(String str) {
        AppMethodBeat.i(47077);
        Cursor rawQuery = this.bSd.rawQuery("select * from WalletLuckyMoney where mNativeUrl=?", new String[]{str});
        if (rawQuery == null) {
            AppMethodBeat.o(47077);
            return null;
        } else if (rawQuery.getCount() == 0) {
            rawQuery.close();
            AppMethodBeat.o(47077);
            return null;
        } else {
            rawQuery.moveToFirst();
            ab abVar = new ab();
            abVar.d(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(47077);
            return abVar;
        }
    }

    public final boolean a(ab abVar) {
        AppMethodBeat.i(47078);
        if (abVar != null && gms.containsKey(abVar.field_mNativeUrl)) {
            gms.put(abVar.field_mNativeUrl, abVar);
        }
        boolean a = super.a(abVar);
        AppMethodBeat.o(47078);
        return a;
    }
}
