package com.tencent.p177mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C45397ef;
import com.tencent.p177mm.protocal.protobuf.byy;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.card.sharecard.model.n */
public final class C46901n extends C45397ef {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C46901n)) {
            return false;
        }
        if (this.field_card_id == ((C46901n) obj).field_card_id) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(88084);
        if (this.field_card_id == null) {
            AppMethodBeat.m2505o(88084);
            return 0;
        }
        int hashCode = this.field_card_id.hashCode();
        AppMethodBeat.m2505o(88084);
        return hashCode;
    }

    /* renamed from: c */
    public static C46901n m89271c(byy byy) {
        AppMethodBeat.m2504i(88085);
        C46901n c46901n = new C46901n();
        c46901n.field_card_id = byy.cMC;
        c46901n.field_update_time = (long) byy.vWx;
        c46901n.field_state_flag = byy.kfy;
        c46901n.field_seq = byy.wYf;
        c46901n.field_retryCount = 10;
        AppMethodBeat.m2505o(88085);
        return c46901n;
    }

    static {
        AppMethodBeat.m2504i(88086);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[5];
        c4924a.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "card_id";
        c4924a.xDd.put("card_id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" card_id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "card_id";
        c4924a.columns[1] = "state_flag";
        c4924a.xDd.put("state_flag", "INTEGER");
        stringBuilder.append(" state_flag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "update_time";
        c4924a.xDd.put("update_time", "LONG");
        stringBuilder.append(" update_time LONG");
        stringBuilder.append(", ");
        c4924a.columns[3] = "seq";
        c4924a.xDd.put("seq", "LONG");
        stringBuilder.append(" seq LONG");
        stringBuilder.append(", ");
        c4924a.columns[4] = "retryCount";
        c4924a.xDd.put("retryCount", "INTEGER");
        stringBuilder.append(" retryCount INTEGER");
        c4924a.columns[5] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(88086);
    }
}
