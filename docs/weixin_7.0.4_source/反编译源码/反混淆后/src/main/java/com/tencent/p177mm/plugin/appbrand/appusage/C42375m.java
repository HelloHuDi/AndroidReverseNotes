package com.tencent.p177mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C37855n;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.m */
public final class C42375m extends C37855n {
    public static final String[] gSr = new String[]{"username", "versionType"};
    public static final C4924a gSs;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return null;
    }

    static {
        int i = 0;
        AppMethodBeat.m2504i(129571);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[3];
        c4924a.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "username";
        c4924a.xDd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "versionType";
        c4924a.xDd.put("versionType", "INTEGER");
        stringBuilder.append(" versionType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "updateTime";
        c4924a.xDd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        c4924a.columns[3] = "rowid";
        c4924a.sql = stringBuilder.toString();
        gSs = c4924a;
        String str = " PRIMARY KEY ( ";
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
        AppMethodBeat.m2505o(129571);
    }
}
