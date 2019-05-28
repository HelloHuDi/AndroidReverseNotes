package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bg;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class m extends bg {
    protected static a ccO;

    public final a Ag() {
        return null;
    }

    static {
        AppMethodBeat.i(62862);
        a aVar = new a();
        aVar.xDb = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "prodcutID";
        aVar.xDd.put("prodcutID", "TEXT PRIMARY KEY ");
        stringBuilder.append(" prodcutID TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "prodcutID";
        aVar.columns[1] = "totalCount";
        aVar.xDd.put("totalCount", "INTEGER");
        stringBuilder.append(" totalCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "continuCount";
        aVar.xDd.put("continuCount", "INTEGER");
        stringBuilder.append(" continuCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "flag";
        aVar.xDd.put("flag", "INTEGER");
        stringBuilder.append(" flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "modifyTime";
        aVar.xDd.put("modifyTime", "LONG");
        stringBuilder.append(" modifyTime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "showTipsTime";
        aVar.xDd.put("showTipsTime", "LONG");
        stringBuilder.append(" showTipsTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "setFlagTime";
        aVar.xDd.put("setFlagTime", "LONG");
        stringBuilder.append(" setFlagTime LONG");
        aVar.columns[7] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(62862);
    }
}
