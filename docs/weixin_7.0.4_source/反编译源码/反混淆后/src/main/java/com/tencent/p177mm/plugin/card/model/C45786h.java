package com.tencent.p177mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;

/* renamed from: com.tencent.mm.plugin.card.model.h */
public final class C45786h extends C7563j<C38747g> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C38747g.ccO, "CardMsgInfo")};
    public C4927e bSd;

    static {
        AppMethodBeat.m2504i(87838);
        AppMethodBeat.m2505o(87838);
    }

    public C45786h(C4927e c4927e) {
        super(c4927e, C38747g.ccO, "CardMsgInfo", null);
        this.bSd = c4927e;
    }

    public final Cursor baR() {
        AppMethodBeat.m2504i(87835);
        Cursor rawQuery = this.bSd.rawQuery("select * from CardMsgInfo order by time desc", null);
        AppMethodBeat.m2505o(87835);
        return rawQuery;
    }

    public final int baS() {
        int i = 0;
        AppMethodBeat.m2504i(87836);
        Cursor a = this.bSd.mo10104a(" select count(*) from CardMsgInfo where read_state = ? ", new String[]{"1"}, 2);
        if (a == null) {
            AppMethodBeat.m2505o(87836);
        } else {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
            AppMethodBeat.m2505o(87836);
        }
        return i;
    }

    public final boolean baT() {
        AppMethodBeat.m2504i(87837);
        boolean hY = this.bSd.mo10108hY("CardMsgInfo", " update CardMsgInfo set read_state = 0  where read_state = 1");
        AppMethodBeat.m2505o(87837);
        return hY;
    }
}
