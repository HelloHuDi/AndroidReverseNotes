package com.tencent.mm.openim.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.df;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends df {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(78985);
        a aVar = new a();
        aVar.xDb = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appid";
        aVar.xDd.put("appid", "TEXT");
        stringBuilder.append(" appid TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE;
        aVar.xDd.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, "TEXT");
        stringBuilder.append(" language TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "appRec";
        aVar.xDd.put("appRec", "BLOB");
        stringBuilder.append(" appRec BLOB");
        stringBuilder.append(", ");
        aVar.columns[3] = "updateTime";
        aVar.xDd.put("updateTime", "LONG default '0' ");
        stringBuilder.append(" updateTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "acctTypeId";
        aVar.xDd.put("acctTypeId", "TEXT");
        stringBuilder.append(" acctTypeId TEXT");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(78985);
    }
}
