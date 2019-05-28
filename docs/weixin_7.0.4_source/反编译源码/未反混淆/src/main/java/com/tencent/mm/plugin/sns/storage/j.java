package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ej;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable.Columns;
import java.lang.reflect.Field;

public final class j extends ej {
    protected static a ccO;
    public int rfb;

    public final a Ag() {
        return ccO;
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(37841);
        try {
            super.d(cursor);
            this.rfb = (int) this.xDa;
            AppMethodBeat.o(37841);
        } catch (Exception e) {
            String message = e.getMessage();
            ab.e("MicroMsg.SnsComment", "error ".concat(String.valueOf(message)));
            if (message != null && message.contains("Unable to convert")) {
                af.cnK().cqH();
            }
            AppMethodBeat.o(37841);
            throw e;
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.SnsComment", e2, "", new Object[0]);
            AppMethodBeat.o(37841);
        }
    }

    public final void cqD() {
        this.field_commentflag |= 1;
    }

    static {
        AppMethodBeat.i(37842);
        a aVar = new a();
        aVar.xDb = new Field[13];
        aVar.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "snsID";
        aVar.xDd.put("snsID", "LONG");
        stringBuilder.append(" snsID LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "parentID";
        aVar.xDd.put("parentID", "LONG");
        stringBuilder.append(" parentID LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "isRead";
        aVar.xDd.put("isRead", "SHORT default '0' ");
        stringBuilder.append(" isRead SHORT default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "createTime";
        aVar.xDd.put("createTime", "INTEGER");
        stringBuilder.append(" createTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "talker";
        aVar.xDd.put("talker", "TEXT");
        stringBuilder.append(" talker TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "type";
        aVar.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "isSend";
        aVar.xDd.put("isSend", "INTEGER default 'false' ");
        stringBuilder.append(" isSend INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "curActionBuf";
        aVar.xDd.put("curActionBuf", "BLOB");
        stringBuilder.append(" curActionBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[8] = "refActionBuf";
        aVar.xDd.put("refActionBuf", "BLOB");
        stringBuilder.append(" refActionBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[9] = "commentSvrID";
        aVar.xDd.put("commentSvrID", "LONG");
        stringBuilder.append(" commentSvrID LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = Columns.CLIENTID;
        aVar.xDd.put(Columns.CLIENTID, "TEXT");
        stringBuilder.append(" clientId TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "commentflag";
        aVar.xDd.put("commentflag", "INTEGER");
        stringBuilder.append(" commentflag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "isSilence";
        aVar.xDd.put("isSilence", "INTEGER default '0' ");
        stringBuilder.append(" isSilence INTEGER default '0' ");
        aVar.columns[13] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(37842);
    }
}
