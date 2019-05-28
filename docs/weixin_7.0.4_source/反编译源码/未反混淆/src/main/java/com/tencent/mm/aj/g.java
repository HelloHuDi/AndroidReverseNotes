package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.af;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class g extends af {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    public g(String str, String str2, String str3, String str4, int i, long j) {
        this.field_openId = str;
        this.field_brandUsername = str2;
        this.field_headImgUrl = str3;
        this.field_nickname = str4;
        this.field_kfType = i;
        this.field_updateTime = j;
    }

    static {
        AppMethodBeat.i(11384);
        a aVar = new a();
        aVar.xDb = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "openId";
        aVar.xDd.put("openId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" openId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "openId";
        aVar.columns[1] = "brandUsername";
        aVar.xDd.put("brandUsername", "TEXT default '' ");
        stringBuilder.append(" brandUsername TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "headImgUrl";
        aVar.xDd.put("headImgUrl", "TEXT");
        stringBuilder.append(" headImgUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "nickname";
        aVar.xDd.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "kfType";
        aVar.xDd.put("kfType", "INTEGER");
        stringBuilder.append(" kfType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "updateTime";
        aVar.xDd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(11384);
    }
}
