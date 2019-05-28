package com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C42113dr;
import com.tencent.p177mm.plugin.appbrand.p911q.C19677b;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.e.f */
public final class C10087f extends C42113dr implements C19677b {
    static final C4924a fjX;
    static final String[] gSr = new String[]{"appId", "scene"};

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return fjX;
    }

    static {
        int i = 0;
        AppMethodBeat.m2504i(129516);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[6];
        c4924a.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "scene";
        c4924a.xDd.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "launchProtoBlob";
        c4924a.xDd.put("launchProtoBlob", "BLOB");
        stringBuilder.append(" launchProtoBlob BLOB");
        stringBuilder.append(", ");
        c4924a.columns[3] = "startTime";
        c4924a.xDd.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[4] = "endTime";
        c4924a.xDd.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[5] = "reportId";
        c4924a.xDd.put("reportId", "LONG");
        stringBuilder.append(" reportId LONG");
        c4924a.columns[6] = "rowid";
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
        AppMethodBeat.m2505o(129516);
    }

    public final String[] getKeys() {
        return gSr;
    }
}
