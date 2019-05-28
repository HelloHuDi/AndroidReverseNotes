package com.tencent.mm.plugin.appbrand.appcache.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dp;
import com.tencent.mm.plugin.appbrand.q.b;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends dp implements b {
    static final a fjX;
    static final String[] gSr = new String[]{"appId", "type", "version"};

    public final a Ag() {
        return fjX;
    }

    static {
        int i = 0;
        AppMethodBeat.i(129510);
        a aVar = new a();
        aVar.xDb = new Field[11];
        aVar.columns = new String[12];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "version";
        aVar.xDd.put("version", "INTEGER");
        stringBuilder.append(" version INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "type";
        aVar.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "retryTimes";
        aVar.xDd.put("retryTimes", "INTEGER");
        stringBuilder.append(" retryTimes INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "retriedCount";
        aVar.xDd.put("retriedCount", "INTEGER");
        stringBuilder.append(" retriedCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "retryInterval";
        aVar.xDd.put("retryInterval", "LONG");
        stringBuilder.append(" retryInterval LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "networkType";
        aVar.xDd.put("networkType", "INTEGER");
        stringBuilder.append(" networkType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "pkgMd5";
        aVar.xDd.put("pkgMd5", "TEXT");
        stringBuilder.append(" pkgMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "lastRetryTime";
        aVar.xDd.put("lastRetryTime", "LONG");
        stringBuilder.append(" lastRetryTime LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "firstTimeTried";
        aVar.xDd.put("firstTimeTried", "INTEGER");
        stringBuilder.append(" firstTimeTried INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "reportId";
        aVar.xDd.put("reportId", "INTEGER");
        stringBuilder.append(" reportId INTEGER");
        aVar.columns[11] = "rowid";
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
        AppMethodBeat.o(129510);
    }

    public final String[] getKeys() {
        return gSr;
    }
}
