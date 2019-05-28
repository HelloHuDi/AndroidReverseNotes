package com.tencent.p177mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C42107dc;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.storage.bm */
public final class C36001bm extends C42107dc {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(80286);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[13];
        c4924a.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "tipId";
        c4924a.xDd.put("tipId", "INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(" tipId INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "tipId";
        c4924a.columns[1] = "tipVersion";
        c4924a.xDd.put("tipVersion", "INTEGER");
        stringBuilder.append(" tipVersion INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "tipkey";
        c4924a.xDd.put("tipkey", "TEXT");
        stringBuilder.append(" tipkey TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "tipType";
        c4924a.xDd.put("tipType", "INTEGER");
        stringBuilder.append(" tipType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "isExit";
        c4924a.xDd.put("isExit", "INTEGER");
        stringBuilder.append(" isExit INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[5] = "hadRead";
        c4924a.xDd.put("hadRead", "INTEGER");
        stringBuilder.append(" hadRead INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[6] = "isReject";
        c4924a.xDd.put("isReject", "INTEGER");
        stringBuilder.append(" isReject INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[7] = "beginShowTime";
        c4924a.xDd.put("beginShowTime", "LONG");
        stringBuilder.append(" beginShowTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[8] = "disappearTime";
        c4924a.xDd.put("disappearTime", "LONG");
        stringBuilder.append(" disappearTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[9] = "overdueTime";
        c4924a.xDd.put("overdueTime", "LONG");
        stringBuilder.append(" overdueTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[10] = "tipsShowInfo";
        c4924a.xDd.put("tipsShowInfo", "BLOB");
        stringBuilder.append(" tipsShowInfo BLOB");
        stringBuilder.append(", ");
        c4924a.columns[11] = IssueStorage.COLUMN_EXT_INFO;
        c4924a.xDd.put(IssueStorage.COLUMN_EXT_INFO, "TEXT");
        stringBuilder.append(" extInfo TEXT");
        stringBuilder.append(", ");
        c4924a.columns[12] = "pagestaytime";
        c4924a.xDd.put("pagestaytime", "LONG");
        stringBuilder.append(" pagestaytime LONG");
        c4924a.columns[13] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(80286);
    }
}
