package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class h extends j<g> {
    public static final String[] fnj = new String[]{j.a(g.ccO, "CardMsgInfo")};
    public e bSd;

    static {
        AppMethodBeat.i(87838);
        AppMethodBeat.o(87838);
    }

    public h(e eVar) {
        super(eVar, g.ccO, "CardMsgInfo", null);
        this.bSd = eVar;
    }

    public final Cursor baR() {
        AppMethodBeat.i(87835);
        Cursor rawQuery = this.bSd.rawQuery("select * from CardMsgInfo order by time desc", null);
        AppMethodBeat.o(87835);
        return rawQuery;
    }

    public final int baS() {
        int i = 0;
        AppMethodBeat.i(87836);
        Cursor a = this.bSd.a(" select count(*) from CardMsgInfo where read_state = ? ", new String[]{"1"}, 2);
        if (a == null) {
            AppMethodBeat.o(87836);
        } else {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
            AppMethodBeat.o(87836);
        }
        return i;
    }

    public final boolean baT() {
        AppMethodBeat.i(87837);
        boolean hY = this.bSd.hY("CardMsgInfo", " update CardMsgInfo set read_state = 0  where read_state = 1");
        AppMethodBeat.o(87837);
        return hY;
    }
}
