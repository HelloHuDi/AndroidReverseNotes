package com.tencent.p177mm.plugin.offline.p478a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C26306dd;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.offline.a.r */
public final class C21404r extends C26306dd {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(43420);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[4];
        c4924a.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "reqkey";
        c4924a.xDd.put("reqkey", "TEXT PRIMARY KEY ");
        stringBuilder.append(" reqkey TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "reqkey";
        c4924a.columns[1] = "ack_key";
        c4924a.xDd.put("ack_key", "TEXT");
        stringBuilder.append(" ack_key TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "status";
        c4924a.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "receive_time";
        c4924a.xDd.put("receive_time", "LONG");
        stringBuilder.append(" receive_time LONG");
        c4924a.columns[4] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(43420);
    }
}
