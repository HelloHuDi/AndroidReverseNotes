package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bj;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class av extends bj {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(60136);
        a aVar = new a();
        aVar.xDb = new Field[17];
        aVar.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "talker";
        aVar.xDd.put("talker", "TEXT default '0'  PRIMARY KEY ");
        stringBuilder.append(" talker TEXT default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "talker";
        aVar.columns[1] = "encryptTalker";
        aVar.xDd.put("encryptTalker", "TEXT default '' ");
        stringBuilder.append(" encryptTalker TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "displayName";
        aVar.xDd.put("displayName", "TEXT default '' ");
        stringBuilder.append(" displayName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "state";
        aVar.xDd.put("state", "INTEGER default '0' ");
        stringBuilder.append(" state INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "lastModifiedTime";
        aVar.xDd.put("lastModifiedTime", "LONG default '0' ");
        stringBuilder.append(" lastModifiedTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "isNew";
        aVar.xDd.put("isNew", "INTEGER default '0' ");
        stringBuilder.append(" isNew INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "addScene";
        aVar.xDd.put("addScene", "INTEGER default '0' ");
        stringBuilder.append(" addScene INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "fmsgSysRowId";
        aVar.xDd.put("fmsgSysRowId", "LONG default '0' ");
        stringBuilder.append(" fmsgSysRowId LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "fmsgIsSend";
        aVar.xDd.put("fmsgIsSend", "INTEGER default '0' ");
        stringBuilder.append(" fmsgIsSend INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "fmsgType";
        aVar.xDd.put("fmsgType", "INTEGER default '0' ");
        stringBuilder.append(" fmsgType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "fmsgContent";
        aVar.xDd.put("fmsgContent", "TEXT default '' ");
        stringBuilder.append(" fmsgContent TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "recvFmsgType";
        aVar.xDd.put("recvFmsgType", "INTEGER default '0' ");
        stringBuilder.append(" recvFmsgType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "contentFromUsername";
        aVar.xDd.put("contentFromUsername", "TEXT default '' ");
        stringBuilder.append(" contentFromUsername TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "contentNickname";
        aVar.xDd.put("contentNickname", "TEXT default '' ");
        stringBuilder.append(" contentNickname TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "contentPhoneNumMD5";
        aVar.xDd.put("contentPhoneNumMD5", "TEXT default '' ");
        stringBuilder.append(" contentPhoneNumMD5 TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "contentFullPhoneNumMD5";
        aVar.xDd.put("contentFullPhoneNumMD5", "TEXT default '' ");
        stringBuilder.append(" contentFullPhoneNumMD5 TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "contentVerifyContent";
        aVar.xDd.put("contentVerifyContent", "TEXT default '' ");
        stringBuilder.append(" contentVerifyContent TEXT default '' ");
        aVar.columns[17] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(60136);
    }
}
