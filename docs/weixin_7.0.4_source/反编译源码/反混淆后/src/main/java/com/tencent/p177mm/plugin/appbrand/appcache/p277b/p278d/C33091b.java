package com.tencent.p177mm.plugin.appbrand.appcache.p277b.p278d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C9538r;
import com.tencent.p177mm.plugin.appbrand.p911q.C19677b;
import com.tencent.p177mm.plugin.appbrand.p911q.C19677b.C10705a;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.d.b */
public final class C33091b extends C9538r implements C19677b {
    static final C4924a fjX;
    static final String[] gSr = new String[]{"appId", "version"};

    static {
        AppMethodBeat.m2504i(129503);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[5];
        c4924a.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "version";
        c4924a.xDd.put("version", "INTEGER");
        stringBuilder.append(" version INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "source";
        c4924a.xDd.put("source", "INTEGER default '0' ");
        stringBuilder.append(" source INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[3] = "hitCount";
        c4924a.xDd.put("hitCount", "INTEGER default '0' ");
        stringBuilder.append(" hitCount INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[4] = "reportId";
        c4924a.xDd.put("reportId", "INTEGER default '0' ");
        stringBuilder.append(" reportId INTEGER default '0' ");
        c4924a.columns[5] = "rowid";
        c4924a.sql = stringBuilder.toString();
        fjX = c4924a;
        StringBuilder stringBuilder2 = new StringBuilder();
        C4924a c4924a2 = fjX;
        c4924a2.sql = stringBuilder2.append(c4924a2.sql).append(C10705a.m18377n(gSr)).toString();
        AppMethodBeat.m2505o(129503);
    }

    public final String[] getKeys() {
        return gSr;
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return fjX;
    }
}
