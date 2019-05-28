package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.u;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class n extends u {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(27350);
        a aVar = new a();
        aVar.xDb = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "flag";
        aVar.xDd.put("flag", "LONG default '0' ");
        stringBuilder.append(" flag LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "appId";
        aVar.xDd.put("appId", "TEXT default '' ");
        stringBuilder.append(" appId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "sortId";
        aVar.xDd.put("sortId", "INTEGER default '0' ");
        stringBuilder.append(" sortId INTEGER default '0' ");
        aVar.columns[3] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(27350);
    }
}
