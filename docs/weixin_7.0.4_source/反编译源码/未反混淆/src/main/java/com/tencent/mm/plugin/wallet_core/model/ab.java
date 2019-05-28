package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ff;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class ab extends ff {
    public static a ccO;

    public final a Ag() {
        return ccO;
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(46912);
        super.d(cursor);
        AppMethodBeat.o(46912);
    }

    static {
        AppMethodBeat.i(46913);
        a aVar = new a();
        aVar.xDb = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "mNativeUrl";
        aVar.xDd.put("mNativeUrl", "TEXT PRIMARY KEY ");
        stringBuilder.append(" mNativeUrl TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "mNativeUrl";
        aVar.columns[1] = "hbType";
        aVar.xDd.put("hbType", "INTEGER");
        stringBuilder.append(" hbType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "receiveAmount";
        aVar.xDd.put("receiveAmount", "LONG");
        stringBuilder.append(" receiveAmount LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "receiveTime";
        aVar.xDd.put("receiveTime", "LONG");
        stringBuilder.append(" receiveTime LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "receiveStatus";
        aVar.xDd.put("receiveStatus", "INTEGER");
        stringBuilder.append(" receiveStatus INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "hbStatus";
        aVar.xDd.put("hbStatus", "INTEGER");
        stringBuilder.append(" hbStatus INTEGER");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(46913);
    }
}
