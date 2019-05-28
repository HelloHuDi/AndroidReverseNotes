package com.tencent.p177mm.p184aj.p185a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C6558ab;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.aj.a.f */
public final class C8925f extends C6558ab {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(11556);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[2];
        c4924a.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "brandUserName";
        c4924a.xDd.put("brandUserName", "TEXT PRIMARY KEY ");
        stringBuilder.append(" brandUserName TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "brandUserName";
        c4924a.columns[1] = "userId";
        c4924a.xDd.put("userId", "TEXT");
        stringBuilder.append(" userId TEXT");
        c4924a.columns[2] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(11556);
    }
}
