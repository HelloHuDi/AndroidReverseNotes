package com.tencent.p177mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.model.l */
public final class C37920l {
    /* renamed from: Yv */
    public static int m64042Yv() {
        AppMethodBeat.m2504i(16271);
        if (C1720g.m3531RK()) {
            int i;
            Cursor dsS = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().dsS();
            if (dsS == null || dsS.getCount() <= 0) {
                i = 0;
            } else {
                dsS.moveToFirst();
                i = dsS.getInt(0);
            }
            if (dsS != null) {
                dsS.close();
            }
            AppMethodBeat.m2505o(16271);
            return i;
        }
        C4990ab.m7420w("MicroMsg.BottleConversationLogic", "get Bottle Total Conversation Unread, but has not set uin");
        AppMethodBeat.m2505o(16271);
        return 0;
    }
}
