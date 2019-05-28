package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C26314q;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.at */
public final class C31281at extends C26314q {
    static final C4924a fjX;
    public static final String[] gUR = new String[]{"appId", "version", "debugType"};

    static {
        int i = 0;
        AppMethodBeat.m2504i(101723);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[10];
        c4924a.columns = new String[11];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "version";
        c4924a.xDd.put("version", "INTEGER");
        stringBuilder.append(" version INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "versionMd5";
        c4924a.xDd.put("versionMd5", "TEXT");
        stringBuilder.append(" versionMd5 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "versionState";
        c4924a.xDd.put("versionState", "INTEGER");
        stringBuilder.append(" versionState INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "pkgPath";
        c4924a.xDd.put("pkgPath", "TEXT");
        stringBuilder.append(" pkgPath TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "createTime";
        c4924a.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[6] = "debugType";
        c4924a.xDd.put("debugType", "INTEGER default '0' ");
        stringBuilder.append(" debugType INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[7] = "downloadURL";
        c4924a.xDd.put("downloadURL", "TEXT");
        stringBuilder.append(" downloadURL TEXT");
        stringBuilder.append(", ");
        c4924a.columns[8] = "startTime";
        c4924a.xDd.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[9] = "endTime";
        c4924a.xDd.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        c4924a.columns[10] = "rowid";
        c4924a.sql = stringBuilder.toString();
        fjX = c4924a;
        String str = " PRIMARY KEY (";
        String[] strArr = gUR;
        int length = strArr.length;
        while (i < length) {
            str = str + ", " + strArr[i];
            i++;
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder stringBuilder2 = new StringBuilder();
        C4924a c4924a2 = fjX;
        c4924a2.sql = stringBuilder2.append(c4924a2.sql).append(",").append(str2).toString();
        AppMethodBeat.m2505o(101723);
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return fjX;
    }
}
