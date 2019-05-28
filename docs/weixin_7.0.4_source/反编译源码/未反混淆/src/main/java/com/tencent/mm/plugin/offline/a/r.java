package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class r extends dd {
    public static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(43420);
        a aVar = new a();
        aVar.xDb = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "reqkey";
        aVar.xDd.put("reqkey", "TEXT PRIMARY KEY ");
        stringBuilder.append(" reqkey TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "reqkey";
        aVar.columns[1] = "ack_key";
        aVar.xDd.put("ack_key", "TEXT");
        stringBuilder.append(" ack_key TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "status";
        aVar.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "receive_time";
        aVar.xDd.put("receive_time", "LONG");
        stringBuilder.append(" receive_time LONG");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(43420);
    }
}
