package com.tencent.p177mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C18460av;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.k */
public final class C42610k extends C18460av {
    static final String[] gSr = new String[]{"appId", "versionType"};
    static final C4924a gSs;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return null;
    }

    static {
        int i = 0;
        AppMethodBeat.m2504i(102101);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[3];
        c4924a.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "versionType";
        c4924a.xDd.put("versionType", "INTEGER");
        stringBuilder.append(" versionType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "extJson";
        c4924a.xDd.put("extJson", "TEXT");
        stringBuilder.append(" extJson TEXT");
        c4924a.columns[3] = "rowid";
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
        AppMethodBeat.m2505o(102101);
    }
}
