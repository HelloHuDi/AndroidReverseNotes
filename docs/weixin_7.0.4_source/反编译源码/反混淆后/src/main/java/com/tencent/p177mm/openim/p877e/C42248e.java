package com.tencent.p177mm.openim.p877e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C18469dg;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.openim.e.e */
public final class C42248e extends C18469dg {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(78990);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[7];
        c4924a.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "appid";
        c4924a.xDd.put("appid", "TEXT");
        stringBuilder.append(" appid TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "wordingId";
        c4924a.xDd.put("wordingId", "TEXT");
        stringBuilder.append(" wordingId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE;
        c4924a.xDd.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, "TEXT");
        stringBuilder.append(" language TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "wording";
        c4924a.xDd.put("wording", "TEXT");
        stringBuilder.append(" wording TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "pinyin";
        c4924a.xDd.put("pinyin", "TEXT");
        stringBuilder.append(" pinyin TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "quanpin";
        c4924a.xDd.put("quanpin", "TEXT");
        stringBuilder.append(" quanpin TEXT");
        stringBuilder.append(", ");
        c4924a.columns[6] = "updateTime";
        c4924a.xDd.put("updateTime", "LONG default '0' ");
        stringBuilder.append(" updateTime LONG default '0' ");
        c4924a.columns[7] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(78990);
    }
}
