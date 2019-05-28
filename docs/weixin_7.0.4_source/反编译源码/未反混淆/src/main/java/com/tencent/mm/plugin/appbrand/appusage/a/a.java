package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.o;
import com.tencent.mm.protocal.protobuf.bqd;
import java.lang.reflect.Field;

public final class a extends o {
    public static com.tencent.mm.sdk.e.c.a ccO;

    static {
        AppMethodBeat.i(129733);
        Class cls = bqd.class;
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xDd.put("appId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" appId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "appId";
        aVar.columns[1] = "recommendCard";
        aVar.xDd.put("recommendCard", "BLOB");
        stringBuilder.append(" recommendCard BLOB");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(129733);
    }

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }
}
