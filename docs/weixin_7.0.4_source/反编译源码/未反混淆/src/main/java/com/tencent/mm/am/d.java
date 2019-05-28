package com.tencent.mm.am;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import java.util.LinkedList;

public final class d extends ai {
    public final boolean kw(int i) {
        return i != 0 && i < 620757033;
    }

    public final void transfer(int i) {
        AppMethodBeat.i(16432);
        ab.d("MicroMsg.DataTransfer.BlackListConvDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (i != 0 && i < 620757033) {
            h.pYm.k(336, 13, 1);
            LinkedList<String> linkedList = new LinkedList();
            aw.ZK();
            Cursor d = c.XM().d("@black.android", "", null);
            if (d != null) {
                d.moveToFirst();
                while (!d.isAfterLast()) {
                    ad adVar = new ad();
                    adVar.d(d);
                    linkedList.add(adVar.field_username);
                    d.moveToNext();
                }
                d.close();
            }
            if (linkedList.size() > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Update rconversation");
                stringBuilder.append(" set parentRef = '@blacklist' where 1 != 1 ");
                for (String append : linkedList) {
                    stringBuilder.append(" or username = '").append(append).append("'");
                }
                ab.d("MicroMsg.DataTransfer.BlackListConvDataTransfer", "update sql: %s", stringBuilder.toString());
                aw.ZK();
                c.Ru().hY("rconversation", append);
            }
        }
        AppMethodBeat.o(16432);
    }

    public final String getTag() {
        return "MicroMsg.DataTransfer.BlackListConvDataTransfer";
    }
}
