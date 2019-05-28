package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bc;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class e extends bc {
    protected static a ccO;

    public e(String str, String str2) {
        this.field_groupID = str;
        this.field_desc = str2;
    }

    public final a Ag() {
        return null;
    }

    static {
        AppMethodBeat.i(62846);
        a aVar = new a();
        aVar.xDb = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "groupID";
        aVar.xDd.put("groupID", "TEXT");
        stringBuilder.append(" groupID TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "desc";
        aVar.xDd.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(62846);
    }
}
