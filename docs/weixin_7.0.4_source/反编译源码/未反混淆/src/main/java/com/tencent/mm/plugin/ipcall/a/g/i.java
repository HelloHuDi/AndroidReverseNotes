package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class i extends cm {
    public static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(21936);
        a aVar = new a();
        aVar.xDb = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "countryCode";
        aVar.xDd.put("countryCode", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" countryCode INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "countryCode";
        aVar.columns[1] = "callTimeCount";
        aVar.xDd.put("callTimeCount", "LONG");
        stringBuilder.append(" callTimeCount LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "lastCallTime";
        aVar.xDd.put("lastCallTime", "LONG");
        stringBuilder.append(" lastCallTime LONG");
        aVar.columns[3] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(21936);
    }
}
