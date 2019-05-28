package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cv;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class n extends cv {
    public static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(42334);
        a aVar = new a();
        aVar.xDb = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "subtype";
        aVar.xDd.put("subtype", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" subtype INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "subtype";
        aVar.columns[1] = "bubbleMd5";
        aVar.xDd.put("bubbleMd5", "TEXT");
        stringBuilder.append(" bubbleMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "coverMd5";
        aVar.xDd.put("coverMd5", "TEXT");
        stringBuilder.append(" coverMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "minilogoMd5";
        aVar.xDd.put("minilogoMd5", "TEXT");
        stringBuilder.append(" minilogoMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "version";
        aVar.xDd.put("version", "INTEGER");
        stringBuilder.append(" version INTEGER");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(42334);
    }
}
