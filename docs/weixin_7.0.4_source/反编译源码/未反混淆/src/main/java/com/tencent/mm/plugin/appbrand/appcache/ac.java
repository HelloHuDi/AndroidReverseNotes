package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dn;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class ac extends dn {
    static final String[] gSr = new String[]{"appId", "type"};
    static final a gSs;

    static {
        int i = 0;
        AppMethodBeat.i(129409);
        a aVar = new a();
        aVar.xDb = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "type";
        aVar.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "hit";
        aVar.xDd.put("hit", "INTEGER");
        stringBuilder.append(" hit INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "hitTimeMS";
        aVar.xDd.put("hitTimeMS", "LONG");
        stringBuilder.append(" hitTimeMS LONG");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        gSs = aVar;
        String str = " PRIMARY KEY (";
        String[] strArr = gSr;
        int length = strArr.length;
        while (i < length) {
            str = str + ", " + strArr[i];
            i++;
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder stringBuilder2 = new StringBuilder();
        a aVar2 = gSs;
        aVar2.sql = stringBuilder2.append(aVar2.sql).append(",").append(str2).toString();
        AppMethodBeat.o(129409);
    }

    public final a Ag() {
        return gSs;
    }
}
