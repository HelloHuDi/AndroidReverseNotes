package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.w;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class k extends w {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(29010);
        a aVar = new a();
        aVar.xDb = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgListDataId";
        aVar.xDd.put("msgListDataId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" msgListDataId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "msgListDataId";
        aVar.columns[1] = "sessionName";
        aVar.xDd.put("sessionName", "TEXT default '' ");
        stringBuilder.append(" sessionName TEXT default '' ");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(29010);
    }
}
