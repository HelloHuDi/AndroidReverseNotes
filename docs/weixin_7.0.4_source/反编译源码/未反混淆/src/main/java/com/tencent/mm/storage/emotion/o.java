package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ca;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class o extends ca {
    public static a ccO;

    public final a Ag() {
        return null;
    }

    public o(String str, byte[] bArr) {
        this.field_reqType = str;
        this.field_cache = bArr;
    }

    public o(Cursor cursor) {
        AppMethodBeat.i(62867);
        if (cursor == null) {
            AppMethodBeat.o(62867);
            return;
        }
        d(cursor);
        AppMethodBeat.o(62867);
    }

    static {
        AppMethodBeat.i(62868);
        a aVar = new a();
        aVar.xDb = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "reqType";
        aVar.xDd.put("reqType", "TEXT PRIMARY KEY ");
        stringBuilder.append(" reqType TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "reqType";
        aVar.columns[1] = "cache";
        aVar.xDd.put("cache", "BLOB default '' ");
        stringBuilder.append(" cache BLOB default '' ");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(62868);
    }
}
