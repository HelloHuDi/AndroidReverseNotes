package com.tencent.p177mm.p824am;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1812ai;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.am.a */
public final class C17911a extends C1812ai {
    /* renamed from: kw */
    public final boolean mo5386kw(int i) {
        return i != 0 && i < 604372991;
    }

    public final String getTag() {
        return "MicroMsg.App.BizInfoDataTransfer";
    }

    public final void transfer(int i) {
        AppMethodBeat.m2504i(16429);
        C4990ab.m7411d("MicroMsg.App.BizInfoDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (i != 0 && i < 604372991) {
            C7060h.pYm.mo15419k(336, 12, 1);
            C9638aw.m17190ZK();
            C7480h Ru = C18628c.m29069Ru();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select BizInfo.username, BizInfo.extInfo");
            stringBuilder.append(" from rcontact , BizInfo");
            stringBuilder.append(" where rcontact.username = BizInfo.username");
            stringBuilder.append(" and (rcontact.type & 1 ) != 0 ");
            stringBuilder.append(" and ( rcontact.verifyFlag & 8 ) != 0 ");
            String stringBuilder2 = stringBuilder.toString();
            ArrayList<String> arrayList = new ArrayList();
            C4990ab.m7411d("MicroMsg.App.BizInfoDataTransfer", "sql %s", stringBuilder2);
            Cursor a = Ru.mo10104a(stringBuilder.toString(), null, 2);
            if (a != null) {
                while (a.moveToNext()) {
                    C16527d c16527d = new C16527d();
                    c16527d.mo8995d(a);
                    if (c16527d.mo30481cJ(false).getServiceType() == 1) {
                        arrayList.add(c16527d.field_username);
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
                C4990ab.m7411d("MicroMsg.App.BizInfoDataTransfer", "update sql %s", stringBuilder.toString());
                C41747z.aeR().mo16768hY("BizInfo", append);
            }
        }
        AppMethodBeat.m2505o(16429);
    }
}
