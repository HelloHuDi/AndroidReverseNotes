package com.tencent.mm.plugin.forcenotify.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bs;
import com.tencent.mm.model.cb;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.storage.ad;
import java.lang.reflect.Field;

public final class b extends bs {
    public static a ccO;
    public ad ehM = null;

    public final boolean bxX() {
        AppMethodBeat.i(51015);
        if (cb.aaD() >= this.field_ExpiredTime) {
            AppMethodBeat.o(51015);
            return true;
        }
        AppMethodBeat.o(51015);
        return false;
    }

    public final boolean isEnable() {
        return this.field_Status == 1;
    }

    public final String toString() {
        AppMethodBeat.i(51016);
        String str = this.field_ForcePushId + " " + this.field_UserName + " " + this.field_CreateTime + " " + this.field_ExpiredTime + " " + this.field_Status;
        AppMethodBeat.o(51016);
        return str;
    }

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(51017);
        a aVar = new a();
        aVar.xDb = new Field[8];
        aVar.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "ForcePushId";
        aVar.xDd.put("ForcePushId", "TEXT");
        stringBuilder.append(" ForcePushId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "CreateTime";
        aVar.xDd.put("CreateTime", "LONG");
        stringBuilder.append(" CreateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "ExpiredTime";
        aVar.xDd.put("ExpiredTime", "LONG");
        stringBuilder.append(" ExpiredTime LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "Description";
        aVar.xDd.put("Description", "TEXT");
        stringBuilder.append(" Description TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "UserIcon";
        aVar.xDd.put("UserIcon", "TEXT");
        stringBuilder.append(" UserIcon TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "UserName";
        aVar.xDd.put("UserName", "TEXT PRIMARY KEY ");
        stringBuilder.append(" UserName TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "UserName";
        aVar.columns[6] = "Extinfo";
        aVar.xDd.put("Extinfo", "TEXT");
        stringBuilder.append(" Extinfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "Status";
        aVar.xDd.put("Status", "INTEGER default '0' ");
        stringBuilder.append(" Status INTEGER default '0' ");
        aVar.columns[8] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(51017);
    }
}
