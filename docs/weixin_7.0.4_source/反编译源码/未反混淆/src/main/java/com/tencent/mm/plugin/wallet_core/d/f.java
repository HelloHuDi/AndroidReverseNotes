package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.aa;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import java.util.ArrayList;

public final class f extends j<aa> {
    public static final String[] fnj = new String[]{j.a(aa.ccO, "WalletKindInfo")};
    public e bSd;

    static {
        AppMethodBeat.i(47076);
        AppMethodBeat.o(47076);
    }

    public f(e eVar) {
        super(eVar, aa.ccO, "WalletKindInfo", null);
        this.bSd = eVar;
    }

    public final ArrayList<aa> cRg() {
        ArrayList<aa> arrayList = null;
        AppMethodBeat.i(47075);
        Cursor a = this.bSd.a("select * from WalletKindInfo", null, 2);
        if (a == null) {
            AppMethodBeat.o(47075);
        } else {
            if (a.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    aa aaVar = new aa();
                    aaVar.d(a);
                    arrayList.add(aaVar);
                } while (a.moveToNext());
            }
            a.close();
            AppMethodBeat.o(47075);
        }
        return arrayList;
    }
}
