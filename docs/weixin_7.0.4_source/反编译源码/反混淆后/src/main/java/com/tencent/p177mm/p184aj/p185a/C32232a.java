package com.tencent.p177mm.p184aj.p185a;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C18486z;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.aj.a.a */
public final class C32232a extends C18486z {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(11489);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[17];
        c4924a.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "bizChatId";
        c4924a.xDd.put("bizChatId", "LONG PRIMARY KEY ");
        stringBuilder.append(" bizChatId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "bizChatId";
        c4924a.columns[1] = "brandUserName";
        c4924a.xDd.put("brandUserName", "TEXT");
        stringBuilder.append(" brandUserName TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "unReadCount";
        c4924a.xDd.put("unReadCount", "INTEGER");
        stringBuilder.append(" unReadCount INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "newUnReadCount";
        c4924a.xDd.put("newUnReadCount", "INTEGER");
        stringBuilder.append(" newUnReadCount INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "lastMsgID";
        c4924a.xDd.put("lastMsgID", "LONG");
        stringBuilder.append(" lastMsgID LONG");
        stringBuilder.append(", ");
        c4924a.columns[5] = "lastMsgTime";
        c4924a.xDd.put("lastMsgTime", "LONG");
        stringBuilder.append(" lastMsgTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[6] = C8741b.CONTENT;
        c4924a.xDd.put(C8741b.CONTENT, "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        c4924a.columns[7] = "digest";
        c4924a.xDd.put("digest", "TEXT default '' ");
        stringBuilder.append(" digest TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[8] = "digestUser";
        c4924a.xDd.put("digestUser", "TEXT default '' ");
        stringBuilder.append(" digestUser TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[9] = "atCount";
        c4924a.xDd.put("atCount", "INTEGER default '0' ");
        stringBuilder.append(" atCount INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[10] = "editingMsg";
        c4924a.xDd.put("editingMsg", "TEXT");
        stringBuilder.append(" editingMsg TEXT");
        stringBuilder.append(", ");
        c4924a.columns[11] = "chatType";
        c4924a.xDd.put("chatType", "INTEGER");
        stringBuilder.append(" chatType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[12] = "status";
        c4924a.xDd.put("status", "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[13] = "isSend";
        c4924a.xDd.put("isSend", "INTEGER default '0' ");
        stringBuilder.append(" isSend INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[14] = "msgType";
        c4924a.xDd.put("msgType", "TEXT default '' ");
        stringBuilder.append(" msgType TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[15] = "msgCount";
        c4924a.xDd.put("msgCount", "INTEGER default '0' ");
        stringBuilder.append(" msgCount INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[16] = "flag";
        c4924a.xDd.put("flag", "LONG default '0' ");
        stringBuilder.append(" flag LONG default '0' ");
        c4924a.columns[17] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(11489);
    }
}
