package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class l extends j<k> {
    public static final String[] fnj = new String[]{j.a(k.ccO, "IPCallRecord")};
    static final String[] nzF = new String[]{"*", "rowid"};
    public e bSd;

    static {
        AppMethodBeat.i(21947);
        AppMethodBeat.o(21947);
    }

    public l(e eVar) {
        super(eVar, k.ccO, "IPCallRecord", null);
        this.bSd = eVar;
    }

    public final Cursor OU(String str) {
        AppMethodBeat.i(21943);
        Cursor query = this.bSd.query("IPCallRecord", nzF, "phonenumber=?", new String[]{str}, null, null, "calltime desc limit 4");
        AppMethodBeat.o(21943);
        return query;
    }

    public final Cursor OV(String str) {
        AppMethodBeat.i(21944);
        Cursor query = this.bSd.query("IPCallRecord", nzF, "phonenumber=?", new String[]{str}, null, null, "calltime desc");
        AppMethodBeat.o(21944);
        return query;
    }

    public final Cursor iX(long j) {
        AppMethodBeat.i(21945);
        Cursor query = this.bSd.query("IPCallRecord", nzF, "addressId=?", new String[]{String.valueOf(j)}, null, null, "calltime desc");
        AppMethodBeat.o(21945);
        return query;
    }

    public final void a(k kVar) {
        AppMethodBeat.i(21946);
        if (kVar != null) {
            a(kVar.xDa, (c) kVar);
        }
        AppMethodBeat.o(21946);
    }
}
