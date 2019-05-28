package com.tencent.p177mm.plugin.freewifi.p417g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C37839bt;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.freewifi.g.a */
public final class C11960a extends C37839bt {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(20873);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[3];
        c4924a.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "key";
        c4924a.xDd.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "key";
        c4924a.columns[1] = "value";
        c4924a.xDd.put("value", "TEXT");
        stringBuilder.append(" value TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "modifyTime";
        c4924a.xDd.put("modifyTime", "LONG default '0' ");
        stringBuilder.append(" modifyTime LONG default '0' ");
        c4924a.columns[3] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(20873);
    }
}
