package com.tencent.p177mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C42115em;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.sns.storage.p */
public final class C46237p extends C42115em {
    protected static C4924a ccO;
    public int reX;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        AppMethodBeat.m2504i(37970);
        try {
            super.mo8995d(cursor);
            this.reX = (int) this.xDa;
            AppMethodBeat.m2505o(37970);
        } catch (Exception e) {
            String message = e.getMessage();
            C4990ab.m7412e("MicroMsg.SnsKvReport", "error ".concat(String.valueOf(message)));
            if (message != null && message.contains("Unable to convert")) {
                C13373af.cnK().cqH();
            }
            AppMethodBeat.m2505o(37970);
            throw e;
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.SnsKvReport", e2, "", new Object[0]);
            AppMethodBeat.m2505o(37970);
        }
    }

    static {
        AppMethodBeat.m2504i(37971);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[5];
        c4924a.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "logtime";
        c4924a.xDd.put("logtime", "LONG");
        stringBuilder.append(" logtime LONG");
        stringBuilder.append(", ");
        c4924a.columns[1] = "offset";
        c4924a.xDd.put("offset", "INTEGER default '0' ");
        stringBuilder.append(" offset INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[2] = "logsize";
        c4924a.xDd.put("logsize", "INTEGER");
        stringBuilder.append(" logsize INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "errorcount";
        c4924a.xDd.put("errorcount", "INTEGER");
        stringBuilder.append(" errorcount INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "value";
        c4924a.xDd.put("value", "BLOB");
        stringBuilder.append(" value BLOB");
        c4924a.columns[5] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(37971);
    }
}
