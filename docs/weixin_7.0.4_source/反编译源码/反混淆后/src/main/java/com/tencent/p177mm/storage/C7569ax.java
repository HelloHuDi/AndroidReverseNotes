package com.tencent.p177mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C6569bk;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.storage.ax */
public final class C7569ax extends C6569bk {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final boolean dtf() {
        return this.field_isSend % 2 == 0;
    }

    static {
        AppMethodBeat.m2504i(60137);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[8];
        c4924a.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "msgContent";
        c4924a.xDd.put("msgContent", "TEXT default '' ");
        stringBuilder.append(" msgContent TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[1] = "isSend";
        c4924a.xDd.put("isSend", "INTEGER default '0' ");
        stringBuilder.append(" isSend INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[2] = "talker";
        c4924a.xDd.put("talker", "TEXT default '' ");
        stringBuilder.append(" talker TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[3] = "encryptTalker";
        c4924a.xDd.put("encryptTalker", "TEXT default '' ");
        stringBuilder.append(" encryptTalker TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[4] = "svrId";
        c4924a.xDd.put("svrId", "LONG default '0' ");
        stringBuilder.append(" svrId LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[5] = "type";
        c4924a.xDd.put("type", "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[6] = "createTime";
        c4924a.xDd.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[7] = "chatroomName";
        c4924a.xDd.put("chatroomName", "TEXT default '' ");
        stringBuilder.append(" chatroomName TEXT default '' ");
        c4924a.columns[8] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(60137);
    }
}
