package com.tencent.mm.plugin.scanner.history.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ea;
import java.lang.reflect.Field;

public final class a extends ea {
    public static com.tencent.mm.sdk.e.c.a ccO;

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(80799);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "productId";
        aVar.xDd.put("productId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" productId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "productId";
        aVar.columns[1] = "xmlContent";
        aVar.xDd.put("xmlContent", "TEXT");
        stringBuilder.append(" xmlContent TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "ScanTime";
        aVar.xDd.put("ScanTime", "LONG");
        stringBuilder.append(" ScanTime LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "funcType";
        aVar.xDd.put("funcType", "INTEGER");
        stringBuilder.append(" funcType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "qrcodeUrl";
        aVar.xDd.put("qrcodeUrl", "TEXT");
        stringBuilder.append(" qrcodeUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "scene";
        aVar.xDd.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(80799);
    }
}
