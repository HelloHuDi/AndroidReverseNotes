package com.tencent.mm.am;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;

public final class h extends ai {
    public final String getTag() {
        return "MicroMsg.App.SyncTopConversation";
    }

    public final boolean kw(int i) {
        return i != 0 && i < 620758015;
    }

    public final void transfer(int i) {
        AppMethodBeat.i(16436);
        ab.d("MicroMsg.App.SyncTopConversation", "the previous version is %d", Integer.valueOf(i));
        com.tencent.mm.plugin.report.service.h.pYm.k(336, 15, 1);
        aw.ZK();
        com.tencent.mm.cd.h Ru = c.Ru();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select username from rconversation");
        stringBuilder.append(" where flag & 4611686018427387904 != 0");
        ab.d("MicroMsg.App.SyncTopConversation", "sql:%s", stringBuilder);
        Cursor a = Ru.a(stringBuilder.toString(), null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                ab.v("MicroMsg.App.SyncTopConversation", "userName %s", a.getString(0));
                t.w(r1, false);
            }
            a.close();
        }
        AppMethodBeat.o(16436);
    }
}
