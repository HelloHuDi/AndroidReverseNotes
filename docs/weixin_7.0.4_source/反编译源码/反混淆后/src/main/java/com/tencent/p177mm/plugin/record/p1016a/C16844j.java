package com.tencent.p177mm.plugin.record.p1016a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C9528dv;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.record.a.j */
public final class C16844j extends C9528dv implements C21594c {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final int cez() {
        return this.field_localId;
    }

    static {
        AppMethodBeat.m2504i(57136);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[10];
        c4924a.columns = new String[11];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "localId";
        c4924a.xDd.put("localId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" localId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "localId";
        c4924a.columns[1] = "msgId";
        c4924a.xDd.put("msgId", "LONG default '-1' ");
        stringBuilder.append(" msgId LONG default '-1' ");
        stringBuilder.append(", ");
        c4924a.columns[2] = "oriMsgId";
        c4924a.xDd.put("oriMsgId", "LONG default '-1' ");
        stringBuilder.append(" oriMsgId LONG default '-1' ");
        stringBuilder.append(", ");
        c4924a.columns[3] = "toUser";
        c4924a.xDd.put("toUser", "TEXT default '' ");
        stringBuilder.append(" toUser TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[4] = "title";
        c4924a.xDd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "desc";
        c4924a.xDd.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        stringBuilder.append(", ");
        c4924a.columns[6] = "dataProto";
        c4924a.xDd.put("dataProto", "BLOB");
        stringBuilder.append(" dataProto BLOB");
        stringBuilder.append(", ");
        c4924a.columns[7] = "type";
        c4924a.xDd.put("type", "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[8] = "status";
        c4924a.xDd.put("status", "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[9] = "favFrom";
        c4924a.xDd.put("favFrom", "TEXT");
        stringBuilder.append(" favFrom TEXT");
        c4924a.columns[10] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(57136);
    }
}
