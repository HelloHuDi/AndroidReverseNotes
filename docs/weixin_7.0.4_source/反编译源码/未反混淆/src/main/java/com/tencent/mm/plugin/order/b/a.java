package com.tencent.mm.plugin.order.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.di;
import java.lang.reflect.Field;

public final class a extends di {
    protected static com.tencent.mm.sdk.e.c.a ccO;

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(43792);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.xDd.put("msgId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" msgId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "msgId";
        aVar.columns[1] = "msgContentXml";
        aVar.xDd.put("msgContentXml", "TEXT");
        stringBuilder.append(" msgContentXml TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "isRead";
        aVar.xDd.put("isRead", "TEXT");
        stringBuilder.append(" isRead TEXT");
        aVar.columns[3] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(43792);
    }
}
