package com.tencent.mm.plugin.webview.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fn;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class d extends fn {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(5645);
        a aVar = new a();
        aVar.xDb = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "recordId";
        aVar.xDd.put("recordId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" recordId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "recordId";
        aVar.columns[1] = "link";
        aVar.xDd.put("link", "TEXT");
        stringBuilder.append(" link TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "title";
        aVar.xDd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "source";
        aVar.xDd.put("source", "TEXT");
        stringBuilder.append(" source TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "imgUrl";
        aVar.xDd.put("imgUrl", "TEXT");
        stringBuilder.append(" imgUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "timeStamp";
        aVar.xDd.put("timeStamp", "LONG");
        stringBuilder.append(" timeStamp LONG");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(5645);
    }
}
