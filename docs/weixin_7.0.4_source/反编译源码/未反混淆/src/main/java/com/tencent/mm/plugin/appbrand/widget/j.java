package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ct;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class j extends ct {
    public static final a gSs;

    public final a Ag() {
        return gSs;
    }

    static {
        AppMethodBeat.i(70661);
        a aVar = new a();
        aVar.xDb = new Field[8];
        aVar.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appIdHash";
        aVar.xDd.put("appIdHash", "INTEGER");
        stringBuilder.append(" appIdHash INTEGER");
        stringBuilder.append(", ");
        aVar.columns[1] = "appId";
        aVar.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "pkgType";
        aVar.xDd.put("pkgType", "INTEGER");
        stringBuilder.append(" pkgType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "widgetType";
        aVar.xDd.put("widgetType", "INTEGER");
        stringBuilder.append(" widgetType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "launchAction";
        aVar.xDd.put("launchAction", "BLOB");
        stringBuilder.append(" launchAction BLOB");
        stringBuilder.append(", ");
        aVar.columns[5] = "jsApiInfo";
        aVar.xDd.put("jsApiInfo", "BLOB");
        stringBuilder.append(" jsApiInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[6] = "versionInfo";
        aVar.xDd.put("versionInfo", "BLOB");
        stringBuilder.append(" versionInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[7] = "widgetSetting";
        aVar.xDd.put("widgetSetting", "BLOB");
        stringBuilder.append(" widgetSetting BLOB");
        aVar.columns[8] = "rowid";
        aVar.sql = stringBuilder.toString();
        gSs = aVar;
        AppMethodBeat.o(70661);
    }
}
