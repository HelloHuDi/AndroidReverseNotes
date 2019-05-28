package com.tencent.p177mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C6573ct;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.j */
public final class C27420j extends C6573ct {
    public static final C4924a gSs;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return gSs;
    }

    static {
        AppMethodBeat.m2504i(70661);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[8];
        c4924a.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "appIdHash";
        c4924a.xDd.put("appIdHash", "INTEGER");
        stringBuilder.append(" appIdHash INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[1] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "pkgType";
        c4924a.xDd.put("pkgType", "INTEGER");
        stringBuilder.append(" pkgType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "widgetType";
        c4924a.xDd.put("widgetType", "INTEGER");
        stringBuilder.append(" widgetType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "launchAction";
        c4924a.xDd.put("launchAction", "BLOB");
        stringBuilder.append(" launchAction BLOB");
        stringBuilder.append(", ");
        c4924a.columns[5] = "jsApiInfo";
        c4924a.xDd.put("jsApiInfo", "BLOB");
        stringBuilder.append(" jsApiInfo BLOB");
        stringBuilder.append(", ");
        c4924a.columns[6] = "versionInfo";
        c4924a.xDd.put("versionInfo", "BLOB");
        stringBuilder.append(" versionInfo BLOB");
        stringBuilder.append(", ");
        c4924a.columns[7] = "widgetSetting";
        c4924a.xDd.put("widgetSetting", "BLOB");
        stringBuilder.append(" widgetSetting BLOB");
        c4924a.columns[8] = "rowid";
        c4924a.sql = stringBuilder.toString();
        gSs = c4924a;
        AppMethodBeat.m2505o(70661);
    }
}
