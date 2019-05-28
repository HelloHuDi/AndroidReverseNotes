package com.tencent.p177mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C6582i;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.b */
public final class C26768b extends C6582i {
    static final C4924a fjX;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return fjX;
    }

    static {
        AppMethodBeat.m2504i(129531);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[2];
        c4924a.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "username";
        c4924a.xDd.put("username", "TEXT PRIMARY KEY ");
        stringBuilder.append(" username TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "username";
        c4924a.columns[1] = "updateTime";
        c4924a.xDd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        c4924a.columns[2] = "rowid";
        c4924a.sql = stringBuilder.toString();
        fjX = c4924a;
        AppMethodBeat.m2505o(129531);
    }
}
