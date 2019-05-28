package com.tencent.mm.plugin.scanner.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class a extends j<com.tencent.mm.plugin.scanner.history.a.a> {
    public static final String[] fnj = new String[]{j.a(com.tencent.mm.plugin.scanner.history.a.a.ccO, "ScanHistoryItem")};
    public e bSd;

    static {
        AppMethodBeat.i(80895);
        AppMethodBeat.o(80895);
    }

    public a(e eVar) {
        super(eVar, com.tencent.mm.plugin.scanner.history.a.a.ccO, "ScanHistoryItem", null);
        this.bSd = eVar;
    }

    public final Cursor baR() {
        AppMethodBeat.i(80894);
        Cursor rawQuery = this.bSd.rawQuery("select * from ScanHistoryItem order by ScanTime desc", null);
        AppMethodBeat.o(80894);
        return rawQuery;
    }
}
