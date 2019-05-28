package com.tencent.mm.storage.emotion;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bd;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class g extends bd {
    protected static a ccO;

    public final a Ag() {
        return null;
    }

    static {
        AppMethodBeat.i(62849);
        a aVar = new a();
        aVar.xDb = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "designerIDAndType";
        aVar.xDd.put("designerIDAndType", "TEXT PRIMARY KEY ");
        stringBuilder.append(" designerIDAndType TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "designerIDAndType";
        aVar.columns[1] = b.CONTENT;
        aVar.xDd.put(b.CONTENT, "BLOB default '' ");
        stringBuilder.append(" content BLOB default '' ");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(62849);
    }
}
