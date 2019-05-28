package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cr;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class ab extends cr {
    public static final a gSs;

    public final a Ag() {
        return gSs;
    }

    static {
        AppMethodBeat.i(94157);
        a aVar = new a();
        aVar.xDb = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "launchPB";
        aVar.xDd.put("launchPB", "BLOB");
        stringBuilder.append(" launchPB BLOB");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        gSs = aVar;
        AppMethodBeat.o(94157);
    }
}
