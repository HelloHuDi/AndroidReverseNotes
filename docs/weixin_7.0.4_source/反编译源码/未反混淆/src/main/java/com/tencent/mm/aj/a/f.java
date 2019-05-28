package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ab;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class f extends ab {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(11556);
        a aVar = new a();
        aVar.xDb = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "brandUserName";
        aVar.xDd.put("brandUserName", "TEXT PRIMARY KEY ");
        stringBuilder.append(" brandUserName TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "brandUserName";
        aVar.columns[1] = "userId";
        aVar.xDd.put("userId", "TEXT");
        stringBuilder.append(" userId TEXT");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(11556);
    }
}
