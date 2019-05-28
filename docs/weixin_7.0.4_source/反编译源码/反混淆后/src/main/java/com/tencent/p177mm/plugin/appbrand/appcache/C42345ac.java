package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C26307dn;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.ac */
public final class C42345ac extends C26307dn {
    static final String[] gSr = new String[]{"appId", "type"};
    static final C4924a gSs;

    static {
        int i = 0;
        AppMethodBeat.m2504i(129409);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[4];
        c4924a.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "type";
        c4924a.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "hit";
        c4924a.xDd.put("hit", "INTEGER");
        stringBuilder.append(" hit INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "hitTimeMS";
        c4924a.xDd.put("hitTimeMS", "LONG");
        stringBuilder.append(" hitTimeMS LONG");
        c4924a.columns[4] = "rowid";
        c4924a.sql = stringBuilder.toString();
        gSs = c4924a;
        String str = " PRIMARY KEY (";
        String[] strArr = gSr;
        int length = strArr.length;
        while (i < length) {
            str = str + ", " + strArr[i];
            i++;
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder stringBuilder2 = new StringBuilder();
        C4924a c4924a2 = gSs;
        c4924a2.sql = stringBuilder2.append(c4924a2.sql).append(",").append(str2).toString();
        AppMethodBeat.m2505o(129409);
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return gSs;
    }
}
