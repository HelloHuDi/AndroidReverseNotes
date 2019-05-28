package com.tencent.p177mm.plugin.ipcall.p438a.p983g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C37843cn;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.ipcall.a.g.k */
public final class C28332k extends C37843cn {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(21942);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[6];
        c4924a.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "phonenumber";
        c4924a.xDd.put("phonenumber", "TEXT");
        stringBuilder.append(" phonenumber TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "calltime";
        c4924a.xDd.put("calltime", "LONG");
        stringBuilder.append(" calltime LONG");
        stringBuilder.append(", ");
        c4924a.columns[2] = FFmpegMetadataRetriever.METADATA_KEY_DURATION;
        c4924a.xDd.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, "LONG");
        stringBuilder.append(" duration LONG");
        stringBuilder.append(", ");
        c4924a.columns[3] = "status";
        c4924a.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "addressId";
        c4924a.xDd.put("addressId", "LONG default '-1' ");
        stringBuilder.append(" addressId LONG default '-1' ");
        stringBuilder.append(", ");
        c4924a.columns[5] = "phoneType";
        c4924a.xDd.put("phoneType", "INTEGER default '-1' ");
        stringBuilder.append(" phoneType INTEGER default '-1' ");
        c4924a.columns[6] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(21942);
    }
}
