package com.tencent.p177mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C42104ay;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.e */
public final class C44718e extends C42104ay {
    public static C4924a fjX;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return fjX;
    }

    static {
        AppMethodBeat.m2504i(70649);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[6];
        c4924a.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "id";
        c4924a.xDd.put("id", "TEXT");
        stringBuilder.append(" id TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "cacheKey";
        c4924a.xDd.put("cacheKey", "TEXT");
        stringBuilder.append(" cacheKey TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "data";
        c4924a.xDd.put("data", "TEXT");
        stringBuilder.append(" data TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "interval";
        c4924a.xDd.put("interval", "INTEGER");
        stringBuilder.append(" interval INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[5] = "updateTime";
        c4924a.xDd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        c4924a.columns[6] = "rowid";
        c4924a.sql = stringBuilder.toString();
        fjX = c4924a;
        AppMethodBeat.m2505o(70649);
    }
}
