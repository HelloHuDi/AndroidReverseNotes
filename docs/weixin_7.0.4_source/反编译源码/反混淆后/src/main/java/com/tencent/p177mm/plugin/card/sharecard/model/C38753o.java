package com.tencent.p177mm.plugin.card.sharecard.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.card.sharecard.model.o */
public final class C38753o extends C7563j<C46901n> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C46901n.ccO, "ShareCardSyncItemInfo")};
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(88088);
        AppMethodBeat.m2505o(88088);
    }

    public C38753o(C4927e c4927e) {
        super(c4927e, C46901n.ccO, "ShareCardSyncItemInfo", null);
        this.bSd = c4927e;
    }

    public final List<C46901n> baU() {
        AppMethodBeat.m2504i(88087);
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.mo10104a("select * from ShareCardSyncItemInfo where retryCount < 10", null, 2);
        while (a.moveToNext()) {
            C46901n c46901n = new C46901n();
            c46901n.mo8995d(a);
            arrayList.add(c46901n);
        }
        a.close();
        C4990ab.m7411d("MicroMsg.ShareCardSyncItemInfoStorage", "getAll, share card count = %d", Integer.valueOf(arrayList.size()));
        AppMethodBeat.m2505o(88087);
        return arrayList;
    }
}
