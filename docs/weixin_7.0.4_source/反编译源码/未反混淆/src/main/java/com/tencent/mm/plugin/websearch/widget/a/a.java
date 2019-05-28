package com.tencent.mm.plugin.websearch.widget.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ft;
import java.lang.reflect.Field;

public final class a extends ft {
    public static com.tencent.mm.sdk.e.c.a ccO;

    static {
        AppMethodBeat.i(91457);
        Class cls = b.class;
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appid";
        aVar.xDd.put("appid", "TEXT PRIMARY KEY ");
        stringBuilder.append(" appid TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "appid";
        aVar.columns[1] = "jsExceptionCount";
        aVar.xDd.put("jsExceptionCount", "INTEGER");
        stringBuilder.append(" jsExceptionCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "crashCount";
        aVar.xDd.put("crashCount", "INTEGER");
        stringBuilder.append(" crashCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "beginTimestamp";
        aVar.xDd.put("beginTimestamp", "LONG");
        stringBuilder.append(" beginTimestamp LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "pkgVersion";
        aVar.xDd.put("pkgVersion", "INTEGER");
        stringBuilder.append(" pkgVersion INTEGER");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(91457);
    }

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }
}
