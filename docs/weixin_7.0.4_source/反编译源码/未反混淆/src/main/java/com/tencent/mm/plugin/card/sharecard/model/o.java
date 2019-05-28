package com.tencent.mm.plugin.card.sharecard.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class o extends j<n> {
    public static final String[] fnj = new String[]{j.a(n.ccO, "ShareCardSyncItemInfo")};
    private e bSd;

    static {
        AppMethodBeat.i(88088);
        AppMethodBeat.o(88088);
    }

    public o(e eVar) {
        super(eVar, n.ccO, "ShareCardSyncItemInfo", null);
        this.bSd = eVar;
    }

    public final List<n> baU() {
        AppMethodBeat.i(88087);
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.a("select * from ShareCardSyncItemInfo where retryCount < 10", null, 2);
        while (a.moveToNext()) {
            n nVar = new n();
            nVar.d(a);
            arrayList.add(nVar);
        }
        a.close();
        ab.d("MicroMsg.ShareCardSyncItemInfoStorage", "getAll, share card count = %d", Integer.valueOf(arrayList.size()));
        AppMethodBeat.o(88087);
        return arrayList;
    }
}
