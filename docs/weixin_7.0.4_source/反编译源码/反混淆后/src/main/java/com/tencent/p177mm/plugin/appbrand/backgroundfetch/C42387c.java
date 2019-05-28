package com.tencent.p177mm.plugin.appbrand.backgroundfetch;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C6583j;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.appbrand.backgroundfetch.c */
public final class C42387c extends C6583j {
    public static C4924a hcb;
    static final String[] hcc = new String[]{"username", "fetchType"};

    static {
        int i = 0;
        AppMethodBeat.m2504i(129770);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[7];
        c4924a.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "username";
        c4924a.xDd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "fetchType";
        c4924a.xDd.put("fetchType", "INTEGER");
        stringBuilder.append(" fetchType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "updateTime";
        c4924a.xDd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[3] = "path";
        c4924a.xDd.put("path", "TEXT");
        stringBuilder.append(" path TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = SearchIntents.EXTRA_QUERY;
        c4924a.xDd.put(SearchIntents.EXTRA_QUERY, "TEXT");
        stringBuilder.append(" query TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "scene";
        c4924a.xDd.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[6] = "data";
        c4924a.xDd.put("data", "TEXT");
        stringBuilder.append(" data TEXT");
        c4924a.columns[7] = "rowid";
        c4924a.sql = stringBuilder.toString();
        hcb = c4924a;
        String str = " PRIMARY KEY ( ";
        String[] strArr = hcc;
        int length = strArr.length;
        while (i < length) {
            str = str + ", " + strArr[i];
            i++;
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder stringBuilder2 = new StringBuilder();
        C4924a c4924a2 = hcb;
        c4924a2.sql = stringBuilder2.append(c4924a2.sql).append(",").append(str2).toString();
        AppMethodBeat.m2505o(129770);
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return hcb;
    }
}
