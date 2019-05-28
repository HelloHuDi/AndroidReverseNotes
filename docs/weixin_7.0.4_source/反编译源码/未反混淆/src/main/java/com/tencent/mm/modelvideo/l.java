package com.tencent.mm.modelvideo;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import java.util.LinkedList;
import java.util.List;

public final class l extends j<j> {
    public static final String[] fnj = new String[]{j.a(j.ccO, "SightDraftInfo")};
    e bSd;

    static {
        AppMethodBeat.i(50732);
        AppMethodBeat.o(50732);
    }

    public l(e eVar) {
        super(eVar, j.ccO, "SightDraftInfo", null);
        this.bSd = eVar;
    }

    public final List<j> alf() {
        AppMethodBeat.i(50730);
        LinkedList linkedList = new LinkedList();
        String str = "SELECT * FROM SightDraftInfo WHERE fileStatus = ?  ORDER BY localId DESC " + new StringBuilder(" LIMIT 5").toString();
        Cursor a = this.bSd.a(str, new String[]{"7"}, 2);
        if (a == null) {
            AppMethodBeat.o(50730);
        } else {
            while (a.moveToNext()) {
                j jVar = new j();
                jVar.d(a);
                linkedList.add(jVar);
            }
            a.close();
            AppMethodBeat.o(50730);
        }
        return linkedList;
    }

    public final Cursor alg() {
        AppMethodBeat.i(50731);
        Cursor rawQuery = this.bSd.rawQuery("SELECT * FROM SightDraftInfo WHERE fileStatus = ?  ORDER BY localId DESC ", new String[]{"1"});
        AppMethodBeat.o(50731);
        return rawQuery;
    }
}
