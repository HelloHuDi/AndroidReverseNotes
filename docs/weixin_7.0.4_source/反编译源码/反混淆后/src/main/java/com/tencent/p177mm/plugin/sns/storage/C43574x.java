package com.tencent.p177mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C18479ey;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.sns.storage.x */
public final class C43574x extends C18479ey {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(38032);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[4];
        c4924a.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "canvasId";
        c4924a.xDd.put("canvasId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" canvasId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "canvasId";
        c4924a.columns[1] = "canvasXml";
        c4924a.xDd.put("canvasXml", "TEXT");
        stringBuilder.append(" canvasXml TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "createTime";
        c4924a.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[3] = "canvasExt";
        c4924a.xDd.put("canvasExt", "TEXT");
        stringBuilder.append(" canvasExt TEXT");
        c4924a.columns[4] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(38032);
    }
}
