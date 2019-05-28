package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ef;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class n extends ef {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        if (this.field_card_id == ((n) obj).field_card_id) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(88084);
        if (this.field_card_id == null) {
            AppMethodBeat.o(88084);
            return 0;
        }
        int hashCode = this.field_card_id.hashCode();
        AppMethodBeat.o(88084);
        return hashCode;
    }

    public static n c(byy byy) {
        AppMethodBeat.i(88085);
        n nVar = new n();
        nVar.field_card_id = byy.cMC;
        nVar.field_update_time = (long) byy.vWx;
        nVar.field_state_flag = byy.kfy;
        nVar.field_seq = byy.wYf;
        nVar.field_retryCount = 10;
        AppMethodBeat.o(88085);
        return nVar;
    }

    static {
        AppMethodBeat.i(88086);
        a aVar = new a();
        aVar.xDb = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "card_id";
        aVar.xDd.put("card_id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" card_id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "card_id";
        aVar.columns[1] = "state_flag";
        aVar.xDd.put("state_flag", "INTEGER");
        stringBuilder.append(" state_flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "update_time";
        aVar.xDd.put("update_time", "LONG");
        stringBuilder.append(" update_time LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "seq";
        aVar.xDd.put("seq", "LONG");
        stringBuilder.append(" seq LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "retryCount";
        aVar.xDd.put("retryCount", "INTEGER");
        stringBuilder.append(" retryCount INTEGER");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(88086);
    }
}
