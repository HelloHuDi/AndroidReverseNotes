package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.q;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class at extends q {
    static final a fjX;
    public static final String[] gUR = new String[]{"appId", "version", "debugType"};

    static {
        int i = 0;
        AppMethodBeat.i(101723);
        a aVar = new a();
        aVar.xDb = new Field[10];
        aVar.columns = new String[11];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "version";
        aVar.xDd.put("version", "INTEGER");
        stringBuilder.append(" version INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "versionMd5";
        aVar.xDd.put("versionMd5", "TEXT");
        stringBuilder.append(" versionMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "versionState";
        aVar.xDd.put("versionState", "INTEGER");
        stringBuilder.append(" versionState INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "pkgPath";
        aVar.xDd.put("pkgPath", "TEXT");
        stringBuilder.append(" pkgPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "createTime";
        aVar.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "debugType";
        aVar.xDd.put("debugType", "INTEGER default '0' ");
        stringBuilder.append(" debugType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "downloadURL";
        aVar.xDd.put("downloadURL", "TEXT");
        stringBuilder.append(" downloadURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "startTime";
        aVar.xDd.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "endTime";
        aVar.xDd.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        aVar.columns[10] = "rowid";
        aVar.sql = stringBuilder.toString();
        fjX = aVar;
        String str = " PRIMARY KEY (";
        String[] strArr = gUR;
        int length = strArr.length;
        while (i < length) {
            str = str + ", " + strArr[i];
            i++;
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder stringBuilder2 = new StringBuilder();
        a aVar2 = fjX;
        aVar2.sql = stringBuilder2.append(aVar2.sql).append(",").append(str2).toString();
        AppMethodBeat.o(101723);
    }

    public final a Ag() {
        return fjX;
    }
}
