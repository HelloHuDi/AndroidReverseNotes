package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C32688dt;
import com.tencent.p177mm.plugin.appbrand.p911q.C19677b;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.ag */
public final class C42347ag extends C32688dt implements C19677b {
    static final C4924a fjX;
    static final String[] gSr = new String[]{"appId", "appVersion"};

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return fjX;
    }

    static {
        int i = 0;
        AppMethodBeat.m2504i(59451);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[5];
        c4924a.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "appVersion";
        c4924a.xDd.put("appVersion", "INTEGER");
        stringBuilder.append(" appVersion INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "decryptKey";
        c4924a.xDd.put("decryptKey", "TEXT");
        stringBuilder.append(" decryptKey TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "pkgMd5";
        c4924a.xDd.put("pkgMd5", "TEXT");
        stringBuilder.append(" pkgMd5 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "reportId";
        c4924a.xDd.put("reportId", "INTEGER");
        stringBuilder.append(" reportId INTEGER");
        c4924a.columns[5] = "rowid";
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
        AppMethodBeat.m2505o(59451);
    }

    public final String[] getKeys() {
        return gSr;
    }
}
