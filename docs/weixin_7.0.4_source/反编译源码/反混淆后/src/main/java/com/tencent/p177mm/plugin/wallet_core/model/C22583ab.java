package com.tencent.p177mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C6580ff;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.ab */
public final class C22583ab extends C6580ff {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        AppMethodBeat.m2504i(46912);
        super.mo8995d(cursor);
        AppMethodBeat.m2505o(46912);
    }

    static {
        AppMethodBeat.m2504i(46913);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[6];
        c4924a.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "mNativeUrl";
        c4924a.xDd.put("mNativeUrl", "TEXT PRIMARY KEY ");
        stringBuilder.append(" mNativeUrl TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "mNativeUrl";
        c4924a.columns[1] = "hbType";
        c4924a.xDd.put("hbType", "INTEGER");
        stringBuilder.append(" hbType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "receiveAmount";
        c4924a.xDd.put("receiveAmount", "LONG");
        stringBuilder.append(" receiveAmount LONG");
        stringBuilder.append(", ");
        c4924a.columns[3] = "receiveTime";
        c4924a.xDd.put("receiveTime", "LONG");
        stringBuilder.append(" receiveTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[4] = "receiveStatus";
        c4924a.xDd.put("receiveStatus", "INTEGER");
        stringBuilder.append(" receiveStatus INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[5] = "hbStatus";
        c4924a.xDd.put("hbStatus", "INTEGER");
        stringBuilder.append(" hbStatus INTEGER");
        c4924a.columns[6] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(46913);
    }
}
