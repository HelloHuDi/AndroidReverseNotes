package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.d;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Map;

public final class c extends d implements Serializable {
    protected static a ccO;
    private Map<String, String> xHN = null;

    public final a Ag() {
        return ccO;
    }

    public final boolean isValid() {
        AppMethodBeat.i(118209);
        long anT = bo.anT();
        if (anT < this.field_startTime || anT > this.field_endTime) {
            AppMethodBeat.o(118209);
            return false;
        }
        AppMethodBeat.o(118209);
        return true;
    }

    public final Map<String, String> dru() {
        AppMethodBeat.i(118210);
        if (this.xHN == null) {
            this.xHN = com.tencent.mm.model.c.a.pc(this.field_rawXML);
        }
        Map map = this.xHN;
        AppMethodBeat.o(118210);
        return map;
    }

    static {
        AppMethodBeat.i(118211);
        a aVar = new a();
        aVar.xDb = new Field[9];
        aVar.columns = new String[10];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "layerId";
        aVar.xDd.put("layerId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" layerId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "layerId";
        aVar.columns[1] = "business";
        aVar.xDd.put("business", "TEXT");
        stringBuilder.append(" business TEXT");
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
        aVar.xDd.put("prioritylevel", "INTEGER default '0' ");
        stringBuilder.append(" prioritylevel INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "startTime";
        aVar.xDd.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "endTime";
        aVar.xDd.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "needReport";
        aVar.xDd.put("needReport", "INTEGER");
        stringBuilder.append(" needReport INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "rawXML";
        aVar.xDd.put("rawXML", "TEXT default '' ");
        stringBuilder.append(" rawXML TEXT default '' ");
        aVar.columns[9] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(118211);
    }
}
