package com.tencent.p177mm.p230g.p711c;

import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.g.c.co */
public abstract class C45392co extends C4925c {
    private static final int dGp = "logId".hashCode();
    private static final int dGq = "liftTime".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private boolean dGn = true;
    private boolean dGo = true;
    public long field_liftTime;
    public int field_logId;

    /* renamed from: Hm */
    public static C4924a m83577Hm() {
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[2];
        c4924a.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "logId";
        c4924a.xDd.put("logId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" logId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "logId";
        c4924a.columns[1] = "liftTime";
        c4924a.xDd.put("liftTime", "LONG");
        stringBuilder.append(" liftTime LONG");
        c4924a.columns[2] = "rowid";
        c4924a.sql = stringBuilder.toString();
        return c4924a;
    }
}
