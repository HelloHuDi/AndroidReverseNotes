package com.tencent.p177mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C9537l;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.appbrand.appstorage.a */
public final class C45517a extends C9537l {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(101760);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[4];
        c4924a.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "key";
        c4924a.xDd.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "key";
        c4924a.columns[1] = "data";
        c4924a.xDd.put("data", "TEXT");
        stringBuilder.append(" data TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "dataType";
        c4924a.xDd.put("dataType", "TEXT");
        stringBuilder.append(" dataType TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "size";
        c4924a.xDd.put("size", "INTEGER");
        stringBuilder.append(" size INTEGER");
        c4924a.columns[4] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(101760);
    }
}
