package com.tencent.mm.plugin.multitalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.da;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends da {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(54110);
        a aVar = new a();
        aVar.xDb = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "memberUuid";
        aVar.xDd.put("memberUuid", "LONG");
        stringBuilder.append(" memberUuid LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "wxGroupId";
        aVar.xDd.put("wxGroupId", "TEXT");
        stringBuilder.append(" wxGroupId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "userName";
        aVar.xDd.put("userName", "TEXT");
        stringBuilder.append(" userName TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "inviteUserName";
        aVar.xDd.put("inviteUserName", "TEXT");
        stringBuilder.append(" inviteUserName TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "memberId";
        aVar.xDd.put("memberId", "LONG");
        stringBuilder.append(" memberId LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "status";
        aVar.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "createTime";
        aVar.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        aVar.columns[7] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(54110);
    }
}
