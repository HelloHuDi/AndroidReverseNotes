package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ar;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class af extends ar {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(29023);
        a aVar = new a();
        aVar.xDb = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "labelID";
        aVar.xDd.put("labelID", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" labelID INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "labelID";
        aVar.columns[1] = "labelName";
        aVar.xDd.put("labelName", "TEXT");
        stringBuilder.append(" labelName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "labelPYFull";
        aVar.xDd.put("labelPYFull", "TEXT");
        stringBuilder.append(" labelPYFull TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "labelPYShort";
        aVar.xDd.put("labelPYShort", "TEXT");
        stringBuilder.append(" labelPYShort TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "createTime";
        aVar.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "isTemporary";
        aVar.xDd.put("isTemporary", "INTEGER");
        stringBuilder.append(" isTemporary INTEGER");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(29023);
    }
}
