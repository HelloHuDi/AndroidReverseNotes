package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class r extends ei {
    protected static a ccO;

    public final a Ag() {
        return null;
    }

    public r(int i, String str) {
        this.field_position = i;
        this.field_key = str;
    }

    public final String toString() {
        AppMethodBeat.i(62887);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index:").append(this.field_position);
        stringBuilder.append("key  :").append(this.field_key);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(62887);
        return stringBuilder2;
    }

    static {
        AppMethodBeat.i(62888);
        a aVar = new a();
        aVar.xDb = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.xDd.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "key";
        aVar.columns[1] = "position";
        aVar.xDd.put("position", "INTEGER");
        stringBuilder.append(" position INTEGER");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(62888);
    }
}
