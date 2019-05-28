package com.tencent.p177mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C45404x;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.storage.m */
public final class C15443m extends C45404x {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(29018);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[3];
        c4924a.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "sessionName";
        c4924a.xDd.put("sessionName", "TEXT default '' ");
        stringBuilder.append(" sessionName TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[1] = "startTime";
        c4924a.xDd.put("startTime", "LONG default '0' ");
        stringBuilder.append(" startTime LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[2] = "endTime";
        c4924a.xDd.put("endTime", "LONG default '0' ");
        stringBuilder.append(" endTime LONG default '0' ");
        c4924a.columns[3] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(29018);
    }
}
