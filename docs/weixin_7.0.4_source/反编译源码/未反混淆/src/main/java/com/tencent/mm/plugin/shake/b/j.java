package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.a.a.b;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class j extends b {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(24470);
        a aVar = new a();
        aVar.xDb = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.xDd.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "username";
        aVar.columns[1] = "lastshaketime";
        aVar.xDd.put("lastshaketime", "INTEGER default '0' ");
        stringBuilder.append(" lastshaketime INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "isshowed";
        aVar.xDd.put("isshowed", "INTEGER default 'false' ");
        stringBuilder.append(" isshowed INTEGER default 'false' ");
        aVar.columns[3] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(24470);
    }
}
