package com.tencent.p177mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C6577ev;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.storage.bx */
public final class C7576bx extends C6577ev {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(59016);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[2];
        c4924a.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "tableHash";
        c4924a.xDd.put("tableHash", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" tableHash INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "tableHash";
        c4924a.columns[1] = "tableSQLMD5";
        c4924a.xDd.put("tableSQLMD5", "TEXT");
        stringBuilder.append(" tableSQLMD5 TEXT");
        c4924a.columns[2] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(59016);
    }
}
