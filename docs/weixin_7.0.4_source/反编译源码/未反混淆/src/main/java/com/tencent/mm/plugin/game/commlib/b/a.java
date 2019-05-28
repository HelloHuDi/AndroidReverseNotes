package com.tencent.mm.plugin.game.commlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dj;
import java.lang.reflect.Field;

public final class a extends dj {
    protected static com.tencent.mm.sdk.e.c.a ccO;

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(59417);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.xDd.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "key";
        aVar.columns[1] = "value";
        aVar.xDd.put("value", "BLOB");
        stringBuilder.append(" value BLOB");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(59417);
    }
}
