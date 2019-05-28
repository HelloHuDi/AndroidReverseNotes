package com.tencent.p177mm.plugin.honey_pay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C26304cj;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.honey_pay.model.a */
public final class C34334a extends C26304cj {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(41750);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[2];
        c4924a.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "payMsgId";
        c4924a.xDd.put("payMsgId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" payMsgId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "payMsgId";
        c4924a.columns[1] = "msgId";
        c4924a.xDd.put("msgId", "LONG");
        stringBuilder.append(" msgId LONG");
        c4924a.columns[2] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(41750);
    }
}
