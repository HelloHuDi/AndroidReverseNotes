package com.tencent.p177mm.plugin.appbrand.game.p292b.p1222a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C42121fz;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.appbrand.game.b.a.b */
public final class C19224b extends C42121fz {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(130108);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[9];
        c4924a.columns = new String[10];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "RecordId";
        c4924a.xDd.put("RecordId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" RecordId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "RecordId";
        c4924a.columns[1] = "AppId";
        c4924a.xDd.put("AppId", "TEXT");
        stringBuilder.append(" AppId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "AppName";
        c4924a.xDd.put("AppName", "TEXT");
        stringBuilder.append(" AppName TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "UserName";
        c4924a.xDd.put("UserName", "TEXT");
        stringBuilder.append(" UserName TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "IconUrl";
        c4924a.xDd.put("IconUrl", "TEXT");
        stringBuilder.append(" IconUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "BriefIntro";
        c4924a.xDd.put("BriefIntro", "TEXT");
        stringBuilder.append(" BriefIntro TEXT");
        stringBuilder.append(", ");
        c4924a.columns[6] = "isSync";
        c4924a.xDd.put("isSync", "INTEGER default 'false' ");
        stringBuilder.append(" isSync INTEGER default 'false' ");
        stringBuilder.append(", ");
        c4924a.columns[7] = "debugType";
        c4924a.xDd.put("debugType", "INTEGER");
        stringBuilder.append(" debugType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[8] = "createTime";
        c4924a.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        c4924a.columns[9] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(130108);
    }
}
