package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ez;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class g extends ez {
    protected static a ccO;
    int bJt = -1;

    public final a Ag() {
        return ccO;
    }

    public final boolean ame() {
        if ((this.field_status <= 1 || this.field_status > 3) && this.field_status != 8) {
            return false;
        }
        return true;
    }

    static {
        AppMethodBeat.i(25284);
        a aVar = new a();
        aVar.xDb = new Field[17];
        aVar.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "filename";
        aVar.xDd.put("filename", "TEXT");
        stringBuilder.append(" filename TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "user";
        aVar.xDd.put("user", "TEXT");
        stringBuilder.append(" user TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "msgid";
        aVar.xDd.put("msgid", "LONG");
        stringBuilder.append(" msgid LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "offset";
        aVar.xDd.put("offset", "INTEGER");
        stringBuilder.append(" offset INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "filenowsize";
        aVar.xDd.put("filenowsize", "INTEGER");
        stringBuilder.append(" filenowsize INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "totallen";
        aVar.xDd.put("totallen", "INTEGER");
        stringBuilder.append(" totallen INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "status";
        aVar.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "createtime";
        aVar.xDd.put("createtime", "LONG");
        stringBuilder.append(" createtime LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "lastmodifytime";
        aVar.xDd.put("lastmodifytime", "LONG");
        stringBuilder.append(" lastmodifytime LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "clientid";
        aVar.xDd.put("clientid", "TEXT");
        stringBuilder.append(" clientid TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "voicelenght";
        aVar.xDd.put("voicelenght", "INTEGER");
        stringBuilder.append(" voicelenght INTEGER");
        stringBuilder.append(", ");
        aVar.columns[11] = "msglocalid";
        aVar.xDd.put("msglocalid", "INTEGER");
        stringBuilder.append(" msglocalid INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "human";
        aVar.xDd.put("human", "TEXT");
        stringBuilder.append(" human TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "voiceformat";
        aVar.xDd.put("voiceformat", "INTEGER");
        stringBuilder.append(" voiceformat INTEGER");
        stringBuilder.append(", ");
        aVar.columns[14] = "nettimes";
        aVar.xDd.put("nettimes", "INTEGER");
        stringBuilder.append(" nettimes INTEGER");
        stringBuilder.append(", ");
        aVar.columns[15] = "reserved1";
        aVar.xDd.put("reserved1", "INTEGER");
        stringBuilder.append(" reserved1 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[16] = "reserved2";
        aVar.xDd.put("reserved2", "TEXT");
        stringBuilder.append(" reserved2 TEXT");
        aVar.columns[17] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(25284);
    }
}
