package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class a extends j<n> {
    public static final String[] fnj = new String[]{j.a(n.ccO, "LoanEntryInfo")};
    private e bSd;

    static {
        AppMethodBeat.i(47049);
        AppMethodBeat.o(47049);
    }

    public a(e eVar) {
        super(eVar, n.ccO, "LoanEntryInfo", null);
        this.bSd = eVar;
    }

    public final n cQZ() {
        n nVar = null;
        AppMethodBeat.i(47047);
        Cursor a = this.bSd.a("select * from LoanEntryInfo", null, 2);
        if (a == null) {
            AppMethodBeat.o(47047);
        } else {
            if (a.moveToFirst()) {
                nVar = new n();
                nVar.d(a);
            }
            a.close();
            AppMethodBeat.o(47047);
        }
        return nVar;
    }

    public final boolean apM() {
        AppMethodBeat.i(47048);
        boolean hY = this.bSd.hY("LoanEntryInfo", "delete from LoanEntryInfo");
        AppMethodBeat.o(47048);
        return hY;
    }
}
