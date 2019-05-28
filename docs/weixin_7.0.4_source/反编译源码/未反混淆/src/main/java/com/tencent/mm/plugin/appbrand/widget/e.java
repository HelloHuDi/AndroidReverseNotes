package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class e extends ay {
    public static a fjX;

    public final a Ag() {
        return fjX;
    }

    static {
        AppMethodBeat.i(70649);
        a aVar = new a();
        aVar.xDb = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "id";
        aVar.xDd.put("id", "TEXT");
        stringBuilder.append(" id TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "cacheKey";
        aVar.xDd.put("cacheKey", "TEXT");
        stringBuilder.append(" cacheKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "appId";
        aVar.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "data";
        aVar.xDd.put("data", "TEXT");
        stringBuilder.append(" data TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "interval";
        aVar.xDd.put("interval", "INTEGER");
        stringBuilder.append(" interval INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "updateTime";
        aVar.xDd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        fjX = aVar;
        AppMethodBeat.o(70649);
    }
}
