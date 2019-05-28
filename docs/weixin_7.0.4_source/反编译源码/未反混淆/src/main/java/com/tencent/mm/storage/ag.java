package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.as;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class ag extends as {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(29024);
        a aVar = new a();
        aVar.xDb = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "labelId";
        aVar.xDd.put("labelId", "TEXT");
        stringBuilder.append(" labelId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "contactName";
        aVar.xDd.put("contactName", "TEXT");
        stringBuilder.append(" contactName TEXT");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(29024);
    }
}
