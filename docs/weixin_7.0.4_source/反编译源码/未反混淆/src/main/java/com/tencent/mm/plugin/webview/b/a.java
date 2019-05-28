package com.tencent.mm.plugin.webview.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fm;
import java.lang.reflect.Field;

public final class a extends fm {
    protected static com.tencent.mm.sdk.e.c.a ccO;

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(5623);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "appIdKey";
        aVar.xDd.put("appIdKey", "TEXT PRIMARY KEY ");
        stringBuilder.append(" appIdKey TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "appIdKey";
        aVar.columns[2] = "value";
        aVar.xDd.put("value", "TEXT");
        stringBuilder.append(" value TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "weight";
        aVar.xDd.put("weight", "TEXT");
        stringBuilder.append(" weight TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "expireTime";
        aVar.xDd.put("expireTime", "LONG");
        stringBuilder.append(" expireTime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "timeStamp";
        aVar.xDd.put("timeStamp", "LONG");
        stringBuilder.append(" timeStamp LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "size";
        aVar.xDd.put("size", "LONG");
        stringBuilder.append(" size LONG");
        aVar.columns[7] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(5623);
    }
}
