package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.c;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;

public final class a extends c {
    protected static com.tencent.mm.sdk.e.c.a ccO;

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    public final boolean isValid() {
        AppMethodBeat.i(118200);
        long anT = bo.anT();
        if (anT < this.field_startTime || anT >= this.field_endTime) {
            AppMethodBeat.o(118200);
            return false;
        }
        AppMethodBeat.o(118200);
        return true;
    }

    static {
        AppMethodBeat.i(118201);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[8];
        aVar.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "abtestkey";
        aVar.xDd.put("abtestkey", "TEXT PRIMARY KEY ");
        stringBuilder.append(" abtestkey TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "abtestkey";
        aVar.columns[1] = "value";
        aVar.xDd.put("value", "TEXT");
        stringBuilder.append(" value TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "expId";
        aVar.xDd.put("expId", "TEXT");
        stringBuilder.append(" expId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "sequence";
        aVar.xDd.put("sequence", "LONG");
        stringBuilder.append(" sequence LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "prioritylevel";
        aVar.xDd.put("prioritylevel", "INTEGER");
        stringBuilder.append(" prioritylevel INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "startTime";
        aVar.xDd.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "endTime";
        aVar.xDd.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "noReport";
        aVar.xDd.put("noReport", "INTEGER");
        stringBuilder.append(" noReport INTEGER");
        aVar.columns[8] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(118201);
    }
}
