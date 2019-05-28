package com.tencent.p177mm.plugin.freewifi.p417g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C37840bv;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.freewifi.g.e */
public final class C34188e extends C37840bv {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(20885);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[4];
        c4924a.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "id";
        c4924a.xDd.put("id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "id";
        c4924a.columns[1] = "protocolNumber";
        c4924a.xDd.put("protocolNumber", "INTEGER");
        stringBuilder.append(" protocolNumber INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "logContent";
        c4924a.xDd.put("logContent", "TEXT");
        stringBuilder.append(" logContent TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "createTime";
        c4924a.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        c4924a.columns[4] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(20885);
    }
}
