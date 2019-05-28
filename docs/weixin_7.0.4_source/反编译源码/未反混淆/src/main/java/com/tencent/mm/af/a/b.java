package com.tencent.mm.af.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fx;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends fx {
    public static a fjX;

    public final a Ag() {
        return fjX;
    }

    static {
        AppMethodBeat.i(51123);
        a aVar = new a();
        aVar.xDb = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "shareKeyHash";
        aVar.xDd.put("shareKeyHash", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" shareKeyHash INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "shareKeyHash";
        aVar.columns[1] = "btnState";
        aVar.xDd.put("btnState", "INTEGER");
        stringBuilder.append(" btnState INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "msgState";
        aVar.xDd.put("msgState", "INTEGER");
        stringBuilder.append(" msgState INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT;
        aVar.xDd.put(com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT, "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "contentColor";
        aVar.xDd.put("contentColor", "TEXT");
        stringBuilder.append(" contentColor TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "updatePeroid";
        aVar.xDd.put("updatePeroid", "INTEGER");
        stringBuilder.append(" updatePeroid INTEGER");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        fjX = aVar;
        AppMethodBeat.o(51123);
    }
}
