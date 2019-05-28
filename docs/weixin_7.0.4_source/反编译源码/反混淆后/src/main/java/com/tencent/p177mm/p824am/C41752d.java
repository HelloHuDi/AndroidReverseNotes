package com.tencent.p177mm.p824am;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1812ai;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.am.d */
public final class C41752d extends C1812ai {
    /* renamed from: kw */
    public final boolean mo5386kw(int i) {
        return i != 0 && i < 620757033;
    }

    public final void transfer(int i) {
        AppMethodBeat.m2504i(16432);
        C4990ab.m7411d("MicroMsg.DataTransfer.BlackListConvDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (i != 0 && i < 620757033) {
            C7060h.pYm.mo15419k(336, 13, 1);
            LinkedList<String> linkedList = new LinkedList();
            C9638aw.m17190ZK();
            Cursor d = C18628c.m29078XM().mo15738d("@black.android", "", null);
            if (d != null) {
                d.moveToFirst();
                while (!d.isAfterLast()) {
                    C7616ad c7616ad = new C7616ad();
                    c7616ad.mo8995d(d);
                    linkedList.add(c7616ad.field_username);
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
                C4990ab.m7411d("MicroMsg.DataTransfer.BlackListConvDataTransfer", "update sql: %s", stringBuilder.toString());
                C9638aw.m17190ZK();
                C18628c.m29069Ru().mo10108hY("rconversation", append);
            }
        }
        AppMethodBeat.m2505o(16432);
    }

    public final String getTag() {
        return "MicroMsg.DataTransfer.BlackListConvDataTransfer";
    }
}
