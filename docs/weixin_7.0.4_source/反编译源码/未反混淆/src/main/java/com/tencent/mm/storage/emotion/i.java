package com.tencent.mm.storage.emotion;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.be;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class i extends be {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(62856);
        a aVar = new a();
        aVar.xDb = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "productID";
        aVar.xDd.put("productID", "TEXT PRIMARY KEY ");
        stringBuilder.append(" productID TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "productID";
        aVar.columns[1] = b.CONTENT;
        aVar.xDd.put(b.CONTENT, "BLOB default '' ");
        stringBuilder.append(" content BLOB default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "lan";
        aVar.xDd.put("lan", "TEXT default '' ");
        stringBuilder.append(" lan TEXT default '' ");
        aVar.columns[3] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(62856);
    }
}
