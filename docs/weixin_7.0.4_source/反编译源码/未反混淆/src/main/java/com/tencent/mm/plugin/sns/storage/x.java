package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ey;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class x extends ey {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(38032);
        a aVar = new a();
        aVar.xDb = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "canvasId";
        aVar.xDd.put("canvasId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" canvasId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "canvasId";
        aVar.columns[1] = "canvasXml";
        aVar.xDd.put("canvasXml", "TEXT");
        stringBuilder.append(" canvasXml TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "createTime";
        aVar.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "canvasExt";
        aVar.xDd.put("canvasExt", "TEXT");
        stringBuilder.append(" canvasExt TEXT");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(38032);
    }
}
