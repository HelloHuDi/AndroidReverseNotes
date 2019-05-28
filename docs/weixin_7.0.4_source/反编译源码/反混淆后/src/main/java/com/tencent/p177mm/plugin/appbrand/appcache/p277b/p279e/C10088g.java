package com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C18481fv;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.e.g */
public final class C10088g extends C18481fv {
    static final C4924a fjX;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return fjX;
    }

    static {
        AppMethodBeat.m2504i(129517);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[3];
        c4924a.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "username";
        c4924a.xDd.put("username", "TEXT PRIMARY KEY ");
        stringBuilder.append(" username TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "username";
        c4924a.columns[1] = "appVersion";
        c4924a.xDd.put("appVersion", "INTEGER");
        stringBuilder.append(" appVersion INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "reportId";
        c4924a.xDd.put("reportId", "INTEGER");
        stringBuilder.append(" reportId INTEGER");
        c4924a.columns[3] = "rowid";
        c4924a.sql = stringBuilder.toString();
        fjX = c4924a;
        AppMethodBeat.m2505o(129517);
    }
}
