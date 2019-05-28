package com.tencent.mm.bg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cz;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class f extends cz {
    public static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(78819);
        a aVar = new a();
        aVar.xDb = new Field[9];
        aVar.columns = new String[10];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "wxGroupId";
        aVar.xDd.put("wxGroupId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" wxGroupId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "wxGroupId";
        aVar.columns[1] = "groupId";
        aVar.xDd.put("groupId", "TEXT");
        stringBuilder.append(" groupId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "roomId";
        aVar.xDd.put("roomId", "INTEGER");
        stringBuilder.append(" roomId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "roomKey";
        aVar.xDd.put("roomKey", "LONG");
        stringBuilder.append(" roomKey LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "routeId";
        aVar.xDd.put("routeId", "INTEGER");
        stringBuilder.append(" routeId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "inviteUserName";
        aVar.xDd.put("inviteUserName", "TEXT");
        stringBuilder.append(" inviteUserName TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "memberCount";
        aVar.xDd.put("memberCount", "INTEGER");
        stringBuilder.append(" memberCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "createTime";
        aVar.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "state";
        aVar.xDd.put("state", "INTEGER default '0' ");
        stringBuilder.append(" state INTEGER default '0' ");
        aVar.columns[9] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(78819);
    }
}
