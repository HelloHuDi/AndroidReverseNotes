package com.tencent.p177mm.plugin.remittance.p1410b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C26309dw;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.remittance.b.c */
public final class C46168c extends C26309dw {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(44706);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[4];
        c4924a.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "transferId";
        c4924a.xDd.put("transferId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" transferId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "transferId";
        c4924a.columns[1] = "locaMsgId";
        c4924a.xDd.put("locaMsgId", "LONG");
        stringBuilder.append(" locaMsgId LONG");
        stringBuilder.append(", ");
        c4924a.columns[2] = "receiveStatus";
        c4924a.xDd.put("receiveStatus", "INTEGER default '-1' ");
        stringBuilder.append(" receiveStatus INTEGER default '-1' ");
        stringBuilder.append(", ");
        c4924a.columns[3] = "isSend";
        c4924a.xDd.put("isSend", "INTEGER");
        stringBuilder.append(" isSend INTEGER");
        c4924a.columns[4] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(44706);
    }
}
