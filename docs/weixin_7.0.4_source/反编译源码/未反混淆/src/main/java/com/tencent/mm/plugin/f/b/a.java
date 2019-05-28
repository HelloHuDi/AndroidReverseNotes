package com.tencent.mm.plugin.f.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fu;
import java.lang.reflect.Field;

public final class a extends fu {
    protected static com.tencent.mm.sdk.e.c.a ccO;

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(18627);
        super.d(cursor);
        AppMethodBeat.o(18627);
    }

    public final String toString() {
        AppMethodBeat.i(18628);
        String str = "{  sys row id: " + this.xDa + " msg id : " + this.field_msgId + " msg talker: " + this.field_username + " msg type : " + this.field_msgType + " msg sub type : " + this.field_msgSubType + " path : " + this.field_path + " size : " + this.field_size + " msgtime : " + this.field_msgtime + " } ";
        AppMethodBeat.o(18628);
        return str;
    }

    static {
        AppMethodBeat.i(18629);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.xDd.put("msgId", "LONG");
        stringBuilder.append(" msgId LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "username";
        aVar.xDd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "msgType";
        aVar.xDd.put("msgType", "INTEGER");
        stringBuilder.append(" msgType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "msgSubType";
        aVar.xDd.put("msgSubType", "INTEGER");
        stringBuilder.append(" msgSubType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "path";
        aVar.xDd.put("path", "TEXT");
        stringBuilder.append(" path TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "size";
        aVar.xDd.put("size", "LONG");
        stringBuilder.append(" size LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "msgtime";
        aVar.xDd.put("msgtime", "LONG");
        stringBuilder.append(" msgtime LONG");
        aVar.columns[7] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(18629);
    }
}
