package com.tencent.mm.plugin.expt.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bi;
import java.lang.reflect.Field;

public final class a extends bi {
    protected static com.tencent.mm.sdk.e.c.a ccO;

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(73607);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "exptKey";
        aVar.xDd.put("exptKey", "TEXT PRIMARY KEY ");
        stringBuilder.append(" exptKey TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "exptKey";
        aVar.columns[1] = "exptId";
        aVar.xDd.put("exptId", "INTEGER");
        stringBuilder.append(" exptId INTEGER");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(73607);
    }
}
