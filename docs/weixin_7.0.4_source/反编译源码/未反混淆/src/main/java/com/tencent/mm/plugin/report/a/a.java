package com.tencent.mm.plugin.report.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import java.lang.reflect.Field;

public final class a extends ax {
    protected static com.tencent.mm.sdk.e.c.a ccO;

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(72663);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "bakLogId";
        aVar.xDd.put("bakLogId", "INTEGER");
        stringBuilder.append(" bakLogId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[1] = "valueStr";
        aVar.xDd.put("valueStr", "TEXT");
        stringBuilder.append(" valueStr TEXT");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(72663);
    }
}
