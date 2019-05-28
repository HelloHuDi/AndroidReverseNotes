package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dk;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class ak extends dk {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ak)) {
            return false;
        }
        if (this.field_cardUserId == ((ak) obj).field_cardUserId) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(87925);
        if (this.field_cardUserId == null) {
            AppMethodBeat.o(87925);
            return 0;
        }
        int hashCode = this.field_cardUserId.hashCode();
        AppMethodBeat.o(87925);
        return hashCode;
    }

    public static ak b(ok okVar) {
        AppMethodBeat.i(87926);
        ak akVar = new ak();
        akVar.field_cardUserId = okVar.vUK;
        AppMethodBeat.o(87926);
        return akVar;
    }

    static {
        AppMethodBeat.i(87927);
        a aVar = new a();
        aVar.xDb = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "cardUserId";
        aVar.xDd.put("cardUserId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" cardUserId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "cardUserId";
        aVar.columns[1] = "retryCount";
        aVar.xDd.put("retryCount", "INTEGER");
        stringBuilder.append(" retryCount INTEGER");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(87927);
    }
}
