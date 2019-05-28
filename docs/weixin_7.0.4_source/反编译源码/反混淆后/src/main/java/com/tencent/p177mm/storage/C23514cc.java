package com.tencent.p177mm.storage;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C37850fa;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.storage.cc */
public final class C23514cc extends C37850fa {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return null;
    }

    public final void aqa(String str) {
        AppMethodBeat.m2504i(116822);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(116822);
            return;
        }
        this.field_cmsgId = str;
        AppMethodBeat.m2505o(116822);
    }

    static {
        AppMethodBeat.m2504i(116823);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[3];
        c4924a.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "msgId";
        c4924a.xDd.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "msgId";
        c4924a.columns[1] = "cmsgId";
        c4924a.xDd.put("cmsgId", "TEXT");
        stringBuilder.append(" cmsgId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = C8741b.CONTENT;
        c4924a.xDd.put(C8741b.CONTENT, "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        c4924a.columns[3] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(116823);
    }
}
