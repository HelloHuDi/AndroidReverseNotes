package com.tencent.mm.openim.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dg;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class e extends dg {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(78990);
        a aVar = new a();
        aVar.xDb = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appid";
        aVar.xDd.put("appid", "TEXT");
        stringBuilder.append(" appid TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "wordingId";
        aVar.xDd.put("wordingId", "TEXT");
        stringBuilder.append(" wordingId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE;
        aVar.xDd.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, "TEXT");
        stringBuilder.append(" language TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "wording";
        aVar.xDd.put("wording", "TEXT");
        stringBuilder.append(" wording TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "pinyin";
        aVar.xDd.put("pinyin", "TEXT");
        stringBuilder.append(" pinyin TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "quanpin";
        aVar.xDd.put("quanpin", "TEXT");
        stringBuilder.append(" quanpin TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "updateTime";
        aVar.xDd.put("updateTime", "LONG default '0' ");
        stringBuilder.append(" updateTime LONG default '0' ");
        aVar.columns[7] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(78990);
    }
}
