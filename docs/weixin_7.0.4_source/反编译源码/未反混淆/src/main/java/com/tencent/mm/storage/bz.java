package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ex;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class bz extends ex {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    public bz(String str, String str2, String str3) {
        this.field_appId = str;
        this.field_username = str2;
        this.field_openId = str3;
    }

    static {
        AppMethodBeat.i(29070);
        a aVar = new a();
        aVar.xDb = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "openId";
        aVar.xDd.put("openId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" openId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "openId";
        aVar.columns[1] = "appId";
        aVar.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "username";
        aVar.xDd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        aVar.columns[3] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(29070);
    }
}
