package com.tencent.mm.plugin.music.model.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class d extends j<c> {
    public e bSd;
    public f<String, c> oNq = new c(20);

    public d(e eVar) {
        super(eVar, c.ccO, "PieceMusicInfo", null);
        AppMethodBeat.i(105041);
        this.bSd = eVar;
        AppMethodBeat.o(105041);
    }

    public final c Tq(String str) {
        AppMethodBeat.i(105042);
        c cVar;
        if (this.oNq.get(str) != null) {
            cVar = (c) this.oNq.get(str);
            AppMethodBeat.o(105042);
            return cVar;
        }
        String format = String.format("Select * From PieceMusicInfo Where musicId=?", new Object[0]);
        Cursor a = this.bSd.a(format, new String[]{str}, 2);
        if (a == null || !a.moveToFirst()) {
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(105042);
            return null;
        }
        cVar = new c();
        cVar.d(a);
        a.close();
        this.oNq.put(str, cVar);
        AppMethodBeat.o(105042);
        return cVar;
    }
}
