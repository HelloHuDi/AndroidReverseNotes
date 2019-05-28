package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bk;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class ax extends bk {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    public final boolean dtf() {
        return this.field_isSend % 2 == 0;
    }

    static {
        AppMethodBeat.i(60137);
        a aVar = new a();
        aVar.xDb = new Field[8];
        aVar.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgContent";
        aVar.xDd.put("msgContent", "TEXT default '' ");
        stringBuilder.append(" msgContent TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "isSend";
        aVar.xDd.put("isSend", "INTEGER default '0' ");
        stringBuilder.append(" isSend INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "talker";
        aVar.xDd.put("talker", "TEXT default '' ");
        stringBuilder.append(" talker TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "encryptTalker";
        aVar.xDd.put("encryptTalker", "TEXT default '' ");
        stringBuilder.append(" encryptTalker TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "svrId";
        aVar.xDd.put("svrId", "LONG default '0' ");
        stringBuilder.append(" svrId LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "type";
        aVar.xDd.put("type", "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "createTime";
        aVar.xDd.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "chatroomName";
        aVar.xDd.put("chatroomName", "TEXT default '' ");
        stringBuilder.append(" chatroomName TEXT default '' ");
        aVar.columns[8] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(60137);
    }
}
