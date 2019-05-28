package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class l {
    public static int Yv() {
        AppMethodBeat.i(16271);
        if (g.RK()) {
            int i;
            Cursor dsS = ((j) g.K(j.class)).XR().dsS();
            if (dsS == null || dsS.getCount() <= 0) {
                i = 0;
            } else {
                dsS.moveToFirst();
                i = dsS.getInt(0);
            }
            if (dsS != null) {
                dsS.close();
            }
            AppMethodBeat.o(16271);
            return i;
        }
        ab.w("MicroMsg.BottleConversationLogic", "get Bottle Total Conversation Unread, but has not set uin");
        AppMethodBeat.o(16271);
        return 0;
    }
}
