package com.tencent.p177mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C6572cr;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.ab */
public final class C10580ab extends C6572cr {
    public static final C4924a gSs;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return gSs;
    }

    static {
        AppMethodBeat.m2504i(94157);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[2];
        c4924a.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "launchPB";
        c4924a.xDd.put("launchPB", "BLOB");
        stringBuilder.append(" launchPB BLOB");
        c4924a.columns[2] = "rowid";
        c4924a.sql = stringBuilder.toString();
        gSs = c4924a;
        AppMethodBeat.m2505o(94157);
    }
}
