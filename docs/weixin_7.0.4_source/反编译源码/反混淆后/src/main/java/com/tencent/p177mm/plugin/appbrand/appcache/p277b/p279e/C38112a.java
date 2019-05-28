package com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C18471do;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.e.a */
public final class C38112a extends C18471do {
    static final C4924a fjX;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return fjX;
    }

    public final String toString() {
        AppMethodBeat.m2504i(129504);
        String str = "CmdBlockCgiPersistentInfo{field_username='" + this.field_username + '\'' + ", field_appId='" + this.field_appId + '\'' + ", field_startTime=" + this.field_startTime + ", field_endTime=" + this.field_endTime + ", field_sceneList='" + this.field_sceneList + '\'' + ", field_cgiList='" + this.field_cgiList + '\'' + ", field_reportId=" + this.field_reportId + '}';
        AppMethodBeat.m2505o(129504);
        return str;
    }

    static {
        AppMethodBeat.m2504i(129505);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[7];
        c4924a.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "username";
        c4924a.xDd.put("username", "TEXT PRIMARY KEY ");
        stringBuilder.append(" username TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "username";
        c4924a.columns[1] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "startTime";
        c4924a.xDd.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[3] = "endTime";
        c4924a.xDd.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[4] = "sceneList";
        c4924a.xDd.put("sceneList", "TEXT");
        stringBuilder.append(" sceneList TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "cgiList";
        c4924a.xDd.put("cgiList", "TEXT");
        stringBuilder.append(" cgiList TEXT");
        stringBuilder.append(", ");
        c4924a.columns[6] = "reportId";
        c4924a.xDd.put("reportId", "INTEGER");
        stringBuilder.append(" reportId INTEGER");
        c4924a.columns[7] = "rowid";
        c4924a.sql = stringBuilder.toString();
        fjX = c4924a;
        AppMethodBeat.m2505o(129505);
    }
}
