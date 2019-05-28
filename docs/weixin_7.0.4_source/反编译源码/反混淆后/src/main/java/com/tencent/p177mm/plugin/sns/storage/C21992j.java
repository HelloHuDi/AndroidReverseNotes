package com.tencent.p177mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C32693ej;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable.Columns;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.sns.storage.j */
public final class C21992j extends C32693ej {
    protected static C4924a ccO;
    public int rfb;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        AppMethodBeat.m2504i(37841);
        try {
            super.mo8995d(cursor);
            this.rfb = (int) this.xDa;
            AppMethodBeat.m2505o(37841);
        } catch (Exception e) {
            String message = e.getMessage();
            C4990ab.m7412e("MicroMsg.SnsComment", "error ".concat(String.valueOf(message)));
            if (message != null && message.contains("Unable to convert")) {
                C13373af.cnK().cqH();
            }
            AppMethodBeat.m2505o(37841);
            throw e;
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.SnsComment", e2, "", new Object[0]);
            AppMethodBeat.m2505o(37841);
        }
    }

    public final void cqD() {
        this.field_commentflag |= 1;
    }

    static {
        AppMethodBeat.m2504i(37842);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[13];
        c4924a.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "snsID";
        c4924a.xDd.put("snsID", "LONG");
        stringBuilder.append(" snsID LONG");
        stringBuilder.append(", ");
        c4924a.columns[1] = "parentID";
        c4924a.xDd.put("parentID", "LONG");
        stringBuilder.append(" parentID LONG");
        stringBuilder.append(", ");
        c4924a.columns[2] = "isRead";
        c4924a.xDd.put("isRead", "SHORT default '0' ");
        stringBuilder.append(" isRead SHORT default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[3] = "createTime";
        c4924a.xDd.put("createTime", "INTEGER");
        stringBuilder.append(" createTime INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "talker";
        c4924a.xDd.put("talker", "TEXT");
        stringBuilder.append(" talker TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "type";
        c4924a.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[6] = "isSend";
        c4924a.xDd.put("isSend", "INTEGER default 'false' ");
        stringBuilder.append(" isSend INTEGER default 'false' ");
        stringBuilder.append(", ");
        c4924a.columns[7] = "curActionBuf";
        c4924a.xDd.put("curActionBuf", "BLOB");
        stringBuilder.append(" curActionBuf BLOB");
        stringBuilder.append(", ");
        c4924a.columns[8] = "refActionBuf";
        c4924a.xDd.put("refActionBuf", "BLOB");
        stringBuilder.append(" refActionBuf BLOB");
        stringBuilder.append(", ");
        c4924a.columns[9] = "commentSvrID";
        c4924a.xDd.put("commentSvrID", "LONG");
        stringBuilder.append(" commentSvrID LONG");
        stringBuilder.append(", ");
        c4924a.columns[10] = Columns.CLIENTID;
        c4924a.xDd.put(Columns.CLIENTID, "TEXT");
        stringBuilder.append(" clientId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[11] = "commentflag";
        c4924a.xDd.put("commentflag", "INTEGER");
        stringBuilder.append(" commentflag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[12] = "isSilence";
        c4924a.xDd.put("isSilence", "INTEGER default '0' ");
        stringBuilder.append(" isSilence INTEGER default '0' ");
        c4924a.columns[13] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(37842);
    }
}
