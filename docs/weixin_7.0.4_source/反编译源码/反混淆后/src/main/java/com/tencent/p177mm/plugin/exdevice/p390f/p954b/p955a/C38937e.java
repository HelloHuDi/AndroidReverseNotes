package com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C45390cf;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.exdevice.f.b.a.e */
public final class C38937e extends C45390cf {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(19489);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[5];
        c4924a.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "rankID";
        c4924a.xDd.put("rankID", "TEXT");
        stringBuilder.append(" rankID TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "appusername";
        c4924a.xDd.put("appusername", "TEXT");
        stringBuilder.append(" appusername TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "username";
        c4924a.xDd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = Param.TIMESTAMP;
        c4924a.xDd.put(Param.TIMESTAMP, "INTEGER default '0' ");
        stringBuilder.append(" timestamp INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[4] = "liketips";
        c4924a.xDd.put("liketips", "TEXT default '' ");
        stringBuilder.append(" liketips TEXT default '' ");
        c4924a.columns[5] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(19489);
    }
}
