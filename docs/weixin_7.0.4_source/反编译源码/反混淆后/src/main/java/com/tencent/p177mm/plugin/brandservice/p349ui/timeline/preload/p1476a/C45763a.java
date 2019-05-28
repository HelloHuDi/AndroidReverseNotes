package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p1476a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C42122y;
import com.tencent.p177mm.protocal.protobuf.C35916er;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a */
public final class C45763a extends C42122y {
    public static C4924a fjX;

    public C45763a(C35916er c35916er) {
        this.field_url = c35916er.Url;
        this.field_reportTime = c35916er.vGy;
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return fjX;
    }

    public final String toString() {
        AppMethodBeat.m2504i(14393);
        String str = "BizAppMsgReportContext{field_appMsgReportContextId=" + this.field_appMsgReportContextId + ", field_url='" + this.field_url + '\'' + ", field_reportTime=" + this.field_reportTime + ", field_aScene=" + this.field_aScene + '}';
        AppMethodBeat.m2505o(14393);
        return str;
    }

    static {
        AppMethodBeat.m2504i(14394);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[4];
        c4924a.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "appMsgReportContextId";
        c4924a.xDd.put("appMsgReportContextId", "LONG PRIMARY KEY ");
        stringBuilder.append(" appMsgReportContextId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "appMsgReportContextId";
        c4924a.columns[1] = "url";
        c4924a.xDd.put("url", "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "reportTime";
        c4924a.xDd.put("reportTime", "LONG");
        stringBuilder.append(" reportTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[3] = "aScene";
        c4924a.xDd.put("aScene", "INTEGER");
        stringBuilder.append(" aScene INTEGER");
        c4924a.columns[4] = "rowid";
        c4924a.sql = stringBuilder.toString();
        fjX = c4924a;
        AppMethodBeat.m2505o(14394);
    }
}
