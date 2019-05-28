package com.tencent.p177mm.storage.emotion;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C45387be;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.storage.emotion.i */
public final class C44224i extends C45387be {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(62856);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[3];
        c4924a.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "productID";
        c4924a.xDd.put("productID", "TEXT PRIMARY KEY ");
        stringBuilder.append(" productID TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "productID";
        c4924a.columns[1] = C8741b.CONTENT;
        c4924a.xDd.put(C8741b.CONTENT, "BLOB default '' ");
        stringBuilder.append(" content BLOB default '' ");
        stringBuilder.append(", ");
        c4924a.columns[2] = "lan";
        c4924a.xDd.put("lan", "TEXT default '' ");
        stringBuilder.append(" lan TEXT default '' ");
        c4924a.columns[3] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(62856);
    }
}
