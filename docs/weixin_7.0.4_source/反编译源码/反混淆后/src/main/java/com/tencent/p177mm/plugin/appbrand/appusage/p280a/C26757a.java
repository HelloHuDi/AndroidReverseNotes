package com.tencent.p177mm.plugin.appbrand.appusage.p280a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C45402o;
import com.tencent.p177mm.protocal.protobuf.bqd;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.a */
public final class C26757a extends C45402o {
    public static C4924a ccO;

    static {
        AppMethodBeat.m2504i(129733);
        Class cls = bqd.class;
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[2];
        c4924a.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "appId";
        c4924a.xDd.put("appId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" appId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "appId";
        c4924a.columns[1] = "recommendCard";
        c4924a.xDd.put("recommendCard", "BLOB");
        stringBuilder.append(" recommendCard BLOB");
        c4924a.columns[2] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(129733);
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }
}
