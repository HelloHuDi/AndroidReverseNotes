package com.tencent.p177mm.plugin.boots.p348a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C32691e;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.boots.a.a */
public final class C2678a extends C32691e {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(105575);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[4];
        c4924a.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "key";
        c4924a.xDd.put("key", "INTEGER PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(" key INTEGER PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(", ");
        c4924a.xDc = "key";
        c4924a.columns[1] = "mau";
        c4924a.xDd.put("mau", "INTEGER");
        stringBuilder.append(" mau INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "dau";
        c4924a.xDd.put("dau", "INTEGER");
        stringBuilder.append(" dau INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "useTime";
        c4924a.xDd.put("useTime", "LONG");
        stringBuilder.append(" useTime LONG");
        c4924a.columns[4] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(105575);
    }
}
