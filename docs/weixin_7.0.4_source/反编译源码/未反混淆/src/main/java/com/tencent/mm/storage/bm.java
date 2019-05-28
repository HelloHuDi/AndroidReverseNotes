package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dc;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.lang.reflect.Field;

public final class bm extends dc {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(80286);
        a aVar = new a();
        aVar.xDb = new Field[13];
        aVar.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "tipId";
        aVar.xDd.put("tipId", "INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(" tipId INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "tipId";
        aVar.columns[1] = "tipVersion";
        aVar.xDd.put("tipVersion", "INTEGER");
        stringBuilder.append(" tipVersion INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "tipkey";
        aVar.xDd.put("tipkey", "TEXT");
        stringBuilder.append(" tipkey TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "tipType";
        aVar.xDd.put("tipType", "INTEGER");
        stringBuilder.append(" tipType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "isExit";
        aVar.xDd.put("isExit", "INTEGER");
        stringBuilder.append(" isExit INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "hadRead";
        aVar.xDd.put("hadRead", "INTEGER");
        stringBuilder.append(" hadRead INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "isReject";
        aVar.xDd.put("isReject", "INTEGER");
        stringBuilder.append(" isReject INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "beginShowTime";
        aVar.xDd.put("beginShowTime", "LONG");
        stringBuilder.append(" beginShowTime LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "disappearTime";
        aVar.xDd.put("disappearTime", "LONG");
        stringBuilder.append(" disappearTime LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "overdueTime";
        aVar.xDd.put("overdueTime", "LONG");
        stringBuilder.append(" overdueTime LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = "tipsShowInfo";
        aVar.xDd.put("tipsShowInfo", "BLOB");
        stringBuilder.append(" tipsShowInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[11] = IssueStorage.COLUMN_EXT_INFO;
        aVar.xDd.put(IssueStorage.COLUMN_EXT_INFO, "TEXT");
        stringBuilder.append(" extInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "pagestaytime";
        aVar.xDd.put("pagestaytime", "LONG");
        stringBuilder.append(" pagestaytime LONG");
        aVar.columns[13] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(80286);
    }
}
