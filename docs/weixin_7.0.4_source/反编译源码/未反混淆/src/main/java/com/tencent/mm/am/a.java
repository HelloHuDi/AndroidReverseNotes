package com.tencent.mm.am;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.z;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class a extends ai {
    public final boolean kw(int i) {
        return i != 0 && i < 604372991;
    }

    public final String getTag() {
        return "MicroMsg.App.BizInfoDataTransfer";
    }

    public final void transfer(int i) {
        AppMethodBeat.i(16429);
        ab.d("MicroMsg.App.BizInfoDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (i != 0 && i < 604372991) {
            h.pYm.k(336, 12, 1);
            aw.ZK();
            com.tencent.mm.cd.h Ru = c.Ru();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select BizInfo.username, BizInfo.extInfo");
            stringBuilder.append(" from rcontact , BizInfo");
            stringBuilder.append(" where rcontact.username = BizInfo.username");
            stringBuilder.append(" and (rcontact.type & 1 ) != 0 ");
            stringBuilder.append(" and ( rcontact.verifyFlag & 8 ) != 0 ");
            String stringBuilder2 = stringBuilder.toString();
            ArrayList<String> arrayList = new ArrayList();
            ab.d("MicroMsg.App.BizInfoDataTransfer", "sql %s", stringBuilder2);
            Cursor a = Ru.a(stringBuilder.toString(), null, 2);
            if (a != null) {
                while (a.moveToNext()) {
                    d dVar = new d();
                    dVar.d(a);
                    if (dVar.cJ(false).getServiceType() == 1) {
                        arrayList.add(dVar.field_username);
                    }
                }
                a.close();
            }
            if (arrayList.size() > 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Update BizInfo set type = 1 where 1 !=1 ");
                for (String append : arrayList) {
                    stringBuilder.append(" or username = '").append(append).append("'");
                }
                ab.d("MicroMsg.App.BizInfoDataTransfer", "update sql %s", stringBuilder.toString());
                z.aeR().hY("BizInfo", append);
            }
        }
        AppMethodBeat.o(16429);
    }
}
