package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fo;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class i extends fo {
    public static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(7021);
        a aVar = new a();
        aVar.xDb = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "host";
        aVar.xDd.put("host", "TEXT");
        stringBuilder.append(" host TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "expireTime";
        aVar.xDd.put("expireTime", "LONG");
        stringBuilder.append(" expireTime LONG");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(7021);
    }
}
