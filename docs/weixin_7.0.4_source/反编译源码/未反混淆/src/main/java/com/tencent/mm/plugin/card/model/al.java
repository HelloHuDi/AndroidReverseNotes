package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class al extends j<ak> {
    public static final String[] fnj = new String[]{j.a(ak.ccO, "PendingCardId")};
    e bSd;

    static {
        AppMethodBeat.i(87929);
        AppMethodBeat.o(87929);
    }

    public al(e eVar) {
        super(eVar, ak.ccO, "PendingCardId", null);
        this.bSd = eVar;
    }

    public final List<ak> baU() {
        AppMethodBeat.i(87928);
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.a("select * from PendingCardId where retryCount < 10", null, 2);
        while (a.moveToNext()) {
            ak akVar = new ak();
            akVar.d(a);
            arrayList.add(akVar);
        }
        a.close();
        ab.d("MicroMsg.PendingCardIdInfoStorage", "getAll, count = %d", Integer.valueOf(arrayList.size()));
        AppMethodBeat.o(87928);
        return arrayList;
    }
}
