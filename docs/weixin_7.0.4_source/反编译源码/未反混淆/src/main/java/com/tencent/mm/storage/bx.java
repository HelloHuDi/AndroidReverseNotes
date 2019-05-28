package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ev;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class bx extends ev {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(59016);
        a aVar = new a();
        aVar.xDb = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "tableHash";
        aVar.xDd.put("tableHash", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" tableHash INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "tableHash";
        aVar.columns[1] = "tableSQLMD5";
        aVar.xDd.put("tableSQLMD5", "TEXT");
        stringBuilder.append(" tableSQLMD5 TEXT");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(59016);
    }
}
