package com.tencent.mm.plugin.shake.d.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class o extends j<n> {
    public static final String[] diI = new String[0];
    public static final String[] fnj = new String[]{j.a(n.ccO, "shaketvhistory")};
    public e bSd;

    static {
        AppMethodBeat.i(24679);
        AppMethodBeat.o(24679);
    }

    public o(e eVar) {
        super(eVar, n.ccO, "shaketvhistory", fnj);
        this.bSd = eVar;
    }

    public final Cursor cky() {
        AppMethodBeat.i(24678);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM shaketvhistory ORDER BY createtime DESC");
        Cursor rawQuery = this.bSd.rawQuery(stringBuilder.toString(), null);
        AppMethodBeat.o(24678);
        return rawQuery;
    }
}
