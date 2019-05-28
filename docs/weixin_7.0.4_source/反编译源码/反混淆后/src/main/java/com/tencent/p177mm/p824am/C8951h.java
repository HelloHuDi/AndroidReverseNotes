package com.tencent.p177mm.p824am;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1812ai;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.am.h */
public final class C8951h extends C1812ai {
    public final String getTag() {
        return "MicroMsg.App.SyncTopConversation";
    }

    /* renamed from: kw */
    public final boolean mo5386kw(int i) {
        return i != 0 && i < 620758015;
    }

    public final void transfer(int i) {
        AppMethodBeat.m2504i(16436);
        C4990ab.m7411d("MicroMsg.App.SyncTopConversation", "the previous version is %d", Integer.valueOf(i));
        C7060h.pYm.mo15419k(336, 15, 1);
        C9638aw.m17190ZK();
        C7480h Ru = C18628c.m29069Ru();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select username from rconversation");
        stringBuilder.append(" where flag & 4611686018427387904 != 0");
        C4990ab.m7411d("MicroMsg.App.SyncTopConversation", "sql:%s", stringBuilder);
        Cursor a = Ru.mo10104a(stringBuilder.toString(), null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                C4990ab.m7419v("MicroMsg.App.SyncTopConversation", "userName %s", a.getString(0));
                C1855t.m3967w(r1, false);
            }
            a.close();
        }
        AppMethodBeat.m2505o(16436);
    }
}
