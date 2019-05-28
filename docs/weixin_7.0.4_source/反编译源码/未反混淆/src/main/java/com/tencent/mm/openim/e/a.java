package com.tencent.mm.openim.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.de;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.lang.reflect.Field;

public final class a extends de {
    protected static com.tencent.mm.sdk.e.c.a ccO;

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(78981);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "acctTypeId";
        aVar.xDd.put("acctTypeId", "TEXT");
        stringBuilder.append(" acctTypeId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE;
        aVar.xDd.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, "TEXT");
        stringBuilder.append(" language TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "accTypeRec";
        aVar.xDd.put("accTypeRec", "BLOB");
        stringBuilder.append(" accTypeRec BLOB");
        stringBuilder.append(", ");
        aVar.columns[3] = "updateTime";
        aVar.xDd.put("updateTime", "LONG default '0' ");
        stringBuilder.append(" updateTime LONG default '0' ");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(78981);
    }
}
