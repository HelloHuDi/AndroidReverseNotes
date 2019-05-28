package com.tencent.mm.plugin.appbrand.appcache.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fv;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class g extends fv {
    static final a fjX;

    public final a Ag() {
        return fjX;
    }

    static {
        AppMethodBeat.i(129517);
        a aVar = new a();
        aVar.xDb = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.xDd.put("username", "TEXT PRIMARY KEY ");
        stringBuilder.append(" username TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "username";
        aVar.columns[1] = "appVersion";
        aVar.xDd.put("appVersion", "INTEGER");
        stringBuilder.append(" appVersion INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "reportId";
        aVar.xDd.put("reportId", "INTEGER");
        stringBuilder.append(" reportId INTEGER");
        aVar.columns[3] = "rowid";
        aVar.sql = stringBuilder.toString();
        fjX = aVar;
        AppMethodBeat.o(129517);
    }
}
