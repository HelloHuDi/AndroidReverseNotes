package com.tencent.p177mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.p262c.C37915a;
import com.tencent.p177mm.p230g.p711c.C32687d;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Map;

/* renamed from: com.tencent.mm.storage.c */
public final class C5141c extends C32687d implements Serializable {
    protected static C4924a ccO;
    private Map<String, String> xHN = null;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final boolean isValid() {
        AppMethodBeat.m2504i(118209);
        long anT = C5046bo.anT();
        if (anT < this.field_startTime || anT > this.field_endTime) {
            AppMethodBeat.m2505o(118209);
            return false;
        }
        AppMethodBeat.m2505o(118209);
        return true;
    }

    public final Map<String, String> dru() {
        AppMethodBeat.m2504i(118210);
        if (this.xHN == null) {
            this.xHN = C37915a.m64039pc(this.field_rawXML);
        }
        Map map = this.xHN;
        AppMethodBeat.m2505o(118210);
        return map;
    }

    static {
        AppMethodBeat.m2504i(118211);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[9];
        c4924a.columns = new String[10];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "layerId";
        c4924a.xDd.put("layerId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" layerId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "layerId";
        c4924a.columns[1] = "business";
        c4924a.xDd.put("business", "TEXT");
        stringBuilder.append(" business TEXT");
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
        c4924a.xDd.put("prioritylevel", "INTEGER default '0' ");
        stringBuilder.append(" prioritylevel INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[5] = "startTime";
        c4924a.xDd.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[6] = "endTime";
        c4924a.xDd.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[7] = "needReport";
        c4924a.xDd.put("needReport", "INTEGER");
        stringBuilder.append(" needReport INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[8] = "rawXML";
        c4924a.xDd.put("rawXML", "TEXT default '' ");
        stringBuilder.append(" rawXML TEXT default '' ");
        c4924a.columns[9] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(118211);
    }
}
