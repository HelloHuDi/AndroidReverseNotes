package com.tencent.mm.g.c;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class co extends c {
    private static final int dGp = "logId".hashCode();
    private static final int dGq = "liftTime".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private boolean dGn = true;
    private boolean dGo = true;
    public long field_liftTime;
    public int field_logId;

    public static a Hm() {
        a aVar = new a();
        aVar.xDb = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "logId";
        aVar.xDd.put("logId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" logId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "logId";
        aVar.columns[1] = "liftTime";
        aVar.xDd.put("liftTime", "LONG");
        stringBuilder.append(" liftTime LONG");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        return aVar;
    }
}
