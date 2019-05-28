package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.y;
import com.tencent.mm.protocal.protobuf.er;
import java.lang.reflect.Field;

public final class a extends y {
    public static com.tencent.mm.sdk.e.c.a fjX;

    public a(er erVar) {
        this.field_url = erVar.Url;
        this.field_reportTime = erVar.vGy;
    }

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return fjX;
    }

    public final String toString() {
        AppMethodBeat.i(14393);
        String str = "BizAppMsgReportContext{field_appMsgReportContextId=" + this.field_appMsgReportContextId + ", field_url='" + this.field_url + '\'' + ", field_reportTime=" + this.field_reportTime + ", field_aScene=" + this.field_aScene + '}';
        AppMethodBeat.o(14393);
        return str;
    }

    static {
        AppMethodBeat.i(14394);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appMsgReportContextId";
        aVar.xDd.put("appMsgReportContextId", "LONG PRIMARY KEY ");
        stringBuilder.append(" appMsgReportContextId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "appMsgReportContextId";
        aVar.columns[1] = "url";
        aVar.xDd.put("url", "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "reportTime";
        aVar.xDd.put("reportTime", "LONG");
        stringBuilder.append(" reportTime LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "aScene";
        aVar.xDd.put("aScene", "INTEGER");
        stringBuilder.append(" aScene INTEGER");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        fjX = aVar;
        AppMethodBeat.o(14394);
    }
}
