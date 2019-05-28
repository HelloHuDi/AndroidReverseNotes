package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ac;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;

public final class j extends ac {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    public final boolean lc(int i) {
        return (this.field_bitFlag & i) != 0;
    }

    public final boolean afh() {
        AppMethodBeat.i(105496);
        if (this.field_needToUpdate) {
            AppMethodBeat.o(105496);
            return true;
        } else if (bo.isNullOrNil(this.field_profileUrl) && bo.isNullOrNil(this.field_headImageUrl)) {
            AppMethodBeat.o(105496);
            return true;
        } else if (!bo.isNullOrNil(this.field_userNamePY) || bo.isNullOrNil(this.field_userName)) {
            AppMethodBeat.o(105496);
            return false;
        } else {
            AppMethodBeat.o(105496);
            return true;
        }
    }

    static {
        AppMethodBeat.i(105497);
        a aVar = new a();
        aVar.xDb = new Field[10];
        aVar.columns = new String[11];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "userId";
        aVar.xDd.put("userId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" userId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "userId";
        aVar.columns[1] = "userName";
        aVar.xDd.put("userName", "TEXT default '' ");
        stringBuilder.append(" userName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "userNamePY";
        aVar.xDd.put("userNamePY", "TEXT default '' ");
        stringBuilder.append(" userNamePY TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "brandUserName";
        aVar.xDd.put("brandUserName", "TEXT default '' ");
        stringBuilder.append(" brandUserName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "UserVersion";
        aVar.xDd.put("UserVersion", "INTEGER default '-1' ");
        stringBuilder.append(" UserVersion INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "needToUpdate";
        aVar.xDd.put("needToUpdate", "INTEGER default 'true' ");
        stringBuilder.append(" needToUpdate INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "headImageUrl";
        aVar.xDd.put("headImageUrl", "TEXT");
        stringBuilder.append(" headImageUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "profileUrl";
        aVar.xDd.put("profileUrl", "TEXT");
        stringBuilder.append(" profileUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "bitFlag";
        aVar.xDd.put("bitFlag", "INTEGER default '0' ");
        stringBuilder.append(" bitFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "addMemberUrl";
        aVar.xDd.put("addMemberUrl", "TEXT");
        stringBuilder.append(" addMemberUrl TEXT");
        aVar.columns[10] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(105497);
    }
}
