package com.tencent.mm.plugin.aa.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.b;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends b {
    public static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(40666);
        a aVar = new a();
        aVar.xDb = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "billNo";
        aVar.xDd.put("billNo", "TEXT PRIMARY KEY ");
        stringBuilder.append(" billNo TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "billNo";
        aVar.columns[1] = "insertmsg";
        aVar.xDd.put("insertmsg", "INTEGER");
        stringBuilder.append(" insertmsg INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "localMsgId";
        aVar.xDd.put("localMsgId", "LONG");
        stringBuilder.append(" localMsgId LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "status";
        aVar.xDd.put("status", "INTEGER default '-1' ");
        stringBuilder.append(" status INTEGER default '-1' ");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(40666);
    }
}
