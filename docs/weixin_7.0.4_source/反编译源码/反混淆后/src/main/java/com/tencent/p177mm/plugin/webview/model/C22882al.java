package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C37852fq;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.webview.model.al */
public final class C22882al extends C37852fq {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(6736);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[5];
        c4924a.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "recordId";
        c4924a.xDd.put("recordId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" recordId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "recordId";
        c4924a.columns[1] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "domin";
        c4924a.xDd.put("domin", "TEXT");
        stringBuilder.append(" domin TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "key";
        c4924a.xDd.put("key", "TEXT");
        stringBuilder.append(" key TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "value";
        c4924a.xDd.put("value", "TEXT");
        stringBuilder.append(" value TEXT");
        c4924a.columns[5] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(6736);
    }
}
