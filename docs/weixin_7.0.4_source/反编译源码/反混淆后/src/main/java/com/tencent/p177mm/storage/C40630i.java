package com.tencent.p177mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C45403v;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.storage.i */
public final class C40630i extends C45403v {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(29002);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[3];
        c4924a.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "deviceId";
        c4924a.xDd.put("deviceId", "TEXT default '' ");
        stringBuilder.append(" deviceId TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[1] = "sessionName";
        c4924a.xDd.put("sessionName", "TEXT default '' ");
        stringBuilder.append(" sessionName TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[2] = "moveTime";
        c4924a.xDd.put("moveTime", "BLOB default '' ");
        stringBuilder.append(" moveTime BLOB default '' ");
        c4924a.columns[3] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(29002);
    }
}
