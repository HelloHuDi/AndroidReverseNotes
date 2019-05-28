package com.tencent.mm.af;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public class s extends cy {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(59713);
        a aVar = new a();
        aVar.xDb = new Field[20];
        aVar.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.xDd.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "msgId";
        aVar.columns[1] = "msgSvrId";
        aVar.xDd.put("msgSvrId", "LONG");
        stringBuilder.append(" msgSvrId LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "type";
        aVar.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "status";
        aVar.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "isSend";
        aVar.xDd.put("isSend", "INTEGER");
        stringBuilder.append(" isSend INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "isShowTimer";
        aVar.xDd.put("isShowTimer", "INTEGER");
        stringBuilder.append(" isShowTimer INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "createTime";
        aVar.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "talker";
        aVar.xDd.put("talker", "TEXT");
        stringBuilder.append(" talker TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = b.CONTENT;
        aVar.xDd.put(b.CONTENT, "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "imgPath";
        aVar.xDd.put("imgPath", "TEXT");
        stringBuilder.append(" imgPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "reserved";
        aVar.xDd.put("reserved", "TEXT");
        stringBuilder.append(" reserved TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "lvbuffer";
        aVar.xDd.put("lvbuffer", "BLOB");
        stringBuilder.append(" lvbuffer BLOB");
        stringBuilder.append(", ");
        aVar.columns[12] = "talkerId";
        aVar.xDd.put("talkerId", "INTEGER");
        stringBuilder.append(" talkerId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[13] = "transContent";
        aVar.xDd.put("transContent", "TEXT default '' ");
        stringBuilder.append(" transContent TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "transBrandWording";
        aVar.xDd.put("transBrandWording", "TEXT default '' ");
        stringBuilder.append(" transBrandWording TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "bizClientMsgId";
        aVar.xDd.put("bizClientMsgId", "TEXT default '' ");
        stringBuilder.append(" bizClientMsgId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "bizChatId";
        aVar.xDd.put("bizChatId", "LONG default '-1' ");
        stringBuilder.append(" bizChatId LONG default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[17] = "bizChatUserId";
        aVar.xDd.put("bizChatUserId", "TEXT default '' ");
        stringBuilder.append(" bizChatUserId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "msgSeq";
        aVar.xDd.put("msgSeq", "LONG");
        stringBuilder.append(" msgSeq LONG");
        stringBuilder.append(", ");
        aVar.columns[19] = "flag";
        aVar.xDd.put("flag", "INTEGER default '0' ");
        stringBuilder.append(" flag INTEGER default '0' ");
        aVar.columns[20] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(59713);
    }
}
