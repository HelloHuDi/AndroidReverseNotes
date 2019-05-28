package com.tencent.p177mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C42111dk;
import com.tencent.p177mm.protocal.protobuf.C15370ok;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.card.model.ak */
public final class C20140ak extends C42111dk {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C20140ak)) {
            return false;
        }
        if (this.field_cardUserId == ((C20140ak) obj).field_cardUserId) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(87925);
        if (this.field_cardUserId == null) {
            AppMethodBeat.m2505o(87925);
            return 0;
        }
        int hashCode = this.field_cardUserId.hashCode();
        AppMethodBeat.m2505o(87925);
        return hashCode;
    }

    /* renamed from: b */
    public static C20140ak m31160b(C15370ok c15370ok) {
        AppMethodBeat.m2504i(87926);
        C20140ak c20140ak = new C20140ak();
        c20140ak.field_cardUserId = c15370ok.vUK;
        AppMethodBeat.m2505o(87926);
        return c20140ak;
    }

    static {
        AppMethodBeat.m2504i(87927);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[2];
        c4924a.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "cardUserId";
        c4924a.xDd.put("cardUserId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" cardUserId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "cardUserId";
        c4924a.columns[1] = "retryCount";
        c4924a.xDd.put("retryCount", "INTEGER");
        stringBuilder.append(" retryCount INTEGER");
        c4924a.columns[2] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(87927);
    }
}
