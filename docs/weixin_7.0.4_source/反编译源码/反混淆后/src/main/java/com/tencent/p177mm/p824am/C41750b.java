package com.tencent.p177mm.p824am;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1812ai;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.am.b */
public final class C41750b extends C1812ai {
    /* renamed from: kw */
    public final boolean mo5386kw(int i) {
        return i != 0 && i < 637735215;
    }

    public final String getTag() {
        return "MicroMsg.App.BizPlaceTopDataTransfer";
    }

    public final void transfer(int i) {
        AppMethodBeat.m2504i(16430);
        C4990ab.m7411d("MicroMsg.App.BizPlaceTopDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (mo5386kw(i)) {
            C4990ab.m7416i("MicroMsg.App.BizPlaceTopDataTransfer", "begin biz place to top data transfer.");
            long currentTimeMillis = System.currentTimeMillis();
            C7060h.pYm.mo8378a(336, 0, 1, true);
            C9638aw.m17190ZK();
            C7480h Ru = C18628c.m29069Ru();
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
            C4990ab.m7419v("MicroMsg.App.BizPlaceTopDataTransfer", "transfer query sql(%s)", stringBuilder.toString());
            Cursor a = Ru.mo10104a(r0, null, 2);
            if (a == null) {
                C4990ab.m7416i("MicroMsg.App.BizPlaceTopDataTransfer", "cursor is null.");
                AppMethodBeat.m2505o(16430);
                return;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            C4990ab.m7417i("MicroMsg.App.BizPlaceTopDataTransfer", "do biz place to top data transfer, query cost : %s msec.", Long.valueOf(currentTimeMillis2 - currentTimeMillis));
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("update ");
            stringBuilder2.append("rconversation");
            stringBuilder2.append(" set ");
            stringBuilder2.append("parentRef");
            stringBuilder2.append("='' where ");
            stringBuilder2.append("username");
            stringBuilder2.append(" in (");
            if (a.moveToFirst()) {
                C7060h.pYm.mo8378a(336, 1, 1, true);
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
                C4990ab.m7417i("MicroMsg.App.BizPlaceTopDataTransfer", "transfer update count(%d)", Integer.valueOf(i2));
                C4990ab.m7419v("MicroMsg.App.BizPlaceTopDataTransfer", "transfer update sql(%s)", stringBuilder3);
                a.close();
                if (Ru.mo10108hY("rconversation", stringBuilder2.toString())) {
                    C7060h.pYm.mo8378a(336, 2, 1, true);
                } else {
                    C7060h.pYm.mo8378a(336, 3, 1, true);
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                C4990ab.m7417i("MicroMsg.App.BizPlaceTopDataTransfer", "do biz place to top data transfer, update cost : %s msec,  total cost : %s msec.", Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis3 - currentTimeMillis));
            } else {
                a.close();
                C4990ab.m7416i("MicroMsg.App.BizPlaceTopDataTransfer", "cursor count is 0.");
                AppMethodBeat.m2505o(16430);
                return;
            }
        }
        AppMethodBeat.m2505o(16430);
    }
}
