package com.tencent.p177mm.plugin.ipcall.p438a.p983g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;

/* renamed from: com.tencent.mm.plugin.ipcall.a.g.h */
public final class C39262h extends C7563j<C46038g> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C46038g.ccO, "IPCallMsg")};
    private static final String[] nzC = new String[]{"*", "rowid"};
    public static int nzD = 0;
    public C4927e bSd;

    static {
        AppMethodBeat.m2504i(21935);
        AppMethodBeat.m2505o(21935);
    }

    public C39262h(C4927e c4927e) {
        super(c4927e, C46038g.ccO, "IPCallMsg", null);
        this.bSd = c4927e;
    }

    /* renamed from: xm */
    public final Cursor mo62158xm(int i) {
        AppMethodBeat.m2504i(21934);
        Cursor query = this.bSd.query("IPCallMsg", nzC, null, null, null, null, "pushTime desc limit ".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(21934);
        return query;
    }
}
