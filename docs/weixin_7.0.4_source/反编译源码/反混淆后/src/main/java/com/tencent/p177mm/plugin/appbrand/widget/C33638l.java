package com.tencent.p177mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C42120fy;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.l */
public final class C33638l extends C42120fy {
    public static C4924a fjX;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return fjX;
    }

    static {
        AppMethodBeat.m2504i(70662);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[3];
        c4924a.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "appIdHash";
        c4924a.xDd.put("appIdHash", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" appIdHash INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "appIdHash";
        c4924a.columns[1] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "openDebug";
        c4924a.xDd.put("openDebug", "INTEGER");
        stringBuilder.append(" openDebug INTEGER");
        c4924a.columns[3] = "rowid";
        c4924a.sql = stringBuilder.toString();
        fjX = c4924a;
        AppMethodBeat.m2505o(70662);
    }
}
