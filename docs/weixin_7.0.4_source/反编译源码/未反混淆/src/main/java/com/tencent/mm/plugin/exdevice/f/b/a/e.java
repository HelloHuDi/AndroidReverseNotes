package com.tencent.mm.plugin.exdevice.f.b.a;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cf;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class e extends cf {
    public static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(19489);
        a aVar = new a();
        aVar.xDb = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "rankID";
        aVar.xDd.put("rankID", "TEXT");
        stringBuilder.append(" rankID TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "appusername";
        aVar.xDd.put("appusername", "TEXT");
        stringBuilder.append(" appusername TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "username";
        aVar.xDd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = Param.TIMESTAMP;
        aVar.xDd.put(Param.TIMESTAMP, "INTEGER default '0' ");
        stringBuilder.append(" timestamp INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "liketips";
        aVar.xDd.put("liketips", "TEXT default '' ");
        stringBuilder.append(" liketips TEXT default '' ");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(19489);
    }
}
