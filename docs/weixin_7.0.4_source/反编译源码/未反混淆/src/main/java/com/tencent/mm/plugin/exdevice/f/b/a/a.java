package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cd;
import java.lang.reflect.Field;

public final class a extends cd {
    public static com.tencent.mm.sdk.e.c.a ccO;

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(19483);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.xDd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "championUrl";
        aVar.xDd.put("championUrl", "TEXT");
        stringBuilder.append(" championUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "championMotto";
        aVar.xDd.put("championMotto", "TEXT");
        stringBuilder.append(" championMotto TEXT");
        aVar.columns[3] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(19483);
    }
}
