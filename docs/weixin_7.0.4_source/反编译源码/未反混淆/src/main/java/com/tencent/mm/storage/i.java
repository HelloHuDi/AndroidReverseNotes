package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.v;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class i extends v {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(29002);
        a aVar = new a();
        aVar.xDb = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "deviceId";
        aVar.xDd.put("deviceId", "TEXT default '' ");
        stringBuilder.append(" deviceId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "sessionName";
        aVar.xDd.put("sessionName", "TEXT default '' ");
        stringBuilder.append(" sessionName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "moveTime";
        aVar.xDd.put("moveTime", "BLOB default '' ");
        stringBuilder.append(" moveTime BLOB default '' ");
        aVar.columns[3] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(29002);
    }
}
