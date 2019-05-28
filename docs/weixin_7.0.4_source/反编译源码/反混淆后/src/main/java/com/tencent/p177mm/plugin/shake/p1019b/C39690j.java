package com.tencent.p177mm.plugin.shake.p1019b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.shake.p1294a.p1295a.C21825b;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.shake.b.j */
public final class C39690j extends C21825b {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(24470);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[3];
        c4924a.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "username";
        c4924a.xDd.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "username";
        c4924a.columns[1] = "lastshaketime";
        c4924a.xDd.put("lastshaketime", "INTEGER default '0' ");
        stringBuilder.append(" lastshaketime INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[2] = "isshowed";
        c4924a.xDd.put("isshowed", "INTEGER default 'false' ");
        stringBuilder.append(" isshowed INTEGER default 'false' ");
        c4924a.columns[3] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(24470);
    }
}
