package com.tencent.p177mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C9539u;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.pluginsdk.model.app.n */
public final class C35797n extends C9539u {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(27350);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[3];
        c4924a.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "flag";
        c4924a.xDd.put("flag", "LONG default '0' ");
        stringBuilder.append(" flag LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[1] = "appId";
        c4924a.xDd.put("appId", "TEXT default '' ");
        stringBuilder.append(" appId TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[2] = "sortId";
        c4924a.xDd.put("sortId", "INTEGER default '0' ");
        stringBuilder.append(" sortId INTEGER default '0' ");
        c4924a.columns[3] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(27350);
    }
}
