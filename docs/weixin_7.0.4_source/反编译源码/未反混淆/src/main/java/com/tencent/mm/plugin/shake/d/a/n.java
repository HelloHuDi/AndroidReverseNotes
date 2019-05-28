package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.a.a.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class n extends c {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(24677);
        a aVar = new a();
        aVar.xDb = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.xDd.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "username";
        aVar.columns[1] = "deeplink";
        aVar.xDd.put("deeplink", "TEXT default '' ");
        stringBuilder.append(" deeplink TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "title";
        aVar.xDd.put("title", "TEXT default '' ");
        stringBuilder.append(" title TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "iconurl";
        aVar.xDd.put("iconurl", "TEXT default '' ");
        stringBuilder.append(" iconurl TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "createtime";
        aVar.xDd.put("createtime", "LONG default '' ");
        stringBuilder.append(" createtime LONG default '' ");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(24677);
    }
}
