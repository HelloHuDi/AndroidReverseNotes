package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dt;
import com.tencent.mm.plugin.appbrand.q.b;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class ag extends dt implements b {
    static final a fjX;
    static final String[] gSr = new String[]{"appId", "appVersion"};

    public final a Ag() {
        return fjX;
    }

    static {
        int i = 0;
        AppMethodBeat.i(59451);
        a aVar = new a();
        aVar.xDb = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "appVersion";
        aVar.xDd.put("appVersion", "INTEGER");
        stringBuilder.append(" appVersion INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "decryptKey";
        aVar.xDd.put("decryptKey", "TEXT");
        stringBuilder.append(" decryptKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "pkgMd5";
        aVar.xDd.put("pkgMd5", "TEXT");
        stringBuilder.append(" pkgMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "reportId";
        aVar.xDd.put("reportId", "INTEGER");
        stringBuilder.append(" reportId INTEGER");
        aVar.columns[5] = "rowid";
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
        AppMethodBeat.o(59451);
    }

    public final String[] getKeys() {
        return gSr;
    }
}
