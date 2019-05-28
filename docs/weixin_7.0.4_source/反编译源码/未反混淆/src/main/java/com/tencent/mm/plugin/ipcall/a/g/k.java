package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cn;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class k extends cn {
    public static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(21942);
        a aVar = new a();
        aVar.xDb = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "phonenumber";
        aVar.xDd.put("phonenumber", "TEXT");
        stringBuilder.append(" phonenumber TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "calltime";
        aVar.xDd.put("calltime", "LONG");
        stringBuilder.append(" calltime LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = FFmpegMetadataRetriever.METADATA_KEY_DURATION;
        aVar.xDd.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, "LONG");
        stringBuilder.append(" duration LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "status";
        aVar.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "addressId";
        aVar.xDd.put("addressId", "LONG default '-1' ");
        stringBuilder.append(" addressId LONG default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "phoneType";
        aVar.xDd.put("phoneType", "INTEGER default '-1' ");
        stringBuilder.append(" phoneType INTEGER default '-1' ");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(21942);
    }
}
