package com.tencent.mm.plugin.expt.roomexpt;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class e extends dy {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    public final String toString() {
        AppMethodBeat.i(73605);
        String format = String.format("name[%s %s] daySec[%s] isMute[%d] unRead[%d] send[%d] enter[%d] disRedRod[%d] stayTime[%d] score[%f] systemRowid[%d]", new Object[]{this.field_chatroom, this.field_nickname, this.field_daySec, Integer.valueOf(this.field_isMute), Integer.valueOf(this.field_unReadCount), Integer.valueOf(this.field_sendCount), Integer.valueOf(this.field_enterCount), Integer.valueOf(this.field_disRedDotCount), Long.valueOf(this.field_stayTime), Float.valueOf(this.field_score), Long.valueOf(this.xDa)});
        AppMethodBeat.o(73605);
        return format;
    }

    static {
        AppMethodBeat.i(73606);
        a aVar = new a();
        aVar.xDb = new Field[10];
        aVar.columns = new String[11];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "chatroom";
        aVar.xDd.put("chatroom", "TEXT");
        stringBuilder.append(" chatroom TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "daySec";
        aVar.xDd.put("daySec", "TEXT");
        stringBuilder.append(" daySec TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "nickname";
        aVar.xDd.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "isMute";
        aVar.xDd.put("isMute", "INTEGER");
        stringBuilder.append(" isMute INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "unReadCount";
        aVar.xDd.put("unReadCount", "INTEGER");
        stringBuilder.append(" unReadCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "sendCount";
        aVar.xDd.put("sendCount", "INTEGER");
        stringBuilder.append(" sendCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "enterCount";
        aVar.xDd.put("enterCount", "INTEGER");
        stringBuilder.append(" enterCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "disRedDotCount";
        aVar.xDd.put("disRedDotCount", "INTEGER");
        stringBuilder.append(" disRedDotCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "stayTime";
        aVar.xDd.put("stayTime", "LONG");
        stringBuilder.append(" stayTime LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = b.SCORE;
        aVar.xDd.put(b.SCORE, "FLOAT");
        stringBuilder.append(" score FLOAT");
        aVar.columns[10] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(73606);
    }
}
