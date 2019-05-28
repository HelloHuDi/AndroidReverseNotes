package com.tencent.p177mm.plugin.ipcall.p438a.p983g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;

/* renamed from: com.tencent.mm.plugin.ipcall.a.g.l */
public final class C28333l extends C7563j<C28332k> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C28332k.ccO, "IPCallRecord")};
    static final String[] nzF = new String[]{"*", "rowid"};
    public C4927e bSd;

    static {
        AppMethodBeat.m2504i(21947);
        AppMethodBeat.m2505o(21947);
    }

    public C28333l(C4927e c4927e) {
        super(c4927e, C28332k.ccO, "IPCallRecord", null);
        this.bSd = c4927e;
    }

    /* renamed from: OU */
    public final Cursor mo46243OU(String str) {
        AppMethodBeat.m2504i(21943);
        Cursor query = this.bSd.query("IPCallRecord", nzF, "phonenumber=?", new String[]{str}, null, null, "calltime desc limit 4");
        AppMethodBeat.m2505o(21943);
        return query;
    }

    /* renamed from: OV */
    public final Cursor mo46244OV(String str) {
        AppMethodBeat.m2504i(21944);
        Cursor query = this.bSd.query("IPCallRecord", nzF, "phonenumber=?", new String[]{str}, null, null, "calltime desc");
        AppMethodBeat.m2505o(21944);
        return query;
    }

    /* renamed from: iX */
    public final Cursor mo46246iX(long j) {
        AppMethodBeat.m2504i(21945);
        Cursor query = this.bSd.query("IPCallRecord", nzF, "addressId=?", new String[]{String.valueOf(j)}, null, null, "calltime desc");
        AppMethodBeat.m2505o(21945);
        return query;
    }

    /* renamed from: a */
    public final void mo46245a(C28332k c28332k) {
        AppMethodBeat.m2504i(21946);
        if (c28332k != null) {
            mo16757a(c28332k.xDa, (C4925c) c28332k);
        }
        AppMethodBeat.m2505o(21946);
    }
}
