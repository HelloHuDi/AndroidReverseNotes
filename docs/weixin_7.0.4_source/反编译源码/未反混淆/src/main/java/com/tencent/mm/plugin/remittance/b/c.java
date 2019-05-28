package com.tencent.mm.plugin.remittance.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dw;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends dw {
    public static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(44706);
        a aVar = new a();
        aVar.xDb = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "transferId";
        aVar.xDd.put("transferId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" transferId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "transferId";
        aVar.columns[1] = "locaMsgId";
        aVar.xDd.put("locaMsgId", "LONG");
        stringBuilder.append(" locaMsgId LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "receiveStatus";
        aVar.xDd.put("receiveStatus", "INTEGER default '-1' ");
        stringBuilder.append(" receiveStatus INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "isSend";
        aVar.xDd.put("isSend", "INTEGER");
        stringBuilder.append(" isSend INTEGER");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(44706);
    }
}
