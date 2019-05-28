package com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C26308dp;
import com.tencent.p177mm.plugin.appbrand.p911q.C19677b;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.e.c */
public final class C38113c extends C26308dp implements C19677b {
    static final C4924a fjX;
    static final String[] gSr = new String[]{"appId", "type", "version"};

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return fjX;
    }

    static {
        int i = 0;
        AppMethodBeat.m2504i(129510);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[11];
        c4924a.columns = new String[12];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "version";
        c4924a.xDd.put("version", "INTEGER");
        stringBuilder.append(" version INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "type";
        c4924a.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "retryTimes";
        c4924a.xDd.put("retryTimes", "INTEGER");
        stringBuilder.append(" retryTimes INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "retriedCount";
        c4924a.xDd.put("retriedCount", "INTEGER");
        stringBuilder.append(" retriedCount INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[5] = "retryInterval";
        c4924a.xDd.put("retryInterval", "LONG");
        stringBuilder.append(" retryInterval LONG");
        stringBuilder.append(", ");
        c4924a.columns[6] = "networkType";
        c4924a.xDd.put("networkType", "INTEGER");
        stringBuilder.append(" networkType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[7] = "pkgMd5";
        c4924a.xDd.put("pkgMd5", "TEXT");
        stringBuilder.append(" pkgMd5 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[8] = "lastRetryTime";
        c4924a.xDd.put("lastRetryTime", "LONG");
        stringBuilder.append(" lastRetryTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[9] = "firstTimeTried";
        c4924a.xDd.put("firstTimeTried", "INTEGER");
        stringBuilder.append(" firstTimeTried INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[10] = "reportId";
        c4924a.xDd.put("reportId", "INTEGER");
        stringBuilder.append(" reportId INTEGER");
        c4924a.columns[11] = "rowid";
        c4924a.sql = stringBuilder.toString();
        fjX = c4924a;
        String str = " PRIMARY KEY ( ";
        String[] strArr = gSr;
        int length = strArr.length;
        while (i < length) {
            str = str + ", " + strArr[i];
            i++;
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder stringBuilder2 = new StringBuilder();
        C4924a c4924a2 = fjX;
        c4924a2.sql = stringBuilder2.append(c4924a2.sql).append(",").append(str2).toString();
        AppMethodBeat.m2505o(129510);
    }

    public final String[] getKeys() {
        return gSr;
    }
}
