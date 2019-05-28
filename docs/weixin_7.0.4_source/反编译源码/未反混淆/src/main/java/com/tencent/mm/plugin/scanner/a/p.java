package com.tencent.mm.plugin.scanner.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eb;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class p extends eb {
    public static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(80885);
        a aVar = new a();
        aVar.xDb = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "originMD5";
        aVar.xDd.put("originMD5", "TEXT PRIMARY KEY ");
        stringBuilder.append(" originMD5 TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "originMD5";
        aVar.columns[1] = "resultFile";
        aVar.xDd.put("resultFile", "TEXT");
        stringBuilder.append(" resultFile TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "fromLang";
        aVar.xDd.put("fromLang", "TEXT");
        stringBuilder.append(" fromLang TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "toLang";
        aVar.xDd.put("toLang", "TEXT");
        stringBuilder.append(" toLang TEXT");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(80885);
    }
}
