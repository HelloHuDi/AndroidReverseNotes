package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.em;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;

public final class p extends em {
    protected static a ccO;
    public int reX;

    public final a Ag() {
        return ccO;
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(37970);
        try {
            super.d(cursor);
            this.reX = (int) this.xDa;
            AppMethodBeat.o(37970);
        } catch (Exception e) {
            String message = e.getMessage();
            ab.e("MicroMsg.SnsKvReport", "error ".concat(String.valueOf(message)));
            if (message != null && message.contains("Unable to convert")) {
                af.cnK().cqH();
            }
            AppMethodBeat.o(37970);
            throw e;
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.SnsKvReport", e2, "", new Object[0]);
            AppMethodBeat.o(37970);
        }
    }

    static {
        AppMethodBeat.i(37971);
        a aVar = new a();
        aVar.xDb = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "logtime";
        aVar.xDd.put("logtime", "LONG");
        stringBuilder.append(" logtime LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "offset";
        aVar.xDd.put("offset", "INTEGER default '0' ");
        stringBuilder.append(" offset INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "logsize";
        aVar.xDd.put("logsize", "INTEGER");
        stringBuilder.append(" logsize INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "errorcount";
        aVar.xDd.put("errorcount", "INTEGER");
        stringBuilder.append(" errorcount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "value";
        aVar.xDd.put("value", "BLOB");
        stringBuilder.append(" value BLOB");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(37971);
    }
}
