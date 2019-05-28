package com.tencent.mm.plugin.ipcall.a.g;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cl;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class g extends cl {
    public static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(21933);
        a aVar = new a();
        aVar.xDb = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "svrId";
        aVar.xDd.put("svrId", "LONG PRIMARY KEY ");
        stringBuilder.append(" svrId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "svrId";
        aVar.columns[1] = "isRead";
        aVar.xDd.put("isRead", "SHORT default '0' ");
        stringBuilder.append(" isRead SHORT default '0' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "title";
        aVar.xDd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = b.CONTENT;
        aVar.xDd.put(b.CONTENT, "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "pushTime";
        aVar.xDd.put("pushTime", "LONG");
        stringBuilder.append(" pushTime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "msgType";
        aVar.xDd.put("msgType", "INTEGER");
        stringBuilder.append(" msgType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "descUrl";
        aVar.xDd.put("descUrl", "TEXT");
        stringBuilder.append(" descUrl TEXT");
        aVar.columns[7] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(21933);
    }
}
