package com.tencent.p177mm.plugin.p268aa.p269a.p879b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C9518b;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.aa.a.b.c */
public final class C26535c extends C9518b {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(40666);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[4];
        c4924a.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "billNo";
        c4924a.xDd.put("billNo", "TEXT PRIMARY KEY ");
        stringBuilder.append(" billNo TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "billNo";
        c4924a.columns[1] = "insertmsg";
        c4924a.xDd.put("insertmsg", "INTEGER");
        stringBuilder.append(" insertmsg INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "localMsgId";
        c4924a.xDd.put("localMsgId", "LONG");
        stringBuilder.append(" localMsgId LONG");
        stringBuilder.append(", ");
        c4924a.columns[3] = "status";
        c4924a.xDd.put("status", "INTEGER default '-1' ");
        stringBuilder.append(" status INTEGER default '-1' ");
        c4924a.columns[4] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(40666);
    }
}
