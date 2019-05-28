package com.tencent.mm.plugin.appbrand.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fz;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends fz {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(130108);
        a aVar = new a();
        aVar.xDb = new Field[9];
        aVar.columns = new String[10];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "RecordId";
        aVar.xDd.put("RecordId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" RecordId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "RecordId";
        aVar.columns[1] = "AppId";
        aVar.xDd.put("AppId", "TEXT");
        stringBuilder.append(" AppId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "AppName";
        aVar.xDd.put("AppName", "TEXT");
        stringBuilder.append(" AppName TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "UserName";
        aVar.xDd.put("UserName", "TEXT");
        stringBuilder.append(" UserName TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "IconUrl";
        aVar.xDd.put("IconUrl", "TEXT");
        stringBuilder.append(" IconUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "BriefIntro";
        aVar.xDd.put("BriefIntro", "TEXT");
        stringBuilder.append(" BriefIntro TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "isSync";
        aVar.xDd.put("isSync", "INTEGER default 'false' ");
        stringBuilder.append(" isSync INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "debugType";
        aVar.xDd.put("debugType", "INTEGER");
        stringBuilder.append(" debugType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "createTime";
        aVar.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        aVar.columns[9] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(130108);
    }
}
