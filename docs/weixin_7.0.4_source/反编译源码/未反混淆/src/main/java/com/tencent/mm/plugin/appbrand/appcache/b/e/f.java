package com.tencent.mm.plugin.appbrand.appcache.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dr;
import com.tencent.mm.plugin.appbrand.q.b;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class f extends dr implements b {
    static final a fjX;
    static final String[] gSr = new String[]{"appId", "scene"};

    public final a Ag() {
        return fjX;
    }

    static {
        int i = 0;
        AppMethodBeat.i(129516);
        a aVar = new a();
        aVar.xDb = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "scene";
        aVar.xDd.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "launchProtoBlob";
        aVar.xDd.put("launchProtoBlob", "BLOB");
        stringBuilder.append(" launchProtoBlob BLOB");
        stringBuilder.append(", ");
        aVar.columns[3] = "startTime";
        aVar.xDd.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "endTime";
        aVar.xDd.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "reportId";
        aVar.xDd.put("reportId", "LONG");
        stringBuilder.append(" reportId LONG");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        fjX = aVar;
        String str = " PRIMARY KEY ( ";
        String[] strArr = gSr;
        int length = strArr.length;
        while (i < length) {
            str = str + ", " + strArr[i];
            i++;
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder stringBuilder2 = new StringBuilder();
        a aVar2 = fjX;
        aVar2.sql = stringBuilder2.append(aVar2.sql).append(",").append(str2).toString();
        AppMethodBeat.o(129516);
    }

    public final String[] getKeys() {
        return gSr;
    }
}
