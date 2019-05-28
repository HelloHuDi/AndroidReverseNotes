package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;

public final class ac {
    public static void Zr() {
        AppMethodBeat.i(16275);
        Cursor dsu = c.XM().dsu();
        String str = "MicroMsg.HardCodeUpdateTask";
        String str2 = "[unstarAllBizContactFor50] size:%s";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(dsu == null ? 0 : dsu.getCount());
        ab.i(str, str2, objArr);
        if (dsu.moveToFirst()) {
            do {
                ad adVar = new ad();
                adVar.d(dsu);
                adVar.NN();
                c.XM().b(adVar.field_username, adVar);
            } while (dsu.moveToNext());
        }
        dsu.close();
        AppMethodBeat.o(16275);
    }
}
