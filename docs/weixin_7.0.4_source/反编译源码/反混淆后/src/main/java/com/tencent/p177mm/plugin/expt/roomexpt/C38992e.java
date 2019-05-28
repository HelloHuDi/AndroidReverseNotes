package com.tencent.p177mm.plugin.expt.roomexpt;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C32689dy;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.expt.roomexpt.e */
public final class C38992e extends C32689dy {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final String toString() {
        AppMethodBeat.m2504i(73605);
        String format = String.format("name[%s %s] daySec[%s] isMute[%d] unRead[%d] send[%d] enter[%d] disRedRod[%d] stayTime[%d] score[%f] systemRowid[%d]", new Object[]{this.field_chatroom, this.field_nickname, this.field_daySec, Integer.valueOf(this.field_isMute), Integer.valueOf(this.field_unReadCount), Integer.valueOf(this.field_sendCount), Integer.valueOf(this.field_enterCount), Integer.valueOf(this.field_disRedDotCount), Long.valueOf(this.field_stayTime), Float.valueOf(this.field_score), Long.valueOf(this.xDa)});
        AppMethodBeat.m2505o(73605);
        return format;
    }

    static {
        AppMethodBeat.m2504i(73606);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[10];
        c4924a.columns = new String[11];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "chatroom";
        c4924a.xDd.put("chatroom", "TEXT");
        stringBuilder.append(" chatroom TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "daySec";
        c4924a.xDd.put("daySec", "TEXT");
        stringBuilder.append(" daySec TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "nickname";
        c4924a.xDd.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "isMute";
        c4924a.xDd.put("isMute", "INTEGER");
        stringBuilder.append(" isMute INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "unReadCount";
        c4924a.xDd.put("unReadCount", "INTEGER");
        stringBuilder.append(" unReadCount INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[5] = "sendCount";
        c4924a.xDd.put("sendCount", "INTEGER");
        stringBuilder.append(" sendCount INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[6] = "enterCount";
        c4924a.xDd.put("enterCount", "INTEGER");
        stringBuilder.append(" enterCount INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[7] = "disRedDotCount";
        c4924a.xDd.put("disRedDotCount", "INTEGER");
        stringBuilder.append(" disRedDotCount INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[8] = "stayTime";
        c4924a.xDd.put("stayTime", "LONG");
        stringBuilder.append(" stayTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[9] = C8741b.SCORE;
        c4924a.xDd.put(C8741b.SCORE, "FLOAT");
        stringBuilder.append(" score FLOAT");
        c4924a.columns[10] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(73606);
    }
}
