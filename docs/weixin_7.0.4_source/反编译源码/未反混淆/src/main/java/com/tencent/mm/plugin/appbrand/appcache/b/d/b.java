package com.tencent.mm.plugin.appbrand.appcache.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.r;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends r implements com.tencent.mm.plugin.appbrand.q.b {
    static final a fjX;
    static final String[] gSr = new String[]{"appId", "version"};

    static {
        AppMethodBeat.i(129503);
        a aVar = new a();
        aVar.xDb = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "version";
        aVar.xDd.put("version", "INTEGER");
        stringBuilder.append(" version INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "source";
        aVar.xDd.put("source", "INTEGER default '0' ");
        stringBuilder.append(" source INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "hitCount";
        aVar.xDd.put("hitCount", "INTEGER default '0' ");
        stringBuilder.append(" hitCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "reportId";
        aVar.xDd.put("reportId", "INTEGER default '0' ");
        stringBuilder.append(" reportId INTEGER default '0' ");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        fjX = aVar;
        StringBuilder stringBuilder2 = new StringBuilder();
        a aVar2 = fjX;
        aVar2.sql = stringBuilder2.append(aVar2.sql).append(com.tencent.mm.plugin.appbrand.q.b.a.n(gSr)).toString();
        AppMethodBeat.o(129503);
    }

    public final String[] getKeys() {
        return gSr;
    }

    public final a Ag() {
        return fjX;
    }
}
