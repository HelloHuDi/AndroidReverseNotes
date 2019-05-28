package com.tencent.p177mm.plugin.ipcall.p438a.p983g;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C9525cl;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.ipcall.a.g.g */
public final class C46038g extends C9525cl {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(21933);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[7];
        c4924a.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "svrId";
        c4924a.xDd.put("svrId", "LONG PRIMARY KEY ");
        stringBuilder.append(" svrId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "svrId";
        c4924a.columns[1] = "isRead";
        c4924a.xDd.put("isRead", "SHORT default '0' ");
        stringBuilder.append(" isRead SHORT default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[2] = "title";
        c4924a.xDd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = C8741b.CONTENT;
        c4924a.xDd.put(C8741b.CONTENT, "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "pushTime";
        c4924a.xDd.put("pushTime", "LONG");
        stringBuilder.append(" pushTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[5] = "msgType";
        c4924a.xDd.put("msgType", "INTEGER");
        stringBuilder.append(" msgType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[6] = "descUrl";
        c4924a.xDd.put("descUrl", "TEXT");
        stringBuilder.append(" descUrl TEXT");
        c4924a.columns[7] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(21933);
    }
}
