package com.tencent.mm.plugin.aa.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class a extends com.tencent.mm.g.c.a {
    public static com.tencent.mm.sdk.e.c.a ccO;

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(40663);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "payMsgId";
        aVar.xDd.put("payMsgId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" payMsgId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "payMsgId";
        aVar.columns[1] = "insertmsg";
        aVar.xDd.put("insertmsg", "INTEGER");
        stringBuilder.append(" insertmsg INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "chatroom";
        aVar.xDd.put("chatroom", "TEXT");
        stringBuilder.append(" chatroom TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "msgId";
        aVar.xDd.put("msgId", "LONG");
        stringBuilder.append(" msgId LONG");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(40663);
    }
}
