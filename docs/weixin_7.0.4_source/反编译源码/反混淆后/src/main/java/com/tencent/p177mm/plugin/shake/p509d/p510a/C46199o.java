package com.tencent.p177mm.plugin.shake.p509d.p510a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;

/* renamed from: com.tencent.mm.plugin.shake.d.a.o */
public final class C46199o extends C7563j<C13264n> {
    public static final String[] diI = new String[0];
    public static final String[] fnj = new String[]{C7563j.m13217a(C13264n.ccO, "shaketvhistory")};
    public C4927e bSd;

    static {
        AppMethodBeat.m2504i(24679);
        AppMethodBeat.m2505o(24679);
    }

    public C46199o(C4927e c4927e) {
        super(c4927e, C13264n.ccO, "shaketvhistory", fnj);
        this.bSd = c4927e;
    }

    public final Cursor cky() {
        AppMethodBeat.m2504i(24678);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM shaketvhistory ORDER BY createtime DESC");
        Cursor rawQuery = this.bSd.rawQuery(stringBuilder.toString(), null);
        AppMethodBeat.m2505o(24678);
        return rawQuery;
    }
}
