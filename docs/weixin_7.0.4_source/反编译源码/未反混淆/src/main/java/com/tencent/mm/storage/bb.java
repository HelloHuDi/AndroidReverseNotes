package com.tencent.mm.storage;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cb;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class bb extends cb {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(60138);
        a aVar = new a();
        aVar.xDb = new Field[13];
        aVar.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "originSvrId";
        aVar.xDd.put("originSvrId", "LONG PRIMARY KEY ");
        stringBuilder.append(" originSvrId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "originSvrId";
        aVar.columns[1] = "newMsgId";
        aVar.xDd.put("newMsgId", "LONG");
        stringBuilder.append(" newMsgId LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "fromUserName";
        aVar.xDd.put("fromUserName", "TEXT default '' ");
        stringBuilder.append(" fromUserName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "toUserName";
        aVar.xDd.put("toUserName", "TEXT default '' ");
        stringBuilder.append(" toUserName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "createTime";
        aVar.xDd.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = b.CONTENT;
        aVar.xDd.put(b.CONTENT, "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "msgSource";
        aVar.xDd.put("msgSource", "TEXT default '' ");
        stringBuilder.append(" msgSource TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "msgSeq";
        aVar.xDd.put("msgSeq", "INTEGER");
        stringBuilder.append(" msgSeq INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "flag";
        aVar.xDd.put("flag", "INTEGER");
        stringBuilder.append(" flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "reserved1";
        aVar.xDd.put("reserved1", "INTEGER");
        stringBuilder.append(" reserved1 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "reserved2";
        aVar.xDd.put("reserved2", "LONG");
        stringBuilder.append(" reserved2 LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "reserved3";
        aVar.xDd.put("reserved3", "TEXT default '' ");
        stringBuilder.append(" reserved3 TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "reserved4";
        aVar.xDd.put("reserved4", "TEXT default '' ");
        stringBuilder.append(" reserved4 TEXT default '' ");
        aVar.columns[13] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(60138);
    }
}
