package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ad;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends ad {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(11249);
        a aVar = new a();
        aVar.xDb = new Field[13];
        aVar.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "userName";
        aVar.xDd.put("userName", "TEXT PRIMARY KEY ");
        stringBuilder.append(" userName TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "userName";
        aVar.columns[1] = "qyUin";
        aVar.xDd.put("qyUin", "INTEGER");
        stringBuilder.append(" qyUin INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "userUin";
        aVar.xDd.put("userUin", "INTEGER");
        stringBuilder.append(" userUin INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "userFlag";
        aVar.xDd.put("userFlag", "INTEGER");
        stringBuilder.append(" userFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "wwExposeTimes";
        aVar.xDd.put("wwExposeTimes", "INTEGER");
        stringBuilder.append(" wwExposeTimes INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "wwMaxExposeTimes";
        aVar.xDd.put("wwMaxExposeTimes", "INTEGER");
        stringBuilder.append(" wwMaxExposeTimes INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "wwCorpId";
        aVar.xDd.put("wwCorpId", "LONG");
        stringBuilder.append(" wwCorpId LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "wwUserVid";
        aVar.xDd.put("wwUserVid", "LONG");
        stringBuilder.append(" wwUserVid LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "userType";
        aVar.xDd.put("userType", "INTEGER");
        stringBuilder.append(" userType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "chatOpen";
        aVar.xDd.put("chatOpen", "INTEGER");
        stringBuilder.append(" chatOpen INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "wwUnreadCnt";
        aVar.xDd.put("wwUnreadCnt", "INTEGER default '0' ");
        stringBuilder.append(" wwUnreadCnt INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "show_confirm";
        aVar.xDd.put("show_confirm", "INTEGER");
        stringBuilder.append(" show_confirm INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "use_preset_banner_tips";
        aVar.xDd.put("use_preset_banner_tips", "INTEGER");
        stringBuilder.append(" use_preset_banner_tips INTEGER");
        aVar.columns[13] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(11249);
    }
}
