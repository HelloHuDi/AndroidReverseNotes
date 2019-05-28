package com.tencent.p177mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C42103ar;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.storage.af */
public final class C46619af extends C42103ar {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(29023);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[6];
        c4924a.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "labelID";
        c4924a.xDd.put("labelID", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" labelID INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "labelID";
        c4924a.columns[1] = "labelName";
        c4924a.xDd.put("labelName", "TEXT");
        stringBuilder.append(" labelName TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "labelPYFull";
        c4924a.xDd.put("labelPYFull", "TEXT");
        stringBuilder.append(" labelPYFull TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "labelPYShort";
        c4924a.xDd.put("labelPYShort", "TEXT");
        stringBuilder.append(" labelPYShort TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "createTime";
        c4924a.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[5] = "isTemporary";
        c4924a.xDd.put("isTemporary", "INTEGER");
        stringBuilder.append(" isTemporary INTEGER");
        c4924a.columns[6] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(29023);
    }
}
