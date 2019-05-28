package com.tencent.p177mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C6568bj;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.storage.av */
public final class C7568av extends C6568bj {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(60136);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[17];
        c4924a.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "talker";
        c4924a.xDd.put("talker", "TEXT default '0'  PRIMARY KEY ");
        stringBuilder.append(" talker TEXT default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "talker";
        c4924a.columns[1] = "encryptTalker";
        c4924a.xDd.put("encryptTalker", "TEXT default '' ");
        stringBuilder.append(" encryptTalker TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[2] = "displayName";
        c4924a.xDd.put("displayName", "TEXT default '' ");
        stringBuilder.append(" displayName TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[3] = "state";
        c4924a.xDd.put("state", "INTEGER default '0' ");
        stringBuilder.append(" state INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[4] = "lastModifiedTime";
        c4924a.xDd.put("lastModifiedTime", "LONG default '0' ");
        stringBuilder.append(" lastModifiedTime LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[5] = "isNew";
        c4924a.xDd.put("isNew", "INTEGER default '0' ");
        stringBuilder.append(" isNew INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[6] = "addScene";
        c4924a.xDd.put("addScene", "INTEGER default '0' ");
        stringBuilder.append(" addScene INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[7] = "fmsgSysRowId";
        c4924a.xDd.put("fmsgSysRowId", "LONG default '0' ");
        stringBuilder.append(" fmsgSysRowId LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[8] = "fmsgIsSend";
        c4924a.xDd.put("fmsgIsSend", "INTEGER default '0' ");
        stringBuilder.append(" fmsgIsSend INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[9] = "fmsgType";
        c4924a.xDd.put("fmsgType", "INTEGER default '0' ");
        stringBuilder.append(" fmsgType INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[10] = "fmsgContent";
        c4924a.xDd.put("fmsgContent", "TEXT default '' ");
        stringBuilder.append(" fmsgContent TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[11] = "recvFmsgType";
        c4924a.xDd.put("recvFmsgType", "INTEGER default '0' ");
        stringBuilder.append(" recvFmsgType INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[12] = "contentFromUsername";
        c4924a.xDd.put("contentFromUsername", "TEXT default '' ");
        stringBuilder.append(" contentFromUsername TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[13] = "contentNickname";
        c4924a.xDd.put("contentNickname", "TEXT default '' ");
        stringBuilder.append(" contentNickname TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[14] = "contentPhoneNumMD5";
        c4924a.xDd.put("contentPhoneNumMD5", "TEXT default '' ");
        stringBuilder.append(" contentPhoneNumMD5 TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[15] = "contentFullPhoneNumMD5";
        c4924a.xDd.put("contentFullPhoneNumMD5", "TEXT default '' ");
        stringBuilder.append(" contentFullPhoneNumMD5 TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[16] = "contentVerifyContent";
        c4924a.xDd.put("contentVerifyContent", "TEXT default '' ");
        stringBuilder.append(" contentVerifyContent TEXT default '' ");
        c4924a.columns[17] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(60136);
    }
}
