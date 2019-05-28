package com.tencent.p177mm.openim.p877e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C18468df;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.openim.e.c */
public final class C42246c extends C18468df {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(78985);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[5];
        c4924a.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "appid";
        c4924a.xDd.put("appid", "TEXT");
        stringBuilder.append(" appid TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE;
        c4924a.xDd.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, "TEXT");
        stringBuilder.append(" language TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "appRec";
        c4924a.xDd.put("appRec", "BLOB");
        stringBuilder.append(" appRec BLOB");
        stringBuilder.append(", ");
        c4924a.columns[3] = "updateTime";
        c4924a.xDd.put("updateTime", "LONG default '0' ");
        stringBuilder.append(" updateTime LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[4] = "acctTypeId";
        c4924a.xDd.put("acctTypeId", "TEXT");
        stringBuilder.append(" acctTypeId TEXT");
        c4924a.columns[5] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(78985);
    }
}
