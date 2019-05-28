package com.tencent.p177mm.plugin.ipcall.p438a.p983g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C26305cm;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.ipcall.a.g.i */
public final class C46039i extends C26305cm {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(21936);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[3];
        c4924a.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "countryCode";
        c4924a.xDd.put("countryCode", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" countryCode INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "countryCode";
        c4924a.columns[1] = "callTimeCount";
        c4924a.xDd.put("callTimeCount", "LONG");
        stringBuilder.append(" callTimeCount LONG");
        stringBuilder.append(", ");
        c4924a.columns[2] = "lastCallTime";
        c4924a.xDd.put("lastCallTime", "LONG");
        stringBuilder.append(" lastCallTime LONG");
        c4924a.columns[3] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(21936);
    }
}
