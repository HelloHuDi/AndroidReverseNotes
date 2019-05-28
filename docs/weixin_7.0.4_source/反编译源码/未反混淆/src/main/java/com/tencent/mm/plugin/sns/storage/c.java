package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ah;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends ah {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(36917);
        a aVar = new a();
        aVar.xDb = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "canvasId";
        aVar.xDd.put("canvasId", "LONG PRIMARY KEY ");
        stringBuilder.append(" canvasId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "canvasId";
        aVar.columns[1] = "canvasXml";
        aVar.xDd.put("canvasXml", "TEXT");
        stringBuilder.append(" canvasXml TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "createTime";
        aVar.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        aVar.columns[3] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(36917);
    }
}
