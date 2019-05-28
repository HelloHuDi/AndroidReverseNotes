package com.tencent.mm.plugin.appbrand.appcache.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.do;
import java.lang.reflect.Field;

public final class a extends do {
    static final com.tencent.mm.sdk.e.c.a fjX;

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return fjX;
    }

    public final String toString() {
        AppMethodBeat.i(129504);
        String str = "CmdBlockCgiPersistentInfo{field_username='" + this.field_username + '\'' + ", field_appId='" + this.field_appId + '\'' + ", field_startTime=" + this.field_startTime + ", field_endTime=" + this.field_endTime + ", field_sceneList='" + this.field_sceneList + '\'' + ", field_cgiList='" + this.field_cgiList + '\'' + ", field_reportId=" + this.field_reportId + '}';
        AppMethodBeat.o(129504);
        return str;
    }

    static {
        AppMethodBeat.i(129505);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.xDd.put("username", "TEXT PRIMARY KEY ");
        stringBuilder.append(" username TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "username";
        aVar.columns[1] = "appId";
        aVar.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "startTime";
        aVar.xDd.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "endTime";
        aVar.xDd.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "sceneList";
        aVar.xDd.put("sceneList", "TEXT");
        stringBuilder.append(" sceneList TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "cgiList";
        aVar.xDd.put("cgiList", "TEXT");
        stringBuilder.append(" cgiList TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "reportId";
        aVar.xDd.put("reportId", "INTEGER");
        stringBuilder.append(" reportId INTEGER");
        aVar.columns[7] = "rowid";
        aVar.sql = stringBuilder.toString();
        fjX = aVar;
        AppMethodBeat.o(129505);
    }
}
