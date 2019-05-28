package com.tencent.p177mm.p203bg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C32686cz;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.bg.f */
public final class C1310f extends C32686cz {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(78819);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[9];
        c4924a.columns = new String[10];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "wxGroupId";
        c4924a.xDd.put("wxGroupId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" wxGroupId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "wxGroupId";
        c4924a.columns[1] = "groupId";
        c4924a.xDd.put("groupId", "TEXT");
        stringBuilder.append(" groupId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "roomId";
        c4924a.xDd.put("roomId", "INTEGER");
        stringBuilder.append(" roomId INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "roomKey";
        c4924a.xDd.put("roomKey", "LONG");
        stringBuilder.append(" roomKey LONG");
        stringBuilder.append(", ");
        c4924a.columns[4] = "routeId";
        c4924a.xDd.put("routeId", "INTEGER");
        stringBuilder.append(" routeId INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[5] = "inviteUserName";
        c4924a.xDd.put("inviteUserName", "TEXT");
        stringBuilder.append(" inviteUserName TEXT");
        stringBuilder.append(", ");
        c4924a.columns[6] = "memberCount";
        c4924a.xDd.put("memberCount", "INTEGER");
        stringBuilder.append(" memberCount INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[7] = "createTime";
        c4924a.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[8] = "state";
        c4924a.xDd.put("state", "INTEGER default '0' ");
        stringBuilder.append(" state INTEGER default '0' ");
        c4924a.columns[9] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(78819);
    }
}
