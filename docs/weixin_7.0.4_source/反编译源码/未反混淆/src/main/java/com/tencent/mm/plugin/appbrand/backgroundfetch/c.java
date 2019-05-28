package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.j;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends j {
    public static a hcb;
    static final String[] hcc = new String[]{"username", "fetchType"};

    static {
        int i = 0;
        AppMethodBeat.i(129770);
        a aVar = new a();
        aVar.xDb = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.xDd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "fetchType";
        aVar.xDd.put("fetchType", "INTEGER");
        stringBuilder.append(" fetchType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "updateTime";
        aVar.xDd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "path";
        aVar.xDd.put("path", "TEXT");
        stringBuilder.append(" path TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = SearchIntents.EXTRA_QUERY;
        aVar.xDd.put(SearchIntents.EXTRA_QUERY, "TEXT");
        stringBuilder.append(" query TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "scene";
        aVar.xDd.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "data";
        aVar.xDd.put("data", "TEXT");
        stringBuilder.append(" data TEXT");
        aVar.columns[7] = "rowid";
        aVar.sql = stringBuilder.toString();
        hcb = aVar;
        String str = " PRIMARY KEY ( ";
        String[] strArr = hcc;
        int length = strArr.length;
        while (i < length) {
            str = str + ", " + strArr[i];
            i++;
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder stringBuilder2 = new StringBuilder();
        a aVar2 = hcb;
        aVar2.sql = stringBuilder2.append(aVar2.sql).append(",").append(str2).toString();
        AppMethodBeat.o(129770);
    }

    public final a Ag() {
        return hcb;
    }
}
