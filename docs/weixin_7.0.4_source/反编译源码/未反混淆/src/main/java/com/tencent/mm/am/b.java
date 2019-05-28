package com.tencent.mm.am;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends ai {
    public final boolean kw(int i) {
        return i != 0 && i < 637735215;
    }

    public final String getTag() {
        return "MicroMsg.App.BizPlaceTopDataTransfer";
    }

    public final void transfer(int i) {
        AppMethodBeat.i(16430);
        ab.d("MicroMsg.App.BizPlaceTopDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (kw(i)) {
            ab.i("MicroMsg.App.BizPlaceTopDataTransfer", "begin biz place to top data transfer.");
            long currentTimeMillis = System.currentTimeMillis();
            h.pYm.a(336, 0, 1, true);
            aw.ZK();
            com.tencent.mm.cd.h Ru = c.Ru();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select conv.username");
            stringBuilder.append(" from ");
            stringBuilder.append("rconversation");
            stringBuilder.append(" as conv, ");
            stringBuilder.append("rcontact");
            stringBuilder.append(" as ct ");
            stringBuilder.append(" where conv.");
            stringBuilder.append("parentRef");
            stringBuilder.append("='");
            stringBuilder.append("officialaccounts");
            stringBuilder.append("' and conv.");
            stringBuilder.append("username");
            stringBuilder.append(" = ct.");
            stringBuilder.append("username");
            stringBuilder.append(" and ct.");
            stringBuilder.append("verifyFlag");
            stringBuilder.append(" & ");
            stringBuilder.append(8);
            stringBuilder.append(" = 0");
            ab.v("MicroMsg.App.BizPlaceTopDataTransfer", "transfer query sql(%s)", stringBuilder.toString());
            Cursor a = Ru.a(r0, null, 2);
            if (a == null) {
                ab.i("MicroMsg.App.BizPlaceTopDataTransfer", "cursor is null.");
                AppMethodBeat.o(16430);
                return;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            ab.i("MicroMsg.App.BizPlaceTopDataTransfer", "do biz place to top data transfer, query cost : %s msec.", Long.valueOf(currentTimeMillis2 - currentTimeMillis));
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("update ");
            stringBuilder2.append("rconversation");
            stringBuilder2.append(" set ");
            stringBuilder2.append("parentRef");
            stringBuilder2.append("='' where ");
            stringBuilder2.append("username");
            stringBuilder2.append(" in (");
            if (a.moveToFirst()) {
                h.pYm.a(336, 1, 1, true);
                stringBuilder2.append("'");
                stringBuilder2.append(a.getString(0));
                stringBuilder2.append("'");
                int i2 = 1;
                while (a.moveToNext()) {
                    stringBuilder2.append(",");
                    stringBuilder2.append("'");
                    stringBuilder2.append(a.getString(0));
                    stringBuilder2.append("'");
                    i2++;
                }
                stringBuilder2.append(")");
                String stringBuilder3 = stringBuilder2.toString();
                ab.i("MicroMsg.App.BizPlaceTopDataTransfer", "transfer update count(%d)", Integer.valueOf(i2));
                ab.v("MicroMsg.App.BizPlaceTopDataTransfer", "transfer update sql(%s)", stringBuilder3);
                a.close();
                if (Ru.hY("rconversation", stringBuilder2.toString())) {
                    h.pYm.a(336, 2, 1, true);
                } else {
                    h.pYm.a(336, 3, 1, true);
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                ab.i("MicroMsg.App.BizPlaceTopDataTransfer", "do biz place to top data transfer, update cost : %s msec,  total cost : %s msec.", Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis3 - currentTimeMillis));
            } else {
                a.close();
                ab.i("MicroMsg.App.BizPlaceTopDataTransfer", "cursor count is 0.");
                AppMethodBeat.o(16430);
                return;
            }
        }
        AppMethodBeat.o(16430);
    }
}
