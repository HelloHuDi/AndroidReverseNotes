package com.tencent.mm.plugin.boots.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.e;
import java.lang.reflect.Field;

public final class a extends e {
    public static com.tencent.mm.sdk.e.c.a ccO;

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(105575);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.xDd.put("key", "INTEGER PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(" key INTEGER PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.xDc = "key";
        aVar.columns[1] = "mau";
        aVar.xDd.put("mau", "INTEGER");
        stringBuilder.append(" mau INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "dau";
        aVar.xDd.put("dau", "INTEGER");
        stringBuilder.append(" dau INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "useTime";
        aVar.xDd.put("useTime", "LONG");
        stringBuilder.append(" useTime LONG");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(105575);
    }
}
