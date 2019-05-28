package com.tencent.p177mm.plugin.downloader_app.p944d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C18461aw;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.downloader_app.d.a */
public final class C27718a extends C18461aw {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return null;
    }

    static {
        AppMethodBeat.m2504i(136200);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[3];
        c4924a.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "appId";
        c4924a.xDd.put("appId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" appId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "appId";
        c4924a.columns[1] = "status";
        c4924a.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "modifyTime";
        c4924a.xDd.put("modifyTime", "LONG");
        stringBuilder.append(" modifyTime LONG");
        c4924a.columns[3] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(136200);
    }
}
