package com.tencent.p177mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.card.model.al */
public final class C20141al extends C7563j<C20140ak> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C20140ak.ccO, "PendingCardId")};
    C4927e bSd;

    static {
        AppMethodBeat.m2504i(87929);
        AppMethodBeat.m2505o(87929);
    }

    public C20141al(C4927e c4927e) {
        super(c4927e, C20140ak.ccO, "PendingCardId", null);
        this.bSd = c4927e;
    }

    public final List<C20140ak> baU() {
        AppMethodBeat.m2504i(87928);
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.mo10104a("select * from PendingCardId where retryCount < 10", null, 2);
        while (a.moveToNext()) {
            C20140ak c20140ak = new C20140ak();
            c20140ak.mo8995d(a);
            arrayList.add(c20140ak);
        }
        a.close();
        C4990ab.m7411d("MicroMsg.PendingCardIdInfoStorage", "getAll, count = %d", Integer.valueOf(arrayList.size()));
        AppMethodBeat.m2505o(87928);
        return arrayList;
    }
}
