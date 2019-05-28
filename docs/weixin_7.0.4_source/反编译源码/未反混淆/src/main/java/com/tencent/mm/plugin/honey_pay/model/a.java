package com.tencent.mm.plugin.honey_pay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cj;
import java.lang.reflect.Field;

public final class a extends cj {
    public static com.tencent.mm.sdk.e.c.a ccO;

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(41750);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "payMsgId";
        aVar.xDd.put("payMsgId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" payMsgId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "payMsgId";
        aVar.columns[1] = "msgId";
        aVar.xDd.put("msgId", "LONG");
        stringBuilder.append(" msgId LONG");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(41750);
    }
}
