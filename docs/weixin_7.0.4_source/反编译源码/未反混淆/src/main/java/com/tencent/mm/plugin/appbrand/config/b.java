package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.k;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends k {
    public static final a fjX;

    public final a Ag() {
        return fjX;
    }

    static {
        AppMethodBeat.i(101783);
        a aVar = new a();
        aVar.xDb = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.xDd.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "key";
        aVar.columns[1] = "value";
        aVar.xDd.put("value", "TEXT");
        stringBuilder.append(" value TEXT");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        fjX = aVar;
        AppMethodBeat.o(101783);
    }
}
