package com.tencent.mm.storage;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fa;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;

public final class cc extends fa {
    protected static a ccO;

    public final a Ag() {
        return null;
    }

    public final void aqa(String str) {
        AppMethodBeat.i(116822);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(116822);
            return;
        }
        this.field_cmsgId = str;
        AppMethodBeat.o(116822);
    }

    static {
        AppMethodBeat.i(116823);
        a aVar = new a();
        aVar.xDb = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.xDd.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "msgId";
        aVar.columns[1] = "cmsgId";
        aVar.xDd.put("cmsgId", "TEXT");
        stringBuilder.append(" cmsgId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = b.CONTENT;
        aVar.xDd.put(b.CONTENT, "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        aVar.columns[3] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(116823);
    }
}
