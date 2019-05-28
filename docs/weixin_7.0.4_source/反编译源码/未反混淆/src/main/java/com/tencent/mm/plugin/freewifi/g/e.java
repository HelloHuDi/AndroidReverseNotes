package com.tencent.mm.plugin.freewifi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bv;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class e extends bv {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(20885);
        a aVar = new a();
        aVar.xDb = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "id";
        aVar.xDd.put("id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "id";
        aVar.columns[1] = "protocolNumber";
        aVar.xDd.put("protocolNumber", "INTEGER");
        stringBuilder.append(" protocolNumber INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "logContent";
        aVar.xDd.put("logContent", "TEXT");
        stringBuilder.append(" logContent TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "createTime";
        aVar.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(20885);
    }
}
