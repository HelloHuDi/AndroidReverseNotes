package com.tencent.p177mm.plugin.websearch.widget.p577a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C26312ft;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.websearch.widget.a.a */
public final class C4534a extends C26312ft {
    public static C4924a ccO;

    static {
        AppMethodBeat.m2504i(91457);
        Class cls = C7614b.class;
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[5];
        c4924a.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "appid";
        c4924a.xDd.put("appid", "TEXT PRIMARY KEY ");
        stringBuilder.append(" appid TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "appid";
        c4924a.columns[1] = "jsExceptionCount";
        c4924a.xDd.put("jsExceptionCount", "INTEGER");
        stringBuilder.append(" jsExceptionCount INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "crashCount";
        c4924a.xDd.put("crashCount", "INTEGER");
        stringBuilder.append(" crashCount INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "beginTimestamp";
        c4924a.xDd.put("beginTimestamp", "LONG");
        stringBuilder.append(" beginTimestamp LONG");
        stringBuilder.append(", ");
        c4924a.columns[4] = "pkgVersion";
        c4924a.xDd.put("pkgVersion", "INTEGER");
        stringBuilder.append(" pkgVersion INTEGER");
        c4924a.columns[5] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(91457);
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }
}
