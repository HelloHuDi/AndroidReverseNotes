package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends ch {
    public static a ccO;

    public final a Ag() {
        return ccO;
    }

    public final String toString() {
        AppMethodBeat.i(19485);
        String str = ("{" + "username: " + this.field_username + " step: " + this.field_step + " rankId: " + this.field_rankID + " appname: " + this.field_appusername) + "}";
        AppMethodBeat.o(19485);
        return str;
    }

    static {
        AppMethodBeat.i(19486);
        a aVar = new a();
        aVar.xDb = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appusername";
        aVar.xDd.put("appusername", "TEXT");
        stringBuilder.append(" appusername TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "rankID";
        aVar.xDd.put("rankID", "TEXT");
        stringBuilder.append(" rankID TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "username";
        aVar.xDd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "step";
        aVar.xDd.put("step", "INTEGER");
        stringBuilder.append(" step INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "sort";
        aVar.xDd.put("sort", "INTEGER default '0' ");
        stringBuilder.append(" sort INTEGER default '0' ");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(19486);
    }
}
