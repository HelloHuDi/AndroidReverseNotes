package com.tencent.p177mm.plugin.scanner.p1018b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.scanner.history.p503a.C3755a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;

/* renamed from: com.tencent.mm.plugin.scanner.b.a */
public final class C13121a extends C7563j<C3755a> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C3755a.ccO, "ScanHistoryItem")};
    public C4927e bSd;

    static {
        AppMethodBeat.m2504i(80895);
        AppMethodBeat.m2505o(80895);
    }

    public C13121a(C4927e c4927e) {
        super(c4927e, C3755a.ccO, "ScanHistoryItem", null);
        this.bSd = c4927e;
    }

    public final Cursor baR() {
        AppMethodBeat.m2504i(80894);
        Cursor rawQuery = this.bSd.rawQuery("select * from ScanHistoryItem order by ScanTime desc", null);
        AppMethodBeat.m2505o(80894);
        return rawQuery;
    }
}
