package com.tencent.p177mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C6565bg;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.storage.emotion.m */
public final class C23520m extends C6565bg {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return null;
    }

    static {
        AppMethodBeat.m2504i(62862);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[7];
        c4924a.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "prodcutID";
        c4924a.xDd.put("prodcutID", "TEXT PRIMARY KEY ");
        stringBuilder.append(" prodcutID TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "prodcutID";
        c4924a.columns[1] = "totalCount";
        c4924a.xDd.put("totalCount", "INTEGER");
        stringBuilder.append(" totalCount INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "continuCount";
        c4924a.xDd.put("continuCount", "INTEGER");
        stringBuilder.append(" continuCount INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "flag";
        c4924a.xDd.put("flag", "INTEGER");
        stringBuilder.append(" flag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "modifyTime";
        c4924a.xDd.put("modifyTime", "LONG");
        stringBuilder.append(" modifyTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[5] = "showTipsTime";
        c4924a.xDd.put("showTipsTime", "LONG");
        stringBuilder.append(" showTipsTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[6] = "setFlagTime";
        c4924a.xDd.put("setFlagTime", "LONG");
        stringBuilder.append(" setFlagTime LONG");
        c4924a.columns[7] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(62862);
    }
}
