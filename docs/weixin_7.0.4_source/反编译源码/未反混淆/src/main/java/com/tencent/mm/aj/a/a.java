package com.tencent.mm.aj.a;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.z;
import java.lang.reflect.Field;

public final class a extends z {
    protected static com.tencent.mm.sdk.e.c.a ccO;

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(11489);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[17];
        aVar.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "bizChatId";
        aVar.xDd.put("bizChatId", "LONG PRIMARY KEY ");
        stringBuilder.append(" bizChatId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "bizChatId";
        aVar.columns[1] = "brandUserName";
        aVar.xDd.put("brandUserName", "TEXT");
        stringBuilder.append(" brandUserName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "unReadCount";
        aVar.xDd.put("unReadCount", "INTEGER");
        stringBuilder.append(" unReadCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "newUnReadCount";
        aVar.xDd.put("newUnReadCount", "INTEGER");
        stringBuilder.append(" newUnReadCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "lastMsgID";
        aVar.xDd.put("lastMsgID", "LONG");
        stringBuilder.append(" lastMsgID LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "lastMsgTime";
        aVar.xDd.put("lastMsgTime", "LONG");
        stringBuilder.append(" lastMsgTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = b.CONTENT;
        aVar.xDd.put(b.CONTENT, "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "digest";
        aVar.xDd.put("digest", "TEXT default '' ");
        stringBuilder.append(" digest TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "digestUser";
        aVar.xDd.put("digestUser", "TEXT default '' ");
        stringBuilder.append(" digestUser TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "atCount";
        aVar.xDd.put("atCount", "INTEGER default '0' ");
        stringBuilder.append(" atCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "editingMsg";
        aVar.xDd.put("editingMsg", "TEXT");
        stringBuilder.append(" editingMsg TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "chatType";
        aVar.xDd.put("chatType", "INTEGER");
        stringBuilder.append(" chatType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "status";
        aVar.xDd.put("status", "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "isSend";
        aVar.xDd.put("isSend", "INTEGER default '0' ");
        stringBuilder.append(" isSend INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "msgType";
        aVar.xDd.put("msgType", "TEXT default '' ");
        stringBuilder.append(" msgType TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "msgCount";
        aVar.xDd.put("msgCount", "INTEGER default '0' ");
        stringBuilder.append(" msgCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "flag";
        aVar.xDd.put("flag", "LONG default '0' ");
        stringBuilder.append(" flag LONG default '0' ");
        aVar.columns[17] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(11489);
    }
}
