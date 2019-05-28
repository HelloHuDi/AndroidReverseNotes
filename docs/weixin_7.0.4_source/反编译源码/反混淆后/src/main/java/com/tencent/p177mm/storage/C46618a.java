package com.tencent.p177mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C6570c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.storage.a */
public final class C46618a extends C6570c {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final boolean isValid() {
        AppMethodBeat.m2504i(118200);
        long anT = C5046bo.anT();
        if (anT < this.field_startTime || anT >= this.field_endTime) {
            AppMethodBeat.m2505o(118200);
            return false;
        }
        AppMethodBeat.m2505o(118200);
        return true;
    }

    static {
        AppMethodBeat.m2504i(118201);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[8];
        c4924a.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "abtestkey";
        c4924a.xDd.put("abtestkey", "TEXT PRIMARY KEY ");
        stringBuilder.append(" abtestkey TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "abtestkey";
        c4924a.columns[1] = "value";
        c4924a.xDd.put("value", "TEXT");
        stringBuilder.append(" value TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "expId";
        c4924a.xDd.put("expId", "TEXT");
        stringBuilder.append(" expId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "sequence";
        c4924a.xDd.put("sequence", "LONG");
        stringBuilder.append(" sequence LONG");
        stringBuilder.append(", ");
        c4924a.columns[4] = "prioritylevel";
        c4924a.xDd.put("prioritylevel", "INTEGER");
        stringBuilder.append(" prioritylevel INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[5] = "startTime";
        c4924a.xDd.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[6] = "endTime";
        c4924a.xDd.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[7] = "noReport";
        c4924a.xDd.put("noReport", "INTEGER");
        stringBuilder.append(" noReport INTEGER");
        c4924a.columns[8] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(118201);
    }
}
