package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.i;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends i {
    static final a fjX;

    public final a Ag() {
        return fjX;
    }

    static {
        AppMethodBeat.i(129531);
        a aVar = new a();
        aVar.xDb = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.xDd.put("username", "TEXT PRIMARY KEY ");
        stringBuilder.append(" username TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "username";
        aVar.columns[1] = "updateTime";
        aVar.xDd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        fjX = aVar;
        AppMethodBeat.o(129531);
    }
}
