package com.tencent.p177mm.plugin.webview.p768b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C26311fm;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.webview.b.a */
public final class C35580a extends C26311fm {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(5623);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[7];
        c4924a.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "appIdKey";
        c4924a.xDd.put("appIdKey", "TEXT PRIMARY KEY ");
        stringBuilder.append(" appIdKey TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "appIdKey";
        c4924a.columns[2] = "value";
        c4924a.xDd.put("value", "TEXT");
        stringBuilder.append(" value TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "weight";
        c4924a.xDd.put("weight", "TEXT");
        stringBuilder.append(" weight TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "expireTime";
        c4924a.xDd.put("expireTime", "LONG");
        stringBuilder.append(" expireTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[5] = "timeStamp";
        c4924a.xDd.put("timeStamp", "LONG");
        stringBuilder.append(" timeStamp LONG");
        stringBuilder.append(", ");
        c4924a.columns[6] = "size";
        c4924a.xDd.put("size", "LONG");
        stringBuilder.append(" size LONG");
        c4924a.columns[7] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(5623);
    }
}
