package com.tencent.p177mm.plugin.shake.p509d.p510a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.shake.p1294a.p1295a.C34892c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.shake.d.a.n */
public final class C13264n extends C34892c {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(24677);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[5];
        c4924a.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "username";
        c4924a.xDd.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "username";
        c4924a.columns[1] = "deeplink";
        c4924a.xDd.put("deeplink", "TEXT default '' ");
        stringBuilder.append(" deeplink TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[2] = "title";
        c4924a.xDd.put("title", "TEXT default '' ");
        stringBuilder.append(" title TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[3] = "iconurl";
        c4924a.xDd.put("iconurl", "TEXT default '' ");
        stringBuilder.append(" iconurl TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[4] = "createtime";
        c4924a.xDd.put("createtime", "LONG default '' ");
        stringBuilder.append(" createtime LONG default '' ");
        c4924a.columns[5] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(24677);
    }
}
