package com.tencent.p177mm.plugin.order.p767b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C42109di;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.order.b.a */
public final class C34658a extends C42109di {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(43792);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[3];
        c4924a.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "msgId";
        c4924a.xDd.put("msgId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" msgId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "msgId";
        c4924a.columns[1] = "msgContentXml";
        c4924a.xDd.put("msgContentXml", "TEXT");
        stringBuilder.append(" msgContentXml TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "isRead";
        c4924a.xDd.put("isRead", "TEXT");
        stringBuilder.append(" isRead TEXT");
        c4924a.columns[3] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(43792);
    }
}
