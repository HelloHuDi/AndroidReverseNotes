package com.tencent.mm.plugin.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dv;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class j extends dv implements c {
    public static a ccO;

    public final a Ag() {
        return ccO;
    }

    public final int cez() {
        return this.field_localId;
    }

    static {
        AppMethodBeat.i(57136);
        a aVar = new a();
        aVar.xDb = new Field[10];
        aVar.columns = new String[11];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.xDd.put("localId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" localId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "localId";
        aVar.columns[1] = "msgId";
        aVar.xDd.put("msgId", "LONG default '-1' ");
        stringBuilder.append(" msgId LONG default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "oriMsgId";
        aVar.xDd.put("oriMsgId", "LONG default '-1' ");
        stringBuilder.append(" oriMsgId LONG default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "toUser";
        aVar.xDd.put("toUser", "TEXT default '' ");
        stringBuilder.append(" toUser TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "title";
        aVar.xDd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "desc";
        aVar.xDd.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "dataProto";
        aVar.xDd.put("dataProto", "BLOB");
        stringBuilder.append(" dataProto BLOB");
        stringBuilder.append(", ");
        aVar.columns[7] = "type";
        aVar.xDd.put("type", "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "status";
        aVar.xDd.put("status", "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "favFrom";
        aVar.xDd.put("favFrom", "TEXT");
        stringBuilder.append(" favFrom TEXT");
        aVar.columns[10] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(57136);
    }
}
