package com.tencent.p177mm.p181af;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C6575cy;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.af.s */
public class C7471s extends C6575cy {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(59713);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[20];
        c4924a.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "msgId";
        c4924a.xDd.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "msgId";
        c4924a.columns[1] = "msgSvrId";
        c4924a.xDd.put("msgSvrId", "LONG");
        stringBuilder.append(" msgSvrId LONG");
        stringBuilder.append(", ");
        c4924a.columns[2] = "type";
        c4924a.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "status";
        c4924a.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "isSend";
        c4924a.xDd.put("isSend", "INTEGER");
        stringBuilder.append(" isSend INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[5] = "isShowTimer";
        c4924a.xDd.put("isShowTimer", "INTEGER");
        stringBuilder.append(" isShowTimer INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[6] = "createTime";
        c4924a.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[7] = "talker";
        c4924a.xDd.put("talker", "TEXT");
        stringBuilder.append(" talker TEXT");
        stringBuilder.append(", ");
        c4924a.columns[8] = C8741b.CONTENT;
        c4924a.xDd.put(C8741b.CONTENT, "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[9] = "imgPath";
        c4924a.xDd.put("imgPath", "TEXT");
        stringBuilder.append(" imgPath TEXT");
        stringBuilder.append(", ");
        c4924a.columns[10] = "reserved";
        c4924a.xDd.put("reserved", "TEXT");
        stringBuilder.append(" reserved TEXT");
        stringBuilder.append(", ");
        c4924a.columns[11] = "lvbuffer";
        c4924a.xDd.put("lvbuffer", "BLOB");
        stringBuilder.append(" lvbuffer BLOB");
        stringBuilder.append(", ");
        c4924a.columns[12] = "talkerId";
        c4924a.xDd.put("talkerId", "INTEGER");
        stringBuilder.append(" talkerId INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[13] = "transContent";
        c4924a.xDd.put("transContent", "TEXT default '' ");
        stringBuilder.append(" transContent TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[14] = "transBrandWording";
        c4924a.xDd.put("transBrandWording", "TEXT default '' ");
        stringBuilder.append(" transBrandWording TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[15] = "bizClientMsgId";
        c4924a.xDd.put("bizClientMsgId", "TEXT default '' ");
        stringBuilder.append(" bizClientMsgId TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[16] = "bizChatId";
        c4924a.xDd.put("bizChatId", "LONG default '-1' ");
        stringBuilder.append(" bizChatId LONG default '-1' ");
        stringBuilder.append(", ");
        c4924a.columns[17] = "bizChatUserId";
        c4924a.xDd.put("bizChatUserId", "TEXT default '' ");
        stringBuilder.append(" bizChatUserId TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[18] = "msgSeq";
        c4924a.xDd.put("msgSeq", "LONG");
        stringBuilder.append(" msgSeq LONG");
        stringBuilder.append(", ");
        c4924a.columns[19] = "flag";
        c4924a.xDd.put("flag", "INTEGER default '0' ");
        stringBuilder.append(" flag INTEGER default '0' ");
        c4924a.columns[20] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(59713);
    }
}
