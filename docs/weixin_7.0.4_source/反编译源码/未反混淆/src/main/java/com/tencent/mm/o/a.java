package com.tencent.mm.o;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.at;
import java.lang.reflect.Field;

public class a extends at {
    public static com.tencent.mm.sdk.e.c.a ccO;
    public static final String ewS = null;

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    public a(String str) {
        AppMethodBeat.i(59709);
        setUsername(str);
        AppMethodBeat.o(59709);
    }

    public final void jj(int i) {
        AppMethodBeat.i(59710);
        hQ(this.field_attrflag | i);
        AppMethodBeat.o(59710);
    }

    public final void jk(int i) {
        AppMethodBeat.i(59711);
        hQ(this.field_attrflag & (i ^ -1));
        AppMethodBeat.o(59711);
    }

    public final boolean jl(int i) {
        return (this.field_attrflag & i) != 0;
    }

    static {
        AppMethodBeat.i(59712);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[25];
        aVar.columns = new String[26];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgCount";
        aVar.xDd.put("msgCount", "INTEGER default '0' ");
        stringBuilder.append(" msgCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "username";
        aVar.xDd.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "username";
        aVar.columns[2] = "unReadCount";
        aVar.xDd.put("unReadCount", "INTEGER default '0' ");
        stringBuilder.append(" unReadCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "chatmode";
        aVar.xDd.put("chatmode", "INTEGER default '0' ");
        stringBuilder.append(" chatmode INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "status";
        aVar.xDd.put("status", "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "isSend";
        aVar.xDd.put("isSend", "INTEGER default '0' ");
        stringBuilder.append(" isSend INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "conversationTime";
        aVar.xDd.put("conversationTime", "LONG default '0' ");
        stringBuilder.append(" conversationTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[7] = b.CONTENT;
        aVar.xDd.put(b.CONTENT, "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "msgType";
        aVar.xDd.put("msgType", "TEXT default '' ");
        stringBuilder.append(" msgType TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "customNotify";
        aVar.xDd.put("customNotify", "TEXT default '' ");
        stringBuilder.append(" customNotify TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "showTips";
        aVar.xDd.put("showTips", "INTEGER default '0' ");
        stringBuilder.append(" showTips INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "flag";
        aVar.xDd.put("flag", "LONG default '0' ");
        stringBuilder.append(" flag LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "digest";
        aVar.xDd.put("digest", "TEXT default '' ");
        stringBuilder.append(" digest TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "digestUser";
        aVar.xDd.put("digestUser", "TEXT default '' ");
        stringBuilder.append(" digestUser TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "hasTrunc";
        aVar.xDd.put("hasTrunc", "INTEGER default '0' ");
        stringBuilder.append(" hasTrunc INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "parentRef";
        aVar.xDd.put("parentRef", "TEXT");
        stringBuilder.append(" parentRef TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "attrflag";
        aVar.xDd.put("attrflag", "INTEGER default '0' ");
        stringBuilder.append(" attrflag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[17] = "editingMsg";
        aVar.xDd.put("editingMsg", "TEXT default '' ");
        stringBuilder.append(" editingMsg TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "atCount";
        aVar.xDd.put("atCount", "INTEGER default '0' ");
        stringBuilder.append(" atCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[19] = "sightTime";
        aVar.xDd.put("sightTime", "LONG default '0' ");
        stringBuilder.append(" sightTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[20] = "unReadMuteCount";
        aVar.xDd.put("unReadMuteCount", "INTEGER default '0' ");
        stringBuilder.append(" unReadMuteCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[21] = "lastSeq";
        aVar.xDd.put("lastSeq", "LONG");
        stringBuilder.append(" lastSeq LONG");
        stringBuilder.append(", ");
        aVar.columns[22] = "UnDeliverCount";
        aVar.xDd.put("UnDeliverCount", "INTEGER");
        stringBuilder.append(" UnDeliverCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[23] = "UnReadInvite";
        aVar.xDd.put("UnReadInvite", "INTEGER");
        stringBuilder.append(" UnReadInvite INTEGER");
        stringBuilder.append(", ");
        aVar.columns[24] = "firstUnDeliverSeq";
        aVar.xDd.put("firstUnDeliverSeq", "LONG");
        stringBuilder.append(" firstUnDeliverSeq LONG");
        aVar.columns[25] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(59712);
    }
}
