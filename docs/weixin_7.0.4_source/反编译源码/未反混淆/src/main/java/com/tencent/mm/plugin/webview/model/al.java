package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fq;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class al extends fq {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(6736);
        a aVar = new a();
        aVar.xDb = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "recordId";
        aVar.xDd.put("recordId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" recordId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "recordId";
        aVar.columns[1] = "appId";
        aVar.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "domin";
        aVar.xDd.put("domin", "TEXT");
        stringBuilder.append(" domin TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "key";
        aVar.xDd.put("key", "TEXT");
        stringBuilder.append(" key TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "value";
        aVar.xDd.put("value", "TEXT");
        stringBuilder.append(" value TEXT");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(6736);
    }
}
