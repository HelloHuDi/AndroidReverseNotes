package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class h extends j<g> {
    public static final String[] fnj = new String[]{j.a(g.ccO, "IPCallMsg")};
    private static final String[] nzC = new String[]{"*", "rowid"};
    public static int nzD = 0;
    public e bSd;

    static {
        AppMethodBeat.i(21935);
        AppMethodBeat.o(21935);
    }

    public h(e eVar) {
        super(eVar, g.ccO, "IPCallMsg", null);
        this.bSd = eVar;
    }

    public final Cursor xm(int i) {
        AppMethodBeat.i(21934);
        Cursor query = this.bSd.query("IPCallMsg", nzC, null, null, null, null, "pushTime desc limit ".concat(String.valueOf(i)));
        AppMethodBeat.o(21934);
        return query;
    }
}
