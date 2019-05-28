package com.tencent.p177mm.p761o;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C6563at;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.o.a */
public class C7487a extends C6563at {
    public static C4924a ccO;
    public static final String ewS = null;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public C7487a(String str) {
        AppMethodBeat.m2504i(59709);
        setUsername(str);
        AppMethodBeat.m2505o(59709);
    }

    /* renamed from: jj */
    public final void mo16712jj(int i) {
        AppMethodBeat.m2504i(59710);
        mo14752hQ(this.field_attrflag | i);
        AppMethodBeat.m2505o(59710);
    }

    /* renamed from: jk */
    public final void mo16713jk(int i) {
        AppMethodBeat.m2504i(59711);
        mo14752hQ(this.field_attrflag & (i ^ -1));
        AppMethodBeat.m2505o(59711);
    }

    /* renamed from: jl */
    public final boolean mo16714jl(int i) {
        return (this.field_attrflag & i) != 0;
    }

    static {
        AppMethodBeat.m2504i(59712);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[25];
        c4924a.columns = new String[26];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "msgCount";
        c4924a.xDd.put("msgCount", "INTEGER default '0' ");
        stringBuilder.append(" msgCount INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[1] = "username";
        c4924a.xDd.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "username";
        c4924a.columns[2] = "unReadCount";
        c4924a.xDd.put("unReadCount", "INTEGER default '0' ");
        stringBuilder.append(" unReadCount INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[3] = "chatmode";
        c4924a.xDd.put("chatmode", "INTEGER default '0' ");
        stringBuilder.append(" chatmode INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[4] = "status";
        c4924a.xDd.put("status", "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[5] = "isSend";
        c4924a.xDd.put("isSend", "INTEGER default '0' ");
        stringBuilder.append(" isSend INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[6] = "conversationTime";
        c4924a.xDd.put("conversationTime", "LONG default '0' ");
        stringBuilder.append(" conversationTime LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[7] = C8741b.CONTENT;
        c4924a.xDd.put(C8741b.CONTENT, "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[8] = "msgType";
        c4924a.xDd.put("msgType", "TEXT default '' ");
        stringBuilder.append(" msgType TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[9] = "customNotify";
        c4924a.xDd.put("customNotify", "TEXT default '' ");
        stringBuilder.append(" customNotify TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[10] = "showTips";
        c4924a.xDd.put("showTips", "INTEGER default '0' ");
        stringBuilder.append(" showTips INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[11] = "flag";
        c4924a.xDd.put("flag", "LONG default '0' ");
        stringBuilder.append(" flag LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[12] = "digest";
        c4924a.xDd.put("digest", "TEXT default '' ");
        stringBuilder.append(" digest TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[13] = "digestUser";
        c4924a.xDd.put("digestUser", "TEXT default '' ");
        stringBuilder.append(" digestUser TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[14] = "hasTrunc";
        c4924a.xDd.put("hasTrunc", "INTEGER default '0' ");
        stringBuilder.append(" hasTrunc INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[15] = "parentRef";
        c4924a.xDd.put("parentRef", "TEXT");
        stringBuilder.append(" parentRef TEXT");
        stringBuilder.append(", ");
        c4924a.columns[16] = "attrflag";
        c4924a.xDd.put("attrflag", "INTEGER default '0' ");
        stringBuilder.append(" attrflag INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[17] = "editingMsg";
        c4924a.xDd.put("editingMsg", "TEXT default '' ");
        stringBuilder.append(" editingMsg TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[18] = "atCount";
        c4924a.xDd.put("atCount", "INTEGER default '0' ");
        stringBuilder.append(" atCount INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[19] = "sightTime";
        c4924a.xDd.put("sightTime", "LONG default '0' ");
        stringBuilder.append(" sightTime LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[20] = "unReadMuteCount";
        c4924a.xDd.put("unReadMuteCount", "INTEGER default '0' ");
        stringBuilder.append(" unReadMuteCount INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[21] = "lastSeq";
        c4924a.xDd.put("lastSeq", "LONG");
        stringBuilder.append(" lastSeq LONG");
        stringBuilder.append(", ");
        c4924a.columns[22] = "UnDeliverCount";
        c4924a.xDd.put("UnDeliverCount", "INTEGER");
        stringBuilder.append(" UnDeliverCount INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[23] = "UnReadInvite";
        c4924a.xDd.put("UnReadInvite", "INTEGER");
        stringBuilder.append(" UnReadInvite INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[24] = "firstUnDeliverSeq";
        c4924a.xDd.put("firstUnDeliverSeq", "LONG");
        stringBuilder.append(" firstUnDeliverSeq LONG");
        c4924a.columns[25] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(59712);
    }
}
